#coding:utf-8
from selenium import webdriver
browser = webdriver.PhantomJS()
browser.get('https://play.google.com/store/apps/details?id=com.ringdroid&showAllReviews=true&hl=en')
#browser.get('https://www.baidu.com/')
html_text = browser.page_source
items = browser.find_elements_by_css_selector("div.Z8UXhc.span.text")
print html_text
browser.quit()