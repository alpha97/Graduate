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
import android support annotation nonnull 
import android support annotation nullable 
import achep base interfaces ionlowmemory 
import java util arraylist 
list link opennotification notifications with 
ability easily replace remove item from list 
author artem chepurnoy 
final class notificationlist extends arraylist opennotification implements ionlowmemory 
default return value link pushnotification opennotification 
link removenotification opennotification methods 
static final result_default 
private static final event_added 
private static final event_changed 
private static final event_removed 
nullable 
private onnotificationlistchangedlistener mlistener 
setmaximumsize 
private volatile mmaximumsize integer max_value 
inheritdoc 
override 
public void onlowmemory 
opennotification this onlowmemory 
interface definition callback invoked 
when list notifications changed 
public interface onnotificationlistchangedlistener 
called when notification added list 
param newly added notification 
onnotificationadded nonnull opennotification 
called when notification replaced with 
param newly added notification 
param removed notification 
onnotificationchanged nonnull opennotification nonnull opennotification 
called when notification removed from list 
param removed notification 
onnotificationremoved nonnull opennotification 
creates link achep acdisplay notifications notificationlist with initial capacity 
equals code 
param listener listener which events will send 
public notificationlist nullable onnotificationlistchangedlistener listener 
mlistener listener 
sets maximum size this list 
param maxsize maximum size 
public void setmaximumsize maxsize 
maxsize 
throw illegalargumentexception maximum size must greater than zero 
mmaximumsize maxsize 
pushorremovenotification nonnull opennotification boolean push 
return push pushnotification removenotification 
adds replaces existent notification list 
return link notificationlist onnotificationlistchangedlistener onnotificationadded opennotification 
link notificationlist onnotificationlistchangedlistener onnotificationchanged opennotification opennotification 
pushnotification nonnull opennotification 
return pushnotification true 
pushnotification nonnull opennotification boolean 
final index indexofnotification 
index 
size mmaximumsize 
remove 
notification list 

return notifylistener event_added null 
else 
replace notification with 
opennotification remove index 
index 
return notifylistener event_changed 
return result_default 
removes notification from list 
return link notificationlist onnotificationlistchangedlistener onnotificationremoved opennotification 
pushnotification opennotification 
removenotification nonnull opennotification 
final index indexofnotification 
return index removenotification index result_default 
removenotification index 
opennotification remove index 
return notifylistener event_removed null 
return position given link opennotification list code found 
notificationutils hasidenticalids opennotification opennotification 
indexofnotification nonnull opennotification 
final size size 
size 
notificationutils hasidenticalids 
return 
return 
notifies listener about this event 
event_added 
event_changed 
event_removed 
private notifylistener final event nonnull opennotification opennotification 
mlistener null return result_default 
switch event 
case event_added 
return mlistener onnotificationadded 
case event_changed 
return mlistener onnotificationchanged 
case event_removed 
return mlistener onnotificationremoved 
default 
throw illegalargumentexception 
