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
import android notification 
import android notificationmanager 
import android pendingintent 
import android content context 
import android content intent 
import android content resources 
import android graphics bitmapfactory 
import android media ringtonemanager 
import android support annotation nonnull 
import android support notificationcompat 
import achep acdisplay 
import achep acdisplay 
import achep acdisplay activities mainactivity 
created artem chepurnoy 
public class notificationhelper 
nonnull 
public static notification buildnotification nonnull context context final 
nonnull object objects 
final resources context getresources 
final notificationcompat builder builder notificationcompat builder context 
setsmallicon drawable stat_acdisplay 
setcolor accent_color 
setautocancel true 
pendingintent null 
switch 
case id_notify_test 
notificationcompat bigtextstyle notificationcompat bigtextstyle 
bigtext getstring string notification_test_message_large 
builder setstyle 
setcontenttitle getstring string app_name 
setcontenttext getstring string notification_test_message 
setlargeicon bitmapfactory decoderesource mipmap ic_launcher 
setsound ringtonemanager getdefaulturi ringtonemanager type_notification 
break 
case id_notify_bath 
charsequence contenttext charsequence objects 
intent contentintent intent objects 
build notification 
pendingintent getactivity context contentintent 
pendingintent flag_update_current 
builder setcontenttitle getstring string service_bath 
setcontenttext contenttext 
setpriority notification priority_min 
break 
case id_notify_init 
builder setsmallicon drawable stat_notify 
setcontenttitle getstring string app_name 
setcontenttext getstring string notification_init_text 
setpriority notification priority_min 
break 
case id_notify_app_auto_disabled 
charsequence summary charsequence objects 
notificationcompat bigtextstyle notificationcompat bigtextstyle 
bigtext getstring string permissions_auto_disabled 
setsummarytext summary 
builder setlargeicon bitmapfactory decoderesource mipmap ic_launcher 
setcontenttitle getstring string app_name 
setcontenttext getstring string permissions_auto_disabled 
setpriority notification priority_high 
setstyle 
break 
default 
throw illegalargumentexception 
null 
pendingintent getactivity context 
intent context mainactivity class 
pendingintent flag_update_current 
return builder setcontentintent build 
public static void sendnotification nonnull context context final 
nonnull object objects 
notificationmanager notificationmanager context 
getsystemservice context notification_service 
notify buildnotification context objects 
