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
option link achep acdisplay fragments blacklistappfragment settings 
allow enabling clearable notifications 
author artem chepurnoy 
public class nonclearableoption extends option 
public nonclearableoption context context compoundbutton 
blacklist blacklist string packagename 
super context blacklist packagename 
resutils getdrawable context drawable ic_settings_non_clearable_notifies 
context getresources getstring string blacklist_app_non_clearable_title 
context getresources getstring string blacklist_app_non_clearable_summary 
inheritdoc 
override 
public boolean getvalue appconfig config 
return config nonclearable 
inheritdoc 
override 
public getdiffmask 
return appconfig diff_non_clearable 
