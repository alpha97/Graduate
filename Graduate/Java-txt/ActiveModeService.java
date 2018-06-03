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

package achep acdisplay services activemode 
import android content broadcastreceiver 
import android content context 
import android content intent 
import android content intentfilter 
import android hardware sensor 
import android hardware sensormanager 
import android powermanager 
import android systemclock 
import android support annotation nonnull 
import android support content localbroadcastmanager 
import android util 
import achep acdisplay 
import achep acdisplay atomic 
import achep acdisplay config 
import achep acdisplay presenter 
import achep acdisplay 
import achep acdisplay notifications notificationpresenter 
import achep acdisplay notifications opennotification 
import achep acdisplay services bathservice 
import achep acdisplay services switch 
import achep acdisplay services switchservice 
import achep acdisplay services activemode sensors accelerometersensor 
import achep acdisplay services activemode sensors gyroscopesensor 
import achep acdisplay services activemode sensors proximitysensor 
import achep acdisplay services switches batteryoutswitch 
import achep acdisplay services switches inactivetimeswitch 
import achep acdisplay services switches nonotifiesswitch 
import achep acdisplay services switches screenoffswitch 
import achep base appheap 
import achep base content configbase 
import achep base tests check 
import achep base utils power powerutils 
import static achep base build debug 
service that turns acdisplay exactly when needed 
author artem chepurnoy 
achep acdisplay services activemode activemodesensor 
public class activemodeservice extends switchservice implements 
notificationpresenter onnotificationlistchangedlistener activemodesensor callback 
private static final string activemodeservice 
private static final string wake_lock_tag consuming sensors 
private activemodesensor msensors 
private long mconsumingpingtimestamp 
private powermanager wakelock mwakelock 
private final broadcastreceiver mlocalreceiver broadcastreceiver 
override 
public void onreceive context context intent intent 
switch intent getaction 
case action_internal_ping_sensors 
pingconsumingsensors 
break 
private final broadcastreceiver mreceiver broadcastreceiver 
override 
public void onreceive context context intent intent 
switch intent getaction 
case intent action_battery_changed 
mpluggedatomic react powerutils isplugged intent 
break 
private final atomic callback mpluggedatomiccallback atomic callback 
override 
public void onstart object objects 
debug plugged start consuming sensors 
activemodesensor msensors 
check getinstance istrue isattached 
instanceof activemodesensor consuming 
activemodesensor consuming sensor activemodesensor consuming 
sensor start 
override 
public void onstop object objects 
debug unplugged stop consuming sensors 
activemodesensor msensors 
check getinstance istrue isattached 
instanceof activemodesensor consuming 
activemodesensor consuming sensor activemodesensor consuming 
sensor stop 
private final atomic mpluggedatomic atomic mpluggedatomiccallback plugged 
private boolean mactivechargingenabled 
starts stops this service required settings device state 
public static void handlestate nonnull context context 
config config config getinstance 
boolean onlywhilechangingoption config isenabledonlywhilecharging 
powerutils isplugged context 
config isenabled 
config isactivemodeenabled 
onlywhilechangingoption 
bathservice startservice context activemodeservice class 
else 
bathservice stopservice context activemodeservice class 
public static boolean issupported nonnull context context 
sensormanager sensormanager sensormanager context getsystemservice context sensor_service 
return sensormanager getsensorlist sensor type_proximity size 
builds array supported link activemodesensor sensors 
return array supported link activemodesensor sensors 
activemodesensor 
nonnull 
public static activemodesensor buildavailablesensorslist nonnull context context 
sensormanager sensormanager sensormanager context getsystemservice context sensor_service 
activemodesensor sensors activemodesensor available sensors 
accelerometersensor getinstance 
gyroscopesensor getinstance 
proximitysensor getinstance 
count number supported sensors 
mark unsupported 
count sensors length 
boolean supportlist boolean sensors length 
sensors length 
supportlist sensors issupported sensormanager 
supportlist 
count 
create list proven sensors 
activemodesensor sensorssupported activemodesensor count 
sensors length 
supportlist 
sensorssupported sensors 
return sensorssupported 
nonnull 
override 
public switch onbuildswitches 
config config config getinstance 
configbase option nonotifies config getoption config key_active_mode_without_notifications 
configbase option respectit config getoption config key_active_mode_respect_inactive_time 
configbase option batteryout config getoption config key_active_mode_disable_on_low_battery 
return switch 
screenoffswitch getcontext this 
inactivetimeswitch getcontext this respectit 
nonotifiesswitch getcontext this nonotifies true 
batteryoutswitch getcontext this batteryout false 
override 
public void oncreate 
context context getcontext 
msensors buildavailablesensorslist context 
super oncreate 
intentfilter filter intentfilter 
filter addaction action_internal_ping_sensors 
localbroadcastmanager getinstance context registerreceiver mlocalreceiver filter 
notificationpresenter getinstance registerlistener this 
override 
public void ondestroy 
localbroadcastmanager getinstance getcontext unregisterreceiver mlocalreceiver 
notificationpresenter getinstance unregisterlistener this 
super ondestroy 
watch leaks 
appheap getrefwatcher watch this 
override 
public string getlabel 
return getcontext getstring string service_bath_active_mode 
override 
public void onnotificationlistchanged nonnull notificationpresenter 
opennotification osbn 
event boolean islasteventinsequence 
config getinstance isnotifywakingup 
notification will wake device without 
sensors callback 
return 
switch event 
case notificationpresenter event_changed 
case notificationpresenter event_posted 
pingconsumingsensors 
break 
override 
public void onstart object objects 
debug starting listening sensors 
context context getcontext 
sensormanager sensormanager sensormanager context getsystemservice context sensor_service 
activemodesensor sensor msensors 
sensor registercallback this 
sensor onattached sensormanager context 
mactivechargingenabled config getinstance isactivemodeactivechargingenabled 
mactivechargingenabled 
mpluggedatomic react powerutils isplugged context 
intentfilter intentfilter intentfilter 
intentfilter addaction intent action_battery_changed 
context registerreceiver mreceiver intentfilter 
override 
public void onstop object objects 
debug stopping listening sensors 
mactivechargingenabled 
context context getcontext 
context unregisterreceiver mreceiver 
mpluggedatomic stop 
activemodesensor sensor msensors 
sensor ondetached 
sensor unregistercallback this 
releasewakelock 
inheritdoc 
public void pingconsumingsensors 
mconsumingpingtimestamp systemclock elapsedrealtime 
pingconsumingsensorsinternal 
private void pingconsumingsensorsinternal 
find maximum remaining time 
remainingtime 
activemodesensor msensors 
isattached instanceof activemodesensor consuming 
activemodesensor consuming sensor activemodesensor consuming 
remainingtime math remainingtime sensor getremainingtime 
long systemclock elapsedrealtime 
delta mconsumingpingtimestamp 
remainingtime delta 
remainingtime 
return late 
acquire wake lock sure that sensors will fine 
releasewakelock 
powermanager powermanager getcontext getsystemservice context power_service 
mwakelock newwakelock powermanager partial_wake_lock wake_lock_tag 
mwakelock acquire remainingtime 
ping sensors 
activemodesensor msensors 
isattached instanceof activemodesensor consuming 
activemodesensor consuming sensor activemodesensor consuming 
sensorremainingtime sensor getremainingtime delta 
sensorremainingtime 
sensor ping sensorremainingtime 
private void releasewakelock 
mwakelock null mwakelock isheld 
mwakelock release 
mwakelock null 
override 
public void onwakerequested nonnull activemodesensor sensor 
presenter getinstance trystartguicausesensor getcontext 
