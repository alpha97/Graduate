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
import android annotation targetapi 
import android notification 
import android content context 
import android content packagemanager 
import android graphics bitmap 
import android graphics canvas 
import android graphics color 
import android graphics drawable drawable 
import android build 
import android systemclock 
import android service notification statusbarnotification 
import android support annotation nonnull 
import android support annotation nullable 
import android support graphics palette 
import android text textutils 
import android util 
import achep acdisplay config 
import achep acdisplay utils bitmaputils 
import achep base device 
import achep base async asynctask 
import achep base interfaces ionlowmemory 
import achep base interfaces isubscriptable 
import achep base tests check 
import achep base utils operator 
import achep base utils packageutils 
import achep base utils smiley smileyparser 
import java lang weakreference 
import java util arraylist 
import java util list 
import static achep base build debug 
author artem chepurnoy 
public abstract class opennotification implements 
isubscriptable opennotification onnotificationdatachangedlistener 
ionlowmemory 
private static final string opennotification 
targetapi build version_codes jelly_bean_mr 
nonnull 
static opennotification newinstance nonnull statusbarnotification 
notification getnotification 
device haslollipopapi 
return opennotificationlollipop 
else device haskitkatwatchapi 
return opennotificationkitkatwatch 
return opennotificationjellybeanmr 
nonnull 
public static opennotification newinstance nonnull notification 
device hasjellybeanmr 
throw runtimeexception must statusbarnotification 
return opennotificationjellybean 
debug 
only debug purposes 
private final object dfinalizewatcher debug object 
logs notifications removal 
override 
protected void finalize throws throwable 

removing notification recycled isrecycled 
from heap opennotification this 
finally 
super finalize 
null 
begin 
notification visibility show this notification entirety lockscreens 

getvisibility 
public static final visibility_public 
notification visibility show this notification lockscreens conceal sensitive 
private information secure lockscreens 

getvisibility 
public static final visibility_private 
notification visibility reveal part this notification secure lockscreen 

getvisibility 
public static final visibility_secret 
events 
public static final event_icon 
public static final event_read 
public static final event_background 
public static final event_brand_color 
nullable 
private final statusbarnotification mstatusbarnotification 
nonnull 
private final notification mnotification 
nullable 
private action mactions 
private boolean memoticonsenabled 
private boolean mmine 
private boolean mread 
private boolean mrecycled 
private long mloadedtimestamp 
private mnumber 
extracted 
nullable 
public charsequence titlebigtext 
nullable 
public charsequence titletext 
nullable 
public charsequence messagebigtext 
private charsequence messagebigtextorigin 
nullable 
public charsequence messagetext 
private charsequence messagetextorigin 
nullable 
public charsequence messagetextlines 
private charsequence messagetextlinesorigin 
nullable 
public charsequence infotext 
nullable 
public charsequence subtext 
nullable 
public charsequence summarytext 
notification icon 
nullable 
private bitmap miconbitmap 
nullable 
private static weakreference iconfactory siconfactoryref 
private iconfactory miconfactory 
nonnull 
private final iconfactory iconasynclistener miconcallback 
iconfactory iconasynclistener 
override 
public void ongenerated nonnull bitmap bitmap 
miconfactory null 
seticon bitmap 
dynamic background 
nullable 
private bitmap mbackgroundbitmap 
nullable 
private static weakreference iconfactory sbackgroundfactoryref 
private iconfactory mbackgroundfactory 
nonnull 
private final backgroundfactory backgroundasynclistener mbackgroundcallback 
backgroundfactory backgroundasynclistener 
override 
public void ongenerated nonnull bitmap bitmap 
mbackgroundfactory null 
setbackground bitmap 
brand color 
private mbrandcolor color white 
nullable 
private android asynctask bitmap void palette mpaletteworker 
listeners 
nonnull 
private final arraylist onnotificationdatachangedlistener mlisteners arraylist 
protected opennotification nullable statusbarnotification nonnull notification 
mstatusbarnotification 
mnotification 
public void load nonnull context context 
mloadedtimestamp systemclock elapsedrealtime 
mmine textutils equals getpackagename packageutils getname context 
mactions action makefor mnotification 
mnumber mnotification number 
load brand color 
loadbrandcolor context 
load notification icon 
siconfactoryref null miconfactory siconfactoryref null 
siconfactoryref weakreference miconfactory iconfactory 
miconfactory remove this 
miconfactory context this miconcallback 
load other things such title text message text 
more more 
extractor loadtexts context this 
messagetext ensurenotempty messagetext 
messagebigtext ensurenotempty messagebigtext 
messagetextorigin messagetext 
messagebigtextorigin messagebigtext 
messagetextlinesorigin messagetextlines null null messagetextlines clone 
initially load emoticons 
memoticonsenabled 
memoticonsenabled false 
setemoticonsenabled true 
inheritdoc 
override 
public void onlowmemory 
nullable 
private charsequence ensurenotempty nullable charsequence 
return textutils isempty null 
return link android service notification statusbarnotification 
code null 
nullable 
public statusbarnotification getstatusbarnotification 
return mstatusbarnotification 
return link notification supplied 
link android notificationmanager notify notification 
nonnull 
public notification getnotification 
return mnotification 
array link action structures attached this notification 
nullable 
public action getactions 
return mactions 
nullable 
public bitmap getbackground 
return mbackgroundbitmap 
nullable 
public bitmap geticon 
return miconbitmap 
number events that this notification represents example mail 
notification this could number unread messages 

system this field modify appearance notification 
example before link android build version_codes honeycomb this number 
superimposed over icon status starting with 
link android build version_codes honeycomb template used 
link notification builder displayed number expanded notification view 

number negative never shown 
public getnumber 
return mnumber 
sphere visibility this notification which affects when systemui reveals 
notification presence contents untrusted situations namely secure 
lockscreen 

default level link visibility_private behaves exactly notifications have always 
done android notification link geticon available 
shown situations contents only available device unlocked 
appropriate user 

more permissive policy expressed link visibility_public such notification 
read even insecure context that above secure lockscreen 

finally notification made link visibility_secret which will suppress icon 
ticker until user bypassed lockscreen 
public getvisibility 
return visibility_private 
return code true user seen notification 
code false otherwise 
markasread 
setread boolean 
public boolean isread 
return mread 
comparing instances 
inheritdoc 
override 
public string tostring 
return string format opennotification g_key g_summary g_child 
getpackagename getgroupkey isgroupsummary isgroupchild 
inheritdoc 
override 
public abstract hashcode 
inheritdoc 
suppresswarnings equalswhichdoesntcheckparameterclass 
override 
public abstract boolean equals object 
note that method does equals with link equals object method 
param notification compare with 
return code true notifications from same source will 
handled system same notifications code false otherwise 
suppresslint newapi 
suppresswarnings constantconditions 
public abstract boolean hasidenticalids nullable opennotification 
notification data 
interface definition callback invoked 
when date notification changed 
public interface onnotificationdatachangedlistener 
event_background 
event_icon 
event_read 
void onnotificationdatachanged nonnull opennotification notification event 
inheritdoc 
override 
public void registerlistener nonnull onnotificationdatachangedlistener listener 
mlisteners listener 
inheritdoc 
override 
public void unregisterlistener nonnull onnotificationdatachangedlistener listener 
mlisteners remove listener 
notifies listeners about this event 
achep acdisplay notifications opennotification onnotificationdatachangedlistener 
registerlistener achep acdisplay notifications opennotification onnotificationdatachangedlistener 
private void notifylisteners event 
onnotificationdatachangedlistener listener mlisteners 
listener onnotificationdatachanged this event 
private void seticon nullable bitmap bitmap 
miconbitmap miconbitmap bitmap return 
notifylisteners event_icon 
brand color 
protected void setbrandcolor color 
mbrandcolor mbrandcolor color return 
notifylisteners event_brand_color 
protected void loadbrandcolor nonnull context context 

string packagename getpackagename 
drawable appicon 

appicon context getpackagemanager getapplicationicon packagename 
catch outofmemoryerror 
failed application icon outofmemoryerror 
return 
final bitmap bitmap bitmap createbitmap 
appicon getminimumwidth 
appicon getminimumheight 
bitmap config argb_ 
bitmap null 
this happened somewhat strange 
chinese phone 
return 
appicon draw canvas bitmap 
asynctask stop mpaletteworker 
mpaletteworker palette builder bitmap 
maximumcolorcount 
generate palette paletteasynclistener 
override 
public void ongenerated palette palette 
setbrandcolor palette getvibrantcolor color white 
bitmap recycle 
catch packagemanager namenotfoundexception nothing 
public getbrandcolor defaultcolor 
mbrandcolor color black mbrandcolor color white 
return defaultcolor 
return mbrandcolor 
background 
private void setbackground nullable bitmap bitmap 
mbackgroundbitmap mbackgroundbitmap bitmap return 
notifylisteners event_background 
asynchronously generates background notification background 
used link achep acdisplay fragments acdisplayfragment 
clearbackground 
public void loadbackgroundasync 
clear background 
clearbackground 
generate background 
bitmap bitmap mnotification largeicon 
isbackgroundfine bitmap 
sbackgroundfactoryref null mbackgroundfactory sbackgroundfactoryref null 
sbackgroundfactoryref weakreference mbackgroundfactory backgroundfactory 
noinspection constantconditions 
mbackgroundfactory null this mbackgroundcallback 
stops link mbackgroundfactory background loader sets background 
code null 
loadbackgroundasync 
public void clearbackground 
mbackgroundfactory null 
mbackgroundfactory remove this 
mbackgroundfactory null 
setbackground null 
private boolean isbackgroundfine nullable bitmap bitmap 
return bitmap null bitmaputils hastransparentcorners bitmap 
emoticons 
public void setemoticonsenabled boolean enabled 
memoticonsenabled memoticonsenabled enabled return 
reformattexts 
basics 
private void reformattexts 
messagetext reformatmessage messagetextorigin 
messagebigtext reformatmessage messagebigtextorigin 
messagetextlines null 
messagetextlines length 
messagetextlines reformatmessage messagetextlinesorigin 
private charsequence reformatmessage nullable charsequence 
null return null 
memoticonsenabled smileyparser getinstance addsmileyspans 
return 
marks notification read 
setread boolean 
public void markasread 
setread true 
sets state notification 
param isread code true user seen notification 
code false otherwise 
markasread 
void setread boolean isread 
list opennotification list getgroupnotifications 
list null 
opennotification list setread isread 
mread mread isread return 
notifylisteners event_read 
dismisses this notification from system 
notificationutils dismissnotification opennotification 
public void dismiss 
notificationutils dismissnotification this 
performs click notification 
clear real click launching content intent 
return code true succeed code false otherwise 
notificationutils startcontentintent opennotification 
public boolean click 
return notificationutils startcontentintent this 
clears some notification resources 
void recycle 
check getinstance isfalse mrecycled 
mrecycled true 
clearbackground 
asynctask stop mpaletteworker 
miconfactory null 
miconfactory remove this 
miconfactory null 
only debug purposes 
boolean isrecycled 
return mrecycled 
return code true notification been posted from application 
code false otherwise package name 
public boolean ismine 
return mmine 
return code true notification dismissed user code false otherwise 
public boolean isdismissible 
return isclearable 
convenience method check notification flags 
either link notification flag_ongoing_event 
link notification flag_no_clear 
public boolean isclearable 
return operator bitand mnotification flags notification flag_ongoing_event 
operator bitand mnotification flags notification flag_no_clear 
public boolean iscontentsecret nonnull context context 
return notificationutils issecret context this visibility_private 
config privacy_hide_content_mask 
return package name notification random string 
possible package name 
nonnull 
public abstract string getpackagename 
time since notification been loaded link android systemclock elapsedrealtime 
format 
public long getloadtimestamp 
return mloadedtimestamp 
groups 
return that indicates group with which this message ranks 
code null deprecated systems 
getgroupnotifications 
nullable 
public string getgroupkey 
return null 
return list notifications this group without summary 
code null deprecated systems 
isgroupchild 
isgroupsummary 
nullable 
public list opennotification getgroupnotifications 
return null 
return code true this notification child link getgroupkey group 
code false otherwise 
public boolean isgroupchild 
return false 
return code true this notification summary short summary notifications 
link getgroupkey group code false otherwise 
public boolean isgroupsummary 
return false 
