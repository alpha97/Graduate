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
import android support annotation nonnull 
import android support annotation nullable 
author artem chepurnoy 
class notificationprtask 
nullable 
public final context context 
nonnull 
public final opennotification notification 
code true link notificationpresenter postnotification context opennotification post 
event code false link notificationpresenter removenotification opennotification otherwise 
public final boolean posts 
public volatile flags 
notificationprtask nullable context context nonnull opennotification notification 
boolean posts flags 
this context context 
this notification notification 
this posts posts 
this flags flags 
inheritdoc 
override 
public string tostring 
return string format notificationprtask is_post_event flags 
notification tostring posts flags 
