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
import android support annotation nonnull 
import android support annotation xmlres 
import achep acdisplay 
import achep acdisplay services activemode activemodeservice 
import achep acdisplay fragments settings activemodesettings 
import achep acdisplay fragments settings interfacesettings 
import achep acdisplay fragments settings keyguardsettings 
import achep acdisplay fragments settings moresettings 
import achep acdisplay fragments settings notificationsettings 
import achep base dashboard dashboardtile 
import achep base activities settingsactivity 
import static achep base build debug 
created artem chepurnoy 
public class settings extends settingsactivity 
private static final string entry_fragments 
keyguardsettings class getname 
activemodesettings class getname 
notificationsettings class getname 
interfacesettings class getname 
moresettings class getname 
override 
protected boolean isvalidfragment nonnull string fragmentname 
almost fragments wrapped this 
except that have their activities 
string fragment entry_fragments 
fragment equals fragmentname 
return true 
return false 
xmlres 
override 
public getdashboardresource 
return settings_dashboard 
override 
protected boolean istilesupported nonnull dashboardtile tile 
switch tile 
case dev_settings 
return debug 
case active_settings 
return activemodeservice issupported this 
return true 
