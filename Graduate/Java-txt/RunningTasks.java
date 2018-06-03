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

package achep acdisplay utils tasks 
import android content context 
import android support annotation nonnull 
import android support annotation nullable 
import achep base device 
import java lang reference 
import java lang softreference 
author artem chepurnoy 
public abstract class runningtasks 
nonnull 
private static reference runningtasks sfactoryref softreference null 
nonnull 
public static runningtasks getinstance 
runningtasks factory sfactoryref 
factory null 
factory newinstance 
sfactoryref softreference factory 
return factory 
return factory 
nonnull 
private static runningtasks newinstance 
device haslollipopapi 
return runningtaskslollipop 
return runningtasksjellybean 
gets package name running activity 
nullable 
public abstract string getrunningtaskstop nonnull context context 
