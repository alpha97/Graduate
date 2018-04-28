#coding:utf-8
'''
生成聚类之后的文本
'''
import numpy as np
K = 3
with open('tmp/model_theta.dat') as f:
    doc = f.readlines()
    dc = len(doc)
theta = np.array([[0.0 for y in range(K)]for x in range(dc)])

with open('tmp/model_theta.dat') as fi:
    doc = fi.readlines()
    for index in range(dc):
        tmp = doc[index].split()
        for i in range(len(tmp)):
            theta[index][i] = float(tmp[i])
idDict ={}
for index in range(dc):
    tem = theta[index].tolist()
    idDict[index] = tem.index(max(tem))

docDict = {}
for index in range(K):
    docDict[index] = []
    for i,t in idDict.items():
        if t == index:
            docDict[index].append(i)

cleanDict = {}#原始文件分类词典
with open('cleaned/RingDroid_clean.txt','r')as f:
    doc = f.readlines()
    for index in range(len(doc)):
        cleanDict[index] = doc[index]
for index in range(K):
    print index
    tem = open('classed/'+str(index)+'RingDroid_clean.txt','w')
    for i in docDict[index]:
        tem.write(str(cleanDict[i]))
    tem.close()
resultDict = {} #结果文件分类词典
with open('cleaned/RingDroid_result.txt','r')as f:
    doc = f.readlines()
    for index in range(len(doc)):
        resultDict[index] = doc[index]

for index in range(K):
    print index
    tem = open('classed/' + str(index) + 'RingDroid_result.txt', 'w')
    for i in docDict[index]:
        tem.write(str(resultDict[i]))
    tem.close()
