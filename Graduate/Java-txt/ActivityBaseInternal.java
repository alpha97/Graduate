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

package achep base activities 
import android activity 
import android content context 
import android content intent 
import android bundle 
import android ibinder 
import android support annotation nonnull 
import android support annotation nullable 
import android util 
import android view view 
import achep base appheap 
import achep base interfaces iactivitybase 
import achep base tests check 
import achep base utils power powersavedetector 
import squareup leakcanary refwatcher 
import solovyev android checkout activitycheckout 
import solovyev android checkout checkout 
import java lang reflect method 
import static achep base build debug 
created artem chepurnoy 
final class activitybaseinternal implements iactivitybase 
private static final string activitybaseinternal 
debug 
private static sinstancescount 
only debug purposes 
suppresswarnings fieldcanbelocal constantconditions 
private final object dfinalizewatcher debug object 
logs notifications removal 
override 
protected void finalize throws throwable 

finalizing instance this sinstancescount 
finally 
super finalize 
null 
begin 
private activity mactivity 
private activitycheckout mcheckout 
private powersavedetector mpowersavedetector 
private boolean mcheckoutrequest 
private boolean minputmethodresetrequest 
private boolean mcreated 
public activitybaseinternal 
logs current number activities 
increases count check dfinalizewatcher field 
more information 
debug creating instance this 
watcher dfinalizewatcher 
sinstancescount 
mirrors activity oncreate 
void oncreate activity activity bundle savedinstancestate 
mcheckoutrequest mcheckout checkout foractivity activity appheap getcheckout 
mpowersavedetector powersavedetector newinstance activity 
mactivity activity 
mcreated true 
mirrors activity onstart 
void onstart 
mcheckout null 
appheap getcheckoutinternal requestconnect 
mcheckout start 
mpowersavedetector start 
mirrors activity onstop 
void onstop 
mcheckout null 
mcheckout stop 
appheap getcheckoutinternal requestdisconnect 
mpowersavedetector stop 
mirrors activity ondestroy 
void ondestroy 
mcheckout null 
minputmethodresetrequest performinputmethodservicereset 
watch activity detect possible leaks 
refwatcher refwatcher appheap getrefwatcher 
refwatcher watch this 
requestinputmethodreset 
private void performinputmethodservicereset 
object mactivity getsystemservice context input_method_service 
reflector typedobject windowtoken reflector typedobject 
mactivity getwindow getdecorview getwindowtoken ibinder class 
reflector invokemethodexceptionsafe windowdismissed windowtoken 
reflector typedobject view reflector typedobject null view class 
reflector invokemethodexceptionsafe startgettingwindowfocus view 
mirrors activity onactivityresult 
boolean onactivityresult requestcode resultcode intent data 
return mcheckout null mcheckout onactivityresult requestcode resultcode data 
iactivitybase 
inheritdoc 
override 
public void requestcheckout 
check getinstance isfalse mcheckoutrequest 
check getinstance isfalse mcreated created 
mcheckoutrequest true 
inheritdoc 
override 
public void requestinputmethodreset 
minputmethodresetrequest true 
inheritdoc 
nonnull 
override 
public activity getactivity 
return mactivity 
inheritdoc 
nullable 
override 
public activitycheckout getcheckout 
return mcheckout 
inheritdoc 
nonnull 
override 
public powersavedetector getpowersavedetector 
return mpowersavedetector 
inheritdoc 
override 
public boolean ispowersavemode 
return mpowersavedetector ispowersavemode 
inheritdoc 
override 
public boolean isnotpowersavemode 
return mpowersavedetector isnotpowersavemode 
other 
private static class reflector 
public static final class typedobject 
private final object object 
private final class type 
public typedobject nullable object object nullable class type 
this object object 
this type type 
nullable 
private object getobject 
return object 
nullable 
private class gettype 
return type 
public static void invokemethodexceptionsafe final object methodowner final string method 
final typedobject arguments 
methodowner null return 

final class types 
final object objects 
arguments null 
length arguments length 
types class length 
objects object length 
length 
types arguments gettype 
objects arguments getobject 
else 
types class 
objects object 
final method declaredmethod methodowner getclass getdeclaredmethod method types 
declaredmethod setaccessible true 
declaredmethod invoke methodowner objects 
catch throwable ignored unused 
