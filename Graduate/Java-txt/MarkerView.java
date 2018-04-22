copyright google 
licensed under apache license version license 
this file except compliance with license 
obtain copy license 
http apache licenses license 
unless required applicable agreed writing software 
distributed under license distributed basis 
without warranties conditions kind either express implied 
license specific language governing permissions 
limitations under license 
package ringdroid 
import android content context 
import android graphics canvas 
import android graphics rect 
import android util attributeset 
import android view keyevent 
import android view motionevent 
import android widget imageview 
represents draggable start marker 
most events passed back client class using 
listener interface 
this class directly keeps track velocity though 
accelerating user holds down left right arrows 
while this control focused 
public class markerview extends imageview 
public interface markerlistener 
public void markertouchstart markerview marker float 
public void markertouchmove markerview marker float 
public void markertouchend markerview marker 
public void markerfocus markerview marker 
public void markerleft markerview marker velocity 
public void markerright markerview marker velocity 
public void markerenter markerview marker 
public void markerkeyup 
public void markerdraw 
private mvelocity 
private markerlistener mlistener 
public markerview context context attributeset attrs 
super context attrs 
make sure keys 
setfocusable true 
mvelocity 
mlistener null 
public void setlistener markerlistener listener 
mlistener listener 
override 
public boolean ontouchevent motionevent event 
switch event getaction 
case motionevent action_down 
requestfocus 
because this window itself going 
move which will screw local coordinates 
mlistener markertouchstart this event getrawx 
break 
case motionevent action_move 
because this window itself going 
move which will screw local coordinates 
mlistener markertouchmove this event getrawx 
break 
case motionevent action_up 
mlistener markertouchend this 
break 
return true 
override 
protected void onfocuschanged boolean gainfocus direction 
rect previouslyfocusedrect 
gainfocus mlistener null 
mlistener markerfocus this 
super onfocuschanged gainfocus direction previouslyfocusedrect 
override 
protected void ondraw canvas canvas 
super ondraw canvas 
mlistener null 
mlistener markerdraw 
override 
public boolean onkeydown keycode keyevent event 
mvelocity 
math sqrt mvelocity 
mlistener null 
keycode keyevent keycode_dpad_left 
mlistener markerleft this 
return true 
else keycode keyevent keycode_dpad_right 
mlistener markerright this 
return true 
else keycode keyevent keycode_dpad_center 
mlistener markerenter this 
return true 
return super onkeydown keycode event 
override 
public boolean onkeyup keycode keyevent event 
mvelocity 
mlistener null 
mlistener markerkeyup 
return super onkeydown keycode event 
