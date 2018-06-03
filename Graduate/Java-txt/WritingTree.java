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

package achep base timber 
import android manifest 
import android content context 
import android environment 
import android support annotation nonnull 
import android util 
import achep base appheap 
import achep base build 
import achep base permissions runtimepermissions 
import achep base tests check 
import achep base utils encryptionutils 
import achep base utils fileutils 
import java file 
import java text simpledateformat 
import java util calendar 
import java util locale 
import timber timber 
import static achep base build encrypt_logs 
async writes logs file 
author artem chepurnoy 
public class writingtree extends timber debugtree 
public static final string filename acdisplay_logs 
nonnull 
private final simpledateformat mformat simpledateformat locale english 
private mthread 
author artem chepurnoy 
private static class extends thread 
private static final string writingtree thread 
suppresswarnings pointlessbooleanexpression 
private final boolean debug false build debug 
long should thread sleep after getting pending 
line 
private static final long sleep 
number symbols buffer 
private static final max_length symbols 
private final object mmonitor object 
private final stringbuilder mbuilder stringbuilder 
private final file mfile 
private volatile boolean mlocked false 
private volatile boolean mrunning true 
private volatile boolean msleepy 
public 
mfile file environment getexternalstoragedirectory filename 
fileutils deleterecursive mfile failed remove 
setpriority thread min_priority 
override 
public void 
while mrunning 
synchronized mmonitor 
final length mbuilder length 
length 
noinspection constantconditions 
debug 
writing length symbols file 
final context context appheap getcontext 
final string permission manifest permission write_external_storage 
runtimepermissions context permission 
noinspection constantconditions 
final charsequence 
encrypt_logs 
encryptionutils mbuilder tostring build log_key_salt 
debug 
check decrypt 
string encrypted tostring substring length 
check getinstance istrue encryptionutils 
fromx encrypted build log_key_salt 
equals mbuilder tostring 
else mbuilder 
final boolean succeed fileutils writetofileappend mfile 
succeed mbuilder delete length 
else runtimepermissions allowed context permission 
runtimepermissions context permission 
else 
archive lets just fall back 

mbuilder delete length 

mlocked true 
mmonitor wait 
catch interruptedexception unused finally 
mlocked false 
msleepy 
thread sleep sleep 
catch interruptedexception unused 
msleepy true 
public void requestwrite priority nonnull charsequence 
synchronized mmonitor 
mbuilder append 

final length mbuilder length 
length max_length 
cutting down length length 
mbuilder delete length max_length 
write important logs immediately 
msleepy priority warn 
mlocked mmonitor notifyall 
public writingtree 
super 
override 
protected void priority string string message throwable 
synchronized this 
println priority message 
append pool 
mthread null 
mthread 
mthread start 
string mformat format calendar getinstance gettime 
priority 

message 
mthread requestwrite priority 
