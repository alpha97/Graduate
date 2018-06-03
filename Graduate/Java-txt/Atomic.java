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

package achep acdisplay 
import android support annotation nonnull 
import android support annotation nullable 
import android util 
import static achep base build debug 
class atomic handling start stop events 
author artem chepurnoy 
public final class atomic 
private final callback mcallback 
private final string mtag 
private volatile boolean mstarted 
public interface callback 
void onstart object objects 
void onstop object objects 
public atomic nonnull callback callback 
this callback null 
public atomic nonnull callback callback nullable string 
mcallback callback 
mtag null getclass getsimplename 
public void react boolean start object objects 
start 
start objects 
else 
stop objects 
public void start object objects 
synchronized this 
mstarted 
mstarted true 
mcallback onstart objects 
else 
debug mtag starting already started 
public void stop object objects 
synchronized this 
mstarted 
mstarted false 
mcallback onstop objects 
else 
debug mtag stopping already stopped 
public boolean isrunning 
synchronized this 
return mstarted 
