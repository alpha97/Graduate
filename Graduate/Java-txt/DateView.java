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

package achep acdisplay widgets 
import android annotation suppresslint 
import android content broadcastreceiver 
import android content context 
import android content intent 
import android content intentfilter 
import android text format dateformat 
import android util attributeset 
import android widget textview 
import achep acdisplay 
import achep base device 
import java text simpledateformat 
import java util date 
import java util locale 
public class dateview extends textview 
private static final string dateview 
private final date mcurrenttime date 
private simpledateformat mdateformat 
private string mlasttext 
private broadcastreceiver mintentreceiver broadcastreceiver 
override 
public void onreceive context context intent intent 
final string action intent getaction 
intent action_time_tick equals action 
intent action_time_changed equals action 
intent action_timezone_changed equals action 
intent action_locale_changed equals action 
intent action_locale_changed equals action 
intent action_timezone_changed equals action 
need fresh date format 
mdateformat null 
updateclock 
public dateview context context attributeset attrs 
super context attrs 
override 
protected void onattachedtowindow 
super onattachedtowindow 
intentfilter filter intentfilter 
filter addaction intent action_time_tick 
filter addaction intent action_time_changed 
filter addaction intent action_timezone_changed 
filter addaction intent action_locale_changed 
getcontext registerreceiver mintentreceiver filter null null 
updateclock 
override 
protected void ondetachedfromwindow 
super ondetachedfromwindow 
mdateformat null reload locale next time 
getcontext unregisterreceiver mintentreceiver 
protected void updateclock 
mdateformat null 
final string dateformat getcontext getstring string status_date_format 
mdateformat getbestdatetimepattern dateformat 
mcurrenttime settime system currenttimemillis 
final string text mdateformat format mcurrenttime 
text equals mlasttext 
settext text 
mlasttext text 
suppresslint newapi 
private simpledateformat getbestdatetimepattern string dateformat 
device hasjellybeanmr 
final locale locale getdefault 
final string dateformat getbestdatetimepattern dateformat 
return simpledateformat 
else 
return simpledateformat dateformat 
