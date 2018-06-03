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
import android support annotation nullable 
import android util 
import java bufferedreader 
import java bytearrayinputstream 
import java file 
import java fileoutputstream 
import java filereader 
import java ioexception 
import java inputstream 
import java outputstream 
import java outputstreamwriter 
import static achep base build debug 
utils related file system files maybe reading buffers 
author artem chepurnoy 
public class fileutils 
private static final string fileutils 
private static final file_delete_tries 
deletes files from given directory recursively 
return code true files were deleted successfully 
exits code false otherwise given file null 
public static boolean deleterecursive nullable file file 
file null 
file exists return true 
file children 
file isdirectory children file listfiles null children length 
file child children 
deleterecursive child 
else 
file_delete_tries 
file delete 
debug removed file file 
return true 
return false 
writes given text file deletes original file 
param file file write 
return code true succeed code false failed file state undefined 
public static boolean writetofile nonnull file file nonnull charsequence text 
file exists 
deleterecursive file 
return false 
string errormessage 
fileoutputstream null 
outputstreamwriter null 

fileoutputstream file 
outputstreamwriter 
append text 
return true 
catch ioexception 
errormessage failed write file 
finally 

null 
close 
else null 
close 
catch ioexception 
errormessage failed close stream 
debug errormessage file file 
return false 
public static void writetofilefrom 
nonnull file file 
nonnull inputstream 
throws ioexception 
ioutils readfullywritetooutputstream fileoutputstream file 
public static boolean writetofileappend nonnull file file nonnull charsequence text 

noinspection resultofmethodcallignored 
file createnewfile 
catch ioexception 
failed create file file file getname 
return false 
outputstream null 
inputstream null 

fileoutputstream file true 
bytearrayinputstream text tostring getbytes 
read 
final byte buffer byte 
read read buffer buffer length 
read write buffer read 
while read 
return true 
catch exception 
failed append file file file getname 
printstacktrace 
finally 
close stream 
null 
close 
catch ioexception 
failed close stream 
printstacktrace 
close stream 
null 
close 
catch ioexception 
failed close stream 
printstacktrace 
return false 
return text read from given file code null 
file does exist reading failed 
nullable 
public static string readtextfile nonnull file file 
file exists return null 

bufferedreader bufferedreader bufferedreader filereader file 
return ioutils readtextfrombufferedreader bufferedreader 
catch ioexception 
debug failed read file file 
return null 
