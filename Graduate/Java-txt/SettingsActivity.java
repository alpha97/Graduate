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

package achep base activities 
import android content componentname 
import android content context 
import android content intent 
import android content activityinfo 
import android content packagemanager 
import android content packagemanager namenotfoundexception 
import android content xmlresourceparser 
import android bundle 
import android preference preference 
import android preference preferencefragment 
import android support annotation nonnull 
import android support annotation xmlres 
import android support fragment 
import android support fragmentmanager 
import android support fragmenttransaction 
import android support actionbar 
import android transition transitionmanager 
import android util attributeset 
import android util 
import android util 
import android view viewgroup 
import achep acdisplay 
import achep acdisplay activities settings settings 
import achep base device 
import achep base dashboard dashboardcategory 
import achep base dashboard dashboardtile 
import achep base fragments dashboardfragment 
import achep base utils xmlutils 
import xmlpull xmlpullparser 
import xmlpull xmlpullparserexception 
import java ioexception 
import java util arraylist 
import java util list 
import java util 
public abstract class settingsactivity extends activitybase implements 
preferencefragment onpreferencestartfragmentcallback 
fragmentmanager onbackstackchangedlistener 
private static final string log_tag settings 
constants loading dashboard from resource 
private static final string resource_tag_dashboard dashboard 
private static final string resource_tag_dashboard_category dashboard category 
private static final string resource_tag_dashboard_tile dashboard tile 
private static final string resource_tag_dashboard_tile_extra extra 
private static final string resource_tag_dashboard_tile_intent intent 
constants state save restore 
private static final string save_key_categories settings categories 
private static final string save_key_show_home_as_up settings show_home_as_up 
when starting this activity invoking intent contain this extra 
string specify which fragment should initially displayed 
starting from lime when this argument passed activity 
will call isvalidfragment confirm that fragment class name valid this 
activity 
public static final string extra_show_fragment settings show_fragment 
when starting this activity using link extra_show_fragment 
this extra also specified supply bundle arguments pass 
that fragment when instantiated during initial creation 
activity 
public static final string extra_show_fragment_arguments settings show_fragment_args 
fragment argument passed thru link extra_show_fragment_arguments 
public static final string extra_fragment_arg_key settings fragment_args_key 
public static final string back_stack_prefs settings prefs 
when starting this activity using link extra_show_fragment 
those extra also specify supply title title shown 
that fragment 
public static final string extra_show_fragment_title 
settings show_fragment_title 
public static final string extra_show_fragment_title_resid 
settings show_fragment_title_resid 
public static final string extra_show_fragment_as_shortcut 
settings show_fragment_as_shortcut 
public static final string extra_show_fragment_as_subsetting 
settings show_fragment_as_subsetting 
private static final string meta_data_key_fragment_class 
android settings fragment_class 
private static final string extra_ui_options 
settings ui_options 
private string mfragmentclass 
private charsequence minitialtitle 
private minitialtitleresid 
private static final string like_shortcut_intent_action_array 
android settings application_details_settings 
private viewgroup mcontent 
private boolean mdisplayhomeasupenabled 
private boolean misshortcut 
private arraylist dashboardcategory mcategories arraylist 
public list dashboardcategory getdashboardcategories boolean forcerefresh 
forcerefresh mcategories size 
builddashboard mcategories 
return mcategories 
override 
public boolean onpreferencestartfragment preferencefragment caller preference 
startpreferencepanel getfragment getextras gettitleres gettitle null 
return true 
private static boolean isshortcutintent final intent intent 
string categories intent getcategories 
return categories null categories contains android settings shortcut 
private static boolean islikeshortcutintent final intent intent 
string action intent getaction 
action null return false 
string item like_shortcut_intent_action_array 
item equals action 
return true 
return false 
override 
protected void oncreate bundle savedstate 
super oncreate savedstate 
should happen before call getintent 
getmetadata 
final intent intent getintent 
intent hasextra extra_ui_options 
getwindow setuioptions intent getintextra extra_ui_options 
getting intent properties only done after super oncreate 
final string initialfragmentname intent getstringextra extra_show_fragment 
misshortcut isshortcutintent intent islikeshortcutintent intent 
intent getbooleanextra extra_show_fragment_as_shortcut false 
final componentname intent getcomponent 
final string classname getclassname 
boolean isshowingdashboard classname equals settings class getname 
this settings when 
this real subsettings 
settings show_fragment_as_subsetting passed intent 
final boolean issubsettings classname equals subsettings class getname 
intent getbooleanextra extra_show_fragment_as_subsetting false 
this settings then apply subsettings theme actionbar content insets 
issubsettings 
check also that theme dialog want override them 
final themeresid gettheme getthemeresid 
themeresid style theme_dialogwhenlarge 
themeresid style theme_subsettingsdialogwhenlarge 
settheme style theme_subsettings 
setcontentview layout settings_main_dashboard 
mcontent viewgroup findviewbyid android content 
getsupportfragmentmanager addonbackstackchangedlistener this 
savedstate null 
restarting from previous saved state used that initialize instead 
starting fresh 
settitlefromintent intent 
arraylist dashboardcategory categories 
savedstate getparcelablearraylist save_key_categories 
categories null 
mcategories clear 
mcategories addall categories 
settitlefrombackstack 
mdisplayhomeasupenabled savedstate getboolean save_key_show_home_as_up 
else 
isshowingdashboard 
mdisplayhomeasupenabled issubsettings 
settitlefromintent intent 
bundle initialarguments intent getbundleextra extra_show_fragment_arguments 
switchtofragment initialfragmentname initialarguments true false 
minitialtitleresid minitialtitle false 
else 
mdisplayhomeasupenabled false 
minitialtitleresid string app_name 
switchtofragment dashboardfragment class getname null false false 
minitialtitleresid minitialtitle false 
actionbar actionbar getsupportactionbar 
actionbar null 
actionbar setdisplayhomeasupenabled mdisplayhomeasupenabled 
actionbar sethomebuttonenabled mdisplayhomeasupenabled 
override 
public boolean onnavigateup 
startactivity intent this mainactivity class 
addflags intent flag_activity_reorder_to_front 
addflags intent flag_activity_clear_top 
return true 
private void settitlefromintent intent intent 
final initialtitleresid intent getintextra extra_show_fragment_title_resid 
initialtitleresid 
minitialtitle null 
minitialtitleresid initialtitleresid 
settitle minitialtitleresid 
else 
minitialtitleresid 
final string initialtitle intent getstringextra extra_show_fragment_title 
minitialtitle initialtitle null initialtitle gettitle 
settitle minitialtitle 
override 
public void onbackstackchanged 
settitlefrombackstack 
private settitlefrombackstack 
final count getfragmentmanager getbackstackentrycount 
count 
minitialtitleresid 
settitle minitialtitleresid 
else 
settitle minitialtitle 
return 
fragmentmanager backstackentry getsupportfragmentmanager getbackstackentryat count 
settitlefrombackstackentry 
return count 
private void settitlefrombackstackentry fragmentmanager backstackentry 
final charsequence title 
final titleres getbreadcrumbtitleres 
titleres 
title gettext titleres 
else 
title getbreadcrumbtitle 
title null 
settitle title 
override 
protected void onsaveinstancestate nonnull bundle outstate 
super onsaveinstancestate outstate 
mcategories size 
outstate putparcelablearraylist save_key_categories mcategories 
outstate putboolean save_key_show_home_as_up mdisplayhomeasupenabled 
protected boolean isvalidfragment nonnull string fragmentname 
return false 
xmlres 
protected getdashboardresource 
return 
protected abstract boolean istilesupported nonnull dashboardtile tile 
override 
public intent getintent 
intent superintent super getintent 
string startingfragment getstartingfragmentclass superintent 
this called from super oncreate ismultipane reliable 
onishidingheaders either which relies itself this method 
startingfragment null 
intent modintent intent superintent 
modintent putextra extra_show_fragment startingfragment 
bundle args superintent getextras 
args null 
args bundle args 
else 
args bundle 
args putparcelable intent superintent 
modintent putextra extra_show_fragment_arguments args 
return modintent 
return superintent 
checks component name intent different from settings class 
returns class name load fragment 
private string getstartingfragmentclass intent intent 
mfragmentclass null return mfragmentclass 
string intentclass intent getcomponent getclassname 
return intentclass equals getclass getname null intentclass 
start fragment containing preference panel preferences 
being displayed multi pane mode given fragment class will 
instantiated placed appropriate pane running 
single pane mode activity will launched which show 
fragment 
param fragmentclass full name class implementing fragment 
param args desired arguments supply fragment 
param titleres optional resource identifier title this 
fragment 
param titletext optional text title this fragment 
param resultto optional fragment that result data should sent 
null resultto onactivityresult will called when this 
preference panel done launched panel must 
link finishpreferencepanel fragment intent when done 
param resultrequestcode resultto null this caller 
request code received with result 
public void startpreferencepanel string fragmentclass bundle args titleres 
charsequence titletext fragment resultto resultrequestcode 
string title null 
titleres 
titletext null 
title titletext tostring 
else 
there much that case 
title 
utils startwithfragment this fragmentclass args 
resultto resultrequestcode 
titleres title misshortcut 
switch specific fragment with taking care validation title backstack 
private fragment switchtofragment string fragmentname bundle args boolean validate 
boolean addtobackstack titleresid charsequence title 
boolean withtransition 
validate isvalidfragment fragmentname 
string message invalid fragment this activity fragmentname 
throw illegalargumentexception message 
fragment fragment instantiate this fragmentname args 
fragmenttransaction transaction getsupportfragmentmanager begintransaction 
transaction replace android content 
withtransition device haskitkatapi 
transitionmanager begindelayedtransition mcontent 
addtobackstack transaction addtobackstack settingsactivity back_stack_prefs 
titleresid 
transaction setbreadcrumbtitle titleresid 
else title null 
transaction setbreadcrumbtitle title 
transaction commitallowingstateloss 
getfragmentmanager executependingtransactions 
return 
called when activity needs list categories tiles built 
param categories list which place tiles categories 
private void builddashboard nonnull list dashboardcategory categories 
categories clear 
loaddashboardfromresource getdashboardresource categories 
updatedashboardtileslist categories 
parse given file categories description adding each 
parsed categories tiles into target list 
param resourceid resource load parse 
param target list which parsed categories tiles should placed 
protected final void loaddashboardfromresource xmlres resourceid 
nonnull list dashboardcategory target 
xmlresourceparser parser null 

parser getresources getxml resourceid 
attributeset attrs asattributeset parser 
type 
type parser next 
type xmlpullparser end_document 
type parser next 
type xmlpullparser start_tag break 
string nodename parser getname 
resource_tag_dashboard equals nodename throw runtimeexception 
string format document must start with found 
resource_tag_dashboard nodename parser getpositiondescription 
type parser next 
type xmlpullparser end_document 
type parser next 
type xmlpullparser end_tag parser getdepth root break 
type xmlpullparser end_tag type xmlpullparser text 
continue 
switch parser getname 
case resource_tag_dashboard_category 
dashboardcategory category dashboardcategory this attrs 
final categorydepth parser getdepth 
type parser next 
type xmlpullparser end_document 
type parser next 
type xmlpullparser end_tag parser getdepth categorydepth 
break 
type xmlpullparser end_tag type xmlpullparser text 
continue 
switch parser getname 
case resource_tag_dashboard_tile 
dashboardtile tile dashboardtile this attrs 
bundle bundle null 
final tiledepth parser getdepth 
type parser next 
type xmlpullparser end_document 
type parser next 
type xmlpullparser end_tag parser getdepth tiledepth 
break 
type xmlpullparser end_tag type xmlpullparser text 
continue 
switch parser getname 
case resource_tag_dashboard_tile_extra 
bundle null 
bundle bundle 
getresources parsebundleextra resource_tag_dashboard_tile_extra attrs bundle 
xmlutils skipcurrenttag parser 
break 
case resource_tag_dashboard_tile_intent 
tile intent intent parseintent getresources parser attrs 
break 
default 
xmlutils skipcurrenttag parser 
tile fragmentarguments bundle 
category tile 
break 
default 
xmlutils skipcurrenttag parser 
target category 
break 
default 
xmlutils skipcurrenttag parser 
catch xmlpullparserexception ioexception 
throw runtimeexception error parsing categories 
finally 
parser null parser close 
private void updatedashboardtileslist list dashboardcategory target 
target size 
final dashboardcategory category target 
category size 
final dashboardtile tile category 
final boolean removetile istilesupported tile 
removetile 
category remove 
category isempty 
target remove 
private void getmetadata 

activityinfo getpackagemanager getactivityinfo getcomponentname 
packagemanager get_meta_data 
null metadata null return 
mfragmentclass metadata getstring meta_data_key_fragment_class 
catch namenotfoundexception nnfe 
recovery 
log_tag cannot metadata getcomponentname tostring 
override 
public boolean shoulduprecreatetask nonnull intent unused 
return super shoulduprecreatetask intent this settingsactivity class 
public static final class utils 
start instance activity showing only given fragment 
when launched this mode given preference fragment will instantiated fill 
entire activity 
param context context 
param fragmentname name fragment display 
param args optional arguments supply fragment 
param resultto option fragment that should receive result activity launch 
param resultrequestcode resultto null this request code which 
report result 
param titleresid resource string display title this 
preferences 
param title string display title this preferences 
public static void startwithfragment context context string fragmentname bundle args 
fragment resultto resultrequestcode titleresid charsequence title 
startwithfragment context fragmentname args resultto resultrequestcode 
titleresid title false shortcut 
public static void startwithfragment context context string fragmentname bundle args 
fragment resultto resultrequestcode titleresid charsequence title 
boolean isshortcut 
intent intent onbuildstartfragmentintent context fragmentname args titleresid 
title isshortcut 
resultto null 
context startactivity intent 
else 
resultto startactivityforresult intent resultrequestcode 
build intent launch activity showing selected fragment 
implementation constructs intent that launches current activity with 
appropriate arguments display fragment 
param context context 
param fragmentname name fragment display 
param args optional arguments supply fragment 
param titleresid optional title resource show this item 
param title optional title show this item 
param isshortcut tell this launcher shortcut 
return returns intent that launched display given 
fragment 
public static intent onbuildstartfragmentintent context context string fragmentname 
bundle args titleresid charsequence title boolean isshortcut 
intent intent intent intent action_main 
intent setclass context subsettings class 
intent putextra extra_show_fragment fragmentname 
intent putextra extra_show_fragment_arguments args 
intent putextra extra_show_fragment_title_resid titleresid 
intent putextra extra_show_fragment_title title 
intent putextra extra_show_fragment_as_shortcut isshortcut 
return intent 
