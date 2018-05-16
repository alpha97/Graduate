介绍一下工程的目录
origin：
    存放原始评论文件，格式为txt文件
cleaned：
    带有clean后缀的为清除无用评论之后的评论文件，主要是为了分类的时候分清id的问题
    带有result后缀的文件为第二步聚类的输入文件
classed：
    聚类之后的结果文件。clean为cleaned中带有clean后缀的文件分类而成。result为带有result后缀的文件分类而成。

Sorted：
	最后的相似度排序结果文件
extracted：
	源代码Zip包加压路径
tmp：
	LDA模型的资源文件夹
zippackages：
	源代码Zip包

step1.py         对原始评论进行数据的清洗
step2.py         LDA聚类模型的实现
step3.py         生成聚类之后的结果文件
Compress.py      解压源代码Zip包并找出其中的java文件。
Resemble.py      计算相似度文件 路径为Sorted文件夹中