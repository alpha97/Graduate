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

package achep acdisplay activities settings 
import android appwidget appwidgetmanager 
import android appwidget appwidgetproviderinfo 
import android content intent 
import android bundle 
import android parcelable 
import android support annotation nonnull 
import android text html 
import android util 
import android view gravity 
import android view menu 
import android view menuitem 
import android view view 
import android view viewgroup 
import android widget framelayout 
import android widget seekbar 
import achep acdisplay config 
import achep acdisplay 
import achep acdisplay appwidget myappwidgethost 
import achep acdisplay appwidget myappwidgethostview 
import achep acdisplay components hostwidget 
import achep base device 
import achep base content configbase 
import achep base tests check 
import achep base switchbarpermissible 
import achep base activities activitybase 
import achep base preferences enabler 
import achep base widgets switchbar 
import achep base utils appwidgetutils 
import achep base utils mathutils 
import achep base utils toastutils 
import achep base utils viewutils 
import afollestad materialdialogs materialdialog 
import melnykov floatingactionbutton 
import java util arraylist 
activity setting custom widget tweaking 
licking 
author artem chepurnoy 
public class widgetpickeractivity extends activitybase implements 
config onconfigchangedlistener 
seekbar onseekbarchangelistener 
private static final string widgetpickeractivity 
private static final string key_pending_appwidget_id achep pending_app_widget_key 
request open default appwidget picker dialog 
private static final request_appwidget_discover 
request open configure activity appwidget 
private static final request_appwidget_configure 
private static final appwidget_id_none 
static 
check getinstance isfalse appwidgetutils isvalidid appwidget_id_none 
private final config mconfig config getinstance 
private appwidgetmanager mappwidgetmanager 
private myappwidgethostview mhostview 
private myappwidgethost mappwidgethost 
private viewgroup mhostcontainer 
private mpendingappwidgetid 
private switchbarpermissible mswitchpermissible 
private menuitem mconfiguremenuitem 
private menuitem mtouchablemenuitem 
private menuitem mclearmenuitem 
private enabler menabler 
private view memptyview 
adjust width height 
private seekbar mwidthseekbar 
private view mwidthmessageview 
private seekbar mheightseekbar 
private view mheightmessageview 
private mminwidth 
private mminheight 
private floatingactionbutton mfab 
private boolean mhostviewneedsreinflate 
private boolean mactivityresumed 
override 
protected void oncreate bundle savedinstancestate 
mconfig iswallpapershown settheme style materialtheme_widgetpicker_wallpaper 
super oncreate savedinstancestate 
setcontentview layout activity_widget_picker 
memptyview findviewbyid empty 
mfab floatingactionbutton findviewbyid 
mfab setonclicklistener view onclicklistener 
override 
public void onclick view 
startappwidgetdiscover 
mappwidgetmanager appwidgetmanager getinstance this 
mhostcontainer viewgroup findviewbyid appwidget_container 
mappwidgethost myappwidgethost this hostwidget host_id 
initswitchbar 
initseekbars 
private void initswitchbar 
activitybase activity activitybase getactivity 
switchbar switchbar switchbar findviewbyid switch_bar 
mswitchpermissible switchbarpermissible activity switchbar null 
menabler enabler this mconfig config key_ui_custom_widget mswitchpermissible 
private void initseekbars 
load dimensions 
mminheight getresources getdimensionpixelsize dimen scene_min_height 
hmax getresources getdimensionpixelsize dimen scene_max_height 
mminwidth getresources getdimensionpixelsize dimen scene_min_width 
wmax getresources getdimensionpixelsize dimen scene_max_width 
init views 
float progress density getresources getdisplaymetrics density 
mwidthseekbar seekbar findviewbyid appwidget_width_seek_bar 
mwidthseekbar setonseekbarchangelistener this 
mwidthseekbar setmax wmax mminwidth 
progress mathutils range mconfig getcustomwidgetwidthdp density mminwidth wmax 
mwidthseekbar setprogress math round progress mminwidth 
mwidthmessageview findviewbyid appwidget_width_label 
mheightseekbar seekbar findviewbyid appwidget_height_seek_bar 
mheightseekbar setonseekbarchangelistener this 
mheightseekbar setmax hmax mminheight 
progress mathutils range mconfig getcustomwidgetheightdp density mminheight hmax 
mheightseekbar setprogress math round progress mminheight 
mheightmessageview findviewbyid appwidget_height_label 
override 
public void onstart 
super onstart 
mappwidgethost startlistening 
updateappwidgetviewifneeded 
override 
protected void onresume 
super onresume 
mactivityresumed true 
mswitchpermissible resume 
menabler start 
mconfig registerlistener this 
override 
protected void onpause 
mconfig unregisterlistener this 
menabler stop 
mswitchpermissible pause 
mactivityresumed false 
super onpause 
override 
public void onstop 
mappwidgethost stoplistening 
mhostviewneedsreinflate true 
stopping listening removes active views from 
will have inflate them 
super onstop 
override 
protected void onsaveinstancestate bundle outstate 
super onsaveinstancestate outstate 
outstate putint key_pending_appwidget_id mpendingappwidgetid 
override 
protected void onrestoreinstancestate nonnull bundle savedinstancestate 
super onrestoreinstancestate savedinstancestate 
mpendingappwidgetid savedinstancestate getint key_pending_appwidget_id 
override 
public boolean oncreateoptionsmenu menu menu 
getmenuinflater inflate menu widget_picker menu 
mclearmenuitem menu finditem clear_action 
mconfiguremenuitem menu finditem configure_action 
mtouchablemenuitem menu finditem touchable 
updateconfiguremenuitem 
updatetouchablemenuitem 
updateclearmenuitem 
return true 
updates visibility link mclearmenuitem 
private void updateclearmenuitem 
mclearmenuitem null return 
boolean visible mhostview null 
mclearmenuitem setvisible visible 
updates visibility link mconfiguremenuitem shows 
current widget configure page hides otherwise 
private void updateconfiguremenuitem 
mclearmenuitem null return 
boolean visible mhostview null 
mhostview getappwidgetinfo null 
mhostview getappwidgetinfo configure null 
mconfiguremenuitem setvisible visible 
updates visibility link mtouchablemenuitem 
private void updatetouchablemenuitem 
mtouchablemenuitem null return 
boolean visible mhostview null 
mtouchablemenuitem setvisible visible 
override 
public boolean onoptionsitemselected menuitem item 
switch item getitemid 
case clear_action 
deletecurrentappwidget 
save current change 
storeappwidget appwidget_id_none 
break 
case configure_action 
check getinstance isnonnull mhostview getappwidgetinfo configure 
startappwidgetconfigure mhostview getappwidgetinfo mhostview getappwidgetid 
break 
case touchable 
mtouchablemenuitem setchecked mtouchablemenuitem ischecked 
mconfig 
getoption config key_ui_custom_widget_touchable 
write mconfig this mtouchablemenuitem ischecked null 
break 
default 
return super onoptionsitemselected item 
return true 
inheritdoc 
override 
public void onconfigchanged nonnull configbase config 
nonnull string 
nonnull object value 
switch 
case config key_ui_custom_widget_id 
final value 
mactivityresumed 
automatically turn switch causing 
terror murders 
mswitchpermissible setchecked appwidgetutils isvalidid 
mhostviewneedsreinflate true 
updateappwidgetviewifneeded 
break 
case config key_ui_custom_widget_width_dp 
case config key_ui_custom_widget_height_dp 
mhostview null updateappwidgetframesize 
break 
case config key_ui_custom_widget_touchable 
mhostview null updateappwidgettouchable 
break 
override 
public void onprogresschanged seekbar seekbar progress boolean fromuser 
mhostview null return 
updateappwidgetframesize 
override 
public void onstarttrackingtouch seekbar seekbar unused 
override 
public void onstoptrackingtouch seekbar seekbar 
double density getresources getdisplaymetrics density 
widthdp mminwidth mwidthseekbar getprogress density 
heightdp mminheight mheightseekbar getprogress density 
save width height config callback will 
ignored 
mconfig getoption config key_ui_custom_widget_width_dp write mconfig this widthdp this 
mconfig getoption config key_ui_custom_widget_height_dp write mconfig this heightdp this 
updates link mhostview widget frame size based 
current width height specified link mwidthseekbar link mheightseekbar 
private void updateappwidgetframesize 
width mminwidth mwidthseekbar getprogress 
height mminheight mheightseekbar getprogress 
viewutils setsize mhostview width height 
mhostview updateappwidgetsize null width height width height 
private void updateappwidgettouchable 
mhostview settouchable mconfig iscustomwidgettouchable 
writes current widget settings 
param widget 
private void storeappwidget 
mconfig getoption config key_ui_custom_widget_id write mconfig this null 
private void deletecurrentappwidgetsafely 
mhostview null deletecurrentappwidget 
private void deletecurrentappwidget 
mhostcontainer removeview mhostview 
mappwidgethost deleteappwidgetid mhostview getappwidgetid 
mhostview null 
discover configure 
override 
protected void onactivityresult requestcode resultcode intent data 

switch requestcode 
case request_appwidget_discover 
mpendingappwidgetid appwidget_id_none 
data null data getextras null 
check getinstance isfalse resultcode result_ok 
intent data empty 
break 
data getextras getint appwidgetmanager extra_appwidget_id 
resultcode result_ok appwidgetutils isvalidid 
appwidgetproviderinfo appwidget mappwidgetmanager getappwidgetinfo 
appwidget null 
clean allocated this probably needed 
cause have access widget 
mappwidgethost deleteappwidgetid 
todo toast user about this incident 
else appwidget configure null 
mpendingappwidgetid 
startappwidgetconfigure appwidget 
else 
just apply widget 
storeappwidget 
else 
clean allocated 
mappwidgethost deleteappwidgetid 
break 
case request_appwidget_configure 
appwidgetutils isvalidid mpendingappwidgetid break 
mpendingappwidgetid appwidget_id_none 
resultcode result_ok 
storeappwidget 
else 
clean allocated 
mappwidgethost deleteappwidgetid 
break 
default 
super onactivityresult requestcode resultcode data 
launches link appwidgetmanager action_appwidget_pick widget picker 
wait result 
private void startappwidgetdiscover 
intent intent intent appwidgetmanager action_appwidget_pick 
intent putextra appwidgetmanager extra_appwidget_id mappwidgethost allocateappwidgetid 
this avoids android settings appwidgetpickactivity which used 
select widgets this just adds empty extras intent avoiding 
more http code google android issues detail 
arraylist parcelable custominfo arraylist 
intent putparcelablearraylistextra appwidgetmanager extra_custom_info custominfo 
arraylist parcelable customextras arraylist 
intent putparcelablearraylistextra appwidgetmanager extra_custom_extras customextras 
startactivityforresult intent request_appwidget_discover 
suppresswarnings newapi 
private void startappwidgetconfigure nonnull appwidgetproviderinfo appwidget 

device haslollipopapi 
mappwidgethost startappwidgetconfigureactivityforresult 
this request_appwidget_configure null 
else 
intent intent intent appwidgetmanager action_appwidget_configure 
intent setcomponent appwidget configure 
intent putextra appwidgetmanager extra_appwidget_id 
startactivityforresult intent request_appwidget_configure 
catch exception 
device islge 
charsequence message html fromhtml getstring string error_dialog_custom_widget_lg 
materialdialog builder this 
title string error_dialog_title 
content message 
positivetext android string 
show 
else toastutils showlong this string error_dialog_title 
update user interface 
private void updateappwidgetviewifneeded 
mconfig getcustomwidgetid 
appwidgetutils isvalidid 
mhostviewneedsreinflate false 
remove current widget 
deletecurrentappwidgetsafely 
update views 
mfab show 
memptyview setvisibility view visible 
mwidthseekbar setvisibility view gone 
mwidthmessageview setvisibility view gone 
mheightseekbar setvisibility view gone 
mheightmessageview setvisibility view gone 
update menu 
updateconfiguremenuitem 
updatetouchablemenuitem 
updateclearmenuitem 
return 
mhostview null 
mhostview myappwidgethostview this 
mhostview setbackgroundresource drawable bg_appwidget_preview 
updateappwidgettouchable 
framelayout layoutparams framelayout layoutparams 
viewgroup layoutparams wrap_content 
viewgroup layoutparams wrap_content 
gravity center_horizontal 
mhostcontainer addview mhostview 
else mhostviewneedsreinflate mhostview getappwidgetid return 
appwidgetproviderinfo appwidget mappwidgetmanager getappwidgetinfo 
mappwidgethost updateview this appwidget mhostview 
mhostviewneedsreinflate false 
updateappwidgetframesize 
update views 
mfab hide haswindowfocus 
memptyview setvisibility view gone 
mwidthseekbar setvisibility view visible 
mwidthmessageview setvisibility view visible 
mheightseekbar setvisibility view visible 
mheightmessageview setvisibility view visible 
update menu 
mhostview post runnable 
override 
public void 
updateconfiguremenuitem 
updatetouchablemenuitem 
updateclearmenuitem 
