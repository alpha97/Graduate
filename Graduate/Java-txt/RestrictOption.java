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

package achep acdisplay blacklist options 
import android content context 
import android widget compoundbutton 
import achep acdisplay 
import achep acdisplay blacklist appconfig 
import achep acdisplay blacklist blacklist 
import achep base utils resutils 
created artem 
public class restrictoption extends option 
public restrictoption context context compoundbutton 
blacklist blacklist string packagename 
super context blacklist packagename 
resutils getdrawable context drawable ic_settings_sleep_mode 
context getresources getstring string blacklist_app_restricted_title 
context getresources getstring string blacklist_app_restricted_summary 
inheritdoc 
override 
public boolean getvalue appconfig config 
return config restricted 
inheritdoc 
override 
public getdiffmask 
return appconfig diff_restricted 
