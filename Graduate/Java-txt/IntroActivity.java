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

package achep acdisplay activities 
import android graphics color 
import android bundle 
import android text html 
import android view view 
import achep acdisplay 
import achep base device 
import github paolorotolo appintro appintro 
import github paolorotolo appintro appintrofragment 
author artem chepurnoy 
public class introactivity extends appintro 
private static final system_ui_basic_flags 
static 
final device haskitkatapi view system_ui_flag_hide_navigation 
system_ui_basic_flags 
view system_ui_flag_low_profile 
view system_ui_flag_layout_fullscreen 
view system_ui_flag_layout_hide_navigation 
view system_ui_flag_layout_stable 
override 
public void init bundle savedinstancestate 
addslide appintrofragment newinstance 
getstring string intro_welcome_title 
getstring string intro_welcome_summary 
drawable ic_intro_app 
addslide appintrofragment newinstance 
getstring string intro_notifications_title 
getstring string intro_notifications_summary 
drawable ic_intro_notifications 
todo color from current theme 
color 
addslide appintrofragment newinstance 
getstring string intro_am_title 
html fromhtml getstring string intro_am_summary_skeleton 
getstring string intro_am_summary 
getstring string intro_settings_enable 
integer tohexstring color color 
integer tohexstring color green color 
integer tohexstring color blue color tostring 
drawable ic_intro_active_mode 
update system visibility hide 
status 
final view decorview getwindow getdecorview 
decorview setonsystemuivisibilitychangelistener 
view onsystemuivisibilitychangelistener 
public final void onsystemuivisibilitychange 
setsystemuivisibilityfake 
decorview postdelayed runnable 
override 
public void 
visibility system_ui_basic_flags 
view system_ui_flag_immersive_sticky 
view system_ui_flag_fullscreen 
decorview setsystemuivisibility visibility 

public void setsystemuivisibilityfake 
visibility system_ui_basic_flags 
view system_ui_flag_immersive 
view system_ui_flag_fullscreen 
getwindow getdecorview setsystemuivisibility visibility 
override 
protected void onresume 
super onresume 
setsystemuivisibilityfake 
override 
public void ondonepressed 
finish should replace this activity with main activity 
override 
public void onslidechanged unused 
override 
public void onnextpressed unused 
