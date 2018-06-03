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
import android annotation suppresslint 
import android keyguardmanager 
import android notification 
import android pendingintent 
import android content context 
import android content packagemanager 
import android content resources 
import android graphics drawable drawable 
import android service notification statusbarnotification 
import android support annotation drawableres 
import android support annotation nonnull 
import android support annotation nullable 
import android util 
import achep acdisplay config 
import achep acdisplay services mediaservice 
import achep acdisplay utils pendingintentutils 
import achep base device 
import achep base utils operator 
import achep base utils resutils 
created artem 
public class notificationutils 
private static final string notificationutils 
return whether keyguard requires password unlock 
have privacy restrictions 
public static boolean issecure nonnull context context 
keyguardmanager keyguardmanager context getsystemservice context keyguard_service 
return iskeyguardsecure iskeyguardlocked 
public static boolean issecret nonnull context context nonnull opennotification 
minvisibility privacymask 
final privacymode config getinstance getprivacymode 
return getvisibility minvisibility 
operator bitand privacymode privacymask 
issecure context 
imitates click given notification launches content intent 
dismisses notification from system 
return code true launched successfully code false otherwise 
public static boolean startcontentintent nonnull opennotification 
pendingintent getnotification contentintent 
null 
getnotification fullscreenintent nullable 
null sending full screen intent instead content 
boolean successful pendingintentutils sendpendingintent 
successful operator bitand 
getnotification flags 
notification flag_auto_cancel 
dismissnotification 
return successful 
dismisses given notification from system 
suppresswarnings deprecation 
suppresslint newapi 
public static void dismissnotification nonnull opennotification 
notificationpresenter getinstance removenotification 
statusbarnotification getstatusbarnotification 
null device hasjellybeanmr 
mediaservice service mediaservice sservice 
service null 
fixme should call deleteintent 
pendingintentutils sendpendingintent getnotification deleteintent 

device haslollipopapi 
service cancelnotification getkey 
else 
service cancelnotification 
getpackagename 
gettag 
getid 
catch securityexception 
fixme disallowed call from unknown listener exception 
java lang securityexception disallowed call from unknown listener android service notification inotificationlistener stub proxy 
android parcel readexception parcel java 
android parcel readexception parcel java 
android inotificationmanager stub proxy cancelnotificationfromlistener inotificationmanager java 
android service notification notificationlistenerservice cancelnotification notificationlistenerservice java 
failed dismiss notification 
printstacktrace 
else 
failed dismiss notification because notification service offline 
suppresslint newapi 
public static void dismissallnotifications 
notificationpresenter getinstance clear true 
device hasjellybeanmr 
mediaservice service mediaservice sservice 
service null 

service cancelallnotifications 
catch securityexception 
fixme disallowed call from unknown listener exception 
java lang securityexception disallowed call from unknown listener android service notification inotificationlistener stub proxy 
android parcel readexception parcel java 
android parcel readexception parcel java 
android inotificationmanager stub proxy cancelnotificationfromlistener inotificationmanager java 
android service notification notificationlistenerservice cancelnotification notificationlistenerservice java 
failed dismiss notification 
printstacktrace 
else 
failed dismiss notification because notification service offline 
nullable 
public static drawable getdrawable nonnull context context 
nonnull opennotification 
drawableres iconres 
context pkgcontext createcontext context 
pkgcontext null 

return resutils getdrawable pkgcontext iconres 
catch resources notfoundexception unused 
return null 
nullable 
public static context createcontext nonnull context context nonnull opennotification 

return context createpackagecontext getpackagename context context_restricted 
catch packagemanager namenotfoundexception 
failed create notification context 
return null 
achep acdisplay notifications opennotification hasidenticalids opennotification 
public static boolean hasidenticalids nullable opennotification 
nullable opennotification 
return null hasidenticalids 
