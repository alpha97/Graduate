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

package achep acdisplay widgets status 
import android content context 
import android support annotation nonnull 
import android util attributeset 
import android widget linearlayout 
import achep acdisplay config 
import achep acdisplay 
import achep base content configbase 
import achep base utils operator 
import achep base utils viewutils 
created achep 
public class statuswidget extends linearlayout implements 
configbase onconfigchangedlistener 
batterymeterview onbatterychangedlistener 
private batterymeterview mbatterymeterview 
public statuswidget context context 
super context 
public statuswidget context context attributeset attrs 
super context attrs 
public statuswidget context context attributeset attrs defstyle 
super context attrs defstyle 
override 
protected void onfinishinflate 
super onfinishinflate 
mbatterymeterview batterymeterview findviewbyid battery 
mbatterymeterview setonbatterychangedlistener this 
override 
protected void onattachedtowindow 
super onattachedtowindow 
isineditmode 
config config config getinstance 
config registerlistener this 
updatebatteryvisibility 
override 
protected void ondetachedfromwindow 
super ondetachedfromwindow 
isineditmode 
config config config getinstance 
config unregisterlistener this 
override 
public void onbatterychanged batterymeterview view event 
operator bitand event batterymeterview event_charging 
operator bitand event batterymeterview event_level 
updatebatteryvisibility 
override 
public void onconfigchanged nonnull configbase config 
nonnull string 
nonnull object value 
switch 
case config key_ui_status_battery_sticky 
updatebatteryvisibility 
break 
private void updatebatteryvisibility 
boolean visible config getinstance isstatusbatterysticky 
mbatterymeterview getbatterycharging 
mbatterymeterview getbatterylevel 
viewutils setvisible mbatterymeterview visible 
