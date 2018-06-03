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
import android annotation targetapi 
import android activity 
import android content componentname 
import android content context 
import android content intent 
import android content serviceconnection 
import android media mediametadataeditor 
import android media mediametadataretriever 
import android media remotecontrolclient 
import android media remotecontroller 
import android build 
import android ibinder 
import android support annotation nonnull 
import android support annotation nullable 
import android support media session playbackstatecompat 
import android util 
import android util sparseintarray 
import android view keyevent 
import achep acdisplay 
import achep acdisplay services mediaservice 
import java lang weakreference 
created artem chepurnoy 
suppresswarnings deprecation 
targetapi build version_codes kitkat 
class mediacontroller kitkat extends mediacontroller 
static weakreference sparseintarray sstatesparse weakreference null 
nullable 
private mediaservice mservice 
private boolean mbound false 
private final remotecontroller onclientupdatelistener mrcclientupdatelistener 
remotecontroller onclientupdatelistener 
override 
public void onclientchange boolean clearing 
clearing 
clearmetadata 
override 
public void onclientplaybackstateupdate state 
mplaybackstate state 
updateplaybackstate state 
override 
public void onclientplaybackstateupdate state long statechangetimems 
long currentposms float speed 
onclientplaybackstateupdate state 
override 
public void onclienttransportcontrolupdate transportcontrolflags 
todo bring more music control 
override 
public void onclientmetadataupdate remotecontroller metadataeditor metadataeditor 
updatemetadata metadataeditor 
private final serviceconnection mconnection serviceconnection 
override 
public void onserviceconnected componentname classname ibinder service 
mediaservice binder mediaservice service 
mservice binder getservice 
mservice setremotecontrollerenabled 
mservice setclientupdatelistener mrcclientupdatelistener 
mbound true 
override 
public void onservicedisconnected componentname name 
mbound false 
private final sparseintarray mstatesparse 
inheritdoc 
protected mediacontroller kitkat nonnull activity activity 
super activity 
sparseintarray cachedstatesparse sstatesparse 
cachedstatesparse null 
mstatesparse generateplaybackcompatsparse 
sstatesparse weakreference mstatesparse 
else 
mstatesparse cachedstatesparse 
nonnull 
static sparseintarray generateplaybackcompatsparse 
sparseintarray sparseintarray 
remotecontrolclient playstate_buffering playbackstatecompat state_buffering 
remotecontrolclient playstate_playing playbackstatecompat state_playing 
remotecontrolclient playstate_paused playbackstatecompat state_paused 
remotecontrolclient playstate_error playbackstatecompat state_error 
remotecontrolclient playstate_rewinding playbackstatecompat state_rewinding 
remotecontrolclient playstate_fast_forwarding playbackstatecompat state_fast_forwarding 
remotecontrolclient playstate_skipping_forwards playbackstatecompat state_skipping_to_next 
remotecontrolclient playstate_skipping_backwards playbackstatecompat state_skipping_to_previous 
return 
inheritdoc 
override 
public void onstart object objects 
super onstart 
intent intent intent action_bind_media_control_service 
mcontext bindservice intent mconnection context bind_auto_create 
inheritdoc 
override 
public void onstop object objects 
mmetadata clear 
mbound 
assert mservice null 
mservice setclientupdatelistener null 
mservice setremotecontrollerdisabled 
mservice null 
mbound false 
mcontext unbindservice mconnection 
super onstop 
inheritdoc 
public void sendmediaaction action 
mservice null 
sending media action stopped controller 
return 
keycode 
switch action 
case action_play_pause 
keycode keyevent keycode_media_play_pause 
break 
case action_stop 
keycode keyevent keycode_media_stop 
break 
case action_skip_to_next 
keycode keyevent keycode_media_next 
break 
case action_skip_to_previous 
keycode keyevent keycode_media_previous 
break 
default 
throw illegalargumentexception 
todo should think about sending these down events accurately with touch down 
buttons near term this will interfere with long press behavior 
remotecontroller mservice getremotecontroller 
sendmediakeyevent keyevent keyevent action_down keycode 
sendmediakeyevent keyevent keyevent action_up keycode 
inheritdoc 
override 
public void seekto long position 
mservice null 
seeking media stopped controller 
return 
remotecontroller mservice getremotecontroller 
seekto position 
inheritdoc 
override 
public long getplaybackbufferedposition 
return 
inheritdoc 
override 
public long getplaybackposition 
mservice null 
getting playback position stopped controller 
return 
remotecontroller mservice getremotecontroller 
return getestimatedmediaposition 
inheritdoc 
protected void updateplaybackstate playbackstatercc 
super updateplaybackstate mstatesparse playbackstatercc 
clears link mmetadata metadata same calling 
link updatemetadata android media remotecontroller metadataeditor 
with code null parameter 
updatemetadata android media remotecontroller metadataeditor 
private void clearmetadata 
updatemetadata null 
updates link mmetadata metadata from given remote metadata class 
this also updates play state 
param data object metadata update from code null clear local metadata 
clearmetadata 
private void updatemetadata nullable remotecontroller metadataeditor data 
data null 
mmetadata isempty return 
mmetadata clear 
else 
mmetadata title data getstring mediametadataretriever metadata_key_title null 
mmetadata artist data getstring mediametadataretriever metadata_key_artist null 
mmetadata album data getstring mediametadataretriever metadata_key_album null 
mmetadata duration data getlong mediametadataretriever metadata_key_duration 
mmetadata bitmap data getbitmap mediametadataeditor bitmap_key_artwork null 
mmetadata generatesubtitle 
notifyonmetadatachanged 
