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

package achep base activities 
import android support annotation nonnull 
import android util 
import achep base dashboard dashboardtile 
stub class showing settings main settings class 
since special singletask class 
public class subsettings extends settingsactivity 
override 
public boolean onnavigateup 
finish 
return true 
override 
protected boolean isvalidfragment nonnull string fragmentname 
subsettings launching fragment fragmentname 
return true 
override 
protected boolean istilesupported nonnull dashboardtile tile 
return false 
