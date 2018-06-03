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
import android support annotation nonnull 
import android support annotation nullable 
class performing oblivious checks 
author artem chepurnoy 
suppresswarnings sameparametervalue 
public abstract class check 
nullable 
private static check scheck 
nonnull 
public static check getinstance 
scheck null 
scheck checkimpl 
return scheck 
does nothing incoming param code true crashes otherwise 
throws java lang runtimeexception 
istrue 
isfalse boolean 
public abstract void istrue boolean bool 
public abstract void istrue boolean bool nonnull string message 
does nothing incoming param zero crashes otherwise 
throws java lang runtimeexception 
istrue boolean 
public abstract void istrue value 
public abstract void istrue value nonnull string message 
does nothing incoming param code false crashes otherwise opposite 
link istrue boolean 
throws java lang runtimeexception 
istrue boolean 
public abstract void isfalse boolean bool 
public abstract void isfalse boolean bool nonnull string message 
does nothing incoming param code null crashes otherwise opposite 
link istrue boolean 
throws java lang runtimeexception 
isnonnull object 
public abstract void isnull nullable object object 
public abstract void isnull nullable object object nonnull string message 
does nothing incoming param code null crashes otherwise opposite 
link isnull object 
throws java lang runtimeexception 
isnull object 
public abstract void isnonnull nonnull object object 
public abstract void isnonnull nonnull object object nonnull string message 
does nothing link android looper getmainlooper main thread 
crashes otherwise 
throws java lang runtimeexception 
public abstract void isinmainthread 
public abstract void isinmainthread nonnull string message 
