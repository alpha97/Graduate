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
import android support test instrumentationregistry 
import android support test runner androidjunit 
import android test instrumentationtestcase 
import android test suitebuilder annotation smalltest 
import achep base utils fileutils 
import junit before 
import junit test 
import junit runner runwith 
import java file 
import java util random 
import static hamcrest corematchers equalto 
import static hamcrest corematchers 
import static junit assert assertthat 
junit unit tests file utils 
author artem chepurnoy 
runwith androidjunit class 
smalltest 
public class fileutilsinsttest extends instrumentationtestcase 
private file mfile 
private string mtext 
before 
public void setup 
mfile file instrumentationregistry getinstrumentation getcontext getfilesdir 
test_file_utils 
random random random 
stringbuilder stringbuilder 
append random nextint 
mtext tostring 
test 
public void test 
test writing file 
asserttrue failed write file fileutils writetofile mfile mtext 
test reading from file 
assertthat mtext equalto fileutils readtextfile mfile 
test removing file 
asserttrue failed delete file fileutils deleterecursive mfile 
asserttrue failed delete file mfile exists 
