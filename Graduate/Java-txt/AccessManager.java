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
import android content context 
import android support annotation nonnull 
import achep base device 
import achep base interfaces ionlowmemory 
import achep base permissions permission 
import achep base permissions permissiongroup 
author artem chepurnoy 
public class accessmanager implements ionlowmemory 
nonnull 
private final permissiongroup mmasterpermissions 
nonnull 
private final permissiongroup mkeyguardpermissions 
public accessmanager nonnull context context 
context context getapplicationcontext 
permissiongroup builder builder 
builder permissiongroup builder context 
builder permission permission_device_admin 
builder device hasjellybeanmr 
permission permission_notification_listener 
permission permission_accessibility 
mmasterpermissions builder build 
builder permissiongroup builder context 
device haslollipopapi builder permission permission_usage_stats 
mkeyguardpermissions builder build 
inheritdoc 
override 
public void onlowmemory 
mmasterpermissions onlowmemory 
mkeyguardpermissions onlowmemory 
return group permissions which required basic 
functionality 
nonnull 
public permissiongroup getmasterpermissions 
return mmasterpermissions 
return group permissions which required 
keyguard functionality 
nonnull 
public permissiongroup getkeyguardpermissions 
return mkeyguardpermissions 
