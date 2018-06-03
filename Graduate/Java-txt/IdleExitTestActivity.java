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

package achep acdisplay activities tests 
import android content context 
import android graphics color 
import android hardware sensormanager 
import android bundle 
import android support annotation nonnull 
import android view gravity 
import android view view 
import android view viewgroup 
import android widget linearlayout 
import android widget textview 
import achep acdisplay services activemode detectors idleexitdetector 
activity testing debugging shake algorithms background 
idle mode green shake 
author artem chepurnoy 
public class idleexittestactivity extends testactivity implements view onclicklistener 
nonnull 
private final idleexitdetector listener mshakedetectorlistener 
idleexitdetector listener 
override 
public void onshakedetected 
mtextview setbackgroundcolor color green 
nonnull 
private final idleexitdetector mshakedetector 
idleexitdetector mshakedetectorlistener 
private textview mtextview 
override 
protected void oncreate bundle savedinstancestate 
super oncreate savedinstancestate 
linearlayout linearlayout this 
setorientation linearlayout vertical 
setlayoutparams linearlayout layoutparams 
viewgroup layoutparams match_parent 
viewgroup layoutparams match_parent 
setpadding 
mtextview oncreatetextview 
mtextview settext shake detector 
addview mtextview 
setcontentview 
override 
protected void onresume 
super onresume 
sensormanager sensormanager sensormanager getsystemservice context sensor_service 
mshakedetector start sensormanager 
override 
protected void onpause 
mshakedetector stop 
super onpause 
nonnull 
private textview oncreatetextview 
linearlayout layoutparams linearlayout layoutparams 
viewgroup layoutparams match_parent 
weight 
weight 
textview textview textview this 
textview setlayoutparams 
textview setonclicklistener this 
textview setgravity gravity center 
textview setbackgroundcolor color 
return textview 
inheritdoc 
override 
public void onclick view 
setbackgroundcolor color 
