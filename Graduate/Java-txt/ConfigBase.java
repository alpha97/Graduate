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

package achep base content 
import android content context 
import android content sharedpreferences 
import android content resources 
import android handler 
import android looper 
import android preference preference 
import android preference preferencescreen 
import android support annotation nonnull 
import android support annotation nullable 
import android text textutils 
import android util 
import achep base device 
import achep base interfaces ibackupable 
import achep base interfaces ionlowmemory 
import achep base interfaces isubscriptable 
import achep base tests check 
import achep base utils gziputils 
import apache commons lang builder equalsbuilder 
import apache commons lang builder hashcodebuilder 
import json jsonexception 
import json jsonobject 
import java lang softreference 
import java lang weakreference 
import java lang reflect field 
import java lang reflect method 
import java util arraylist 
import java util hashmap 
import java util iterator 
import java util 
import timber timber 
import static achep base build debug 
saves configurations 
author artem chepurnoy 
since 
suppresswarnings constantconditions 
public abstract class configbase implements 
isubscriptable configbase onconfigchangedlistener 
ionlowmemory ibackupable 
private static final string config 
protected static final string preferences_file_name config 
private final arraylist weakreference onconfigchangedlistener mlistenersrefs arraylist 
private volatile softreference string option mmapref softreference null 
private volatile context mcontext 
private volatile object mpreviousvalue 
threading 
protected final handler mhandler handler looper getmainlooper 
interface definition callback invoked 
when config changed 
public interface onconfigchangedlistener 
callback that config changed 
param config instance config 
param value value changed option 
void onconfigchanged 
nonnull configbase config 
nonnull string 
nonnull object value 
inheritdoc 
override 
public void onlowmemory 
mmapref clear will recreated getmap 
adds link java lang weakreference weak listener config make sure call 
link unregisterlistener configbase onconfigchangedlistener later 
param listener listener register config changes 
unregisterlistener configbase onconfigchangedlistener 
override 
public final void registerlistener nonnull onconfigchangedlistener listener 
make sure register listener only once 
weakreference onconfigchangedlistener mlistenersrefs 
listener 
timber tried register already registered listener 
return 
mlistenersrefs weakreference listener 
registers listener there 
param listener listener unregister from config changes 
registerlistener configbase onconfigchangedlistener 
override 
public final void unregisterlistener nonnull onconfigchangedlistener listener 
weakreference onconfigchangedlistener mlistenersrefs 
listener 
mlistenersrefs remove 
return 
timber tried unregister existent listener 
return link java util hashmap hashmap with option keys keys 
link option data values 
oncreatemap java util 
nonnull 
public final string option getmap 
string option mmapref 
null 
hashmap 
oncreatemap 
mmapref softreference 
return 
param unique option 
throws runtimeexception failed find corresponding option 
getmap 
nonnull 
public final option getoption nonnull string 
option option getmap 
option null return option 
throw runtimeexception have forgotten 
hash config 
context from here only 
link configbase onconfigchangedlistener onconfigchanged configbase string object config change 
public context getcontext 
return mcontext 
previous value from here only 
link configbase onconfigchangedlistener onconfigchanged configbase string object config change 
nullable 
public object getpreviousvalue 
return mpreviousvalue 
internal methods 
gets instance shared preferences link preferences_file_name 
default name link preferences_file_name 
nonnull 
protected sharedpreferences getsharedpreferences nonnull context context 
return context getsharedpreferences preferences_file_name context mode_private 
fills link java util hashmap hash with config options 
getmap 
protected abstract void oncreatemap nonnull string option 
protected abstract void onoptionchanged nonnull option option nonnull string 
protected void writefrommain final nonnull context context 
final nonnull option option final nonnull object value 
final nullable onconfigchangedlistener listenertobeignored 
mhandler post runnable 
override 
public void 
write context option value listenertobeignored 
protected void write final nonnull context context 
final nonnull option option 
final nonnull object value 
final nullable onconfigchangedlistener listenertobeignored 
check getinstance isinmainthread 
option read configbase this equals value return 
string option getkey configbase this 
debug writing value config 
read current value from option 
mpreviousvalue option read this 
current value field 

field field getclass getdeclaredfield option fieldname 
field setaccessible true 
field this value 
catch exception 
throw illegalstateexception 
current value preferences file 
sharedpreferences editor editor getsharedpreferences context edit 
value instanceof boolean 
editor putboolean boolean value 
else value instanceof integer 
editor putint integer value 
else value instanceof float 
editor putfloat float value 
else value instanceof string 
editor putstring string value 
else throw illegalargumentexception unknown option type 
editor apply 
mcontext context 
onoptionchanged option 
notifyconfigchanged value listenertobeignored 
mcontext null 
mpreviousvalue null 
param option 
param value value 
configbase onconfigchangedlistener onconfigchanged configbase string object 
private void notifyconfigchanged nonnull string nonnull object value 
nullable onconfigchangedlistener listenertobeignored 
check getinstance isinmainthread 
mlistenersrefs size 
weakreference onconfigchangedlistener mlistenersrefs 
onconfigchangedlistener 
null 
there were links this listener except 
class 
deleting addled listener 
mlistenersrefs remove 
else listenertobeignored 
onconfigchanged this value 
backup 
stores values json string compresses 
using link gziputils gzip 
return backup string code null failed generate 
frombackuptext context string 
override 
nullable 
public string tobackuptext 
jsonobject json 

json jsonobject 
todo should protect somehow 
json __package__ 
json __version__ 
fill json with value pairs 
entry string option entry getmap entryset 
json entry getkey entry getvalue 
catch jsonexception 
failed generate json getmessage 
return null 
compress result protect from noobs changes 
reduce size this still easy extract 
know what 
return gziputils compress json tostring 
loads settings from previously link tobackuptext generated backup string 
technically this broke current settings kinda dangerous 
return code true config successfully restored code false otherwise 
tobackuptext 
override 
public boolean frombackuptext nonnull context context nonnull string input 
string json gziputils decompress input 
json null return false 
string fallback tobackuptext risk 
return fallback null frombackuptext context json fallback 
private boolean frombackuptext nonnull context context 
nonnull string nonnull string fallback 

jsonobject json jsonobject 
iterator string json keys 
while hasnext 
string next 
object value json 
apply value 
option option getmap 
option null 
option write this context value null 
else 
passed loading unknown item from plain text 
catch exception 
fallback original settings 
textutils equals fallback frombackuptext context fallback fallback 
this point current config partially corrupted recoverable 
return false 
return true 
other 
protected void initinternal nonnull context context 

resources context getresources 
sharedpreferences prefs getsharedpreferences context 
entry string option entry getmap entryset 
final string entry getkey 
final option option entry getvalue 
current value 
object value option getdefault 
boolean class isassignablefrom option clazz 
value prefs getboolean boolean value 
else class isassignablefrom option clazz 
value prefs getint integer value 
else float class isassignablefrom option clazz 
value prefs getfloat float value 
else string class isassignablefrom option clazz 
value prefs getstring string value 
else throw illegalargumentexception unknown option type 
current value 
field field getclass getdeclaredfield option fieldname 
field setaccessible true 
field this value 
catch exception 
throw runtimeexception 
protected void resetinternal nonnull context context 
reset values 
resources context getresources 
option option getmap values 
object value option getdefault 
option write this context value null 
clean storage 
sharedpreferences prefs getsharedpreferences context 
prefs edit clear apply 
syncer 
class that syncs link android preference preference with 
value config sample class found here 
link achep base fragments preferencefragment 
author artem chepurnoy 
public static class syncer 
private final arraylist item mitems 
private final context mcontext 
private final configbase mconfig 
private boolean mbroadcasting 
private boolean mstarted 
private final preference onpreferencechangelistener mpreferencelistener 
preference onpreferencechangelistener 
override 
public boolean onpreferencechange preference preference object newvalue 
mbroadcasting 
return true 
item item null 
item mitems 
preference preference 
item 
break 
assert item null 
newvalue item setter getvalue newvalue 
item option write mconfig mcontext newvalue mconfiglistener 
item setter updatesummary item preference item option newvalue 
return true 
private final onconfigchangedlistener mconfiglistener 
onconfigchangedlistener 
override 
public void onconfigchanged nonnull configbase config nonnull string 
nonnull object value 
item item null 
item mitems 
equals preference getkey 
item 
break 
item null 
return 
setpreferencevalue item value 
private void setpreferencevalue nonnull item item nonnull object value 
mbroadcasting true 
item setter setvalue item preference item option value 
item setter updatesummary item preference item option value 
mbroadcasting false 
public interface setter 
void updatesummary nonnull preference preference 
nonnull option option 
nonnull object value 
sets value preference 
param preference preference 
param option changed option 
param value value 
void setvalue nonnull preference preference 
nonnull option option 
nonnull object value 
nonnull 
object getvalue nonnull object value 
class merge link android preference preference 
link configbase option link configbase syncer setter 
author artem chepurnoy 
private final static class item 
final preference preference 
final setter setter 
final option option 
public item nonnull configbase config 
nonnull preference preference 
nonnull setter setter 
this preference preference 
this setter setter 
this option config getoption preference getkey 
public syncer nonnull context context nonnull configbase config 
mitems arraylist 
mcontext context 
mconfig config 
public void syncpreference nullable preferencescreen 
nonnull preference preference 
nonnull setter setter 
item item item mconfig preference setter 
null 
remove preference from preference screen 
needed 
boolean fitsmax device hastargetapi item option maxsdkversion 
boolean fitsmin device hastargetapi item option minsdkversion 
fitsmax fitsmin 
removepreference preference 
return 
preference 
mitems item 
immediately start listening needed 
mstarted startlisteningtoitem item 
updates preferences starts listen changes 
forget call link stop later 
stop 
syncpreference preferencescreen preference setter 
public void start 
mstarted true 
mconfig registerlistener mconfiglistener 
item item mitems startlisteningtoitem item 
private void startlisteningtoitem nonnull item item 
item preference setonpreferencechangelistener mpreferencelistener 
setpreferencevalue item item option read mconfig 
stops listen changes 
start 
public void stop 
mstarted false 
mconfig unregisterlistener mconfiglistener 
item item mitems item preference setonpreferencechangelistener null 
author artem chepurnoy 
public static class option 
nonnull 
private final string fieldname 
nullable 
private final string settername 
nullable 
private final string gettername 
nonnull 
private final class clazz 
private volatile minsdkversion integer min_value 
private volatile maxsdkversion integer max_value 
private volatile mdefaultres 
private volatile object mdefault 
public option nonnull string fieldname 
nullable string settername 
nullable string gettername 
nonnull class clazz 
this fieldname fieldname 
this settername settername 
this gettername gettername 
this clazz clazz 
nonnull 
public option setdefault object value 
mdefault value 
return this 
nonnull 
public option setdefaultres resource 
mdefaultres resource 
return this 
sets minimum link android build version sdk_int version this 
option this option shown older systems 
setmaxsdkversion 
nonnull 
public option setminsdkversion version 
minsdkversion version 
return this 
sets maximum link android build version sdk_int version this 
option this option shown newer systems 
setminsdkversion 
nonnull 
public option setmaxsdkversion version 
maxsdkversion version 
return this 
inheritdoc 
override 
public hashcode 
return hashcodebuilder 
append fieldname 
append settername 
append gettername 
append clazz 
tohashcode 
inheritdoc 
override 
public boolean equals object 
null 
return false 
this 
return true 
instanceof option 
return false 
option option option 
return equalsbuilder 
append fieldname option fieldname 
append settername option settername 
append gettername option gettername 
append clazz option clazz 
isequals 
extracts returns default option value specified 
link setdefault object link setdefaultres 
setdefault object 
setdefaultres 
nullable 
public final object getdefault nonnull resources resources 
mdefaultres 
boolean class isassignablefrom clazz 
return resources getboolean mdefaultres 
else class isassignablefrom clazz 
return resources getinteger mdefaultres 
else float class isassignablefrom clazz 
assuming dimension fraction 
return resources getdimension mdefaultres 
else string class isassignablefrom clazz 
return resources getstring mdefaultres 
else throw illegalargumentexception unknown option type 
return mdefault 
nonnull 
public final string getkey nonnull configbase config 
entry string option entry config getmap entryset 
entry getvalue equals this 
return entry getkey 
throw runtimeexception 
reading writing 
reads option from given config instance 
reading done using reflections 
param config config read from 
throws runtimeexception failed read given config 
nonnull 
public final object read nonnull configbase config 
return gettername null readfromgetter config readfromfield config 
nonnull 
private object readfromfield nonnull configbase config 
assert fieldname null 

field field config getclass getdeclaredfield fieldname 
field setaccessible true 
return field config 
catch exception 
throw runtimeexception failed access clazz getname fieldname field 
nonnull 
private object readfromgetter nonnull configbase config 
assert gettername null 

method method config getclass getdeclaredmethod gettername 
method setaccessible true 
return method invoke config 
catch exception 
throw runtimeexception failed access clazz getname gettername method 
writes value option given config instance 
writing done using reflections 
param config config write 
throws runtimeexception failed read given config 
public final void write nonnull configbase config nonnull context context 
nonnull object newvalue nullable onconfigchangedlistener listener 
settername null 
setter must calling writefrommain itself 
writebysetter config context newvalue listener 
return 
config writefrommain context this newvalue listener 
private void writebysetter nonnull configbase config nonnull context context 
nonnull object newvalue nullable onconfigchangedlistener listener 
assert settername null 

method method config getclass getdeclaredmethod settername 
context class clazz 
configbase onconfigchangedlistener class 
method setaccessible true 
method invoke config context newvalue listener 
catch exception 
throw runtimeexception failed access clazz getname settername method 
