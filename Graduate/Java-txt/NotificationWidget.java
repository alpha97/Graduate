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
import android support annotation nonnull 
import android support annotation nullable 
import android util attributeset 
import android view view 
import android view viewgroup 
import android widget imageview 
import android widget linearlayout 
import android widget textview 
import achep acdisplay 
import achep acdisplay interfaces inotificatiable 
import achep acdisplay notifications notificationuihelper 
import achep acdisplay notifications opennotification 
simple notification widget that shows title notification 
message icon actions more 
author artem chepurnoy 
public class notificationwidget extends linearlayout implements 
inotificatiable notificationuihelper onnotificationcontentchanged 
private notificationuihelper mhelper 
views 
private viewgroup mcontent 
private imageview mlargeicon 
private textview mwhentextview 
private textview mtitletextview 
private textview msubtitletextview 
private notificationmessages mmessagecontainer 
private notificationactions mactionscontainer 
private callback mcallback 
public interface callback extends notificationactions callback 
called content view click 
param clicked view 
notificationwidget getnotification 
void oncontentclick nonnull notificationwidget widget nonnull view 
public notificationwidget context context attributeset attrs 
this context attrs 
public notificationwidget context context attributeset attrs defstyle 
super context attrs defstyle 
mhelper notificationuihelper context this 
mhelper setbig true 
register callback invoked when notification views clicked 
public void setcallback nullable callback callback 
mcallback callback 
callback 
mactionscontainer setcallback callback 
mcontent setonclicklistener callback null 
null 
view onclicklistener 
override 
public void onclick view 
mcallback null 
notificationwidget widget notificationwidget this 
mcallback oncontentclick widget 
override 
protected void onfinishinflate 
super onfinishinflate 
mcontent viewgroup findviewbyid content 
mlargeicon imageview findviewbyid icon 
mwhentextview textview findviewbyid when 
mtitletextview textview findviewbyid title 
msubtitletextview textview findviewbyid subtext 
mmessagecontainer notificationmessages findviewbyid message_container 
mactionscontainer notificationactions findviewbyid actions 
override 
protected void onattachedtowindow 
super onattachedtowindow 
mhelper resume 
override 
protected void ondetachedfromwindow 
mhelper pause 
super ondetachedfromwindow 
inheritdoc 
override 
public void onnotificationcontentchanged nonnull notificationuihelper helper event 
switch event 
case notificationuihelper event_large_icon_changed 
mlargeicon setimagebitmap helper getlargeicon 
break 
case notificationuihelper event_timestamp_changed 
mwhentextview settext helper gettimestamp 
break 
case notificationuihelper event_title_changed 
mtitletextview settext helper gettitle 
break 
case notificationuihelper event_subtitle_changed 
msubtitletextview settext helper getsubtitle 
break 
case notificationuihelper event_message_changed 
mmessagecontainer setmessages helper getmessages 
break 
case notificationuihelper event_actions_changed 
mactionscontainer setactions helper getnotification helper getactions 
break 
inheritdoc 
override 
public opennotification getnotification 
return mhelper getnotification 
inheritdoc 
override 
public void setnotification opennotification 
mhelper setnotification 
