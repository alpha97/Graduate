package jarofgreen 
import android hardware sensor 
import android hardware sensorevent 
import android hardware sensoreventlistener 
import android hardware sensormanager 
import android systemclock 
import android support annotation nonnull 
import achep base tests check 
import java util arraylist 
import java util arrays 
import java util list 
shake detection library 
author james 
copyright technology limited 
license open source clause 
edited artem chepurnoy 
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

todo filter slow shakes velocity 
public class shakedetector implements sensoreventlistener 
private static final shake_check_threshold 
after detect shake ignore events time 
want shakes close together 
private static final ignore_events_after_shake 
private static final long keep_data_points_for 
private static final long minimum_each_direction 
private static final float positive_counter_threshold 
private static final float negative_counter_threshold 
private final list datapoint mdatapoints arraylist 
private final listener mlistener 
private sensormanager msensormanager 
private long lastupdate 
private long lastshake 
private float last_x last_y last_z 
private final 
private final 
private final 
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
public float getaxis 
switch 
case 
return 
case 
return 
default 
return 
public shakedetector nonnull listener listener 
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
long systemclock elapsedrealtime 
shake last seconds ignore 
lastshake lastshake ignore_events_after_shake return 
float event values 
float event values 
float event values 
last_x last_y last_z last_x last_y last_z 
datapoint datapoint last_x last_y last_z 
mdatapoints 
lastupdate shake_check_threshold 
lastupdate 
checkshake 
last_x 
last_y 
last_z 
private void checkshake 
long curtime systemclock elapsedrealtime 
long cutofftime curtime keep_data_points_for 
remove outdated data points 
while mdatapoints size mdatapoints time cutofftime 
mdatapoints remove 
arrays fill 
arrays fill 
arrays fill 
datapoint mdatapoints 

float getaxis 
positive_counter_threshold 


else negative_counter_threshold 



minimum_each_direction minimum_each_direction 
last_x 
last_y 
last_z 
lastshake systemclock elapsedrealtime 
mdatapoints clear 
notify listener 
mlistener onshakedetected 
break 
override 
public void onaccuracychanged nonnull sensor sensor accuracy unused 
