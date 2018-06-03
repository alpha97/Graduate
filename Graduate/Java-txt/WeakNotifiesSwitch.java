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

package achep acdisplay services switches 
import android content context 
import android handler 
import android systemclock 
import android support annotation nonnull 
import achep acdisplay notifications notificationpresenter 
import achep acdisplay notifications opennotification 
import achep acdisplay services switch 
import achep base content configbase 
author artem chepurnoy 
achep acdisplay fragments settings activemodesettings 
achep acdisplay fragments settings keyguardsettings 
public final class weaknotifiesswitch extends switch optional implements 
notificationpresenter onnotificationlistchangedlistener 
private static final duration 
private notificationpresenter mnotificationpresenter 
private boolean mtriggercallpending 
private long mtriggertimestamp 
nonnull 
private final handler mhandler handler 
nonnull 
private final runnable mrunnable runnable 
override 
public void 
requestinactiveinternal 
public weaknotifiesswitch 
nonnull context context 
nonnull callback callback 
nonnull configbase option option boolean isoptioninverted 
super context callback option isoptioninverted 
override 
public void oncreate 
super oncreate 
mnotificationpresenter notificationpresenter getinstance 
mnotificationpresenter registerlistener this 
override 
public void ondestroy 
mnotificationpresenter unregisterlistener this 
super ondestroy 
override 
public boolean isactiveinternal 
return systemclock elapsedrealtime mtriggertimestamp duration 
override 
public void onnotificationlistchanged nonnull notificationpresenter 
opennotification osbn 
event boolean islasteventinsequence 
event notificationpresenter event_removed 
islasteventinsequence 
triggernotification 
else mtriggercallpending true 
else islasteventinsequence mtriggercallpending 
triggernotification 
private void triggernotification 
mtriggercallpending false 
mtriggertimestamp systemclock elapsedrealtime 
mhandler removecallbacks mrunnable 
mhandler postdelayed mrunnable duration 
