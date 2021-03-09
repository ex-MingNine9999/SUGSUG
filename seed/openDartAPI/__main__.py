import xml.etree.ElementTree as elemTree
import requests
import json
import mariaDB
import pandas as pd

API_KEY = "3ef2c725046104be2b572d80c13dc0635371e12b"

def indutyParse(fileName, db) :
    csvFile = pd.read_csv(fileName)

    for col in csvFile.columns :
        if csvFile[col].dtype == 'float64' :
            csvFile[col] = csvFile[col].apply('int64')

    stdGroup = csvFile.set_index('표준산업분류')

    tName = "trend"
    key = ["business", "score"]

    classfication = stdGroup['세세분류'].unique()
    values = [[x, 0] for x in classfication]
    db.insert(tName, key, values, 1)

    classfication = stdGroup['세분류'].unique()
    values = [[x, 0] for x in classfication]
    db.insert(tName, key, values, 1)

    classfication = stdGroup['소분류'].unique()
    values = [[x, 0] for x in classfication]
    db.insert(tName, key, values, 1)

    classfication = stdGroup['중분류'].unique()
    values = [[x, 0]for x in classfication]
    db.insert(tName, key, values, 1)

    return stdGroup

def getInduty(indutyCode, stdGroup) :
    try :
        induty = stdGroup.loc[indutyCode]['세세분류']
    except :
        try :
            induty = stdGroup.set_index('중분류_C').loc[indutyCode]['중분류']
        except :
            try :
                induty = stdGroup.set_index('소분류_C').loc[indutyCode]['소분류']
            except :
                try :
                    induty = stdGroup.set_index('세분류_C').loc[indutyCode]['세분류']
                except :
                    induty = None

    if type(induty) != str :
        induty = str(induty.values[0])

    return induty

def parsingCorpCode(fileName) :
    tree = elemTree.parse(fileName)
    root = tree.getroot()

    corpList = root.findall("list")
    corpCode = []

    i = 0
    for x in corpList :
        corpCode.insert(i, x.findtext("corp_code"))
        i += 1

        if i == 12 :
            break;

    return corpCode

def strToHtml(string) :
    ret = ""

    for ch in string :
        if ch == '\n' :
            ret += "<br/>"
        else :
            ret += ch

    return ret

def corpDetail(corpCode, stdGroup, db) :
    URL = "https://opendart.fss.or.kr/api/company.json"
    params = {"crtfc_key" : API_KEY, "corp_code": ""}
    dir = "세부정보/"
    ending = "_detail.csv"

    stName = "startup"
    sKey = ("s_id", "s_name", "business", "logo", "birth", "phone", "grade", "hits")
    dtNmae = "startup_detail"
    dKey = ("s_id", "ceo", "homepage", "ir_page", "address", "technology", "product", "icon", "service", "introduction")


    i = 0
    for code in corpCode:
        params["corp_code"] = code
        query = requests.get(URL, params=params).text

        js = json.loads(query)

        if js["induty_code"] != "" :
            induty = getInduty(int(js["induty_code"]), stdGroup)
        else :
            induty = ""

        logo = "img/logo/" + js["corp_name"] + ".png"
        grade = "비상장"
        if js["stock_code"] != " " :
            grade = js["stock_code"]

        sValue = (code, js["corp_name"], induty, logo, js["est_dt"], js["phn_no"], grade, 0)
        db.insert(stName, sKey, sValue)


        fileName = dir + js["corp_name"] + ending
        dValue = [code, js["ceo_nm"], js["hm_url"], js["ir_url"], js["adres"]]
        try:
            df = pd.read_csv(fileName).set_index("topic")

            for idx in df.index:
                data = df.loc[idx]["content"]
                if idx == "introduction" :
                    data = strToHtml(data)

                dValue.append(data)

                if idx == "product" :
                    iconPath = "img/serviceIcons/" + df.loc[idx]["content"].replace(' ', '_') + ".png"
                    dValue.append(iconPath)


            db.insert(dtNmae, dKey, dValue)
        except Exception as e:
            print(e)


        i += 1
        if i == 12 :
            break;

def corpYearData(db) :
    dir = "재무제표/"
    ending = "_재무제표.csv"
    ytName = "startup_year"
    yKey = ("y_id", "s_id", "s_year", "total", "paid_capital", "capital", "sales", "profit", "cur_income", "investment", "people")

    tup = db.select("s_id, s_name", "startup", None)


    for corp in tup :
        fileName = dir + corp[1] + ending

        try :
            df = pd.read_csv(fileName).set_index("연도")

            for year in df.index :
                values = [corp[0] + str(year), corp[0], year]
                for i in range(8) :
                    if type(df.loc[year][i]) == str :
                        data = int(df.loc[year][i].replace(',', ''))
                        if i != 7 :
                            data /= 10
                    else :
                        data = df.loc[year][i]

                    values.append(int(data))

                db.insert(ytName, yKey, values)

        except Exception as e :
            print(e)



def __main__() :
    db = mariaDB.DB('db', 'root', '3306', 'seed0111', 'sugsug_db')

    stdGroup = indutyParse("induty_code_table.csv", db)
    corpCode = parsingCorpCode("CORPCODE.xml")

    corpDetail(corpCode, stdGroup, db)

    corpYearData(db)


if __name__ == '__main__':
    __main__()