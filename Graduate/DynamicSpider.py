#coding:utf-8
import selenium
from time import sleep
from selenium import webdriver
from bs4 import BeautifulSoup

appName = "ACDisplay"
cs_ACDisplay = 'https://play.google.com/store/apps/details?id=com.achep.acdisplay&hl%20=%20en&showAllReviews=true&hl=en'
cs_CoolReader = 'https://play.google.com/store/apps/details?id=org.coolreader&showAllReviews=true&hl=en'
cs_FBReader = 'https://play.google.com/store/apps/details?id=org.geometerplus.zlibrary.ui.android&referrer=utm_source%3Dfbreader.org%26utm_medium%3Dbadge%26utm_content%3Dandroid-page-bottom%26utm_campaign%3Dbadge&showAllReviews=true&hl=en'
cs_Focal = 'https://play.google.com/store/apps/details?id=in.zendroid.hyperfocal&showAllReviews=true&hl=en'
cs_FrostWire = 'https://play.google.com/store/apps/details?id=com.frostwire.android&showAllReviews=true&hl=en'
cs_K = 'https://play.google.com/store/apps/details?id=com.fsck.k9&showAllReviews=true&hl=en'
cs_Shortyz = 'https://play.google.com/store/apps/details?id=com.totsp.crossword.shortyz&showAllReviews=true&hl=en'
cs_SMS = 'https://play.google.com/store/apps/details?id=com.zegoggles.smssync&showAllReviews=true&hl=en'
cs_Solitaire = 'https://play.google.com/store/apps/details?id=de.tobiasbielefeld.solitaire&showAllReviews=true&hl=en'
cs_WordPress = 'https://play.google.com/store/apps/details?id=org.wordpress.android&showAllReviews=true&hl=en'

browser = webdriver.Chrome(r"C:/Users/fengyouyi/Downloads/chromedriver_win32/chromedriver.exe")
#C:\Users\fengyouyi\Downloads\chromedriver_win32
browser.get(cs_ACDisplay)
sleep(2)
def execute_times(times):
    for i in range(times+1):
        browser.execute_script("window.scrollTo(0, document.body.scrollHeight);")
        sleep(3)

def changePage(times):
    for i in range(times+1):
        # try:
        #     showmore = browser.find_element_by_xpath(
        #         '//*[@id="fcxH9b"]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div')
        #     showmore.click()
        #     execute_times(4)
        # except selenium.common.exceptions.WebDriverException:
        #     print '没有页面了。'
        showmore = browser.find_element_by_xpath(
            '//*[@id="fcxH9b"]/div[4]/c-wiz/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div')
        showmore.click()
        execute_times(4)



execute_times(4)
changePage(10)
sleep(3)
html_text = browser.page_source

browser.quit()

soup =BeautifulSoup(
    html_text,
    'html.parser',
    from_encoding='utf-8'
)
#print html_text

# f = open("pagesource.txt",'w')
# f.write(str(html_text).encode('utf-8'))
# f.close()
tagsfull = {
    # 'jscontroller':'LVJ1x',
    # 'class':'UD7Dzf'
    #'jsname':'bN97Pc'
    'jsname': 'fbQN7e'


}

tags = {
    'jsname': 'bN97Pc'
}
linksfull = soup.find_all('span',tagsfull)
links = soup.find_all('span',tags)

reviewlistfull = []
for link in linksfull:
    reviewlistfull.append(link.get_text().encode('utf-8').strip())

reviewlist = []
for link in links:
    reviewlist.append(link.get_text().encode('utf-8').strip())


for i in range(len(reviewlistfull)):
    if reviewlistfull[i].strip() == "":
        reviewlistfull[i] = reviewlist[i]

# for sentence in reviewlistfull:
#     sentence = sentence.replace("\n"," ")
    #print sentence
# print len(reviewlistfull)
# print len(reviewlist)



save= open('origin/'+appName+'.txt','w')
con = 0
for review in reviewlistfull:
    review = review.replace("\n"," ")
    print str(con)+"\t"+review
    con = con + 1
    save.write(review)
    save.write("\n")

save.close()