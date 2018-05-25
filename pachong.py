#coding:utf-8
import requests
import sys
reload(sys)
sys.setdefaultencoding('utf8')
proxie = {
    'http':'socks5h://127.0.0.1:1080',
    'https':'socks5h://127.0.0.1:1080'
}





r = requests.get(cs_gooleplay, proxies=proxie)

from bs4 import BeautifulSoup
soup = BeautifulSoup(
    r.text,
    'html.parser',
    from_encoding='utf-8'
)

tags = {
    'class':'UD7Dzf',
    'jscontroller':'LVJlx'
}

links = soup.find_all('div',tags)
reviews = []
for link in links:
    #print link.get_text()
    reviews.append(link.get_text().encode('utf-8').strip())


save= open('ring.txt','w')
for review in reviews:
    save.write(review)
    save.write("\n")

save.close()












