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

package achep acdisplay services switches 
import android content context 
import android systemclock 
import android support annotation nonnull 
import android util 
import achep acdisplay config 
import achep acdisplay inactivetimehelper 
import achep acdisplay services switch 
import achep base content configbase 
import java util timer 
import java util timertask 
import static achep base build debug 
prevents link achep acdisplay services activemode activemodeservice from listening 
sensors inactive time corresponding option enabled 
author artem chepurnoy 
achep acdisplay fragments settings moresettings 
todo implement event based inactive time handling 
public final class inactivetimeswitch extends switch implements 
configbase onconfigchangedlistener 
private static final inactive_hours_check_period 
private final config mconfig 
private final configbase option moption 
private timer mtimer 
public inactivetimeswitch nonnull context context nonnull callback callback 
nonnull configbase option option 
super context callback 
mconfig config getinstance 
moption option 
override 
public void oncreate 
mconfig registerlistener this 
updatestate 
override 
public void ondestroy 
mconfig unregisterlistener this 
mtimer null 
mtimer cancel 
mtimer null 
override 
public boolean isactive 
return isenabled inactivetimehelper isinactivetime mconfig 
private void updatestate 
mtimer null 
mtimer cancel 
mtimer null 
isenabled 
start timer monitor when inactive time 
will start this awful 
mtimer timer 
mtimer schedule timertask 
private static final string inactivetimeticker 
private boolean firsttick true 
private boolean inactiveprev false 
override 
public void 
boolean inactive inactivetimehelper isinactivetime mconfig 
boolean changed inactive inactiveprev firsttick 
firsttick false 
debug 
timer tick elapsed_real_time 
systemclock elapsedrealtime 
changed 
inactiveprev inactive 
debug 
is_inactive_time inactive 
inactive 
requestinactive 
else 
requestactive 
inactive_hours_check_period 
else 
requestactive 
override 
public void onconfigchanged nonnull configbase configbase 
nonnull string 
nonnull object value 
moption getkey mconfig equals 
updatestate 
return 
switch 
case config key_inactive_time_from 
case config key_inactive_time_to 
isenabled 
break 
immediately update sensors blocker 
case config key_inactive_time_enabled 
updatestate 
break 
return code true inactive time enabled code false otherwise 
private boolean isenabled 
return mconfig isinactivetimeenabled boolean moption read mconfig 
