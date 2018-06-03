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

package achep base utils logcat 
import android support annotation nullable 
import achep base utils ioutils 
import stericson roottools roottools 
import java bufferedreader 
import java ioexception 
import java inputstreamreader 
author artem chepurnoy 
public class logcat 
captures application logcat 
nullable 
public static string capture 
final string command 
roottools isaccessgiven 
command string logcat threadtime 
else command string logcat threadtime 
bufferedreader null 

process process runtime getruntime exec command 
bufferedreader inputstreamreader process getinputstream 
return ioutils readtextfrombufferedreader 
catch ioexception 
return null 
finally 
null 

close 
catch ioexception unlucky 
