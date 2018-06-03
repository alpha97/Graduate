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

package achep base notifications 
import android annotation suppresslint 
import android systemclock 
import android support annotation nonnull 
import achep base device 
import java util arraylist 
import timber timber 
import static achep base build debug 
helper class help mess with notifications 
author artem chepurnoy 
public class notificationspace 
private static final string notificationspace 
private static notificationspace sinstance 
nonnull 
private final arraylist integer mlist arraylist 
nonnull 
public static synchronized notificationspace getinstance 
sinstance null 
sinstance notificationspace 
return sinstance 
public void requestrange from 

length mlist size 
length 
mlist from 
noinspection caughtexceptionimmediatelyrethrown 

mlist 
throw runtimeexception 
catch exception 
debug 
throw 
else timber getmessage 
break 
range 
mlist 
mlist from 
must call this method before creating notification 
ensure that mess with 
public void ensure 
final length mlist size 
length 
mlist mlist return 

throw runtimeexception 
must request range before 

list mlist tostring 
return string which granted unique among other 
generated this method 
public static string generateuniquetag 
final long nanotime 
noinspection statementwithemptybody 
while nanotime just sure 
other side converting long string 
will probably always last more than 
return long tostring nanotime 
suppresslint newapi 
private static long nanotime 
return device hasjellybeanmr 
systemclock elapsedrealtimenanos 
system nanotime 
