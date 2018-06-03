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
import android annotation suppresslint 
import android keyguardmanager 
import android content context 
import android support annotation nonnull 
import achep base device 
author artem chepurnoy 
public class keyguardutils 
returns whether device currently locked requires 
pattern password unlock 
suppresslint newapi 
public static boolean isdevicelocked nonnull context context 
keyguardmanager keyguardmanager context getsystemservice context keyguard_service 
return isdevicelocked 
returns whether device currently locked requires 
pattern password unlock 
suppresslint newapi 
public static boolean isdevicelocked nonnull keyguardmanager 
return device haslollipopmr isdevicelocked iskeyguardsecure 
