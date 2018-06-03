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

package achep acdisplay notifications 
import android annotation targetapi 
import android build 
import android bundle 
import android support annotation nullable 
import android support remoteinput 
import android util 
import java lang reflect constructor 
import java lang reflect invocationtargetexception 
author artem chepurnoy 
public class remoteinpututils 
private static final string remoteinpututils 
targetapi build version_codes kitkat_watch 
nullable 
public static remoteinput tocompat nullable android remoteinput srcarray 
srcarray null return null 
remoteinput result remoteinput srcarray length 

constructor constructor remoteinput class getdeclaredconstructor 
string class charsequence class charsequence class 
boolean class bundle class 
constructor setaccessible true 
srcarray length 
android remoteinput srcarray 
result remoteinput constructor newinstance 
getresultkey getlabel getchoices 
getallowfreeforminput getextras 
catch nosuchmethodexception 
invocationtargetexception 
instantiationexception 
illegalaccessexception 
failed create remote inputs 
return null 
return result 
