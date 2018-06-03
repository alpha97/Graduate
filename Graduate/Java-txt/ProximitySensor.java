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

package achep acdisplay services activemode sensors 
import android hardware sensor 
import android hardware sensorevent 
import android hardware sensoreventlistener 
import android hardware sensormanager 
import android handler 
import android support annotation nonnull 
import android util 
import achep acdisplay config 
import achep acdisplay services activemode activemodesensor 
import achep base content configbase 
import apache commons lang builder equalsbuilder 
import apache commons lang builder hashcodebuilder 
import java lang weakreference 
import java util arraylist 
import static achep base build debug 
basing results proximity sensor notifies when 
link achep acdisplay activities acdisplayactivity acdisplay 
should shown 
author artem chepurnoy 
public final class proximitysensor extends activemodesensor implements 
sensoreventlistener configbase onconfigchangedlistener 
private static final string proximitysensor 
private static final last_event_max_time 
pocket program 
private static final pocket_start_delay 
private static weakreference proximitysensor sproximitysensorweak 
private static long slasteventtime 
private static boolean sattached 
private static boolean snear 
private float mmaximumrange 
private boolean mfirstchange 
nonnull 
private final object monitor object 
private final arraylist program mprograms 
private final arraylist event mhistory 
private final handler mhandler 
private mhistorymaximumsize 
private final program mpocketprogram 
private final program mwave wakeprogram 
private static class program 
nonnull 
public final data dataarray 
private static class data 
public final boolean isnear 
public timemin 
public final long timemax 
public data boolean isnear timemin long timemax 
this isnear isnear 
this timemin timemin 
this timemax timemax 
inheritdoc 
override 
public hashcode 
return hashcodebuilder 
append isnear 
append timemin 
append timemax 
tohashcode 
inheritdoc 
override 
public boolean equals object 
this 
return true 
instanceof data 
return false 
data data data 
return equalsbuilder 
append isnear data isnear 
append timemin data timemin 
append timemax data timemax 
isequals 
public program nonnull data dataarray 
this dataarray dataarray 
inheritdoc 
override 
public hashcode 
return hashcodebuilder 
append dataarray 
tohashcode 
inheritdoc 
override 
public boolean equals object 
this 
return true 
instanceof program 
return false 
program program program 
return equalsbuilder 
append dataarray program dataarray 
isequals 
public static fits nonnull program program nonnull arraylist event history 
data dataarray program dataarray 
historysize history size 
programsize dataarray length 
historysize programsize 
program needs slightly longer history 
return 
historyoffset historysize programsize 
event eventprevious history historyoffset 
programsize 
data data dataarray 
event eventfuture history historyoffset 
final long delta eventfuture time eventprevious time 
eventprevious isnear data isnear 
delta data timemin 
delta data timemax 
return 
eventprevious eventfuture 
data data dataarray programsize 
eventprevious isnear data isnear 
return data timemin 
return 
public static class builder 
private final arraylist data mprogram arraylist 
private boolean mlastnear 
nonnull 
public builder begin boolean isnear timemin 
return isnear timemin long max_value 
nonnull 
public builder timemin long timemax 
return mlastnear timemin timemax 
nonnull 
public builder timemin 
return timemin 
nonnull 
private builder boolean isnear timemin long timemax 
data data data isnear timemin timemax 
mprogram data 
mlastnear isnear 
return this 
nonnull 
public program build 
return program mprogram toarray data mprogram size 
proximity event 
private static class event 
final boolean isnear 
final long time 
public event boolean isnear long time 
this isnear isnear 
this time time 
private proximitysensor 
super 
mpocketprogram program builder 
begin true pocket_start_delay near least some seconds 
after least seconds 
build 
mwave wakeprogram program builder 
begin true near least millis 
after more than second 
after near more than second 
after least second 
build 
mprograms arraylist 
mprograms mpocketprogram 
mprograms mwave wakeprogram needed include history size calculation 
program program mprograms 
size program dataarray length 
size mhistorymaximumsize 
mhistorymaximumsize size 
mhistory arraylist mhistorymaximumsize 
mhandler handler 
nonnull 
public static proximitysensor getinstance 
proximitysensor sensor sproximitysensorweak null 
sproximitysensorweak null 
sensor null 
sensor proximitysensor 
sproximitysensorweak weakreference sensor 
return sensor 
return code true sensor currently near state code false otherwise 
public static boolean isnear 
return gettimenow slasteventtime last_event_max_time sattached snear 
override 
public gettype 
return sensor type_proximity 
override 
public void onstart nonnull sensormanager sensormanager 
debug starting proximity sensor 
mhistory clear 
mhistory event false gettimenow 
config getinstance registerlistener this 
updatewave wakeprogram 
ignore pocket program start delay 
just after started 
mfirstchange true 
mpocketprogram dataarray timemin 
sensor proximitysensor sensormanager getdefaultsensor gettype 
sensormanager registerlistener this proximitysensor sensormanager sensor_delay_normal 
mmaximumrange proximitysensor getmaximumrange 
sattached true 
override 
public void onstop 
debug stopping proximity sensor 
sensormanager sensormanager getsensormanager 
sensormanager unregisterlistener this 
mhandler removecallbacksandmessages null 
mhistory clear 
config getinstance unregisterlistener this 
override 
public void onsensorchanged sensorevent event 
final float distance event values 
final boolean isnear distance mmaximumrange distance 
final boolean changed snear snear isnear mfirstchange 
synchronized monitor 
long gettimenow 
debug 
historysize mhistory size 
string delta historysize 
delta mhistory historysize time 
first_event 
event distance distance 
is_near isnear 
changed changed 
delta 
changed 
well just cause proximity sensor always eventual 
this should happen knows found maximum 
range buggy enough 
return 
while mhistory size mhistorymaximumsize 
mhistory remove 
mhandler removecallbacksandmessages null 
mhistory event isnear 
program program mprograms 
delay program fits program mhistory 
delay 
mhandler postdelayed runnable 
override 
public void 
synchronized monitor 
mhandler removecallbacksandmessages null 
mhistory clear 
requestwakeup 
delay 
mfirstchange 
change pocket program back defaults 
mpocketprogram dataarray timemin pocket_start_delay 
slasteventtime 
mfirstchange false 
override 
public void onaccuracychanged sensor sensor accuracy unused 
override 
public void onconfigchanged nonnull configbase config 
nonnull string 
nonnull object value 
switch 
case config key_active_mode_wave_to_wake 
updatewave wakeprogram 
break 
private void updatewave wakeprogram 
synchronized monitor 
boolean enabled config getinstance isactivemodewavetowakeenabled 
enabled 
mprograms contains mwave wakeprogram 
debug added wave wake program 
mprograms mwave wakeprogram 
else 
debug removed wave wake program 
mprograms remove mwave wakeprogram 
