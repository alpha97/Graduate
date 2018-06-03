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
import android preference preference 
import android support annotation nonnull 
import achep acdisplay config 
import achep acdisplay 
import achep base content configbase 
import achep base utils resutils 
interface settings fragment 
author artem chepurnoy 
public class interfacesettings extends basesettings implements 
configbase onconfigchangedlistener 
private preference miconsizepreference 
override 
public void oncreate bundle savedinstancestate 
super oncreate savedinstancestate 
addpreferencesfromresource settings_interface_fragment 
syncpreference config key_ui_dynamic_background_mode 
multiselectlistpreferencesetter getactivity 
string settings_dynamic_background_summary 
string settings_dynamic_background_disabled 
syncpreference config key_ui_wallpaper_shown 
syncpreference config key_ui_status_battery_sticky 
syncpreference config key_ui_fullscreen 
syncpreference config key_ui_override_fonts 
syncpreference config key_ui_emoticons 
syncpreference config key_ui_unlock_animation 
miconsizepreference findpreference icon_size 
override 
public void onresume 
super onresume 
config config getconfig 
config registerlistener this 
updateiconsizesummary config 
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
case config key_ui_icon_size 
updateiconsizesummary config 
break 
private void updateiconsizesummary config config 
string summary resutils getstring getresources 
string settings_icon_size_summary 
integer tostring config geticonsize config icon_size_dp 
miconsizepreference setsummary summary 
