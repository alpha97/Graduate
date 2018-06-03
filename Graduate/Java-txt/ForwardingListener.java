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

package achep acdisplay view 
import android view motionevent 
import android view view 
import android view viewconfiguration 
import android view viewparent 
import achep base utils viewutils 
abstract class that forwards touch events link forwardinglayout 
public class forwardinglistener implements 
view ontouchlistener view onattachstatechangelistener 
scaled touch slop used detecting movement outside bounds 
private final float mscaledtouchslop 
timeout before disallowing intercept source parent 
private final mtaptimeout 
source view from which events forwarded 
private final view msrc 
private final forwardinglayout mdst 
runnable used prevent conflicts with scrolling parents 
private runnable mdisallowintercept 
whether this listener currently forwarding touch events 
private boolean mforwarding 
first pointer down current event stream 
private mactivepointerid 
private final boolean mimmediately 
public forwardinglistener view 
this false 
public forwardinglistener view boolean immediately 
this immediately null 
public forwardinglistener view boolean immediately forwardinglayout 
msrc 
mdst 
mimmediately immediately 
mscaledtouchslop viewconfiguration getcontext getscaledtouchslop 
mtaptimeout viewconfiguration gettaptimeout 
addonattachstatechangelistener this 
returns layout which this listener forwarding events 

override this return correct layout layout displayed 
asynchronously also need override 
link onforwardingstopped prevent premature cancelation 
forwarding 
return layout which this listener forwarding events 
public forwardinglayout getforwardinglayout 
return null 
override 
public boolean ontouch view motionevent event 
final boolean wasforwarding mforwarding 
final boolean forwarding 
wasforwarding 
forwarding ontouchforwarded event onforwardingstopped 
else 
forwarding ontouchobserved event onforwardingstarted 
mimmediately forwarding 
mforwarding true 
ontouch event 
mforwarding forwarding 
return forwarding wasforwarding 
override 
public void onviewattachedtowindow view 
override 
public void onviewdetachedfromwindow view 
mforwarding false 
mactivepointerid motionevent invalid_pointer_id 
mdisallowintercept null 
msrc removecallbacks mdisallowintercept 
called when forwarding would like start 
return true start forwarding false otherwise 
protected boolean onforwardingstarted 
return true 
called when forwarding would like stop 
return true stop forwarding false otherwise 
protected boolean onforwardingstopped 
return true 
observes motion events determines when start forwarding 
param srcevent motion event source view coordinates 
return true start forwarding motion events false otherwise 
private boolean ontouchobserved motionevent srcevent 
final view msrc 
isenabled 
return false 
final actionmasked srcevent getactionmasked 
switch actionmasked 
case motionevent action_down 
mactivepointerid srcevent getpointerid 
mimmediately 
mdisallowintercept null 
mdisallowintercept disallowintercept 
postdelayed mdisallowintercept mtaptimeout 
break 
case motionevent action_move 
final activepointerindex srcevent findpointerindex mactivepointerid 
activepointerindex 
final float srcevent getx activepointerindex 
final float srcevent gety activepointerindex 
viewutils pointinview mscaledtouchslop mimmediately 
pointer moved outside view 
mdisallowintercept null 
removecallbacks mdisallowintercept 
getparent requestdisallowintercepttouchevent true 
return true 
break 
case motionevent action_cancel 
case motionevent action_up 
mdisallowintercept null 
removecallbacks mdisallowintercept 
break 
return false 
handled forwarded motion events determines when stop 
forwarding 
param srcevent motion event source view coordinates 
return true continue forwarding motion events false cancel 
private boolean ontouchforwarded motionevent srcevent 
final view msrc 
final forwardinglayout mdst null mdst getforwardinglayout 
null isshown 
return false 
convert event destination local coordinates 
final motionevent dstevent motionevent obtainnohistory srcevent 
assert dstevent null 
viewutils toglobalmotionevent dstevent 
viewutils tolocalmotionevent dstevent 
forward converted event destination view then recycle 
final boolean handled onforwardedevent dstevent mactivepointerid 
dstevent recycle 
return handled 
private class disallowintercept implements runnable 
override 
public void 
final viewparent parent msrc getparent 
parent requestdisallowintercepttouchevent true 
