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
import android content intent 
import android bundle 
import android support fragmentmanager 
import android support fragmenttransaction 
import achep acdisplay presenter 
import achep acdisplay 
import achep acdisplay timeout 
import achep acdisplay fragments pocketfragment 
created artem 
public class acdisplayactivity extends keyguardactivity implements 
timeout ontimeouteventlistener 
pocketfragment onsleeprequestlistener 
private static final string acdisplayactivity 
private final presenter mpresenter presenter getinstance 
private pocketfragment mpocketfragment 
override 
protected void oncreate bundle savedinstancestate 
getconfig iswallpapershown settheme style materialtheme_acdisplay_wallpaper 
super oncreate savedinstancestate 
mpresenter oncreate this 
setcontentview layout acdisplay 
initialize fragments 
savedinstancestate null 
initinternalfragments 
else 
find fragments 
fragmentmanager getsupportfragmentmanager 
mpocketfragment pocketfragment findfragmentbytag pocketfragment 
todo maybe remove pocketfragment active mode disabled 
setup fragments 
mpocketfragment null 
mpocketfragment setlistener this 
mpulsingthread pulsingthread getcontentresolver 
mpulsingthread start 
override 
public void onstart 
super onstart 
mpresenter onstart 
getconfig gettriggers incrementlaunchcount this null 
override 
protected void onresume 
super onresume 
mpresenter onresume 
hideheadsupapp true 
override 
protected void onpause 
hideheadsupapp false 
mpresenter onpause 
super onpause 
override 
public void onstop 
mpresenter onstop 
super onstop 
override 
protected void ondestroy 
mpresenter ondestroy 
super ondestroy 
asks headsup https play google store apps details achep headsup 
pause continue showing floating notifications 
param hideheadsup code true disallow showing floating notifications 
code false allow 
private void hideheadsupapp boolean hideheadsup 
intent intent intent hideheadsup 
achep headsup action_disallow_headsup 
achep headsup action_allow_headsup 
sendbroadcast intent 
initializes fragments such link achep acdisplay fragments pocketfragment 
private void initinternalfragments 
fragmenttransaction getsupportfragmentmanager begintransaction 
turns screen inside your pocket 
getconfig isactivemodeenabled 
mpocketfragment pocketfragment newinstance 
mpocketfragment pocketfragment 
commit 
inheritdoc 
override 
public boolean onsleeprequest 
probably best solution worst 
check user does interact with before locking 
gettimeout ispaused 
return lock 
return false 
