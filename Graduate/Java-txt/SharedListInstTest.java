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
import android content context 
import android content sharedpreferences 
import android support annotation nonnull 
import android support test instrumentationregistry 
import android support test runner androidjunit 
import android test instrumentationtestcase 
import android test suitebuilder annotation smalltest 
import achep base content sharedlist 
import junit test 
import junit runner runwith 
import java util arraylist 
junit unit tests shared list 
author artem chepurnoy 
runwith androidjunit class 
smalltest 
public class sharedlistinsttest extends instrumentationtestcase 
test 
public void test 
create strings data 
final initialsize 
arraylist string list arraylist initialsize 
initialsize list double tostring math random 
initialize list 
context context instrumentationregistry getinstrumentation getcontext 
sharedliststring origin sharedliststring context 
string list origin context 
initialsize 
math random list size 
origin remove context list 
list remove 
testing placeholders 
list cute kitten 
origin context list list size 
testing overwriting 
list list 
origin context list list size 
check equality 
sharedliststring restored sharedliststring context 
string list asserttrue restored contains 
saver link string string 
private static class stringsaver extends sharedlist saver string 
private static final string key_str str_ 
inheritdoc 
nonnull 
override 
public sharedpreferences editor nonnull string string 
nonnull sharedpreferences editor editor 
position 
editor putstring key_str position string 
return editor 
inheritdoc 
override 
public string nonnull sharedpreferences prefs position 
return prefs getstring key_str position null 
most simple implementation link achep base content sharedlist shared list 
private static class sharedliststring extends sharedlist string stringsaver 
public static final string pref_name test_shared_list 
protected sharedliststring context context 
super context 
inheritdoc 
nonnull 
override 
protected string getpreferencesfilename 
return pref_name 
inheritdoc 
nonnull 
override 
protected stringsaver oncreatesaver 
return stringsaver 
inheritdoc 
override 
protected boolean isoverwriteallowed nonnull string 
return true 
