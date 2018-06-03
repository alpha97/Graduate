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
import android content componentname 
import android content context 
import android graphics bitmap 
import android media mediametadata 
import android media session mediacontroller 
import android media session mediasession 
import android media session mediasessionmanager 
import android media session playbackstate 
import android build 
import android handler 
import android looper 
import android systemclock 
import android support annotation nonnull 
import android support annotation nullable 
import android util 
import achep acdisplay 
import achep acdisplay services mediaservice 
import achep base async taskqueuethread 
import achep base tests check 
import java lang reference 
import java lang weakreference 
import java util list 
import static achep base build debug 
inheritdoc 
targetapi build version_codes lollipop 
class mediacontroller lollipop extends mediacontroller 
nonnull 
private final componentname mcomponent 
nonnull 
private final onactivesessionschangedlistener msessionlistener 
onactivesessionschangedlistener 
nonnull 
private final mediacontroller callback mcallback 
mediacontroller callback 
override 
public void onmetadatachanged mediametadata metadata 
super onmetadatachanged metadata 
check getinstance isinmainthread 
updatemetadata metadata 
override 
public void onplaybackstatechanged nonnull playbackstate state 
super onplaybackstatechanged state 
check getinstance isinmainthread 
updateplaybackstate state getstate 
author artem chepurnoy 
private static class onactivesessionschangedlistener implements 
mediasessionmanager onactivesessionschangedlistener 
nonnull 
private reference mediacontroller lollipop mmediacontrollerref weakreference null 
public void setmediacontroller nullable mediacontroller lollipop 
null 
mmediacontrollerref clear 
return 
mmediacontrollerref weakreference 
override 
public void onactivesessionschanged list mediacontroller controllers 
mediacontroller lollipop mmediacontrollerref 
null return 
mmediacontroller null 
mediacontroller controller controllers 
mmediacontroller controller 
current media controller still alive 
return 
mediacontroller pickbestmediacontroller controllers 
null 
setmediacontroller 
else 
clearmediacontroller true 
nullable 
private mediacontroller pickbestmediacontroller 
nonnull list mediacontroller list 
mediacontrollerscore 
mediacontroller mediacontroller null 
mediacontroller list 
null continue 
mcscore 
check current state 
playbackstate state getplaybackstate 
state null 
switch state getstate 
case playbackstate state_stopped 
case playbackstate state_error 
break 
default 
mcscore 
break 
mcscore mediacontrollerscore 
mediacontrollerscore mcscore 
mediacontroller 
return mediacontroller 
nullable 
private mediasessionmanager mmediasessionmanager 
nullable 
private mediacontroller mmediacontroller 
private boolean msessionlistening 
private mthread 
inheritdoc 
protected mediacontroller lollipop nonnull context context 
super context 
mcomponent componentname context mediaservice class 
inheritdoc 
override 
public void onstart object objects 
super onstart 
init thread 
mthread this 
mthread setpriority thread min_priority 
mthread start 
media session manager leaks holds context long 
leak activity better whole 
final context context mcontext getapplicationcontext 
mmediasessionmanager mediasessionmanager context 
getsystemservice context media_session_service 

mmediasessionmanager addonactivesessionschangedlistener msessionlistener mcomponent 
msessionlistener setmediacontroller this 
msessionlistening true 
catch securityexception exception 
failed start lollipop media controller exception getmessage 
unregister just case 

mmediasessionmanager removeonactivesessionschangedlistener msessionlistener 
catch exception unused finally 
mmediasessionmanager null 
msessionlistening false 
media controller needs notification listener service 
permissions granted 
return 
list mediacontroller controllers mmediasessionmanager getactivesessions mcomponent 
msessionlistener onactivesessionschanged controllers 
inheritdoc 
override 
public void onstop object objects 
force stop thread 
mthread finish true 
msessionlistening 
msessionlistening false 
msessionlistener setmediacontroller null 
assert mmediasessionmanager null 
mmediasessionmanager removeonactivesessionschangedlistener msessionlistener 
clearmediacontroller true 
super onstop 
mmediasessionmanager null 
private void clearmediacontroller boolean clear 
mmediacontroller null 
mmediacontroller unregistercallback mcallback 
mmediacontroller null 
clear 
clearmetadata 
updateplaybackstate null 
private void setmediacontroller nonnull mediacontroller controller 
debug switching controller getpackagename controller 
clearmediacontroller true 
mmediacontroller controller 
mmediacontroller registercallback mcallback 
metadata playback state async 
prevent possible anrs 
mthread sendtask eventupdatemetadata mmediacontroller getsessiontoken 
inheritdoc 
public void sendmediaaction action 
mmediacontroller null 
maybe somebody waiting start player 
this lovely event 
todo check works expected 
mediacontroller broadcastmediaaction mcontext action 
return 
mediacontroller transportcontrols controls mmediacontroller gettransportcontrols 
switch action 
case action_play_pause 
mplaybackstate playbackstate state_playing 
controls pause 
else 
controls play 
break 
case action_stop 
controls stop 
break 
case action_skip_to_next 
controls skiptonext 
break 
case action_skip_to_previous 
controls skiptoprevious 
break 
default 
throw illegalargumentexception 
inheritdoc 
override 
public void seekto long position 
mmediacontroller null 
nothing crash 
return 
mmediacontroller gettransportcontrols seekto position 
inheritdoc 
override 
public long getplaybackbufferedposition 
mmediacontroller null mmediacontroller getplaybackstate null 
nothing crash 
return 
return mmediacontroller getplaybackstate getbufferedposition 
inheritdoc 
override 
public long getplaybackposition 
mmediacontroller null mmediacontroller getplaybackstate null 
nothing crash 
return 
return mmediacontroller getplaybackstate getposition 
clears link mmetadata metadata same calling 
link updatemetadata mediametadata 
with code null parameter 
updatemetadata mediametadata 
private void clearmetadata 
updatemetadata null 
updates link mmetadata metadata from given media metadata class 
this also updates play state 
param data object metadata update from code null clear local metadata 
clearmetadata 
private void updatemetadata nullable mediametadata data 
data null 
mmetadata isempty 
need clear again 
notify subscribers about 
return 
mmetadata clear 
else 
string 

data getstring mediametadata metadata_key_media_id 
catch runtimeexception 
this weird happens some devices 
periodically 

again 
data getstring mediametadata metadata_key_media_id 
catch runtimeexception 
mmetadata clear 
notifyonmetadatachanged 
return 
null equals mmetadata return 
mmetadata 
mmetadata title data getdescription gettitle 
mmetadata artist data gettext mediametadata metadata_key_artist 
mmetadata album data gettext mediametadata metadata_key_album 
mmetadata duration data getlong mediametadata metadata_key_duration 
mmetadata generatesubtitle 
load artwork 
bitmap artwork data getbitmap mediametadata metadata_key_art 
artwork null 
artwork data getbitmap mediametadata metadata_key_album_art 
might still null 
artwork null 
final size mcontext getresources getdimensionpixelsize dimen media_artwork_size 

mmetadata bitmap bitmap createscaledbitmap artwork size size true 
catch outofmemoryerror 
mmetadata bitmap null 
else 
mmetadata bitmap null 
clear previous artwork 
notifyonmetadatachanged 
private void updateplaybackstate nullable playbackstate state 
updateplaybackstate state null playbackstate state_none state getstate 
threading 
static class extends taskqueuethread 
nonnull 
private final reference mediacontroller mmediacontrollerref 
public nonnull mediacontroller 
mmediacontrollerref weakreference 
override 
protected void onhandletask object 
mediacontroller mmediacontrollerref 
null 
mrunning false 
return 
object 
override 
public void sendtask nonnull object 
onhandletask object 
override 
protected boolean islost 
return false 
represents single event 
static abstract class 
public abstract void nonnull mediacontroller 
event seek song specific position 
author artem chepurnoy 
private static class eventupdatemetadata extends 
nonnull 
private final mediasession token mtoken 
nonnull 
private final handler mhandler 
public eventupdatemetadata nonnull mediasession token token 
super 
mhandler handler looper getmainlooper 
mtoken token 
override 
public void nonnull mediacontroller 
final mediacontroller lollipop mediacontroller lollipop 
final mediacontroller source mmediacontroller 
source null mtoken equals source getsessiontoken 
long systemclock elapsedrealtime 
final mediametadata metadata source getmetadata 
final playbackstate playbackstate source getplaybackstate 
long delta systemclock elapsedrealtime 
metadata playback state delta millis 
media controller source getpackagename 
mhandler post runnable 
override 
public void 
updatemetadata metadata 
updateplaybackstate playbackstate 
