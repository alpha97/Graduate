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

package achep acdisplay notifications 
import android annotation targetapi 
import android notification 
import android content context 
import android graphics color 
import android build 
import android service notification statusbarnotification 
import android support annotation nonnull 
import android support annotation nullable 
import android util 
import java lang reflect invocationtargetexception 
import java lang reflect method 
import java util list 
author artem chepurnoy 
targetapi build version_codes lollipop 
class opennotificationlollipop extends opennotificationkitkatwatch 
private static final string opennotificationlp 
nonnull 
private final notificationlist mgroupnotifications 
opennotificationlollipop nonnull statusbarnotification nonnull notification 
super 
mgroupnotifications notificationlist null 
inheritdoc 
override 
public void onlowmemory 
super onlowmemory 
opennotification mgroupnotifications onlowmemory 
inheritdoc 
override 
public getvisibility 
return getnotification visibility 
override 
protected void loadbrandcolor nonnull context context 
color getnotification color 
color color black color color white 
super loadbrandcolor context 
else setbrandcolor getnotification color 
inheritdoc 
nullable 
public string getgroupkey 
return getstatusbarnotification getgroupkey 
inheritdoc 
nonnull 
override 
public list opennotification getgroupnotifications 
return mgroupnotifications 
inheritdoc 
override 
public boolean isgroupchild 

method method notification class getdeclaredmethod isgroupchild 
method setaccessible true 
return boolean method invoke getnotification 
catch nosuchmethodexception 
invocationtargetexception 
illegalaccessexception 
failed check group child 
return false 
inheritdoc 
override 
public boolean isgroupsummary 

method method notification class getdeclaredmethod isgroupsummary 
method setaccessible true 
return boolean method invoke getnotification 
catch nosuchmethodexception 
invocationtargetexception 
illegalaccessexception 
failed check group summary 
return false 
