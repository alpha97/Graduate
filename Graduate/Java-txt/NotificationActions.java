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

package achep acdisplay widgets notification 
import android content context 
import android graphics colorfilter 
import android graphics colormatrixcolorfilter 
import android graphics typeface 
import android graphics drawable drawable 
import android support annotation layoutres 
import android support annotation nonnull 
import android support annotation nullable 
import android support remoteinput 
import android text editable 
import android text textutils 
import android text textwatcher 
import android transition transitionmanager 
import android util attributeset 
import android view layoutinflater 
import android view view 
import android view viewgroup 
import android widget arrayadapter 
import android widget edittext 
import android widget linearlayout 
import android widget spinner 
import android widget textview 
import achep acdisplay 
import achep acdisplay notifications action 
import achep acdisplay notifications notificationutils 
import achep acdisplay notifications opennotification 
import achep base device 
import achep base tests check 
import java util hashmap 
author artem chepurnoy 
since 
public class notificationactions extends linearlayout 
public interface callback 
void onriistatechanged nonnull notificationactions boolean shown 
called action button click 
void onactionclick nonnull notificationactions 
nonnull view view nonnull action action 
called action button click 
param remoteinput chosen link android support remoteinput reply 
param text text quick reply 
void onactionclick nonnull notificationactions 
nonnull view view nonnull action action 
nonnull remoteinput remoteinput 
nonnull charsequence text 
disables link mview current action view text 
link android text textutils isempty charsequence empty 
protected final textable ontextchangedlistener montextchangedlistener 
textable ontextchangedlistener 
override 
public void ontextchanged nullable charsequence text 
assert mview null 
mview setenabled textutils isempty text 
private final hashmap action remoteinput mremoteinputsmap hashmap 
private final hashmap view action mactionsmap hashmap 
private final onclicklistener mactionsonclick onclicklistener 
override 
public void onclick view 
action action mactionsmap 
assert action null 
onactionclick action 
private final onlongclicklistener mactionsonlongclick onlongclicklistener 
override 
public boolean onlongclick view 
sendaction mactionsmap 
hiderii 
return true 
know what 
nullable 
private callback mcallback 
nullable 
private remoteinput mremoteinput 
nullable 
private textable mtextable 
nullable 
private view mview 
private linearlayout layoutparams mlayoutparams 
private typeface mtypeface 
public notificationactions context context attributeset attrs 
super context attrs 
public void setcallback nullable callback callback 
mcallback callback 
protected void onactionclick nonnull view view nonnull action action 
isriishowing 
mview view 
ignore this click this happen because 
animation delays 
return 
send callback with performed remote input 
assert mremoteinput null 
assert mtextable null 
charsequence text mtextable gettext 
check getinstance isfalse textutils isempty text 
assert text null 
sendactionwithremoteinput view action mremoteinput text 
hiderii 
else mremoteinput mremoteinputsmap action null 
initialize show remote input graphic 
user interface 
mview view 
mtextable oncreatetextable mremoteinput 
montextchangedlistener ontextchanged mtextable gettext 
device haskitkatapi islaidout 
transitionmanager begindelayedtransition this 
mlayoutparams layoutparams mview getlayoutparams 
layoutparams layoutparams 
viewgroup layoutparams wrap_content 
viewgroup layoutparams match_parent 
mview setlayoutparams 
hide other actions 
getchildcount 
view getchildat 
mview setvisibility gone 
textable view 
addview mtextable getview 
mtextable getview requestfocus 
mcallback null mcallback onriistatechanged this true 
else 
sendaction view action 
private void sendaction nonnull view view nonnull action action 
mcallback null mcallback onactionclick this view action 
private void sendactionwithremoteinput nonnull view view nonnull action action 
nonnull remoteinput remoteinput 
nonnull charsequence text 
mcallback null mcallback onactionclick this view action remoteinput text 
returns appropriate link notificationactions textable this 
link android support remoteinput remote input 
android support remoteinput getallowfreeforminput 
nonnull 
protected textable oncreatetextable nonnull remoteinput remoteinput 
return remoteinput getallowfreeforminput 
textablefreeform this remoteinput montextchangedlistener 
textablerestrictedform this remoteinput montextchangedlistener 
public void hiderii 
check getinstance isinmainthread 
isriishowing return 
assert mtextable null 
assert mview null 
removeview mtextable getview 
mview setlayoutparams mlayoutparams 
other actions back 
getchildcount 
view getchildat 
mview setvisibility visible 
mview null 
mtextable null 
mremoteinput null 
mlayoutparams null 
mcallback null mcallback onriistatechanged this false 
public boolean isriishowing 
return mremoteinput null 
sets actions 
param notification host notification 
param actions actions 
public void setactions nullable opennotification notification nullable action actions 
check getinstance isinmainthread 
mremoteinputsmap clear 
mactionsmap clear 
hiderii 
actions null 
free actions container 
removeallviews 
return 
else 
assert notification null 
count actions length 
view views view count 
find available views 
childcount getchildcount 
math childcount count 

views getchildat 
remove redundant views 
childcount count 
removeviewat 
layoutinflater inflater null 
count 
final action action actions 
view root views 
root null 
initialize layout inflater only when really need 
inflater null 
inflater layoutinflater getcontext 
getsystemservice context layout_inflater_service 
assert inflater null 
root inflater inflate getactionlayoutresource this false 
root oncreateactionview root 
need keep unique make 
transitionmanager begindelayedtransition viewgroup null 
work correctly 
root setid getchildcount 
addview root 
mactionsmap root action 
style typeface normal 
root setonlongclicklistener null 
action intent null 
root setenabled true 
root setonclicklistener mactionsonclick 
remoteinput remoteinput getremoteinput action 
remoteinput null 
mremoteinputsmap action remoteinput 
root setonlongclicklistener mactionsonlongclick 
highlight action 
style typeface italic 
else 
root setenabled false 
root setonclicklistener null 
message view apply content 
textview textview root instanceof textview 
textview root 
textview root findviewbyid android title 
textview settext action title 
mtypeface null mtypeface textview gettypeface 
textview settypeface mtypeface style 
drawable icon notificationutils getdrawable getcontext notification action icon 
icon null icon oncreateactionicon icon 
device hasjellybeanmr 
textview setcompounddrawablesrelative icon null null null 
else 
textview setcompounddrawables icon null null null 
nonnull 
protected view oncreateactionview nonnull view view 
return view 
nullable 
protected drawable oncreateactionicon nonnull drawable icon 
size getresources getdimensionpixelsize dimen notification_action_icon_size 
icon icon mutate 
icon setbounds size size 
matrix stored single array treated follows 

when applied color resulting color computed after clamping 




colorfilter colorfilter colormatrixcolorfilter float 

green 
blue 
alpha 
icon setcolorfilter colorfilter force white color 
return icon 
nullable 
fixme which remoteinput should 
protected remoteinput getremoteinput nonnull action action 
return null 
action remoteinputs null action remoteinputs length return null 
remoteinput action remoteinputs 
getallowfreeforminput 
return 
return null 
layoutres 
protected getactionlayoutresource 
return layout notification_action 
textable 
base class link android support remoteinput view fields example 
should provide dropdown only 
link android support remoteinput getallowfreeforminput code false 
free text form otherwise 
author artem chepurnoy 
android support remoteinput 
since 
private static abstract class textable 
public interface ontextchangedlistener 
called link gettext text changed 
void ontextchanged nullable charsequence text 
nonnull 
protected final context mcontext 
nonnull 
protected final remoteinput mremoteinput 
nonnull 
protected final notificationactions mcontainer 
nonnull 
protected final ontextchangedlistener mlistener 
public textable nonnull notificationactions container 
nonnull remoteinput remoteinput 
nonnull ontextchangedlistener listener 
mcontainer container 
mremoteinput remoteinput 
mlistener listener 
mcontext container getcontext 
return view this code textable 
nonnull 
public abstract view getview 
return text code textable displaying 
nullable 
public abstract charsequence gettext 
inflates view hierarchy from specified resource view root 
link mcontainer 
return root view inflated hierarchy 
nonnull 
protected final view inflate layoutres layoutres 
layoutinflater inflater layoutinflater mcontext 
getsystemservice context layout_inflater_service 
return inflater inflate layoutres mcontainer false 
author artem chepurnoy 
since 
protected static class textablefreeform extends textable 
private edittext medittext 
private final textwatcher mtextwatcher textwatcher 
override 
public void beforetextchanged charsequence start count after unused 
override 
public void ontextchanged charsequence start before count 
mlistener ontextchanged 
override 
public void aftertextchanged editable unused 
public textablefreeform nonnull notificationactions container 
nonnull remoteinput remoteinput 
nonnull ontextchangedlistener listener 
super container remoteinput listener 
medittext oncreateedittext 
medittext sethint remoteinput getlabel 
medittext addtextchangedlistener mtextwatcher 
inheritdoc 
nonnull 
override 
public view getview 
return medittext 
inheritdoc 
nullable 
override 
public charsequence gettext 
return medittext gettext 
nonnull 
protected edittext oncreateedittext 
return edittext inflate layout notification_reply_free_form 
author artem chepurnoy 
since 
protected static class textablerestrictedform extends textable 
private final spinner mspinner 
public textablerestrictedform nonnull notificationactions container 
nonnull remoteinput remoteinput 
nonnull ontextchangedlistener listener 
super container remoteinput listener 
arrayadapter charsequence adapter arrayadapter 
mcontext android layout simple_spinner_dropdown_item 
remoteinput getchoices 
mspinner oncreatespinner 
mspinner setadapter adapter 
inheritdoc 
nonnull 
override 
public view getview 
return mspinner 
inheritdoc 
nullable 
override 
public charsequence gettext 
mspinner getselecteditemposition 
return mremoteinput getchoices 
nonnull 
protected spinner oncreatespinner 
return spinner inflate layout notification_reply_restricted_form 
