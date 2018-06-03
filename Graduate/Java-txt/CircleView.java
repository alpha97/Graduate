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

package achep acdisplay widgets 
import android animation objectanimator 
import android content context 
import android content resources 
import android graphics canvas 
import android graphics color 
import android graphics colorfilter 
import android graphics colormatrixcolorfilter 
import android graphics paint 
import android graphics drawable drawable 
import android message 
import android support annotation drawableres 
import android support annotation nonnull 
import android support graphics colorutils 
import android support view animation fastoutlinearininterpolator 
import android util attributeset 
import android util 
import android util property 
import android view hapticfeedbackconstants 
import android view motionevent 
import android view view 
import achep acdisplay config 
import achep acdisplay 
import achep acdisplay cornerhelper 
import achep acdisplay drawables cornericondrawable 
import achep base async weakhandler 
import achep base tests check 
import achep base utils floatproperty 
import achep base utils mathutils 
import achep base utils refcachebase 
import achep base utils resutils 
import java lang reference 
import java lang weakreference 
import static achep acdisplay preferences colorpickerpreference getcolor 
import static achep base build debug 
created achep 
public class circleview extends view 
private static final string circleview 
public static final action_start 
public static final action_unlock 
public static final action_unlock_start 
public static final action_unlock_cancel 
public static final action_canceled 
private static final msg_cancel 
nonnull 
private static final property circleview float radius_property 
floatproperty circleview setradius 
override 
public void setvalue circleview float value 
setradius value 
override 
public float circleview 
return mradius 
current touch point 
private float mpoint float 
real radius circle measured touch 
private float mradius 
radius drawn circle 
setradiusdrawn float 
private float mradiusdrawn 
target 
private float mradiustarget 
private boolean mradiustargetaimed 
decreasing detection 
private float mradiusmaxpeak 
private float mradiusdecreasethreshold 
private boolean mcanceled 
private float mdarkening 
private float mcornermargin 
drawableres 
private mdrawableresourceid 
private colorfilter minversecolorfilter 
private cornericondrawable mdrawablelefttopcorner 
private cornericondrawable mdrawablerighttopcorner 
private cornericondrawable mdrawableleftbottomcorner 
private cornericondrawable mdrawablerightbottomcorner 
private drawable mdrawable 
private paint mpaint 
nonnull 
private refcachebase drawable mdrawablecache refcachebase drawable 
nonnull 
override 
protected reference drawable oncreatereference nonnull drawable object 
return weakreference object 
animation 
private objectanimator manimator 
private mshortanimtime 
private mmediumanimtime 
private callback mcallback 
private supervisor msupervisor 
private mhandler this 
private minnercolor 
private moutercolor 
private mcorneractionid 
public interface callback 
void oncircleevent float radius float ratio event actionid 
public interface supervisor 
boolean isanimationenabled 
boolean isanimationunlockenabled 
public circleview context context 
this context null 
public circleview context context attributeset attrs 
this context attrs 
public circleview context context attributeset attrs defstyleattr 
super context attrs defstyleattr 
init 
private void init 
resources getresources 
mcornermargin getdimension dimen circle_corner_margin 
mradiustarget getdimension dimen circle_radius_target 
mradiusdecreasethreshold getdimension dimen circle_radius_decrease_threshold 
mshortanimtime getinteger android integer config_shortanimtime 
mmediumanimtime getinteger android integer config_mediumanimtime 
mdrawablelefttopcorner cornericondrawable config key_corner_action_left_top 
mdrawablerighttopcorner cornericondrawable config key_corner_action_right_top 
mdrawableleftbottomcorner cornericondrawable config key_corner_action_left_bottom 
mdrawablerightbottomcorner cornericondrawable config key_corner_action_right_bottom 
mpaint paint 
mpaint setantialias true 
initinversecolorfilter 
setradius 
private void initinversecolorfilter 
final float 
final float matrix 




minversecolorfilter colormatrixcolorfilter matrix 
public void setsupervisor supervisor supervisor 
msupervisor supervisor 
public void setcallback callback callback 
mcallback callback 
override 
protected void onattachedtowindow 
super onattachedtowindow 
start tracking corners icons 
context context getcontext 
mdrawablelefttopcorner start context 
mdrawablerighttopcorner start context 
mdrawableleftbottomcorner start context 
mdrawablerightbottomcorner start context 
override 
protected void ondraw canvas canvas 
final float ratio calculateratio 
draw corners 
drawcornericon canvas mdrawablelefttopcorner left 
drawcornericon canvas mdrawablerighttopcorner right 
drawcornericon canvas mdrawableleftbottomcorner left bottom 
drawcornericon canvas mdrawablerightbottomcorner right bottom 
darkening background 
alpha mdarkening 
alpha alpha ratio change alpha dynamically 
canvas drawcolor color argb alpha 
color moutercolor 
color green moutercolor 
color blue moutercolor 
draw unlock circle 
mpaint setcolor minnercolor 
mpaint setalpha math ratio 
canvas drawcircle mpoint mpoint mradiusdrawn mpaint 
ratio 
draw unlock icon center circle 
float scale ratio 
canvas save 
canvas translate 
mpoint mdrawable getminimumwidth scale 
mpoint mdrawable getminimumheight scale 
canvas scale scale scale 
mdrawable draw canvas 
canvas restore 
private void drawcornericon nonnull canvas canvas nonnull drawable drawable 
width getmeasuredwidth drawable getbounds width 
height getmeasuredheight drawable getbounds height 
float margin mcornermargin 
draw 
canvas save 
canvas translate width margin height margin 
drawable draw canvas 
canvas restore 
override 
protected void ondetachedfromwindow 
cancelandclearanimator 
mhandler removecallbacksandmessages null 
mdrawablecache clear 
mdrawablelefttopcorner stop 
mdrawablerighttopcorner stop 
mdrawableleftbottomcorner stop 
mdrawablerightbottomcorner stop 
super ondetachedfromwindow 
private void setinnercolor color boolean needscolorreset 
minnercolor minnercolor color needscolorreset return 
inverse drawable needed 
boolean isbright colorutils calculateluminance color 
mdrawable setcolorfilter isbright minversecolorfilter null 
private void setoutercolor color 
moutercolor color 
updates icon center circle once corresponding 
with current action 
cornerhelper 
private boolean updateicon 
final cornerhelper geticonresource mcorneractionid 
mdrawableresourceid return false need update 
mdrawableresourceid 
label 
from cache 
final charsequence integer tostring 
mdrawable mdrawablecache 
mdrawable null 
debug icon from cache 
break label 
load from resources 
mdrawable resutils getdrawable getcontext 
assert mdrawable null 
mdrawable setbounds 
mdrawable getintrinsicwidth 
mdrawable getintrinsicheight 
mdrawable mdrawable mutate affect original drawable 
mdrawablecache mdrawable 
update alpha 
float ratio calculateratio 
mdrawable setalpha math ratio 
return true 
public boolean sendtouchevent nonnull motionevent event 
final action event getactionmasked 
current circle canceled then 
ignore actions except touch down reset state 
mcanceled action motionevent action_down return false 
cancel current circle more fingers touch 
event getpointercount 
cancelcircle 
return false 
final float event getx 
final float event gety 
switch action 
case motionevent action_down 
clearanimation 
config config config getinstance 
corner actions 
width getwidth 
height getheight 
radius math width height 
mathutils isincircle radius left 
mcorneractionid config getcorneractionlefttop 
else mathutils isincircle width radius right 
mcorneractionid config getcorneractionrighttop 
else mathutils isincircle height radius bottom left 
mcorneractionid config getcorneractionleftbottom 
else mathutils isincircle width height radius bottom right 
mcorneractionid config getcorneractionrightbottom 
else 
default action unlocking 
mcorneractionid config corner_unlock 
update colors icon drawable 
boolean needscolorreset updateicon 
setinnercolor getcolor config getcircleinnercolor needscolorreset 
setoutercolor getcolor config getcircleoutercolor 
initialize circle 
mradiustargetaimed false 
mradiusmaxpeak 
mpoint 
mpoint 
mcanceled false 
mhandler hasmessages action_unlock 
cancel unlocking process 
mhandler sendemptymessage action_unlock_cancel 
mhandler removecallbacksandmessages null 
mhandler sendemptymessagedelayed msg_cancel 
mhandler sendemptymessage action_start 
break 
case motionevent action_move 
setradius 
break 
case motionevent action_cancel 
case motionevent action_up 
mradiustargetaimed action motionevent action_cancel 
cancelcircle 
break 
startunlock 
break 
return true 
private void cancelcircle 
cancelcircle msupervisor isanimationunlockenabled 
private void cancelcircle boolean animate 
check getinstance isfalse mcanceled 
mcanceled true 
mhandler removecallbacksandmessages null 
mhandler sendemptymessage action_canceled 
animate 
startanimatorby mradius mmediumanimtime 
else 
setradius 
private void startunlock 
startunlock msupervisor isanimationunlockenabled 
private void startunlock boolean animate 
animate 
calculate longest distance between center 
circle view corners 
float distance 
corners 
left 
getheight bottom left 
getwidth getheight bottom right 
getwidth right 
corners length 
double math hypot 
mpoint corners 
mpoint corners 
distance distance float 
distance float math distance 
startanimatorby mradius distance mshortanimtime 
final delayunlock animate mshortanimtime 
mhandler removecallbacksandmessages null 
mhandler sendemptymessage action_unlock_start 
mhandler sendemptymessagedelayed action_unlock delayunlock 
private void startanimatorby float from float duration 
cancelandclearanimator 
animate circle 
manimator objectanimator offloat this radius_property from 
manimator setinterpolator fastoutlinearininterpolator 
manimator setduration duration 
manimator start 
private void cancelandclearanimator 
manimator null 
manimator cancel 
manimator null 
private float calculateratio 
return math mradius mradiustarget 
private void setradius float float 
double radius math hypot mpoint mpoint 
setradius float radius 
sets radius fake circle 
param radius radius 
private void setradius float radius 
mradius radius 
mcanceled 
save maximum radius detecting 
decreasing circle size 
mradius mradiusmaxpeak 
mradiusmaxpeak mradius 
else mradiusmaxpeak mradius mradiusdecreasethreshold 
cancelcircle 
return cancelling circle will recall setradius 
boolean aimed mradius mradiustarget 
mradiustargetaimed aimed 
mradiustargetaimed aimed 
vibrate user interacting with device 
isintouchmode performhapticfeedback hapticfeedbackconstants virtual_key 
final float ratio calculateratio 
alpha 
update unlock icon transparency 
mdrawable null 
alpha math ratio 
mdrawable setalpha alpha 
update corners icons transparency 
alpha math ratio 
mdrawablelefttopcorner setalpha alpha 
mdrawablerighttopcorner setalpha alpha 
mdrawableleftbottomcorner setalpha alpha 
mdrawablerightbottomcorner setalpha alpha 
update size unlock circle 
radius float math sqrt mradius 
setradiusdrawn radius 
private void setradiusdrawn float radius 
mradiusdrawn radius 
postinvalidateonanimation 
private static class extends weakhandler circleview 
public nonnull circleview 
super 
override 
protected void onhandlemassage nonnull circleview message 
switch what 
case msg_cancel 
cancelcircle 
break 
case action_start 
case action_unlock 
case action_unlock_start 
case action_unlock_cancel 
case action_canceled 
mcallback null 
final float ratio calculateratio 
final actionid mcorneractionid 
mcallback oncircleevent mradius ratio what actionid 
break 
default 
throw illegalargumentexception 
