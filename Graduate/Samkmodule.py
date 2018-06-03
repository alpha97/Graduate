#coding:utf-8
import numpy as np


def _cal(vector):
    su = 0.0
    m = np.mean(vector)
    for i in range(len(vector)):
        su += np.power((vector[i] - m), 2)
    return np.sqrt(su)

def samk(path,data_X,k):
    idDict = {}
    with open(path) as f:
        doc = f.readlines()
        dc = len(doc)
        index = 0
        for line in doc:
            indexs = line.strip().split()
            idDict[index] = indexs
            index += 1
    # for k,v in idDict.items():
    #     print k,v
    #     print
    centroids = np.empty((k, k))

    for index,indexs in idDict.items():
        maxns = -1.0
        maxindex = 0
        for item in indexs:
            item = int(item)
            ns = _cal(data_X[item,:])
            if ns>maxns:
                maxns = ns
                maxindex = item
        #print maxindex
        centroids[index,:] = data_X[maxindex,:]
    return centroids


# K = 6
# with open('tmp/model_theta.dat') as f:
#     doc = f.readlines()
#     dc = len(doc)
# theta = np.array([[0.0 for y in range(K)]for x in range(dc)])
#
# with open('tmp/model_theta.dat') as fi:
#     doc = fi.readlines()
#     for index in range(dc):
#         tmp = doc[index].split()
#         for i in range(len(tmp)):
#             theta[index][i] = float(tmp[i])
# samk("model_theta_classify/theta_class.txt",theta,6)


# with open('tmp/model_theta.dat') as f:
#     doc = f.readlines()
#     dc = len(doc)
# theta = np.array([[0.0 for y in range(K)]for x in range(dc)])
