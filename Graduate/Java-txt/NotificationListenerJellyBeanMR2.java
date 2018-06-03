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
import android annotation targetapi 
import android content context 
import android build 
import android handler 
import android service notification notificationlistenerservice 
import android service notification statusbarnotification 
import android support annotation nonnull 
import achep acdisplay 
import achep acdisplay services mediaservice 
created artem chepurnoy 
class notificationlistenerjellybeanmr extends notificationlistener 
private boolean minitialized 
override 
public void onlistenerbind nonnull mediaservice service 
minitialized false 
what idea init notification 
well main goal access getactivenotifications 
what seems possible without dirty buggy 
workarounds 
handler postdelayed runnable 
override 
public void 
mediaservice service mediaservice sservice 
service null return 
notificationhelper sendnotification service id_notify_init 

never gets called lollipop 
override 
public void onlistenerconnected nonnull notificationlistenerservice service unused 
override 
public void onnotificationposted nonnull notificationlistenerservice service 
nonnull statusbarnotification 
minitialized postactivenotifications service 
context context service getapplicationcontext 
notificationpresenter notificationpresenter getinstance 
postnotificationfrommain context opennotification newinstance 
override 
public void onnotificationremoved nonnull notificationlistenerservice service 
nonnull statusbarnotification 
minitialized postactivenotifications service 
notificationpresenter notificationpresenter getinstance 
removenotificationfrommain opennotification newinstance 
override 
public void onlistenerunbind nonnull mediaservice mediaservice 
notificationpresenter getinstance clearfrommain true 
suppresswarnings booleanmethodisalwaysinverted 
targetapi build version_codes jelly_bean_mr 
private boolean postactivenotifications nonnull notificationlistenerservice service 
statusbarnotification service getactivenotifications 
null return false 
notificationpresenter notificationpresenter getinstance 
init service 
return minitialized true 
