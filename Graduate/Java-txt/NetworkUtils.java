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
import android connectivitymanager 
import android networkinfo 
import android support annotation nonnull 
utils related internet networking 
author artem chepurnoy 
public class networkutils 
return code true device connected internet 
code false otherwise 
public static boolean isonline nonnull context context 
return isonline connectivitymanager context getsystemservice context connectivity_service 
return code true device connected internet 
code false otherwise 
public static boolean isonline nonnull connectivitymanager 
networkinfo getactivenetworkinfo 
return null isconnectedorconnecting 
