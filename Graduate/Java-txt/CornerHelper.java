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

package achep acdisplay 
import android content context 
import android content intent 
import android 
import android provider mediastore 
import android support annotation drawableres 
import android support annotation nonnull 
import android util 
import achep acdisplay config 
import achep acdisplay 
created artem chepurnoy 
public class cornerhelper 
private static final string cornerhelper 
private static final icon_ids 
drawable ic_corner_unlock_white 
drawable ic_corner_launch_photo_camera_white 
drawable ic_corner_launch_dialer_white 
return icon resource specific action 
drawableres 
public static geticonresource actionid 
return icon_ids actionid 
performs specific corner action 
public static void perform nonnull context context actionid 
switch actionid 
case config corner_unlock 
nothing special 
break 
case config corner_launch_camera 

intent intent intent mediastore intent_action_still_image_camera 
context startactivity intent 
catch exception 
unable launch camera 
printstacktrace 
break 
case config corner_launch_dialer 

intent intent intent intent action_dial 
intent setdata parse todo check works devices 
context startactivity intent 
catch exception 
unable launch dialer 
printstacktrace 
break 
default 
throw illegalargumentexception 
