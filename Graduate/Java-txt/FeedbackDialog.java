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
import android content intent 
import android content packageinfo 
import android content packagemanager 
import android 
import android bundle 
import android support annotation nonnull 
import android support annotation nullable 
import android support dialogfragment 
import android support appcompatactivity 
import android view view 
import android view viewgroup 
import android view viewstub 
import android widget adapterview 
import android widget checkbox 
import android widget edittext 
import android widget spinner 
import achep acdisplay config 
import achep acdisplay 
import achep acdisplay providers logattachmentprovider 
import achep acdisplay dialoghelper 
import achep base build 
import achep base device 
import achep base content configbase 
import achep base providers logsproviderbase 
import achep base utils fileutils 
import achep base utils intentutils 
import achep base utils packageutils 
import achep base utils resutils 
import achep base utils toastutils 
import achep base utils viewutils 
import achep base utils logcat logcat 
import afollestad materialdialogs dialogaction 
import afollestad materialdialogs materialdialog 
import json jsonexception 
import json jsonobject 
import java file 
import java text simpledateformat 
import java util date 
import java util locale 
import java util timezone 
import static achep base build debug 
feedback dialog fragment 

provides sending bugs suggestions email 
public class feedbackdialog extends dialogfragment implements configbase onconfigchangedlistener 
private view mfaqcontainer 
private spinner mspinner 
private edittext medittext 
private checkbox mattachlogcheckbox 
private final adapterview onitemselectedlistener mlistener 
adapterview onitemselectedlistener 
override 
public void onitemselected adapterview parent view view position long 
show attach checkbox only type 
this message issue 
viewutils setvisible mattachlogcheckbox position 
override 
public void onnothingselected adapterview parent 
viewutils setvisible mattachlogcheckbox false 
override 
public void onresume 
super onresume 
config config config getinstance 
config registerlistener this 
updatefaqpanel config gettriggers ishelpread 
override 
public void onpause 
config config config getinstance 
config unregisterlistener this 
super onpause 
override 
public void onconfigchanged nonnull configbase config 
nonnull string 
nonnull object value 
switch 
case config key_trig_help_read 
boolean read boolean value 
updatefaqpanel read 
break 
nonnull 
override 
public dialog oncreatedialog bundle savedinstancestate 
activity activity getactivity 
assert activity null 
materialdialog materialdialog builder activity 
iconres drawable ic_email_white_ 
title string feedback_dialog_title 
customview layout feedback_dialog true 
negativetext android string cancel 
positivetext string send 
onpositive materialdialog singlebuttoncallback 
override 
public void onclick nonnull materialdialog materialdialog 
nonnull dialogaction dialogaction 
context context getactivity 
charsequence message medittext gettext 
ismessagelongenough message 
boolean attachlog mattachlogcheckbox ischecked 
mattachlogcheckbox getvisibility view visible 
type mspinner getselecteditemposition 
charsequence title createtitle context type 
charsequence body createbody context message 
send title body attachlog 
else 
string toasttext getstring 
string feedback_error_msg_too_short 
getminmessagelength 
toastutils showshort context toasttext 
onnegative materialdialog singlebuttoncallback 
override 
public void onclick nonnull materialdialog materialdialog 
nonnull dialogaction dialogaction 
dismiss 
autodismiss false 
build 
view view getcustomview 
assert view null 
mspinner spinner view findviewbyid type 
mspinner setonitemselectedlistener mlistener 
medittext edittext view findviewbyid message 
mattachlogcheckbox checkbox view findviewbyid checkbox 
frequently asked questions panel 
config triggers triggers config getinstance gettriggers 
triggers ishelpread initfaqpanel viewgroup view 
return 
initialize frequently asked questions panel this panel here reduce 
number already answered questions 
private void initfaqpanel nonnull viewgroup root 
mfaqcontainer viewstub root findviewbyid inflate 
mfaqcontainer findviewbyid setonclicklistener view onclicklistener 
override 
public void onclick view 
appcompatactivity activity appcompatactivity getactivity 
dialoghelper showhelpdialog activity 
removes frequently asked questions panel from view 
sets link mfaqcontainer null 
after calling this method longer able panel back 
private void recyclefaqpanel 
viewutils removeviewparent mfaqcontainer 
mfaqcontainer null 
link recyclefaqpanel recycles frequently asked questions panel when needed 
anymore 
param ishelpread code true recycle panel code false nothing 
private void updatefaqpanel boolean ishelpread 
mfaqcontainer null ishelpread 
recyclefaqpanel 
private void send nonnull charsequence title 
nonnull charsequence body boolean attachlog 
activity context getactivity 
string recipients build support_email 
intent intent intent 
putextra intent extra_email recipients 
putextra intent extra_subject title 
putextra intent extra_text body 
attachlog 
attachlog intent 
intent setaction intent action_send 
intent settype message 
else 
intent setaction intent action_sendto 
intent setdata parse mailto only email apps should handle 
intentutils hasactivityforthat context intent 
startactivity intent 
dismiss 
else 
toastutils showlong context string feedback_error_no_app 
creates title email 
param type following types 
issue 
suggestion 
other 
return title email 
nonnull 
private charsequence createtitle nonnull context context type 
charsequence osversion device api_version_name_short 
charsequence types charsequence issue suggestion other 
return aboutdialog getversionname context osversion types type 
creates body email automatically adds some 
info about device 
param message that been typed user 
return body email 
nonnull 
private charsequence createbody nonnull context context nonnull charsequence 
final string extra 
packageinfo 

context 
getpackagemanager 
getpackageinfo packageutils getname context 
catch packagemanager namenotfoundexception 
extra there exception while getting package info 
break 
jsonobject jsonobject 

config config config getinstance 
related stuff 
app_version_code versioncode 
app_version_name versionname 
app_timestamp build time_stamp 
app_is_debug debug 
app_is_help_read config gettriggers ishelpread 
app_launch_count config gettriggers getlaunchcount 
device related stuff 
language locale getdefault getlanguage 
android_version_release android build version release 
android_version_sdk_int android build version sdk_int 
android_build_display android build display 
android_build_brand android build brand 
android_build_model android build model 
catch jsonexception ignored 
extra there exception while building json 
break 
extra tostring replaceall 
while false 
return nextras added automatically change extra 
private boolean ismessagelongenough nullable charsequence message 
return message null message length getminmessagelength 
private getminmessagelength 
return getresources getinteger integer config_feedback_minmessagelength 
private void attachlog nonnull intent intent 
context context getactivity 

string logcat capture 
null 
throw exception failed capture logcat 
prepare cache directory 
file cachedir context getcachedir 
cachedir null 
throw exception cache directory inaccessible 
file directory file cachedir logsproviderbase directory 
fileutils deleterecursive directory clean cache folder 
directory mkdirs 
throw exception failed create cache directory 
create file 
suppresslint simpledateformat 
simpledateformat simpledateformat yyyymmdd_hhmmss 
settimezone timezone gettimezone 
string filename acdisplay_log_ format date 
file file file directory filename 
write file 
fileutils writetofile file 
throw exception failed write file 
extra stream intent 
parse content logattachmentprovider authority filename 
intent putextra intent extra_stream 
catch exception 
string message resutils getstring getresources string feedback_error_accessing_log getmessage 
toastutils showlong context message 
