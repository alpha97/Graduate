#coding:utf-8
#将评论变为小写
import os
import nltk
from nltk.corpus import stopwords
import re
from textblob import Word
#print os.getcwd()
lowfile = open("cleaned/ring_low.txt","w")
with open("origin/ring.txt")as origin:
    line = origin.read()
    lowfile.write(str(line).lower().strip())
lowfile.close()
#去除文本中的表情和标点符号
clean_file = open("cleaned/ring_clean.txt",'w')
with open("cleaned/ring_low.txt")as low:
    for line in low:
        string = re.sub('\W', " ", line)
        string = re.sub('[\s+\.\!\/_,$%^*(+\"\')]+|[+——()?【】“”！，。？、~@#￥%……&*（）]+', " ", string)
        pattern = re.compile(r"(\w*\s*)*")
        match = pattern.match(string)
        print match.group()
        clean_file.write(match.group().strip())
        clean_file.write("\n")
    clean_file.close()
#分词and纠错and标准化
origin_Dict = {}
with open("cleaned/ring_clean.txt")as clean:
    i = 0
    for line in clean:
        list = []
        for word in line.split():
            w = Word(word)
            list.append(w.correct().singularize())
        if len(list)<3:
            continue
        origin_Dict[i] = list
        i = i+1
    print i
#pos 词性标注，过滤出名词和动词
filter_Dict = {}
tag_Dict = {}
for index,words in origin_Dict.items():
    tag_Dict[index] = nltk.pos_tag(words)
for index,tags in tag_Dict.items():
    tem = []
    for tag in tags:
        #print tag
        if tag[1]!= 'NN' and tag[1] != 'VB':
            continue
        else:
            tem.append(tag[0])
    filter_Dict[index] = tem

#停用词移除
stop_Dict = {}
stoplist = stopwords.words("english")
for index,words in filter_Dict.items():
    cleanedlist = [word for word in words if word not in stoplist]
    stop_Dict[index] = cleanedlist
repeat_Dict = {}
index1 = 0
for words in stop_Dict.values():
    list = []
    for word in words:
        if word not in list and len(word)>2:
            list.append(word)
    if len(list)>2:
        repeat_Dict[index1] = list
        index1 += 1


resultfile = open('cleaned/ring_result.txt','w')
for k,v in repeat_Dict.items():
    resultfile.write(str(k))
    for word in v:
        resultfile.write(str(word)+" ")
    resultfile.write("\n")


