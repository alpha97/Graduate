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

package painless 
import android content broadcastreceiver 
import android content context 
import android content intent 
public abstract class powertogglesplugin extends broadcastreceiver 
intent send powertoggles asking state change 
public static final string action_set_state painless action_set_state 
intent send powertoggles notifying state changes 
public static final string action_state_changed painless action_state_changed 
intent extra denoting state value must boolean 
public static final string extra_state state 
must class name receiver when informing powertoggles 
state change 
public static final string extra_varid varid 
override 
public void onreceive context context intent intent 
action_set_state equals intent getaction 
changestate context intent getbooleanextra extra_state false 
called when powertoggles widget requests state change because 
user clicked corresponding toggle 
protected abstract void changestate context context boolean newstate 
updates plugin state powertoggles widget 
public final void sendstateupdate context context boolean newstate 
sendstateupdate this getclass newstate context 
updates plugin state powertoggles widget 
param pluginclass receiver implementing plugin application 
define multiple plugins with receiver plugin 
param newstate 
param context 
public static void sendstateupdate class extends powertogglesplugin pluginclass 
boolean newstate context context 
context sendbroadcast intent action_state_changed 
putextra extra_varid pluginclass getname 
putextra extra_state newstate 
