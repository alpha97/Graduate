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
import android appwidget appwidgetmanager 
import android appwidget appwidgetproviderinfo 
import android content context 
import android content resources 
import android graphics bitmap 
import android support annotation nonnull 
import android support annotation nullable 
import android view gravity 
import android view layoutinflater 
import android view view 
import android view viewgroup 
import android widget linearlayout 
import achep acdisplay config 
import achep acdisplay 
import achep acdisplay appwidget myappwidgethost 
import achep acdisplay appwidget myappwidgethostview 
import achep acdisplay fragments acdisplayfragment 
import achep base content configbase 
import achep base utils appwidgetutils 
import achep base utils mathutils 
import achep base utils viewutils 
widget hosts link android appwidget appwidgethost 
author artem chepurnoy 
public class hostwidget extends widget implements configbase onconfigchangedlistener 
private static final string hostwidget 
public static final host_id 
private final appwidgetmanager mappwidgetmanager 
private final myappwidgethost mappwidgethost 
private myappwidgethostview mhostview 
private viewgroup mhostcontainer 
private view memptyview 
private boolean mhostviewneedsreinflate 
public hostwidget nonnull callback callback nonnull acdisplayfragment fragment 
super callback fragment 
activity activity fragment getactivity 
mappwidgetmanager appwidgetmanager getinstance activity 
mappwidgethost myappwidgethost activity host_id 
override 
public void onstart 
super onstart 
mappwidgethost startlistening 
getconfig registerlistener this 
updateappwidgetviewifneeded 
override 
public void onviewattached 
super onviewattached 
updateappwidgetviewifneeded 
override 
public void onstop 
getconfig unregisterlistener this 
mappwidgethost stoplistening 
mhostviewneedsreinflate true 
stopping listening removes active views from 
will have inflate them 
super onstop 
inheritdoc 
override 
public boolean ishomewidget 
return true 
inheritdoc 
override 
public boolean hasclock 
return true 
override 
protected viewgroup oncreateview 
nonnull layoutinflater inflater 
nonnull viewgroup container 
nullable viewgroup sceneview 
boolean initialize sceneview null 
initialize 
sceneview viewgroup inflater inflate layout acdisplay_scene_host container false 
assert sceneview null 
mhostcontainer viewgroup sceneview findviewbyid scene 
memptyview sceneview findviewbyid empty 
return sceneview 
nullable 
override 
public bitmap getbackground 
return null 
override 
public getbackgroundmask 
return 
widget host 
private void updateappwidgetviewifneeded 
isstarted isviewattached return 
getconfig getcustomwidgetid 
appwidgetutils isvalidid 
mhostview null 
viewutils removeviewparent mhostview 
memptyview setvisibility view visible 
mhostviewneedsreinflate false 
mhostview null 
return 
context context getfragment getactivity 
mhostview null 
mhostview myappwidgethostview context 
updateappwidgettouchable 
linearlayout layoutparams linearlayout layoutparams 
viewgroup layoutparams wrap_content 
viewgroup layoutparams wrap_content 
gravity center_horizontal 
mhostcontainer addview mhostview 
memptyview setvisibility view gone 
else mhostviewneedsreinflate mhostview getappwidgetid return 
appwidgetproviderinfo appwidget mappwidgetmanager getappwidgetinfo 
mappwidgethost updateview context appwidget mhostview 
mhostviewneedsreinflate false 
updateappwidgetframesize 
private void updateappwidgetframesize 
resources getfragment getactivity getresources 
getconfig getcustomwidgetheightdp 
hmin getdimensionpixelsize dimen scene_min_height 
hmax getdimensionpixelsize dimen scene_max_height 
getconfig getcustomwidgetwidthdp 
wmin getdimensionpixelsize dimen scene_min_width 
wmax getdimensionpixelsize dimen scene_max_width 
float density getdisplaymetrics density 
math round mathutils range density wmin wmax 
math round mathutils range density hmin hmax 
update size 
viewutils setsize mhostview 
mhostview updateappwidgetsize null 
private void updateappwidgettouchable 
mhostview settouchable getconfig iscustomwidgettouchable 
inheritdoc 
override 
public void onconfigchanged nonnull configbase config 
nonnull string 
nonnull object value 
switch 
case config key_ui_custom_widget_id 
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
