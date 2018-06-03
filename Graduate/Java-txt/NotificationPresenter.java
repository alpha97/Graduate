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

package achep acdisplay notifications 
import android annotation suppresslint 
import android notificationmanager 
import android content context 
import android handler 
import android looper 
import android systemclock 
import android service notification statusbarnotification 
import android support annotation nonnull 
import android support annotation nullable 
import android text textutils 
import android util 
import achep acdisplay 
import achep acdisplay config 
import achep acdisplay blacklist appconfig 
import achep acdisplay blacklist blacklist 
import achep base appheap 
import achep base device 
import achep base content configbase 
import achep base interfaces ionlowmemory 
import achep base interfaces isubscriptable 
import achep base tests check 
import achep base utils operator 
import java lang weakreference 
import java util arraylist 
import java util hashset 
import java util iterator 
import java util list 
import java util 
import static achep base build debug 
created artem 
public class notificationpresenter implements 
notificationlist onnotificationlistchangedlistener 
isubscriptable notificationpresenter onnotificationlistchangedlistener 
ionlowmemory 
private static final string notificationpresenter 
private static final string wake_lock_tag notification pool post remove lock 
code true filter noisy flow same notifications 
code false handle notifications updates normally 
private static final boolean filter_noisy_notifications true 
private static final fresh_notification_expiry_time 
public static final flag_silence 
public static final flag_immediately 
public static final event_bath 
public static final event_posted 
public static final event_changed 
public static final event_changed_spam 
public static final event_removed 
nonnull 
public static string geteventname event 
switch event 
case event_posted 
return event_posted 
case event_changed 
return event_changed 
case event_changed_spam 
return event_changed_spam 
case event_removed 
return event_removed 
case event_bath 
return event_bath 
default 
return unknown_value 
private static final result_success 
private static final result_spam 
private static notificationpresenter snotificationpresenter 
private final notificationlist mglist 
private final notificationlist mllist 
private final string mgroupswithsummaries 
private volatile onnotificationpostedlistener mmainlistener 
private final arraylist weakreference onnotificationlistchangedlistener mlistenersrefs 
private final arraylist notificationlistchange mfrozenevents 
private volatile mfreezelevel 
threading 
private final handler mhandler 
private final notificationprproxy mproxy 
private final notificationspamfilter mfilter 
final object monitor object 
handling config blacklist 
private final config mconfig 
private final blacklist mblacklist 
make local 
private final configlistener mconfiglistener 
private final blacklistlistener mblacklistlistener 
listens config update notification list when needed 
private class configlistener implements configbase onconfigchangedlistener 
private volatile mminpriority 
private volatile mmaxpriority 
public configlistener nonnull config config 
mminpriority config getnotifyminpriority 
mmaxpriority config getnotifymaxpriority 
override 
public void onconfigchanged nonnull configbase configbase 
nonnull string 
nonnull object value 
synchronized monitor 
check getinstance isinmainthread 
onconfigchangedsynced value 
public void onconfigchangedsynced nonnull string nonnull object value 
boolean enabled 

switch 
case config key_enabled 
rebuildlocallist 
break 
case config key_notify_min_priority 
value 
handlenotifyprioritychanged mminpriority 
mminpriority 
break 
case config key_notify_max_priority 
value 
handlenotifyprioritychanged mmaxpriority 
mmaxpriority 
break 
case config key_ui_dynamic_background_mode 
enabled operator bitand value config dynamic_bg_notification_mask 
opennotification notification mllist 
enabled 
notification loadbackgroundasync 
else 
notification clearbackground 
break 
case config key_ui_emoticons 
boolean boolean value 
opennotification mglist 
setemoticonsenabled 
break 
private void handlenotifyprioritychanged 




fixme this swapping method doesn work java does work 

final lower higher 
rebuildlocallist rebuildconfirmatory 
override 
public boolean needsrebuild nonnull opennotification 
priority getnotification priority 
return priority lower priority higher 
private class blacklistlistener extends blacklist onblacklistchangedlistener 
override 
public void onblacklistchanged 
nonnull appconfig confignew 
nonnull appconfig configold diff 
boolean hiddennew confignew ishidden 
boolean hiddenold configold ishidden 
boolean nonclearableenablednew confignew isnonclearableenabled 
boolean nonclearableenabledold configold isnonclearableenabled 
check something important changed 
hiddennew hiddenold nonclearableenablednew nonclearableenabledold 
synchronized monitor 
todo check getinstance isinmainthread 
handlepackagevisibilitychanged confignew packagename 
private void handlepackagevisibilitychanged nonnull final string packagename 
rebuildlocallist rebuildconfirmatory 
override 
public boolean needsrebuild nonnull opennotification 
return getpackagename equals packagename 
private interface rebuildconfirmatory 
boolean needsrebuild nonnull opennotification 
private void rebuildlocallist nonnull rebuildconfirmatory rebuildconfirmatory 
opennotification mglist 
rebuildconfirmatory needsrebuild 
rebuildlocallist 
break 
listeners 
public interface onnotificationlistchangedlistener 
callback that list notifications changed 
param instance notification must null 
event link event_bath code null otherwise 
param event event type 
link event_posted link event_removed 
link event_changed link event_changed_spam 
link event_bath 
param islasteventinsequence code true this last bath changes code false 
otherwise 
void onnotificationlistchanged nonnull notificationpresenter 
opennotification event 
boolean islasteventinsequence 
inheritdoc 
override 
public void registerlistener nonnull onnotificationlistchangedlistener listener 
make sure register listener only once 
weakreference onnotificationlistchangedlistener mlistenersrefs 
listener 
tried register already registered listener 
return 
cleandeadlisteners 
mlistenersrefs weakreference listener 
inheritdoc 
override 
public void unregisterlistener nonnull onnotificationlistchangedlistener listener 
weakreference onnotificationlistchangedlistener mlistenersrefs 
listener 
mlistenersrefs remove 
return 
tried unregister existent listener 
ideally this method whole weakness thing should needed 
private void cleandeadlisteners 
iterator weakreference onnotificationlistchangedlistener mlistenersrefs iterator 
while hasnext 
weakreference next 
null 
removing dead listener 
remove 
author artem chepurnoy 
public interface onnotificationpostedlistener 
postnotificationfrommain android content context opennotification 
postnotification android content context opennotification 
void onnotificationposted nonnull context context nonnull opennotification flags 
registerlistener onnotificationlistchangedlistener 
unregisterlistener onnotificationlistchangedlistener 
public void setonnotificationpostedlistener nullable onnotificationpostedlistener listener 
mmainlistener listener 
main 
private notificationpresenter 
mfrozenevents arraylist 
mlistenersrefs arraylist 
mglist notificationlist notificationlist onnotificationlistchangedlistener 
override 
public onnotificationadded nonnull opennotification 
return notificationlist result_default 
override 
public onnotificationchanged 
nonnull opennotification 
nonnull opennotification 
isgroupsummary isgroupsummary 
copy paste children from notification 

list opennotification children getgroupnotifications 
list opennotification aged getgroupnotifications 
assert children null 
assert aged null 
check getinstance istrue children isempty 
children addall aged 
return notificationlist result_default 
override 
public onnotificationremoved nonnull opennotification 
return notificationlist result_default 
mllist notificationlist this 
mgroupswithsummaries hashset 
mhandler handler looper getmainlooper 
mproxy notificationprproxy this looper getmainlooper 
mfilter notificationspamfilter 
device hasjellybeanmr version 
mglist setmaximumsize 
mllist setmaximumsize 
mconfig config getinstance 
mconfiglistener configlistener mconfig because weak listeners 
mconfig registerlistener mconfiglistener 
mblacklistlistener blacklistlistener 
mblacklist blacklist getinstance 
mblacklist registerlistener mblacklistlistener 
nonnull 
public synchronized static notificationpresenter getinstance 
snotificationpresenter null 
snotificationpresenter notificationpresenter 
return snotificationpresenter 
inheritdoc 
override 
public void onlowmemory 
mglist onlowmemory does cover local list notifications 
public void postnotificationfrommain 
nonnull final context context 
nonnull final opennotification final flags 
mfilter postnotification isvalid 
todo implement basic spam filter 
return 
mproxy postnotification context flags 
posts notification global list notifies every follower 
about this change tries launch 
link achep acdisplay activities acdisplayactivity 

create link opennotification 
link opennotification newinstance statusbarnotification 
link opennotification newinstance android notification 
method 

flag_silence 
void postnotification 
nonnull context context 
nonnull opennotification flags 
synchronized monitor 
check getinstance isinmainthread 
mproxy onposted 
check test notification 
isinitnotification context 
notificationutils dismissnotification 
with another just sure 
string name context notification_service 
notificationmanager notificationmanager context getsystemservice name 
cancel id_notify_init 
return 
freezelisteners 
boolean globalvalid isvalidforglobal 
boolean localvalid false 
boolean groupchild false 
notification will added 
list there point loading data 
globalvalid 
load context 
isgroupsummary 
string groupkey getgroupkey 
assert groupkey null 
noinspection statementwithemptybody 
mgroupswithsummaries contains groupkey 
group children summary 
notification 
mglist size 
opennotification mglist 
groupkey equals getgroupkey 
isgroupchild 
assert getgroupnotifications null 
getgroupnotifications 
remove this notification from global list 
mglist removenotification 
mllist removenotification 
else 
that ideally this will never happen 

removenotification 
else 
group children summary 
notification 
mglist size 
opennotification mglist 
groupkey equals getgroupkey 
isgroupchild 
assert getgroupnotifications null 
getgroupnotifications 
remove this notification from global list 
mglist removenotification 
mllist removenotification 
else 
that ideally this will never happen 
removenotification 
mgroupswithsummaries groupkey 
else isgroupchild mgroupswithsummaries contains getgroupkey 
artem chepurnoy sure this happen 
debug adding notification existent group 
string groupkey getgroupkey 
assert groupkey null 
opennotification mglist 
groupkey equals getgroupkey isgroupsummary 
groupchild true 
assert getgroupnotifications null 
notificationlist getgroupnotifications pushnotification 
notifylisteners event_changed 
break 
groupchild 
failed find summary this group although 
indicating presence this possible happen 
optimization list pending events 
mgroupswithsummaries remove groupkey 
debug removed lost group from group groupkey 
config config config getinstance 
setemoticonsenabled config isemoticonsenabled 
groupchild 
globalvalid false 
assume that localvalid 
false here 
else 
localvalid isvalidforlocal 
device hasjellybeanmr globalvalid localvalid 
mglist pushorremovenotification globalvalid 
result mllist pushorremovenotification localvalid 
localvalid result result_success mmainlistener null 
debug notification posted notifying main listener 
mmainlistener onnotificationposted context flags 
release listeners send pending 
events 
operator bitand flags flag_silence mfrozenevents clear 
meltlisteners 
public void removenotificationfrommain final nonnull opennotification final flags 
mproxy removenotification flags 
removes notification from presenter sends 
this event followers calling method will 
remove notification from system 
public void removenotification nonnull opennotification final flags 
synchronized monitor 
check getinstance isinmainthread 
mproxy onremoved 
update summary group notifications 
handlenotificationremoval 
notificationlist list mglist 
list indexofnotification 

recycle 
list remove 
mllist removenotification 
watch memory leaks 
appheap getrefwatcher watch 
private void handlenotificationremoval nonnull opennotification 
isgroupsummary 
string groupkey getgroupkey 
assert groupkey null 
mgroupswithsummaries remove groupkey 
else isgroupchild mgroupswithsummaries contains getgroupkey 
string groupkey getgroupkey 
assert groupkey null 
opennotification mglist 
groupkey equals getgroupkey 
check getinstance istrue isgroupsummary 
assert getgroupnotifications null 
notificationlist list notificationlist getgroupnotifications 
list indexofnotification 

recycle 
list remove 
watch memory leaks 
appheap getrefwatcher watch 
return 
failed find summary this group although 
indicating presence this possible happen 
optimization list pending events 
mgroupswithsummaries remove groupkey 
debug removed lost group from group groupkey 
validates notifications from link mglist global list 
sends link event_bath bath event after 
isvalidforlocal opennotification 
isvalidforglobal opennotification 
must synced monitor 
private void rebuildlocallist 
freezelisteners 
remove valid notifications 
from local list 
mllist size 
opennotification mllist 
isvalidforlocal mllist removenotification 
newly valid notifications local list 
opennotification mglist 
isvalidforlocal mllist pushnotification false 
meltlisteners 
nullable 
public opennotification getfreshnotification 
synchronized monitor 
opennotification getlist 
long delta math getnotification priority fresh_notification_expiry_time 
long past systemclock elapsedrealtime delta 
isread getloadtimestamp past return 
return null 
nonnull 
public arraylist opennotification getlist 
synchronized monitor 
return mllist 
return number notifications link getlist local list 
isempty 
public size 
synchronized monitor 
return mllist size 
return code true link getlist local list contains notifications 
code false otherwise 
size 
public boolean isempty 
synchronized monitor 
return mllist isempty 
local list events 
inheritdoc 
override 
enter point should synchronized 
public onnotificationadded nonnull opennotification 
check getinstance isfalse isrecycled 
loadnotificationbackground 
notifylisteners event_posted 
return result_success 
inheritdoc 
override 
enter point should synchronized 
public onnotificationchanged nonnull opennotification nonnull opennotification 
check getinstance isfalse isrecycled 
loadnotificationbackground 
clearbackground 
prevent damn notification spam 
checking texts equality 
example notification spammer well known 
downloadprovider seriously google 
getnumber getnumber 
textutils equals titletext titletext 
textutils equals titlebigtext titlebigtext 
textutils equals messagetext messagetext 
textutils equals infotext infotext 
ismine dumb 
technically notification changed fault 
dumb developer mark notification read 
setread isread 
notifylisteners event_changed_spam 
return result_spam wake 
notifylisteners event_changed 
return result_success 
inheritdoc 
override 
enter point should synchronized 
public onnotificationremoved nonnull opennotification 
notifylisteners event_removed 
have recycle notification here cause 
should recycled removing from global list otherwise 
unexpected behaviour when this notification will 
added back local list 
isrecycled 
clearbackground 
isempty 
clean static cache 
debug cleaning cache 
notificationuihelper sappiconcache clear 
return result_success 
private void loadnotificationbackground nonnull opennotification notification 
config config config getinstance 
selective load exactly what need nothing more 
this will reduce consumption 
operator bitand 
config getdynamicbackgroundmode 
config dynamic_bg_notification_mask 
notification loadbackgroundasync 
notification utils 
suppresslint newapi 
public boolean istestnotification nonnull context context nonnull opennotification 
statusbarnotification getstatusbarnotification 
return ismine null getid id_notify_test 
suppresslint newapi 
public boolean isinitnotification nonnull context context nonnull opennotification 
statusbarnotification getstatusbarnotification 
return ismine null getid id_notify_init 
freezes listeners notification process 
stores events list 
meltlisteners 
private void freezelisteners 
mfreezelevel 
unfreezes events sends them 
freezelisteners 
private void meltlisteners 
check getinstance istrue mfreezelevel 
mfreezelevel 
notifylisteners mfrozenevents 
mfrozenevents clear 
private void notifylisteners nullable opennotification event 
notifylisteners event true 
private void notifylisteners nullable opennotification event 
boolean islasteventinsequence 
check getinstance isinmainthread 
mfreezelevel 
mfrozenevents size mfrozenevents event event_bath return 
event event_bath mfrozenevents clear 
mfrozenevents notificationlistchange event 
return 
mlistenersrefs size 
weakreference onnotificationlistchangedlistener mlistenersrefs 
onnotificationlistchangedlistener 
null 
there were links this listener except 
class 
deleting unused listener 
mlistenersrefs remove 
else 
onnotificationlistchanged this event islasteventinsequence 
private void notifylisteners nonnull arraylist notificationlistchange changes 
size changes size 
size 
notificationlistchange change changes 
notifylisteners change notification change event size 
return code true notification shown user 
code false otherwise 
private boolean isvalidforlocal nonnull opennotification notification 
mconfig isenabled 
return false 
appconfig config mblacklist getappconfig notification getpackagename 
config ishidden 
display notifications from this 
return false 
notification isclearable config isnonclearableenabled 
display clearable notification 
return false 
notification getnotification priority mconfig getnotifyminpriority 
display priority notification 
return false 
notification getnotification priority mconfig getnotifymaxpriority 
display high priority notification 
return false 
allow notifications with content 
return textutils isempty notification titletext 
textutils isempty notification titlebigtext 
textutils isempty notification messagetext 
textutils isempty notification messagebigtext 
notification messagetextlines null 
here filter completely wrong 
notifications 
suppresslint newapi 
private boolean isvalidforglobal nonnull opennotification notification 
return true 
initializing 
void init final nonnull context context 
final nonnull statusbarnotification activenotifications 
mhandler post runnable 
suppresslint newapi 
override 
public void 
clear false 
debug initializing notifications list 
initialize notifications list through proxy 
optimize process this completely useful 
lollipop devices lack children notifications 
list notificationprtask list arraylist activenotifications length 
statusbarnotification activenotifications 
opennotification opennotification newinstance 
list notificationprtask context true post 
device haslollipopapi mproxy optimizeprtasks list 
mproxy sendprtasks list 
list clear this probably needed 
void clearfrommain final boolean notifylisteners 
mhandler post runnable 
suppresslint newapi 
override 
public void 
clear notifylisteners 
void clear final boolean notifylisteners 
synchronized monitor 
check getinstance isinmainthread 
debug clearing notifications list notify_listeners 
notifylisteners 
mproxy onclear 
mgroupswithsummaries clear 
mglist clear 
mllist clear 
notifylisteners notifylisteners null event_bath 
