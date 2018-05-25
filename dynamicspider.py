#coding:utf-8
from time import sleep
from selenium import webdriver
from bs4 import BeautifulSoup

browser = webdriver.Chrome(r"C:/Users/fengyouyi/Downloads/chromedriver_win32/chromedriver.exe")
browser.get('https://play.google.com/store/apps/details?id=com.achep.acdisplay&hl%20=%20en&showAllReviews=true&hl=en')



sleep(2)
def execute_times(times):
    for i in range(times+1):
        browser.execute_script("window.scrollTo(0, document.body.scrollHeight);")
        sleep(2)

execute_times(4)
showmore = browser.find_element_by_xpath("//*[@id='fcxH9b']/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div")
showmore.click()
sleep(3)

# html_text = browser.page_source
#
# browser.quit()
#
# soup =BeautifulSoup(
#     html_text,
#     'html.parser',
#     from_encoding='utf-8'
# )
# print html_text
#
# # f = open("pagesource.txt",'w')
# # f.write(str(html_text).encode('utf-8'))
# # f.close()
# tags = {
#     # 'jscontroller':'LVJ1x',
#     # 'class':'UD7Dzf'
#     'jsname':'bN97Pc'
#
# }
# reviews = soup.find_all('span',tags)
# reviewdict = []
# for link in reviews:
#     reviewdict.append(link.get_text().encode('utf-8').strip())
#
# save= open('ACDisplay.txt','w')
# for review in reviews:
#     save.write(review)
#     save.write("\n")
#
# save.close()