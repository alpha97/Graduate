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

package achep acdisplay fragments 
import android activity 
import android fragment 
import android content applicationinfo 
import android content packagemanager 
import android bundle 
import android view layoutinflater 
import android view view 
import android view viewgroup 
import android widget checkbox 
import android widget imageview 
import android widget linearlayout 
import android widget scrollview 
import android widget textview 
import achep acdisplay 
import achep acdisplay blacklist blacklist 
import achep acdisplay blacklist options hideoption 
import achep acdisplay blacklist options nonclearableoption 
import achep acdisplay blacklist options option 
import achep acdisplay blacklist options restrictoption 
import achep base utils viewutils 
created artem 
public class blacklistappfragment extends fragment 
public static final string args_package_name package_name 
private static final string save_key_package_name package_name 
private static final string save_key_scroll_view_x scroll_view_x 
private static final string save_key_scroll_view_y scroll_view_y 
private option moptions 
private string mpackagename 
header 
private imageview mappicon 
private textview mappname 
private textview mapppackagename 
options 
private linearlayout mcontainer 
private scrollview mscrollview 
private string extractpackagename bundle args bundle savedinstancestate 
string packagename 
args null 
packagename args getstring args_package_name 
packagename null return packagename 
savedinstancestate null 
packagename savedinstancestate getstring save_key_package_name 
packagename null return packagename 
return 
override 
public void oncreate bundle savedinstancestate 
super oncreate savedinstancestate 
activity activity getactivity 
blacklist blacklist blacklist getinstance 
mpackagename extractpackagename getarguments savedinstancestate 
moptions option 
hideoption activity checkbox activity blacklist mpackagename 
restrictoption activity checkbox activity blacklist mpackagename 
nonclearableoption activity checkbox activity blacklist mpackagename 
override 
public void onsaveinstancestate bundle outstate 
super onsaveinstancestate outstate 
outstate putstring save_key_package_name mpackagename 
outstate putint save_key_scroll_view_x mscrollview getscrollx 
outstate putint save_key_scroll_view_y mscrollview getscrolly 
override 
public void onresume 
super onresume 
option option moptions 
option resume 
override 
public void onpause 
super onpause 
option option moptions 
option pause 
override 
public view oncreateview layoutinflater inflater viewgroup container bundle savedinstancestate 
view view inflater inflate layout fragment_blacklist_app_config container false 
assert view null 
hide switch from header 
mappicon imageview view findviewbyid icon 
mappname textview view findviewbyid title 
mapppackagename textview view findviewbyid summary 
options list 
mscrollview scrollview view findviewbyid scrollview 
mcontainer linearlayout view findviewbyid container 
buildoptionslist 
savedinstancestate null 
restore scroll position 
final scrollx savedinstancestate getint save_key_scroll_view_x 
final scrolly savedinstancestate getint save_key_scroll_view_y 
mscrollview post runnable 
override 
public void 
mscrollview scrollto scrollx scrolly 
displayapp 
return view 
private void buildoptionslist 
mcontainer removeallviews 
layoutinflater inflater getactivity getlayoutinflater 
option option moptions 
view view inflater inflate layout preference_blacklist_app_config mcontainer false 
imageview icon imageview view findviewbyid icon 
textview title textview view findviewbyid android title 
textview summary textview view findviewbyid android summary 
icon setimagedrawable option icon 
viewutils safelysettext title option title 
viewutils safelysettext summary option summary 
final checkbox checkbox checkbox view findviewbyid checkbox 
option setcompoundbutton checkbox 
view setonclicklistener view onclicklistener 
override 
public void onclick view 
checkbox toggle 
mcontainer addview view 
private void displayapp 
mscrollview scrollto 
update header 
final packagemanager getactivity getpackagemanager 

applicationinfo getapplicationinfo mpackagename 
mappicon setimagedrawable getapplicationicon 
mappname settext getapplicationlabel 
mapppackagename settext mpackagename 
catch packagemanager namenotfoundexception 
mappname settext name found 
