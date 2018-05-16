#coding:utf-8
import os
javadir = 'Java-txt\\'
classed = 'classed\\'
def deljava(filepath):
    file = os.listdir(filepath)
    for index in file:
        fp = os.path.join(filepath,index)
        #print index
        os.remove(fp)

#deljava(javadir)

