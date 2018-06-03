package achep base content 
import android annotation suppresslint 
import android content context 
import android content sharedpreferences 
import android content resources 
import android handler 
import android looper 
import android preference preference 
import android preference preferencescreen 
import android support annotation nonnull 
import android support annotation nullable 
import android util 
import achep base device 
import achep base interfaces ionlowmemory 
import apache commons lang builder equalsbuilder 
import apache commons lang builder hashcodebuilder 
import java lang reference 
import java lang weakreference 
import java util arraylist 
import java util list 
import java util 
import java util concurrent concurrenthashmap 
config class that stores application options provides easy 
sync them with 
author artem chepurnoy 
public abstract class cfgbase implements ionlowmemory 
private static final boolean debug true 
private static final string cfg_base 
return filename this config 
nonnull 
public abstract string getpreferencesfilename 
loads settings from storage should called begin 
lifecycle 
public final void load nonnull context context 
synchronized this 
resources context getresources 
sharedpreferences prefs getsharedpreferences context 
option option getmap values 
current value 
object value option getdefault 
boolean class isassignablefrom option clazz 
value prefs getboolean option boolean value 
else class isassignablefrom option clazz 
value prefs getint option integer value 
else float class isassignablefrom option clazz 
value prefs getfloat option float value 
else string class isassignablefrom option clazz 
value prefs getstring option string value 
else long class isassignablefrom option clazz 
value prefs getlong option long value 
else throw illegalargumentexception unknown option type 
init option option with value 
current value 
option setvalue value 
resets options their default values 
public final void reset nonnull context context 
synchronized this 
transaction transaction transaction true fake putting 
transaction begintransaction context 
reset values 
resources context getresources 
option option getmap values 
object value option getdefault 
transaction option value null notify everyone 
clean storage 
transaction clear faked 
transaction endtransaction 
public final void nonnull context context nonnull string nonnull object 
context null 
public final void nonnull context context nonnull string nonnull object 
nullable onconfigchangedlistener listenerignored 
synchronized this 
context change listenerignored 
public final void nonnull context context nonnull change change 
synchronized this 
context change change 
public final void nonnull context context 
nonnull change changes 
synchronized this 
transaction transaction transaction 
transaction begintransaction context 
change change changes transaction change 
transaction endtransaction 
begin 
nonnull 
private final arraylist reference onconfigchangedlistener mlistenersrefs arraylist 
private final arraylist handlerholder mlistenersholders arraylist 
private string option mmap 
inheritdoc 
override 
public void onlowmemory unused 
gets instance shared preferences 
nonnull 
protected sharedpreferences getsharedpreferences nonnull context context 
return context getsharedpreferences getpreferencesfilename context mode_private 
protected abstract void onconfigchanged nonnull transaction transaction nonnull option option 
here should create options 
protected abstract void oncreatemap nonnull string option 
protected final void putoption nonnull string option nonnull option option 
option option 
return link java util hashmap hashmap with option keys keys 
link option data values 
oncreatemap 
nonnull 
public final string option getmap 
mmap null 
mmap concurrenthashmap 
oncreatemap mmap 
return mmap 
param unique option 
throws illegalargumentexception failed find corresponding option 
getmap 
nonnull 
public final option getoption nonnull string 
option option getmap 
option null 
throw illegalargumentexception existent option found 
return option 
public final boolean contains nonnull string 
return getmap containskey 
read 
public boolean getboolean nonnull string 
return boolean getobject 
public float getfloat nonnull string 
return float getobject 
public getint nonnull string 
return getobject 
public long getlong nonnull string 
return long getobject 
nonnull 
public string getstring nonnull string 
return string getobject 
nonnull 
public object getobject nonnull string 
return getoption getvalue 
listener 
adds link weakreference weak listener config make sure call 
link unregisterlistener onconfigchangedlistener later 
param listener listener register config changes 
unregisterlistener onconfigchangedlistener 
public final void registerlistener nonnull onconfigchangedlistener listener 
synchronized mlistenersrefs 
make sure register listener only once 
reference onconfigchangedlistener mlistenersrefs 
listener 
tried register already registered listener 
return 
addlistenerref weakreference listener listener 
registers listener there 
param listener listener unregister from config changes 
registerlistener onconfigchangedlistener 
public final void unregisterlistener nonnull onconfigchangedlistener listener 
synchronized mlistenersrefs 
reference onconfigchangedlistener mlistenersrefs 
listener 
removelistenerref 
return 
tried unregister existent listener 
private void addlistenerref nonnull reference onconfigchangedlistener 
nonnull onconfigchangedlistener listener 
mlistenersrefs 
listener instanceof uithreadedconfigchangedlistener return 
uithreadedconfigchangedlistener uithreadedconfigchangedlistener listener 
looks weird that check looper here 
check handlerholder class 
will work normally 
noinspection suspiciousmethodcalls 
index mlistenersholders indexof mlooper 
index 
debug adding looper mlooper 
mlistenersholders index list 
else 
debug creating looper mlooper 
handlerholder handlerholder mlooper 
list 
mlistenersholders 
private void removelistenerref nonnull reference onconfigchangedlistener 
mlistenersrefs remove 
final onconfigchangedlistener listener 
listener null listener instanceof uithreadedconfigchangedlistener return 
final length mlistenersholders size 
length 
final handlerholder mlistenersholders 
list contains 
list remove 
debug removed from looper 
list isempty 
debug removed looper 
mlistenersholders remove 
break 
interface definition callback invoked 
when option changed 
author artem chepurnoy 
public interface onconfigchangedlistener 
callback that option changed 
void onconfigchanged nonnull transaction transaction nonnull option option 
author artem chepurnoy 
public static abstract class uithreadedconfigchangedlistener implements 
onconfigchangedlistener 
nonnull 
private final looper mlooper 
public uithreadedconfigchangedlistener nonnull looper looper 
looper null looper looper getmainlooper 
mlooper looper 
inheritdoc 
this called wrong looper 
override 
public void onconfigchanged nonnull final transaction transaction 
nonnull final option option empty 
public abstract boolean onkeycheck nonnull string 
same link onconfigchanged transaction option called only 
link looper looper when option fits link onkeycheck string 
public abstract void onuithreadedconfigchanged 
nonnull transaction transaction 
nonnull option option 
simple link handler class that checks equality only 
internal link looper looper note that link equals object 
methods works pass link looper looper 
author artem chepurnoy 
private static class handlerholder extends handler 
nonnull 
final list reference onconfigchangedlistener list 
public handlerholder nonnull looper looper 
super looper 
list arraylist 
override 
public hashcode 
return getlooper hashcode 
override 
public boolean equals object 
null return false 
this return true 
final looper looper 
instanceof handlerholder 
handlerholder handlerholder 
looper getlooper 
else instanceof looper 
looper looper 
else return false 
return getlooper equals looper 
other 
author artem chepurnoy 
public final static class change 
nonnull 
public final string 
nonnull 
public final object value 
nullable 
public final onconfigchangedlistener listenerignored 
public change nonnull string nonnull object value 
nullable onconfigchangedlistener listenerignored 
this 
this value value 
this listenerignored listenerignored 
transaction 
author artem chepurnoy 
public final class transaction 
private context mcontext 
private sharedpreferences editor meditor 
private final boolean mfake 
public transaction 
this false 
public transaction boolean fake 
mfake fake 
suppresslint commitprefedits 
nonnull 
public transaction begintransaction nonnull context context 
mcontext context getapplicationcontext 
meditor getsharedpreferences mcontext edit 
return this 
nonnull 
public transaction nonnull change change 
return getoption change change value change listenerignored 
nonnull 
public transaction final nonnull option option nonnull object value 
final nullable onconfigchangedlistener listenerignored 
option getvalue equals value return this need equal value 
value 
saving option value 
option setvalue value 
onconfigchanged this option 
notify listeners 
synchronized mlistenersrefs 
mlistenersrefs size 
reference onconfigchangedlistener mlistenersrefs 
onconfigchangedlistener 
null 
there were links this listener except 
class 
deleting addled listener 
removelistenerref 
else listenerignored 
onconfigchanged this option 
final mlistenersholders size 

final handlerholder mlistenersholders 
final list reference onconfigchangedlistener list list 
check really need notify about this event 
somebody there 
boolean post false 
reference onconfigchangedlistener list 
onconfigchangedlistener 
null 
uithreadedconfigchangedlistener uithreadedconfigchangedlistener 
onkeycheck option 
post true 
break need check more 
post continue 
post runnable 
override 
public void 
synchronized mlistenersrefs 
have unregistered 
reference onconfigchangedlistener list 
onconfigchangedlistener 
null listenerignored continue 
uithreadedconfigchangedlistener uithreadedconfigchangedlistener 
onkeycheck option continue 
onuithreadedconfigchanged transaction this option 
notifying from looper mlooper looper mylooper 
mfake return this 
value instanceof boolean 
meditor putboolean option boolean value 
else value instanceof integer 
meditor putint option integer value 
else value instanceof float 
meditor putfloat option float value 
else value instanceof string 
meditor putstring option string value 
else value instanceof long 
meditor putlong option long value 
else throw illegalargumentexception unknown value type 
return this 
nonnull 
public transaction clear 
meditor clear 
return this 
nonnull 
public transaction endtransaction 
meditor apply 
return this 

additional stuff 

nonnull 
public context getcontext 
return mcontext 
option 
single option that synced with preference 
author artem chepurnoy 
public static class option 
nonnull 
public final class clazz 
nonnull 
public final string 
defaults 
public final object defaultvalue 
public final defaultres 

public final minsdkversion 
public final maxsdkversion 
private volatile object mvalue 
public option nonnull class clazz nonnull string 
object defaultvalue defaultres 
minsdkversion maxsdkversion 
this clazz clazz 
this 
this defaultvalue defaultvalue 
this defaultres defaultres 
this minsdkversion minsdkversion 
this maxsdkversion maxsdkversion 
inheritdoc 
override 
public hashcode 
return hashcodebuilder 
append clazz 
append 
append defaultvalue 
append defaultres 
append minsdkversion 
append maxsdkversion 
append mvalue 
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
append clazz option clazz 
append option 
append defaultvalue option defaultvalue 
append defaultres option defaultres 
append minsdkversion option minsdkversion 
append maxsdkversion option maxsdkversion 
append mvalue option mvalue 
isequals 
public void setvalue nonnull object value 
mvalue value 
nonnull 
public object getvalue 
return mvalue 

additional stuff 

extracts returns default option value 
nonnull 
public final object getdefault nonnull resources resources 
check defaultvalue already 
defaultvalue null 
defaultres 
boolean class isassignablefrom clazz 
return resources getboolean defaultres 
else class isassignablefrom clazz 
return resources getinteger defaultres 
else float class isassignablefrom clazz 
assuming dimension fraction 
return resources getdimension defaultres 
else string class isassignablefrom clazz 
return resources getstring defaultres 
else throw illegalargumentexception unknown option type 
else throw illegalstateexception 
return defaultvalue 
author artem chepurnoy 
public static class builder 
private final class mclass 
private final string mkey 
defaults 
private object mdefaultvalue 
private mdefaultres 

private mminsdkversion integer min_value 
private mmaxsdkversion integer max_value 
public builder nonnull class clazz nonnull string 
mclass clazz 
mkey 
nonnull 
public builder setdefault nonnull object value 
mdefaultvalue value 
return this 
nonnull 
public builder setdefaultres resource 
mdefaultres resource 
return this 
sets minimum link android build version sdk_int version this 
option this option shown older systems 
setmaxsdkversion 
nonnull 
public builder setminsdkversion version 
mminsdkversion version 
return this 
sets maximum link android build version sdk_int version this 
option this option shouldn shown newer systems 
setminsdkversion 
nonnull 
public builder setmaxsdkversion version 
mmaxsdkversion version 
return this 
bakes this builder into option 
nonnull 
public option build 
return option mclass mkey 
mdefaultvalue mdefaultres 
mminsdkversion mmaxsdkversion 
syncer 
class syncing link cfgbase option with 
corresponding link preference 
author artem chepurnoy 
public final static class syncer 
private final cfgbase mcfg 
private final arraylist item mitems 
private final context mcontext 
private boolean mbroadcastingpref 
private boolean mstarted 
nonnull 
private final handler mhandler handler looper getmainlooper 
nonnull 
private final preference onpreferencechangelistener mpreferencelistener 
preference onpreferencechangelistener 
override 
public boolean onpreferencechange preference preference object newvalue 
mbroadcastingpref 
return true 
item item null 
item mitems 
preference preference 
item 
break 
assert item null 
newvalue item setter getvalue newvalue 
change change change item option newvalue mconfiglistener 
item mcontext change 
update preference summary 
item setter updatesummary item preference item option newvalue 
return true 
nonnull 
private final onconfigchangedlistener mconfiglistener 
onconfigchangedlistener 
override 
public void onconfigchanged nonnull transaction transaction 
nonnull option option 
item item null 
item mitems 
option equals preference getkey 
item 
break 
item null 
return 
setpreferencevalue item option getvalue 
public syncer nonnull context context nonnull cfgbase 
mcfg 
mitems arraylist 
mcontext context 
private void setpreferencevalue final nonnull item item final nonnull object value 
mhandler post runnable 
override 
public void 
mbroadcastingpref true 
item setter setvalue item preference item option value 
item setter updatesummary item preference item option value 
mbroadcastingpref false 
public void sync 
nullable preferencescreen 
nonnull preference preference 
nonnull setter setter 
item item item preference setter mcfg 
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
sync preferencescreen preference setter 
public void start 
mstarted true 
mitems size 
mitems registerlistener mconfiglistener 
item item mitems startlisteningtoitem item 
private void startlisteningtoitem nonnull item item 
item preference setonpreferencechangelistener mpreferencelistener 
setpreferencevalue item item option getvalue 
stops listen changes 
start 
public void stop 
mstarted false 
mcfg unregisterlistener mconfiglistener 
item item mitems item preference setonpreferencechangelistener null 

additional stuff 

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
class merge link preference 
link option link syncer setter 
author artem chepurnoy 
private final static class item 
nonnull 
final cfgbase 
nonnull 
final preference preference 
nonnull 
final setter setter 
nonnull 
final option option 
public item nonnull preference preference 
nonnull setter setter 
nonnull cfgbase 
this preference preference 
this setter setter 
this 
this option getoption preference getkey 
