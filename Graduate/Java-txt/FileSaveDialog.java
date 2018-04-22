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
import java util arraylist 
import android dialog 
import android content context 
import android content resources 
import android message 
import android view view 
import android widget adapterview 
import android widget adapterview onitemselectedlistener 
import android widget arrayadapter 
import android widget button 
import android widget edittext 
import android widget spinner 
public class filesavedialog extends dialog 
file kinds these should correspond order which 
they presented spinner control 
public static final file_kind_music 
public static final file_kind_alarm 
public static final file_kind_notification 
public static final file_kind_ringtone 
private spinner mtypespinner 
private edittext mfilename 
private message mresponse 
private string moriginalname 
private arraylist string mtypearray 
private mpreviousselection 
return human readable name kind music alarm ringtone 
these displayed screen just logs they shouldn 
translated 
public static string kindtoname kind 
switch kind 
default 
return unknown 
case file_kind_music 
return music 
case file_kind_alarm 
return alarm 
case file_kind_notification 
return notification 
case file_kind_ringtone 
return ringtone 
public filesavedialog context context 
resources resources 
string originalname 
message response 
super context 
inflate from layout description 
setcontentview layout file_save 
settitle resources getstring string file_save_title 
mtypearray arraylist string 
mtypearray resources getstring string type_music 
mtypearray resources getstring string type_alarm 
mtypearray resources getstring string type_notification 
mtypearray resources getstring string type_ringtone 
mfilename edittext findviewbyid filename 
moriginalname originalname 
arrayadapter string adapter arrayadapter string 
context android layout simple_spinner_item mtypearray 
adapter setdropdownviewresource 
android layout simple_spinner_dropdown_item 
mtypespinner spinner findviewbyid ringtone_type 
mtypespinner setadapter adapter 
mtypespinner setselection file_kind_ringtone 
mpreviousselection file_kind_ringtone 
setfilenameeditboxfromname false 
mtypespinner setonitemselectedlistener onitemselectedlistener 
public void onitemselected adapterview parent 
view 
position 
long 
setfilenameeditboxfromname true 
public void onnothingselected adapterview parent 
button save button findviewbyid save 
save setonclicklistener savelistener 
button cancel button findviewbyid cancel 
cancel setonclicklistener cancellistener 
mresponse response 
private void setfilenameeditboxfromname boolean onlyifnotedited 
onlyifnotedited 
charsequence currenttext mfilename gettext 
string expectedtext moriginalname 
mtypearray mpreviousselection 
expectedtext contentequals currenttext 
return 
newselection mtypespinner getselecteditemposition 
string newsuffix mtypearray newselection 
mfilename settext moriginalname newsuffix 
mpreviousselection mtypespinner getselecteditemposition 
private view onclicklistener savelistener view onclicklistener 
public void onclick view view 
mresponse mfilename gettext 
mresponse mtypespinner getselecteditemposition 
mresponse sendtotarget 
dismiss 
private view onclicklistener cancellistener view onclicklistener 
public void onclick view view 
dismiss 
