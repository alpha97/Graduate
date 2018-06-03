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

package achep base async 
import android handler 
import android message 
import android support annotation nonnull 
import java lang weakreference 
import timber timber 
created artem chepurnoy 
public abstract class weakhandler extends handler 
private static final string weakhandler 
nonnull 
private weakreference mweakref 
public weakhandler nonnull object 
mweakref weakreference object 
override 
public void handlemessage message 
super handlemessage 
object mweakref 
object null 
timber weak reference died 
class mweakref getclass 
message tostring 
return 
onhandlemassage object 
protected abstract void onhandlemassage nonnull object message 
