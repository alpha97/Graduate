#coding:utf-8
import numpy as np
import math
from sklearn.cluster import KMeans
data = np.random.rand(100, 3)
# #print
# estimator = KMeans(n_clusters=3)
# estimator.fit(data)
# label_pred = estimator.labels_
# centroids = estimator.cluster_centers_
# inertia = estimator.inertia_
# print label_pred
import matplotlib.pyplot as pl

iternum = [27,17,13,25,37,39,22,41,32]
SSE = [4.22933308552,3.99629308275,3.92825529981,4.44302466708,3.98658511122,5.52915305564,6.4790443516,6.27265104797,6.21620296452]
fig,ax = pl.subplots()
pl.xlabel('The ith test')
pl.ylabel('iternums;SSE')

yticks = range(0,45,5)
ax.set_yticks(yticks)
ax.set_ylim([0,45])
ax.set_xlim([0,10])
x = [i for i in range(1,10)]
pl.plot(x,iternum,"x-",label = "iternums")
pl.plot(x,SSE,"+-",label = "SSE")
pl.grid(True)
pl.legend(bbox_to_anchor=(1.0, 1), loc=1, borderaxespad=0.)
pl.show()

print np.mean(data[0,:])