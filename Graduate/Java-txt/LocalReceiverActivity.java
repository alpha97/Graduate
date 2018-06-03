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
import android activity 
import android admin devicepolicymanager 
import android content activitynotfoundexception 
import android content componentname 
import android content context 
import android content intent 
import android 
import android bundle 
import android provider settings 
import android support annotation nullable 
import android util 
import achep acdisplay 
import achep base utils packageutils 
import achep base utils toastutils 
created artem 
public class localreceiveractivity extends activity 
private static final string localreceiveractivity 
private static final string host_uninstall uninstall 
private static final string host_launch_app_info launch_app_info 
private static final string host_remove_admin_access remove_admin_access 
override 
protected void oncreate bundle savedinstancestate 
super oncreate savedinstancestate 
handleintent getintent 
finish 
private void handleintent nullable intent intent 
data 
string host 
intent null 
data intent getdata null 
host data gethost null return 
switch host 
case host_remove_admin_access 
removedeviceadminrights 
break 
case host_uninstall 

removedeviceadminrights 
startactivity intent 
intent action_uninstall_package 
fromparts package packageutils getname this null 
catch activitynotfoundexception 
failed start uninstall activity 
break 
case host_launch_app_info 

startactivity intent 
settings action_application_details_settings 
fromparts package packageutils getname this null 
catch activitynotfoundexception 
failed start applicationdetails activity 
break 
private void removedeviceadminrights 
componentname component adminreceiver newcomponentname this 
devicepolicymanager devicepolicymanager 
getsystemservice context device_policy_service 
isadminactive component 

removeactiveadmin component 
toastutils showshort this string permissions_device_admin_removed 
catch securityexception ignored 
