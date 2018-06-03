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

package achep base interfaces 
import android activity 
import android support annotation nonnull 
import android support annotation nullable 
import achep base utils power powersavedetector 
import solovyev android checkout activitycheckout 
created artem chepurnoy 
public interface iactivitybase extends ipowersave 
requests load link solovyev android checkout checkout activity 
create must called from link activity oncreate 
void requestcheckout 
requests activity apply this workaround activity destroy 
http code google android issues detail 
void requestinputmethodreset 
nonnull 
activity getactivity 
nullable 
activitycheckout getcheckout 
ispowersavemode 
nonnull 
powersavedetector getpowersavedetector 
