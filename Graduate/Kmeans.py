#coding:utf-8
import numpy as np
import Samkmodule as sam
class Kmeans():
    def __init__(self,k = 6,initCent = 'lda',max_ter = 1000):
        self._k = k
        self._initCent = initCent
        self._max_iter = max_ter
        self._labels = None
        self._sse = None

    def _calEDist(self,vecA,vecB):
        '''
        距离计算
        :param vecA: 
        :param vecB: 
        :return: 
        '''
        return np.math.sqrt(sum(np.power(vecA-vecB,2)))

    def _calMDist(self,vecA,vecB):
        '''
        
        :param vecA: 
        :param vecB: 
        :return: 
        '''
        return sum(np.abs(vecA-vecB))

    def _randCent(self,data_X,k):
        '''
        
        :param data_X: 
        :param k: 
        :return: 
        '''
        n = data_X.shape[1]  # 获取特征的维数
        centroids = np.empty((k, n))  # 使用numpy生成一个k*n的矩阵，用于存储质心
        for j in range(n):
            minJ = min(data_X[:, j])
            rangeJ = float(max(data_X[:, j] - minJ))
            # 使用flatten拉平嵌套列表(nested list)
            centroids[:, j] = (minJ + rangeJ * np.random.rand(k, 1)).flatten()
        return centroids

    # def _cal(self,vector):
    #     su = 0.0
    #     m = np.mean(vector)
    #     for i in range(len(vector)):
    #         su += np.power((vector[i]-m),2)
    #     return np.sqrt(su)




    def _samK(self,data_X,k):
        # n = data_X.shape[1]
        # centroids = np.empty((k,n))
        # idDict = {}
        # for i in range(data_X.shape[0]):
        #     idDict[i] = self._cal(list(data_X[i,:]))
        # orderlist = sorted(zip(idDict.values(), idDict.keys()), reverse=True)
        # o = OrderedDict()
        # for item in orderlist:
        #     o[item[1]] = item[0]
        # co = 0
        # for i in o.keys():
        #     if co < k:
        #         centroids[co,:] = data_X[i,:]
        #         co = co +1
        #     else:
        #         break
       # print sam.samk("model_theta_classify/theta_class.txt", data_X, k)
        return sam.samk("model_theta_classify/theta_class.txt",data_X,k)


    def fit(self,data_X):
        '''
        :param data_X: 训练数据，
        在本文中为model_theta.dat文件中文档-主题分布
        :return: 返回值为分类结果
        '''
        m = data_X.shape[0]#获取样本数，即评论数
        # 一个m*2的矩阵，第一列储存样本所属簇的索引值，
        # 第二列储存该点与所属簇的质心的平方误差
        self._clusterAssment = np.zeros((m,2))
        #初始化质心的选择，传入参数为'random'则随机化初始质心，
        # 若是传入参数为'lda',则按照LDA聚类结果初始化质心
        if self._initCent == 'random':
            self._centroids = self._randCent(data_X,self._k)
        elif self._initCent == 'lda':
            self._centroids = self._samK(data_X,self._k)

        clusterChanged = True#标志变量
        qq = 0
        for q in range(self._max_iter):
            clusterChanged = False
            for i in range(m):#将每个样本点分配到离它最近的质心所属地簇
                minDist = np.inf#首先将minDist初始化为一个无穷大的数
                minIndex = -1#将最近的质心的索引值设为-1
                for j in range(self._k):#每次迭代用于寻找最近的质心
                    vecA = self._centroids[j,:]#第j个质心
                    vecB = data_X[i,:] #第i个样本值
                    distJI = self._calEDist(vecA,vecB)#计算样本与质心之间的距离
                    if distJI < minDist:#若是距离小于最小距离
                        minDist = distJI# 更新最小距离
                        minIndex = j #更新所属簇的索引
                #如果在此次迭代过程中样本所属簇的索引值更新了，
                # 更新_clusterAssment矩阵
                if self._clusterAssment[i,0] != minIndex or self._clusterAssment[i,1]>minDist**2:
                    clusterChanged = True #将标志设为True
                    #print minIndex
                    self._clusterAssment[i,:] = minIndex,minDist**2
            if not clusterChanged:#如果此次迭代没有发生更新
                break#结束迭代

            for i in range(self._k):#更新质心
                index_all = self._clusterAssment[:,0]#获得样本所属簇的索引值
                value = np.nonzero(index_all==i)#获得所有属于第i个簇的索引值
                ptsInClust = data_X[value[0]]#获得属于第i个簇的所有样本
                # 计算此簇中所有样本的均值作为新的质心
                self._centroids[i,:] = np.mean(ptsInClust,axis=0)
            qq = q
        self._labels = self._clusterAssment[:,0]#保存聚类结果
        self._sse = sum(self._clusterAssment[:,1])#sse值
        print qq
class biKmeans():
    '''
    this is a binary K-means classifier
    '''
    def __init__(self,k=6):
        self._k = k
        self._centroids = None
        self._clusterAssment = None
        self._labels = None
        self._sse = None

    def _calEDist(self,vecA,vecB):
        return np.math.sqrt(sum(np.power(vecA-vecB,2)))

    def fit(self,X):
        m = X.shape[0]
        self._clusterAssment = np.zeros((m,2))
        centroid0 = np.mean(X,axis=0).tolist()
        centList = [centroid0]
        for j in range(m):
            self._clusterAssment[j,1] = self._calEDist(np.asanyarray(centroid0),X[j,:])**2

        while(len(centList)<self._k):
            lowestSSE = np.inf
            for i in range(len(centList)):
                index_all = self._clusterAssment[:,0]
                value = np.nonzero(index_all==i)
                ptsInCurrCluster = X[value[0],:]
                clf = Kmeans(2)
                clf.fit(ptsInCurrCluster)
                centroidMat,splitClusteAss = clf._centroids,clf._clusterAssment
                sseSplit = sum(splitClusteAss[:,1])
                index_all = self._clusterAssment[:,0]
                value = np.nonzero(index_all==i)
                sseNotSplit = sum(self._clusterAssment[value[0],1])
                if(sseSplit + sseNotSplit)<lowestSSE:
                    bestCentToSplit = i
                    bestNewCents = centroidMat
                    bestClustAss = splitClusteAss.copy()
                    lowestSSE = sseSplit + sseNotSplit
            bestClustAss[np.nonzero(bestClustAss[:, 0] == 1)[0], 0] = len(centList)
            bestClustAss[np.nonzero(bestClustAss[:, 0] == 0)[0], 0] = bestCentToSplit
            centList[bestCentToSplit] = bestNewCents[0, :].tolist()
            centList.append(bestNewCents[1, :].tolist())
            self._clusterAssment[np.nonzero(self._clusterAssment[:, 0] ==  bestCentToSplit)[0], :] = bestClustAss

        self._labels = self._clusterAssment[:0]
        self._sse = sum(self._clusterAssment[:1])
        self._centroids = np.asarray(centList)


from collections import OrderedDict
data = np.random.rand(100, 3)
import numpy as np
K = 6
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
#print theta
kmeans = Kmeans(6,'lda',1000)
for i in range(8):
    kmeans.fit(theta)
    print kmeans._sse

#means = biKmeans()
# kmeans.fit(theta)
# print kmeans._sse
# ldaresult = [0, 4, 0, 2, 3, 1, 1, 2, 0, 0, 0, 2, 1, 1, 1, 5, 2, 1, 1, 1, 0, 2, 4, 1, 4, 1, 3, 1, 0, 2, 1, 2, 1, 1, 2, 4, 2, 1, 4, 1, 2, 1, 1, 1, 1, 3, 0, 5, 0, 4, 2, 0, 1, 3, 4, 2, 4, 4, 1, 2, 0, 3, 2, 0, 2, 1, 0, 2, 4, 4, 3, 1, 1, 1, 1, 0, 2, 0, 2, 3, 4, 1, 2, 0, 4, 1, 3, 2, 1, 1, 3, 1, 4, 0, 0, 2, 4, 3, 0, 0, 1, 4, 0, 3, 0, 0, 2, 4, 0, 0, 4, 3, 0, 1, 0, 4, 5, 0, 4, 1, 1, 5, 1, 1, 4, 4, 1, 2, 3, 0, 0, 1, 3, 1, 2, 0, 5, 5, 1, 3, 5, 0, 1, 5, 1, 3, 0, 1, 1, 5, 1, 0, 0, 3, 1, 2, 1, 4, 1, 4, 4, 4, 5, 4, 4, 4, 4, 2, 1, 1, 3, 5, 0, 0, 0, 1, 5, 5, 3, 1, 0, 3, 1, 4, 1, 5, 3, 0, 1, 4, 3, 0, 4, 1, 3, 4, 5, 1, 2, 5, 0, 5, 2, 1, 3, 4, 4, 0, 0, 3, 2, 1, 0, 1, 1, 1, 2, 4, 2, 2, 1, 0, 0, 3, 1, 4, 0, 4, 1, 0, 0, 3, 3, 4, 3, 5, 1, 0, 4, 0, 3, 0, 4, 3, 4, 0, 0, 0, 0, 1, 3, 0, 4, 0, 0, 1, 5, 0, 0, 0, 0, 1, 0, 3, 5, 1, 0, 5, 4, 4, 4, 1, 2, 1, 1, 0, 1, 3, 4, 1, 0, 5, 1, 2, 0, 3, 1, 4, 1, 1, 0, 0, 2, 4, 1, 1, 3, 4, 2, 0, 0, 1, 2, 1, 0, 5, 1, 1, 5, 1, 0, 2, 4, 2, 3, 5, 2, 1, 2, 0, 0, 2, 0, 1, 1, 2, 4, 3, 1, 0, 5, 3, 0, 3, 4, 2, 2, 1, 0, 1, 2, 4, 0, 4, 2, 0, 0, 0, 4, 5, 1, 1, 0, 2, 3, 2, 4, 1, 0, 4, 1, 4, 3, 4, 3, 0, 5, 0, 0, 1, 1, 0, 4, 1, 0, 5, 0, 2, 0, 1, 5, 2, 2, 0, 5, 1, 2, 3, 3, 1, 4, 0, 5, 1, 2, 4, 5, 1, 1, 4, 1, 4, 2, 2, 5, 5, 0, 4, 1, 2, 3, 0, 0, 0, 5, 0, 0, 0, 1, 0, 2, 4, 2, 2, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 4, 0, 3, 0, 1, 0, 2, 1, 1, 4, 1, 4, 0, 4, 1, 3, 1, 2, 1, 4, 1, 5, 3, 0, 0, 1, 1, 1, 0, 1, 0, 3, 1, 1, 0, 3, 2, 1, 1, 2, 0, 5, 3, 3, 0, 1, 4, 2, 4, 5, 1, 0, 1, 0, 5, 4, 2, 2, 3, 1, 1, 4, 0, 1, 3, 2, 1, 5, 1, 3, 2, 1, 0, 3, 0, 2, 3, 2, 5, 2, 0, 0, 1, 3, 4, 0, 4, 4, 3, 0, 4, 2, 0, 1, 0, 0, 3, 1, 2, 3, 2, 0, 3, 1, 0, 4, 1, 5, 1, 0, 3, 2, 5, 0, 2, 4, 0, 3, 0, 3, 0, 1, 5, 0, 0, 2, 0, 5, 2, 2, 0, 2, 0, 1, 5, 0, 0, 1, 0, 1, 0, 4, 1, 5, 1, 4, 0, 0, 0, 1, 2, 0, 4, 0, 1, 4, 4, 0, 0, 2, 0, 2, 0, 2, 4, 2, 1, 0, 2, 2, 0, 4, 0, 5, 0, 0, 1, 5, 2, 5, 2, 2, 3, 5, 5, 0, 3, 5, 0, 2, 3, 0, 5, 2, 0, 0, 5, 0, 1, 0, 5, 5, 1, 0, 2, 4, 3, 3, 2, 3, 2, 1, 0, 4, 2, 5, 2, 4, 3, 0, 3, 5, 1, 3, 0, 3, 3, 1, 3, 1, 3, 1, 0, 5, 1, 1, 1, 4, 0, 3, 1, 0, 1, 1, 0, 5, 2, 5, 1, 1, 3, 4, 1, 2, 4, 1, 0, 2, 5, 0, 0, 1, 5, 4, 1, 1, 3, 3, 4, 4, 4, 3, 5, 5, 0, 3, 0, 2, 0, 5, 2, 2, 1, 4, 1, 1, 0, 5, 5, 0, 3, 4, 2, 1, 0, 5, 1, 4, 3, 0, 0, 1, 4, 1, 1, 1, 0, 0, 0, 4, 0, 5, 2, 5, 5, 0, 5, 2, 0, 3, 1, 0, 3, 0, 5, 4, 0, 5, 1, 1, 1, 4, 5, 1, 0, 2, 1, 0, 1, 5, 2, 3, 5, 0, 0, 0, 2, 3, 0, 5, 2, 0, 0, 0, 1, 5, 5, 0, 3, 1, 1, 5, 0, 5, 2, 5, 2, 0, 1, 2, 1, 1, 0, 0, 1, 1, 1, 1, 2, 2, 5, 3, 0, 1, 1, 4, 4, 0, 4, 0, 3, 4, 1, 5, 5, 4, 1, 5, 0, 1, 0, 3, 1, 3, 0, 0, 0, 0, 4, 5, 1, 4, 4, 5, 3, 5, 2, 0, 5, 0, 0, 5, 0, 4, 3, 0, 0, 2, 2, 1, 3, 0, 5, 3, 2, 0, 3, 1, 3, 0, 3, 0, 3, 2, 5, 5, 5, 0, 5, 5, 1, 5, 2, 2, 3, 1, 4, 0, 2, 1, 0, 0, 1, 5, 1, 5, 3, 1, 4, 1, 2, 0, 5, 0, 1, 4, 0, 3, 4, 0, 4, 4, 0, 5, 0, 3, 0, 0, 3, 4, 1, 2, 4, 3, 2, 3, 2, 3, 1, 2, 3, 4, 5, 5, 2, 3, 0, 4, 0, 2, 1, 5, 3, 3, 5, 2, 1, 2, 1, 3, 1, 3, 5, 4, 5, 5, 2, 2, 0, 0, 0, 2, 3, 5, 5, 2, 0, 2, 3, 2, 0, 0, 1, 2, 3, 0, 4, 1, 5, 0, 3, 3, 2, 4, 1, 0, 0, 1, 0, 2, 2, 1, 4, 0, 4, 1, 0, 0, 3, 4, 5, 2, 1, 1, 3, 5, 4, 2, 4, 1, 1, 0, 0, 3, 4, 2, 0, 5, 4, 4, 5, 0, 5, 3, 5, 3, 1, 0, 2, 0, 4, 0, 1, 2, 2, 4, 2, 0, 3, 1, 3, 2, 5, 1, 4, 1, 5, 3, 3, 4, 1, 5, 2, 0, 2, 1, 4, 1, 2, 0, 4, 3, 0, 1, 4, 1, 5, 4, 1, 0, 1, 5, 2, 3, 3, 2, 0, 2, 1, 3, 4, 2, 4, 1, 2, 3, 4, 0, 1, 3, 3, 4, 2, 1, 1, 0, 5, 0, 0, 4, 2, 2, 4, 3, 3, 5, 3, 3, 0, 3, 3, 2, 3, 0, 4, 5, 4, 1, 2, 4, 3, 0, 2, 3, 3, 3, 0, 5, 4, 0, 0, 4, 2, 1, 0, 4, 4, 1, 0, 1, 4, 0, 0, 1, 4, 4, 5, 5, 3, 0, 2, 5, 4, 5, 4, 1, 2, 1, 5, 3, 0, 1, 3, 3, 2, 3, 1, 1, 2, 0, 1, 2, 0, 2, 1, 0, 0, 4, 0, 0, 0, 2, 4, 5, 0, 0, 4, 2, 5, 5, 2, 5, 3, 2, 2, 0, 1, 0, 2, 5, 0, 5, 4, 1, 1, 2, 1, 4, 5, 3, 0, 4, 2, 2, 2, 4, 3, 3, 2, 1, 1, 5, 3, 3, 0, 0, 5, 0, 1, 0, 0, 2, 2, 3, 1, 0, 0, 4, 4, 1, 5, 0, 3, 0, 1, 4, 1, 3, 2, 0, 1, 1, 2, 5, 0, 4, 3, 5, 0, 2, 3, 5, 0, 4, 3, 3, 0, 4, 3, 1, 1, 1, 5, 1, 0, 0, 0, 2, 0, 3, 2, 4, 0, 3, 0, 3, 3, 5, 3, 1, 3, 5, 5, 3, 3, 3, 0, 0, 5, 4, 4, 3, 4, 1, 1, 3, 1, 1, 4, 5, 5, 3, 2, 0, 5, 0, 0, 0, 0, 4, 1, 0, 3, 0, 2, 4, 2, 0, 5, 3, 0, 4, 2, 2, 5, 4, 3, 0, 1, 0, 4, 0, 1, 3, 1, 0, 0, 0, 3, 4, 3, 3, 5, 3, 5, 2, 3, 0, 5, 3, 0, 4, 0, 2, 0, 2, 3, 2, 2, 4, 3, 3, 4, 4, 0, 0, 5, 5, 2, 1, 2, 2, 3, 3, 5, 1, 1, 3, 3, 0, 0, 0, 3, 4, 5, 4, 2, 3, 0, 1, 1, 3, 5, 3, 1, 0, 2, 3, 5, 5, 5, 0, 3, 4, 0, 4, 3, 0, 2, 5, 5, 4, 5, 1, 4, 0, 0, 3, 3, 4, 0, 1, 1, 1, 2, 3, 0, 4, 0, 1, 3, 2, 4, 1, 3, 5, 2, 3, 2, 3, 0, 4, 1, 2, 1, 2, 4, 5, 0, 1, 4, 2, 4, 3, 0, 2, 0, 0, 1, 0, 1, 1, 5, 0, 3, 2, 1, 3, 3, 0, 0, 4, 2, 3, 1, 2, 3, 5, 0, 3, 2, 0, 4, 0, 2, 5, 4, 0, 0, 0, 0, 1, 0, 3, 0, 4, 3, 1, 5, 3, 2, 1, 3, 2, 5, 1, 0, 0, 0, 0, 0, 2, 5, 1, 1, 5, 0, 2, 1, 3, 0, 2, 4, 2, 3, 3, 0, 1, 2, 3, 0, 4, 3, 5, 2, 3, 0, 3, 5, 2, 1, 5, 4, 1, 2, 2, 5, 0, 4, 0, 3, 5, 2, 1, 3, 5, 3, 4, 4, 2, 5, 2, 1, 5, 3, 0, 3, 1, 5, 0, 3, 3, 0, 3, 3, 4, 3, 2, 3, 0, 0, 0, 3, 0, 2, 3, 5, 1, 2, 1, 5, 3, 5, 4, 3, 1, 5, 4, 3, 0, 2, 4, 3, 2, 3, 0, 0, 3, 2, 1, 5, 2, 4, 3, 0, 3, 4, 1, 1, 3, 4, 2, 3, 3, 1, 2, 2, 3, 4, 0, 0, 3, 2, 2, 0, 2, 3, 2, 1, 2, 3, 3, 1, 2, 1, 2, 1, 1, 3, 0, 3, 5, 1, 0, 0, 5, 3, 4, 0, 2, 1, 3, 0, 5, 0, 5, 0, 1, 5, 3, 4, 1, 5, 0, 3, 1, 5, 0, 3, 3, 4, 3, 0, 5, 2, 2, 2, 1, 3, 5, 1, 1, 4, 3, 3, 1, 0, 2, 5, 1, 4, 2, 5, 2, 2, 5, 0, 3, 4, 1, 3, 5, 1, 0, 3, 3, 4, 3, 2, 5, 3, 2, 5, 3, 1, 4, 1, 3, 1, 0, 3, 5, 3, 3, 3, 2, 0, 0, 3, 1, 3, 2, 3, 1, 0, 2, 3, 3, 1, 2, 0, 3, 4, 0, 4, 4, 1, 0, 2, 2, 3, 0, 0, 4, 2, 0, 4, 2, 3, 4, 2, 2, 3, 0, 0, 1, 4, 4, 2, 3, 2, 2, 1, 2, 1, 3, 3, 3, 3, 2, 1, 3, 0, 0, 5, 3, 5, 2, 3, 5, 2, 2, 0, 2, 5, 3, 3, 0, 5, 3, 3, 1, 1, 1, 2, 2, 5, 3, 4, 3, 5, 3, 0, 4, 3, 0, 2, 4, 2, 0, 5, 2, 2, 2, 2, 0, 3, 1, 0, 0, 3, 2, 0, 2, 0, 3, 1, 0, 2, 1, 3, 3, 3, 5, 0, 1, 0, 3, 0, 0, 1, 0, 3, 5, 3, 0, 3, 2, 3, 0, 3, 5, 5, 2, 1, 1, 3, 2, 4, 0, 1, 3, 0, 4, 2, 3, 5, 1, 3, 2, 3, 3, 2, 0, 0, 2, 4, 0, 5, 3, 3, 3, 0, 2, 0, 2, 3, 0, 3, 0, 4, 5, 2, 3, 2, 1, 2, 0, 1, 1, 2, 1, 2, 2, 0, 3]
# classifyresult = []
# for i in kmeans._labels:
#     classifyresult.append(int(i))
# for i in range(len(classifyresult)):
#     if ldaresult[i] != classifyresult[i]:
#         print i,ldaresult[i],classifyresult[i]
#

