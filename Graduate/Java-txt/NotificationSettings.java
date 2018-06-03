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

package achep acdisplay fragments settings 
import android bundle 
import android preference listpreference 
import android preference preference 
import android support annotation nonnull 
import achep acdisplay config 
import achep acdisplay 
created artem 
public class notificationsettings extends basesettings 
private final listpreferencesetter mlistpreferencenotifyprioritysetter 
listpreferencesetter 
override 
public void updatesummary nonnull preference preference 
nonnull config option option 
nonnull object value 
value 
listpreference listpreference preference 
setsummary getentries 
override 
public void oncreate bundle savedinstancestate 
super oncreate savedinstancestate 
addpreferencesfromresource settings_notification_fragment 
syncpreference config key_notify_min_priority mlistpreferencenotifyprioritysetter 
syncpreference config key_notify_max_priority mlistpreferencenotifyprioritysetter 
syncpreference config key_notify_wake_up_on 
syncpreference config key_notify_glance 
