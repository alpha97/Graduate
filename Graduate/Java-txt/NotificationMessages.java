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
import android content typedarray 
import android support annotation layoutres 
import android support annotation nullable 
import android text spannablestring 
import android text spanned 
import android text style underlinespan 
import android util attributeset 
import android view layoutinflater 
import android view view 
import android widget linearlayout 
import android widget textview 
import achep acdisplay 
import achep base tests check 
import java util arrays 
author artem chepurnoy 
since 
public class notificationmessages extends linearlayout 
private charsequence mmessages 
private boolean mhighlightmessages 
private mmaxlines 
public notificationmessages context context attributeset attrs 
this context attrs 
public notificationmessages context context attributeset attrs defstyle 
super context attrs defstyle 
typedarray context obtainstyledattributes attrs styleable notificationmessages 
setmaxlines getint styleable notificationmessages_maxlines 
sethighlightmessagesenabled getboolean styleable notificationmessages_highlightmessages true 
recycle 
public void setmaxlines maxlines 
mmaxlines maxlines 
updatemessages 
public void sethighlightmessagesenabled boolean enabled 
mhighlightmessages enabled 
updatemessages 
protected void updatemessages 
mmessages null setmessages mmessages 
param messages array empty messages 
public void setmessages final nullable charsequence messages 
mmessages messages 
messages null 
free messages container 
removeallviews 
return 
freelines mmaxlines 
final length messages length 
final viewcount math length freelines 
final viewmaxlines length 
freelines length reserve more than line message 
initial setup 
arrays fill viewmaxlines 
freelines length 
build list lengths have 
recalculate every time 
msglengths length 
length 
assert messages null 
msglengths messages length 
while freelines 

float 
length 
final float float msglengths viewmaxlines 



viewmaxlines 
freelines 
else 
show first messages 
freelines freelines 
viewmaxlines 
view views view viewcount 
find available views 
childcount getchildcount 
math childcount viewcount 
views getchildat 
remove redundant views 
childcount viewcount 
removeviewat 
boolean highlightfirstletter mhighlightmessages viewcount 
layoutinflater inflater null 
viewcount 
view root views 
root null 
initialize layout inflater only when really need 
inflater null 
inflater layoutinflater getcontext 
getsystemservice context layout_inflater_service 
assert inflater null 
root inflater inflate 
getmessagelayoutresource 
this false 
fixme 
need keep unique make 
transitionmanager begindelayedtransition viewgroup 
work correctly 
root setid getchildcount 
addview root 
check getinstance istrue messages length 
final charsequence text 
final char char_ messages charat 
highlightfirstletter character isletter char_ character isdigit char_ 
spannablestring spannable spannablestring messages 
spannable setspan underlinespan spanned span_exclusive_exclusive 
text spannable 
else 
text messages 
message view apply content 
textview textview root instanceof textview 
textview root 
textview root findviewbyid android message 
textview setmaxlines viewmaxlines 
textview settext text 
layoutres 
protected getmessagelayoutresource 
return layout notification_message 
