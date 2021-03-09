import mysql.connector

class DB:
    tables = {"trend":{"business", "score"},
              "trend_news":{"n_id":"", "business":"", "news":""},
              "startup":{"s_id":"", "s_name":"", "business":"", "logo":"", "birth":"", "phone":""},
              "startup_detail":{"s_id":"", "ceo":"", "homepage":"", "address":"",  "technology":"", "product":"", "service":""},
              "startup_year":{"s_id":"", "s_year":"", "people":0, "investment":0, "capital":0, "sales":0},
              "user":{"u_id":"", "u_password":"", "u_name":"", "phone":"", "address":"", "e_mail":"", "birth":"", "s_id":""},
              "presentation":{"p_id":"", "p_title":"", "s_id":"", "times":0, "p_date":""}}

    def __init__(self, host, user, port, passwd, database):
        self.dbConn = mysql.connector.connect(host=host, port=port, user=user, passwd=passwd, database=database)
        self.dbCurs = self.dbConn.cursor()
        # db와 연결되는 변수

    def select(self, sel, fr, wh):
        sql = "SELECT %s FROM %s;" % (sel, fr)
        if wh is not None :
            sql += " WHERE " + wh
        print(sql)
        self.dbCurs.execute(sql)

        return self.dbCurs.fetchall()

    def insert(self, tbl, key, values, many=0):
        col = ','.join(key)         # 키값으로 칼럼생성
        holder = ','.join(['%s'] * len(key))

        sql = "INSERT INTO %s (%s) VALUES (%s);" % (tbl, col, holder)
        print(sql, " : ", values)

        if many == 0 :
            try :
                self.dbCurs.execute(sql, values)
            except Exception as e :
                print(e)
        else :
            try :
                self.dbCurs.executemany(sql, values)
            except Exception as e :
                print(e)

                for v in values :
                    try :
                        self.dbCurs.execute(sql, v)
                    except Exception as e:
                        print(e)


        self.dbConn.commit()

    def update(self, tbl, key, values, idKey, idValue, many = 0):
        qry = ""
        for k in key :
            qry += "%s = %s, "
        qry = qry.substr(0, len(qry) - 2)

        sql = "UPDATE %s SET %s WHERE %s = %s;" % (tbl, qry, "%s", "%s")

        datas = []
        for i in range(len(key)) :
            datas.append(key[i])
            datas.append(values[i])
        datas.append(idKey)
        datas.append(idValue)

        print(sql)
        print(datas)
        exit(0)
        try :
            self.dbCurs.execute(sql, datas)
        except Exception as e :
            print(e)
