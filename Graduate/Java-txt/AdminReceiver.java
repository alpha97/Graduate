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
import android content componentname 
import android content context 
import android content intent 
import android support content localbroadcastmanager 
import android widget toast 
import achep acdisplay config 
import achep acdisplay 
created artem 
public class adminreceiver extends android admin deviceadminreceiver 
public static final string action_disabled device_admin_disabled 
public static final string action_enabled device_admin_enabled 
override 
public void ondisabled context context intent intent 
super ondisabled context intent 
localbroadcastmanager getinstance context sendbroadcast intent action_disabled 
config config config getinstance 
config isenabled 
toast maketext context string permissions_auto_disabled toast length_long show 
config setenabled context false null auto disabling 
override 
public void onenabled context context intent intent 
super onenabled context intent 
localbroadcastmanager getinstance context sendbroadcast intent action_enabled 
public static componentname newcomponentname context context 
return componentname context adminreceiver class 
