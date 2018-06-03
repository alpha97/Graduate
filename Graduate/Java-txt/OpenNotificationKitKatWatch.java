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
import android build 
import android service notification statusbarnotification 
import android support annotation nonnull 
import android support annotation nullable 
import apache commons lang builder equalsbuilder 
author artem chepurnoy 
targetapi build version_codes kitkat_watch 
class opennotificationkitkatwatch extends opennotificationjellybeanmr 
opennotificationkitkatwatch nonnull statusbarnotification nonnull notification 
super 
inheritdoc 
override 
public boolean hasidenticalids nullable opennotification 
null return false 
statusbarnotification getstatusbarnotification 
statusbarnotification getstatusbarnotification 
assert null 
return equalsbuilder 
append getkey getkey 
isequals 
