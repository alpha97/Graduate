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

package achep base fragments 
import android content context 
import android content resources 
import android bundle 
import android message 
import android support annotation nonnull 
import android util 
import android view layoutinflater 
import android view view 
import android view viewgroup 
import android widget textview 
import achep acdisplay 
import achep base async weakhandler 
import achep base dashboard dashboardcategory 
import achep base dashboard dashboardtile 
import achep base activities settingsactivity 
import achep base fragments leakcanary leakwatchfragment 
import achep base widgets dashboardtileview 
import java util list 
import static achep base build debug 
public class dashboardfragment extends leakwatchfragment 
private static final string dashboardfragment 
private layoutinflater mlayoutinflater 
private viewgroup mdashboardcontainer 
private static final msg_rebuild_ui 
private final mhandler this 
private static class extends weakhandler dashboardfragment 
public nonnull dashboardfragment object 
super object 
override 
protected void onhandlemassage nonnull dashboardfragment message 
switch what 
case msg_rebuild_ui 
final context context getactivity 
rebuildui context 
break 
override 
public void onresume 
super onresume 
sendrebuildui 
override 
public view oncreateview layoutinflater inflater viewgroup container 
bundle savedinstancestate 
mlayoutinflater inflater 
final view rootview inflater inflate layout dashboard container false 
mdashboardcontainer viewgroup rootview findviewbyid dashboard_container 
return rootview 
private void rebuildui context context 
isadded 
cannot build dashboardsummary fragment added 
return 
final long start system currenttimemillis 
final resources getresources 
mdashboardcontainer removeallviews 
settingsactivity activity settingsactivity context 
list dashboardcategory categories activity getdashboardcategories true 
final count categories size 
count 
dashboardcategory category categories 
view view mlayoutinflater inflate layout dashboard_category mdashboardcontainer false 
textview labelview textview view findviewbyid category_title 
labelview settext category gettitle 
mdashboardcontainer addview view 
viewgroup categorycontent viewgroup view findviewbyid category_content 
dashboardtile tile category 
create fill tile category 
dashboardtileview tileview dashboardtileview 
mlayoutinflater inflate layout dashboard_tile categorycontent false 
tileview setdashboardtile tile 
categorycontent addview tileview 
debug 
long delta system currenttimemillis start 
rebuilding took delta 
private void sendrebuildui 
mhandler hasmessages msg_rebuild_ui 
mhandler sendemptymessage msg_rebuild_ui 
