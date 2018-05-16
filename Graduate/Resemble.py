#coding:utf-8
#这是程序的最后一步，计算评论和源代码的相似度
import os
from collections import OrderedDict
import CleanCache
appName = 'Wordpress'
riviewpath = "classed\\0" + appName + "_result.txt"
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

sortfile = open("Sorted\\"+appName+".txt",'w')
sortfile.write("共有"+str(len(last.keys()))+"个java文件，以下为java文件的相似度排序：\n")
for k,v in last.items():
    sortfile.write(k+"\t"+str(v))
    sortfile.write("\n")
sortfile.close()
CleanCache.deljava("Java-txt")
#CleanCache.deljava("classed")
#CleanCache.deljava("cleaned")




