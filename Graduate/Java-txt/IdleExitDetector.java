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

package achep acdisplay services activemode detectors 
import android hardware sensor 
import android hardware sensorevent 
import android hardware sensoreventlistener 
import android hardware sensormanager 
import android systemclock 
import android support annotation nonnull 
import android util 
import achep base build 
import achep base tests check 
import java util arraylist 
import java util list 
public class idleexitdetector implements sensoreventlistener 
suppresswarnings pointlessbooleanexpression 
private static final boolean debug_algorithm true build debug 
private static final string shakedetector 
after detect shake ignore events time 
want shakes close together 
private static final ignore_events_after_shake 
private static final long keep_data_points_for 
private final list datapoint mdatapoints arraylist 
private final listener mlistener 
private sensormanager msensormanager 
private long lastshake 
private float last_x last_y last_z 
private float ave_x ave_y ave_z 
public interface listener 
called shake detected 
void onshakedetected 
private static class datapoint 
public float 
public long time 
public datapoint float float float long time 
this 
this 
this 
this time time 
public idleexitdetector nonnull listener listener 
mlistener listener 
public void start nonnull sensormanager sensormanager 
msensormanager sensormanager 
sensor sensor msensormanager getdefaultsensor sensor type_accelerometer 
check getinstance isnonnull sensor 
msensormanager registerlistener this sensor sensormanager sensor_delay_game 
public void stop 
msensormanager unregisterlistener this 
msensormanager null 
override 
public void onsensorchanged nonnull sensorevent event 
check getinstance istrue event sensor gettype sensor type_accelerometer 
final long systemclock elapsedrealtime 
final long deltatime keep_data_points_for 
shake last seconds ignore 
lastshake lastshake ignore_events_after_shake return 
float event values 
float event values 
float event values 
last_x last_y last_z last_x last_y last_z 
datapoint datapoint last_x last_y last_z 
mdatapoints 
remove outdated data points 
while mdatapoints size mdatapoints time deltatime 
mdatapoints remove 
calculate average threshold 
final length mdatapoints size 
length 
datapoint mdatapoints 
ave_x math 
ave_y math 
ave_z math 
ave_x length 
ave_y length 
ave_z length 
debug_algorithm 
ave_x ave_x 
ave_y ave_y 
ave_z ave_z 
length length 

final float ave_x ave_y ave_z 
final float avedp math math math 
final float ratio avedp 
debug_algorithm 

ave_dp avedp 
ave_ratio ratio 
delta avedp 
math ratio math avedp 
mlistener onshakedetected 

ave_dp avedp 
ave_ratio ratio 
delta avedp 
last_x 
last_y 
last_z 
override 
public void onaccuracychanged nonnull sensor sensor accuracy unused 
