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

package achep base utils 
import android annotation suppresslint 
import android content context 
import android content resources 
import android graphics drawable drawable 
import android support annotation drawableres 
import android support annotation nonnull 
import android support annotation nullable 
import android support annotation stringres 
import achep base device 
import java util illegalformatexception 
import java util locale 
created artem chepurnoy 
public class resutils 
getstring android content resources object 
nonnull 
public static string getstring nonnull context context stringres object formatargs 
return getstring context getresources formatargs 
return string value associated with particular resource 
substituting format arguments defined link java util formatter 
link java lang string format will stripped styled text 
information 
param desired resource identifier generated aapt 
tool this integer encodes package type resource 
entry value invalid identifier 
param formatargs format arguments that will used substitution 
return string string data associated with resource 
stripped styled text information 
throws resources notfoundexception throws notfoundexception given does exist 
nonnull 
public static string getstring nonnull resources resources stringres object formatargs 

return resources getstring formatargs 
catch illegalformatexception 
final string message failed format string resource user locale 
locale getdefault tostring 
throw illegalargumentexception message 
suppresslint newapi 
suppresswarnings deprecation 
nullable 
public static drawable getdrawable nonnull context context drawableres drawableres 
return device haslollipopapi 
context getresources getdrawable drawableres context gettheme 
context getresources getdrawable drawableres 
