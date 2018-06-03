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

package achep acdisplay services 
import android notification 
import android notificationmanager 
import android content broadcastreceiver 
import android content context 
import android content intent 
import android content intentfilter 
import android ibinder 
import android support annotation nonnull 
import android support annotation nullable 
import android support content localbroadcastmanager 
import android text textutils 
import android util 
import achep acdisplay 
import achep acdisplay 
import achep acdisplay notifications notificationhelper 
import achep acdisplay activities mainactivity 
import achep base appheap 
import achep base interfaces ionlowmemory 
import achep base services baseservice 
import java util hashmap 
import java util 
import java util 
import java util concurrent concurrenthashmap 
import static achep base build debug 
created achep 
author artem chepurnoy 
public class bathservice extends baseservice 
private static final string bathservice 
private static final string action_add_service add_service 
private static final string action_remove_service remove_service 
private static final string extra_service_class class 
public static void startservice context context class extends childservice clazz 
synchronized monitor 
srunning 
intent intent intent action_add_service 
intent putextra extra_service_class clazz 
localbroadcastmanager getinstance context sendbroadcast intent 
else sservicemap containskey clazz 
childservice instance 

instance clazz newinstance 
catch exception 
throw runtimeexception 
sservicemap clazz instance 
screated context startservice intent context bathservice class 
public static void stopservice context context class extends childservice clazz 
synchronized monitor 
srunning 
intent intent intent action_remove_service 
intent putextra extra_service_class clazz 
localbroadcastmanager getinstance context sendbroadcast intent 
else 
sservicemap remove clazz 
private static final class childservice sservicemap concurrenthashmap 
private static final object monitor object 
private static boolean screated 
private static boolean srunning 
private localbroadcastmanager mlocalbroadcastmanager 
private notificationmanager mnotificationmanager 
private string mlanguage 
private final class childservice mmap hashmap 
private final broadcastreceiver mreceiver broadcastreceiver 
override 
public void onreceive context context intent intent 
final string action intent getaction 
switch action 
received from local broadcast receiver 
case action_add_service 
case action_remove_service 
synchronized monitor 
class clazz class intent getserializableextra extra_service_class 
boolean addition action_add_service equals action 
boolean exists mmap containskey clazz 
addition exists return 
addition addition 
childservice child 

adding child host service 
child childservice clazz newinstance 
catch exception 
throw runtimeexception should never happen 
child setcontext bathservice this 
child oncreate 
mmap clazz child 
updatenotification 
else removal 
childservice child mmap remove clazz 
child ondestroy 
child setcontext null 
mmap isempty 
stopmyself 
else updatenotification 
break 
received from system broadcast receiver 
case intent action_configuration_changed 
string lang getresources getconfiguration locale getlanguage 
textutils equals mlanguage lang 
mlanguage lang 
updatenotification 
break 
override 
public void oncreate 
super oncreate 
mnotificationmanager notificationmanager getsystemservice notification_service 
mlanguage getresources getconfiguration locale getlanguage 
listen config changes update notification just 
once locale changed 
intentfilter intentfilter intentfilter 
intentfilter addaction intent action_configuration_changed 
registerreceiver mreceiver intentfilter 
synchronized monitor 
screated true 
srunning true 
register remove service events 
intentfilter intentfilter 
intentfilter addaction action_add_service 
intentfilter addaction action_remove_service 
mlocalbroadcastmanager localbroadcastmanager getinstance this 
mlocalbroadcastmanager registerreceiver mreceiver intentfilter 
sservicemap isempty 
stopmyself 
else 
init children 
entry class childservice sservicemap entryset 
entry class childservice entry 
childservice child entry getvalue 
child setcontext this 
child oncreate 
mmap entry getkey child 
sservicemap clear 
startforeground id_notify_bath buildnotification 
override 
public void onlowmemory 
super onlowmemory 
synchronized monitor 
childservice child mmap values 
child onlowmemory 
override 
public void ondestroy 
super ondestroy 
synchronized monitor 
screated false 
srunning false 
mlocalbroadcastmanager unregisterreceiver mreceiver 
kill children 
childservice child mmap values child ondestroy 
mmap clear 
todo should children back pending then 
restart service 
sservicemap isempty startservice intent this getclass 
unregisterreceiver mreceiver 
make sure that notification does exists 
mnotificationmanager cancel id_notify_bath 
leaks canary 
appheap getrefwatcher watch this 
private void stopmyself 
srunning false 
stopself 
private void updatenotification 
mnotificationmanager notify id_notify_bath buildnotification 
builds fresh notification with link childservice children services 
link achep acdisplay services bathservice childservice getlabel labels 
nonnull 
private notification buildnotification 
boolean empty true 
stringbuilder stringbuilder 
string divider getstring string settings_multi_list_divider 
childservice child mmap values 
string label child getlabel 
textutils isempty label 
debug 
label child getclass getsimplename 
else continue 
empty 
append divider 
append label 
empty false 
format message text 
string contenttext tostring 
contenttext length mlanguage contains 
contenttext contenttext charat contenttext substring tolowercase 
notification intent 
intent intent null 
childservice child mmap values 
textutils isempty child getlabel 
intent null 
intent child getsettingsintent 
else 
intent null 
break 
intent null 
intent intent this mainactivity class 
return notificationhelper buildnotification this id_notify_bath contenttext intent 
override 
public ibinder onbind intent intent 
return null 
child service 
base fake foreground service hosted link achep acdisplay services bathservice 
call link bathservice startservice android content context class start this service 
link bathservice stopservice android content context class stop 
author artem chepurnoy 
public abstract static class childservice implements ionlowmemory 
private context mcontext 
public childservice 
debug 
creating getclass getsimplename service 
final void setcontext context context 
mcontext context 
called when fake service attached main 
android service oncreate 
public abstract void oncreate 
called when fake service detached from main 
android service ondestroy 
public abstract void ondestroy 
inheritdoc 
override 
public void onlowmemory placeholder 
return human readable label this service 
nullable 
public string getlabel 
return null 
nullable 
public intent getsettingsintent 
return null 
public final context getcontext 
return mcontext 
