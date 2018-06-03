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

package achep acdisplay activities settings 
import android activity 
import android content componentname 
import android content context 
import android content intent 
import android content sharedpreferences 
import android content activityinfo 
import android content applicationinfo 
import android content packagemanager 
import android content packagemanager namenotfoundexception 
import android content resources 
import android graphics drawable drawable 
import android asynctask 
import android bundle 
import android systemclock 
import android preference preference 
import android preference preferenceactivity 
import android preference preferencefragment 
import android support annotation nonnull 
import android text textutils 
import android util 
import android view layoutinflater 
import android view menu 
import android view menuitem 
import android view view 
import android view view onclicklistener 
import android view viewgroup 
import android widget arrayadapter 
import android widget imageview 
import android widget listadapter 
import android widget textview 
import achep acdisplay 
import achep acdisplay blacklist appconfig 
import achep acdisplay blacklist blacklist 
import achep acdisplay fragments blacklistappfragment 
import achep base utils mathutils 
import achep base utils resutils 
import java lang reflect method 
import java util collections 
import java util comparator 
import java util hashmap 
import java util list 
import java util locale 
import java util concurrent concurrenthashmap 
level settings activity handle single pane double pane layout 
public class blacklistactivity extends preferenceactivity 
private static final string blacklistactivity 
meta data 
private static final string meta_data_key_header_id 
achep acdisplay blacklist top_level_header_id 
private static final string meta_data_key_fragment_class 
achep acdisplay blacklist fragment_class 
private static final string meta_data_key_parent_title 
achep acdisplay blacklist parent_fragment_title 
private static final string meta_data_key_parent_fragment_class 
achep acdisplay blacklist parent_fragment_class 
save state 
private static final string save_key_current_header 
achep acdisplay blacklist current_header 
private static final string save_key_parent_header 
achep acdisplay blacklist parent_header 
preferences 
private static final string pref_key_show_system_apps show_system_apps 
private string mfragmentclass 
private mtoplevelheaderid 
private header mfirstheader 
private header mcurrentheader 
private header mparentheader 
private boolean minlocalheaderswitch 
protected hashmap integer integer mheaderindexmap hashmap 
private sharedpreferences mpreferences 
override 
protected void oncreate bundle savedinstancestate 
mpreferences getsharedpreferences blacklist pref_name activity mode_private 
getmetadata 
minlocalheaderswitch true 
super oncreate savedinstancestate 
minlocalheaderswitch false 
onishidingheaders onismultipane 
highlightheader mtoplevelheaderid 
force title that doesn overridden direct launch 
specific settings screen 
settitle string settings 
retrieve saved state 
savedinstancestate null 
mcurrentheader savedinstancestate getparcelable save_key_current_header 
mparentheader savedinstancestate getparcelable save_key_parent_header 
current header saved switch 
savedinstancestate null mcurrentheader null 
switchtoheaderlocal mcurrentheader 
showbreadcrumbs mcurrentheader title null 
mparentheader null 
setparenttitle mparentheader title null onclicklistener 
override 
public void onclick view 
switchtoparent mparentheader fragment 
override navigation multi pane since handle fragment breadcrumbs 
onismultipane 
getactionbar setdisplayhomeasupenabled false 
getactionbar sethomebuttonenabled false 
override 
protected void onsaveinstancestate nonnull bundle outstate 
super onsaveinstancestate outstate 
save current fragment same originally launched 
mcurrentheader null 
outstate putparcelable save_key_current_header mcurrentheader 
mparentheader null 
outstate putparcelable save_key_parent_header mparentheader 
override 
public void onresume 
super onresume 
invalidateheaders 
override 
public boolean oncreateoptionsmenu menu menu 
getmenuinflater inflate menu blacklist menu 
menu finditem show_system_apps setchecked shouldshowsystemapps 
return true 
override 
public boolean onoptionsitemselected menuitem item 
switch item getitemid 
case show_system_apps 
item setchecked item ischecked 
mpreferences 
edit 
putboolean pref_key_show_system_apps item ischecked 
apply 
invalidateheaders 
break 
default 
return super onoptionsitemselected item 
return true 
private boolean shouldshowsystemapps 
return mpreferences getboolean pref_key_show_system_apps false 
private void updateicons 
listadapter listadapter getlistadapter 
listadapter instanceof headeradapter 
headeradapter listadapter loadicons 
fills header list with list installed apps 
private void buildheaderlist list header headers boolean showsystemapps 
string fragmentname blacklistappfragment class getcanonicalname 

packagemanager getpackagemanager 
list applicationinfo packages getinstalledapplications packagemanager get_meta_data 
applicationinfo packages 
systemflag applicationinfo flag_system applicationinfo flag_updated_system_app 
system mathutils bool flags systemflag 
system showsystemapps 
continue 
header header header 
header fragment fragmentname 
header title loadlabel todo this huge operation 
header summary packagename 
header system store system 
package name fragment 
bundle args bundle 
args putstring blacklistappfragment args_package_name packagename 
header fragmentarguments args 
headers header 
sort name 
collections sort headers comparator header 
override 
public compare header header header header 
string title header title tostring 
string title header title tostring 
return title comparetoignorecase title 
override 
protected boolean isvalidfragment string fragmentname 
return true 
private void switchtoheaderlocal header header 
minlocalheaderswitch true 
switchtoheader header 
minlocalheaderswitch false 
override 
public void switchtoheader nonnull header header 
minlocalheaderswitch 
mcurrentheader null 
mparentheader null 
super switchtoheader header 
switch parent fragment store grand parent info 
param classname name activity wrapper parent fragment 
private void switchtoparent string classname 
final componentname componentname this classname 

final packagemanager getpackagemanager 
final activityinfo parentinfo getactivityinfo packagemanager get_meta_data 
parentinfo null parentinfo metadata null 
string fragmentclass parentinfo metadata getstring meta_data_key_fragment_class 
charsequence fragmenttitle parentinfo loadlabel 
header parentheader header 
parentheader fragment fragmentclass 
parentheader title fragmenttitle 
mcurrentheader parentheader 
switchtoheaderlocal parentheader 
highlightheader mtoplevelheaderid 
mparentheader header 
mparentheader fragment 
parentinfo metadata getstring meta_data_key_parent_fragment_class 
mparentheader title parentinfo metadata getstring meta_data_key_parent_title 
catch namenotfoundexception nnfe 
could find parent activity classname 
override 
public void onnewintent intent intent 
super onnewintent intent 
launched from history then reset level 
intent getflags intent flag_activity_launched_from_history 
mfirstheader null onishidingheaders onismultipane 
switchtoheaderlocal mfirstheader 
getlistview setselectionfromtop 
private void highlightheader 

integer index mheaderindexmap 
index null 
getlistview setitemchecked index true 
ismultipane 
getlistview smoothscrolltoposition index 
override 
public intent getintent 
intent superintent super getintent 
string startingfragment getstartingfragmentclass superintent 
this called from super oncreate ismultipane reliable 
onishidingheaders either which relies itself this method 
startingfragment null onismultipane 
intent modintent intent superintent 
modintent putextra extra_show_fragment startingfragment 
bundle args superintent getextras 
args null 
args bundle args 
else 
args bundle 
args putparcelable intent superintent 
modintent putextra extra_show_fragment_arguments superintent getextras 
return modintent 
return superintent 
checks component name intent different from settings class 
returns class name load fragment 
protected string getstartingfragmentclass intent intent 
mfragmentclass null return mfragmentclass 
string intentclass intent getcomponent getclassname 
intentclass equals getclass getname return null 
return intentclass 
override initial header when activity alias causing settings launched 
specific fragment encoded android name parameter 
override 
public header ongetinitialheader 
string fragmentclass getstartingfragmentclass super getintent 
fragmentclass null 
header header header 
header fragment fragmentclass 
header title gettitle 
header fragmentarguments getintent getextras 
mcurrentheader header 
return header 
return mfirstheader 
override 
public intent onbuildstartfragmentintent string fragmentname bundle args 
titleres shorttitleres 
return super 
onbuildstartfragmentintent fragmentname args titleres shorttitleres 
setclass this subblacklistactivity class 
populate activity with level headers 
override 
public void onbuildheaders list header headers 
onishidingheaders 
buildheaderlist headers shouldshowsystemapps 
updateheaderlist headers 
updateicons 
private void updateheaderlist list header target 

mheaderindexmap clear 
while target size 
header header target 
integers downcasting 
header 
increment current wasn removed utils code 
target size target header 
hold first header when need reset level 
headertype headeradapter getheadertype header 
mfirstheader null 
headertype headeradapter header_type_category 
mfirstheader header 
mheaderindexmap 
private void getmetadata 

activityinfo getpackagemanager getactivityinfo getcomponentname 
packagemanager get_meta_data 
null metadata null return 
mtoplevelheaderid metadata getint meta_data_key_header_id 
mfragmentclass metadata getstring meta_data_key_fragment_class 
check parent specified create header object 
final parentheadertitleres metadata getint meta_data_key_parent_title 
string parentfragmentclass metadata getstring meta_data_key_parent_fragment_class 
parentfragmentclass null 
mparentheader header 
mparentheader fragment parentfragmentclass 
parentheadertitleres 
mparentheader title getresources getstring parentheadertitleres 
catch namenotfoundexception 
recovery 
private static class headeradapter extends arrayadapter header 
static final header_type_category 
static final header_type_normal 
private static final header_type_count 
private final context mcontext 
private final layoutinflater minflater 
private final packagemanager mpackagemanager 
private final drawable mdefaultimg 
private final list header mheaders 
private loadiconstask mloadiconstask 
private final concurrenthashmap string drawable micons 
static getheadertype header header 
header fragment null header intent null 
return header_type_category 
else 
return header_type_normal 
override 
public getitemviewtype position 
header header getitem position 
return getheadertype header 
override 
public boolean areallitemsenabled 
return false because categories 
override 
public boolean isenabled position 
return getitemviewtype position header_type_category 
override 
public getviewtypecount 
return header_type_count 
override 
public boolean hasstableids 
return true 
public headeradapter context context list header headers 
super context headers 
mcontext context 
minflater layoutinflater context getsystemservice context layout_inflater_service 
mpackagemanager context getpackagemanager 
mheaders headers 
default icon till actual icon loaded async task 
noinspection resourcetype 
mdefaultimg resutils getdrawable context android mipmap sym_def_app_icon 
micons concurrenthashmap 
loadicons 
private static class holder 
imageview icon 
textview title 
textview summary 
override 
public view getview position view convertview viewgroup parent 
final holder holder 
final header header getitem position 
final headertype getheadertype header 
view view null 
convertview null 
holder holder 
switch headertype 
case header_type_category 
view textview getcontext null 
android attr listseparatortextviewstyle 
holder title textview view 
break 
case header_type_normal 
view minflater inflate 
layout preference_header_item parent 
false 
holder icon imageview view findviewbyid icon 
holder title textview view findviewbyid android title 
holder summary textview view findviewbyid android summary 
break 
view settag holder 
else 
view convertview 
holder holder view gettag 
resources mcontext getresources 
view fields must updated every time because view recycled 
switch headertype 
case header_type_category 
holder title settext header gettitle getcontext getresources 
break 
case header_type_normal 
string packagename header summary 
appconfig config blacklist getinstance getappconfig packagename 
show checked options summary 
todo find optimize 
config ishidden config isrestricted config isnonclearableenabled 
stringbuilder stringbuilder 
boolean empty true 
pairs 
hidden 
mathutils bool config ishidden 
string blacklist_app_hide_title 
restricted 
mathutils bool config isrestricted 
string blacklist_app_restricted_title 
clearable 
mathutils bool config isnonclearableenabled 
string blacklist_app_non_clearable_title 
append checked options 
string divider getstring string settings_multi_list_divider 
pairs length 
pairs 

empty 
append divider 
append getstring pairs 
empty false 
string summary tostring 
textutils isempty summary 
keep only first letter with upper case 
force other lower case 
summary summary charat 
summary substring tolowercase locale getdefault 
holder summary setvisibility view visible 
holder summary settext summary 
else 
holder summary setvisibility view gone 
else 
holder summary setvisibility view gone 
drawable icon micons packagename 
holder icon setimagedrawable icon null icon mdefaultimg 
holder title settext header title null header title packagename 
break 
return view 
update list apps icons 
public void loadicons 
mloadiconstask null mloadiconstask getstatus 
equals asynctask status finished 
mloadiconstask cancel true 
mloadiconstask cancel false 
mloadiconstask loadiconstask 
mloadiconstask execute mheaders toarray header mheaders size 
asynchronous task load icons titles installed applications 
todo maybe softreference save some memory 
private class loadiconstask extends asynctask header void void 
private volatile long time 
private volatile boolean cancel 
override 
protected void doinbackground header headers 
header header headers 

cancel return null 
string packagename header summary 
micons containskey packagename 
continue 
applicationinfo mpackagemanager getapplicationinfo packagename 
drawable icon mpackagemanager getapplicationicon packagename 
micons packagename icon 
long systemclock uptimemillis 
time 
publishprogress 
time 
catch namenotfoundexception 
ignored will show with default image title 
return null 
override 
protected void onprogressupdate void progress 
notifydatasetchanged 
override 
protected void onpostexecute void avoid 
super onpostexecute avoid 
notifydatasetchanged 
override 
public boolean onpreferencestartfragment preferencefragment caller nonnull preference pref 
startpreferencepanel 
pref getfragment 
pref getextras 
pref gettitleres 
pref gettitle null 
return true 
override 
public boolean shoulduprecreatetask nonnull intent targetintent 
return super shoulduprecreatetask intent this blacklistactivity class 
override 
public void setlistadapter listadapter adapter 
adapter null 
super setlistadapter null 
else 
list header headers null 

method method preferenceactivity class getdeclaredmethod getheaders 
method setaccessible true 
headers list header method invoke this 
catch exception 
printstacktrace 
super setlistadapter headeradapter this headers 
