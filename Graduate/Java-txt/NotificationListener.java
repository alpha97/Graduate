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

package achep acdisplay notifications 
import android service notification notificationlistenerservice 
import android service notification statusbarnotification 
import android support annotation nonnull 
import achep acdisplay services mediaservice 
import achep base device 
created artem chepurnoy 
public abstract class notificationlistener 
nonnull 
public static notificationlistener newinstance 
device haslollipopapi 
return notificationlistenerlollipop 
else device hasjellybeanmr 
return notificationlistenerjellybeanmr 
throw unsupportedoperationexception 
called link achep acdisplay services mediaservice media service bind 
public abstract void onlistenerbind 
nonnull mediaservice service 
called link notificationlistenerservice onlistenerconnected 
since link android build version_codes lollipop 
public abstract void onlistenerconnected 
nonnull notificationlistenerservice service 
called link notificationlistenerservice onnotificationposted android service notification statusbarnotification 
onlistenerconnected notificationlistenerservice 
onnotificationremoved notificationlistenerservice android service notification statusbarnotification 
public abstract void onnotificationposted 
nonnull notificationlistenerservice service 
nonnull statusbarnotification 
called link notificationlistenerservice onnotificationremoved android service notification statusbarnotification 
onnotificationposted notificationlistenerservice android service notification statusbarnotification 
public abstract void onnotificationremoved 
nonnull notificationlistenerservice service 
nonnull statusbarnotification 
called link achep acdisplay services mediaservice media service unbind 
public abstract void onlistenerunbind 
nonnull mediaservice mediaservice 
