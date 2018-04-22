copyright google 
licensed under apache license version license 
this file except compliance with license 
obtain copy license 
http apache licenses license 
unless required applicable agreed writing software 
distributed under license distributed basis 
without warranties conditions kind either express implied 
license specific language governing permissions 
limitations under license 
package ringdroid 
import java file 
import java util arraylist 
import java util arrays 
import android alertdialog 
import android listactivity 
import android loadermanager 
import android content cursorloader 
import android content dialoginterface 
import android content intent 
import android content loader 
import android database cursor 
import android database mergecursor 
import android media ringtonemanager 
import android 
import android bundle 
import android environment 
import android provider mediastore 
import android util 
import android view contextmenu 
import android view contextmenu contextmenuinfo 
import android view menu 
import android view menuinflater 
import android view menuitem 
import android view view 
import android widget adapterview 
import android widget adapterview onitemclicklistener 
import android widget imageview 
import android widget searchview 
import android widget simplecursoradapter 
import android widget toast 
import ringdroid soundfile soundfile 
main screen that shows when launch ringdroid handles selecting 
audio file using intent record then 
launches ringdroideditactivity from here 
public class ringdroidselectactivity 
extends listactivity 
implements loadermanager loadercallbacks cursor 
private searchview mfilter 
private simplecursoradapter madapter 
private boolean mwasgetcontentintent 
private boolean mshowall 
private cursor minternalcursor 
private cursor mexternalcursor 
result codes 
private static final request_code_edit 
private static final request_code_choose_contact 
context menu 
private static final cmd_edit 
private static final cmd_delete 
private static final cmd_set_as_default 
private static final cmd_set_as_contact 
public ringdroidselectactivity 
called when activity first created 
override 
public void oncreate bundle icicle 
super oncreate icicle 
mshowall false 
string status environment getexternalstoragestate 
status equals environment media_mounted_read_only 
showfinalalert getresources gettext string sdcard_readonly 
return 
status equals environment media_shared 
showfinalalert getresources gettext string sdcard_shared 
return 
status equals environment media_mounted 
showfinalalert getresources gettext string no_sdcard 
return 
intent intent getintent 
mwasgetcontentintent intent getaction equals 
intent action_get_content 
inflate from layout description 
setcontentview layout media_select 

madapter simplecursoradapter 
this 
template that displays text view 
layout media_select_row 
null 
from database columns 
string 
mediastore audio media artist 
mediastore audio media album 
mediastore audio media title 
mediastore audio media 
mediastore audio media 
widget layout 

row_artist 
row_album 
row_title 
row_icon 
row_options_button 
setlistadapter madapter 
getlistview setitemscanfocus true 
normal click open editor 
getlistview setonitemclicklistener onitemclicklistener 
public void onitemclick adapterview parent 
view view 
position 
long 
startringdroideditor 
minternalcursor null 
mexternalcursor null 
getloadermanager initloader internal_cursor_id null this 
getloadermanager initloader external_cursor_id null this 
catch securityexception 
permission retrieve audio 
ringdroid tostring 
todo error 
catch illegalargumentexception 
permission retrieve audio 
ringdroid tostring 
todo error 
madapter setviewbinder simplecursoradapter viewbinder 
public boolean setviewvalue view view cursor cursor columnindex 
view getid row_options_button 
arrow imageview onclicklistener open context menu 
imageview imageview view 
setonclicklistener view onclicklistener 
public void onclick view 
opencontextmenu 
return true 
else view getid row_icon 
setsoundiconfromcursor imageview view cursor 
return true 
return false 
long press opens context menu 
registerforcontextmenu getlistview 
private void setsoundiconfromcursor imageview view cursor cursor 
cursor getint cursor getcolumnindexorthrow 
mediastore audio media is_ringtone 
view setimageresource drawable type_ringtone 
view view getparent setbackgroundcolor 
getresources getcolor color type_bkgnd_ringtone 
else cursor getint cursor getcolumnindexorthrow 
mediastore audio media is_alarm 
view setimageresource drawable type_alarm 
view view getparent setbackgroundcolor 
getresources getcolor color type_bkgnd_alarm 
else cursor getint cursor getcolumnindexorthrow 
mediastore audio media is_notification 
view setimageresource drawable type_notification 
view view getparent setbackgroundcolor 
getresources getcolor color type_bkgnd_notification 
else cursor getint cursor getcolumnindexorthrow 
mediastore audio media is_music 
view setimageresource drawable type_music 
view view getparent setbackgroundcolor 
getresources getcolor color type_bkgnd_music 
string filename cursor getstring cursor getcolumnindexorthrow 
mediastore audio media data 
soundfile isfilenamesupported filename 
view view getparent setbackgroundcolor 
getresources getcolor color type_bkgnd_unsupported 
called with activity started with intent returns 
override 
protected void onactivityresult requestcode resultcode 
intent dataintent 
requestcode request_code_edit 
return 
resultcode result_ok 
return 
setresult result_ok dataintent 
finish todo nfaralli would want quit here 
override 
public boolean oncreateoptionsmenu menu menu 
menuinflater inflater getmenuinflater 
inflater inflate menu select_options menu 
mfilter searchview menu finditem action_search_filter getactionview 
mfilter null 
mfilter setonquerytextlistener searchview onquerytextlistener 
public boolean onquerytextchange string newtext 
refreshlistview 
return true 
public boolean onquerytextsubmit string query 
refreshlistview 
return true 
return true 
override 
public boolean onprepareoptionsmenu menu menu 
super onprepareoptionsmenu menu 
menu finditem action_about setvisible true 
menu finditem action_record setvisible true 
todo nfaralli really need show audio item 
menu finditem action_show_all_audio setvisible true 
menu finditem action_show_all_audio setenabled mshowall 
return true 
override 
public boolean onoptionsitemselected menuitem item 
switch item getitemid 
case action_about 
ringdroideditactivity onabout this 
return true 
case action_record 
onrecord 
return true 
case action_show_all_audio 
mshowall true 
refreshlistview 
return true 
default 
return false 
override 
public void oncreatecontextmenu contextmenu menu 
view 
contextmenuinfo menuinfo 
super oncreatecontextmenu menu menuinfo 
cursor madapter getcursor 
string title getstring getcolumnindexorthrow mediastore audio media title 
menu setheadertitle title 
menu cmd_edit string context_menu_edit 
menu cmd_delete string context_menu_delete 
items context menu item based file type 
getint getcolumnindexorthrow mediastore audio media is_ringtone 
menu cmd_set_as_default string context_menu_default_ringtone 
menu cmd_set_as_contact string context_menu_contact 
else getint getcolumnindexorthrow mediastore audio media is_notification 
menu cmd_set_as_default string context_menu_default_notification 
override 
public boolean oncontextitemselected menuitem item 
switch item getitemid 
case cmd_edit 
startringdroideditor 
return true 
case cmd_delete 
confirmdelete 
return true 
case cmd_set_as_default 
setasdefaultringtoneornotification 
return true 
case cmd_set_as_contact 
return choosecontactforringtone item 
default 
return super oncontextitemselected item 
private void setasdefaultringtoneornotification 
cursor madapter getcursor 
item ringtone then default ringtone 
otherwise notification default notification sound 
getint getcolumnindexorthrow mediastore audio media is_ringtone 
ringtonemanager setactualdefaultringtoneuri 
ringdroidselectactivity this 
ringtonemanager type_ringtone 
geturi 
toast maketext 
ringdroidselectactivity this 
string default_ringtone_success_message 
toast length_short 
show 
else 
ringtonemanager setactualdefaultringtoneuri 
ringdroidselectactivity this 
ringtonemanager type_notification 
geturi 
toast maketext 
ringdroidselectactivity this 
string default_notification_success_message 
toast length_short 
show 
private geturiindex cursor 
uriindex 
string columnnames 
mediastore audio media internal_content_uri tostring 
mediastore audio media external_content_uri tostring 
string columnname arrays aslist columnnames 
uriindex getcolumnindex columnname 
uriindex 
return uriindex 
some phones android versions column name includes double quotes 
uriindex getcolumnindex columnname 
uriindex 
return uriindex 
return 
private geturi 
item that 
cursor madapter getcursor 
uriindex geturiindex 
uriindex 
return null 
string itemuri getstring uriindex 
getstring getcolumnindexorthrow mediastore audio media 
return parse itemuri 
private boolean choosecontactforringtone menuitem item 

choose contact activity 
intent intent intent intent action_edit geturi 
intent setclassname 
ringdroid 
ringdroid choosecontactactivity 
startactivityforresult intent request_code_choose_contact 
catch exception 
ringdroid couldn open choose contact window 
return true 
private void confirmdelete 
selected list item created ringdroid 
determine which alert message show 
cursor madapter getcursor 
string artist getstring getcolumnindexorthrow 
mediastore audio media artist 
charsequence ringdroidartist 
getresources gettext string artist_name 
charsequence message 
artist equals ringdroidartist 
message getresources gettext 
string confirm_delete_ringdroid 
else 
message getresources gettext 
string confirm_delete_non_ringdroid 
charsequence title 
getint getcolumnindexorthrow 
mediastore audio media is_ringtone 
title getresources gettext string delete_ringtone 
else getint getcolumnindexorthrow 
mediastore audio media is_alarm 
title getresources gettext string delete_alarm 
else getint getcolumnindexorthrow 
mediastore audio media is_notification 
title getresources gettext string delete_notification 
else getint getcolumnindexorthrow 
mediastore audio media is_music 
title getresources gettext string delete_music 
else 
title getresources gettext string delete_audio 
alertdialog builder ringdroidselectactivity this 
settitle title 
setmessage message 
setpositivebutton 
string delete_ok_button 
dialoginterface onclicklistener 
public void onclick dialoginterface dialog 
whichbutton 
ondelete 
setnegativebutton 
string delete_cancel_button 
dialoginterface onclicklistener 
public void onclick dialoginterface dialog 
whichbutton 
setcancelable true 
show 
private void ondelete 
cursor madapter getcursor 
dataindex getcolumnindexorthrow mediastore audio media data 
string filename getstring dataindex 
uriindex geturiindex 
uriindex 
showfinalalert getresources gettext string delete_failed 
return 
file filename delete 
showfinalalert getresources gettext string delete_failed 
string itemuri getstring uriindex 
getstring getcolumnindexorthrow mediastore audio media 
getcontentresolver delete parse itemuri null null 
private void showfinalalert charsequence message 
alertdialog builder ringdroidselectactivity this 
settitle getresources gettext string alert_title_failure 
setmessage message 
setpositivebutton 
string alert_ok_button 
dialoginterface onclicklistener 
public void onclick dialoginterface dialog 
whichbutton 
finish 
setcancelable false 
show 
private void onrecord 

intent intent intent intent action_edit parse record 
intent putextra was_get_content_intent mwasgetcontentintent 
intent setclassname ringdroid ringdroid ringdroideditactivity 
startactivityforresult intent request_code_edit 
catch exception 
ringdroid couldn start editor 
private void startringdroideditor 
cursor madapter getcursor 
dataindex getcolumnindexorthrow mediastore audio media data 
string filename getstring dataindex 

intent intent intent intent action_edit parse filename 
intent putextra was_get_content_intent mwasgetcontentintent 
intent setclassname ringdroid ringdroid ringdroideditactivity 
startactivityforresult intent request_code_edit 
catch exception 
ringdroid couldn start editor 
private void refreshlistview 
minternalcursor null 
mexternalcursor null 
bundle args bundle 
args putstring filter mfilter getquery tostring 
getloadermanager restartloader internal_cursor_id args this 
getloadermanager restartloader external_cursor_id args this 
private static final string internal_columns string 
mediastore audio media 
mediastore audio media data 
mediastore audio media title 
mediastore audio media artist 
mediastore audio media album 
mediastore audio media is_ringtone 
mediastore audio media is_alarm 
mediastore audio media is_notification 
mediastore audio media is_music 
mediastore audio media internal_content_uri 
private static final string external_columns string 
mediastore audio media 
mediastore audio media data 
mediastore audio media title 
mediastore audio media artist 
mediastore audio media album 
mediastore audio media is_ringtone 
mediastore audio media is_alarm 
mediastore audio media is_notification 
mediastore audio media is_music 
mediastore audio media external_content_uri 
private static final internal_cursor_id 
private static final external_cursor_id 
implementation loadercallbacks oncreateloader 
override 
public loader cursor oncreateloader bundle args 
arraylist string selectionargslist arraylist string 
string selection 
baseuri 
string projection 
switch 
case internal_cursor_id 
baseuri mediastore audio media internal_content_uri 
projection internal_columns 
break 
case external_cursor_id 
baseuri mediastore audio media external_content_uri 
projection external_columns 
break 
default 
return null 
mshowall 
selection _data like 
selectionargslist 
else 
selection 
string extension soundfile getsupportedextensions 
selectionargslist extension 
selection length 
selection 
selection _data like 
selection 
selection selection _data like 
selectionargslist espeak data scratch 
string filter args null args getstring filter null 
filter null filter length 
filter filter 
selection 
selection 
title like artist like album like 
selectionargslist filter 
selectionargslist filter 
selectionargslist filter 
string selectionargs 
selectionargslist toarray string selectionargslist size 
return cursorloader 
this 
baseuri 
projection 
selection 
selectionargs 
mediastore audio media default_sort_order 
implementation loadercallbacks onloadfinished 
override 
public void onloadfinished loader cursor loader cursor data 
switch loader getid 
case internal_cursor_id 
minternalcursor data 
break 
case external_cursor_id 
mexternalcursor data 
break 
default 
return 
todo should mutex synchronized block here 
minternalcursor null mexternalcursor null 
cursor mergecursor mergecursor cursor minternalcursor mexternalcursor 
madapter swapcursor mergecursor 
implementation loadercallbacks onloaderreset 
override 
public void onloaderreset loader cursor loader 
this called when last cursor provided onloadfinished 
above about closed need make sure 
longer using 
madapter swapcursor null 
