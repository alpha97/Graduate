#coding:utf-8
import time
from selenium import webdriver
browser = webdriver.Chrome()
browser.get('https://play.google.com/store/apps/details?id=com.ringdroid&showAllReviews=true&hl=en')
#browser.get('https://play.google.com/_/PlayStoreUi/data?ds.extension=136880256&f.sid=7450855871867535619&hl=en&soc-app=121&soc-platform=1&soc-device=1&authuser=0&_reqid=551411&rt=c')
browser.execute_script("window.scrollTo(0, document.body.scrollHeight);")
time.sleep(10)
html_text = browser.page_source
browser.quit()
from bs4 import BeautifulSoup
soup =BeautifulSoup(
    html_text,
    'html.parser',
    from_encoding='utf-8'
)
print html_text
tags = {
    'class':'review-body with-review-wrapper'
    #'jsname':'bN97Pc'
}
reviews = soup.find_all('div',tags)
for review in reviews:
    print review.get_text()