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
import android service notification notificationlistenerservice 
import android service notification statusbarnotification 
import android support annotation nonnull 
import achep acdisplay services mediaservice 
created artem chepurnoy 
class notificationlistenerlollipop extends notificationlistener 
override 
public void onlistenerbind nonnull mediaservice service unused 
never gets called lollipop 
targetapi build version_codes jelly_bean_mr 
override 
public void onlistenerconnected nonnull notificationlistenerservice service 
statusbarnotification service getactivenotifications 
null return 
notificationpresenter notificationpresenter getinstance 
init service 
override 
public void onnotificationposted nonnull notificationlistenerservice service 
nonnull statusbarnotification 
context context service getapplicationcontext 
notificationpresenter notificationpresenter getinstance 
postnotificationfrommain context opennotification newinstance 
override 
public void onnotificationremoved nonnull notificationlistenerservice service 
nonnull statusbarnotification 
notificationpresenter notificationpresenter getinstance 
removenotificationfrommain opennotification newinstance 
override 
todo should clear notifications list here 
public void onlistenerunbind nonnull mediaservice mediaservice unused 
