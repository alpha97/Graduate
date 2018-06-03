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
import android annotation suppresslint 
import android content colorstatelist 
import android content resources 
import android graphics bitmap 
import android graphics color 
import android graphics porterduff 
import android graphics drawable drawable 
import android asynctask 
import android handler 
import android support annotation nonnull 
import android support annotation nullable 
import android support media session playbackstatecompat 
import android support graphics palette 
import android transition transitionmanager 
import android util 
import android view layoutinflater 
import android view view 
import android view viewgroup 
import android widget imagebutton 
import android widget imageview 
import android widget seekbar 
import android widget textview 
import achep acdisplay atomic 
import achep acdisplay config 
import achep acdisplay 
import achep acdisplay graphics backgroundfactory 
import achep acdisplay services media mediacontroller 
import achep acdisplay services media metadata 
import achep acdisplay fragments acdisplayfragment 
import achep base device 
import achep base tests check 
import achep base drawables playpausedrawable 
import achep base drawables rippledrawable 
import achep base utils operator 
import achep base utils resutils 
import achep base utils rippleutils 
import achep base utils viewutils 
import static achep base build debug 
media widget link achep acdisplay fragments acdisplayfragment that provides 
basic media controls nice skin 
author artem chepurnoy 
public class mediawidget extends widget implements 
mediacontroller medialistener 
view onclicklistener 
view onlongclicklistener seekbar onseekbarchangelistener 
private static final string mediawidget 
private final mediacontroller mmediacontroller 
private final playpausedrawable mplaypausedrawable 
private final drawable mwarningdrawable 
private imageview martworkview 
private textview mtitleview 
private textview msubtitleview 
private imagebutton mbuttonprevious 
private imagebutton mbuttonplaypause 
private imagebutton mbuttonnext 
seek 
private viewgroup mseeklayout 
private textview mpositiontext 
private textview mdurationtext 
private seekbar mseekbar 
private boolean midle 
private martworkcolor color white 
private bitmap martwork 
private bitmap martworkbackground 
private asynctask bitmap void palette mpaletteworker 
private asynctask void void bitmap mbackgroundworker 
private final palette paletteasynclistener mpalettecallback 
palette paletteasynclistener 
override 
public void ongenerated nonnull palette palette 
martworkcolor palette getvibrantcolor color white 
updateplaypausebuttoncolor martworkcolor 
updateseekbarcolor martworkcolor 
private final backgroundfactory backgroundasynclistener mbackgroundcallback 
backgroundfactory backgroundasynclistener 
override 
public void ongenerated nonnull bitmap bitmap 
martworkbackground bitmap 
populatebackground 
private final atomic callback mseekatomiccallback atomic callback 
private static final refresh_rate 
nonnull 
private final handler mhandler handler 
nonnull 
private final runnable mrunnable runnable 
override 
public void 
mseekbartracking 
fixme this workaround implementing states 
acdisplay fragment 
mcallback requesttimeoutrestart mediawidget this 
else 
update seek 
long position mmediacontroller getplaybackposition 
long duration mmediacontroller getmetadata duration 
check getinstance istrue duration 
float ratio float double position duration 
float progress mseekbar getmax ratio 
mseekbar setprogress math round progress 
update playback position text 
mpositiontext settext formattime position 
refresh schedule 
mseekuiatomic isrunning 
debug seek refresh tick 
mhandler postdelayed this refresh_rate 
override 
public void onstart object objects 
mhandler post mrunnable 
mseeklayout setvisibility view visible 
override 
public void onstop object objects 
mhandler removecallbacks mrunnable 
mseeklayout setvisibility view gone 
workaround with transition manager 
which causes seek layout semi transparent 
gone 
mseeklayout postdelayed runnable 
override 
public void 
mseeklayout setvisibility view visible 
mseeklayout setvisibility view gone 
mseeklayout postinvalidate 

private final atomic mseekuiatomic atomic mseekatomiccallback mediawidget seekbar 
private boolean mseekbartracking 
public mediawidget nonnull callback callback nonnull acdisplayfragment fragment 
super callback fragment 
mmediacontroller fragment getmediacontroller 
resources fragment getresources 
mplaypausedrawable playpausedrawable 
mplaypausedrawable setsize getdimensionpixelsize dimen media_btn_actual_size 
mwarningdrawable resutils getdrawable fragment getactivity drawable ic_action_warning_white 
inheritdoc 
override 
public boolean ishomewidget 
return true 
override 
public void onviewattached 
super onviewattached 
midle false 
mmediacontroller registerlistener this 
onmetadatachanged mmediacontroller getmetadata 
onplaybackstatechanged mmediacontroller getplaybackstate 
midle true 
override 
public void onviewdetached 
mmediacontroller unregisterlistener this 
mseekuiatomic stop 
super onviewdetached 
override 
public void onstop 
mseekuiatomic stop 
super onstop 
override 
public void onmetadatachanged nonnull metadata metadata 
populatemetadata 
final bitmap bitmap metadata bitmap 
check artwork equals then need 
generate everything from beginning 
martwork bitmap martwork null martwork sameas bitmap 
return 
martwork bitmap 
martworkbackground null 
achep base async asynctask stop mpaletteworker 
achep base async asynctask stop mbackgroundworker 
updateplaypausebuttoncolor color white reset color 
updateseekbarcolor color white reset color 
bitmap null 
todo load vibrant color only 
martworkcolor color white 
mpaletteworker palette builder bitmap 
maximumcolorcount 
generate mpalettecallback 
dynamicbgmode getconfig getdynamicbackgroundmode 
operator bitand dynamicbgmode getbackgroundmask 
mbackgroundworker backgroundfactory generateasync bitmap mbackgroundcallback 
return reset background 
else 
mpaletteworker null 
mbackgroundworker null 
populatebackground 
override 
public void onplaybackstatechanged state 
making transformation rule warning icon 
much overkill 
state playbackstatecompat state_error 
mbuttonplaypause setimagedrawable mwarningdrawable 
else 
mbuttonplaypause setimagedrawable mplaypausedrawable 
debug playback state state 
final imagedescid 
switch state 
case playbackstatecompat state_error 
imagedescid string media_play_description 
break 
case playbackstatecompat state_playing 
mplaypausedrawable transformtopause 
imagedescid string media_pause_description 
break 
case playbackstatecompat state_buffering 
case playbackstatecompat state_stopped 
mplaypausedrawable transformtostop 
imagedescid string media_stop_description 
break 
case playbackstatecompat state_paused 
default 
mplaypausedrawable transformtoplay 
imagedescid string media_play_description 
break 
mbuttonplaypause setcontentdescription getfragment getstring imagedescid 
updates content view latest metadata 
provided link achep acdisplay services media mediacontroller getmetadata 
private void populatemetadata 
midle 
viewgroup getview 
device haskitkatapi islaidout getfragment isanimatable 
transitionmanager begindelayedtransition 
metadata metadata mmediacontroller getmetadata 
viewutils safelysettext mtitleview metadata title 
viewutils safelysettext msubtitleview metadata subtitle 
mdurationtext settext formattime metadata duration 
mseekuiatomic stop 
mseekbar setmax math metadata duration 
martworkview null 
martworkview setimagebitmap metadata bitmap 
requests host update dynamic background 
getbackground 
getbackgroundmask 
private void populatebackground 
isviewattached 
mcallback requestbackgroundupdate this 
suppresslint newapi 
private void updateplaypausebuttoncolor color 
device haslollipopapi 
rippledrawable rippledrawable rippledrawable mbuttonplaypause getbackground 
rippledrawable setcolorfilter color porterduff mode multiply 
else 
rippleutils makefor colorstatelist valueof color false mbuttonplaypause 
private void updateseekbarcolor color 
mseekbar getprogressdrawable setcolorfilter color porterduff mode multiply 
inheritdoc 
nullable 
override 
public bitmap getbackground 
return martworkbackground null 
martwork 
martworkbackground 
inheritdoc 
override 
public getbackgroundmask 
return config dynamic_bg_artwork_mask 
override 
protected viewgroup oncreateview 
nonnull layoutinflater inflater 
nonnull viewgroup container 
nullable viewgroup sceneview 
boolean initialize sceneview null 
initialize 
sceneview viewgroup inflater inflate layout acdisplay_scene_music container false 
assert sceneview null 
martworkview imageview sceneview findviewbyid artwork 
viewgroup infolayout viewgroup sceneview findviewbyid metadata 
mtitleview textview infolayout findviewbyid media_title 
msubtitleview textview infolayout findviewbyid media_subtitle 
mbuttonprevious imagebutton sceneview findviewbyid previous 
mbuttonplaypause imagebutton sceneview findviewbyid play 
mbuttonnext imagebutton sceneview findviewbyid next 
mseeklayout viewgroup sceneview findviewbyid seek_layout 
mseekbar seekbar mseeklayout findviewbyid seek_bar 
mpositiontext textview mseeklayout findviewbyid playback_position 
mdurationtext textview mseeklayout findviewbyid duration 
initialize 
return sceneview 
mseekbar setonseekbarchangelistener this 
mbuttonprevious setonclicklistener this 
mbuttonplaypause setimagedrawable mplaypausedrawable 
mbuttonplaypause setonclicklistener this 
mbuttonplaypause setonlongclicklistener this 
mbuttonnext setonclicklistener this 
show seek panel long click 
infolayout setonlongclicklistener view onlongclicklistener 
override 
public boolean onlongclick view 
allow seeking weird song 
mmediacontroller getmetadata duration 
mmediacontroller getplaybackposition 
mseekuiatomic isrunning 
toggleseekuivisibility 
return true 
return false 
toggleseekuivisibility 
return true 
private void toggleseekuivisibility 
viewgroup getview 
device haskitkatapi islaidout getfragment isanimatable 
transitionmanager begindelayedtransition 
mseekuiatomic react mseekuiatomic isrunning 
mcallback requesttimeoutrestart mediawidget this 
device haslollipopapi 
fixme ripple doesn work background masked ripple works fine ugly 
apply ripple drawable with slightly extended abilities such 
setting color filter 
colorstatelist container getresources getcolorstatelist color ripple_dark 
mbuttonplaypause setbackground rippledrawable null null 
else 
rippleutils makefor false true 
mbuttonnext 
mbuttonplaypause 
mbuttonprevious 
updateplaypausebuttoncolor martworkcolor 
updateseekbarcolor martworkcolor 
return sceneview 
override 
public void onclick nonnull view 
action 
mbuttonprevious 
action mediacontroller action_skip_to_previous 
else mbuttonplaypause 
action mediacontroller action_play_pause 
else mbuttonnext 
action mediacontroller action_skip_to_next 
else 
received click event from unknown view 
return 
mmediacontroller sendmediaaction action 
mcallback requesttimeoutrestart this 
override 
public boolean onlongclick nonnull view 
mbuttonplaypause 
mmediacontroller sendmediaaction mediacontroller action_stop 
else 
received long click event from unknown view 
return false 
mcallback requesttimeoutrestart this 
return true 
seeking songs 
inheritdoc 
override 
public void onprogresschanged seekbar seekbar progress boolean fromuser 
fromuser 
final long position getplaybackseekposition 
mpositiontext settext formattime position 
inheritdoc 
override 
public void onstarttrackingtouch seekbar seekbar 
mseekbartracking true 
mcallback requesttimeoutrestart mediawidget this 
inheritdoc 
override 
public void onstoptrackingtouch seekbar seekbar 
mseekbartracking 
final long position getplaybackseekposition 
debug seeking position 
mmediacontroller getmetadata duration 
mmediacontroller seekto position 
mseekbartracking false 
private long getplaybackseekposition 
double mseekbar getprogress 
double mseekbar getmax 
double ratio 
long duration mmediacontroller getmetadata duration 
return long math ceil duration ratio 
nonnull 
private string formattime long time 
time millis 
time 
time 
return formatnumber formatnumber 
nonnull 
private string formatnumber 
string integer tostring 
return 
