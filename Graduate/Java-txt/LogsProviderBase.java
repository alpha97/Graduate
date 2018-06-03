copyright achep artemchep gmail 
this program free software redistribute 
modify under terms general public license 
published free software foundation either version 
license your option later version 
this program distributed hope that will useful 
without warranty without even implied warranty 
merchantability fitness particular purpose 
general public license more details 
should have received copy general public license 
along with this program write free software 
foundation franklin street fifth floor boston 

package achep base providers 
import android content contentprovider 
import android content contentvalues 
import android content context 
import android database cursor 
import android database matrixcursor 
import android 
import android parcelfiledescriptor 
import android provider openablecolumns 
import android support annotation nonnull 
import java file 
import java filenotfoundexception 
import java util list 
import timber timber 
created achep 
public abstract class logsproviderbase extends contentprovider 
private static final string logsprovider 
private static final string column_data _data 
public static final string directory logs 
override 
public boolean oncreate 
return true 
override 
public cursor query nonnull string projection string selection 
string selectionargs string orderby 
file file 
final list string pathsegments getpathsegments 
final string filename pathsegments 
final context context getcontext 
context null 
timber context 
return null 
file getcontext getcachedir 
file null 
timber cache 
return null 
file file file file directory filename 
file exists 
timber requested file doesn exist 
return null 
projection null 
projection string 
column_data 
openablecolumns display_name 
openablecolumns size 
matrixcursor matrixcursor matrixcursor projection 
object object projection length 
projection length 
switch projection 
case column_data 
file getabsolutepath 
break 
case openablecolumns display_name 
filename 
break 
case openablecolumns size 
file length 
break 
matrixcursor addrow 
return matrixcursor 
override 
public parcelfiledescriptor openfile nonnull nonnull string mode 
throws filenotfoundexception 
return openfilehelper 
override 
public string gettype nonnull 
return text plain 
supported 
throws unsupportedoperationexception 
override 
public insert nonnull contentvalues values 
throw unsupportedoperationexception insert supported 
supported 
throws unsupportedoperationexception 
override 
public delete nonnull string selection string args 
throw unsupportedoperationexception delete supported 
supported 
throws unsupportedoperationexception 
override 
public update nonnull contentvalues values string selection string args 
throw unsupportedoperationexception update supported 
