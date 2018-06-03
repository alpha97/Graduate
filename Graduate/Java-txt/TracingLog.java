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

package achep base utils logs 
import android support annotation nonnull 
import android support annotation nullable 
import android text textutils 
import timber timber 
that includes fancy stack traces addition 
given message everything here uses link timber 
print logs 
public class tracinglog 
logs verbose message 
public static void nonnull string nullable string depth 
null 

timber getlocation depth 
nonnull 
private static string getlocation depth 
final string classname tracinglog class getname 
final stacktraceelement traces thread currentthread getstacktrace 
boolean found false 
stringbuilder stringbuilder 
stacktraceelement trace traces 

found 
trace getclassname startswith classname continue 
class clazz class forname trace getclassname 
append 
append getclassname clazz 
append 
append trace getmethodname 
append 
append trace getlinenumber 
append 
depth break 
else trace getclassname startswith classname 
found true 
catch classnotfoundexception ignored ignore 
return tostring 
nonnull 
private static string getclassname nullable class clazz 
clazz null 
textutils isempty clazz getsimplename 
return clazz getsimplename 
return getclassname clazz getenclosingclass 
return 
