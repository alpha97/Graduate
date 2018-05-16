#coding:utf-8
#这个文件是用来测试python压缩文件的。
import os
import zipfile
import os
import re
appName = 'Wordpress'
filename = appName + '.zip'
wrdir = 'Java-txt\\'
print os.getcwd()
ex_before = os.getcwd()+'\\zippackages\\'
ex_after = os.getcwd()+'\\extracted\\'
def extract(path):
    fname = path.split("\\")[-1]
    print fname.split('\.')[0]
    with zipfile.ZipFile(path, 'r') as zip:
        zip.printdir()
        print 'Extracting...'
        zip.extractall(ex_after+fname)
        print 'done!'
extract(ex_before+filename)

def trverse(path):
    mylist = os.listdir(path)
    for index in mylist:
        fp = os.path.join(path,index)
        if os.path.isfile(fp):
            if fp.endswith('.java'):
                temwr = open(wrdir+fp.split('\\')[-1],'w')
                #Codepro.filepro(fp)
                print fp.split('\\')[-1]
                with open(fp,'r')as f:
                    for line in f.readlines():
                        if len(line.strip()) > 4:
                            string = re.sub('\W', ' ', line).strip().lower()
                            string = re.sub('\d+', ' ', string)
                            for word in string.split():
                                if len(word)>3:
                                    temwr.write(word+" ")
                            temwr.write("\n")

                temwr.close()
                #print fp

        elif os.path.isdir(fp):

            trverse(fp)

trverse(ex_after+filename)