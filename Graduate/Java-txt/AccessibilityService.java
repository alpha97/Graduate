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

package achep acdisplay services 
import android accessibilityservice accessibilityserviceinfo 
import android notification 
import android parcelable 
import android view accessibility accessibilityevent 
import achep acdisplay notifications notificationpresenter 
import achep acdisplay notifications opennotification 
import achep base device 
created artem chepurnoy 
public class accessibilityservice extends android accessibilityservice accessibilityservice 
private static final string accessibilityservice 
override 
public void onserviceconnected 
accessibilityserviceinfo info accessibilityserviceinfo 
info eventtypes accessibilityevent type_notification_state_changed 
info feedbacktype accessibilityserviceinfo feedback_generic 
info notificationtimeout 
setserviceinfo info 
override 
public void onaccessibilityevent accessibilityevent event 
switch event geteventtype 
case accessibilityevent type_notification_state_changed 
parcelable parcelable event getparcelabledata 
parcelable instanceof notification 
device hasjellybeanmr 
need accessibility service 
instead notificationlistener 
return 
notification notification notification parcelable 
opennotification opennotification opennotification newinstance notification 
notificationpresenter getinstance postnotificationfrommain this opennotification 
break 
inheritdoc 
override 
public void oninterrupt unused 
