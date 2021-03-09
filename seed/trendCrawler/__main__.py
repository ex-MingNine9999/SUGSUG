import PIL
import requests
from bs4 import BeautifulSoup
import matplotlib.pyplot as plt
from wordcloud import WordCloud, STOPWORDS
import numpy as np
from konlpy.tag import Kkma

trendURL = "https://www.venturesquare.net/trend"


def nlp(data):
    kkma = Kkma()
    text = ' '.join(data)

    words = kkma.nouns(text)

    i = 0
    while i < (len(words) - 2) :
        if words[i + 1] == words[i] + words[i + 2] :
            words.pop(i + 2)
            words.pop(i)
        elif len(words[i]) == 1 :
            words.pop(i)
        elif words[i] == "가지" :
            words.pop(i)

        i += 1

    return words


def crawling():
    data = []
    a = 1

    while (a > 0):
        ending = "/page/" + str(a)

        req = requests.get(trendURL + ending)
        soup = BeautifulSoup(req.content, "html.parser")

        articles = soup.findAll('article')
        if articles == []:
            break

        for article in articles:
            href = article.find('a')["href"]
            title = article.find('a', attrs={"class": "post-title"})

            title = title.text.replace('\r', '').replace('\n', '').replace('\t', '')
            title = title.replace('.', '').replace(',', '').replace("\xa0", ' ').replace("'", ' ').replace('"', ' ')
            title = title.split(' ')

            for word in title:
                if word == '':
                    continue
                data.append(word)
            # req2 = requests.get(href)
            # soup2 = BeautifulSoup(req.content, "html.parser")

        print("Page " + str(a) + ": 완료")
        a += 1

    return data


def makeWordCollection() :
    wordCollection = nlp(crawling())
    
    return wordCollection

def makeWordCloud(wordCollection):
    text = ' '.join(wordCollection)

    print("워드클라우드에 들어갈 텍스트 :")
    print(text)
    circleMask = np.array(PIL.Image.open("circle.png"))

    wc = WordCloud(max_font_size=200, font_path='HMKMMAG.TTF', background_color="white", colormap="Blues_r",
                   mask=circleMask)
    wc = wc.generate(text)

    arr = wc.to_array()

    fig = plt.figure(figsize=(10, 10))
    plt.imshow(arr, interpolation='bilinear')
    plt.axis('off')
    plt.show()

    fig.savefig("../frontend/public/img/TrendCloud.png")


def __main__():
    wordCollection = makeWordCollection()
    print(wordCollection)

    makeWordCloud(wordCollection)


if __name__ == "__main__":
    __main__()
