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
import java lang reference 
import java util arraylist 
import java util 
import java util concurrent concurrenthashmap 
created artem chepurnoy 
public abstract class refcachebase 
nonnull 
private final charsequence reference mcache concurrenthashmap 
public final void nonnull charsequence nonnull object 
synchronized this 
mcache oncreatereference object 
nullable 
public final remove nonnull charsequence 
synchronized this 
reference mcache remove 
null 
cleandeadentries 
return null 
return 
nullable 
public final nonnull charsequence 
synchronized this 
reference mcache 
null 
cleandeadentries 
return null 
return 
private void cleandeadentries 
arraylist charsequence deaths null 
find empty links 
entry charsequence reference entry mcache entryset 
entry getvalue null 
deaths null 
deaths arraylist 
deaths entry getkey 
clean 
deaths null 
charsequence deaths 
mcache remove 
removes elements from this cache leaving empty 
public void clear 
synchronized this 
mcache clear 
nonnull 
protected abstract reference oncreatereference nonnull object 
