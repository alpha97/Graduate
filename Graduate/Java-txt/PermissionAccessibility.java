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
import android content componentname 
import android content contentresolver 
import android content context 
import android content intent 
import android provider settings 
import android support annotation drawableres 
import android support annotation nonnull 
import android support annotation stringres 
import android util 
import achep acdisplay 
import achep acdisplay services accessibilityservice 
import achep base permissions permission 
accessibility notification permission 
author artem chepurnoy 
achep acdisplay services accessibilityservice 
public final class permissionaccessibility extends permission 
private static final string permissionacbnotify 
nonnull 
private final string mcomponentstring 
public permissionaccessibility nonnull context context 
super context 
mcomponentstring componentname mcontext accessibilityservice class flattentostring 
inheritdoc 
public boolean isgranted 
final contentresolver mcontext getcontentresolver 

settings secure getint settings secure accessibility_enabled 
return false 
catch settings settingnotfoundexception 
accessibility enabled setting found 
final string flat settings secure getstring 
settings secure enabled_accessibility_services 
return flat null flat contains mcomponentstring 
inheritdoc 
nonnull 
override 
public intent getintentsettings 
return intent settings action_accessibility_settings 

inheritdoc 
drawableres 
public geticonresource 
return drawable stat_notify 
inheritdoc 
stringres 
public gettitleresource 
return string permissions_notifications 
inheritdoc 
stringres 
public getsummaryresource 
return string permissions_notifications_description 
inheritdoc 
stringres 
public geterrorresource 
return should never needed 
