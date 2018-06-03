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

package achep acdisplay notifications 
import android content context 
import android graphics bitmap 
import android support annotation nonnull 
import static achep acdisplay graphics backgroundfactory generate 
simple single thread background factory 
author artem chepurnoy 
achep acdisplay graphics backgroundfactory 
achep acdisplay notifications iconfactory 
class backgroundfactory extends iconfactory 
public interface backgroundasynclistener extends iconasynclistener 
identical 
nonnull 
override 
protected bitmap ongenerate nonnull context context nonnull opennotification notification 
context always null here 
return generate notification getnotification largeicon 
