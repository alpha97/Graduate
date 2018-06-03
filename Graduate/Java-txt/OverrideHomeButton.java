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

package achep acdisplay plugins xposed 
import android content broadcastreceiver 
import android content context 
import android content intent 
import android content intentfilter 
import achep acdisplay 
import robv android xposed ixposedhookzygoteinit 
import robv android xposed xc_methodhook 
import static robv android xposed xposedhelpers findandhookmethod 
import static robv android xposed xposedhelpers getobjectfield 
public class overridehomebutton implements ixposedhookzygoteinit 
private static boolean active false 
override 
public void initzygote startupparam startupparam throws throwable 
register broadcastreceiver phonewindowmanager init that 
enable disable home button demand 
findandhookmethod android internal policy impl phonewindowmanager null init 
context class android view iwindowmanager android view windowmanagerpolicy windowmanagerfuncs 
xc_methodhook 
override 
protected void afterhookedmethod methodhookparam param throws throwable 
broadcastreceiver receiver broadcastreceiver 
override 
public void onreceive context context intent intent 
switch intent getaction 
case action_eat_home_press_start 
active true 
break 
case action_eat_home_press_stop 
active false 
break 
intentfilter filter intentfilter 
filter addaction action_eat_home_press_start 
filter addaction action_eat_home_press_stop 
context context context getobjectfield param thisobject mcontext 
context registerreceiver receiver filter 
active have phonewindowmanager launchhomefromhotkey nothing 
findandhookmethod android internal policy impl phonewindowmanager null launchhomefromhotkey 
xc_methodhook 
override 
protected void beforehookedmethod methodhookparam param throws throwable 
active 
param setresult null 
