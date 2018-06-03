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

package achep acdisplay supervisor 
import android support annotation nonnull 
import android support annotation nullable 
import achep base interfaces isubscriptable 
created artem chepurnoy 
public abstract class presenter implements isubscriptable presenter state 
nonnull 
public static presenter newinstance 
throw runtimeexception 
public enum state 
unknown 
screen turned acdisplay awaiting 
just below darkness 
idle 
shown_mode_active 
shown_mode_passive 
acdisplay activity destroyed 
dead 
nonnull 
private state mstate state unknown 
return current state acdisplay 
nonnull 
public state getstate 
return mstate 
protected void setstate nonnull state state 
mstate state 
requests 
public abstract void requeststate nonnull state state nullable extras extras 
callback 
callback link linked activity 
author artem chepurnoy 
public interface callback 
extras 
details launch 
author artem chepurnoy 
public static final class extras 
public final string data 
public extras nullable string data 
this data data 
