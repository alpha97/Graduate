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

package achep acdisplay fragments 
import android animation animator 
import android animation animatorlisteneradapter 
import android animation objectanimator 
import android annotation suppresslint 
import android activity 
import android content context 
import android content resources 
import android bundle 
import android handler 
import android message 
import android systemclock 
import android support annotation nonnull 
import android support annotation nullable 
import android transition changebounds 
import android transition fade 
import android transition scene 
import android transition transition 
import android transition transitionmanager 
import android transition transitionset 
import android util 
import android util property 
import android view gesturedetector 
import android view hapticfeedbackconstants 
import android view layoutinflater 
import android view motionevent 
import android view velocitytracker 
import android view view 
import android view viewconfiguration 
import android view viewgroup 
import android view windowmanager 
import android view animation accelerateinterpolator 
import android widget gridlayout 
import android widget imageview 
import android widget progressbar 
import achep acdisplay config 
import achep acdisplay 
import achep acdisplay timeout 
import achep acdisplay compat scenecompat 
import achep acdisplay notifications notificationpresenter 
import achep acdisplay notifications notificationutils 
import achep acdisplay notifications opennotification 
import achep acdisplay services media mediacontroller 
import achep acdisplay services media mediacontrolshelper 
import achep acdisplay cornerhelper 
import achep acdisplay dynamicbackground 
import achep acdisplay activities acdisplayactivity 
import achep acdisplay components clockwidget 
import achep acdisplay components hostwidget 
import achep acdisplay components mediawidget 
import achep acdisplay components notifywidget 
import achep acdisplay components widget 
import achep acdisplay view forwardinglayout 
import achep acdisplay view forwardinglistener 
import achep acdisplay widgets circleview 
import achep base device 
import achep base async weakhandler 
import achep base content configbase 
import achep base tests check 
import achep base activities activitybase 
import achep base fragments leakcanary leakwatchfragment 
import achep base widgets textview 
import achep base utils floatproperty 
import achep base utils mathutils 
import achep base utils viewutils 
import java lang reflect invocationtargetexception 
import java lang reflect method 
import java util arraylist 
import java util hashmap 
import static achep base build debug 
this main fragment activedisplay 
todo main scene inside widget 
public class acdisplayfragment extends leakwatchfragment implements 
notificationpresenter onnotificationlistchangedlistener 
forwardinglayout onforwardedeventlistener 
view ontouchlistener 
widget callback 
configbase onconfigchangedlistener 
circleview callback 
private static final string acdisplayfragment 
private static final msg_show_home_widget 
private static final msg_hide_media_widget 
private static final property acdisplayfragment float transform 
floatproperty acdisplayfragment populatestdanimation 
private float mvalue 
override 
public void setvalue acdisplayfragment fragment float value 
fragment populatestdanimation mvalue value 
override 
public float acdisplayfragment fragment 
return mvalue 
views 
private circleview mcircleview 
private textview mstatusclocktextview 
private progressbar mprogressbar 
private viewgroup mdividerview 
private forwardinglayout mscenecontainer 
private forwardinglayout miconsforwarder 
private gridlayout miconscontainer 
main 
private activitybase mactivity 
private acdisplayactivity mactivityacd 
private final hashmap view widget mwidgetsmap hashmap 
private final hashmap string scenecompat mscenesmap hashmap 
private scenecompat mcurrentscene 
private widget mselectedwidget 
private view mpressediconview 
private boolean mhaspinnedwidget 
private forwardinglistener msceneforwardinglistener 
private forwardinglistener miconsforwardinglistener 
private final handler mtouchhandler handler 
private boolean mtouchsticky 
private mconfigwidgetpinduration 
private mconfigwidgetselectdelay 
quick glance 
private mnotificationhashglanced 
private long mnotificationhashtime 
animations transitions 
private transitionset mtransitionjit 
private transition mtransitionswitchscene 
private objectanimator mstdanimator 
clock widget 
private scenecompat mscenemainclock 
private widget mclockwidget 
media widget 
private scenecompat mscenemainmedia 
private mediacontrolshelper mmediacontrolshelper 
private mediawidget mmediawidget 
private boolean mmediawidgetactive 
timeout 
private timeout mtimeoutgui 
private timeout mtimeout 
private mtimeoutnormal 
private mtimeoutshort 
swipe dismiss 
private velocitytracker mvelocitytracker 
private mmaxflingvelocity 
private mminflingvelocity 
dynamic background 
private dynamicbackground mbackground 
handler control delayed events 
msg_hide_media_widget 
msg_show_home_widget 
private final handler mhandler this 
private boolean mpendingiconssizechange 
private boolean mpendingnotifychange 
private boolean mresuming 
private boolean ispinnable 
return getconfig iswidgetpinnable 
private boolean isreadable 
return getconfig iswidgetreadable 
unlocks keyguard runs link runnable runnable when unlocked 
param finish code true finish activity code false keep 
achep acdisplay activities keyguardactivity 
public void unlock runnable runnable boolean finish 
isnotdemo 
runnable null runnable 
return 
mactivityacd unlock runnable finish 
public config getconfig 
return config getinstance 
override 
public void onattach activity activity 
super onattach activity 
mactivity activitybase activity 
mactivityacd isnotdemo acdisplayactivity activity null 
override 
public void oncreate bundle savedinstancestate 
super oncreate savedinstancestate 
resources getresources 
mconfigwidgetpinduration getinteger integer config_maxpintime 
mconfigwidgetselectdelay getinteger integer config_iconselectdelaymillis 
viewconfiguration viewconfiguration getactivity 
mmaxflingvelocity getscaledmaximumflingvelocity 
mminflingvelocity getscaledminimumflingvelocity 
clock widget 
mclockwidget getconfig iscustomwidgetenabled 
hostwidget this this 
clockwidget this this 
media widget 
mediacontroller mediacontroller newinstance getactivity asyncwrap 
mmediacontrolshelper mediacontrolshelper 
mmediacontrolshelper registerlistener mediacontrolshelper callback 
override 
public void onstatechanged boolean showing 
showing 
makemediawidgetactive 
else makemediawidgetinactive 
mmediawidget mediawidget this this 
transitions 
device haskitkatapi 
mtransitionjit transitionset 
setordering transitionset ordering_together 
addtransition fade 
addtransition changebounds 
mtransitionswitchscene transitionset 
setordering transitionset ordering_together 
addtransition fade fade setduration 
addtransition fade fade setstartdelay 
addtransition changebounds setstartdelay 
timeout 
mtimeout isnotdemo 
mactivityacd gettimeout 
timeout 
override 
public view oncreateview layoutinflater inflater viewgroup container bundle savedinstancestate 
debug creating view 
view root inflater inflate isnotdemo 
layout acdisplay_fragment_full 
layout acdisplay_fragment container false 
assert root null 
initialize secondary views 
mstatusclocktextview textview root findviewbyid clock_small 
mcircleview circleview root findviewbyid circle 
mbackground dynamicbackground newinstance this 
imageview root findviewbyid background 
initialize main views 
view root findviewbyid container 
mdividerview viewgroup findviewbyid divider 
mprogressbar progressbar mdividerview findviewbyid progress 
mscenecontainer forwardinglayout findviewbyid scene 
miconsforwarder forwardinglayout findviewbyid forwarding 
miconscontainer gridlayout findviewbyid grid 
initialize home widgets 
mscenemainclock scenecompat mscenecontainer mclockwidget 
createview inflater mscenecontainer null 
mscenemainmedia scenecompat mscenecontainer mmediawidget 
createview inflater mscenecontainer null 
return root 
override 
public void onviewcreated view view bundle savedinstancestate 
super onviewcreated view savedinstancestate 
debug creating view created 
msceneforwardinglistener forwardinglistener miconsforwarder false mscenecontainer 
miconsforwardinglistener forwardinglistener miconsforwarder true miconsforwarder 
miconsforwarder setonforwardedeventlistener this 
miconsforwarder setallviewsforwardable true touch depth 
miconsforwarder setontouchlistener this 
isnotdemo 
init timeout 
mtimeoutgui timeout mprogressbar 
mtimeout registerlistener mtimeoutgui 
init touch forwarding 
view ontouchlistener listener touchforwarder getactivity mcircleview mactivityacd 
view setontouchlistener listener 
mcircleview setcallback this 
mcircleview setsupervisor circleview supervisor 
override 
public boolean isanimationenabled 
return isanimatable 
override 
public boolean isanimationunlockenabled 
return isanimationenabled getconfig isunlockanimationenabled 
override 
public void onactivitycreated bundle savedinstancestate 
super onactivitycreated savedinstancestate 
showwidget mclockwidget false 
override 
public void onstart 
super onstart 
notificationpresenter getinstance registerlistener this 
getconfig registerlistener this 
mpendingnotifychange true 
mpendingiconssizechange true 
override 
public void onresume 
super onresume 
mresuming true 
start available widgets 
widget widget mwidgetsmap values widget start 
mclockwidget start 
mmediawidget start 
update notifications list config 
mpendingnotifychange rebuildnotifications 
mpendingiconssizechange updateiconssize 
updatetimeouts 
mpendingnotifychange false 
mpendingiconssizechange false 
media controller 
mmediacontrolshelper start 
show notification that cause acdisplay being shown this 
allows user that damn notification time 
isnotdemo getconfig isnotifyglanceenabled 
long systemclock elapsedrealtime 
hash mactivityacd getcause 
hash hash mnotificationhashglanced mnotificationhashtime 
find appropriate notification widget 
widget widget mwidgetsmap values 
widget instanceof notifywidget 
notifywidget notifywidget widget 
opennotification getnotification 
null hashcode hash 
mnotificationhashglanced hash 
iscontentsecret getactivity 
show appropriate widget 
debug doing quick glance 
showwidget widget 
onwidgetpin widget 
otherwise there nothing helpful show 
break 
avoid issue when onresume being called 
twice 
mnotificationhashtime 
logs 
mnotificationhashglanced hash 
mnotificationhashglanced hash 
glance notification shown 
mresuming false 
override 
public void onpause 
back home widget 
showwidget mclockwidget false 
clear ongoing events such handling media widget 
handing pinned widget handing touch delay 
mmediawidgetactive false 
mhandler removecallbacksandmessages null 
mtouchhandler removecallbacksandmessages null 
stop widgets 
widget widget mwidgetsmap values widget stop 
mclockwidget stop 
mmediawidget stop 
media controller 
mmediacontrolshelper stop 
super onpause 
override 
public void onstop 
unregister everything 
notificationpresenter getinstance unregisterlistener this 
getconfig unregisterlistener this 
super onstop 
override 
public void ondestroyview 
debug destroying view 
isnotdemo 
mtimeout unregisterlistener mtimeoutgui 
super ondestroyview 
config 
inheritdoc 
override 
public void onconfigchanged nonnull configbase config 
nonnull string 
nonnull object value 
switch 
case config key_ui_icon_size 
updateiconssize 
break 
case config key_timeout_normal 
mtimeoutnormal value 
break 
case config key_timeout_short 
mtimeoutshort value 
break 
private void updatetimeouts 
mtimeoutnormal getconfig gettimeoutnormal 
mtimeoutshort getconfig gettimeoutshort 
updates size widget icons 
link achep acdisplay config geticonsizepx config 
private void updateiconssize 
isresumed 
mpendingiconssizechange true 
return 
final sizepx getconfig geticonsizepx 
final childcount miconscontainer getchildcount 
childcount 
view child miconscontainer getchildat 
viewutils setsize child sizepx 
timeout 
override 
public void requesttimeoutrestart nonnull widget widget 
check getinstance istrue iscurrentwidget widget 
mtimeout settimeoutdelayed mtimeoutnormal true 
touch handling 
override 
public void oncircleevent float radius float ratio event final actionid 
switch event 
case circleview action_start 
mhaspinnedwidget 
showhomewidget 
mtimeout settimeoutdelayed mtimeoutshort 
mtimeout pause 
break 
case circleview action_unlock_start 
mactivityacd getwindow addflags windowmanager layoutparams flag_dismiss_keyguard 
break 
case circleview action_unlock_cancel 
mactivityacd getwindow clearflags windowmanager layoutparams flag_dismiss_keyguard 
break 
case circleview action_unlock 
mactivityacd unlock runnable 
override 
public void 
context context getactivity 
assert context null 
cornerhelper perform context actionid 
case circleview action_canceled 
clear pinned widget short emulator 
probably something real life 
mhaspinnedwidget showhomewidget 
mtimeout resume 
delta mtimeout getremainingtime 
delta 
mtimeout delay delta 
break 
override 
public void onpressedview motionevent event activepointerid view view 
mtouchhandler removecallbacksandmessages null 
mpressediconview view 
view null 
return 
final widget widget findwidgetbyicon view 
iscurrentwidget widget 
need reset this cause current widget 
pinned 
mhandler removemessages msg_show_home_widget 
return 
else widget null mselectedwidget ishomewidget 
return 
action event getactionmasked 
delay action motionevent action_down mconfigwidgetselectdelay 
mtouchhandler postdelayed runnable 
override 
public void 
widget null 
showhomewidget 
else 
showwidget widget 
delay 
override 
public boolean ontouch view motionevent event 
miconsforwarder 
msceneforwardinglistener ontouch event 
miconsforwardinglistener ontouch event 
return true 
return false 
override 
public void onforwardedevent motionevent event activepointerid 
action event getactionmasked 
switch action 
case motionevent action_down 
track velocity movement 
swipe dismiss 
mvelocitytracker velocitytracker obtain 
mtouchsticky false 
case motionevent action_move 
case motionevent action_up 
populatestdmotion event 
action motionevent action_up 
return fall down 
boolean dismissing swipetodismiss 
dismissing 
mtouchsticky 
disable default timeout mechanism 
selected widget stay while 
onwidgetstick mselectedwidget 
else mpressediconview null ispinnable 
showhomewidget 
else 
onwidgetpin mselectedwidget 
case motionevent action_cancel 
mtouchhandler removecallbacksandmessages null 
mvelocitytracker recycle 
mvelocitytracker null 
mtouchsticky false 
action motionevent action_cancel 
showhomewidget 
break 
override 
public void requestwidgetstick nonnull widget widget 
check getinstance istrue iscurrentwidget widget 
mtouchsticky true 
swipe dismiss 
private boolean swipetodismiss 
isdismissible mselectedwidget return false 
mvelocitytracker computecurrentvelocity 
float velocityx mvelocitytracker getxvelocity 
float velocityy mvelocitytracker getyvelocity 
float absvelocityx math velocityx 
float absvelocityy math velocityy 
float deltay mscenecontainer gettranslationy 
float absdeltay math deltay 
height getsceneview getheight 
height 
scene view measured 
return false 
else absdeltay height 
boolean dismiss false 
mminflingvelocity absvelocityy 
absvelocityy mmaxflingvelocity 
absvelocityy absvelocityx 
absdeltay height 
dismiss only flinging same direction dragging 
dismiss velocityy deltay 
dismiss 
return false 

dismiss 

height absdeltay isanimatable 
duration 
duration math round height absdeltay absvelocityx 
duration math duration 
final widget widget mselectedwidget 
float progress mathutils range deltay height 
mstdanimator null mstdanimator cancel 
mstdanimator objectanimator offloat this transform progress 
mstdanimator setduration duration 
mstdanimator addlistener animatorlisteneradapter 
inheritdoc 
override 
public void onanimationend animator animation 
super onanimationend animation 
onwidgetdismiss widget 
override 
public void onanimationcancel animator animation 
super onanimationcancel animation 
onwidgetdismiss widget 
mstdanimator start 
else 
onwidgetdismiss mselectedwidget 
return true 
private void populatestdmotion nonnull motionevent srcevent 
track current movement able handle 
flings correctly 
motionevent dstevent motionevent obtainnohistory srcevent 
mvelocitytracker addmovement motionevent obtainnohistory srcevent 
dstevent recycle 
need handle swipe dismiss 
widget dismissible 
isdismissible mselectedwidget 
return 
final float srcevent gety miconscontainer getheight 

mscenecontainer gettranslationy 
resetscenecontainerparams 
return 
populate current animation 
float height getsceneview getheight 
float progress mathutils range height 
populatestdanimation progress 
private void populatestdanimation float progress 
float height getsceneview getheight 
float height progress 
double degrees math todegrees math acos height height 
mscenecontainer setalpha progress 
mscenecontainer settranslationy 
mscenecontainer setrotationx float degrees 
managing widgets 
resets link mscenecontainer scene container params such 
animation alpha level translation rotation 
private void resetscenecontainerparams 
mstdanimator null mstdanimator cancel 
mscenecontainer setalpha 
mscenecontainer settranslationy 
mscenecontainer setrotationx 
return code true current widget equals given code false otherwise 
protected final boolean iscurrentwidget widget widget 
return widget mselectedwidget 
return code true widget code null 
link widget isdismissible dismissible code false otherwise 
public final boolean isdismissible nullable widget widget 
return widget null widget isdismissible 
return view link mcurrentscene current scene 
nonnull 
private view getsceneview 
return mcurrentscene getview 
nullable 
private scenecompat findscenebywidget nonnull widget widget 
widget mmediawidget 
return mscenemainmedia 
else widget mclockwidget 
return mscenemainclock 
else widget getview null 
string classname widget getclass getname 
return mscenesmap classname 
return null 
private widget findwidgetbyicon nonnull view view 
return mwidgetsmap view 
displaying widgets 
public void showhomewidget 
showhomewidget true 
public void showhomewidget boolean animate 
widget widget ismediawidgethome 
mmediawidget 
mclockwidget 
showwidget widget animate 
showwidget achep acdisplay components widget boolean 
protected void showwidget nonnull widget widget 
showwidget widget true 
showwidget achep acdisplay components widget 
protected void showwidget nonnull widget widget boolean animate 
mhandler removemessages msg_show_home_widget 
mhaspinnedwidget false 
showing widget widget 
view iconview 
mselectedwidget null 
iconview mselectedwidget geticonview 
iconview null 
iconview setselected false 
mselectedwidget onviewdetached 
mselectedwidget widget 
resetscenecontainerparams 
animate isanimatableauto 
scenecompat scene findscenebywidget mselectedwidget 
scene null scene mscenemainclock 
mcurrentscene scene 
goscene scene animate 
else animate 
final viewgroup viewgroup mselectedwidget getview 
maybebegindelayedtransition viewgroup mtransitionjit 
mselectedwidget onviewattached 
mbackground dispatchsetbackground 
mselectedwidget getbackground 
mselectedwidget getbackgroundmask 
updatestatusclockvisibility mselectedwidget hasclock getconfig isfullscreen 
iconview mselectedwidget geticonview 
iconview null 
iconview setselected true 
iconview performhapticfeedback hapticfeedbackconstants virtual_key 
isresumed 
return 
start timeout main media widgets 
pause otherwise 
widget ishomewidget 
mtimeout resume 
else 
mtimeout settimeoutdelayed mtimeoutnormal true 
mtimeout pause 
updates visibility status clock appears above screen 
private void updatestatusclockvisibility boolean visiblenow 
mstatusclocktextview null 
return 
view view mstatusclocktextview 
boolean visible view getvisibility view visible 
visible visiblenow return 
isanimatable 
final float values 
visiblenow 
values float 



view setvisibility view visible 
view animate setlistener null 
else 
values float 



view animate setlistener animatorlisteneradapter 
override 
public void onanimationend animator animation 
super onanimationend animation 
mstatusclocktextview setvisibility view gone 
view setalpha values 
view setscalex values 
view setscaley values 
view animate 
alpha values 
scalex values 
scaley values 
else 
viewutils setvisible view visiblenow 
widgets management 
protected void onwidgetpin nonnull widget widget 
mhandler sendemptymessagedelayed msg_show_home_widget mconfigwidgetpinduration 
mhaspinnedwidget true 
protected void onwidgetstick nonnull widget widget 
mhandler sendemptymessagedelayed msg_show_home_widget mconfigwidgetpinduration 
mhaspinnedwidget true 
protected void onwidgetreadaloud nonnull widget widget reading aloud 
called widget dismissal code here link internalremovewidget widget removes 
code widget provides turn screen last widget dismissal feature 
protected void onwidgetdismiss nonnull widget widget 
internalremovewidget widget 
widget ondismiss 
updatedividervisibility true 
turn screen last widget dismissal feature 
previously this feature working only notifications 
isnotdemo 
getconfig isscreenoffafterlastwidget 
mwidgetsmap isempty checking there widgets 
mactivityacd lock 
scenes management 
changes current scene given 
showwidget achep acdisplay components widget 
suppresslint newapi 
protected synchronized final void goscene nonnull scenecompat scenecompat boolean animate 
mcurrentscene scenecompat return 
mcurrentscene scenecompat 
debug going scenecompat 
device haskitkatapi animate mscenecontainer islaidout 
animate 
scenecompat enter 
return 
device haskitkatapi 
final scene scene scenecompat getscene 

this must synchronization problem with android scene transitionmanager 
those were declared final classes have idea 
transitionmanager scene mtransitionswitchscene 
catch illegalstateexception 
transitionmanager failed switching scenes 
viewgroup viewgroup viewgroup getsceneview getparent 
viewgroup removeview getsceneview 

reset internal scene make work again 
resources getsystem getidentifier current_scene android 
method method view class getmethod settaginternal class object class 
method setaccessible true 
method invoke viewgroup null 
catch nosuchmethodexception 
illegalaccessexception 
invocationtargetexception 
throw runtimeexception attempt transitionmanager failed 
transitionmanager scene mtransitionswitchscene 
else 
scenecompat enter 
getactivity null 
todo better animation jelly bean users 
float density getresources getdisplaymetrics density 
getsceneview setalpha 
getsceneview setrotationx 
getsceneview settranslationy density 
getsceneview animate alpha rotationx translationy 
dynamic background 
updates current background widget must actually selected otherwise 
will crash 
override 
public void requestbackgroundupdate nonnull widget widget 
check getinstance istrue iscurrentwidget widget 
final mask widget getbackgroundmask 
mbackground dispatchsetbackground widget getbackground mask 
media 
gets controller which should receiving media events 
while this fragment foreground controller supports 
platforms starting from android does nothing older 
versions 
return controller which should receive events 
nonnull 
public mediacontroller getmediacontroller 
return mmediacontrolshelper getmediacontroller 
private void makemediawidgetactive 
mmediawidgetactive mmediawidgetactive true return 
update home widget current widget 
clock media widget 
mselectedwidget ishomewidget showhomewidget 
private void makemediawidgetinactive 
mmediawidgetactive mmediawidgetactive false return 
update home widget current widget 
media widget 
iscurrentwidget mmediawidget showhomewidget 
defines media widget replaces home widget 

return code true media widget replaces home widget 
code false otherwise 
private boolean ismediawidgethome 
return mmediawidgetactive 
lollipop 
returns code true device currently power save mode 
when this mode applications should reduce their functionality 
order conserve battery much possible 
return code true device currently power save mode code false otherwise 
achep base utils power powersavedetector 
public boolean ispowersavemode 
return mactivity ispowersavemode 
return code true this fragment attached link achep acdisplay activities acdisplayactivity 
matches parent layout code false this only preview 
public boolean isnotdemo 
return getactivity instanceof acdisplayactivity 
public boolean isanimatable 
return ispowersavemode isresumed 
public boolean isanimatableauto 
return isanimatable mresuming 
notification handling 
nullable 
private notifywidget find nullable opennotification 
null return null 
find widget this previous notification 
manage 
widget item mwidgetsmap values 
item instanceof notifywidget 
check notification same 
notifywidget notifywidget item 
hasidenticalids 
return 
return null 
override 
public void onnotificationlistchanged nonnull notificationpresenter 
opennotification osbn 
event boolean islasteventinsequence 
debug handling notification list changed event 
notificationpresenter geteventname event 
isresumed 
mpendingnotifychange true 
return 
notifywidget widgetprev null 
event notificationpresenter event_removed 
event notificationpresenter event_changed 
find widget this previous notification 
manage 
widgetprev find osbn 
switch event update spam change 
case notificationpresenter event_changed 
widgetprev null 
debug event updating notification widget 
iscurrentwidget widgetprev 
final viewgroup viewgroup widgetprev getview 
maybebegindelayedtransition viewgroup mtransitionjit 
widgetprev setnotification osbn 
break 
case notificationpresenter event_posted 
debug event adding notification widget 
event notificationpresenter event_posted 
create widget inflate 
icon view 
notifywidget notifywidget this this 
start 
layoutinflater inflater getactivity getlayoutinflater 
view iconview createiconview inflater miconscontainer 
check widget scene available 
string name getclass getname 
scenecompat scene mscenesmap name 
setup widget view 
viewutils setsize iconview getconfig geticonsizepx 
setnotification osbn 
scene null 
initialize widget with previously created 
scene this possible design 
createview null null scene getview 
else 
create scene view scenes 
viewgroup sceneview createview inflater mscenecontainer null 
sceneview null 
scene scenecompat mscenecontainer sceneview 
mscenesmap name scene 
mwidgetsmap iconview 
maybebegindelayedtransition miconscontainer mtransitionjit 
miconscontainer addview iconview 
break 
case notificationpresenter event_removed 
widgetprev null 
debug event removing notification widget 
internalremovewidget widgetprev 
internalcleanpressediconviewifremovedfromcontainer 
break 
case notificationpresenter event_bath 
debug event rebuilding notifications 
rebuildnotifications 
break 
event notificationpresenter event_posted 
event notificationpresenter event_removed 
islasteventinsequence updatedividervisibility true 
notificationpresenter event_bath causes rebuildnotifications 
which calls updatedividervisibility begins delayed 
transition itself 
private void rebuildnotifications 
final long systemclock elapsedrealtime 
viewgroup container miconscontainer 
final childcount container getchildcount 
count number notification fragments 
such unlock music controls fragments 
start 
childcount 
view child container getchildat 
widget fragment findwidgetbyicon child 
fragment instanceof notifywidget 
those fragments placed begin layout 
reason continue searching 
break 
else 
start 
final arraylist opennotification list notificationpresenter getinstance getlist 
final notifycount list size 
final boolean notifyused boolean notifycount 
final boolean childused boolean childcount 
start childcount 
view child container getchildat 
notifywidget widget notifywidget findwidgetbyicon child 
opennotification target widget getnotification 
notifycount 
opennotification list 
notificationutils hasidenticalids target 
notifyused true 
childused true 
target 
widget setnotification 
break 
free views remove redundant views 
boolean removeallafter false 
start offset childcount 
childused continue 
final offset 
view child container getchildat 
removing_all_next_views 
removeallafter 
notifycount 
notifyused continue 
assert child null 
notifyused true 
notifywidget notifywidget findwidgetbyicon child 
setnotification list 
break removing_all_next_views 
removeallafter true 
internalreleasewidget child 
remove widget icon 
container removeviewat 
offset 
assert getactivity null 
layoutinflater inflater getactivity getlayoutinflater 
final iconsize getconfig geticonsizepx 
notifycount 
notifyused continue 
notifywidget notifywidget this this 
isresumed start 
view iconview createiconview inflater container 
viewutils setsize iconview iconsize 
container addview iconview 
setnotification list 
mwidgetsmap iconview 

update hash 

hashmap string scenecompat hashmap string scenecompat mscenesmap clone 
mscenesmap clear 
widget fragment mwidgetsmap values 
string type fragment getclass getname 
scenecompat scene type 
scene null 
fragment createview null null scene getview 
else 
viewgroup sceneview fragment createview inflater mscenecontainer null 
sceneview null 
scene scenecompat mscenecontainer sceneview 
type scene 
scene null 
mscenesmap type scene 
internalcleanpressediconviewifremovedfromcontainer 
debug 
long delta systemclock elapsedrealtime 
fragment list updated delta 
animate divider visibility change 
pause resume cause _somehow_ confuses people 
boolean animate mresuming 
updatedividervisibility animate 
stops widget which icon view been passed parameter removes 
from link mwidgetsmap 
private void internalreleasewidget nonnull view iconview 
isresumed findwidgetbyicon iconview stop 
mwidgetsmap remove iconview 
stops widget removes from link mwidgetsmap 
private void internalreleasewidget nonnull widget widget 
isresumed widget stop 
mwidgetsmap remove widget geticonview 
private void internalremovewidget nonnull widget widget 
internalreleasewidget widget 
maybebegindelayedtransition miconscontainer mtransitionjit 
miconscontainer removeview widget geticonview 
remove widget scene needed anymore 
boolean removescene true 
string name widget getclass getname 
widget item mwidgetsmap values 
name equals item getclass getname 
removescene false 
break 
removescene mscenesmap remove name 
iscurrentwidget widget showhomewidget 
private void internalcleanpressediconviewifremovedfromcontainer 
mpressediconview null 
return 
length miconscontainer getchildcount 
length 
view view miconscontainer getchildat 
mpressediconview view 
return 
mpressediconview null 
updates visibility divider between 
scene icons 
suppresslint newapi 
private void updatedividervisibility boolean animate 
final view view mdividerview 
final boolean visible view getvisibility view visible 
final boolean visiblenow mwidgetsmap isempty 
animate isanimatable 
visibleint mathutils bool visible 
visiblenowint mathutils bool visiblenow 
float values 
viewutils setvisible view true 
view setscalex values visibleint 
view setalpha values visibleint 
view animate 
scalex values visiblenowint 
alpha values visiblenowint 
setinterpolator accelerateinterpolator 
setlistener animatorlisteneradapter 
override 
public void onanimationend animator animation 
super onanimationend animation 
viewutils setvisible view visiblenow view invisible 
view setalpha 
view setscalex 
else 
viewutils setvisible view visiblenow view invisible 
other classes 
suppresslint newapi 
private void maybebegindelayedtransition nullable viewgroup sceneroot 
nullable transition transition 
device haskitkatapi 
isanimatableauto 
sceneroot null 
sceneroot islaidout 
transitionmanager begindelayedtransition sceneroot transition 
transfers touch between views implements double lock 
author artem chepurnoy 
private static class touchforwarder implements view ontouchlistener 
private final pocketfragment onsleeprequestlistener mlistener 
private final circleview mcircleview 
private final gesturedetector mgesturedetector 
code true redirecting touches link mcircleview 
code false otherwise 
private boolean mcircling 
public touchforwarder nonnull context context 
nonnull circleview circleview 
nonnull pocketfragment onsleeprequestlistener listener 
mlistener listener 
mcircleview circleview 
mgesturedetector gesturedetector context gesturelistener 
override 
public boolean ontouch view motionevent event 
mgesturedetector ontouchevent event 
switch event getaction 
case motionevent action_down 
float event getx 
float event gety 
mcircling viewutils pointinview 
default 
mcircling mcircleview sendtouchevent event 
return mcircling 
implements double gesture 
author artem chepurnoy 
class gesturelistener extends gesturedetector simpleongesturelistener 
override 
public boolean onsingletapup motionevent 
return false 
override 
public boolean ondoubletap motionevent 
config config config getinstance 
return config isdoubletaptosleepenabled mlistener onsleeprequest 
private static class extends weakhandler acdisplayfragment 
public nonnull acdisplayfragment fragment 
super fragment 
override 
protected void onhandlemassage nonnull acdisplayfragment fragment message 
switch what 
case msg_hide_media_widget 
fragment makemediawidgetinactive 
break 
case msg_show_home_widget 
fragment showhomewidget 
break 
