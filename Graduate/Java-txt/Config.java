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

package achep acdisplay 
import android content context 
import android content resources 
import android support annotation nonnull 
import android support annotation nullable 
import android util displaymetrics 
import android util typedvalue 
import achep acdisplay notifications notificationpresenter 
import achep acdisplay plugins powertoggles togglereceiver 
import achep acdisplay services keyguardservice 
import achep acdisplay services sensorsdumpservice 
import achep acdisplay services activemode activemodeservice 
import achep base content configbase 
import java util 
saves configurations 
author artem chepurnoy 
since 
suppresswarnings constantconditions unused 
public final class config extends configbase 
private static final string config 
public static final string key_enabled enabled 
public static final string key_only_while_charging only_while_charging 
notifications 
public static final string key_notify_min_priority notify_min_priority 
public static final string key_notify_max_priority notify_max_priority 
public static final string key_notify_wake_up_on notify_wake_up_on 
public static final string key_notify_glance notify_glance 
inactive time 
public static final string key_inactive_time_from inactive_time_from 
public static final string key_inactive_time_to inactive_time_to 
public static final string key_inactive_time_enabled inactive_time_enabled 
timeouts 
public static final string key_timeout_normal timeout_normal 
public static final string key_timeout_short timeout_short 
keyguard 
public static final string key_keyguard keyguard 
public static final string key_keyguard_respect_inactive_time keyguard_respect_inactive_time 
public static final string key_keyguard_without_notifications keyguard_without_notifications 
public static final string key_keyguard_lock_delay keyguard_lock_delay 
active mode 
public static final string key_active_mode active_mode 
public static final string key_active_mode_respect_inactive_time active_mode_respect_inactive_time 
public static final string key_active_mode_without_notifications active_mode_without_notifications 
public static final string key_active_mode_active_charging active_mode_active_charging 
public static final string key_active_mode_disable_on_low_battery active_mode_disable_on_low_battery 
public static final string key_active_mode_wave_to_wake active_mode_wave_to_wake 
interface 
public static final string key_ui_fullscreen ui_fullscreen 
public static final string key_ui_wallpaper_shown wallpaper_shown 
public static final string key_ui_dynamic_background_mode dynamic_background_mode 
public static final dynamic_bg_artwork_mask 
public static final dynamic_bg_notification_mask 
public static final string key_ui_status_battery_sticky ui_status_battery_sticky 
public static final string key_ui_icon_size ui_condensed_view_size 
public static final string icon_size_px 
public static final string icon_size_dp 
public static final string key_ui_unlock_animation unlock_animation 
public static final string key_ui_circle_color_inner ui_circle_color_inner 
public static final string key_ui_circle_color_outer ui_circle_color_outer 
public static final string key_ui_override_fonts ui_override_fonts 
public static final string key_ui_emoticons ui_emoticons 
public static final string key_ui_custom_widget ui_custom_widget 
public static final string key_ui_custom_widget_id ui_custom_widget_id 
public static final string key_ui_custom_widget_height_dp ui_custom_widget_height 
public static final string key_ui_custom_widget_width_dp ui_custom_widget_width 
public static final string key_ui_custom_widget_touchable ui_custom_widget_touchable 
behavior 
public static final string key_feel_screen_off_after_last_notify feel_widget_screen_off_after_last_notify 
public static final string key_feel_widget_pinnable feel_widget_pinnable 
public static final string key_feel_widget_readable feel_widget_readable 
public static final string key_privacy privacy_mode 
public static final privacy_hide_content_mask 
public static final privacy_hide_actions_mask 
public static final string key_double_tap_to_sleep double_tap_to_sleep 
public static final string key_media_widget media_widget 
public static final string key_corner_action_left_top corner_action_left_top 
public static final string key_corner_action_right_top corner_action_right_top 
public static final string key_corner_action_left_bottom corner_action_left_bottom 
public static final string key_corner_action_right_bottom corner_action_right_bottom 
default corner action simply unlocks device 
public static final corner_unlock 
launches camera 
public static final corner_launch_camera 
launches dialer 
public static final corner_launch_dialer 
development 
public static final string key_dev_sensors_dump dev_sensors_dump 
triggers 
public static final string key_trig_previous_version trigger_previous_version 
public static final string key_trig_help_read trigger_dialog_help 
public static final string key_trig_translated trigger_translated 
public static final string key_trig_launch_count trigger_launch_count 
public static final string key_trig_donation_asked trigger_donation_asked 
private static config sconfig 
private boolean menabled 
private boolean mkeyguardenabled 
private boolean mkeyguardrespectinactivetime 
private boolean mkeyguardwithoutnotifies 
private boolean mactivemode 
private boolean mactivemoderespectinactivetime 
private boolean mactivemodewithoutnotifies 
private boolean mactivemodeactivecharging 
private boolean mactivemodedisableonlowbattery 
private boolean mactivemodewave wake 
private boolean menabledonlywhilecharging 
private boolean mscreenoffafterlastnotify 
private boolean mdoubletaptosleep 
private boolean mmediawidget 
private boolean mfeelwidgetpinnable 
private boolean mfeelwidgetreadable 
private boolean mnotifywakeupon 
private boolean mnotifyglance 
private mnotifyminpriority 
private mnotifymaxpriority 
private mtimeoutnormal 
private mtimeoutshort 
private minactivetimefrom 
private minactivetimeto 
private muidynamicbackground 
private muiiconsize 
private muicustomwidgetid 
private muicustomwidgetwidthdp 
private muicustomwidgetheightdp 
private muicirclecolorinner 
private muicirclecolorouter 
private mprivacymode 
private mcorneractionlefttop 
private mcorneractionrighttop 
private mcorneractionleftbottom 
private mcorneractionrightbottom 
private mkeyguardlockdelay 
private boolean minactivetimeenabled 
private boolean muifullscreen 
private boolean muioverridefonts 
private boolean muiemoticons 
private boolean muiwallpaper 
private boolean muibatterysticky 
private boolean muiunlockanimation 
private boolean muicustomwidget 
private boolean muicustomwidgettouchable 
private boolean mdevsensorsdump 
private final triggers mtriggers 
private mtrigpreviousversion 
private mtriglaunchcount 
private boolean mtrigtranslated 
private boolean mtrighelpread 
private boolean mtrigdonationasked 
nonnull 
public static synchronized config getinstance 
sconfig null 
sconfig config 
return sconfig 
private config 
mtriggers triggers 
loads saved values from shared preferences 
this called link create 
void init nonnull context context 
initinternal context 
public void reset nonnull context context 
resetinternal context 
override 
protected void oncreatemap nonnull string option 
key_enabled configbase option 
menabled setenabled isenabled boolean class 
setdefaultres bool config_default_enabled 
key_keyguard configbase option 
mkeyguardenabled null null boolean class 
setdefaultres bool config_default_keyguard_enabled 
key_keyguard_respect_inactive_time configbase option 
mkeyguardrespectinactivetime null null boolean class 
setdefaultres bool config_default_keyguard_respect_inactive_time 
key_keyguard_without_notifications configbase option 
mkeyguardwithoutnotifies null null boolean class 
setdefaultres bool config_default_keyguard_without_notifies_enabled 
key_keyguard_lock_delay configbase option 
mkeyguardlockdelay null null class 
setdefaultres integer config_default_keyguard_lock_delay 
key_active_mode configbase option 
mactivemode null null boolean class 
setdefaultres bool config_default_active_mode_enabled 
key_active_mode_respect_inactive_time configbase option 
mactivemoderespectinactivetime null null boolean class 
setdefaultres bool config_default_active_mode_respect_inactive_time 
key_active_mode_without_notifications configbase option 
mactivemodewithoutnotifies null null boolean class 
setdefaultres bool config_default_active_mode_without_notifies_enabled 
key_active_mode_active_charging configbase option 
mactivemodeactivecharging null null boolean class 
setdefaultres bool config_default_active_mode_active_charging 
key_active_mode_disable_on_low_battery configbase option 
mactivemodedisableonlowbattery null null boolean class 
setdefaultres bool config_default_active_mode_disable_on_low_battery 
key_active_mode_wave_to_wake configbase option 
mactivemodewave wake null null boolean class 
setdefaultres bool config_default_active_mode_wave_to_wake 
notifications 
key_notify_wake_up_on configbase option 
mnotifywakeupon null null boolean class 
setdefaultres bool config_default_notify_wake_up_on 
key_notify_glance configbase option 
mnotifyglance null null boolean class 
setdefaultres bool config_default_notify_glance 
key_notify_min_priority configbase option 
mnotifyminpriority null null class 
setdefaultres integer config_default_notify_min_priority 
key_notify_max_priority configbase option 
mnotifymaxpriority null null class 
setdefaultres integer config_default_notify_max_priority 
timeout 
key_timeout_normal configbase option 
mtimeoutnormal null null class 
setdefaultres integer config_default_timeout_normal 
key_timeout_short configbase option 
mtimeoutshort null null class 
setdefaultres integer config_default_timeout_short 
inactive time 
key_inactive_time_enabled configbase option 
minactivetimeenabled null null boolean class 
setdefaultres bool config_default_inactive_time_enabled 
key_inactive_time_from configbase option 
minactivetimefrom null null class 
setdefaultres integer config_default_inactive_time_from 
key_inactive_time_to configbase option 
minactivetimeto null null class 
setdefaultres integer config_default_inactive_time_to 
interface 
key_ui_fullscreen configbase option 
muifullscreen null null boolean class 
setdefaultres bool config_default_ui_full_screen 
key_ui_wallpaper_shown configbase option 
muiwallpaper null null boolean class 
setdefaultres bool config_default_ui_show_wallpaper 
key_ui_status_battery_sticky configbase option 
muibatterysticky null null boolean class 
setdefaultres bool config_default_ui_status_battery_sticky 
key_ui_dynamic_background_mode configbase option 
muidynamicbackground null null class 
setdefaultres integer config_default_ui_show_shadow_dynamic_bg 
key_ui_circle_color_inner configbase option 
muicirclecolorinner null null class 
setdefault xfff 
key_ui_circle_color_outer configbase option 
muicirclecolorouter null null class 
setdefault 
key_ui_unlock_animation configbase option 
muiunlockanimation null null boolean class 
setdefaultres bool config_default_ui_unlock_animation 
key_ui_emoticons configbase option 
muiemoticons null null boolean class 
setdefaultres bool config_default_ui_emoticons 
key_ui_override_fonts configbase option 
muioverridefonts null null boolean class 
setdefaultres bool config_default_ui_override_fonts 
key_ui_custom_widget configbase option 
muicustomwidget null null boolean class 
setdefaultres bool config_default_ui_custom_widget 
key_ui_custom_widget_id configbase option 
muicustomwidgetid null null class 
setdefault 
key_ui_custom_widget_width_dp configbase option 
muicustomwidgetwidthdp null null class 
setdefault 
key_ui_custom_widget_height_dp configbase option 
muicustomwidgetheightdp null null class 
setdefault 
key_ui_custom_widget_touchable configbase option 
muicustomwidgettouchable null null boolean class 
setdefaultres bool config_default_ui_custom_widget_touchable 
key_ui_icon_size configbase option 
muiiconsize null null class 
setdefaultres integer config_default_ui_icon_size_dp 
development 
key_dev_sensors_dump configbase option 
mdevsensorsdump null null boolean class 
setdefaultres bool config_default_dev_sensors_dump 
other 
key_only_while_charging configbase option 
menabledonlywhilecharging null null boolean class 
setdefaultres bool config_default_enabled_only_while_charging 
key_feel_screen_off_after_last_notify configbase option 
mscreenoffafterlastnotify null null boolean class 
setdefaultres bool config_default_feel_screen_off_after_last_notify 
key_feel_widget_pinnable configbase option 
mfeelwidgetpinnable null null boolean class 
setdefaultres bool config_default_feel_widget_pinnable 
key_feel_widget_readable configbase option 
mfeelwidgetreadable null null boolean class 
setdefaultres bool config_default_feel_widget_readable 
key_privacy configbase option 
mprivacymode null null class 
setdefaultres integer config_default_privacy_mode 
key_double_tap_to_sleep configbase option 
mdoubletaptosleep null null boolean class 
setdefaultres bool config_default_double_tap_to_sleep 
key_media_widget configbase option 
mmediawidget null null boolean class 
setdefaultres bool config_default_media_widget 
key_corner_action_left_top configbase option 
mcorneractionlefttop null null class 
setdefaultres integer config_default_corner_left_top 
key_corner_action_right_top configbase option 
mcorneractionrighttop null null class 
setdefaultres integer config_default_corner_right_top 
key_corner_action_left_bottom configbase option 
mcorneractionleftbottom null null class 
setdefaultres integer config_default_corner_left_bottom 
key_corner_action_right_bottom configbase option 
mcorneractionrightbottom null null class 
setdefaultres integer config_default_corner_right_bottom 
triggers 
key_trig_donation_asked configbase option 
mtrigdonationasked null null boolean class 
setdefault false 
key_trig_help_read configbase option 
mtrighelpread null null boolean class 
setdefault false 
key_trig_launch_count configbase option 
mtriglaunchcount null null class 
setdefault 
key_trig_previous_version configbase option 
mtrigpreviousversion null null class 
setdefault 
key_trig_translated configbase option 
mtrigtranslated null null boolean class 
setdefault false 
override 
protected void onoptionchanged nonnull option option nonnull string 
switch 
case key_active_mode 
activemodeservice handlestate getcontext 
break 
case key_keyguard 
keyguardservice handlestate getcontext 
break 
case key_enabled 
togglereceiver sendstateupdate togglereceiver class menabled getcontext 
notificationpresenter getinstance setonnotificationpostedlistener isenabled 
presenter getinstance 
null 
case key_only_while_charging 
activemodeservice handlestate getcontext 
keyguardservice handlestate getcontext 
break 
case key_dev_sensors_dump 
sensorsdumpservice handlestate getcontext 
break 
case key_ui_custom_widget_id 
track current appwidget delete unused ones 
todo ensure cleaning appwidgets required 
object previous getpreviousvalue 
previous null 
final previous 
appwidgetutils isvalidid 
release previously allocated appwidget avoid 
memory leaks carma 
appwidgethost host myappwidgethost getcontext hostwidget host_id 
host deleteappwidgetid 
deleted appwidget 
break 
separated group different internal triggers 
nonnull 
public triggers gettriggers 
return mtriggers 

options 

setter entire enabler 
public void setenabled nonnull context context boolean enabled 
nullable onconfigchangedlistener listener 
writefrommain context getoption key_enabled enabled listener 
setter enable night mode 
public void setinactivetimeenabled nonnull context context boolean enabled 
nullable onconfigchangedlistener listener 
writefrommain context getoption key_inactive_time_enabled enabled listener 
setter time night mode should start 
public void setinactivetimefrom nonnull context context minutes 
nullable onconfigchangedlistener listener 
writefrommain context getoption key_inactive_time_from minutes listener 
setter time night mode should 
public void setinactivetimeto nonnull context context minutes 
nullable onconfigchangedlistener listener 
writefrommain context getoption key_inactive_time_to minutes listener 
sets size height only collapsed views 
param size preferred size 
geticonsizepx 
geticonsize string 
public void seticonsizedp nonnull context context size 
nullable onconfigchangedlistener listener 
writefrommain context getoption key_ui_icon_size size listener 
return delay between turning screen actual locking millis 
public getkeyguardlockdelaymillis 
return mkeyguardlockdelay 
return minimal link android notification priority notification shown 
getnotifymaxpriority 
android notification priority 
public getnotifyminpriority 
return mnotifyminpriority 
return maximum link android notification priority notification shown 
getnotifyminpriority 
android notification priority 
public getnotifymaxpriority 
return mnotifymaxpriority 
return color unlock circle 
getcircleoutercolor 
public getcircleinnercolor 
return muicirclecolorinner 
return background color unlock circle 
getcircleinnercolor 
public getcircleoutercolor 
return muicirclecolorouter 
public gettimeoutnormal 
return mtimeoutnormal 
public gettimeoutshort 
return mtimeoutshort 
public getinactivetimefrom 
return minactivetimefrom 
public getinactivetimeto 
return minactivetimeto 
public getdynamicbackgroundmode 
return muidynamicbackground 
gets current privacy mode 
return mask containing different privacy options 
privacy_hide_actions_mask 
privacy_hide_content_mask 
public getprivacymode 
return mprivacymode 
public getcustomwidgetid 
return muicustomwidgetid 
public getcustomwidgetwidthdp 
return muicustomwidgetwidthdp 
public getcustomwidgetheightdp 
return muicustomwidgetheightdp 
return action left corner screen 
achep acdisplay cornerhelper 
public getcorneractionlefttop 
return mcorneractionlefttop 
return action right corner screen 
achep acdisplay cornerhelper 
public getcorneractionrighttop 
return mcorneractionrighttop 
return action left bottom corner screen 
achep acdisplay cornerhelper 
public getcorneractionleftbottom 
return mcorneractionleftbottom 
return action right bottom corner screen 
achep acdisplay cornerhelper 
public getcorneractionrightbottom 
return mcorneractionrightbottom 
return size height only collapsed views pixels 
geticonsize string 
public geticonsizepx 
return geticonsize icon_size_px 
return size height only collapsed views 
geticonsizepx 
icon_size_dp 
icon_size_px 
public geticonsize nonnull string type 
switch type 
case icon_size_px 
displaymetrics resources getsystem getdisplaymetrics 
return typedvalue applydimension typedvalue complex_unit_dip muiiconsize 
case icon_size_dp 
return muiiconsize 
default 
throw illegalargumentexception type valid icon size type 
public boolean isenabled 
return menabled 
public boolean iskeyguardenabled 
return mkeyguardenabled 
public boolean iskeyguardwithoutnotifiesenabled 
return mkeyguardwithoutnotifies 
public boolean isactivemodeenabled 
return mactivemode 
public boolean isactivemodewithoutnotifiesenabled 
return mactivemodewithoutnotifies 
return code true always listen every device sensors while 
charging code false otherwise 
public boolean isactivemodeactivechargingenabled 
return mactivemodeactivecharging 
public boolean isenabledonlywhilecharging 
return menabledonlywhilecharging 
public boolean isnotifywakingup 
return mnotifywakeupon 
public boolean isnotifyglanceenabled 
return mnotifyglance 
public boolean iswallpapershown 
return muiwallpaper 
public boolean isstatusbatterysticky 
return muibatterysticky 
public boolean iswidgetpinnable 
return mfeelwidgetpinnable 
public boolean iswidgetreadable 
return mfeelwidgetreadable 
public boolean isinactivetimeenabled 
return minactivetimeenabled 
public boolean isfullscreen 
return muifullscreen 
public boolean isoverridingfontsenabled 
return muioverridefonts 
public boolean isemoticonsenabled 
return muiemoticons 
public boolean isscreenoffafterlastwidget 
return mscreenoffafterlastnotify 
public boolean isdoubletaptosleepenabled 
return mdoubletaptosleep 
public boolean ismediawidgetenabled 
return mmediawidget 
public boolean isunlockanimationenabled 
return muiunlockanimation 
public boolean isdevsensorsdumpenabled 
return mdevsensorsdump 
public boolean iscustomwidgetenabled 
return muicustomwidget 
public boolean iscustomwidgettouchable 
return muicustomwidgettouchable 
public boolean isactivemodewavetowakeenabled 
return mactivemodewave wake 

triggers 

contains 
author artem chepurnoy 
public class triggers 
public void setpreviousversion nonnull context context versioncode 
nullable onconfigchangedlistener listener 
writefrommain context getoption key_trig_previous_version versioncode listener 
public void sethelpread nonnull context context boolean isread 
nullable onconfigchangedlistener listener 
writefrommain context getoption key_trig_help_read isread listener 
public void setdonationasked nonnull context context boolean isasked 
nullable onconfigchangedlistener listener 
writefrommain context getoption key_trig_donation_asked isasked listener 
public void settranslated nonnull context context boolean translated 
nullable onconfigchangedlistener listener 
writefrommain context getoption key_trig_translated translated listener 
setlaunchcount android content context achep base content configbase onconfigchangedlistener 
getlaunchcount 
public void incrementlaunchcount nonnull context context 
nullable onconfigchangedlistener listener 
setlaunchcount context getlaunchcount listener 
incrementlaunchcount android content context achep base content configbase onconfigchangedlistener 
getlaunchcount 
public void setlaunchcount nonnull context context launchcount 
nullable onconfigchangedlistener listener 
writefrommain context getoption key_trig_launch_count launchcount listener 
link achep acdisplay activities mainactivity returns version 
code previously installed acdisplay code first install 
return version code previously installed acdisplay code first installation 
setpreviousversion android content context config onconfigchangedlistener 
public getpreviousversion 
return mtrigpreviousversion 
return number link achep acdisplay activities acdisplayactivity creations 
incrementlaunchcount android content context achep base content configbase onconfigchangedlistener 
setlaunchcount android content context achep base content configbase onconfigchangedlistener 
public getlaunchcount 
return mtriglaunchcount 
return code true link achep base fragments dialogs helpdialog been read 
code false otherwise 
sethelpread android content context boolean config onconfigchangedlistener 
public boolean ishelpread 
return mtrighelpread 
return code true fully translated currently used locale 
code false otherwise 
setdonationasked android content context boolean achep base content configbase onconfigchangedlistener 
public boolean istranslated 
return mtrigtranslated 
public boolean isdonationasked 
return mtrigdonationasked 
