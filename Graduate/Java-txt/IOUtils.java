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

package achep base utils 
import android support annotation nonnull 
import java bufferedreader 
import java ioexception 
import java inputstream 
import java outputstream 
public class ioutils 
public static void readfullywritetooutputstream 
nonnull inputstream 
nonnull outputstream 
throws ioexception 

byte buffer byte 
bytesread 
while bytesread read buffer 
write buffer bytesread 
flush 
finally 
close 
reads text from given link bufferedreader line line 
return text from given link bufferedreader 
throws ioexception 
nonnull 
public static string readtextfrombufferedreader nonnull bufferedreader bufferedreader throws ioexception 
store lines string builder 
reduce memory using 
final stringbuilder body stringbuilder 
string nextline 

while nextline bufferedreader readline null 
body append nextline 
body append 
body length 

body deletecharat 
finally 
bufferedreader close 
return body tostring 
