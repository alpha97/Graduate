#coding:utf-8
import re

# f = open('ring_low.txt','r')
# cout = 0
# for line in f:
#     string = re.sub('\W', " ", line)
#     string = re.sub('[\s+\.\!\/_,$%^*(+\"\')]+|[+——()?【】“”！，。？、~@#￥%……&*（）]+', " ", string)
#     pattern = re.compile(r"(\w*\s*)*")
#     match = pattern.match(string)
#     ss = match.group()
#     print cout,'\t', ss
#     cout+=1
# line = ' '
# string = re.sub('\W', " ", line)
# string = re.sub('[\s+\.\!\/_,$%^*(+\"\')]+|[+——()?【】“”！，。？、~@#￥%……&*（）]+', " ", string)
# pattern = re.compile(r"(\w*\s*)*")
# match = pattern.match(string)
# print match.group()

import os

for index in range(3):
    temfile = open(str(index)+'.txt','w')
    temfile.write('4')