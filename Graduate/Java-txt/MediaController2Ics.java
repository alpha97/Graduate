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

package achep acdisplay services media 
import android activity 
import android pendingintent 
import android content context 
import android graphics bitmap 
import android media audiomanager 
import android media iremotecontroldisplay 
import android media mediametadataretriever 
import android bundle 
import android handler 
import android looper 
import android message 
import android remoteexception 
import android support annotation nonnull 
import android support annotation nullable 
import android util 
import android util sparseintarray 
import achep acdisplay 
import achep base utils mathutils 
import java lang weakreference 
import java lang reflect method 
import static achep acdisplay services media mediacontroller kitkat sstatesparse 
inheritdoc 
thanks alexander_breen research 
http forum developers showthread 
class mediacontroller extends mediacontroller 
private final sparseintarray mstatesparse 
private remotecontroldisplay mremotedisplay 
private handler mhandler handler looper getmainlooper handler callback 
private mhostid 
override 
public boolean handlemessage message 
switch what 
case remotecontroldisplay msg_host_id 
mhostid 
break 
default 
mhostid break 
switch what 
case remotecontroldisplay msg_update_state update playback state 
updateplaybackstate 
break 
case remotecontroldisplay msg_set_metadata update metadata 
updatemetadata bundle 
break 
case remotecontroldisplay msg_set_artwork 
updatemetadataartwork bitmap 
break 
return true 
inheritdoc 
protected mediacontroller nonnull activity activity 
super activity 
sparseintarray cachedstatesparse sstatesparse 
cachedstatesparse null 
mstatesparse mediacontroller kitkat generateplaybackcompatsparse 
sstatesparse weakreference mstatesparse 
else 
mstatesparse cachedstatesparse 
override 
public void onstart object objects 
super onstart objects 
mhandler handler 
mremotedisplay remotecontroldisplay mhandler 
audiomanager manager audiomanager mcontext getsystemservice context audio_service 

method method manager getclass getdeclaredmethod 
registerremotecontroldisplay 
iremotecontroldisplay class 
method setaccessible true 
method invoke manager mremotedisplay 
catch exception 
failed register remote control display 
printstacktrace 
mremotedisplay null clean 
override 
public void onstop object objects 
mremotedisplay null 
audiomanager manager audiomanager mcontext getsystemservice context audio_service 

method method manager getclass getdeclaredmethod 
unregisterremotecontroldisplay 
iremotecontroldisplay class 
method setaccessible true 
method invoke manager mremotedisplay 
catch exception 
failed unregister remote control display 
printstacktrace 
finally 
mremotedisplay null clean 
mhandler removemessages remotecontroldisplay msg_host_id 
mhandler removemessages remotecontroldisplay msg_set_metadata 
mhandler removemessages remotecontroldisplay msg_set_transport_controls 
mhandler removemessages remotecontroldisplay msg_update_state 
mmetadata clear 
super onstop objects 
inheritdoc 
public void sendmediaaction action 
broadcastmediaaction mcontext action 
inheritdoc 
override 
public void seekto long position nothing 
inheritdoc 
override 
public long getplaybackbufferedposition 
return 
inheritdoc 
override 
public long getplaybackposition 
return 
inheritdoc 
override 
protected void updateplaybackstate playbackstatercc 
super updateplaybackstate mstatesparse playbackstatercc 
clears link mmetadata metadata same calling 
link updatemetadata bundle with code null parameter 
updatemetadata bundle 
private void clearmetadata 
updatemetadata null 
updates link mmetadata metadata from given bundle 
param data object metadata update from code null clear local metadata 
clearmetadata 
private void updatemetadata nullable bundle data 
data null 
mmetadata isempty return 
mmetadata clear 
else 
mmetadata title data getstring mediametadataretriever metadata_key_title null 
mmetadata artist data getstring mediametadataretriever metadata_key_artist null 
mmetadata album data getstring mediametadataretriever metadata_key_album null 
mmetadata duration data getlong mediametadataretriever metadata_key_duration 
mmetadata generatesubtitle 
notifyonmetadatachanged 
private void updatemetadataartwork bitmap artwork 
artwork null 
size mcontext getresources getdimensionpixelsize dimen media_artwork_size 

mmetadata bitmap bitmap createscaledbitmap artwork size size true 
catch outofmemoryerror 
mmetadata bitmap null 
else 
mmetadata bitmap null 
clear previous artwork 
this class required have weak linkage 
because remote process hold strong reference this binder object 
predict when will remote process without this code 
would allow heavyweight object held this side binder when there 
requirement other side 
private static class remotecontroldisplay extends iremotecontroldisplay stub 
public static final msg_update_state 
public static final msg_set_metadata 
public static final msg_set_transport_controls 
public static final msg_host_id 
public static final msg_set_artwork 
reference should weak predict when process 
will happen remote object 
nonnull 
private weakreference handler mhandlerref 
public remotecontroldisplay nonnull handler handler 
super 
mhandlerref weakreference handler 
override 
public void setallmetadata generationid bundle metadata bitmap bitmap 
handler handler mhandlerref 
handler null return 
handler obtainmessage msg_set_metadata generationid metadata sendtotarget 
handler obtainmessage msg_set_artwork generationid bitmap sendtotarget 
override 
public void setartwork generationid bitmap bitmap 
handler handler mhandlerref 
handler null return 
handler obtainmessage msg_set_artwork generationid bitmap sendtotarget 
override 
public void setcurrentclientid clientgeneration pendingintent mediaintent 
boolean clearing throws remoteexception 
handler handler mhandlerref 
handler null return 
handler obtainmessage 
msg_host_id clientgeneration 
mathutils bool clearing mediaintent sendtotarget 
override 
public void setmetadata generationid bundle metadata 
handler handler mhandlerref 
handler null return 
handler obtainmessage msg_set_metadata generationid metadata sendtotarget 
override 
public void setplaybackstate generationid state long statechangetimems 
handler handler mhandlerref 
handler null return 
handler obtainmessage msg_update_state generationid state sendtotarget 
override 
public void settransportcontrolflags generationid flags 
handler handler mhandlerref 
handler null return 
handler obtainmessage msg_set_transport_controls generationid flags sendtotarget 
