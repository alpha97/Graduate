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

package achep acdisplay widgets 
import android content broadcastreceiver 
import android content context 
import android content intent 
import android content intentfilter 
import android text format time 
import android util attributeset 
import achep base widgets textview 
import achep base utils dateutils 
created artem 
public class timeview extends textview 
private static final string timeview 
private mlasttime 
private broadcastreceiver mintentreceiver broadcastreceiver 
override 
public void onreceive context context intent intent 
switch intent getaction 
case intent action_time_tick 
case intent action_time_changed 
case intent action_timezone_changed 
updateclock 
break 
public timeview context context attributeset attrs 
super context attrs 
override 
protected void onattachedtowindow 
super onattachedtowindow 
intentfilter filter intentfilter 
filter addaction intent action_time_tick 
filter addaction intent action_time_changed 
filter addaction intent action_timezone_changed 
getcontext registerreceiver mintentreceiver filter null null 
updateclock 
override 
protected void ondetachedfromwindow 
super ondetachedfromwindow 
getcontext unregisterreceiver mintentreceiver 
protected void updateclock 
time time time 
time settonow 
time hour time minute 
mlasttime 
settext dateutils formattime getcontext time hour time minute 
mlasttime 
