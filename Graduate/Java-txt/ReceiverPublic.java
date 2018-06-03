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
import android util 
import achep acdisplay 
import achep acdisplay config 
import achep acdisplay 
import achep base utils toastutils 
created artem 
public class receiverpublic extends broadcastreceiver 
private static final string publicreceiver 
override 
public void onreceive context context intent intent 
config config config getinstance 
string action intent getaction 
switch action 
case action_enable 
enabling acdisplay intent intent 
setacdisplayenabled context config true 
break 
case action_disable 
disabling acdisplay intent intent 
setacdisplayenabled context config false 
break 
case action_toggle 
toggling acdisplay intent intent 
setacdisplayenabled context config config isenabled 
break 
active mode 
case action_active_mode_enable 
enabling active mode intent intent 
setactivemodeenabled context config true 
break 
case action_active_mode_disable 
disabling active mode intent intent 
setactivemodeenabled context config false 
break 
case action_active_mode_toggle 
toggling active mode intent intent 
setactivemodeenabled context config config isenabled 
break 
tries link achep acdisplay config setenabled android content context boolean achep acdisplay config onconfigchangedlistener enable disable 
acdisplay shows toast message about result 
param enable code true enable acdisplay code false disable 
private void setacdisplayenabled context context config config boolean enable 
enable getaccessmanager getmasterpermissions isgranted 
config setenabled context enable null 
toastutils showlong context enable 
string remote_enable_acdisplay 
string remote_disable_acdisplay 
private void setactivemodeenabled context context config config boolean enable 
config getmap config key_active_mode write config context enable null 
toastutils showlong context enable 
string remote_enable_active_mode 
string remote_disable_active_mode 
