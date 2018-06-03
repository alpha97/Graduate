#coding:utf-8
'''
这是第一步处理，将评论处理好。
生成cleaned中的clean和result文件
'''
import os
import nltk
from nltk.corpus import stopwords
import re
from textblob import Word

#首先将文本生成一个原始字典
appName = "ACDisplay"
originDict = {}
originindex = 0
with open('origin/'+appName+'.txt','r')as origin:
    for line in origin:
        originDict[originindex] = line
        originindex += 1
#将文本转化为小写并去除表情和标点符号后的词典
cleanDict = {}
for index,line in originDict.items():
    string = re.sub('\W', " ", line.lower().strip())
    string = re.sub('[\s+\.\!\/_,$%^*(+\"\')]+|[+——()?【】“”！，。？、~@#￥%……&*（）]+', " ", string)
    pattern = re.compile(r"(\w*\s*)*")
    match = pattern.match(string)
    cleanDict[index] = match.group().strip()
wordsDict = {}
for index,line in cleanDict.items():
    if len(line.split())<3:
        del(cleanDict[index])
    else:
        temlist = []
        for word in line.split():
            # w = Word(word)
            # temlist.append(w.correct().singularize())
            temlist.append(word)
        wordsDict[index] = temlist

filterDict = {}
tagDict = {}
for index,words in wordsDict.items():
    tagDict[index] = nltk.pos_tag(words)
for index,tags in tagDict.items():
    temlist = []
    for tag in tags:
        if tag[1] == 'NN' or tag[1] == 'VB':
            temlist.append(tag[0])
        filterDict[index] = temlist

stopDict = {}
stoplist = stopwords.words("english")
for index,words in filterDict.items():
    cleanedlist = [word for word in words if word not in stoplist]
    stopDict[index] = cleanedlist

repeatDict = {}
for index,words in stopDict.items():
    temlist = []
    for word in words:
        if word not in temlist and len(word)>2:
            temlist.append(word)
    if len(temlist)>2:
        repeatDict[index] = temlist
resultDict = {}
for k in repeatDict.keys():
    resultDict[k] = originDict[k]

print len(resultDict.keys())

cleanfile = open('cleaned/'+appName+'_clean.txt','w')#解决id问题,去除无用评论的原始文件
for v in resultDict.values():
    cleanfile.write(v)
    #cleanfile.write("\n")
cleanfile.close()
resultfile = open('cleaned/'+appName+'_result.txt','w')#step2的输入
for k,v in repeatDict.items():
    for word in v:
        resultfile.write(str(word)+" ")
    resultfile.write("\n")
resultfile.close()