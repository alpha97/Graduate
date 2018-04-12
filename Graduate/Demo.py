import numpy as np
theta = np.array([ [0.0 for y in range(3)] for x in range(40)])
#print(theta)
with open('model_theta.dat')as file:
    data = file.readlines()
    ix = 0
    for line in data:
        tmp = line.strip().split()
        jy = 0
        for item in tmp:
            theta[ix][jy] = float(item)
            jy += 1
        ix += 1
#print(theta)
list = []
for i in range(40):
    tmp = theta[i].tolist()
    index = tmp.index(max(tmp))
    list.append(index)
# print(list)
docdict = {}
for i in range(3):
    docdict[i] = []
for index in range(len(list)):
    docdict[list[index]].append(index)
# for k,v in docdict.items():
#     #print(k,v)
re0 = open ('00.dat','w')
re1 = open ('01.dat','w')
re2 = open ('02.dat','w')
with open('cleaned/ring_clean.txt') as train:
    doc = train.readlines()
    for k in docdict.keys():
        if k == 0:
            for item in docdict[k]:
                re0.write(doc[item])
        if k == 1:
            for item in docdict[k]:
                re1.write(doc[item])
        if k == 2:
            for item in docdict[k]:
                re2.write(doc[item])






