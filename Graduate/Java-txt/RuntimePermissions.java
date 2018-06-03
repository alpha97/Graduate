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

package achep base permissions 
import android manifest 
import android annotation suppresslint 
import android activity 
import android content context 
import android content packagemanager 
import android provider settings 
import android support annotation nonnull 
import android support annotation nullable 
import android support content contextcompat 
import achep base appheap 
import achep base device 
import achep base content cfgbase 
import achep base notifications notificationspace 
import java util hashset 
import java util 
import java util 
author artem chepurnoy 
since 
public class runtimepermissions extends cfgbase 
private static final string preferences_file_name __permissions 
nullable 
private static runtimepermissions sruntimepermissions 
return code true this permission given 
code false otherwise 
allowed context string 
suppresslint newapi 
public static boolean nonnull context context nonnull string permission 
allowed context permission 
else return false 
switch permission 
case manifest permission system_alert_window 
return device hasmarshmallowapi 
settings candrawoverlays context 
case manifest permission write_settings 
return device hasmarshmallowapi 
settings system canwrite context 
final contextcompat checkselfpermission context permission 
return packagemanager permission_granted 
return code true this permission 
code false otherwise 
context string 
public static boolean allowed nonnull context context nonnull string permission 
return getinstance contains permission getinstance getboolean permission 
public static void nonnull context context nonnull string permission 
final boolean disturbing context instanceof activity 
disturbing 
else 
notificationspace getinstance ensure 
return singlet object runtime permissions manager 
nonnull 
public static synchronized runtimepermissions getinstance 
sruntimepermissions null 
sruntimepermissions runtimepermissions 
return sruntimepermissions 
begin 
inheritdoc 
private runtimepermissions 
super 
notificationspace getinstance requestrange 
inheritdoc 
nonnull 
override 
public string getpreferencesfilename 
return preferences_file_name 
inheritdoc 
override 
protected void onconfigchanged nonnull transaction transaction nonnull option option 
inheritdoc 
override 
protected void oncreatemap nonnull string option 
fulfil permissions 
string hashset 
manifest permission write_external_storage 
appheap getinstance getconfiguration getpermissions onbuildpermissions 
create 
string permission 
putoption cfgbase option 
boolean class permission true 
integer max_value 
