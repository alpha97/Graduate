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
import android support annotation nonnull 
import android text format dateformat 
helper class with utils related date 
author artem chepurnoy 
public class dateutils 
formats given hours minutes hours format 
depends current system settings 
return formatted string time 
nonnull 
public static string formattime nonnull context context 
dateformat hourformat context formatting 

else 
return 
