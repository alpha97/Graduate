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

package achep base widgets 
import android content context 
import android content resources 
import android support annotation nonnull 
import android text textutils 
import android util attributeset 
import android view view 
import android widget imageview 
import android widget linearlayout 
import android widget textview 
import achep acdisplay 
import achep base dashboard dashboardtile 
import achep base activities settingsactivity 
import achep base utils rippleutils 
public class dashboardtileview extends linearlayout implements view onclicklistener 
private static final default_col_span 
private imageview mimageview 
private textview mtitletextview 
private textview mstatustextview 
private view mdivider 
private mcolspan default_col_span 
private dashboardtile mtile 
public dashboardtileview context context attributeset attrs 
super context attrs 
override 
protected void onfinishinflate 
super onfinishinflate 
mimageview imageview findviewbyid icon 
mtitletextview textview findviewbyid title 
mstatustextview textview findviewbyid status 
mdivider findviewbyid tile_divider 
setonclicklistener this 
setfocusable true 
rippleutils makefor this true 
public void setdashboardtile nonnull dashboardtile tile 
mtile tile 
resources getresources 
tile iconres 
mimageview setimageresource tile iconres 
else 
mimageview setimagedrawable null 
mimageview setbackground null 
mtitletextview settext tile gettitle 
charsequence summary tile getsummary 
textutils isempty summary 
mstatustextview setvisibility view visible 
mstatustextview settext summary 
else 
mstatustextview setvisibility view gone 
public void setdividervisibility boolean visible 
mdivider setvisibility visible view visible view gone 
void setcolumnspan span 
mcolspan span 
getcolumnspan 
return mcolspan 
override 
public void onclick view 
mtile fragment null 
settingsactivity utils startwithfragment getcontext 
mtile fragment mtile fragmentarguments null 
mtile titleres mtile gettitle getresources 
else mtile intent null 
getcontext startactivity mtile intent 
