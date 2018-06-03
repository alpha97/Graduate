copyright android open source project 
licensed under apache license version license 
this file except compliance with license 
obtain copy license 
http apache licenses license 
unless required applicable agreed writing software 
distributed under license distributed basis 
without warranties conditions kind either express implied 
license specific language governing permissions 
limitations under license 
package achep base fragments 
import android content intent 
import android bundle 
import android message 
import android preference preference 
import android preference preferencemanager 
import android preference preferencescreen 
import android support annotation nonnull 
import android view keyevent 
import android view layoutinflater 
import android view view 
import android view viewgroup 
import android widget listview 
import achep acdisplay 
import achep base async weakhandler 
import achep base fragments leakcanary leakwatchfragment 
import achep base utils preferencemanagerutils 
import java lang reflect method 
shows hierarchy link android preference preference objects 
lists these preferences will 
automatically save link android content sharedpreferences user interacts with 
them retrieve instance link android content sharedpreferences that 
preference hierarchy this fragment will call 
link android preference preferencemanager getdefaultsharedpreferences android content context 
with context same package this fragment 

furthermore preferences shown will follow visual style system 
preferences easy create hierarchy preferences that 
shown multiple screens these reasons recommended 
this fragment superclass deal with preferences applications 

link android preference preferencescreen object should preference 
hierarchy furthermore subsequent link android preference preferencescreen hierarchy 
denote screen break that preferences contained within subsequent 
link android preference preferencescreen should shown another screen preference 
framework handles showing these other screens from preference hierarchy 

preference hierarchy formed multiple ways 
from file specifying hierarchy 
from different link android activity activities that each specify 
preferences file link android activity meta data 
from object hierarchy rooted with link android preference preferencescreen 

inflate from link addpreferencesfromresource 
root element should link android preference preferencescreen subsequent elements point 
actual link android preference preference subclasses mentioned above subsequent 
link android preference preferencescreen hierarchy will result screen break 

specify link android content intent query link android activity activities that each 
have preferences link addpreferencesfromintent each 
link android activity specify meta data manifest 
link android preference preferencemanager metadata_key_preferences that points 
resource these resources will inflated into single preference 
hierarchy shown this fragment 

specify object hierarchy rooted with link android preference preferencescreen 
link setpreferencescreen android preference preferencescreen 

convenience this fragment implements click listener 
preference current hierarchy 
link onpreferencetreeclick android preference preferencescreen android preference preference 

class special reference 
developer guides 
information about using code preferencefragment 
read href docroot guide topics settings html settings 
guide 


name samplecode 
sample code 

following sample code shows simple preference fragment that 
populated from resource resource loads 

sample development samples apidemos preferences preferences 

fragment implementation itself simply populates preferences 
when created note that preferences framework takes care loading 
current values preferences writing them when changed 

sample development samples apidemos example android apis preference fragmentpreferences java 
fragment 
android preference preference 
android preference preferencescreen 
public abstract class preferencefragmentbase extends leakwatchfragment implements 
preferencemanagerutils onpreferencetreeclicklistener 
private static final string preferences_tag android preferences 
private preferencemanager mpreferencemanager 
private listview mlist 
private boolean mhaveprefs 
private boolean minitdone 
starting request code given preference framework 
private static final first_request_code 
private static final msg_bind_preferences 
private final mhandler this 
private static class extends weakhandler preferencefragmentbase 
public nonnull preferencefragmentbase object 
super object 
override 
protected void onhandlemassage nonnull preferencefragmentbase message 
switch what 
case msg_bind_preferences 
bindpreferences 
break 
final private runnable mrequestfocus runnable 
public void 
mlist focusableviewavailable mlist 
interface that preferencefragment containing activity should 
implement able process preference items that wish 
switch fragment 
public interface onpreferencestartfragmentcallback 
called when user clicked preference that 
fragment class name associated with implementation 
should instantiate switch instance given 
fragment 
boolean onpreferencestartfragment preferencefragmentbase caller preference pref 
override 
public void oncreate bundle savedinstancestate 
super oncreate savedinstancestate 
mpreferencemanager preferencemanagerutils newinstance getactivity first_request_code 
override 
public view oncreateview layoutinflater inflater viewgroup container 
bundle savedinstancestate 
return inflater inflate layout preference_list_fragment container false 
override 
public void onactivitycreated bundle savedinstancestate 
super onactivitycreated savedinstancestate 
mhaveprefs 
bindpreferences 
minitdone true 
savedinstancestate null 
bundle container savedinstancestate getbundle preferences_tag 
container null 
final preferencescreen preferencescreen getpreferencescreen 
preferencescreen null 
preferencescreen restorehierarchystate container 
override 
public void onstart 
super onstart 
preferencemanagerutils setonpreferencetreeclicklistener mpreferencemanager this 
override 
public void onstop 
super onstop 
preferencemanagerutils dispatchactivitystop mpreferencemanager 
preferencemanagerutils setonpreferencetreeclicklistener mpreferencemanager null 
override 
public void ondestroyview 
mlist null 
mhandler removecallbacks mrequestfocus 
mhandler removemessages msg_bind_preferences 
super ondestroyview 
override 
public void ondestroy 
super ondestroy 
preferencemanagerutils dispatchactivitydestroy mpreferencemanager 
override 
public void onsaveinstancestate bundle outstate 
super onsaveinstancestate outstate 
final preferencescreen preferencescreen getpreferencescreen 
preferencescreen null 
bundle container bundle 
preferencescreen savehierarchystate container 
outstate putbundle preferences_tag container 
override 
public void onactivityresult requestcode resultcode intent data 
super onactivityresult requestcode resultcode data 
preferencemanagerutils dispatchactivityresult mpreferencemanager requestcode resultcode data 
returns link android preference preferencemanager used this fragment 
return link android preference preferencemanager 
public preferencemanager getpreferencemanager 
return mpreferencemanager 
sets root preference hierarchy that this fragment showing 
param preferencescreen root link android preference preferencescreen preference hierarchy 
public void setpreferencescreen preferencescreen preferencescreen 
boolean preferencemanagerutils setpreferences mpreferencemanager preferencescreen 
preferencescreen null 
onunbindpreferences 
mhaveprefs true 
minitdone 
postbindpreferences 
gets root preference hierarchy that this fragment showing 
return link android preference preferencescreen that root preference 
hierarchy 
public preferencescreen getpreferencescreen 
return preferencemanagerutils getpreferencescreen mpreferencemanager 
adds preferences from activities that match given link android content intent 
param intent link android content intent query activities 
public void addpreferencesfromintent intent intent 
requirepreferencemanager 
setpreferencescreen preferencemanagerutils inflatefromintent 
mpreferencemanager intent getpreferencescreen 
inflates given resource adds preference hierarchy current 
preference hierarchy 
param preferencesresid resource inflate 
public void addpreferencesfromresource preferencesresid 
requirepreferencemanager 
setpreferencescreen preferencemanagerutils inflatefromresource 
mpreferencemanager getactivity preferencesresid getpreferencescreen 
inheritdoc 
public boolean onpreferencetreeclick preferencescreen preferencescreen 
preference preference 
return preference getfragment null 
getactivity instanceof preferencefragmentbase onpreferencestartfragmentcallback 
preferencefragmentbase onpreferencestartfragmentcallback getactivity 
onpreferencestartfragment this preference 
finds link android preference preference based 
param preference retrieve 
return link android preference preference with null 
android preference preferencegroup findpreference charsequence 
public preference findpreference charsequence 
mpreferencemanager null 
return null 
return mpreferencemanager findpreference 
private void requirepreferencemanager 
mpreferencemanager null 
throw runtimeexception this should called after super oncreate 
private void postbindpreferences 
mhandler hasmessages msg_bind_preferences return 
mhandler obtainmessage msg_bind_preferences sendtotarget 
private void bindpreferences 
final preferencescreen preferencescreen getpreferencescreen 
preferencescreen null 
preferencescreen bind getlistview 
onbindpreferences 
protected void onbindpreferences 
protected void onunbindpreferences 
public listview getlistview 
ensurelist 
return mlist 
private void ensurelist 
mlist null 
return 
view root getview 
root null 
throw illegalstateexception content view created 
view rawlistview root findviewbyid android list 
rawlistview instanceof listview 
throw runtimeexception 
content view with attribute android list 
that listview class 
mlist listview rawlistview 
mlist setonkeylistener mlistonkeylistener 
mhandler post mrequestfocus 
private final view onkeylistener mlistonkeylistener view onkeylistener 
override 
public boolean onkey view keycode keyevent event 
object selecteditem mlist getselecteditem 
selecteditem instanceof preference 
view selectedview mlist getselectedview 
preference pref preference selecteditem 

method method pref getclass getdeclaredmethod onkey 
view class class keyevent class 
method setaccessible true 
return boolean method invoke pref selectedview keycode event 
catch exception ignored unused 
return false 
