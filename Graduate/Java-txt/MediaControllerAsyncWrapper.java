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

package achep acdisplay services media 
import android support annotation nonnull 
import android support annotation nullable 
import android text textutils 
import achep base async taskqueuethread 
import java lang reference 
import java lang weakreference 
author artem chepurnoy 
public class mediacontrollerasyncwrapper extends mediacontroller 
private final object monitor object 
private final mediacontroller mmediacontroller 
private mthread 
public mediacontrollerasyncwrapper nonnull mediacontroller 
super mcontext 
mmediacontroller 
override 
public void registerlistener nonnull medialistener listener 
mmediacontroller registerlistener listener 
override 
public void unregisterlistener nonnull medialistener listener 
mmediacontroller unregisterlistener listener 
override 
public void onstart object objects 
mmediacontroller onstart objects 
synchronized monitor 
init thread 
mthread mmediacontroller 
mthread start 
override 
public void onstop object objects 
synchronized monitor 
force stop thread 
mthread finish true 
mmediacontroller onstop objects 
threading 
private static class extends taskqueuethread 
private final reference mediacontroller mmediacontrollerref 
public nonnull mediacontroller 
mmediacontrollerref weakreference 
override 
protected void onhandletask object 
mediacontroller mmediacontrollerref 
null 
mrunning false 
return 
textutils equals object getmetadata 
object 
override 
public void sendtask nonnull object 
onhandletask object 
override 
protected boolean islost 
return false 
represents single event 
private static abstract class 
nullable 
public final string 
public nullable string 
this 
public abstract void nonnull mediacontroller 
event seek song specific position 
author artem chepurnoy 
private static class eventseekto extends 
public final long position 
public eventseekto nullable string long position 
super 
this position position 
override 
public void nonnull mediacontroller 
seekto position 
event send media action 
author artem chepurnoy 
private static class eventmediaaction extends 
public final action 
public eventmediaaction nullable string action 
super 
this action action 
override 
public void nonnull mediacontroller 
sendmediaaction action 
basic methods 
inheritdoc 
override 
public void sendmediaaction action 
synchronized monitor 
mthread sendtask eventmediaaction 
mmediacontroller getmetadata 
action 
inheritdoc 
override 
public void seekto long position 
synchronized monitor 
mthread sendtask eventseekto 
mmediacontroller getmetadata 
position 
inheritdoc 
override 
public long getplaybackbufferedposition 
return mmediacontroller getplaybackbufferedposition 
inheritdoc 
override 
public long getplaybackposition 
return mmediacontroller getplaybackposition 
inheritdoc 
nonnull 
override 
public metadata getmetadata 
return mmediacontroller getmetadata 
inheritdoc 
override 
public getplaybackstate 
return mmediacontroller getplaybackstate 
