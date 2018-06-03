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

package achep acdisplay services 
import android annotation suppresslint 
import android content context 
import android content intent 
import android media audiomanager 
import android media remotecontroller 
import android binder 
import android ibinder 
import android service notification notificationlistenerservice 
import android service notification statusbarnotification 
import android support annotation nonnull 
import android support annotation nullable 
import android util 
import achep acdisplay 
import achep acdisplay 
import achep acdisplay notifications notificationlistener 
import achep base appheap 
import achep base device 
created achep 
author artem chepurnoy 
suppresswarnings deprecation remotecontroller completely outdated 
suppresslint newapi remotecontroller thing 
public class mediaservice extends notificationlistenerservice implements 
remotecontroller onclientupdatelistener 
private static final string mediaservice 
public static mediaservice sservice 
private final notificationlistener mnotificationlistener notificationlistener newinstance 
private final ibinder mbinder 
private audiomanager maudiomanager 
private boolean mregistered 
private remotecontroller mremotecontroller 
private remotecontroller onclientupdatelistener mexternallistener 
public class extends binder 
public mediaservice getservice 
return mediaservice this 
private static boolean isremotecontrollersupported 
return device haskitkatapi device haslollipopapi 
override 
public ibinder onbind nonnull intent intent 
switch intent getaction 
case action_bind_media_control_service 
isremotecontrollersupported 
should never happen normally 
throw runtimeexception supported android version 
return mbinder 
default 
sservice this 
mnotificationlistener onlistenerbind this 
return super onbind intent 
override 
public boolean onunbind nonnull intent intent 
switch intent getaction 
case action_bind_media_control_service 
break 
default 
mnotificationlistener onlistenerunbind this 
sservice null 
break 
return super onunbind intent 
handling notifications 
override 
public void onlistenerconnected 
super onlistenerconnected 
mnotificationlistener onlistenerconnected this 
override 
public void onnotificationposted nonnull statusbarnotification notification 
mnotificationlistener onnotificationposted this notification 
override 
public void onnotificationremoved nonnull statusbarnotification notification 
mnotificationlistener onnotificationremoved this notification 
remote controller 
override 
public void oncreate 
isremotecontrollersupported 
mremotecontroller remotecontroller this this 
maudiomanager audiomanager getsystemservice context audio_service 
override 
public void ondestroy 
isremotecontrollersupported 
setremotecontrollerdisabled 
appheap getrefwatcher watch this 
public void setremotecontrollerenabled 
mregistered 
return 
mregistered maudiomanager registerremotecontroller mremotecontroller 
mregistered 
final size getresources getdimensionpixelsize dimen media_artwork_size 
mremotecontroller setartworkconfiguration size size 
mremotecontroller setsynchronizationmode remotecontroller position_synchronization_check 
else 
error while registering remotecontroller 
public void setremotecontrollerdisabled 
mregistered 
return 
maudiomanager unregisterremotecontroller mremotecontroller 
mregistered false 
public remotecontroller getremotecontroller 
return mremotecontroller 
sets external callback client update events 
public void setclientupdatelistener nullable remotecontroller onclientupdatelistener listener 
mexternallistener listener 
override 
public void onclientchange boolean clearing 
mexternallistener null 
mexternallistener onclientchange clearing 
override 
public void onclientplaybackstateupdate state 
mexternallistener null 
mexternallistener onclientplaybackstateupdate state 
override 
public void onclientplaybackstateupdate state long statechangetimems long currentposms float speed 
mexternallistener null 
mexternallistener onclientplaybackstateupdate state statechangetimems currentposms speed 
override 
public void onclienttransportcontrolupdate transportcontrolflags 
mexternallistener null 
mexternallistener onclienttransportcontrolupdate transportcontrolflags 
override 
public void onclientmetadataupdate remotecontroller metadataeditor metadataeditor 
mexternallistener null 
mexternallistener onclientmetadataupdate metadataeditor 
