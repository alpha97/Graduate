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
import android annotation targetapi 
import android appopsmanager 
import android content context 
import android content intent 
import android content packagemanager 
import android build 
import android provider settings 
import android support annotation drawableres 
import android support annotation nonnull 
import android support annotation stringres 
import achep acdisplay 
import achep base device 
import achep base permissions permission 
import achep base tests check 
import achep base utils packageutils 
usage stats permission 
author artem chepurnoy 
android usage usagestatsmanager 
targetapi build version_codes lollipop 
public final class permissionusagestats extends permission 
nonnull 
private final packagemanager mpackagemanager 
public permissionusagestats nonnull context context 
super context 
check getinstance istrue device haslollipopapi 
mpackagemanager mcontext getpackagemanager 
inheritdoc 
public boolean isgranted 
final string packagename packageutils getname mcontext 
final 

mpackagemanager getapplicationinfo packagename 
catch packagemanager namenotfoundexception 
throw runtimeexception 
result getappopsmanager checkop appopsmanager opstr_get_usage_stats packagename 
return result appopsmanager mode_allowed 
nonnull 
private appopsmanager getappopsmanager 
return appopsmanager mcontext getsystemservice context app_ops_service 
inheritdoc 
nonnull 
override 
public intent getintentsettings 
return intent settings action_usage_access_settings 

inheritdoc 
drawableres 
public geticonresource 
return drawable ic_settings_apps_white 
inheritdoc 
stringres 
public gettitleresource 
return string permissions_usage_stats 
inheritdoc 
stringres 
public getsummaryresource 
return string permissions_usage_stats_description 
inheritdoc 
stringres 
public geterrorresource 
return string permissions_usage_stats_error 
