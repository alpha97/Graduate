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
import android handler 
import android message 
import android support annotation nonnull 
import android support media session playbackstatecompat 
import achep acdisplay config 
import achep base async weakhandler 
import achep base content configbase 
import achep base interfaces isubscriptable 
import achep base tests check 
import java util arraylist 
import java util list 
helper class deciding when show media controls widget 
author artem chepurnoy 
public class mediacontrolshelper implements 
mediacontroller medialistener 
isubscriptable mediacontrolshelper callback 
configbase onconfigchangedlistener 
private static final delay 
nonnull 
private final handler mhandler 
nonnull 
private final list callback mlisteners 
nonnull 
private final mediacontroller mmediacontroller 
private boolean mshowing 
private boolean mstarted 
private boolean menabled 
public interface callback 
void onstatechanged boolean showing 
public mediacontrolshelper nonnull mediacontroller 
mhandler this 
mlisteners arraylist 
mmediacontroller 
mshowing false 
public void start 
config getinstance registerlistener this 
mmediacontroller registerlistener this 
menabled config getinstance ismediawidgetenabled mmediacontroller start 
mstarted true 
initialize 
fixme need ping playback state here 
onplaybackstatechanged mmediacontroller getplaybackstate 
public void stop 
mstarted false 
menabled mmediacontroller stop 
mmediacontroller unregisterlistener this 
config getinstance unregisterlistener this 
override 
public void registerlistener nonnull callback listener 
mlisteners listener 
override 
public void unregisterlistener nonnull callback listener 
mlisteners remove listener 
override 
public void onmetadatachanged nonnull metadata metadata 
this event handled 
media widget 
override 
public void onplaybackstatechanged state 
check getinstance isinmainthread 
switch state 
case playbackstatecompat state_playing 
mhandler removemessages msg_hide_media_widget 
mshowing 
mshowing true 
notifyonstatechanged 
break 
default 
mshowing 
delay state playbackstatecompat state_none delay 
mhandler sendemptymessagedelayed msg_hide_media_widget delay 
break 
return code true media controls should shown 
code false otherwise 
public boolean isshown 
return mshowing 
private void notifyonstatechanged 
callback callback mlisteners 
callback onstatechanged mshowing 
override 
public void onconfigchanged nonnull configbase config 
nonnull string 
nonnull object value 
switch 
case config key_media_widget 
menabled boolean value 
mstarted 
menabled 
mmediacontroller start 
else mmediacontroller stop 
break 
nonnull 
public mediacontroller getmediacontroller 
return mmediacontroller 
classes 
author artem chepurnoy 
private static class extends weakhandler mediacontrolshelper 
private static final msg_hide_media_widget 
public nonnull mediacontrolshelper 
super 
override 
protected void onhandlemassage nonnull mediacontrolshelper message 
switch what 
case msg_hide_media_widget 
mshowing false 
notifyonstatechanged 
break 
