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

package achep acdisplay services switches 
import android content broadcastreceiver 
import android content context 
import android content intent 
import android content intentfilter 
import android support annotation nonnull 
import achep acdisplay services switch 
import achep base content configbase 
import achep base utils power powerutils 
prevents link achep acdisplay services switchservice from working 
while battery level link battery_low_level 
author artem chepurnoy 
public final class batteryoutswitch extends switch optional 
private static final battery_low_level 
private boolean mbatteryplugged 
private mbatterylevel 
private final broadcastreceiver mreceiver broadcastreceiver 
override 
public void onreceive context context intent intent 
switch intent getaction 
case intent action_battery_changed 
mbatterylevel powerutils getbatterylevel intent 
mbatteryplugged powerutils isplugged intent 
update state 
isactiveinternal 
requestactiveinternal 
else 
requestinactiveinternal 
break 
public batteryoutswitch 
nonnull context context 
nonnull callback callback 
nonnull configbase option option boolean isoptioninverted 
super context callback option isoptioninverted 
override 
public void oncreate 
intentfilter intentfilter intentfilter 
intentfilter addaction intent action_battery_changed 
intent intent getcontext registerreceiver mreceiver intentfilter 
mbatterylevel powerutils getbatterylevel intent 
mbatteryplugged powerutils isplugged intent 
override 
public void ondestroy 
getcontext unregisterreceiver mreceiver 
override 
public boolean isactiveinternal 
return mbatteryplugged mbatterylevel battery_low_level 
