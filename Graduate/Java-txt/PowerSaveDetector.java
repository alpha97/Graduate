package achep base utils power 
import android annotation targetapi 
import android content broadcastreceiver 
import android content context 
import android content intent 
import android content intentfilter 
import android build 
import android powermanager 
import android support annotation nonnull 
import achep acdisplay atomic 
import achep base device 
import achep base interfaces ipowersave 
import achep base interfaces isubscriptable 
import java util arraylist 
import static achep base build debug_power_saving 
author artem chepurnoy 
public abstract class powersavedetector implements 
isubscriptable powersavedetector onpowersavechanged 
ipowersave 
private static boolean spowersavemode 
nonnull 
public static powersavedetector newinstance nonnull context context 
return device haslollipopapi 
powersavelollipop context 
powersavecompat context 
returns code true device currently power save mode 
when this mode applications should reduce their functionality 
order conserve battery much possible 
return code true device currently power save mode code false otherwise 
public static boolean ispowersaving 
return spowersavemode 
inverse function link ispowersavemode 
hate using construction this 
method created 
public static boolean isnotpowersaving 
return ispowersaving 
protected final arraylist onpowersavechanged mlisteners 
protected final context mcontext 
protected boolean mpowersavemode 
author artem chepurnoy 
public interface onpowersavechanged 
void onpowersavechanged boolean powersaving 
private powersavedetector nonnull context context 
mlisteners arraylist 
mcontext context 
inheritdoc 
override 
public void registerlistener nonnull onpowersavechanged listener 
mlisteners listener 
inheritdoc 
override 
public void unregisterlistener nonnull onpowersavechanged listener 
mlisteners remove listener 
public abstract void start 
public abstract void stop 
inheritdoc 
override 
public boolean ispowersavemode 
return mpowersavemode 
inheritdoc 
override 
public boolean isnotpowersavemode 
return isnotpowersaving 
protected void setpowersavemode boolean 
debug_power_saving true 
mpowersavemode return 
spowersavemode mpowersavemode 
notifylisteners 
private void notifylisteners 
onpowersavechanged listener mlisteners 
listener onpowersavechanged mpowersavemode 
author artem chepurnoy 
targetapi build version_codes lollipop 
private static class powersavelollipop extends powersavedetector 
private final powermanager mpowermanager 
private final broadcastreceiver mreceiver 
broadcastreceiver 
override 
public void onreceive context context intent intent 
switch intent getaction 
case powermanager action_power_save_mode_changed 
setpowersavemode mpowermanager ispowersavemode 
break 
nonnull 
private final atomic matomic atomic atomic callback 
override 
public void onstart object objects 
intentfilter intentfilter intentfilter 
intentfilter addaction powermanager action_power_save_mode_changed 
mcontext registerreceiver mreceiver intentfilter 
setpowersavemode mpowermanager ispowersavemode 
override 
public void onstop object objects 
mcontext unregisterreceiver mreceiver 
public powersavelollipop nonnull context context 
super context 
mpowermanager powermanager context getsystemservice context power_service 
override 
public void start 
matomic start 
override 
public void stop 
matomic stop 
author artem chepurnoy 
private static class powersavecompat extends powersavedetector 
public powersavecompat nonnull context context 
super context 
override 
public void start empty 
override 
public void stop empty 
