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
import android handler 
import android support annotation nonnull 
import android telephony phonestatelistener 
import android telephony telephonymanager 
import achep acdisplay services switch 
import java lang reference 
import java lang weakreference 
prevents link achep acdisplay services switchservice from working 
while phone calling 
author artem chepurnoy 
public final class phonecallswitch extends switch 
private static final string phonecallswitch 
nonnull 
private final callmonitor mcallmonitor 
public phonecallswitch nonnull context context nonnull callback callback 
super context callback 
mcallmonitor callmonitor context callmonitor oncallstatechangedlistener 
override 
public void oncallstatechanged state 
isactive 
requestactive 
else requestinactive 
inheritdoc 
override 
public void oncreate 
mcallmonitor start 
inheritdoc 
override 
public void ondestroy 
mcallmonitor stop 
inheritdoc 
override 
public boolean isactive 
return mcallmonitor iscalling 
return whether phone calling 
public boolean iscalling 
return mcallmonitor iscalling 
author artem chepurnoy 
private static class callmonitor 
private boolean mstarted 
author artem chepurnoy 
public interface oncallstatechangedlistener 
callback invoked when device call state changes 
void oncallstatechanged state 
nonnull 
private final context mcontext 
nonnull 
private final handler mhandler 
nonnull 
private final oncallstatechangedlistener mcallback 
private listener mlistener 
private telephonymanager mtelephonymanager 
public callmonitor 
nonnull context context 
nonnull oncallstatechangedlistener listener 
mcontext context 
mcallback listener 
mhandler handler 
mlistener listener this 
public void start 
mstarted true 
mtelephonymanager telephonymanager mcontext getsystemservice context telephony_service 
mtelephonymanager listen mlistener phonestatelistener listen_call_state 
public void stop 
mtelephonymanager listen mlistener phonestatelistener listen_none 
mtelephonymanager null 
mstarted false 
return current call state 
iscalling 
public getcallstate 
return mlistener getcallstate 
return whether phone calling 
getcallstate 
public boolean iscalling 
final state getcallstate 
return state telephonymanager call_state_ringing 
state telephonymanager call_state_offhook 
private void notifycallstatechanged final state 
mhandler post runnable 
override 
public void 
mstarted mcallback oncallstatechanged state 
author artem chepurnoy 
private static class listener extends phonestatelistener 
nonnull 
private final reference callmonitor mcallhandlerref 
current call state 
private mstate 
public listener nonnull callmonitor callstatelistener 
mcallhandlerref weakreference callstatelistener 
mstate telephonymanager call_state_idle 
override 
public void oncallstatechanged state string incomingnumber 
super oncallstatechanged state incomingnumber 
mstate state return 
mstate state 
notify call handler 
callmonitor callstatelistener mcallhandlerref 
callstatelistener null callstatelistener notifycallstatechanged state 
return current call state 
public getcallstate 
return mstate 
