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
import achep acdisplay config 
import achep acdisplay 
created artem 
public class activemodesettings extends basesettings 
override 
public void oncreate bundle savedinstancestate 
super oncreate savedinstancestate 
requestmasterswitch config key_active_mode 
addpreferencesfromresource settings_active_fragment 
syncpreference config key_active_mode_respect_inactive_time 
syncpreference config key_active_mode_without_notifications 
syncpreference config key_active_mode_active_charging 
syncpreference config key_active_mode_disable_on_low_battery 
syncpreference config key_active_mode_wave_to_wake 
