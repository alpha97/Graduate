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
import android support annotation nullable 
import android util base 
import android util 
import java bytearrayinputstream 
import java bytearrayoutputstream 
import java ioexception 
import java util gzipinputstream 
import java util gzipoutputstream 
import static achep base build debug 
created artem chepurnoy 
public class gziputils 
private static final string gziputils 
private static final buffer_size 
nullable 
public static string compress string input 
byte bytes null 
bytearrayoutputstream null 
gzipoutputstream null 
final size input length 

bytearrayoutputstream size 
gzipoutputstream 
write input getbytes 
close 
catch ioexception 
return null 
finally 

null close 
null 
bytes tobytearray 
close 
catch ioexception 
printstacktrace 
convert bytes string 
assert bytes null 
string output base encodetostring bytes base default 
print debug info 
debug 
final float rate float output length size 
gzip compress rate float tostring rate 
return output 
nullable 
public static string decompress string input 
stringbuilder stringbuilder 
bytearrayinputstream null 
gzipinputstream null 

final byte bytes base decode input base default 
bytearrayinputstream bytes 
gzipinputstream buffer_size 
cache 
final byte data byte buffer_size 
while cache read data 
append string data cache 
catch ioexception 
return null 
finally 

null close 
null close 
catch ioexception 
printstacktrace 
return tostring 
