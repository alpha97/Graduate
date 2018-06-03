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

package achep acdisplay utils 
import android pendingintent 
import android content context 
import android content intent 
import android support annotation nonnull 
import android support annotation nullable 
import achep base tests check 
import java lang reflect method 
created artem 
public class pendingintentutils 
perform operation associated with this pendingintent 
public static boolean sendpendingintent nullable pendingintent 
return sendpendingintent null null 
perform operation associated with this pendingintent 
public static boolean sendpendingintent nullable pendingintent context context intent intent 
null 

context caller null 
intent also null 
check getinstance istrue context null intent null 
noinspection constantconditions 
send context intent 
return true 
catch pendingintent canceledexception unused 
return false 
check whether this pendingintent will launch activity 
public static boolean isactivity nonnull pendingintent 
method method 

method pendingintent class getdeclaredmethod isactivity 
method setaccessible true 
return boolean method invoke 
catch exception 
printstacktrace 
return true must true fallback value 
