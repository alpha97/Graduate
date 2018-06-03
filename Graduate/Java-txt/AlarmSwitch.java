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
import android content broadcastreceiver 
import android content context 
import android content intent 
import android content intentfilter 
import android systemclock 
import android support annotation nonnull 
import android util 
import achep acdisplay services switch 
prevents link achep acdisplay services switchservice from working 
while alarm alarming 
author artem chepurnoy 
public final class alarmswitch extends switch 
private static final string alarmswitch 
public static final string alarm_alert alarm_alert 
public static final string alarm_dismiss alarm_dismiss 
public static final string alarm_snooze alarm_snooze 
public static final string alarm_done alarm_done 
private boolean mactive 
private long malarmingtimestamp 
nonnull 
private final broadcastreceiver mreceiver broadcastreceiver 
override 
public void onreceive context context intent intent 
final string action intent getaction 
action contains alarm_alert 
hide keyguard 
mactive false 
malarmingtimestamp systemclock elapsedrealtime 
requestinactive 
else action contains alarm_dismiss 
action contains alarm_snooze 
action contains alarm_done 
show keyguard 
mactive true 
requestactive 
else mactive 

received unknown intent intent getaction 
enabling switch 
show keyguard 
mactive true 
requestactive 
public alarmswitch nonnull context context nonnull callback callback 
super context callback 
inheritdoc 
override 
public void oncreate 
mactive true 
intentfilter intentfilter intentfilter 
intentfilter addaction alarms standard_alarm_alert_action 
intentfilter addaction alarms standard_alarm_dismiss_action 
intentfilter addaction alarms standard_alarm_snooze_action 
intentfilter addaction alarms standard_alarm_done_action 
string alarm alarms alarms 
intentfilter addaction alarm alarm_alert 
intentfilter addaction alarm alarm_dismiss 
intentfilter addaction alarm alarm_snooze 
intentfilter addaction alarm alarm_done 
intentfilter setpriority intentfilter system_high_priority 
getcontext registerreceiver mreceiver intentfilter 
inheritdoc 
override 
public void ondestroy 
getcontext unregisterreceiver mreceiver 
inheritdoc 
override 
public boolean isactive 
check alarm intent this needed because 
sure that alarm will broadcast 
dismiss snooze done intents 
final long systemclock elapsedrealtime 
final boolean timedout malarmingtimestamp 
checking alarmswitch active 
active mactive 
timed_out timedout 
return mactive timedout 
author artem chepurnoy 
private static class alarms 
modern android 
public static final string standard_alarm_package android deskclock 
public static final string standard_alarm_alert_action 
android deskclock alarm_alert 
public static final string standard_alarm_snooze_action 
android deskclock alarm_snooze 
public static final string standard_alarm_dismiss_action 
android deskclock alarm_dismiss 
public static final string standard_alarm_done_action 
android deskclock alarm_done 
deprecated android 
public static final string standard_old_alarm_package android alarmclock 
manufacturers 
samsung 
public static final string samsung_alarm_package samsung android clockpackage alarm 
public static final string samsung_alarm_package_ android clockpackage alarm 

public static final string htc_alarm_alert_package android worldclock 
public static final string htc_one_alarm_alert_package android 
sony 
public static final string sony_alarm_package sonyericsson alarm 

public static final string zte_alarm_package alarmclock 
motorola 
public static final string moto_alarm_package motorola blur alarmclock 

public static final string lg_alarm_package alarm alarmclocknew 
third party 
gentle alarm 
public static final string gentle_alarm_package mobitobi android gentlealarm 
sleep android 
public static final string sleepasdroid_alarm_package urbandroid sleep alarmclock 
alarmdroid 
public static final string alarmdroid_alarm_package splunchy android alarmclock 
timely 
public static final string timely_alarm_package bitspin timely 

nonnull 
public static final string alarms 
standard_alarm_package 
standard_old_alarm_package 
samsung_alarm_package 
samsung_alarm_package_ 
htc_alarm_alert_package 
htc_one_alarm_alert_package 
sony_alarm_package 
zte_alarm_package 
moto_alarm_package 
lg_alarm_package 
gentle_alarm_package 
sleepasdroid_alarm_package 
alarmdroid_alarm_package 
timely_alarm_package 
