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

package achep acdisplay 
import android application 
import android content context 
import android content resources 
import android support annotation nonnull 
import android text html 
import achep acdisplay blacklist blacklist 
import achep acdisplay notifications notificationhelper 
import achep acdisplay notifications notificationpresenter 
import achep acdisplay permissions accessmanager 
import achep acdisplay services keyguardservice 
import achep acdisplay services sensorsdumpservice 
import achep acdisplay services activemode activemodeservice 
import achep base appheap 
import achep base content configbase 
import achep base interfaces iconfiguration 
import achep base permissions permission 
import achep base permissions permissiongroup 
import achep base utils rawreader 
import achep base utils smiley smileyparser 
import java util arrays 
import java util list 
import java util 
created artem 
public class extends application 
private static final string 
public static final accent_color 
public static final id_notify_init 
public static final id_notify_test 
public static final id_notify_bath 
public static final id_notify_app_auto_disabled 
public static final string action_bind_media_control_service achep acdisplay bind_media_control_service 
public static final string action_enable achep acdisplay enable 
public static final string action_disable achep acdisplay disable 
public static final string action_toggle achep acdisplay toggle 
public static final string action_active_mode_enable achep acdisplay active_mode_enable 
public static final string action_active_mode_disable achep acdisplay active_mode_disable 
public static final string action_active_mode_toggle achep acdisplay active_mode_toggle 
public static final string action_state_start achep acdisplay state_start 
public static final string action_state_resume achep acdisplay state_resume 
public static final string action_state_pause achep acdisplay state_pause 
public static final string action_state_stop achep acdisplay state_stop 
public static final string action_eat_home_press_start achep acdisplay eat_home_press_start 
public static final string action_eat_home_press_stop achep acdisplay eat_home_press_stop 
public static final string action_internal_timeout timeout 
public static final string action_internal_ping_sensors ping_sensors 
private accessmanager maccessmanager 
suppresswarnings nullableproblems 
nonnull 
private static instance 
public 
instance this 
override 
public void oncreate 
maccessmanager accessmanager this 
appheap getinstance init this iconfiguration 
nonnull 
private final ipermissions permissions ipermissions 
override 
public void onbuildpermissions nonnull string list 
nonnull 
private final ibilling billing ibilling 
nonnull 
override 
public list string getproducts 
return arrays aslist 
donation_ 
donation_ 
donation_ 
donation_ 
donation_ 
donation_ 
override 
public boolean hasalternativepaymentmethods 
config getinstance gettriggers getlaunchcount 
always show addition options active 
user hope this 
return true 
final resources appheap getcontext getresources 
return getboolean bool config_alternative_payments 
nonnull 
private final ihelp help ihelp 
nonnull 
override 
public charsequence gettext nonnull context context 
final string source rawreader readtext context 
return html fromhtml source 
override 
public void onuserreadhelp 
final context context instance 
config getinstance gettriggers sethelpread context true null 
nonnull 
override 
public ibilling getbilling 
return billing 
nonnull 
override 
public ihelp gethelp 
return help 
nonnull 
override 
public ipermissions getpermissions 
return permissions 
config getinstance init this 
blacklist getinstance init this 
smileyparser init this 
init main notification listener 
notificationpresenter getinstance setonnotificationpostedlistener 
config getinstance isenabled 
presenter getinstance 
null 
super oncreate 
check main switch 
string divider getstring string settings_multi_list_divider 
config config config getinstance 
config isenabled 
stringbuilder stringbuilder 
boolean foundany false 
permissiongroup getaccessmanager getmasterpermissions 
permission permission permissions 
permission isgranted 
foundany 
append divider 
else foundany true 
append getstring permission gettitleresource 
foundany 
string list tostring 
list list charat list substring tolowercase 
configbase option option config getoption config key_enabled 
option write config this false null 
notificationhelper sendnotification this id_notify_app_auto_disabled list 
launch keyguard active mode 
launch 
keyguardservice handlestate this 
activemodeservice handlestate this 
sensorsdumpservice handlestate this 
override 
public void onlowmemory 
config getinstance onlowmemory 
blacklist getinstance onlowmemory 
notificationpresenter getinstance onlowmemory 
maccessmanager onlowmemory 
super onlowmemory 
nonnull 
public static accessmanager getaccessmanager 
assert instance maccessmanager null 
return instance maccessmanager 
