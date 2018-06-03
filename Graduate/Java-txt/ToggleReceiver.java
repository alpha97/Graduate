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

package achep acdisplay plugins powertoggles 
import android content context 
import android support annotation nonnull 
import android util 
import achep acdisplay config 
import achep base content configbase 
import painless powertogglesplugin 
import static achep base build debug 
acdisplay toggle plugin powertoggles http powertoggles 
author artem chepurnoy 
public class togglereceiver extends powertogglesplugin implements configbase onconfigchangedlistener 
private static final string togglereceiver 
object monitor garbage collector 
this possible only because config wraps listeners 
weak references changes will memory leak 
private final object dfinilizer object 
override 
protected void finalize throws throwable 

config getinstance unregisterlistener togglereceiver this 
debug registering toggle receiver from config 
finally 
super finalize 
public togglereceiver 
config getinstance registerlistener this 
override 
protected void changestate context context boolean newstate 
config getinstance setenabled context newstate null 
override 
public void onconfigchanged nonnull configbase config 
nonnull string 
nonnull object value 
switch 
case config key_enabled 
sendstateupdate config getcontext boolean value 
break 
