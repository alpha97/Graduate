#-*- coding:utf-8 -*-

#from enchant.checker import SpellChecker
#from textblob import TextBlob
from textblob import Word
from nltk.corpus import stopwords
import nltk
#change to low
#Spelling correction 拼写纠错 注释的代码块是使用pyenchant实现的,
#因为这种方法需要人工判断是否需要改正，所以注释掉了。
lowfile = open("low.txt","w")
with open("ARpro.txt")as origin:
    line = origin.read()
    lowfile.write(str(line.lower().strip()))
'''
with open("low.txt")as file:
    line = file.read()
    chkr = SpellChecker("en_US")
    chkr.ignore_always("iphone")
    chkr.ignore_always("app")
    chkr.set_text(line)
    for err in chkr:
        print "ERROR:",err.word
        print chkr.suggest(err.word)
'''

wordDict = {}#最初的评论
#将评论分词，去除评论中的标点符号并生成原始词典
#Tokenization
with open("low.txt") as low:
    i = 0
    for line in low:
        #print line
        line = line.translate(None,'",.()!;/?0123456789')#过滤标点和数字
        #tem = TextBlob(line)
        #s = tem.correct()
        list = []
        for word in line.split():
            list.append(str(word).strip())
        wordDict[i] = list
        i = i + 1
#SpellCorrect 这里使用的是TEXTBLOB库。花时间较长。
correct_Dict = {}
for index,words in wordDict.items():
    list = []
    for word in words:
        w = Word(word)
        list.append(w.correct())
    correct_Dict[index] = list
#Singularization 使用TEXTBLOB，花时间较长。
singular_Dict = {}
for index,words in correct_Dict.items():
    list = []
    for word in words:
        list.append(str(word.singularize()))
    singular_Dict[index] = list

#stemming 词干提取 提取后有些单词不知道什么意思了。所以注释掉了。使用的nltk
'''
stemed_Dict = {}#词干提取后的词典
from nltk.stem import PorterStemmer
pst = PorterStemmer()
for index,words in singular_Dict.items():
    list = []
    for word in words:
        list.append(pst.stem(word))
    stemed_Dict[index] = list
'''
# pos 词性标注并过滤特定词性单词
tagDict = {}#pos之后的标签词典
for index,words in singular_Dict.items():
    tagDict[index] = nltk.pos_tag(words)

#Nouns and verbs filtering
filterDict = {}#pos过滤名词和动词后的结果。
for index,tags in tagDict.items():
    tem = []
    for tag in tags:
        if tag[1] != 'NN'and tag[1]!='VB':
            continue
        else:
            tem.append(tag[0])#这里只保留了单词，若是tag则保留了单词和词性组成的元组
    filterDict[index] = tem
#StopWord removal 停用词移除 使用nltk
stopword_filter_Dict = {}
stoplist = stopwords.words("english")
for index,words in filterDict.items():
    cleanedlist = [word for word in words if word not in stoplist]
    stopword_filter_Dict[index] = cleanedlist

# Repetitions removal 移除评论中重复多次的单词以及长度过短的单词
repe_filter_Dict = {}
for index,words in stopword_filter_Dict.items():
    list = []
    for word in words:
        if word not in list and len(word)>2:
            list.append(word)
    repe_filter_Dict[index] = list

# Short document removal 移除长度过短的评论
short_filter_Dict = {}
j = 0
for index,words in repe_filter_Dict.items():
    if len(words)<3:
        #print index 单词数少于两个的评论索引
        continue
    else:
        short_filter_Dict[j] = words
        j = j + 1

resultfile = file("result.txt",'w')
for k,v in short_filter_Dict.items():
    #print k,v
    resultfile.write(str(k))
    for word in v:
        resultfile.write(str(word)+',')
    resultfile.write('\n')













