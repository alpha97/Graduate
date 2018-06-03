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
import android content broadcastreceiver 
import android content context 
import android content intent 
import android content intentfilter 
import android asynctask 
import android powermanager 
import android systemclock 
import android support annotation nonnull 
import android support annotation nullable 
import android text textutils 
import android util 
import achep acdisplay config 
import achep acdisplay presenter 
import achep acdisplay 
import achep acdisplay services switches alarmswitch 
import achep acdisplay services switches inactivetimeswitch 
import achep acdisplay services switches nonotifiesswitch 
import achep acdisplay services switches phonecallswitch 
import achep acdisplay utils tasks runningtasks 
import achep base appheap 
import achep base content configbase 
import achep base tests check 
import achep base utils packageutils 
import achep base utils power powerutils 
import static achep base build debug 
created artem 
author artem chepurnoy 
public class keyguardservice extends switchservice 
private static final string keyguardservice 
code true link keyguardservice keyguard service running 
functioning code false otherwise 
public static boolean isactive false 
starts stops this service required settings device state 
public static void handlestate context context 
config config config getinstance 
boolean onlywhilechargingoption config isenabledonlywhilecharging 
powerutils isplugged context 
config isenabled 
config iskeyguardenabled 
onlywhilechargingoption 
bathservice startservice context keyguardservice class 
else 
bathservice stopservice context keyguardservice class 
private static final activity_launch_max_time 
private phonecallswitch mphonecallswitch 
private activitymonitorthread mactivitymonitorthread 
private string mpackagename 
private final presenter mpresenter presenter getinstance 
private final broadcastreceiver mreceiver broadcastreceiver 
override 
public void onreceive context context intent intent 
mscreenreceiver onreceive context intent 
switch intent getaction 
case intent action_screen_on 
string activityname null 
long activitychangetime 
mactivitymonitorthread null 
noinspection synchronizeonnonfinalfield 
synchronized mactivitymonitorthread 
mactivitymonitorthread monitor 
activityname mactivitymonitorthread topactivityname 
activitychangetime mactivitymonitorthread topactivitytime 
stopmonitorthread 
mphonecallswitch iscalling 
mpresenter kill 
return 
long systemclock elapsedrealtime 
boolean becauseofactivitylaunch 
activitychangetime activity_launch_max_time 
activityname null 
activityname startswith mpackagename 
debug screen activity_flag becauseofactivitylaunch 
becauseofactivitylaunch 
finish acdisplay activity shown 
after exiting from newly launched 
mpresenter kill 
else mlocked startgui normal launch 
break 
case intent action_screen_off 
mlocked mpresenter islocked 
performlockwithdelay 
break 
private boolean mlocked 
code true screen actually 
code false otherwise 
private boolean mscreenoff 
link systemclock elapsedrealtime when screen 
been turned 
private long mscreenofftimestamp 
nullable 
private asynctask void void void mdelayedlocktask 
nonnull 
private final broadcastreceiver mscreenreceiver broadcastreceiver 
override 
public void onreceive context context intent intent 
switch intent getaction 
case intent action_screen_on 
debug screen 
mscreenofftimestamp 
mscreenoff false 
cancellockwithdelay 
break 
case intent action_screen_off 
debug screen 
mscreenofftimestamp systemclock elapsedrealtime 
mscreenoff true 
break 
private void startguighost 
startgui 
private void startgui 
presenter getinstance trystartguicausekeyguard getcontext 
private void performlockwithdelay 
debug trying perform delayed lock 
final long systemclock elapsedrealtime 
final config getinstance getkeyguardlockdelaymillis 
final delay mscreenofftimestamp 
final delaymax 
delay delay delaymax 
performlock 
else delay delaymax 
todo allow delays more than without lags 
using android alarm system 
else mdelayedlocktask asynctask void void void 
override 
protected void onpreexecute 
super onpreexecute 
debug starting delay thread 
delay delaymax throw runtimeexception really want 
into deep sleep until 
finish 
powermanager powermanager getcontext getsystemservice context power_service 
newwakelock powermanager partial_wake_lock delayed lock acquire delay 
override 
protected void doinbackground void params 

thread sleep delay 
catch interruptedexception totally fine 
return null 
override 
protected void onpostexecute void 
super onpostexecute 
check getinstance istrue mscreenoff 
performlock 
execute 
private void performlock 
debug trying perform lock screen_off mscreenoff 
mscreenoff 
mlocked true 
startguighost 
startmonitorthread 
private void cancellockwithdelay 
mdelayedlocktask null mdelayedlocktask cancel true 
nonnull 
override 
public switch onbuildswitches 
config config config getinstance 
configbase option nonotifies config getoption config key_keyguard_without_notifications 
configbase option respectit config getoption config key_keyguard_respect_inactive_time 
return switch 
mphonecallswitch phonecallswitch getcontext this 
alarmswitch getcontext this 
options 
nonotifiesswitch getcontext this nonotifies true 
inactivetimeswitch getcontext this respectit 
nonnull 
override 
public string getlabel 
return getcontext getstring string service_bath_keyguard 
override 
public void oncreate 
super oncreate 
final context context getcontext 
mpackagename packageutils getname context 
mscreenoff powerutils isscreenon context 
register base receiver that watching action_screen_on 
action_screen_off does completely nothing except 
saving screen timestamp 
intentfilter intentfilter intentfilter 
intentfilter addaction intent action_screen_on 
intentfilter addaction intent action_screen_off 
intentfilter setpriority intentfilter system_high_priority highest priority 
context registerreceiver mscreenreceiver intentfilter 
override 
public void onstart nullable object objects 
final context context getcontext 
register receiver 
intentfilter intentfilter intentfilter 
intentfilter addaction intent action_screen_on 
intentfilter addaction intent action_screen_off 
intentfilter setpriority intentfilter system_high_priority highest priority 
context registerreceiver mreceiver intentfilter 
mscreenoff 
make sure launched 
mlocked mpresenter islocked 
performlockwithdelay 
isactive true 
override 
public void onstop nullable object objects 
final context context getcontext 
context unregisterreceiver mreceiver 
stopmonitorthread 
cancellockwithdelay 
mscreenoff 
make sure that 
waiting shade 
mpresenter kill 
isactive false 
override 
public void ondestroy 
final context context getcontext 
context unregisterreceiver mscreenreceiver 
super ondestroy 
watch leaks 
appheap getrefwatcher watch this 
private void startmonitorthread 
stopmonitorthread 
mactivitymonitorthread activitymonitorthread getcontext 
mactivitymonitorthread start 
private void stopmonitorthread 
mactivitymonitorthread null 
return nothing stop 
mactivitymonitorthread running false 
mactivitymonitorthread interrupt 
mactivitymonitorthread null 
thread that monitors current activity 
author artem chepurnoy 
private static class activitymonitorthread extends thread 
frequently should check running activity 
values millis 
private static final long period 
public volatile long topactivitytime 
public volatile string topactivityname 
public volatile boolean running true 
nonnull 
private final context mcontext 
public activitymonitorthread nonnull context context 
debug activity monitor thread been initiated 
mcontext context 
override 
public void 
super 
while running 
monitor 

thread sleep period 
catch interruptedexception unused 
checks what activity latest 
public synchronized void monitor 
string topactivity runningtasks getinstance getrunningtaskstop mcontext 
textutils equals topactivity topactivityname 
return 
topactivityname topactivity 
topactivitytime systemclock elapsedrealtime 
activity topactivityname 
debug 
only debug purposes 
private final object dfinalizewatcher debug object 
logs notifications removal 
override 
protected void finalize throws throwable 

activity monitor thread died 
finally 
super finalize 
null 
