#coding:utf-8
from time import sleep
from selenium import webdriver
#import pan
browser = webdriver.Chrome(r"C:/Users/fengyouyi/Downloads/chromedriver_win32/chromedriver.exe")
browser.get('https://play.google.com/store/apps/details?id=com.ringdroid&showAllReviews=true&hl=en')
#browser.execute_script("window.scrollTo(0, document.body.scrollHeight);")
sleep(10)
html_text = browser.page_source
browser.quit()
from bs4 import BeautifulSoup,Comment
soup =BeautifulSoup(
    html_text,
    'html.parser',
    from_encoding='utf-8'
)
print html_text
f = open("pagesource.txt",'w')
f.write(str(html_text).encode('utf-8'))
f.close()
tags = {
    'class':'review-body with-review-wrapper'
    #'jsname':'bN97Pc'
}
reviews = soup.find_all('div',tags)
for review in reviews:
    pass
    #print review.get_text()