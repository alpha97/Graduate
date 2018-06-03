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

package achep base async 
import android support annotation nonnull 
import android support annotation nullable 
import android text textutils 
import achep base appheap 
import achep base interfaces ionlowmemory 
import achep base utils ioutils 
import achep base utils networkutils 
import java bufferedreader 
import java ioexception 
import java inputstream 
import java inputstreamreader 
import java lang weakreference 
import java 
import java util arraylist 
import java util list 
import java util concurrent concurrenthashmap 
import timber timber 
better link asynctask 
author artem chepurnoy 
public abstract class asynctask extends android asynctask 
public static void stop nullable asynctask asynctask 
asynctask null asynctask isfinished 
asynctask cancel 
public static void stop nullable android asynctask asynctask 
asynctask null asynctask getstatus equals status finished 
asynctask cancel false 
equals calling code asynctask getstatus equals asynctask status finished 
public boolean isfinished 
return getstatus equals status finished 
equals calling code asynctask cancel false 
public void cancel 
cancel false 
downloads text files from internet note that forcing task stop immediately 
will likely produce memory leak 
author artem chepurnoy 
public static class downloadtext extends asynctask string void string implements ionlowmemory 
private static final string downloadtext 
private static final max_thread_num 
private final weakreference callback mcallback 
private final concurrenthashmap string string mmap 
private final list loaderthread mthreadlist 
private boolean mreducethreads false 
reduces number running download tasks 
this possible revert 
override 
public void onlowmemory 
mreducethreads true 
interface definition callback invoked 
when downloading finished failed 
public interface callback 
called when downloading finished failed 
void ondownloaded nonnull string texts 
private static class loaderthread extends thread 
private final concurrenthashmap string string mmap 
private final string murl 
public loaderthread concurrenthashmap string string string 
mmap 
murl 
override 
todo calculate much downloading will take 
able kick threads effectively 
public void 
timber fetching from murl 
inputstream null 
inputstreamreader null 
bufferedreader null 

murl openstream 
inputstreamreader 
bufferedreader 
string result ioutils readtextfrombufferedreader 
mmap murl result 
timber done fetching from murl 
catch ioexception 
timber failed fetching from murl 
finally 

null 
close 
else null 
close 
else null 
close 
catch ioexception 
printstacktrace 
public downloadtext nonnull callback callback 
mcallback weakreference callback 
initialcapacity math max_thread_num 
mmap concurrenthashmap initialcapacity 
mthreadlist arraylist initialcapacity 
override 
protected string doinbackground string urls 
string result string urls length 
networkutils isonline appheap getcontext return result 
string urls 
textutils isempty continue 
control amount running threads 
final threadsize mthreadlist size 
mreducethreads threadsize threadsize max_thread_num 
search best candidate 
finished 
loaderthread thread null 
threadsize 
thread mthreadlist 
thread isalive 
need search more 
dead thread great choice 
break 
else threadsize 
thread mthreadlist 
assert thread null 
jointhread thread 
mthreadlist remove thread 
loaderthread thread loaderthread mmap 
thread start 
mthreadlist thread 
iscancelled 
firethreads 
return null 
wait threads 
loaderthread thread mthreadlist 
jointhread thread 
mthreadlist clear 
extract results array 
urls length 
result mmap urls 
mmap clear 
return result 
joins given thread alive 
param thread thread joined 
private void jointhread nonnull loaderthread thread 
thread isalive 
while true 

thread join 
break 
catch interruptedexception pretty please 
well least didn explode 
private void firethreads correct 
loaderthread thread mthreadlist 
thread isalive thread isinterrupted 
thread interrupt 
mthreadlist clear 
override 
protected void onpostexecute nonnull string 
super onpostexecute 
callback callback mcallback 
callback null 
callback ondownloaded 
else timber finished loading text callback null 
