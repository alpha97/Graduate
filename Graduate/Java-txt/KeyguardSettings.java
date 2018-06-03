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
import android content context 
import android bundle 
import android preference listpreference 
import android preference preference 
import android support annotation nonnull 
import achep acdisplay 
import achep acdisplay config 
import achep acdisplay 
import achep base permissions permissiongroup 
created artem 
public class keyguardsettings extends basesettings 
nonnull 
private final listpreferencesetter mdelaypreferencesetter listpreferencesetter 
override 
public void updatesummary nonnull preference preference 
nonnull config option option 
nonnull object value 
listpreference listpreference preference 
final charsequence valuestr integer tostring integer value 
final charsequence values getentryvalues 
final length values length 
length 
valuestr equals values 
setsummary getentries 
break 
override 
public void oncreate bundle savedinstancestate 
super oncreate savedinstancestate 
context context getactivity 
request grant keyguard permissions possible 
need permissions otherwise since acdisplay 
permissiongroup getaccessmanager getkeyguardpermissions 
exists context 
requestmasterswitch config key_keyguard permissions 
else requestmasterswitch config key_keyguard 
addpreferencesfromresource settings_keyguard_fragment 
syncpreference config key_keyguard_respect_inactive_time 
syncpreference config key_keyguard_without_notifications 
syncpreference config key_keyguard_lock_delay mdelaypreferencesetter 
