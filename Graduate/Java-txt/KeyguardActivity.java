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

package achep acdisplay activities 
import android keyguardmanager 
import android admin devicepolicymanager 
import android content broadcastreceiver 
import android content context 
import android content intent 
import android content intentfilter 
import android bundle 
import android handler 
import android powermanager 
import android systemclock 
import android support annotation nonnull 
import android support annotation nullable 
import android util 
import android view view 
import android view windowmanager 
import achep acdisplay 
import achep acdisplay 
import achep acdisplay timeout 
import achep acdisplay services keyguardservice 
import achep acdisplay activities base baseactivity 
import achep base device 
import achep base tests check 
import achep base utils keyguardutils 
import achep base utils toastutils 
import achep base utils logs tracinglog 
import achep base utils power powerutils 
import static achep base build debug 
activity that contains some methods emulate system keyguard 
author artem chepurnoy 
public abstract class keyguardactivity extends baseactivity implements 
timeout ontimeouteventlistener 
private static final string keyguardactivity 
optional extra that contains reason this 
wake 
public static final string extra_cause cause 
public static final string extra_turn_screen_on turn_screen_on 
this constant cyanogenmod specific should nothing 
stock android 
private static final prevent_power_key 
private static final system_ui_basic_flags 
static 
final device haskitkatapi view system_ui_flag_hide_navigation 
system_ui_basic_flags 
view system_ui_flag_low_profile 
view system_ui_flag_layout_fullscreen 
view system_ui_flag_layout_hide_navigation 
view system_ui_flag_layout_stable 
private static final unlocking_max_time 
private static final pf_max_time 
private broadcastreceiver mscreenoffreceiver 
private keyguardmanager mkeyguardmanager 
private long munlockingtime 
private boolean mresumed 
private mextracause 
private boolean mtimeoutpaused true 
private final timeout mtimeout timeout 
private final handler mhandler handler 
private powermanager wakelock mwakeuplock 
private boolean mkeyguarddismissed 
private view onsystemuivisibilitychangelistener msystemuilistener 
override 
public void onwindowfocuschanged boolean windowhasfocus 
super onwindowfocuschanged windowhasfocus 
debug window focus changed windowhasfocus 
isunlocking 
windowhasfocus 
munlockingtime 
else 
finish 
return 
mresumed 
populateflags windowhasfocus 
update system visibility hide optionally 
status 
setsystemuivisibilityfake 
private void populateflags boolean manualcontrol 
windowflags windowmanager layoutparams flag_keep_screen_on 
timeoutdelay getconfig gettimeoutnormal 
manualcontrol 
getwindow addflags windowflags 
mtimeoutpaused false 
mtimeout resume 
mtimeout settimeoutdelayed timeoutdelay true 
else 
getwindow clearflags windowflags 
mtimeoutpaused true 
mtimeout settimeoutdelayed timeoutdelay true 
mtimeout pause 
override 
protected void oncreate bundle savedinstancestate 
super oncreate savedinstancestate 
debug creating keyguard activity 
mtimeout registerlistener this 
mkeyguardmanager keyguardmanager getsystemservice context keyguard_service 
registerscreeneventsreceiver 
flags 
handle intents 
final intent intent getintent 
intent null 
haswakeupextra intent flags windowmanager layoutparams flag_turn_screen_on 
mextracause intent getintextra extra_cause 
fixme android team broke dismiss_keyguard flag 
https code google android developer preview issues detail 
device haslollipopapi 
device hasmarshmallowapi should fine 
mkeyguardmanager iskeyguardsecure 
getwindow addflags flags 
requestdismisssystemkeyguard 
else 
getwindow addflags flags 
show activity above system keyguard 
windowmanager layoutparams flag_show_when_locked 
update system visibility hide optionally 
status 
final view decorview getwindow getdecorview 
decorview setonsystemuivisibilitychangelistener 
msystemuilistener view onsystemuivisibilitychangelistener 
public final void onsystemuivisibilitychange 
setsystemuivisibilityfake 
decorview postdelayed runnable 
override 
public void 
visibility system_ui_basic_flags 
view system_ui_flag_immersive_sticky 
getconfig isfullscreen 
visibility view system_ui_flag_fullscreen 
decorview setsystemuivisibility visibility 

public void setsystemuivisibilityfake 
visibility system_ui_basic_flags view system_ui_flag_immersive 
getconfig isfullscreen 
visibility view system_ui_flag_fullscreen 
getwindow getdecorview setsystemuivisibility visibility 
override 
protected void onnewintent intent intent 
super onnewintent intent 
handle intents 
haswakeupextra intent acquirewakeuplock 
mextracause intent getintextra extra_cause 
override 
public void onattachedtowindow 
super onattachedtowindow 
handle intents 
haswakeupextra getintent acquirewakeupflags 
releasewakeuplock 
private void acquirewakeuplock 
flags powermanager acquire_causes_wakeup powermanager screen_dim_wake_lock 
powermanager powermanager getsystemservice context power_service 
mwakeuplock newwakelock flags turn keyguard 
mwakeuplock acquire 
releases previously acquired link mwakeuplock wake lock does 
nothing code null held 
acquirewakeuplock 
private void releasewakeuplock 
mwakeuplock null mwakeuplock isheld mwakeuplock release 
private void acquirewakeupflags 
getwindow addflags windowmanager layoutparams flag_turn_screen_on 
return code true passed intent code null includes 
link extra_turn_screen_on code true code false 
otherwise 
private boolean haswakeupextra nullable intent intent 
return intent null intent getbooleanextra extra_turn_screen_on false 
override 
public void ondetachedfromwindow 
releasewakeuplock 
super ondetachedfromwindow 
override 
protected void ondestroy 
debug destroying keyguard activity 
unregisterscreeneventsreceiver 
mtimeout unregisterlistener this 
mtimeout clear 
super ondestroy 
registers receiver finish activity when screen goes 
refresh window flags screen will need 
link unregisterscreeneventsreceiver unregister later 
unregisterscreeneventsreceiver 
private void registerscreeneventsreceiver 
mscreenoffreceiver broadcastreceiver 
override 
public void onreceive context context intent intent 
switch intent getaction 
case intent action_screen_on 
mresumed 
fake system visibility state change 
update flags again 
msystemuilistener onsystemuivisibilitychange 
break 
case intent action_screen_off 
keyguardservice isactive 
powermanager powermanager context getsystemservice context power_service 
newwakelock powermanager partial_wake_lock finalize keyguard acquire 
keyguardactivity this finish 
break 
intentfilter intentfilter intentfilter 
intentfilter addaction intent action_screen_on 
intentfilter addaction intent action_screen_off 
intentfilter setpriority intentfilter system_high_priority allowed priority 
registerreceiver mscreenoffreceiver intentfilter 
unregisters screen receiver registered previously 
registerscreeneventsreceiver 
private void unregisterscreeneventsreceiver 
mscreenoffreceiver null 
unregisterreceiver mscreenoffreceiver 
mscreenoffreceiver null 
override 
public void onstart 
super onstart 
sendbroadcast action_state_start 
override 
protected void onresume 
debug resuming keyguard activity 
super onresume 
mresumed true 
munlockingtime 
populateflags true 
overridehomepress true 
getwindow addflags prevent_power_key 
read system screen timeout setting 

msystemscreenofftimeout settings system getint 
getcontentresolver 
settings system screen_off_timeout 
catch settings settingnotfoundexception 
msystemscreenofftimeout 
sendbroadcast action_state_resume 
override 
protected void onpause 
sendbroadcast action_state_pause 
getwindow clearflags prevent_power_key 
debug pausing keyguard activity 
mresumed false 
populateflags false 
overridehomepress false 
mhandler removecallbacksandmessages null 
super onpause 
override 
public void onstop 
super onstop 
workarounds this 
this annoying driving crazy after acdisplay notification 
matter much time wait when press power button will 
directly launcher only turn screen again 
will lockscreen should always 
read more https plus google posts zyfwurptt 
mkeyguarddismissed only after setting flag_dismiss_keyguard flag 
isfinishing otherwise flags case turn screen 
keyguardservice isactive otherwise fine leave device unlocked 
powerutils isscreenon this screen will kill later 
debug clearing flag_dismiss_keyguard flag 
getwindow clearflags windowmanager layoutparams flag_dismiss_keyguard 
mkeyguarddismissed false 
sendbroadcast action_state_stop 
notifies xposed link achep acdisplay plugins xposed overridehomebutton module 
start ignoring home button press please notice that will ignore home button 
click everywhere until call code overridehomepress false 
param override code true start ignoring code false stop 
achep acdisplay plugins xposed overridehomebutton 
sendbroadcast android content intent 
private void overridehomepress boolean override 
sendbroadcast override 
action_eat_home_press_start 
action_eat_home_press_stop 
same calling code sendbroadcast intent action 
private void sendbroadcast nonnull string action 
sendbroadcast intent action 
override 
protected void onuserleavehint 
super onuserleavehint 
debug user leaving 
user tried fool keyguard 
blame shall pass 
turn screen 
powerutils isscreenon this 
munlocking 
shall pass 
lock 
else mlocking 
finish 
override 
public void ontimeoutevent nonnull timeout timeout event 
debug tracinglog timeout event 
switch event 
case timeout event_changed 
case timeout event_resumed 
mtimeoutpaused 
runonuithread runnable 
override 
public void 
mtimeout pause 
break 
case timeout event_timeout 
check getinstance isfalse mtimeoutpaused 
lock 
break 
locks device turns screen 
return code true successful code false otherwise 
devicepolicymanager locknow 
public boolean lock 
devicepolicymanager devicepolicymanager getsystemservice context device_policy_service 

todo respect secure lock timeout settings 
munlockingtime 
locknow 
return true 
catch securityexception 
string errormessage failed lock screen security exception 
toastutils showlong this errormessage 
errormessage 
clear flag_keep_screen_on flag prevent situation when 
acdisplay stays forever normally this should never happen 
getwindow clearflags windowmanager layoutparams flag_keep_screen_on 
return false screw owner 
unlocks keyguard runs link runnable runnable when unlocked 
public void unlock nullable runnable runnable 
unlock runnable true 
unlocks keyguard runs link runnable runnable when unlocked 
param finish code true finish activity code false keep 
unlock runnable 
public void unlock final nullable runnable runnable final boolean finish 
debug unlocking with params finish finish 
keyguard disabled need make 
delay between calling this method 
unlocking 
otherwise need this delay 
flags applied 
final long systemclock elapsedrealtime 
munlockingtime 
requestdismisssystemkeyguard 
mhandler post runnable 
override 
public void 
loop until flag gets applied 
todo somewhat trigger detecting unlocking 
delta systemclock elapsedrealtime 
islocked issecure delta unlocking_max_time 
mhandler postdelayed this 
return 
runnable null runonuithread runnable 
finish 
performunlock 
private void performunlock 
munlockingtime systemclock elapsedrealtime 
mkeyguarddismissed false 
finish 
boolean animate getconfig isunlockanimationenabled ispowersavemode 
overridependingtransition animate 
anim activity_unlock 

sets link windowmanager layoutparams flag_dismiss_keyguard flag 
marks link mkeyguarddismissed code true 
private void requestdismisssystemkeyguard 
getwindow addflags windowmanager layoutparams flag_dismiss_keyguard 
mkeyguarddismissed true 
returns whether device currently locked requires 
pattern password unlock 
return code true device locked code false otherwise 
public boolean issecure 
return keyguardutils isdevicelocked mkeyguardmanager 
return whether keyguard presents 
return code true device locked code false otherwise 
public boolean islocked 
return mkeyguardmanager iskeyguardlocked 
return whether keyguard unlocking 
return code true keyguard unlocking code false otherwise 
unlock runnable 
pf_max_time 
public boolean isunlocking 
return systemclock elapsedrealtime munlockingtime pf_max_time 
public getcause 
return mextracause 
nonnull 
public timeout gettimeout 
return mtimeout 
override 
public void onbackpressed override back button 
