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
import android content context 
import android content intent 
import android support annotation drawableres 
import android support annotation nonnull 
import android support annotation stringres 
import achep acdisplay permissions permissionaccessibility 
import achep acdisplay permissions permissiondeviceadmin 
import achep acdisplay permissions permissionnotificationlistener 
import achep acdisplay permissions permissionusagestats 
import achep base interfaces ipermission 
import achep base interfaces isubscriptable 
import achep base utils intentutils 
import java util arraylist 
author artem chepurnoy 
public abstract class permission implements 
isubscriptable permission onpermissionstatechanged 
ipermission 
achep acdisplay permissions permissionaccessibility 
nonnull 
public static final string permission_accessibility 
permissionaccessibility class getsimplename 
achep acdisplay permissions permissiondeviceadmin 
nonnull 
public static final string permission_device_admin 
permissiondeviceadmin class getsimplename 
achep acdisplay permissions permissionnotificationlistener 
nonnull 
public static final string permission_notification_listener 
permissionnotificationlistener class getsimplename 
achep acdisplay permissions permissionusagestats 
nonnull 
public static final string permission_usage_stats 
permissionusagestats class getsimplename 
achep base permissions permission permission_accessibility 
achep base permissions permission permission_device_admin 
achep base permissions permission permission_notification_listener 
achep base permissions permission permission_usage_stats 
nonnull 
public static permission newinstance nonnull context context nonnull string name 
permission_accessibility equals name 
return permissionaccessibility context 
else permission_device_admin equals name 
return permissiondeviceadmin context 
else permission_notification_listener equals name 
return permissionnotificationlistener context 
else permission_usage_stats equals name 
return permissionusagestats context 
throw illegalargumentexception 
main 
nonnull 
protected final context mcontext 
nonnull 
protected final arraylist onpermissionstatechanged mlisteners arraylist 
public interface onpermissionstatechanged 
public permission nonnull context context 
mcontext context getapplicationcontext 
inheritdoc 
override 
public void registerlistener nonnull onpermissionstatechanged listener 
synchronized this 
mlisteners listener 
inheritdoc 
override 
public void unregisterlistener nonnull onpermissionstatechanged listener 
synchronized this 
mlisteners remove listener 
inheritdoc 
override 
public void onlowmemory empty 
inheritdoc 
override 
public boolean exists nonnull context context 
return intentutils hasactivityforthat context getintentsettings 
return intent enable permission settings screen 
nonnull 
public abstract intent getintentsettings 

drawableres 
public geticonresource 
return 
stringres 
public gettitleresource 
return 
stringres 
public getsummaryresource 
return 
stringres 
public geterrorresource 
return 
