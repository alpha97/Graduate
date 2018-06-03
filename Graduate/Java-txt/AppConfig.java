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

package achep acdisplay blacklist 
import android content sharedpreferences 
import android support annotation nonnull 
import android util 
import achep base content sharedlist 
import apache commons lang builder equalsbuilder 
import apache commons lang builder hashcodebuilder 
attention equality package name only 
author artem chepurnoy 
public class appconfig 
private static final string appconfig 
public static final diff_restricted 
public static final diff_hidden 
public static final diff_non_clearable 
static final boolean default_restricted false 
static final boolean default_hidden false 
static final boolean default_non_clearable false 
public string packagename 
public final boolean restricted boolean default_restricted 
public final boolean hidden boolean default_hidden 
public final boolean nonclearable boolean default_non_clearable 
public appconfig string packagename 
this packagename 
default_restricted 
default_hidden 
default_non_clearable 
public appconfig string packagename 
boolean restricted 
boolean hidden 
boolean nonclearable 
this packagename packagename 
setrestricted restricted 
sethidden hidden 
setnonclearableenabled nonclearable 
resets except package name default values 
public static void reset appconfig config 
config setrestricted default_restricted 
config sethidden default_hidden 
config setnonclearableenabled default_non_clearable 
copies data first config into second 
param config origin config 
param clone clone config 
return cloned config 
reset appconfig 
public static appconfig copy appconfig config appconfig clone 
clone packagename config packagename 
clone setrestricted config isrestricted 
clone sethidden config ishidden 
clone setnonclearableenabled config isnonclearableenabled 
return clone 
logs given config with debug output level 
public static void string appconfig config 
config tostring 
inheritdoc 
override 
public hashcode 
return hashcodebuilder 
append packagename 
tohashcode 
compares given link achep acdisplay blacklist appconfig with 
this warning only criterion equality package name 
override 
public boolean equals object 
this 
return true 
instanceof appconfig 
return false 
appconfig appconfig 
return equalsbuilder 
append packagename packagename 
isequals 
inheritdoc 
override 
public string tostring 
return appconfig 
restricted isrestricted 
hidden ishidden 
clearable isnonclearableenabled 
packagename 

public void setrestricted boolean restricted 
this restricted restricted 
public void sethidden boolean hidden 
this hidden hidden 
public void setnonclearableenabled boolean enabled 
this nonclearable enabled 
public boolean isrestricted 
return restricted 
public boolean ishidden 
return hidden 
return code true showing clearable notifications allowed 
this code false otherwise 
setnonclearableenabled boolean 
default_non_clearable 
diff_non_clearable 
public boolean isnonclearableenabled 
return nonclearable 
return code true options default code false otherwise 
appconfig default_restricted 
appconfig default_hidden 
appconfig default_non_clearable 
reset appconfig 
suppresswarnings pointlessbooleanexpression 
boolean equalstodefault 
return isrestricted appconfig default_restricted 
ishidden appconfig default_hidden 
isnonclearableenabled appconfig default_non_clearable 
saves restores appconfig from shared preferences 
author artem chepurnoy 
static final class saver extends sharedlist saver appconfig 
private static final string key_package package_name_ 
private static final string key_restricted restricted_ 
private static final string key_hidden hidden_ 
private static final string key_non_clearable clearable_ 
inheritdoc 
nonnull 
override 
public sharedpreferences editor nonnull appconfig 
nonnull sharedpreferences editor editor 
position 
editor putstring key_package position packagename 
editor putboolean key_restricted position isrestricted 
editor putboolean key_hidden position ishidden 
editor putboolean key_non_clearable position isnonclearableenabled 
return editor 
inheritdoc 
override 
public appconfig nonnull sharedpreferences prefs position 
string prefs getstring key_package position null 
boolean restricted prefs getboolean key_restricted position default_restricted 
boolean hidden prefs getboolean key_hidden position default_hidden 
boolean ongoing prefs getboolean key_non_clearable position default_non_clearable 
return appconfig restricted hidden ongoing 
compares different appconfigs 
author artem chepurnoy 
static final class comparator extends sharedlist comparator appconfig 
inheritdoc 
override 
public compare nonnull appconfig object appconfig 
return orzero diff_hidden object ishidden ishidden 
orzero diff_restricted object isrestricted isrestricted 
orzero diff_non_clearable object isnonclearableenabled isnonclearableenabled 
private orzero value boolean boolean 
return value 
