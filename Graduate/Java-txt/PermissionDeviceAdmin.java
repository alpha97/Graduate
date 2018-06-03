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

package achep acdisplay permissions 
import android admin devicepolicymanager 
import android content componentname 
import android content context 
import android content intent 
import android support annotation drawableres 
import android support annotation nonnull 
import android support annotation stringres 
import achep acdisplay 
import achep acdisplay receiver adminreceiver 
import achep base permissions permission 
device admin permission 
author artem chepurnoy 
android admin devicepolicymanager 
public final class permissiondeviceadmin extends permission 
nonnull 
private final componentname mcomponent 
public permissiondeviceadmin nonnull context context 
super context 
mcomponent componentname mcontext adminreceiver class 
inheritdoc 
public boolean isgranted 
return getdpmservice isadminactive mcomponent 
inheritdoc 
override 
public boolean exists nonnull context context 
return true 
nonnull 
private devicepolicymanager getdpmservice 
return devicepolicymanager mcontext getsystemservice context device_policy_service 
inheritdoc 
nonnull 
override 
public intent getintentsettings 
return intent devicepolicymanager action_add_device_admin 
putextra devicepolicymanager extra_device_admin mcomponent 

inheritdoc 
drawableres 
public geticonresource 
return drawable ic_dialog_timeout_white 
inheritdoc 
stringres 
public gettitleresource 
return string permissions_device_admin 
inheritdoc 
stringres 
public getsummaryresource 
return string permissions_device_admin_description 
inheritdoc 
stringres 
public geterrorresource 
return string permissions_device_admin_grant_manually 
