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

package achep acdisplay notifications 
import android content context 
import android graphics bitmap 
import android handler 
import android looper 
import android systemclock 
import android support annotation nonnull 
import android support annotation nullable 
import android util 
import achep base tests check 
import java util concurrent concurrentlinkedqueue 
import static achep acdisplay graphics iconfactory generate 
import static achep base build debug 
simple single thread icon factory 
author artem chepurnoy 
public class iconfactory 
private static final string iconfactory 
public interface iconasynclistener 
void ongenerated nonnull bitmap bitmap 
author artem chepurnoy 
private static final class worker extends thread 
private static class task 
nonnull 
private context context 
nonnull 
private iconasynclistener listener 
nonnull 
private opennotification notification 
public task nonnull context context 
nonnull iconasynclistener listener 
nonnull opennotification notification 
this context context 
this listener listener 
this notification notification 
private final concurrentlinkedqueue task mqueue concurrentlinkedqueue 
private final iconfactory mfactory 
private final object mmonitor 
private volatile boolean mstopping 
worker iconfactory factory nonnull object monitor 
mfactory factory 
mmonitor monitor 
override 
public void 
super 
final long start systemclock elapsedrealtime 

while true 
next task from 
queue 
final task task 
synchronized mmonitor 
mqueue isempty 
mstopping true 
debug 
long delta systemclock elapsedrealtime start 
done loading icons 
delta delta 
count 
return 
task mqueue poll 
assert task null 
final bitmap bitmap mfactory ongenerate task context task notification 
mfactory handler post runnable 
override 
public void 
check getinstance isinmainthread 
task listener ongenerated bitmap 
void nonnull context context 
nonnull opennotification notification 
nonnull iconasynclistener listener 
task task task context listener notification 
check getinstance isfalse mstopping 
mqueue task 
void remove nonnull opennotification notification 
check getinstance isfalse mstopping 
task task mqueue 
task notification notification 
mqueue remove task 
return 
return code true current worker accept handle 
incoming tasks code false otherwise 
boolean isactive 
return mstopping 
nullable 
private worker mworker 
nonnull 
private handler handler handler looper getmainlooper 
nonnull 
private final object mmonitor object 
nonnull 
protected bitmap ongenerate nonnull context context nonnull opennotification notification 
return generate context notification 
adds notification tasks list 
param notification notification load from 
param listener callback 
remove opennotification 
public void nonnull context context 
nonnull opennotification notification 
nonnull iconasynclistener listener 
synchronized mmonitor 
boolean create isworkerinactive 
create 
mworker worker this mmonitor 
mworker setpriority thread max_priority 
assert mworker null 
mworker context notification listener 
create mworker start 
removes notification from task list available 
android content context opennotification iconfactory iconasynclistener 
public void remove nonnull opennotification notification 
synchronized mmonitor 
isworkerinactive 
late 
return 
assert mworker null 
mworker remove notification 
private boolean isworkerinactive 
return mworker null mworker isactive 
