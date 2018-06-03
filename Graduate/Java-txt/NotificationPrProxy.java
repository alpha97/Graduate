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
import android handler 
import android looper 
import android systemclock 
import android support annotation nonnull 
import android support annotation nullable 
import android util 
import achep base build 
import achep base device 
import achep base utils operator 
import java util arraylist 
import java util iterator 
import java util list 
import static achep acdisplay notifications notificationpresenter flag_immediately 
processes notification flow transfers through 
link looper getmainlooper main thread 
author artem chepurnoy 
class notificationprproxy 
private static final string notificationprproxy 
private static final long delay 
private static final long max_delay delay 
nonnull 
private final object mmonitor object 
nonnull 
private final notificationpresenter mpresenter 
nonnull 
private final handler mhandler 
nonnull 
private final list notificationprtask mtasks 
private final runnable mprocessrunnable runnable 
override 
public void 
synchronized mmonitor 
mstarttime 
mprocessing true 
optimizeprtasks mtasks 
sendprtasks mtasks 
mtasks clear 
mprocessing false 
private volatile long mstarttime 
private volatile boolean mprocessing 
public notificationprproxy 
nonnull notificationpresenter presenter 
nonnull looper looper 
mpresenter presenter 
mhandler handler looper 
mtasks arraylist device haslollipopapi 
multiply notifications levels have 
introduced much larger flow notifications 

called link notificationpresenter postnotification context opennotification 
direct posting notification 
onremoved opennotification 
onclear 
void onposted nonnull opennotification 
onremoveduplicates 
public void postnotification 
nonnull context context 
nonnull opennotification flags 
synchronized mmonitor 
boolean immediately operator bitand flags flag_immediately 
addtask context flags true immediately 
called link notificationpresenter removenotification opennotification 
direct removing notification 
onposted opennotification opennotification 
onclear 
void onremoved nonnull opennotification 
onremoveduplicates 
public void removenotification nonnull opennotification flags 
synchronized mmonitor 
boolean immediately operator bitand flags flag_immediately 
addtask null flags false immediately 
called link notificationpresenter clear boolean 
direct clean 
onposted opennotification 
onremoved opennotification 
void onclear 
synchronized mmonitor 
mstarttime 
mtasks clear 
mhandler removecallbacks mprocessrunnable 
private void addtask nullable context context nonnull opennotification notification 
flags boolean posts boolean immediately 
mtasks notificationprtask context notification posts flags 
allow infinitive loop here 
final long systemclock elapsedrealtime 
mstarttime mstarttime 
final long delta mstarttime 
delay processing 
mhandler removecallbacks mprocessrunnable 
mhandler postdelayed mprocessrunnable immediately delta max_delay delay 
private void onremoveduplicates nonnull opennotification 
synchronized mmonitor 
mprocessing removeoverridingtasks 
private void removeoverridingtasks nonnull opennotification 
iterator notificationprtask iterator mtasks iterator 
while iterator hasnext 
notificationutils hasidenticalids 
iterator next notification 
iterator remove 
optimize link notificationprtask post remove tasks list removing redundant 
tasks sorting families 
public void optimizeprtasks nonnull list notificationprtask list 
build debug optimizing post remove tasks list tostring 
size list size 
noinspection constantconditions 
notificationprtask empty notificationprtask null null false 
remove overriding tasks 
size 
notificationprtask task list 
task empty continue 

notificationprtask list 
empty continue 
notificationutils hasidenticalids 
task notification 
notification 
removed overridden task processing tasks list 
list empty 
remove empty objects 
iterator notificationprtask iterator list iterator 
while iterator hasnext 
notificationprtask task iterator next 
task empty iterator remove 
size list size 
sort families 
fixme check works correctly 
size 
notificationprtask task list 
task empty task notification isgroupchild continue 
size 
notificationprtask list 
empty notification isgroupsummary continue 
string subgroupkey notification getgroupkey 
string taskgroupkey task notification getgroupkey 
assert taskgroupkey null 
taskgroupkey equals subgroupkey 
swapped tasks processing tasks list 
swap tasks 
list task 
list 
break 
anything else 
build debug done optimizing post remove tasks list tostring 
materializes tasks link postnotification context opennotification posting 
link removenotification opennotification removing appropriate notifications 
public void sendprtasks nonnull list notificationprtask list 
notificationprtask task list 
task posts 
assert task context null 
mpresenter postnotification task context task notification task flags 
else 
mpresenter removenotification task notification task flags 
