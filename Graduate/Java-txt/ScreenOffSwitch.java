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
import android content broadcastreceiver 
import android content context 
import android content intent 
import android content intentfilter 
import android support annotation nonnull 
import achep acdisplay services switch 
import achep base utils power powerutils 
prevents link achep acdisplay services switchservice from working 
while screen turned 
author artem chepurnoy 
public final class screenoffswitch extends switch 
private final broadcastreceiver mreceiver broadcastreceiver 
override 
public void onreceive context context intent intent 
switch intent getaction 
case intent action_screen_on 
requestinactive 
break 
case intent action_screen_off 
requestactive 
break 
public screenoffswitch nonnull context context nonnull callback callback 
super context callback 
override 
public void oncreate 
intentfilter intentfilter intentfilter 
intentfilter addaction intent action_screen_on 
intentfilter addaction intent action_screen_off 
intentfilter setpriority intentfilter system_high_priority 
getcontext registerreceiver mreceiver intentfilter 
override 
public void ondestroy 
getcontext unregisterreceiver mreceiver 
override 
public boolean isactive 
return powerutils isscreenon getcontext 
