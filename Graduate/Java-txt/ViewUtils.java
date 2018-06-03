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

package achep base utils 
import android graphics matrix 
import android support annotation nonnull 
import android support annotation nullable 
import android text textutils 
import android util 
import android view motionevent 
import android view view 
import android view viewgroup 
import android view viewparent 
import android widget textview 
import achep base device 
import achep base utils logs tracinglog 
import java lang reflect field 
import java lang reflect invocationtargetexception 
import java lang reflect method 
import static achep base build debug 
created artem 
public class viewutils 
private static final string viewutils 
nonnull 
private static final motioneventhandler motion_event_handler device haskitkatapi 
motioneventhandlerreflective 
motioneventhandlerreflectivecompat 
nonnull 
public static view removeviewparent nonnull view view 
return removeviewparent view 
nonnull 
public static view removeviewparent nonnull view view 

view view view getparent 
kick parent 
viewgroup viewgroup view getparent 
null 
removeview view 
else debug tracinglog tried remove parent orphan view 
return view 
public static void setsize nonnull view view size 
setsize view size size 
public static void setsize nonnull view view width height 
viewgroup layoutparams view getlayoutparams 
height height 
width width 
view requestlayout 
public static void setvisible nonnull view view boolean visible 
setvisible view visible view gone 
public static void setvisible nonnull view view boolean visible invisibleflag 
visibility view getvisibility 
visibilitynew visible view visible invisibleflag 
visibility visibilitynew 
view setvisibility visibilitynew 
public static void safelysettext nonnull textview textview nullable charsequence text 
final boolean visible textutils isempty text 
visible textview settext text 
viewutils setvisible textview visible 
return code true point view slop code false otherwise 
public static boolean pointinview nonnull view view float localx float localy float slop 
return localx view getleft slop 
localx view getright slop 
localy view gettop slop 
localy view getbottom slop 
transforms motion event from view local coordinates screen 
coordinates 
param view local motion event 
return code false transformation could applied 
public static boolean toglobalmotionevent nonnull view view nonnull motionevent 
return motion_event_handler toglobalmotionevent view 
transforms motion event from screen coordinates view local 
coordinates 
param screen motion event 
return code false transformation could applied 
public static boolean tolocalmotionevent nonnull view view nonnull motionevent 
return motion_event_handler tolocalmotionevent view 
public static boolean isanimatable view view 
return math random 
private static abstract class motioneventhandler 
transforms motion event from view local coordinates screen 
coordinates 
param view local motion event 
return code false transformation could applied 
abstract boolean toglobalmotionevent nonnull view view nonnull motionevent 
transforms motion event from screen coordinates view local 
coordinates 
param screen motion event 
return code false transformation could applied 
abstract boolean tolocalmotionevent nonnull view view nonnull motionevent 
native motion event handler 
private static final class motioneventhandlerreflective extends motioneventhandler 
override 
boolean toglobalmotionevent nonnull view view nonnull motionevent 
return tomotionevent view toglobalmotionevent 
override 
boolean tolocalmotionevent nonnull view view nonnull motionevent 
return tomotionevent view tolocalmotionevent 
private boolean tomotionevent view view motionevent string methodname 

method method view class getdeclaredmethod methodname motionevent class 
method setaccessible true 
return boolean method invoke view 
catch invocationtargetexception 
illegalaccessexception 
nosuchmethodexception 
noclassdeffounderror 
failed access methodname 
return false 
compatibility motion event handler 
this class uses half native view methods half ported from 
newer versions 
private static final class motioneventhandlerreflectivecompat extends motioneventhandler 
override 
boolean toglobalmotionevent nonnull view view nonnull motionevent 
final windowposition getwindowposition view 
windowposition null 
return false 
transformmotioneventtoglobal view 
offsetlocation windowposition windowposition 
return true 
override 
boolean tolocalmotionevent nonnull view view nonnull motionevent 
final windowposition getwindowposition view 
windowposition null 
return false 
offsetlocation windowposition windowposition 
transformmotioneventtolocal view 
return true 
nullable 
private static getwindowposition nonnull view view 
object info 

field field view class getdeclaredfield mattachinfo 
field setaccessible true 
info field view 
catch exception 
info null 
failed attachinfo 
info null 
return null 
position 

class clazz class forname android view view attachinfo 
field field clazz getdeclaredfield mwindowleft 
field setaccessible true 
position field getint info 
field clazz getdeclaredfield mwindowtop 
field setaccessible true 
position field getint info 
catch exception 
failed window position from attachinfo 
return null 
return position 
recursive helper method that applies transformations post order 
param screen motion event 
private static void transformmotioneventtolocal nonnull view view nonnull motionevent 
final viewparent parent view getparent 
parent instanceof view 
final view view parent 
transformmotioneventtolocal 
offsetlocation getscrollx getscrolly 
todo reflections access viewrootimpl 
else parent instanceof viewrootimpl 
final viewrootimpl viewrootimpl parent 
offsetlocation mcurscrolly 
offsetlocation view getleft view gettop 
matrix matrix view getmatrix 
matrix null 
transform matrix 
recursive helper method that applies transformations order 
param screen motion event 
private static void transformmotioneventtoglobal nonnull view view nonnull motionevent 
matrix matrix view getmatrix 
matrix null 
transform matrix 
offsetlocation view getleft view gettop 
final viewparent parent view getparent 
parent instanceof view 
final view view parent 
offsetlocation getscrollx getscrolly 
transformmotioneventtoglobal 
todo reflections access viewrootimpl 
else parent instanceof viewrootimpl 
final viewrootimpl viewrootimpl parent 
offsetlocation mcurscrolly 
