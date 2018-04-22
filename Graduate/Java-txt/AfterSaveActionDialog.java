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
import android dialog 
import android content context 
import android message 
import android view view 
import android widget button 
public class aftersaveactiondialog extends dialog 
private message mresponse 
public aftersaveactiondialog context context message response 
super context 
inflate from layout description 
setcontentview layout after_save_action 
settitle string alert_title_success 
button findviewbyid button_make_default 
setonclicklistener view onclicklistener 
public void onclick view view 
closeandsendresult button_make_default 
button findviewbyid button_choose_contact 
setonclicklistener view onclicklistener 
public void onclick view view 
closeandsendresult button_choose_contact 
button findviewbyid button_do_nothing 
setonclicklistener view onclicklistener 
public void onclick view view 
closeandsendresult button_do_nothing 
mresponse response 
private void closeandsendresult clickedbuttonid 
mresponse clickedbuttonid 
mresponse sendtotarget 
dismiss 
