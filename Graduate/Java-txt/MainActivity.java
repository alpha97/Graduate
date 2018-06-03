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

package achep acdisplay activities 
import android admin devicepolicymanager 
import android content context 
import android content intent 
import android content packageinfo 
import android content packagemanager 
import android bundle 
import android handler 
import android powermanager 
import android support annotation nonnull 
import android support appcompatactivity 
import android util 
import android view menu 
import android view menuitem 
import android widget compoundbutton 
import achep acdisplay 
import achep acdisplay config 
import achep acdisplay 
import achep acdisplay notifications notificationhelper 
import achep acdisplay dialoghelper 
import achep acdisplay activities base baseactivity 
import achep acdisplay activities settings settings 
import achep base content configbase 
import achep base permissions permission 
import achep base switchbarpermissible 
import achep base widgets switchbar 
import achep base utils packageutils 
author artem chepurnoy 
public class mainactivity extends baseactivity implements configbase onconfigchangedlistener 
private static final string mainactivity 
private switchbarpermissible mswitchpermission 
private menuitem msendtestnotificationmenuitem 
private boolean mbroadcasting 
override 
protected void oncreate bundle savedinstancestate 
requestcheckout 
super oncreate savedinstancestate 
setcontentview layout main 
getconfig registerlistener this 
permission permissions getaccessmanager getmasterpermissions permissions 
switchbar switchbar switchbar findviewbyid switch_bar 
mswitchpermission switchbarpermissible this switchbar permissions 
mswitchpermission setchecked getconfig isenabled 
mswitchpermission setoncheckedchangelistener compoundbutton oncheckedchangelistener 
override 
public void oncheckedchanged compoundbutton compoundbutton boolean checked 
updatesendtestnotificationmenuitem 
mbroadcasting 
return 
appcompatactivity context mainactivity this 
getconfig setenabled context checked mainactivity this 
config triggers triggers getconfig gettriggers 
triggers isdonationasked triggers getlaunchcount 
triggers setdonationasked this true this 
dialoghelper showcrydialog this 
handleappupgrade 
private void handleappupgrade 
packageinfo 

getpackagemanager getpackageinfo packageutils getname this 
catch packagemanager namenotfoundexception 
failed find packageinfo 
return 
config triggers triggers getconfig gettriggers 
final versioncode versioncode 
final versioncodeold triggers getpreviousversion 
versioncodeold versioncode 
triggers setpreviousversion this versioncode null 
versioncodeold version 
dialoghelper showcompatdialog mainactivity this 
versioncodeold before 
startacdisplayintro 
private void updatesendtestnotificationmenuitem 
msendtestnotificationmenuitem null return 
msendtestnotificationmenuitem setvisible mswitchpermission ischecked 
override 
protected void onresume 
super onresume 
mswitchpermission resume 
override 
protected void onpause 
mswitchpermission pause 
super onpause 
override 
protected void ondestroy 
super ondestroy 
getconfig unregisterlistener this 
override 
public void onconfigchanged nonnull configbase config 
nonnull string 
nonnull object value 
switch 
case config key_enabled 
mbroadcasting true 
mswitchpermission setchecked boolean value 
mbroadcasting false 
break 
override 
public boolean oncreateoptionsmenu menu menu 
getmenuinflater inflate menu main menu 
msendtestnotificationmenuitem menu finditem test_action 
updatesendtestnotificationmenuitem 
return true 
override 
public boolean onoptionsitemselected menuitem item 
switch item getitemid 
case settings_action 
startactivity intent this settings class 
break 
case test_action 
startacdisplaytest true 
break 
case intro_action 
startacdisplayintro 
break 
dialogs 
case donate_action 
dialoghelper showdonatedialog this 
break 
case feedback_action 
dialoghelper showfeedbackdialog this 
break 
case about_action 
dialoghelper showaboutdialog this 
break 
case help_action 
dialoghelper showhelpdialog this 
break 
default 
return super onoptionsitemselected item 
return true 
private void startacdisplayintro 
startactivity intent this introactivity class 
turns screen sends test notification 
param cheat code true simply starts link acdisplayactivity 
code false turns device then uses notification 
wake 
private void startacdisplaytest boolean cheat 
cheat 
startactivity intent this acdisplayactivity class 
notificationhelper sendnotification this id_notify_test 
return 
delay getresources getinteger integer config_test_notification_delay 
powermanager powermanager getsystemservice context power_service 
powermanager wakelock wakelock newwakelock powermanager partial_wake_lock test notification 
wakelock acquire delay 

sleep 
devicepolicymanager devicepolicymanager getsystemservice context device_policy_service 
locknow 
handler postdelayed runnable 
private final context context getapplicationcontext 
override 
public void 
notificationhelper sendnotification context id_notify_test 
delay 
catch securityexception 
failed turn screen 
wakelock release 
