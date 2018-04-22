copyright google 
licensed under apache license version license 
this file except compliance with license 
obtain copy license 
http apache licenses license 
unless required applicable agreed writing software 
distributed under license distributed basis 
without warranties conditions kind either express implied 
license specific language governing permissions 
limitations under license 
package ringdroid 
import java util hashmap 
import android activity 
import android database cursor 
import android 
import android provider mediastore 
public class songmetadatareader 
public genres_uri mediastore audio genres external_content_uri 
public activity mactivity null 
public string mfilename 
public string mtitle 
public string martist 
public string malbum 
public string mgenre 
public myear 
songmetadatareader activity activity string filename 
mactivity activity 
mfilename filename 
mtitle getbasename filename 

readmetadata 
catch exception 
private void readmetadata 
from genre names 
hashmap string string genreidmap hashmap string string 
cursor mactivity getcontentresolver query 
genres_uri 
string 
mediastore audio genres 
mediastore audio genres name 
null null null 
movetofirst isafterlast movetonext 
genreidmap getstring getstring 
close 
mgenre 
string genreid genreidmap keyset 
mactivity getcontentresolver query 
makegenreuri genreid 
string mediastore audio media data 
mediastore audio media data like mfilename 
null null 
getcount 
mgenre genreidmap genreid 
break 
close 
null 
mediastore audio media getcontenturiforpath mfilename 
mactivity getcontentresolver query 
string 
mediastore audio media 
mediastore audio media title 
mediastore audio media artist 
mediastore audio media album 
mediastore audio media year 
mediastore audio media data 
mediastore audio media data like mfilename 
null null 
getcount 
mtitle getbasename mfilename 
martist 
malbum 
myear 
return 
movetofirst 
mtitle getstringfromcolumn mediastore audio media title 
mtitle null mtitle length 
mtitle getbasename mfilename 
martist getstringfromcolumn mediastore audio media artist 
malbum getstringfromcolumn mediastore audio media album 
myear getintegerfromcolumn mediastore audio media year 
close 
private makegenreuri string genreid 
string contentdir mediastore audio genres members content_directory 
return parse 
stringbuilder 
append genres_uri tostring 
append 
append genreid 
append 
append contentdir 
tostring 
private string getstringfromcolumn cursor string columnname 
index getcolumnindexorthrow columnname 
string value getstring index 
value null value length 
return value 
else 
return null 
private getintegerfromcolumn cursor string columnname 
index getcolumnindexorthrow columnname 
integer value getint index 
value null 
return value 
else 
return 
private string getbasename string filename 
return filename substring filename lastindexof 
filename lastindexof 
