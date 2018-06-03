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
import android content componentname 
import android content contentresolver 
import android content context 
import android content intent 
import android build 
import android provider settings 
import android support annotation drawableres 
import android support annotation nonnull 
import android support annotation stringres 
import achep acdisplay 
import achep acdisplay services mediaservice 
import achep base device 
import achep base permissions permission 
import achep base tests check 
notification listener service permission 
author artem chepurnoy 
android service notification notificationlistenerservice 
targetapi build version_codes jelly_bean_mr 
public final class permissionnotificationlistener extends permission 
private static final string enabled_notification_listeners 
private static final string action android settings action_notification_listener_settings 
nonnull 
private final string mcomponentstring 
public permissionnotificationlistener nonnull context context 
super context 
check getinstance istrue device hasjellybeanmr 
mcomponentstring componentname mcontext mediaservice class flattentostring 
inheritdoc 
public boolean isgranted 
final contentresolver mcontext getcontentresolver 
final string flat settings secure getstring 
return flat null flat contains mcomponentstring 
inheritdoc 
nonnull 
override 
public intent getintentsettings 
return intent action 

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
return string permissions_notifications_grant_manually 
