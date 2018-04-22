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
import android listactivity 
import android loadermanager 
import android content contentvalues 
import android content cursorloader 
import android content intent 
import android content loader 
import android database cursor 
import android 
import android bundle 
import android provider contactscontract contacts 
import android text editable 
import android text textwatcher 
import android util 
import android view view 
import android widget adapterview 
import android widget adapterview onitemclicklistener 
import android widget simplecursoradapter 
import android widget textview 
import android widget toast 
after ringtone been saved this activity lets pick contact 
assign ringtone that contact 
public class choosecontactactivity 
extends listactivity 
implements textwatcher loadermanager loadercallbacks cursor 
private textview mfilter 
private simplecursoradapter madapter 
private mringtoneuri 
public choosecontactactivity 
called when activity first created 
override 
public void oncreate bundle icicle 
super oncreate icicle 
settitle string choose_contact_title 
intent intent getintent 
mringtoneuri intent getdata 
inflate from layout description 
setcontentview layout choose_contact 

madapter simplecursoradapter 
this 
template that displays text view 
layout contact_row 
empty cursor right will onloadfinished 
null 
from database columns 
string 
contacts custom_ringtone 
contacts starred 
contacts display_name 
widget layout 

row_ringtone 
row_starred 
row_display_name 
madapter setviewbinder simplecursoradapter viewbinder 
public boolean setviewvalue view view 
cursor cursor 
columnindex 
string name cursor getcolumnname columnindex 
string value cursor getstring columnindex 
name equals contacts custom_ringtone 
value null value length 
view setvisibility view visible 
else 
view setvisibility view invisible 
return true 
name equals contacts starred 
value null value equals 
view setvisibility view visible 
else 
view setvisibility view invisible 
return true 
return false 
setlistadapter madapter 
click assign ringtone contact 
getlistview setonitemclicklistener 
onitemclicklistener 
public void onitemclick adapterview parent 
view view 
position 
long 
assignringtonetocontact 
getloadermanager initloader null this 
catch securityexception 
permission retrieve contacts 
ringdroid tostring 
mfilter textview findviewbyid search_filter 
mfilter null 
mfilter addtextchangedlistener this 
private void assignringtonetocontact 
cursor madapter getcursor 
dataindex getcolumnindexorthrow contacts 
string contactid getstring dataindex 
dataindex getcolumnindexorthrow contacts display_name 
string displayname getstring dataindex 
withappendedpath contacts content_uri contactid 
contentvalues values contentvalues 
values contacts custom_ringtone mringtoneuri tostring 
getcontentresolver update values null null 
string message 
getresources gettext string success_contact_ringtone 

displayname 
toast maketext this message toast length_short 
show 
finish 
return 
implementation textwatcher beforetextchanged 
public void beforetextchanged charsequence start count after 
implementation textwatcher ontextchanged 
public void ontextchanged charsequence start before count 
implementation textwatcher aftertextchanged 
public void aftertextchanged editable 
string filterstr mfilter gettext tostring 
madapter changecursor createcursor filterstr 
bundle args bundle 
args putstring filter mfilter gettext tostring 
getloadermanager restartloader args this 
implementation loadercallbacks oncreateloader 
override 
public loader cursor oncreateloader bundle args 
string selection null 
string filter args null args getstring filter null 
filter null filter length 
selection display_name like filter 
return cursorloader 
this 
contacts content_uri 
string 
contacts 
contacts custom_ringtone 
contacts display_name 
contacts last_time_contacted 
contacts starred 
contacts times_contacted 
selection 
null 
starred desc 
times_contacted desc 
last_time_contacted desc 
display_name 
implementation loadercallbacks onloadfinished 
override 
public void onloadfinished loader cursor loader cursor data 
ringdroid data getcount contacts 
madapter swapcursor data 
implementation loadercallbacks onloaderreset 
override 
public void onloaderreset loader cursor loader 
this called when last cursor provided onloadfinished 
above about closed need make sure 
longer using 
madapter swapcursor null 
