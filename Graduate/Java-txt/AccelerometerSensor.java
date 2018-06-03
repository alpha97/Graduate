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

package achep acdisplay services activemode sensors 
import android hardware sensor 
import android hardware sensormanager 
import android support annotation nonnull 
import android util 
import achep acdisplay services activemode activemodesensor 
import java lang weakreference 
import jarofgreen shakedetector 
import static achep base build debug 
basing results accelerometer sensor notifies when 
link achep acdisplay activities acdisplayactivity acdisplay 
should shown 
author artem chepurnoy 
public final class accelerometersensor extends activemodesensor consuming implements 
shakedetector listener 
private static final string accelerometersensor 
private static weakreference accelerometersensor saccelerometersensorweak 
private final shakedetector mshakedetector 
private accelerometersensor 
super 
mshakedetector shakedetector this 
nonnull 
public static accelerometersensor getinstance 
accelerometersensor sensor saccelerometersensorweak null 
saccelerometersensorweak null 
sensor null 
sensor accelerometersensor 
saccelerometersensorweak weakreference sensor 
return sensor 
override 
public gettype 
return sensor type_accelerometer 
inheritdoc 
override 
public getremainingtime 
return 
override 
public void onstart nonnull sensormanager sensormanager 
debug starting accelerometer sensor 
mshakedetector start sensormanager 
override 
public void onstop 
debug stopping accelerometer sensor 
mshakedetector stop 
called shake detected 
override 
public void onshakedetected 
debug hearing shake 
requestwakeup 
