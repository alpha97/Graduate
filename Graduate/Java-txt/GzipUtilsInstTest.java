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

package achep acdisplay 
import android support test runner androidjunit 
import android test instrumentationtestcase 
import android test suitebuilder annotation smalltest 
import achep base utils gziputils 
import junit before 
import junit test 
import junit runner runwith 
import java util random 
junit unit tests gzip utils 
author artem chepurnoy 
runwith androidjunit class 
smalltest 
public class gziputilsinsttest extends instrumentationtestcase 
private string mtext 
before 
public void setup 
random random random 
stringbuilder stringbuilder 
append random nextint 
mtext tostring 
test 
public void test 
string compressed gziputils compress mtext 
string decompressed gziputils decompress compressed 
assertequals mtext decompressed 
