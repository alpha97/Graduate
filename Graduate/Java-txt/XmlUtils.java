copyright android open source project 
licensed under apache license version license 
this file except compliance with license 
obtain copy license 
http apache licenses license 
unless required applicable agreed writing software 
distributed under license distributed basis 
without warranties conditions kind either express implied 
license specific language governing permissions 
limitations under license 
package achep base utils 
import android graphics bitmap 
import android graphics bitmap compressformat 
import android graphics bitmapfactory 
import android 
import android util base 
import android util 
import xmlpull xmlpullparser 
import xmlpull xmlpullparserexception 
import xmlpull xmlserializer 
import java bytearrayoutputstream 
import java ioexception 
import java inputstream 
import java outputstream 
import java protocolexception 
import java util arraylist 
import java util hashmap 
import java util hashset 
import java util list 
import java util 
import java util 
public class xmlutils 
public static void skipcurrenttag xmlpullparser parser 
throws xmlpullparserexception ioexception 
outerdepth parser getdepth 
type 
noinspection statementwithemptybody 
while type parser next xmlpullparser end_document 
type xmlpullparser end_tag 
parser getdepth outerdepth 
public static convertvaluetolist charsequence value string options defaultvalue 
value null 
options length 
value equals options 
return 
return defaultvalue 
public static boolean convertvaluetoboolean charsequence value boolean defaultvalue 
value null 
return defaultvalue 
return value equals 
value equals true 
value equals true 
public static convertvaluetoint charsequence charseq defaultvalue 
charseq null 
return defaultvalue 
string charseq tostring 
this code copied from integer decode 
have instantiate integer 
sign 
index 
length 
base 
charat 
sign 
index 
charat index 
quick check zero itself 
index 
return 
char charat index 

index 
base 
else 
index 
base 
else charat index 
index 
base 
return integer parseint substring index base sign 
public static convertvaluetounsignedint string value defaultvalue 
return value null defaultvalue parseunsignedintattribute value 
public static parseunsignedintattribute charsequence charseq 
string value charseq tostring 
index 
value length 
base 
value charat index 
quick check zero itself 
index 
return 
char value charat index 
check 
index 
base 
else check octal 
index 
base 
else value charat index 
index 
base 
return long parselong value substring index base 
flatten into output stream later 
read back with readmapxml 
param flattened 
param where write data 
writemapxml string xmlserializer 
writelistxml 
writevaluexml 
readmapxml 
public static void writemapxml outputstream 
throws xmlpullparserexception java ioexception 
xmlserializer serializer fastxmlserializer 
serializer setoutput 
serializer startdocument null true 
serializer setfeature http xmlpull features html indent output true 
writemapxml null serializer 
serializer enddocument 
flatten list into output stream list later 
read back with readlistxml 
param list flattened 
param where write data 
writelistxml list string xmlserializer 
writemapxml 
writevaluexml 
readlistxml 
public static void writelistxml list outputstream 
throws xmlpullparserexception java ioexception 
xmlserializer serializer newserializer 
serializer setoutput 
serializer startdocument null true 
serializer setfeature http xmlpull features html indent output true 
writelistxml null serializer 
serializer enddocument 
flatten into xmlserializer later read back 
with readthismapxml 
param flattened 
param name name attribute include with this list null 
none 
param xmlserializer write into 
writemapxml outputstream 
writelistxml 
writevaluexml 
readmapxml 
public static void writemapxml string name xmlserializer 
throws xmlpullparserexception java ioexception 
writemapxml name null 
flatten into xmlserializer later read back 
with readthismapxml 
param flattened 
param name name attribute include with this list null 
none 
param xmlserializer write into 
param callback method call when object type recognized 
writemapxml outputstream 
writelistxml 
writevaluexml 
readmapxml 
public static void writemapxml string name xmlserializer 
writemapcallback callback 
throws xmlpullparserexception java ioexception 
null 
starttag null null 
endtag null null 
return 
starttag null 
name null 
attribute null name name 
writemapxml callback 
endtag null 
flatten into xmlserializer later read back 
with readthismapxml this method presumes that start 
name attribute have already been written does write 
param flattened 
param xmlserializer write into 
writemapxml outputstream 
writelistxml 
writevaluexml 
readmapxml 
public static void writemapxml xmlserializer writemapcallback callback 
throws xmlpullparserexception java ioexception 
null 
return 
entryset 
object value 
entry entry value 
writevaluexml getvalue string getkey callback 
flatten list into xmlserializer list later read back 
with readthislistxml 
param list flattened 
param name name attribute include with this list null 
none 
param xmlserializer write list into 
writelistxml list outputstream 
writemapxml 
writevaluexml 
readlistxml 
public static void writelistxml list string name xmlserializer 
throws xmlpullparserexception java ioexception 
null 
starttag null null 
endtag null null 
return 
starttag null list 
name null 
attribute null name name 
size 

while 
writevaluexml null 
endtag null list 
public static void writesetxml string name xmlserializer 
throws xmlpullparserexception java ioexception 
null 
starttag null null 
endtag null null 
return 
starttag null 
name null 
attribute null name name 
object 
writevaluexml null 
endtag null 
flatten byte into xmlserializer list later read back 
with readthisbytearrayxml 
param byte array flattened 
param name name attribute include with this array null 
none 
param xmlserializer write array into 
writemapxml 
writevaluexml 
public static void writebytearrayxml byte string name xmlserializer 
throws java ioexception 
null 
starttag null null 
endtag null null 
return 
starttag null byte array 
name null 
attribute null name name 
final length 
attribute null integer tostring 
stringbuilder stringbuilder length 
byte 

append 

append 
text tostring 
endtag null byte array 
flatten into xmlserializer list later read back 
with readthisintarrayxml 
param array flattened 
param name name attribute include with this array null 
none 
param xmlserializer write array into 
writemapxml 
writevaluexml 
readthisintarrayxml 
public static void writeintarrayxml string name xmlserializer 
throws java ioexception 
null 
starttag null null 
endtag null null 
return 
starttag null array 
name null 
attribute null name name 
final length 
attribute null integer tostring 
aval 
starttag null item 
attribute null value integer tostring aval 
endtag null item 
endtag null array 
flatten long into xmlserializer list later read back 
with readthislongarrayxml 
param long array flattened 
param name name attribute include with this array null 
none 
param xmlserializer write array into 
writemapxml 
writevaluexml 
readthisintarrayxml 
public static void writelongarrayxml long string name xmlserializer 
throws java ioexception 
null 
starttag null null 
endtag null null 
return 
starttag null long array 
name null 
attribute null name name 
final length 
attribute null integer tostring 
long aval 
starttag null item 
attribute null value long tostring aval 
endtag null item 
endtag null long array 
flatten double into xmlserializer list later read back 
with readthisdoublearrayxml 
param double array flattened 
param name name attribute include with this array null 
none 
param xmlserializer write array into 
writemapxml 
writevaluexml 
readthisintarrayxml 
public static void writedoublearrayxml double string name xmlserializer 
throws java ioexception 
null 
starttag null null 
endtag null null 
return 
starttag null double array 
name null 
attribute null name name 
final length 
attribute null integer tostring 
double aval 
starttag null item 
attribute null value double tostring aval 
endtag null item 
endtag null double array 
flatten string into xmlserializer list later read back 
with readthisstringarrayxml 
param long array flattened 
param name name attribute include with this array null 
none 
param xmlserializer write array into 
writemapxml 
writevaluexml 
readthisintarrayxml 
public static void writestringarrayxml string string name xmlserializer 
throws java ioexception 
null 
starttag null null 
endtag null null 
return 
starttag null string array 
name null 
attribute null name name 
final length 
attribute null integer tostring 
string aval 
starttag null item 
attribute null value aval 
endtag null item 
endtag null string array 
flatten object value into xmlserializer value later 
read back with readthisvaluexml 

currently supported value types null string integer long 
float double boolean list 
param object flattened 
param name name attribute include with this value null 
none 
param xmlserializer write object into 
writemapxml 
writelistxml 
readvaluexml 
public static void writevaluexml object string name xmlserializer 
throws xmlpullparserexception java ioexception 
writevaluexml name null 
flatten object value into xmlserializer value later 
read back with readthisvaluexml 

currently supported value types null string integer long 
float double boolean list 
param object flattened 
param name name attribute include with this value null 
none 
param xmlserializer write object into 
param callback handler object types recognized 
writemapxml 
writelistxml 
readvaluexml 
private static void writevaluexml object string name xmlserializer 
writemapcallback callback 
throws xmlpullparserexception java ioexception 
string typestr 
null 
starttag null null 
name null 
attribute null name name 
endtag null null 
return 
else instanceof string 
starttag null string 
name null 
attribute null name name 
text tostring 
endtag null string 
return 
else instanceof integer 
typestr 
else instanceof long 
typestr long 
else instanceof float 
typestr float 
else instanceof double 
typestr double 
else instanceof boolean 
typestr boolean 
else instanceof byte 
writebytearrayxml byte name 
return 
else instanceof 
writeintarrayxml name 
return 
else instanceof long 
writelongarrayxml long name 
return 
else instanceof double 
writedoublearrayxml double name 
return 
else instanceof string 
writestringarrayxml string name 
return 
else instanceof 
writemapxml name 
return 
else instanceof list 
writelistxml list name 
return 
else instanceof 
writesetxml name 
return 
else instanceof charsequence 
this allow least write something 
encounter styled text means will drop 
styling information 
starttag null string 
name null 
attribute null name name 
text tostring 
endtag null string 
return 
else callback null 
callback writeunknownobject name 
return 
else 
throw runtimeexception writevaluexml unable write value 
starttag null typestr 
name null 
attribute null name name 
attribute null value tostring 
endtag null typestr 
read hashmap from inputstream containing stream 
previously have been written writemapxml 
param inputstream from which read 
return hashmap resulting 
readlistxml 
readvaluexml 
readthismapxml 
writemapxml 
suppresswarnings unchecked 
public static hashmap string readmapxml inputstream 
throws xmlpullparserexception java ioexception 
xmlpullparser parser newpullparser 
parser setinput null 
return hashmap string readvaluexml parser string 
read arraylist from inputstream containing stream 
previously have been written writelistxml 
param inputstream from which read 
return arraylist resulting list 
readmapxml 
readvaluexml 
readthislistxml 
writelistxml 
public static arraylist readlistxml inputstream 
throws xmlpullparserexception java ioexception 
xmlpullparser parser newpullparser 
parser setinput null 
return arraylist readvaluexml parser string 
read hashset from inputstream containing stream 
previously have been written writesetxml 
param inputstream from which read 
return hashset resulting 
throws xmlpullparserexception 
throws java ioexception 
readvaluexml 
readthissetxml 
writesetxml 
public static hashset readsetxml inputstream 
throws xmlpullparserexception java ioexception 
xmlpullparser parser newpullparser 
parser setinput null 
return hashset readvaluexml parser string 
read hashmap object from xmlpullparser data could 
previously have been generated writemapxml xmlpullparser 
must positioned after that begins 
param parser xmlpullparser from which read data 
param endtag name that will usually 
param name array string used return name attribute 

return hashmap newly generated 
readmapxml 
public static hashmap string readthismapxml xmlpullparser parser string endtag 
string name 
throws xmlpullparserexception java ioexception 
return readthismapxml parser endtag name null 
read hashmap object from xmlpullparser data could 
previously have been generated writemapxml xmlpullparser 
must positioned after that begins 
param parser xmlpullparser from which read data 
param endtag name that will usually 
param name array string used return name attribute 

return hashmap newly generated 
readmapxml 
public static hashmap string readthismapxml xmlpullparser parser string endtag 
string name readmapcallback callback 
throws xmlpullparserexception java ioexception 
hashmap string object hashmap 
eventtype parser geteventtype 
eventtype xmlpullparser start_tag 
object readthisvaluexml parser name callback 
name 
else eventtype xmlpullparser end_tag 
parser getname equals endtag 
return 
throw xmlpullparserexception 
expected endtag parser getname 
eventtype parser next 
while eventtype xmlpullparser end_document 
throw xmlpullparserexception 
document ended before endtag 
read arraylist object from xmlpullparser data could 
previously have been generated writelistxml xmlpullparser 
must positioned after that begins list 
param parser xmlpullparser from which read list data 
param endtag name that will list usually list 
param name array string used return name attribute 
list 
return hashmap newly generated list 
readlistxml 
public static arraylist readthislistxml xmlpullparser parser string endtag string name 
throws xmlpullparserexception java ioexception 
return readthislistxml parser endtag name null 
read arraylist object from xmlpullparser data could 
previously have been generated writelistxml xmlpullparser 
must positioned after that begins list 
param parser xmlpullparser from which read list data 
param endtag name that will list usually list 
param name array string used return name attribute 
list 
return hashmap newly generated list 
readlistxml 
private static arraylist readthislistxml xmlpullparser parser string endtag 
string name readmapcallback callback 
throws xmlpullparserexception java ioexception 
arraylist list arraylist 
eventtype parser geteventtype 
eventtype xmlpullparser start_tag 
object readthisvaluexml parser name callback 
list 
system println adding list 
else eventtype xmlpullparser end_tag 
parser getname equals endtag 
return list 
throw xmlpullparserexception 
expected endtag parser getname 
eventtype parser next 
while eventtype xmlpullparser end_document 
throw xmlpullparserexception 
document ended before endtag 
read hashset object from xmlpullparser data could previously 
have been generated writesetxml xmlpullparser must positioned 
after that begins 
param parser xmlpullparser from which read data 
param endtag name that will usually 
param name array string used return name attribute 

return hashset newly generated 
throws xmlpullparserexception 
throws java ioexception 
readsetxml 
public static hashset readthissetxml xmlpullparser parser string endtag string name 
throws xmlpullparserexception java ioexception 
return readthissetxml parser endtag name null 
read hashset object from xmlpullparser data could previously 
have been generated writesetxml xmlpullparser must positioned 
after that begins 
param parser xmlpullparser from which read data 
param endtag name that will usually 
param name array string used return name attribute 

return hashset newly generated 
throws xmlpullparserexception 
throws java ioexception 
readsetxml 
private static hashset readthissetxml xmlpullparser parser string endtag string name 
readmapcallback callback 
throws xmlpullparserexception java ioexception 
hashset hashset 
eventtype parser geteventtype 
eventtype xmlpullparser start_tag 
object readthisvaluexml parser name callback 

system println adding 
else eventtype xmlpullparser end_tag 
parser getname equals endtag 
return 
throw xmlpullparserexception 
expected endtag parser getname 
eventtype parser next 
while eventtype xmlpullparser end_document 
throw xmlpullparserexception 
document ended before endtag 
read object from xmlpullparser data could 
previously have been generated writeintarrayxml xmlpullparser 
must positioned after that begins list 
param parser xmlpullparser from which read list data 
param endtag name that will list usually list 
param name array string used return name attribute 
list 
return returns newly generated 
readlistxml 
public static readthisintarrayxml xmlpullparser parser 
string endtag string name 
throws xmlpullparserexception java ioexception 


integer parseint parser getattributevalue null 
catch nullpointerexception 
throw xmlpullparserexception 
need attribute byte array 
catch numberformatexception 
throw xmlpullparserexception 
number attribute byte array 
parser next 
array 

eventtype parser geteventtype 
eventtype xmlpullparser start_tag 
parser getname equals item 

array integer parseint 
parser getattributevalue null value 
catch nullpointerexception 
throw xmlpullparserexception 
need value attribute item 
catch numberformatexception 
throw xmlpullparserexception 
number value attribute item 
else 
throw xmlpullparserexception 
expected item parser getname 
else eventtype xmlpullparser end_tag 
parser getname equals endtag 
return array 
else parser getname equals item 
else 
throw xmlpullparserexception 
expected endtag 
parser getname 
eventtype parser next 
while eventtype xmlpullparser end_document 
throw xmlpullparserexception 
document ended before endtag 
read long object from xmlpullparser data could 
previously have been generated writelongarrayxml xmlpullparser 
must positioned after that begins list 
param parser xmlpullparser from which read list data 
param endtag name that will list usually list 
param name array string used return name attribute 
list 
return returns newly generated long 
readlistxml 
public static long readthislongarrayxml xmlpullparser parser 
string endtag string name 
throws xmlpullparserexception java ioexception 


integer parseint parser getattributevalue null 
catch nullpointerexception 
throw xmlpullparserexception need attribute long array 
catch numberformatexception 
throw xmlpullparserexception number attribute long array 
parser next 
long array long 

eventtype parser geteventtype 
eventtype xmlpullparser start_tag 
parser getname equals item 

array long parselong parser getattributevalue null value 
catch nullpointerexception 
throw xmlpullparserexception need value attribute item 
catch numberformatexception 
throw xmlpullparserexception number value attribute item 
else 
throw xmlpullparserexception expected item parser getname 
else eventtype xmlpullparser end_tag 
parser getname equals endtag 
return array 
else parser getname equals item 
else 
throw xmlpullparserexception expected endtag 
parser getname 
eventtype parser next 
while eventtype xmlpullparser end_document 
throw xmlpullparserexception document ended before endtag 
read double object from xmlpullparser data could 
previously have been generated writedoublearrayxml xmlpullparser 
must positioned after that begins list 
param parser xmlpullparser from which read list data 
param endtag name that will list usually double array 
param name array string used return name attribute 
list 
return returns newly generated double 
readlistxml 
public static double readthisdoublearrayxml xmlpullparser parser string endtag string name 
throws xmlpullparserexception java ioexception 


integer parseint parser getattributevalue null 
catch nullpointerexception 
throw xmlpullparserexception need attribute double array 
catch numberformatexception 
throw xmlpullparserexception number attribute double array 
parser next 
double array double 

eventtype parser geteventtype 
eventtype xmlpullparser start_tag 
parser getname equals item 

array double parsedouble parser getattributevalue null value 
catch nullpointerexception 
throw xmlpullparserexception need value attribute item 
catch numberformatexception 
throw xmlpullparserexception number value attribute item 
else 
throw xmlpullparserexception expected item parser getname 
else eventtype xmlpullparser end_tag 
parser getname equals endtag 
return array 
else parser getname equals item 
else 
throw xmlpullparserexception expected endtag 
parser getname 
eventtype parser next 
while eventtype xmlpullparser end_document 
throw xmlpullparserexception document ended before endtag 
read string object from xmlpullparser data could 
previously have been generated writestringarrayxml xmlpullparser 
must positioned after that begins list 
param parser xmlpullparser from which read list data 
param endtag name that will list usually string array 
param name array string used return name attribute 
list 
return returns newly generated string 
readlistxml 
public static string readthisstringarrayxml xmlpullparser parser string endtag string name 
throws xmlpullparserexception java ioexception 


integer parseint parser getattributevalue null 
catch nullpointerexception 
throw xmlpullparserexception need attribute string array 
catch numberformatexception 
throw xmlpullparserexception number attribute string array 
parser next 
string array string 

eventtype parser geteventtype 
eventtype xmlpullparser start_tag 
parser getname equals item 

array parser getattributevalue null value 
catch nullpointerexception 
throw xmlpullparserexception need value attribute item 
catch numberformatexception 
throw xmlpullparserexception number value attribute item 
else 
throw xmlpullparserexception expected item parser getname 
else eventtype xmlpullparser end_tag 
parser getname equals endtag 
return array 
else parser getname equals item 
else 
throw xmlpullparserexception expected endtag 
parser getname 
eventtype parser next 
while eventtype xmlpullparser end_document 
throw xmlpullparserexception document ended before endtag 
read flattened object from xmlpullparser data could 
previously have been written with writemapxml writelistxml 
writevaluexml xmlpullparser must positioned 
that defines value 
param parser xmlpullparser from which read object 
param name array string used return name attribute 
value 
return object newly generated value object 
readmapxml 
readlistxml 
writevaluexml 
public static object readvaluexml xmlpullparser parser string name 
throws xmlpullparserexception java ioexception 
eventtype parser geteventtype 
eventtype xmlpullparser start_tag 
return readthisvaluexml parser name null 
else eventtype xmlpullparser end_tag 
throw xmlpullparserexception 
unexpected parser getname 
else eventtype xmlpullparser text 
throw xmlpullparserexception 
unexpected text parser gettext 
eventtype parser next 
while eventtype xmlpullparser end_document 
throw xmlpullparserexception 
unexpected document 
private static object readthisvaluexml xmlpullparser parser string name 
readmapcallback callback 
throws xmlpullparserexception java ioexception 
final string valuename parser getattributevalue null name 
final string tagname parser getname 
system println reading this value tagname name valuename 
object 
tagname equals null 
null 
else tagname equals string 
stringbuilder value stringbuilder 
eventtype 
while eventtype parser next xmlpullparser end_document 
eventtype xmlpullparser end_tag 
parser getname equals string 
name valuename 
system println returning value valuename value 
return value tostring 
throw xmlpullparserexception 
unexpected string parser getname 
else eventtype xmlpullparser text 
value append parser gettext 
else eventtype xmlpullparser start_tag 
throw xmlpullparserexception 
unexpected start string parser getname 
throw xmlpullparserexception 
unexpected document string 
else noinspection statementwithemptybody 
readthisprimitivevaluexml parser tagname null 
work already done readthisprimitivevaluexml 
else tagname equals array 
readthisintarrayxml parser array name 
name valuename 
system println returning value valuename 
return 
else tagname equals long array 
readthislongarrayxml parser long array name 
name valuename 
system println returning value valuename 
return 
else tagname equals double array 
readthisdoublearrayxml parser double array name 
name valuename 
system println returning value valuename 
return 
else tagname equals string array 
readthisstringarrayxml parser string array name 
name valuename 
system println returning value valuename 
return 
else tagname equals 
parser next 
readthismapxml parser name 
name valuename 
system println returning value valuename 
return 
else tagname equals list 
parser next 
readthislistxml parser list name 
name valuename 
system println returning value valuename 
return 
else tagname equals 
parser next 
readthissetxml parser name 
name valuename 
system println returning value valuename 
return 
else callback null 
callback readthisunknownobjectxml parser tagname 
name valuename 
return 
else 
throw xmlpullparserexception unknown tagname 
skip through 
eventtype 
while eventtype parser next xmlpullparser end_document 
eventtype xmlpullparser end_tag 
parser getname equals tagname 
name valuename 
system println returning value valuename 
return 
throw xmlpullparserexception 
unexpected tagname parser getname 
else eventtype xmlpullparser text 
throw xmlpullparserexception 
unexpected text tagname parser getname 
else eventtype xmlpullparser start_tag 
throw xmlpullparserexception 
unexpected start tagname parser getname 
throw xmlpullparserexception 
unexpected document tagname 
private static object readthisprimitivevaluexml xmlpullparser parser string tagname 
throws xmlpullparserexception 

switch tagname 
case 
return integer parseint parser getattributevalue null value 
case long 
return long valueof parser getattributevalue null value 
case float 
return float valueof parser getattributevalue null value 
case double 
return double valueof parser getattributevalue null value 
case boolean 
return boolean valueof parser getattributevalue null value 
default 
return null 
catch nullpointerexception 
throw xmlpullparserexception need value attribute tagname 
catch numberformatexception 
throw xmlpullparserexception 
number value attribute tagname 
public static void begindocument xmlpullparser parser string firstelementname 
throws xmlpullparserexception ioexception 
type 
noinspection statementwithemptybody 
while type parser next xmlpullparser start_tag 
type xmlpullparser end_document 
type xmlpullparser start_tag 
throw xmlpullparserexception start found 
parser getname equals firstelementname 
throw xmlpullparserexception unexpected start found parser getname 
expected firstelementname 
public static void nextelement xmlpullparser parser throws xmlpullparserexception ioexception 
type 
noinspection statementwithemptybody 
while type parser next xmlpullparser start_tag 
type xmlpullparser end_document 
public static boolean nextelementwithin xmlpullparser parser outerdepth 
throws ioexception xmlpullparserexception 

type parser next 
type xmlpullparser end_document 
type xmlpullparser end_tag parser getdepth outerdepth 
return false 
type xmlpullparser start_tag 
parser getdepth outerdepth 
return true 
public static readintattribute xmlpullparser string name defaultvalue 
final string value getattributevalue null name 

return integer parseint value 
catch numberformatexception 
return defaultvalue 
public static readintattribute xmlpullparser string name throws ioexception 
final string value getattributevalue null name 

return integer parseint value 
catch numberformatexception 
throw protocolexception problem parsing name value 
public static void writeintattribute xmlserializer string name value 
throws ioexception 
attribute null name integer tostring value 
public static long readlongattribute xmlpullparser string name long defaultvalue 
final string value getattributevalue null name 

return long parselong value 
catch numberformatexception 
return defaultvalue 
public static long readlongattribute xmlpullparser string name throws ioexception 
final string value getattributevalue null name 

return long parselong value 
catch numberformatexception 
throw protocolexception problem parsing name value long 
public static void writelongattribute xmlserializer string name long value 
throws ioexception 
attribute null name long tostring value 
public static float readfloatattribute xmlpullparser string name throws ioexception 
final string value getattributevalue null name 

return float parsefloat value 
catch numberformatexception 
throw protocolexception problem parsing name value long 
public static void writefloatattribute xmlserializer string name float value 
throws ioexception 
attribute null name float tostring value 
public static boolean readbooleanattribute xmlpullparser string name 
final string value getattributevalue null name 
return boolean parseboolean value 
public static boolean readbooleanattribute xmlpullparser string name 
boolean defaultvalue 
final string value getattributevalue null name 
value null 
return defaultvalue 
else 
return boolean parseboolean value 
public static void writebooleanattribute xmlserializer string name boolean value 
throws ioexception 
attribute null name boolean tostring value 
public static readuriattribute xmlpullparser string name 
final string value getattributevalue null name 
return value null parse value null 
public static void writeuriattribute xmlserializer string name value 
throws ioexception 
value null 
attribute null name value tostring 
public static string readstringattribute xmlpullparser string name 
return getattributevalue null name 
public static void writestringattribute xmlserializer string name string value 
throws ioexception 
value null 
attribute null name value 
public static byte readbytearrayattribute xmlpullparser string name 
final string value getattributevalue null name 
value null 
return base decode value base default 
else 
return null 
public static void writebytearrayattribute xmlserializer string name byte value 
throws ioexception 
value null 
attribute null name base encodetostring value base default 
public static bitmap readbitmapattribute xmlpullparser string name 
final byte value readbytearrayattribute name 
value null 
return bitmapfactory decodebytearray value value length 
else 
return null 
deprecated 
public static void writebitmapattribute xmlserializer string name bitmap value 
throws ioexception 
value null 
final bytearrayoutputstream bytearrayoutputstream 
value compress compressformat 
writebytearrayattribute name tobytearray 
public interface writemapcallback 
called from writemapxml when object type recognized implementer 
must write entire element including start tags 
param object written 
param name mapping must written into name attribute 
start 
param output stream 
throws xmlpullparserexception unrecognized object type 
throws ioexception xmlserializer serialization errors 
void writeunknownobject object string name xmlserializer 
public interface readmapcallback 
called from readthismapxml when start_tag recognized input stream 
positioned within start that attributes read using getattribute 
param input stream 
param start_tag that recognized 
return object parsed from stream which will into 
throws xmlpullparserexception start_tag recognized 
throws ioexception xmlpullparser serialization errors 
object readthisunknownobjectxml xmlpullparser string 
