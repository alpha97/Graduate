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

package achep acdisplay services 
import android content broadcastreceiver 
import android content context 
import android content intent 
import android content intentfilter 
import android hardware sensor 
import android hardware sensorevent 
import android hardware sensoreventlistener 
import android hardware sensormanager 
import android handler 
import android systemclock 
import android support annotation nonnull 
import android util 
import achep acdisplay config 
import achep acdisplay 
import achep base appheap 
import achep base utils fileutils 
import achep base utils power powerutils 
import java file 
import java util linkedlist 
import static achep base build debug 
created achep 
public class sensorsdumpservice extends bathservice childservice implements 
sensoreventlistener 
private static final string sensorsdumpservice 
private static final char divider 
private static final char new_line 
private static final max_size 
private sensormanager msensormanager 
private final msensortypes 
sensor type_gyroscope sensor type_accelerometer 
private final linkedlist event meventlist linkedlist 
private static class event 
long timestamp 
float values 
sensor 
private handler mhandler handler 
private receiver mreceiver receiver 
private class receiver extends broadcastreceiver 
override 
public void onreceive context context intent intent 
switch intent getaction 
case intent action_screen_on 
startlistening 
stop listening after some minutes keep battery 
mhandler postdelayed runnable 
override 
public void 
synchronized meventlist 
stoplistening 
meventlist clear 

break 
case intent action_screen_off 
stoplistening 
droptostorage 
break 
starts stops this service required settings device state 
public static void handlestate nonnull context context 
config config config getinstance 
boolean onlywhilechangingoption config isenabledonlywhilecharging 
powerutils isplugged context 
config isenabled 
config isdevsensorsdumpenabled 
onlywhilechangingoption 
bathservice startservice context sensorsdumpservice class 
else 
bathservice stopservice context sensorsdumpservice class 
override 
public void oncreate 
context context getcontext 
intentfilter intentfilter intentfilter 
intentfilter addaction intent action_screen_on 
intentfilter addaction intent action_screen_off 
intentfilter setpriority intentfilter system_high_priority 
context registerreceiver mreceiver intentfilter 
msensormanager sensormanager context getsystemservice context sensor_service 
override 
public void ondestroy 
getcontext unregisterreceiver mreceiver 
stoplistening 
watch leaks 
appheap getrefwatcher watch this 
override 
public string getlabel 
return getcontext getstring string service_bath_active_mode_dump 
private void startlistening 
type msensortypes 
sensor sensor msensormanager getdefaultsensor type 
sensor null 
debug listening sensor getname sensor 
msensormanager registerlistener this sensor sensormanager sensor_delay_game 
private void stoplistening 
debug stopping listening 
msensormanager unregisterlistener this 
mhandler removecallbacksandmessages null 
private void droptostorage 
synchronized meventlist 
debug dumping sensors data file 
meventlist size 
return 
stringbuilder stringbuilder 
event event meventlist 
append event timestamp append divider 
append event sensor append divider 
float event values append append divider 
append new_line 
string filename dump_sensors_ systemclock elapsedrealtime 
file file file getcontext getfilesdir filename 
fileutils writetofile file 
meventlist clear 
override 
public void onsensorchanged sensorevent sensorevent 
synchronized meventlist 
event event event 
event timestamp systemclock elapsedrealtime 
event values sensorevent values clone 
event sensor sensorevent sensor gettype 
meventlist event 
size meventlist size 
size max_size 
meventlist remove 
override 
public void onaccuracychanged sensor sensor unused 
