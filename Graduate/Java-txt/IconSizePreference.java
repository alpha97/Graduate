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

package achep acdisplay preferences 
import android content context 
import android content resources 
import android support annotation nonnull 
import android util attributeset 
import android view layoutinflater 
import android view view 
import android view viewgroup 
import android widget imageview 
import android widget linearlayout 
import android widget seekbar 
import android widget textview 
import achep acdisplay config 
import achep acdisplay 
import achep base preferences materialdialogpreference 
import afollestad materialdialogs materialdialog 
import java lang softreference 
preference configure size collapsed views 
author artem chepurnoy 
public class iconsizepreference extends materialdialogpreference implements 
seekbar onseekbarchangelistener 
private static final string iconsizepreference 
private final string mvaluelabel 
private softreference string msoftstoredlabels 
private mmin 
private seekbar mseekbar 
private textview mvaluetextview 
private linearlayout mcontainer 
public iconsizepreference context context attributeset attrs 
super context attrs 
mvaluelabel context getresources getstring string preference_icon_size_dpi 
nonnull 
override 
public materialdialog onbuilddialog nonnull materialdialog builder builder 
layoutinflater inflater layoutinflater getcontext 
getsystemservice context layout_inflater_service 
resources getcontext getresources 
materialdialog builder 
customview layout preference_dialog_size false 
build 
final getinteger integer config_icon_size_max_dp 
mmin getinteger integer config_icon_size_min_dp 
msoftstoredlabels softreference mmin 
config config config getinstance 
view root getcustomview 
assert root null 
mcontainer linearlayout root findviewbyid container 
mvaluetextview textview root findviewbyid info 
mseekbar seekbar root findviewbyid seek_bar 
mseekbar setonseekbarchangelistener this 
mseekbar setmax mmin 
mseekbar setprogress config geticonsize config icon_size_dp mmin 
init preview 

view view inflater inflate layout notification_icon mcontainer false 
view setbackgroundcolor getcolor color selector_pressed_dark 
imageview icon imageview view findviewbyid icon 
icon setimageresource drawable stat_notify 
textview text textview view findviewbyid number 
text settext integer tostring 
mcontainer addview view 
onstoptrackingtouch mseekbar 
return 
override 
protected void ondialogclosed boolean positiveresult 
super ondialogclosed positiveresult 
positiveresult 
return 
save changes config 
config config config getinstance 
config seticonsizedp getcontext mseekbar getprogress mmin null 
override 
public void onprogresschanged seekbar seekbar progress boolean byuser 
store labels soft references array 
prevent lots strings 
string label 
softreference string cached msoftstoredlabels progress 
cached null cached null 
label string format mvaluelabel integer tostring progress mmin 
msoftstoredlabels progress softreference label 
else 
label cached 
mvaluetextview settext label 
override 
public void onstarttrackingtouch seekbar seekbar unused 
override 
public void onstoptrackingtouch seekbar seekbar 
update preview collapsed views 
list 
float density getcontext getresources getdisplaymetrics density 
size math round seekbar getprogress mmin density 
length mcontainer getchildcount 
length 
view child mcontainer getchildat 
viewgroup layoutparams child getlayoutparams 
height size 
width size 
child setlayoutparams 
