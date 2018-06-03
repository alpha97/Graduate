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
import achep base interfaces ithreadfinishable 
import java util iterator 
import java util queue 
import java util concurrent concurrentlinkedqueue 
import timber timber 
created artem chepurnoy 
public abstract class taskqueuethread extends thread implements ithreadfinishable 
private static final string taskqueuethread 
private final queue mqueue concurrentlinkedqueue 
private boolean mwaiting false 
protected boolean mrunning true 
override 
public void finish 
finish false 
public void finish boolean clearalltasks 
isalive 
mrunning false 
clearalltasks 
synchronized this 
mqueue clear 
mwaiting notifyall 
while true 

join 
break 
catch interruptedexception pretty please 
override 
public void 
timber starting thread 
super 
queue queue concurrentlinkedqueue 
while mrunning 
synchronized this 
mqueue isempty 

wait next sendevent event 
where this thread will unlocked 
mwaiting true 
wait 
catch interruptedexception ignored 
finally 
mwaiting false 
move pending events local copy need 
block main queue 
while mqueue isempty 
queue mqueue poll 
islost 
mrunning false 
break 
iterator iterator queue iterator 
while iterator hasnext 
object iterator next 

onhandletask object 

iterator remove 
timber stopping thread 
public void sendtask nonnull object 
synchronized this 
mqueue object 
release thread lock needed 
mwaiting notifyall 
public void cleartask nonnull object 
synchronized this 
mqueue remove object 
public void clearalltasks 
synchronized this 
mqueue clear 
protected abstract void onhandletask object 
protected abstract boolean islost 
