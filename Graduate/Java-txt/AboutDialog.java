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

package achep base fragments dialogs 
import android annotation suppresslint 
import android activity 
import android dialog 
import android content context 
import android content packageinfo 
import android content packagemanager 
import android content resources 
import android graphics color 
import android bundle 
import android support annotation nonnull 
import android text html 
import android text spanned 
import android util 
import android view contextthemewrapper 
import android view view 
import android widget toast 
import achep acdisplay 
import achep base build 
import achep base utils resutils 
import achep base utils toastutils 
import afollestad materialdialogs materialdialog 
dialog fragment that shows some info about this application 
author artem chepurnoy 
public class aboutdialog extends dialogfragment 
private static final string aboutdialog 
private static final easter_eggs_click_number 
private mtitleclicknumber 
private toastutils singletoast mtimestamptoast 
merges name version name into 
nonnull 
public static spanned getversionname nonnull context context 
packagemanager context getpackagemanager 
string packagename context getpackagename 
string versionname 

packageinfo info getpackageinfo packagename 
versionname info versionname 
make info part version name smaller 
versionname indexof 
versionname versionname replacefirst small small 
catch packagemanager namenotfoundexception 
versionname 
attribute android attr textcolorhint 
typedarray context obtainstyledattributes android attr textappearance attribute 
color getcolor 
recycle 
todo color from current theme 
color 
resources context getresources 
return html fromhtml 
resutils getstring string about_dialog_title 
getstring string app_name 
versionname 
integer tohexstring color color 
integer tohexstring color green color 
integer tohexstring color blue color 
override 
public void onattach activity activity 
super onattach activity 
mtimestamptoast toastutils singletoast activity 
nonnull 
override 
public dialog oncreatedialog bundle savedinstancestate 
contextthemewrapper context getactivity 
assert context null 
string year build time_stamp substring build time_stamp lastindexof 
year charat build year corrupted check build script 
string credits getstring string about_dialog_credits 
suppresslint stringformatmatches 
string resutils getstring getresources string about_dialog_message credits year 
charsequence message html fromhtml 
materialdialog materialdialog builder context 
iconres drawable ic_information_outline_white_ 
title getversionname context 
content message 
negativetext string close 
build 
gettitleview setonclicklistener view onclicklistener 
override 
public void onclick view 
switch mtitleclicknumber 
case easter_eggs_click_number 
intent intent intent getactivity mainactivity class 
addflags intent flag_activity_no_animation 
startactivity intent 
reset click counter 
mtitleclicknumber 
break 
default 
mtimestamptoast show build time_stamp toast length_long 
return 
