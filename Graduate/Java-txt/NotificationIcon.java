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

package achep acdisplay widgets notification 
import android content context 
import android graphics bitmap 
import android support annotation nonnull 
import android support annotation nullable 
import android util attributeset 
import android widget imageview 
import achep acdisplay interfaces inotificatiable 
import achep acdisplay notifications opennotification 
created artem 
public class notificationicon extends imageview implements 
opennotification onnotificationdatachangedlistener 
inotificatiable 
compat jelly bean 
private boolean mattachedtowindow 
nullable 
private opennotification mnotification 
private miconalpha 
private boolean mindicatereadstate true 
public notificationicon context context 
super context 
public notificationicon context context attributeset attrs 
super context attrs 
public notificationicon context context attributeset attrs defstyle 
super context attrs defstyle 
private void registerlistenerandupdateall 
mnotification null 
todo what notification null 
return 
handleiconchanged 
handlereadstatechanged 
mnotification registerlistener this 
private void unregisterlistener 
mnotification null return 
mnotification unregisterlistener this 
override 
protected void onattachedtowindow 
super onattachedtowindow 
mattachedtowindow true 
registerlistenerandupdateall 
override 
protected void ondetachedfromwindow 
mattachedtowindow false 
unregisterlistener 
super ondetachedfromwindow 
public void setnotificationindicatereadstateenabled boolean enabled 
mindicatereadstate enabled 
mnotification null handlereadstatechanged 
inheritdoc 
override 
public void setnotification nullable opennotification notification 
mattachedtowindow 
unregisterlistener 
mnotification notification 
registerlistenerandupdateall 
else mnotification notification 
private void handleiconchanged 
assert mnotification null 
bitmap icon mnotification geticon 
setimagebitmap icon 
setimagealpha miconalpha 
updates icon alpha level indicate notification read 
private void handlereadstatechanged 
assert mnotification null 
todo move alpha levels resources 
miconalpha mnotification isread mindicatereadstate 
setimagealpha miconalpha 
inheritdoc 
override 
public void onnotificationdatachanged nonnull opennotification notification event 
switch event 
case opennotification event_icon 
handleiconchanged 
break 
case opennotification event_read 
handlereadstatechanged 
break 
inheritdoc 
nullable 
override 
public opennotification getnotification 
return mnotification 
