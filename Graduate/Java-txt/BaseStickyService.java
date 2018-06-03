package achep base services 
import android annotation suppresslint 
import android alarmmanager 
import android pendingintent 
import android content context 
import android content intent 
import achep base device 
import timber timber 
author artem chepurnoy 
public abstract class basestickyservice extends baseservice 
private static final long pending_intent_restart_delay 
return code true service enabled should running 
code false otherwise 
public abstract boolean isenabled 
public abstract code 
inheritdoc 
override 
public void ondestroy 
super ondestroy 
remoterestartserviceifneeded 
inheritdoc 
override 
public void ontaskremoved intent rootintent 
super ontaskremoved rootintent 
remoterestartserviceifneeded 
private void remoterestartserviceifneeded 
isenabled remoterestartservice 
suppresslint newapi 
private void remoterestartservice 
timber remote restart service 
final intent intent intent this getclass 
final pendingintent pendingintent getservice this code intent 
pendingintent flag_update_current 
alarm manger restart 
alarmmanager alarm alarmmanager getsystemservice context alarm_service 
device hasmarshmallowapi 
alarm setandallowwhileidle alarmmanager rtc_wakeup 
system currenttimemillis pending_intent_restart_delay 
else alarm alarmmanager rtc_wakeup 
system currenttimemillis pending_intent_restart_delay 
