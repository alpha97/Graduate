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
import android content context 
import android hardware sensormanager 
import android message 
import android systemclock 
import android support annotation nonnull 
import android support annotation nullable 
import achep acdisplay services activemode sensors proximitysensor 
import achep base async weakhandler 
import java util arraylist 
provides callback when link achep acdisplay activities acdisplayactivity 
should started stopped 
author artem chepurnoy 
public abstract class activemodesensor 
mattachednumber 
private context mcontext 
private sensormanager msensormanager 
private final arraylist callback mcallbacks 
provides callback when acdisplay should shown hidden 
author artem chepurnoy 
public interface callback 
requests show acdisplay 
void onwakerequested nonnull activemodesensor sensor 
protected activemodesensor 
mcallbacks arraylist 
registers given callback listen this sensor 
must call link unregistercallback activemodesensor callback 
later 
unregistercallback activemodesensor callback 
public void registercallback nonnull callback callback 
mcallbacks callback 
unregisters given callback from this sensor 
registercallback activemodesensor callback 
public void unregistercallback nonnull callback callback 
mcallbacks remove callback 
protected void requestwakeup 
callback callback mcallbacks 
callback onwakerequested this 
checks this sensor supported device 
default does following code 
code sensormanager getsensorlist gettype size 
return code true sensor supported device code false otherwise 
public boolean issupported nonnull sensormanager sensormanager 
return sensormanager getsensorlist gettype size 
return type used sensor 
android hardware sensor type_accelerometer 
android hardware sensor type_proximity 
public abstract gettype 
public abstract void onstart nonnull sensormanager sensormanager 
public abstract void onstop 
called when sensor attached main class 
public void onattached nonnull sensormanager sensormanager nonnull context context 
register sensors only once 
mattachednumber 
return 
setup sensormanager context 
onstart sensormanager 
called when sensor detached from main class 
public void ondetached 
mattachednumber 
return 
onstop 
setup null null 
void setup nullable sensormanager sensormanager nullable context context 
mcontext context 
msensormanager sensormanager 
public boolean isattached 
return mattachednumber 
nonnull 
public context getcontext 
return mcontext 
nonnull 
public sensormanager getsensormanager 
return msensormanager 
return code systemclock elapsedrealtime 
protected static long gettimenow 
return systemclock elapsedrealtime 
public abstract static class consuming extends activemodesensor 
private static final string consumingsensor 
static final default_remaining_time 
private static final start 
private static final stop 
private boolean mrunning 
private final mhandler this 
private static class extends weakhandler consuming 
public nonnull consuming object 
super object 
override 
protected void onhandlemassage nonnull consuming message 
mrunning what start return 
switch what 
case start 
mrunning true 
onstart getsensormanager 
break 
case stop 
onstop 
mrunning false 
break 
default 
throw illegalargumentexception 
specifies long sensor should active after receiving 
ping 
return time millis 
default_remaining_time 
public getremainingtime 
return default_remaining_time 
override 
protected void requestwakeup 
allow waking your pocket 
proximitysensor isnear 
return 
super requestwakeup 
inheritdoc 
override 
public void onattached nonnull sensormanager sensormanager nonnull context context 
register sensors only once 
mattachednumber 
return 
setup sensormanager context 
inheritdoc 
override 
public void ondetached 
mattachednumber 
return 

mhandler removecallbacksandmessages null 
mhandler sendemptymessage stop 
setup null null 
public void ping remainingtime 
start 
mhandler removemessages stop 
mhandler sendemptymessagedelayed stop remainingtime 
starts consuming sensor forever 
stop 
public void start 
mhandler sendemptymessage start 
stops consuming sensor 
stop 
public void stop 
mhandler sendemptymessage stop 
