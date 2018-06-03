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
import android notification 
import android content context 
import android support annotation nonnull 
import android support annotation nullable 
import android widget remoteviews 
import apache commons lang builder equalsbuilder 
author artem chepurnoy 
todo find notification 
class opennotificationjellybean extends opennotification 
suppresswarnings nullableproblems 
nonnull 
private volatile string mpackagename 
opennotificationjellybean nonnull notification 
super null 
override 
public void load nonnull context context 
remoteviews getnotification contentview 
null getnotification bigcontentview 
null noinspection deprecation 
getnotification tickerview 
mpackagename null getpackage 
super load context 
comparing instances 
inheritdoc 
override 
public hashcode 
return getnotification hashcode 
inheritdoc 
suppresswarnings equalswhichdoesntcheckparameterclass 
override 
public boolean equals object 
return getnotification equals 
inheritdoc 
override 
public boolean hasidenticalids nullable opennotification 
null 
return false 
equalsbuilder builder equalsbuilder 
remoteviews getnotification contentview 
remoteviews getnotification contentview 
null null 
builder append getlayoutid getlayoutid 
return builder 
append getnotification ledargb getnotification ledargb 
append getpackagename getpackagename 
append titletext titletext 
isequals 
other 
inheritdoc 
nonnull 
override 
public string getpackagename 
return mpackagename 
