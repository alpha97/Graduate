
import requests
proxie = {
    'http':'socks5h://127.0.0.1:1080',
    'https':'socks5h://127.0.0.1:1080'
}
cs_url = "https://play.google.com/store/apps/details?id=com.ringdroid&showAllReviews=true&hl=en"
cs_git = 'https://github.com/github'
cs_blog = "http://fengxuegt.com/"
cs_gooleplay = 'https://play.google.com/store/apps/details'
param = {'id':'com.ringdroid','showAllReviews':'true','hl':'en'}
r = requests.get(cs_gooleplay,params=param,proxies = proxie,verify =False)
#r = requests.get(cs_gooleplay,proxies = proxie)
#r = requests.post(cs_url,proxies = proxie)
print r.url
print r.text

from bs4 import BeautifulSoup
soup = BeautifulSoup(
    r.text,
    'html.parser',
    from_encoding='utf-8'
)

tags = {
   # 'class':'review-text'
    'class':'review-body with-review-wrapper'
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












