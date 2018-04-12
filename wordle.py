#-*-coding:utf-8-*-
'''
这个工程是阅读NLTK练手用的项目
这个文件是一个纯文本分析的例子
'''
import urllib2
response = urllib2.urlopen('http://python.org/')
html = response.read()
'''
print len(html)
tokens = [token for token in  html.split()]
print 'Total no of tokens '+str(len(tokens))
print tokens[0:100]
import re
tokens = re.split('\W+',html)
print len(tokens)
print tokens[0:100]
'''
import nltk
#clean = nltk.clean_html(html)
from bs4 import BeautifulSoup
soup = BeautifulSoup(html,"lxml")
clean = soup.get_text()
tokens = [token for token in clean.split()]
print tokens[0:100]
'''
import operator
freq_dict = {}
for tok in tokens:
    if tok in freq_dict.keys():
        freq_dict[tok]+=1
    else:
        freq_dict[tok] =1

sort_freq = sorted(freq_dict.items(),key=operator.itemgetter(1),reverse=True)
print sort_freq[:10]
'''

freq_dict = nltk.FreqDist(tokens)
print freq_dict

for k,v in freq_dict.items():
    print str(k)+":"+str(v)