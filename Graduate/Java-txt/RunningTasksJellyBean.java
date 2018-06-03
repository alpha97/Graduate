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

package achep acdisplay utils tasks 
import android annotation targetapi 
import android activitymanager 
import android content context 
import android build 
import android support annotation nonnull 
import android support annotation nullable 
import java util list 
author artem chepurnoy 
targetapi build version_codes jelly_bean 
class runningtasksjellybean extends runningtasks 
inheritdoc 
suppresswarnings deprecation 
nullable 
public string getrunningtaskstop nonnull context context 
activitymanager activitymanager context getsystemservice context activity_service 
list activitymanager runningtaskinfo tasks getrunningtasks 
return tasks null tasks isempty null tasks topactivity getpackagename 
