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
import android graphics pixelformat 
import android support annotation nonnull 
import android util attributeset 
import android util 
import android view view 
import android view windowmanager 
import android widget framelayout 
import static achep base build debug 
author artem chepurnoy 
public class overlayview extends framelayout 
private static final string overlayview 
private static final system_ui_basic_flags 
view system_ui_flag_hide_navigation 
view system_ui_flag_low_profile 
view system_ui_flag_fullscreen 
view system_ui_flag_layout_hide_navigation 
view system_ui_flag_layout_fullscreen 
view system_ui_flag_layout_stable 
public overlayview context context 
super context 
public overlayview context context attributeset attrs 
super context attrs 
override 
protected void onattachedtowindow 
super onattachedtowindow 
setwindowsystemuivisibilityflags 
override 
public void onwindowfocuschanged boolean haswindowfocus 
super onwindowfocuschanged haswindowfocus 
setwindowsystemuivisibilityflags 
override 
public void onwindowsystemuivisibilitychanged visible 
super onwindowsystemuivisibilitychanged visible 
postdelayed runnable 
override 
public void 
setwindowsystemuivisibilityflags 

protected void setwindowsystemuivisibilityflags 
final flags system_ui_basic_flags view system_ui_flag_immersive_sticky 
setsystemuivisibility flags 
clears then sets back immersive mode flags status 
definitely hides 
protected void setwindowsystemuivisibilityflagsrefresh 
final flags system_ui_basic_flags view system_ui_flag_immersive 
setsystemuivisibility flags 
postdelayed runnable 
override 
public void 
setwindowsystemuivisibilityflags 

safely adds this view window manager 
public void addoverlayview 
final context context getcontext 
final windowmanager windowmanager context getsystemservice context window_service 

addview this createlayoutparams 
catch exception 
debug failed overlay view message getmessage 
safely removes this view from window manager 
public void removeoverlayview 
final context context getcontext 
final windowmanager windowmanager context getsystemservice context window_service 

removeview this 
catch exception 
debug failed overlay view message getmessage 
nonnull 
private windowmanager layoutparams createlayoutparams 
type windowmanager layoutparams type_system_error 
flags windowmanager layoutparams flag_hardware_accelerated 
windowmanager layoutparams flag_alt_focusable_im 
windowmanager layoutparams flag_show_when_locked 
windowmanager layoutparams flag_layout_in_screen 
windowmanager layoutparams flag_layout_no_limits 
windowmanager layoutparams flag_dismiss_keyguard 
windowmanager layoutparams windowmanager layoutparams 
windowmanager layoutparams match_parent 
windowmanager layoutparams match_parent 
type flags 
pixelformat rgb_ 
softinputmode windowmanager layoutparams soft_input_state_always_hidden 
return 
