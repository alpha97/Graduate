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

package achep acdisplay widgets status 
import android content contentresolver 
import android content context 
import android provider settings 
import android text textutils 
import android util attributeset 
import android widget textview 
import java util regex matcher 
import java util regex pattern 
created achep 
todo watch alarm changes 
public class nextalarmview extends textview 
private static final pattern digit_pattern pattern compile 
private static final string formatter time 
public nextalarmview context context 
this context null 
public nextalarmview context context attributeset attrs 
this context attrs 
public nextalarmview context context attributeset attrs defstyle 
super context attrs defstyle 
override 
protected void onattachedtowindow 
super onattachedtowindow 
updatetext 
private void updatetext 
contentresolver getcontext getcontentresolver 
string nextalarm settings system getstring settings system next_alarm_formatted 
textutils isempty nextalarm 
matcher digit_pattern matcher nextalarm 
find start 
nextalarm string format formatter 
nextalarm substring start 
nextalarm substring start 
settext nextalarm 
