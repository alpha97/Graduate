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

package achep base utils power 
import android annotation suppresslint 
import android content context 
import android content intent 
import android content intentfilter 
import android hardware display displaymanager 
import android batterymanager 
import android powermanager 
import android support annotation nonnull 
import android support annotation nullable 
import android view display 
import achep base device 
import achep base utils operator 
import java lang reflect method 
import timber timber 
helper class with utils related power 
author artem chepurnoy 
public class powerutils 
private static final string powerutils 
return true device plugged this moment false otherwise 
isplugged android content intent 
public static boolean isplugged nonnull context context 
intentfilter intentfilter intentfilter intent action_battery_changed 
return isplugged context getapplicationcontext registerreceiver null intentfilter 
return true device plugged this moment false otherwise 
isplugged android content context 
suppresslint inlinedapi 
public static boolean isplugged nullable intent intent 
intent null 
return false 
final plugged intent getintextra batterymanager extra_plugged 
return plugged batterymanager battery_plugged_ac 
plugged batterymanager battery_plugged_usb 
plugged batterymanager battery_plugged_wireless 
suppresslint newapi 
public static boolean isscreenon nonnull context context 
display_api 
device haskitkatwatchapi 
displaymanager displaymanager context getsystemservice context display_service 
display displays getdisplays null 
display display null 
displays null displays length 
break display_api 
else displays length 
timber number logical displays displays length 
display displays 
final boolean virtual operator bitand getflags display flag_presentation 
isvalid virtual 
display 
final type 

method method display class getdeclaredmethod gettype 
method setaccessible true 
type method invoke 
catch exception 
continue 
type built display 
break 
display null 
return false 
timber display state display getstate 
return display getstate display state_on 
powermanager powermanager context getsystemservice context power_service 
return isinteractive 
returns code true device interactive state 
suppresswarnings deprecation 
suppresslint newapi 
public static boolean isinteractive nonnull powermanager 
return device haslollipopapi 
isinteractive 
isscreenon 
isplugged android content context 
isplugged android content intent 
suppresslint inlinedapi 
public static getbatterylevel nullable intent intent 
intent null 
return 
final level intent getintextra batterymanager extra_level 
final scale intent getintextra batterymanager extra_scale 
return level scale 
