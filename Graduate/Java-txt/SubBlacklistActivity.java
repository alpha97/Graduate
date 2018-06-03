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

package achep acdisplay activities settings 
import android fragmentmanager 
import android util 
import android view menu 
level settings activity handle single pane double pane layout 
public class subblacklistactivity extends blacklistactivity 
private static final string subblacklist 
override 
public boolean onnavigateup 
popfragment 
finish 
return true 
override 
protected boolean isvalidfragment string fragmentname 
launching fragment fragmentname 
return true 
override 
public boolean oncreateoptionsmenu menu menu 
return false 
private boolean popfragment 
fragmentmanager getfragmentmanager 
getbackstackentrycount 
popbackstack 
return true 
return false 
