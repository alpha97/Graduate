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

package achep base tests 
import android looper 
import android support annotation nonnull 
import android support annotation nullable 
author artem chepurnoy 
final class checkimpl extends check 
override 
public void istrue boolean bool 
istrue bool should true 
override 
public void istrue boolean bool nonnull string message 
bool throw runtimeexception message 
override 
public void istrue value 
istrue value should zero 
override 
public void istrue value nonnull string message 
value throw runtimeexception message 
override 
public void isfalse boolean bool 
isfalse bool should false 
override 
public void isfalse boolean bool nonnull string message 
bool throw runtimeexception message 
override 
public void isnull nullable object object 
isnull object should null 
override 
public void isnull nullable object object nonnull string message 
object null throw runtimeexception message 
override 
public void isnonnull nonnull object object 
isnonnull object should null 
override 
public void isnonnull nonnull object object nonnull string message 
noinspection constantconditions 
object null throw runtimeexception message 
override 
public void isinmainthread 
isinmainthread should called main thread 
override 
public void isinmainthread nonnull string message 
looper mylooper looper getmainlooper 
throw runtimeexception message 
