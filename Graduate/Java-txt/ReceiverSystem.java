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

package achep acdisplay receiver 
import android content broadcastreceiver 
import android content context 
import android content intent 
import android handler 
import achep acdisplay services keyguardservice 
import achep acdisplay services sensorsdumpservice 
import achep acdisplay services activemode activemodeservice 
created artem 
public class receiversystem extends broadcastreceiver 
private static final string receiver 
private handler mhandler handler 
override 
public void onreceive final context context final intent intent 
mhandler post runnable 
override 
public void 
string action intent getaction 
switch action 
case intent action_boot_completed 
case intent action_power_connected 
case intent action_power_disconnected 
activemodeservice handlestate context 
keyguardservice handlestate context 
sensorsdumpservice handlestate context 
break 
