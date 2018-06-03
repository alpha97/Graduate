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

package achep acdisplay fragments settings 
import android bundle 
import android preference listpreference 
import android preference preference 
import android preference preferencegroup 
import android support annotation nonnull 
import achep acdisplay config 
import achep acdisplay 
import achep base content configbase 
import achep base utils dateutils 
import achep base utils resutils 
import afollestad materialdialogs dialogaction 
import afollestad materialdialogs materialdialog 
import static achep base build debug 
created artem 
public class moresettings extends basesettings implements 
configbase onconfigchangedlistener 
preference onpreferenceclicklistener 
private final listpreferencesetter mlistpreferencecorneractionsetter 
listpreferencesetter 
override 
public void updatesummary nonnull preference preference 
nonnull config option option 
nonnull object value 
value 
listpreference listpreference preference 
setsummary getentries 
private preference minactivehourspreference 
private preference mtimeoutpreference 
private preference mdatarestoredefaultspreference 
private preference mdatabackuppreference 
private preference mdatarestorepreference 
override 
public void oncreate bundle savedinstancestate 
super oncreate savedinstancestate 
addpreferencesfromresource settings_more_fragment 
syncpreference config key_privacy 
multiselectlistpreferencesetter getactivity 
string settings_privacy_mode_disabled 
syncpreference config key_only_while_charging 
syncpreference config key_feel_screen_off_after_last_notify 
syncpreference config key_double_tap_to_sleep 
syncpreference config key_media_widget 
syncpreference config key_feel_widget_pinnable 
syncpreference config key_feel_widget_readable 
syncpreference config key_corner_action_left_top mlistpreferencecorneractionsetter 
syncpreference config key_corner_action_left_bottom mlistpreferencecorneractionsetter 
syncpreference config key_corner_action_right_top mlistpreferencecorneractionsetter 
syncpreference config key_corner_action_right_bottom mlistpreferencecorneractionsetter 
minactivehourspreference findpreference inactive_hours 
mtimeoutpreference findpreference timeout 
back restore 
mdatarestoredefaultspreference findpreference data_restore_defaults 
mdatabackuppreference findpreference data_backup 
mdatarestorepreference findpreference data_restore 
mdatarestoredefaultspreference setonpreferenceclicklistener this 
mdatabackuppreference setonpreferenceclicklistener this 
mdatarestorepreference setonpreferenceclicklistener this 
debug 
preferencegroup preferencegroup findpreference data_category 
removepreference mdatabackuppreference 
removepreference mdatarestorepreference 
override 
public void onresume 
super onresume 
config config getconfig 
config registerlistener this 
updateinactivehourssummary config 
updatetimeoutsummary config 
override 
public void onpause 
super onpause 
config config getconfig 
config unregisterlistener this 
override 
public void onconfigchanged nonnull configbase configbase 
nonnull string 
nonnull object value 
config config config configbase 
switch 
case config key_inactive_time_enabled 
case config key_inactive_time_from 
case config key_inactive_time_to 
updateinactivehourssummary config 
break 
case config key_timeout_normal 
case config key_timeout_short 
updatetimeoutsummary config 
break 
private void updateinactivehourssummary config config 
config isinactivetimeenabled 
from config getinactivetimefrom 
config getinactivetimeto 
minactivehourspreference setsummary resutils getstring getresources 
string settings_inactive_hours_enabled 
dateutils formattime getactivity from from 
dateutils formattime getactivity 
else 
minactivehourspreference setsummary getstring string settings_inactive_hours_disabled 
private void updatetimeoutsummary config config 
mtimeoutpreference setsummary resutils getstring getresources 
string settings_timeout_summary 
float tostring config gettimeoutnormal 
float tostring config gettimeoutshort 
inheritdoc 
override 
public boolean onpreferenceclick preference preference 
preference mdatarestoredefaultspreference 
materialdialog builder getactivity 
title string settings_restore_defaults_warning_title 
content string settings_restore_defaults_warning_message 
positivetext android string 
negativetext android string cancel 
onpositive materialdialog singlebuttoncallback 
override 
public void onclick nonnull materialdialog materialdialog 
nonnull dialogaction dialogaction 
config getinstance reset getactivity 
build 
show 
else preference mdatabackuppreference 
todo back things 
else preference mdatarestorepreference 
todo restore things 
else 
return false 
return true 
