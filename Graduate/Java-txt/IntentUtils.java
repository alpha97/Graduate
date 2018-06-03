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
import android content intent 
import android content packagemanager 
import android 
import android support annotation nonnull 
import android support annotation nullable 
created artem 
public class intentutils 
public static boolean hasactivityforthat nonnull context context nullable intent intent 
packagemanager context getpackagemanager 
return null intent null intent resolveactivity null 
public static intent createviewintent nonnull 
return intent intent action_view 
