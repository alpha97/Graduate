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

package achep acdisplay fragments 
import android activity 
import android content context 
import android hardware sensor 
import android hardware sensorevent 
import android hardware sensoreventlistener 
import android hardware sensormanager 
import android handler 
import android message 
import achep base fragments leakcanary leakwatchfragment 
fragment that listens proximity sensor know 
when turn screen 

please note that must 
link setlistener pocketfragment onsleeprequestlistener initialize listener 
before attaching fragment 

author artem chepurnoy 
setlistener pocketfragment onsleeprequestlistener 
public class pocketfragment extends leakwatchfragment implements sensoreventlistener 
public static final string pocketfragment 
private static final sleep_delay 
private static final msg_sleep 
private sensormanager msensormanager 
private sensor mproximitysensor 
private boolean mproximityavailable 
private boolean mnear 
private boolean mfirstchange 
private float mmaximumrange 
private handler mhandler handler 
override 
public void handlemessage message 
super handlemessage 
switch what 
case msg_sleep 
mlistener null 
mlistener onsleeprequest 
break 
private onsleeprequestlistener mlistener 
interface definition callback invoked 
when device been pocket 
public interface onsleeprequestlistener 
called when parent activity sleep because 
pocket this moment 
boolean onsleeprequest 
public static pocketfragment newinstance 
return pocketfragment 
public pocketfragment setlistener onsleeprequestlistener listener 
mlistener listener 
return this 
override 
public void onattach activity activity 
super onattach activity 
msensormanager sensormanager activity getsystemservice context sensor_service 
mproximitysensor msensormanager getdefaultsensor sensor type_proximity 
mproximityavailable mproximitysensor null 
mproximityavailable 
mmaximumrange mproximitysensor getmaximumrange 
override 
public void onresume 
super onresume 
mproximityavailable 
msensormanager registerlistener this mproximitysensor sensormanager sensor_delay_normal 
mfirstchange true 
mnear false 
override 
public void onpause 
super onpause 
mhandler removecallbacksandmessages null 
msensormanager unregisterlistener this 
override 
public void ondetach 
super ondetach 
msensormanager null 
mproximitysensor null 
override 
public void onsensorchanged sensorevent event 
final float distance event values 
final boolean isnear distance mmaximumrange distance 
final boolean changed mnear mnear isnear mfirstchange 
changed 
well just cause proximity sensor always eventual 
this should happen knows found maximum 
range buggy enough 
return 
mhandler removecallbacksandmessages null 
isnear 
return 
mhandler sendemptymessagedelayed msg_sleep sleep_delay 
override 
public void onaccuracychanged sensor sensor unused 
