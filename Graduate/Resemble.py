#coding:utf-8
#这是程序的最后一步，计算评论和源代码的相似度
import os
from collections import OrderedDict

riviewpath = "classed\\2RingDroid_result.txt"
reviewwords = []
with open(riviewpath,'r') as review:
    for line in review.readlines():
        for word in line.split():
            reviewwords.append(word)

codepath = "Java-txt\\"
lastDict ={}
def traverse(path):
    dirlist = os.listdir(path)
    for item in dirlist:
        fp = os.path.join(path,item)
        codewords = []
        with open(fp, 'r') as f:
            for line in f.readlines():
                for word in line.split():
                    codewords.append(word)
        rate = calrate(codewords, reviewwords)
        lastDict[item] = rate

def calrate(codewords,reviewwords):
    set1 = set(codewords)
    set2 = set(reviewwords)
    return float(len(set1 & set2))/float(min(len(set1),len(set2)))

traverse(codepath)
orderdict = sorted(zip(lastDict.values(),lastDict.keys()),reverse=True)
last = OrderedDict()
for item in orderdict:
    last[item[1]] =item[0]

for k,v in last.items():
    print k+"\t"+str(v)



