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

package achep acdisplay preferences 
import android timepickerdialog 
import android content context 
import android support annotation nonnull 
import android text html 
import android util attributeset 
import android view view 
import android widget checkbox 
import android widget textview 
import android widget timepicker 
import achep acdisplay config 
import achep acdisplay 
import achep base preferences materialdialogpreference 
import achep base utils dateutils 
import afollestad materialdialogs materialdialog 
preference configure timeouts 
author artem chepurnoy 
public class inactivetimepreference extends materialdialogpreference implements view onclicklistener 
private static final string inactivehourspreference 
private checkbox menabled 
private data mfrom data 
private data data 
public static class data 
public hours 
public minutes 
public string labelsource 
public textview labeltextview 
public void settime context context timeinminutes 
settime context timeinminutes timeinminutes 
public void settime context context hours minutes 
this hours hours 
this minutes minutes 
string labeltime dateutils formattime context hours minutes 
labeltextview settext html fromhtml string format labelsource labeltime 
public inactivetimepreference context context attributeset attrs 
super context attrs 
nonnull 
override 
public materialdialog onbuilddialog nonnull materialdialog builder builder 
context context getcontext 
materialdialog builder 
customview layout preference_dialog_inactive_hours false 
build 
view root getcustomview 
assert root null 
textview fromtextview textview root findviewbyid from 
textview totextview textview root findviewbyid 
menabled checkbox root findviewbyid checkbox 
fromtextview setonclicklistener this 
totextview setonclicklistener this 
mfrom labeltextview fromtextview 
mfrom labelsource context getstring string preference_inactive_hours_from 
labeltextview totextview 
labelsource context getstring string preference_inactive_hours_to 
config config config getinstance 
mfrom settime context config getinactivetimefrom 
settime context config getinactivetimeto 
menabled setchecked config isinactivetimeenabled 
return 
override 
protected void ondialogclosed boolean positiveresult 
super ondialogclosed positiveresult 
positiveresult 
return 
context context getcontext 
config config config getinstance 
config setinactivetimefrom context mfrom hours mfrom minutes null 
config setinactivetimeto context hours minutes null 
config setinactivetimeenabled context menabled ischecked null 
override 
public void onclick view 
final data data mfrom labeltextview mfrom 
timepickerdialog timepickerdialog timepickerdialog getcontext 
timepickerdialog ontimesetlistener 
override 
public void ontimeset timepicker timepicker selectedhour selectedminute 
data settime getcontext selectedhour selectedminute 
data hours data minutes true 
timepickerdialog show 
