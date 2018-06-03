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
import android content context 
import android content intent 
import android support annotation nonnull 
import android support media session playbackstatecompat 
import android util 
import android view keyevent 
import achep acdisplay atomic 
import achep base device 
import achep base interfaces isubscriptable 
import achep base tests check 
import java util arraylist 
import timber timber 
import static achep base build debug 
allows interact with ongoing media session media buttons 
other commands sent session callback registered 
receive updates from session such metadata play state changes 
author artem chepurnoy 
public abstract class mediacontroller implements 
atomic callback isubscriptable mediacontroller medialistener 
protected static final string mediacontroller 
public static final action_skip_to_next 
public static final action_skip_to_previous 
public static final action_play_pause 
public static final action_stop 
creates instance created working this device 
android version 
return instance 
nonnull 
public static mediacontroller newinstance nonnull activity activity 
device haslollipopapi 
return mediacontroller lollipop activity 
else device haskitkatapi 
return mediacontroller kitkat activity 
return mediacontroller empty activity 
emulates hardware buttons click broadcast system 
android view keyevent 
public static void broadcastmediaaction nonnull context context action 
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
intent intent intent intent action_media_button 
keyevent keydown keyevent keyevent action_down keycode 
keyevent keyup keyevent keyevent action_up keycode 
context sendorderedbroadcast intent putextra intent extra_key_event keydown null 
context sendorderedbroadcast intent putextra intent extra_key_event keyup null 
callback receiving updates from session callback 
registered using link registerlistener medialistener 
public interface medialistener 
override handle changes current metadata warning must call 
link registerlistener medialistener link unregisterlistener medialistener 
from here otherwise will crash 
param metadata current metadata session 
achep acdisplay services media metadata 
getmetadata 
void onmetadatachanged nonnull metadata metadata 
override handle changes playback state warning must call 
link registerlistener medialistener link unregisterlistener medialistener 
from here otherwise will crash 
param state playback state session 
getplaybackstate 
void onplaybackstatechanged state 
nonnull 
private final atomic matomic 
nonnull 
protected final context mcontext 
nonnull 
protected final arraylist medialistener mlisteners 
nonnull 
protected final metadata mmetadata 
protected mplaybackstate 
protected mediacontroller nonnull context context 
mcontext context 
mlisteners arraylist 
mmetadata metadata 
matomic atomic this 
public void start 
timber starting media controller was_running matomic isrunning 
matomic start 
public void stop 
timber stopping media controller was_running matomic isrunning 
matomic stop 
inheritdoc 
override 
public void onstart object objects empty 
inheritdoc 
override 
public void onstop object objects 
mplaybackstate playbackstatecompat state_none 
inheritdoc 
override 
public void registerlistener nonnull medialistener listener 
synchronized this 
mlisteners listener 
inheritdoc 
override 
public void unregisterlistener nonnull medialistener listener 
synchronized this 
mlisteners remove listener 
nonnull 
public mediacontroller asyncwrap 
return this instanceof mediacontrollerasyncwrapper 
this 
mediacontrollerasyncwrapper this 
sends media action following 

link action_play_pause 
link action_stop 
link action_skip_to_next 
link action_skip_to_previous 

public abstract void sendmediaaction action 
move location media stream 
param position position move milliseconds 
public abstract void seekto long position 
current buffered position this farthest playback point 
that reached from current position using only buffered content 
return current buffered position code something went wrong 
public abstract long getplaybackbufferedposition 
current playback position 
return current playback position code something went wrong 
public abstract long getplaybackposition 
protected void notifyonmetadatachanged 
check getinstance isinmainthread 
debug notifying metadata state changed 
synchronized this 
medialistener listener mlisteners 
listener onmetadatachanged mmetadata 
protected void updateplaybackstate playbackstate 
mplaybackstate mplaybackstate playbackstate return 
notifyonplaybackstatechanged 
protected void notifyonplaybackstatechanged 
check getinstance isinmainthread 
debug notifying playback state changed 
synchronized this 
medialistener listener mlisteners 
listener onplaybackstatechanged mplaybackstate 
current metadata this session 
return link metadata metadata playing track 
nonnull 
public metadata getmetadata 
return mmetadata 
current state playback following 

link android media session playbackstate state_none 
link android media session playbackstate state_stopped 
link android media session playbackstate state_playing 
link android media session playbackstate state_paused 
link android media session playbackstate state_fast_forwarding 
link android media session playbackstate state_rewinding 
link android media session playbackstate state_buffering 
link android media session playbackstate state_error 

also link android support media session playbackstatecompat 
access those values 
public getplaybackstate 
return mplaybackstate 
