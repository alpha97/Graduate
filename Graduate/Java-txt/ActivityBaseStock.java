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

package achep base activities 
import android activity 
import android content intent 
import android bundle 
import android support annotation nonnull 
import android support annotation nullable 
import achep base interfaces iactivitybase 
import achep base utils power powersavedetector 
import solovyev android checkout activitycheckout 
created artem chepurnoy 
public abstract class activitybasestock extends activity implements iactivitybase 
nonnull 
private final activitybaseinternal mabs activitybaseinternal 
inheritdoc 
override 
protected void oncreate bundle savedinstancestate 
mabs oncreate this savedinstancestate 
super oncreate savedinstancestate 
inheritdoc 
override 
public void onstart 
super onstart 
mabs onstart 
inheritdoc 
override 
public void onstop 
mabs onstop 
super onstop 
override 
protected void ondestroy 
mabs ondestroy 
super ondestroy 
inheritdoc 
override 
protected void onactivityresult requestcode resultcode intent data 
mabs onactivityresult requestcode resultcode data 
super onactivityresult requestcode resultcode data 
iactivitybase 
inheritdoc 
override 
public void requestcheckout 
mabs requestcheckout 
inheritdoc 
override 
public void requestinputmethodreset 
mabs requestinputmethodreset 
inheritdoc 
nonnull 
override 
public activity getactivity 
return mabs getactivity 
inheritdoc 
nullable 
override 
public activitycheckout getcheckout 
return mabs getcheckout 
inheritdoc 
nonnull 
override 
public powersavedetector getpowersavedetector 
return mabs getpowersavedetector 
inheritdoc 
override 
public boolean ispowersavemode 
return mabs ispowersavemode 
inheritdoc 
override 
public boolean isnotpowersavemode 
return mabs isnotpowersavemode 
