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

package achep acdisplay components 
import android activity 
import android pendingintent 
import android content context 
import android content intent 
import android graphics bitmap 
import android bundle 
import android support annotation nonnull 
import android support annotation nullable 
import android support remoteinput 
import android view layoutinflater 
import android view view 
import android view viewgroup 
import achep acdisplay config 
import achep acdisplay 
import achep acdisplay interfaces inotificatiable 
import achep acdisplay notifications action 
import achep acdisplay notifications notificationutils 
import achep acdisplay notifications opennotification 
import achep acdisplay fragments acdisplayfragment 
import achep acdisplay widgets notification notificationactions 
import achep acdisplay widgets notification notificationiconwidget 
import achep acdisplay widgets notification notificationwidget 
import achep acdisplay utils pendingintentutils 
import achep base tests check 
import apache commons lang builder equalsbuilder 
import apache commons lang builder hashcodebuilder 
created artem 
public class notifywidget extends widget implements 
opennotification onnotificationdatachangedlistener 
inotificatiable 
private notificationiconwidget miconview 
private opennotification mnotification 
private notificationwidget mnotifywidget 
private final notificationwidget callback mwidgetcallback notificationwidget callback 
private acdisplayfragment mfragment getfragment 
override 
public void onriistatechanged nonnull notificationactions boolean shown 
shown mcallback requestwidgetstick notifywidget this 
override 
public void onactionclick nonnull notificationactions 
nonnull view view final nonnull action action 
final pendingintent action intent 
null throw illegalstateexception button should have been disabled 
pendingintentutils isactivity 
mfragment unlock runnable 
override 
public void 
pendingintentutils sendpendingintent 
false unlock carefully 
else pendingintentutils sendpendingintent 
override 
public void onactionclick nonnull notificationactions 
nonnull view view final nonnull action action 
nonnull remoteinput remoteinput 
nonnull charsequence text 
final intent intent intent 
final bundle bundle bundle 
bundle putcharsequence remoteinput getresultkey text 
remoteinput addresultstointent action remoteinputs intent bundle 
mfragment unlock 
runnable 
override 
public void 
todo cancel pending finish sending pending intent 
failed 
pendingintent action intent 
activity activity mfragment getactivity 
pendingintentutils sendpendingintent activity intent 
false 
override 
public void oncontentclick nonnull notificationwidget widget nonnull view 
final opennotification osbn widget getnotification 
check getinstance isnonnull osbn 
mfragment unlock 
runnable 
override 
public void 
osbn click 
false 
public notifywidget nonnull callback callback nonnull acdisplayfragment fragment 
super callback fragment 
inheritdoc 
override 
public hashcode 
return hashcodebuilder 
append miconview 
append mnotification 
append mnotifywidget 
append super hashcode 
tohashcode 
inheritdoc 
override 
public boolean equals object 
this 
return true 
instanceof notifywidget 
return false 
notifywidget widget notifywidget 
return equalsbuilder 
append miconview widget miconview 
append mnotification widget mnotification 
append mnotifywidget widget mnotifywidget 
isequals 
return code true notification dismissed user code false otherwise 
override 
public boolean isdismissible 
return mnotification isdismissible super isdismissible 
override 
public void ondismiss 
mnotification dismiss 
override 
public boolean isreadable 
context context getfragment getactivity 
return mnotification iscontentsecret context 
override 
protected view oncreateiconview 
nonnull layoutinflater inflater 
nonnull viewgroup container 
view view inflater inflate layout notification_icon container false 
assert view null 
miconview notificationiconwidget view 
miconview setnotification mnotification 
return view 
override 
protected viewgroup oncreateview 
nonnull layoutinflater inflater 
nonnull viewgroup container 
nullable viewgroup sceneview 
boolean initialize sceneview null 
initialize 
sceneview viewgroup inflater inflate layout acdisplay_scene_notification container false 
assert sceneview null 
mnotifywidget notificationwidget sceneview findviewbyid notification 
initialize 
return sceneview 
mnotifywidget setcallback mwidgetcallback 
return sceneview 
nonnull 
override 
public opennotification getnotification 
return mnotification 
public boolean hasidenticalids opennotification notification 
return notificationutils hasidenticalids mnotification notification 
override 
public void onviewattached 
super onviewattached 
onviewattachedinternal 
private void onviewattachedinternal 
mnotification markasread 
mnotification registerlistener this 
mnotifywidget setnotification mnotification 
override 
public void onviewdetached 
onviewdetachedinternal 
super onviewdetached 
private void onviewdetachedinternal 
mnotification unregisterlistener this 
override 
public void onnotificationdatachanged nonnull opennotification notification event 
switch event 
case opennotification event_background 
mcallback requestbackgroundupdate this 
break 
override 
public void setnotification opennotification notification 
boolean attached isviewattached 
attached 
check getinstance isnonnull mnotification 
onviewdetachedinternal 
mnotification notification 
miconview setnotification notification 
update content notification widget because 
used relatives 
attached 
onviewattachedinternal 
inheritdoc 
nullable 
override 
public bitmap getbackground 
return mnotification getbackground 
inheritdoc 
override 
public getbackgroundmask 
return config dynamic_bg_notification_mask 
