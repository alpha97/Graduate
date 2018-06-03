copyright android open source project 
licensed under apache license version license 
this file except compliance with license 
obtain copy license 
http apache licenses license 
unless required applicable agreed writing software 
distributed under license distributed basis 
without warranties conditions kind either express implied 
license specific language governing permissions 
limitations under license 
package achep base utils 
import android activity 
import android content context 
import android content intent 
import android preference preference 
import android preference preferencemanager 
import android preference preferencescreen 
import android support annotation nonnull 
import java lang reflect constructor 
import java lang reflect field 
import java lang reflect invocationhandler 
import java lang reflect method 
import java lang reflect proxy 
created artem chepurnoy 
public final class preferencemanagerutils 
interface definition callback invoked when 
link android preference preference hierarchy rooted this link android preference preferencescreen 
clicked 
public interface onpreferencetreeclicklistener 
called when preference tree rooted this 
link android preference preferencescreen been clicked 
param preferencescreen link android preference preferencescreen that 
preference located 
param preference preference that clicked 
return whether click handled 
boolean onpreferencetreeclick preferencescreen preferencescreen preference preference 
nonnull 
public static preferencemanager newinstance nonnull activity activity firstrequestcode 

constructor preferencemanager preferencemanager class 
getdeclaredconstructor activity class class 
setaccessible true 
return newinstance activity firstrequestcode 
catch exception 
throw runtimeexception 
sets callback invoked when link android preference preference 
hierarchy rooted this link android preference preferencemanager clicked 
param listener callback invoked 
public static void setonpreferencetreeclicklistener nonnull preferencemanager manager 
final preferencemanagerutils onpreferencetreeclicklistener listener 

field onpreferencetreeclicklistener preferencemanager class 
getdeclaredfield monpreferencetreeclicklistener 
onpreferencetreeclicklistener setaccessible true 
listener null 
object proxy proxy newproxyinstance 
onpreferencetreeclicklistener gettype getclassloader 
class onpreferencetreeclicklistener gettype 
invocationhandler 
public object invoke object proxy method method object args 
method getname equals onpreferencetreeclick 
preferencescreen preferencescreen args 
preference preference args 
return listener onpreferencetreeclick 
else 
return null 
onpreferencetreeclicklistener manager proxy 
else 
onpreferencetreeclicklistener manager null 
catch exception 
throw runtimeexception 
inflates preference hierarchy from preference hierarchies 
link android activity activities that match given link android content intent 
link android activity defines preference hierarchy with meta data using 
link android preference preferencemanager metadata_key_preferences 

preference hierarchy given preference hierarchies will 
merged 
param queryintent intent match activities 
param rootpreferences optional existing hierarchy merge 
hierarchies into 
return root hierarchy provided hierarchy 
root 
public static preferencescreen inflatefromintent nonnull preferencemanager manager 
intent queryintent 
preferencescreen rootpreferences 

method preferencemanager class getdeclaredmethod inflatefromintent 
intent class 
preferencescreen class 
setaccessible true 
return preferencescreen invoke manager queryintent rootpreferences 
catch exception 
throw runtimeexception 
inflates preference hierarchy from preference hierarchy 
given preference hierarchies will merged 
param context context resource 
param resid resource inflate 
param rootpreferences optional existing hierarchy merge 
hierarchies into 
return root hierarchy provided hierarchy 
root 
public static preferencescreen inflatefromresource nonnull preferencemanager manager 
context context resid 
preferencescreen rootpreferences 

method preferencemanager class getdeclaredmethod inflatefromresource 
context class class preferencescreen class 
setaccessible true 
return preferencescreen invoke manager context resid rootpreferences 
catch exception 
throw runtimeexception 
returns root preference hierarchy managed this class 
return link android preference preferencescreen object that root hierarchy 
public static preferencescreen getpreferencescreen nonnull preferencemanager manager 

method preferencemanager class getdeclaredmethod getpreferencescreen 
setaccessible true 
return preferencescreen invoke manager 
catch exception 
throw runtimeexception 
called link android preference preferencemanager dispatch subactivity result 
public static void dispatchactivityresult nonnull preferencemanager manager 
requestcode resultcode 
intent data 

method preferencemanager class getdeclaredmethod dispatchactivityresult 
class class intent class 
setaccessible true 
invoke manager requestcode resultcode data 
catch exception 
throw runtimeexception 
called link android preference preferencemanager dispatch activity stop 
event 
public static void dispatchactivitystop nonnull preferencemanager manager 

method preferencemanager class getdeclaredmethod dispatchactivitystop 
setaccessible true 
invoke manager 
catch exception 
throw runtimeexception 
called link android preference preferencemanager dispatch activity destroy 
event 
public static void dispatchactivitydestroy nonnull preferencemanager manager 

method preferencemanager class getdeclaredmethod dispatchactivitydestroy 
setaccessible true 
invoke manager 
catch exception 
throw runtimeexception 
sets root preference hierarchy 
param preferencescreen root link android preference preferencescreen preference hierarchy 
return whether link android preference preferencescreen given different than previous 
public static boolean setpreferences nonnull preferencemanager manager 
preferencescreen preferencescreen 

method preferencemanager class 
getdeclaredmethod setpreferences preferencescreen class 
setaccessible true 
return boolean invoke manager preferencescreen 
catch exception 
throw runtimeexception 
