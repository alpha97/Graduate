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
import android content context 
import android content colorstatelist 
import android support annotation nonnull 
import android view view 
import achep acdisplay 
import achep base device 
import achep base interfaces iactivitybase 
import dreamers graphics rippledrawable 
created artem chepurnoy 
public class rippleutils 
return code false ripple been code true otherwise 
public static boolean makefor nonnull view view boolean parentisscrollcontainer 
return makefor parentisscrollcontainer true view 
return code false ripple been code true otherwise 
public static boolean makefor boolean parentisscrollcontainer 
boolean darktheme nonnull view views 
colorstatelist views getresources getcolorstatelist 
darktheme color ripple_dark color ripple_light 
return null makefor parentisscrollcontainer views 
public static boolean makefor nonnull colorstatelist 
boolean parentisscrollcontainer 
nonnull view views 
device haslollipopapi 
create ripple effect power save mode because 
this will drain more energy 
context context views getcontext 
context instanceof iactivitybase 
iactivitybase activitybase iactivitybase context 
activitybase ispowersavemode 
return true 
view view views 
view setbackground null 
rippledrawable makefor view parentisscrollcontainer 
return false 
return true 
