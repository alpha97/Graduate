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
import achep acdisplay config 
import achep acdisplay 
development settings fragment 
author artem chepurnoy 
public class devsettings extends basesettings implements 
preference onpreferenceclicklistener 
private preference msensorsdumpsendpreference 
override 
public void oncreate bundle savedinstancestate 
super oncreate savedinstancestate 
addpreferencesfromresource settings_dev_fragment 
syncpreference config key_dev_sensors_dump 
msensorsdumpsendpreference findpreference dev_sensors_dump_send 
msensorsdumpsendpreference setonpreferenceclicklistener this 
override 
public boolean onpreferenceclick preference preference 
preference msensorsdumpsendpreference 
else 
return false 
return true 
