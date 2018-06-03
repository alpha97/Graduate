#coding:utf-8
#这是程序的最后一步，计算评论和源代码的相似度
import os
from collections import OrderedDict
import CleanCache
appName = 'ACDisplay'
reviewpath = "classed\\0" + appName + "_result.txt"
def loadreview(reviewpath):
    reviewwords = []
    with open(reviewpath,'r') as review:
        for line in review.readlines():
            for word in line.split():
                reviewwords.append(word)
    return reviewwords
codepath = "Java-txt\\"

def traverse(path,reviewpath):
    lastDict = {}
    words = loadreview(reviewpath)
    dirlist = os.listdir(path)
    for item in dirlist:
        fp = os.path.join(path,item)
        codewords = []
        with open(fp, 'r') as f:
            for line in f.readlines():
                for word in line.split():
                    codewords.append(word)
        rate = calrate(codewords, words)
        lastDict[item] = rate
    return lastDict

def calrate(codewords,reviewwords):
    set1 = set(codewords)
    set2 = set(reviewwords)
    return float(len(set1 & set2))/float(min(len(set1),len(set2)))
#t = traverse(codepath,reviewpath)

sortfile = open("Sorted\\"+appName+".txt",'w')
for i in range(6):
    sortfile.write("第"+str(i)+"类：\n")
    reviewpath = "classed\\"+str(i) + appName + "_result.txt"
    lastDict = traverse(codepath,reviewpath)
    orderdict = sorted(zip(lastDict.values(),lastDict.keys()),reverse=True)
    last = OrderedDict()
    c = 0
    for item in orderdict:
        last[item[1]] = item[0]
    for name,rate in last.items():
        if c<10:
            sortfile.write(name+"\t"+str(rate))
            sortfile.write("\n")
            c = c+1
        else:
            break

sortfile.close()
CleanCache.deljava("Java-txt")
#
#
# last = OrderedDict()
# for item in orderdict:
#     last[item[1]] =item[0]
#
# for k,v in last.items():
#     print k+"\t"+str(v)
#
# sortfile = open("Sorted\\"+appName+".txt",'w')
# sortfile.write("共有"+str(len(last.keys()))+"个java文件，以下为java文件的相似度排序：\n")
# for k,v in last.items():
#     sortfile.write(k+"\t"+str(v))
#     sortfile.write("\n")
# sortfile.close()
# CleanCache.deljava("Java-txt")
# #CleanCache.deljava("classed")
# #CleanCache.deljava("cleaned")
#
#


