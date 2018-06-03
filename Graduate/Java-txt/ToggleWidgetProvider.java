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

package achep acdisplay providers 
import android pendingintent 
import android appwidget appwidgetmanager 
import android appwidget appwidgetprovider 
import android content componentname 
import android content context 
import android content intent 
import android content resources 
import android support annotation nonnull 
import android util 
import android widget remoteviews 
import achep acdisplay 
import achep acdisplay config 
import achep acdisplay 
import achep base content configbase 
import static achep base build debug 
toggle widget provider 
author artem chepurnoy 
public class togglewidgetprovider extends appwidgetprovider 
implements configbase onconfigchangedlistener 
private static final string appwidgetprovider 
private config mconfig 
override 
public void onenabled context context 
super onenabled context 
onenabledinternal context 
override 
public void ondisabled context context 
super ondisabled context 
ondisabledinternal context 
override 
public void onupdate context context appwidgetmanager appwidgetmanager appwidgetids 
onenabledinternal context 
updatewidgets context 
override 
public void onconfigchanged nonnull configbase config 
nonnull string 
nonnull object value 
switch 
case config key_enabled 
updatewidgets config getcontext 
break 
private void onenabledinternal context context 
mconfig null 
return already initialized 
mconfig config getinstance 
mconfig registerlistener this 
debug toggle widget enabled 
private void ondisabledinternal context context 
mconfig null 
return initialized 
mconfig unregisterlistener this 
mconfig null 
debug toggle widget disabled 
private void updatewidgets context context 
appwidgetmanager appwidgetmanager appwidgetmanager getinstance context 
componentname componentname context togglewidgetprovider class 
appwidgetids appwidgetmanager getappwidgetids 
appwidgetid appwidgetids 
create intent launch receiveractivity toggle acdisplay 
probably doing same using broadcastreceiver would better solution 
intent intent intent action_toggle 
pendingintent pendingintent pendingintent getbroadcast context intent 
resources context getresources 
layout widget attach click listener 
button 
remoteviews remoteviews context getpackagename layout appwidget_toggle_layout 
setonclickpendingintent container pendingintent 
settextviewtext title getstring 
mconfig isenabled string enabled string disabled 
tell appwidgetmanager perform update current widget 
appwidgetmanager updateappwidget appwidgetid 
