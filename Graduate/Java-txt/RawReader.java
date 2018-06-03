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
import android support annotation nullable 
import android support annotation rawres 
import java bufferedreader 
import java ioexception 
import java inputstream 
import java inputstreamreader 
import timber timber 
resources utils 
author artem chepurnoy 
public final class rawreader 
private static final string rawreader 
reads text from resource 
param resource file read code 
return text from resource code null 
reading failed resource code 
nullable 
public static string readtext nonnull context context rawres resource 
resource return null 
final inputstream inputstream context getresources openrawresource resource 
final inputstreamreader inputstreamreader inputstreamreader inputstream 
final bufferedreader bufferedreader bufferedreader inputstreamreader 

return ioutils readtextfrombufferedreader bufferedreader 
catch ioexception 
timber failed read resource resource 
return null 
