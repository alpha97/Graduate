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
import android content context 
import android util attributeset 
import android view hapticfeedbackconstants 
import android view motionevent 
import android view view 
import android view viewgroup 
import android widget linearlayout 
import achep base utils viewutils 
created achep 
public class forwardinglayout extends linearlayout 
private static final string forwardinglayout 
private view mpressedchild 
private onforwardedeventlistener monforwardedeventlistener 
private boolean mvibrateonforwarded 
private boolean mforwardall 
private mforwarddepth 
public forwardinglayout context context 
super context 
public forwardinglayout context context attributeset attrs 
super context attrs 
public forwardinglayout context context attributeset attrs defstyle 
super context attrs defstyle 
public interface onforwardedeventlistener 
void onforwardedevent motionevent event activepointerid 
void onpressedview motionevent event activepointerid view view 
public void setonforwardedeventlistener onforwardedeventlistener listener 
monforwardedeventlistener listener 
enabled forwarding motion event will accompanied 
haptic feedback press press click 
public void setvibrateonforwardedeventenabled boolean enabled 
mvibrateonforwarded enabled 
public void setallviewsforwardable boolean enabled depth 
mforwardall enabled 
mforwarddepth depth 
handles forwarded events 
param activepointerid pointer that activated forwarding 
return whether event handled 
public boolean onforwardedevent motionevent event activepointerid 
boolean handledevent true 
view vibrateview null 
final actionmasked event getactionmasked 
switch actionmasked 
case motionevent action_cancel 
handledevent false 
break 
case motionevent action_up 
handledevent false 
fall through 
case motionevent action_down 
case motionevent action_move 
final activeindex event findpointerindex activepointerid 
activeindex 
handledevent false 
break 
final event getx activeindex 
final event gety activeindex 
view pressedview findviewbycoordinate this 
mpressedchild pressedview 
vibrateview pressedview null pressedview mpressedchild 
pressedview null pressedview setpressed true 
mpressedchild null mpressedchild setpressed false 
mpressedchild pressedview 
monforwardedeventlistener null 
monforwardedeventlistener onpressedview event activepointerid mpressedchild 
actionmasked motionevent action_up 
vibrateview mpressedchild 
clickpresseditem 
break 
failure handle event cancels forwarding 
handledevent 
clearpresseditem 
vibrateview null mvibrateonforwarded 
vibrateview performhapticfeedback hapticfeedbackconstants virtual_key 
monforwardedeventlistener null 
monforwardedeventlistener onforwardedevent event activepointerid 
return handledevent 
private view findviewbycoordinate viewgroup viewgroup float float depth 
final childcount viewgroup getchildcount 
childcount 
final view child viewgroup getchildat 
assert child null 
child getvisibility view visible child isenabled 
continue 
child instanceof viewgroup depth mforwarddepth mforwardall 
view view findviewbycoordinate viewgroup child 
child getleft 
child gettop depth 
view null 
return view 
child isclickable mforwardall viewutils pointinview child 
return child 
return null 
private void clearpresseditem 
mpressedchild null 
return 
mpressedchild setpressed false 
mpressedchild refreshdrawablestate 
mpressedchild null 
private void clickpresseditem 
mpressedchild null 
return 
mpressedchild performclick 
clearpresseditem 
