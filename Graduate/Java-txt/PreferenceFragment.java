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

package achep base fragments 
import android content context 
import android bundle 
import android preference listpreference 
import android preference multiselectlistpreference 
import android preference preference 
import android preference preferencescreen 
import android preference twostatepreference 
import android support annotation nonnull 
import android support annotation nullable 
import android support annotation stringres 
import android util 
import android view view 
import android view viewstub 
import achep acdisplay 
import achep base content configbase 
import achep base interfaces icheckable 
import achep base permissions permission 
import achep base switchbarpermissible 
import achep base activities activitybase 
import achep base preferences enabler 
import achep base widgets switchbar 
import achep base utils operator 
import achep base utils resutils 
import java util collections 
import java util hashset 
import java util 
import static achep base build debug 
public abstract class preferencefragment extends preferencefragmentbase 
private static final string preferencefragment 
private switchbar mswitch 
private switchbarpermissible mswitchpermissible 
private permission menablerpermissions 
private string menablerkey 
private enabler menabler 
private configbase mconfig 
private configbase syncer msyncer 
private twostatepreferencesetter mtwostatepreferencesetter 
public abstract configbase getconfig 
requests fragment setup master switch from 
corresponding 
param link achep base content configbase options 
achep base content configbase 
achep base preferences enabler 
public void requestmasterswitch nonnull string 
requestmasterswitch null 
public void requestmasterswitch nonnull string nullable permission permissions 
menablerkey 
menablerpermissions permissions 
override 
public void onattach context context 
super onattach context 
mconfig getconfig 
msyncer configbase syncer context mconfig 
override 
public void onviewcreated view view nullable bundle savedinstancestate 
super onviewcreated view savedinstancestate 
menablerkey null 
debug creating enabler menablerkey 
setup enabler switch 
menabler enabler getactivity mconfig menablerkey createpermissionswitch 
nonnull 
private icheckable createpermissionswitch 
activitybase activity activitybase getactivity 
switchbar switchbar getswitchbar 
assert switchbar null 
mswitchpermissible switchbarpermissible activity switchbar menablerpermissions 
return mswitchpermissible 
override 
public void onresume 
super onresume 
menabler null 
mswitchpermissible resume 
menabler start 
msyncer start 
override 
public void onpause 
super onpause 
menabler null 
menabler stop 
mswitchpermissible pause 
msyncer stop 
synchronizes simple checkbox preference with config 
param preference config parameter 
achep acdisplay config getmap 
protected void syncpreference nonnull string 
mtwostatepreferencesetter null 
mtwostatepreferencesetter twostatepreferencesetter 
syncpreference mtwostatepreferencesetter 
synchronizes preference with config 
param preference config parameter 
param setter preference setter 
achep acdisplay config getmap 
listpreferencesetter 
twostatepreferencesetter 
protected void syncpreference nonnull string nonnull configbase syncer setter setter 
preference preference findpreference 
preferencescreen preferencescreen getpreferencescreen 
preference null 
debug tried sync existent preference with config 
return 
msyncer syncpreference preferencescreen preference setter 
nullable 
public switchbar getswitchbar 
mswitch null 
getview null 
return null 
viewstub stub viewstub getview findviewbyid switch_bar_stub 
mswitch switchbar stub inflate findviewbyid switch_bar 
return mswitch 
setter link twostatepreference 
author artem chepurnoy 
protected static class twostatepreferencesetter implements configbase syncer setter 
inheritdoc 
override 
public final void updatesummary nonnull preference preference 
nonnull configbase option option 
nonnull object value 
this unneeded because should always 
android summaryon 
android summaryoff 
attributes 
inheritdoc 
override 
public void setvalue nonnull preference preference 
nonnull configbase option option 
nonnull object value 
twostatepreference twostatepreference preference 
setchecked boolean value 
inheritdoc 
nonnull 
override 
public object getvalue nonnull object value 
return value 
setter link listpreference 
author artem chepurnoy 
protected static class listpreferencesetter implements configbase syncer setter 
inheritdoc 
override 
public void updatesummary nonnull preference preference 
nonnull configbase option option 
nonnull object value unused 
inheritdoc 
override 
public void setvalue nonnull preference preference 
nonnull configbase option option 
nonnull object value 
listpreference listpreference preference 
setvalue integer tostring integer value 
inheritdoc 
nonnull 
override 
public object getvalue nonnull object value 
return integer parseint string value 
setter link multiselectlistpreference work currently 
data must mask selectable item format 
author artem chepurnoy 
protected static class multiselectlistpreferencesetter implements configbase syncer setter 
nonnull 
private final context mcontext 
private final mstrressummary 
private final mstrresdisabled 
public multiselectlistpreferencesetter nonnull context context 
stringres summarystrres 
stringres disabledstrres 
mcontext context 
mstrressummary summarystrres 
mstrresdisabled disabledstrres 
inheritdoc 
override 
public void updatesummary nonnull preference preference 
nonnull configbase option option 
nonnull object value 
multiselectlistpreference mslp multiselectlistpreference preference 
mode value 
charsequence summary 
mode 
charsequence entries mslp getentries 
charsequence values mslp getentryvalues 
string divider mcontext getstring string settings_multi_list_divider 
stringbuilder stringbuilder 
boolean empty true 
assert entries null 
assert values null 
append selected items 
values length 
integer parseint values tostring 
operator bitand mode 
empty 
append divider 
append entries 
empty false 
string itemstext tostring tolowercase 
summary mstrressummary 
resutils getstring mcontext mstrressummary itemstext 
charat itemstext substring itemstext length 
else 
summary mcontext getstring mstrresdisabled 
mslp setsummary summary 
inheritdoc 
override 
public void setvalue nonnull preference preference 
nonnull configbase option option 
nonnull object value 
mode value 
string values string integer bitcount mode 
values length 
operator bitand mode 
values integer tostring 
string valuesset hashset 
collections addall valuesset values 
multiselectlistpreference mslp multiselectlistpreference preference 
mslp setvalues valuesset 
inheritdoc 
nonnull 
override 
public object getvalue nonnull object value 
mode 
string values string value 
string values 
mode integer parseint 
return mode 
