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
import android support annotation nonnull 
import android support annotation nullable 
import android util 
import achep base interfaces ibackupable 
import achep base interfaces ionlowmemory 
import achep base interfaces isubscriptable 
import java util arraylist 
import java util hashmap 
import java util iterator 
import java util 
import static achep base build debug 
simple list which automatically saves items private storage restores initialize 
this useful implementing blacklists something 
author artem chepurnoy 
public abstract class sharedlist extends sharedlist saver implements 
isubscriptable sharedlist onsharedlistchangedlistener 
ionlowmemory iterable ibackupable 
private static final string sharedlist 
prefix sharedlist internal usage 
private static final string key_prefix 
private static final string key_number key_prefix 
private static final string key_used_item key_prefix used_ 
private hashmap integer mlist 
private arraylist integer mplaceholder 
private arraylist onsharedlistchangedlistener mlisteners 
private boolean mrecyclablecreated 
private comparator mcomparator 
private msaver 
interface definition callback invoked 
when shared list changed 
author artem chepurnoy 
sharedlist 
sharedlist registerlistener sharedlist onsharedlistchangedlistener 
sharedlist unregisterlistener sharedlist onsharedlistchangedlistener 
public interface onsharedlistchangedlistener 
called object replaced list 
param objectnew current object 
param objectold object from list 
param diff difference between objects provided link sharedlist comparator 
void onput nonnull objectnew nullable objectold diff 
called object removed from list 
param objectremoved removed object from list 
void onremoved nonnull objectremoved 
provider diffs between objects list 
author artem chepurnoy 
onsharedlistchangedlistener onput object object 
public static abstract class comparator 
compares object returns difference between them 
return difference between objects 
public abstract compare nonnull object nullable 
skeleton saver class which needed store values 
into link android content sharedpreferences 
author artem chepurnoy 
could parcelable that 
public static abstract class saver 
should object data given shared prefs editor 
note this should write values with 
starting with link key_prefix 
param position position given object list 
android content sharedpreferences 
nonnull 
public abstract sharedpreferences editor nonnull object 
nonnull sharedpreferences editor editor 
position 
restores previously save object from shared preferences 
param position position given object list 
object android content sharedpreferences editor 
public abstract nonnull sharedpreferences prefs position 
note that must unregister your listener lately 
unregisterlistener sharedlist onsharedlistchangedlistener 
sharedlist onsharedlistchangedlistener 
override 
public void registerlistener nonnull onsharedlistchangedlistener listener 
mlisteners listener 
unregisters previously registered listener 
registerlistener sharedlist onsharedlistchangedlistener 
sharedlist onsharedlistchangedlistener 
override 
public void unregisterlistener nonnull onsharedlistchangedlistener listener 
mlisteners remove listener 
protected sharedlist must call init context later 
protected sharedlist nonnull context context 
init context 
protected void init nonnull context context 
mlist hashmap 
mplaceholder arraylist 
mlisteners arraylist 
createrecyclablefields 
restore previously saved list 
sharedpreferences prefs getsharedpreferences context 
final prefs getint key_number 

prefs getboolean key_used_item false 
create previously saved object 
object msaver prefs 
mlist object 
else 
this empty place which 
later 
mplaceholder 
nonnull 
private sharedpreferences getsharedpreferences nonnull context context 
return context getsharedpreferences getpreferencesfilename context mode_private 
return name shared list file 
getsharedpreferences android content context 
nonnull 
protected abstract string getpreferencesfilename 
return instance saver which will save your object shared preferences 
saver 
nonnull 
protected abstract oncreatesaver 
return comparator this shared list null 
onsharedlistchangedlistener onput object object 
android content context object 
android content context object onsharedlistchangedlistener 
getcomparator 
nullable 
protected comparator oncreatecomparator 
return null 
return previously created comparator 
oncreatecomparator 
nullable 
public comparator getcomparator 
return mcomparator 
protected boolean isoverwriteallowed nonnull object 
return false 
inheritdoc 
override 
public void onlowmemory 
mrecyclablecreated false 
this probably free 

mcomparator null 
msaver null 
private void createrecyclablefields 
mrecyclablecreated mrecyclablecreated true return 
mcomparator oncreatecomparator 
msaver oncreatesaver 
public void remove nonnull context context object 
remove context object null 
public void remove nonnull context context object nullable onsharedlistchangedlistener 
mlist containskey object 
tried remove existing object from list 
return 
objectremoved find object 
assert objectremoved null defined condition above 
mlist remove object 
position newly removed object 
sorted list keeping sorted 

final size mplaceholder size 
size 
mplaceholder 
break 
mplaceholder 
mark this item unused restore placeholders 
getsharedpreferences context edit 
putboolean key_used_item false 
apply 
notifyonremoved objectremoved 
nullable 
public nonnull context context nonnull object 
return context object null 
nullable 
public nonnull context context nonnull object nullable onsharedlistchangedlistener 
boolean growup false 

null 
contains object 
this completely useless equality checking 
method been implemented correctly content truly equals 
isoverwriteallowed object 
debug trying existing object shared list 
return null nothing 
search object 
find object 
remember position object 

mlist 
mlist remove 
else 
increase size list there 
empty place that 
growup mplaceholder size 
where save this object 
growup 
mplaceholder 
mplaceholder remove 
else 
mlist size 
mlist object 
createrecyclablefields 
save object internal memory 
sharedpreferences editor editor msaver 
object getsharedpreferences context edit 
putboolean key_used_item true 
growup editor putint key_number mlist size 
editor apply 
notifyonput object 
return 
nullable 
private find nonnull object 
mlist keyset 
equals object 
return 
return null 
notifies link registerlistener onsharedlistchangedlistener registered listeners 
about removed from list object 
param objectremoved removed object from list 
param listener that will ignored while notifying 
protected void notifyonremoved nonnull objectremoved 
nullable onsharedlistchangedlistener 
onsharedlistchangedlistener listener mlisteners 
listener continue 
listener onremoved objectremoved 
notifies link registerlistener onsharedlistchangedlistener registered listeners 
that list more item item overwritten 
param object object 
param object from list 
param listener that will ignored while notifying 
protected void notifyonput object nullable onsharedlistchangedlistener 
createrecyclablefields 
diff mcomparator null mcomparator compare object 
onsharedlistchangedlistener listener mlisteners 
listener continue 
listener onput object diff 
returns whether this list contains specified object 
return code true this list contains specified object code true otherwise 
public boolean contains nullable object 
return mlist containskey object 
nonnull 
public values 
return mlist keyset 
inheritdoc 
override 
public iterator iterator 
return values iterator 
backup 
override 
nullable 
public string tobackuptext 
return null 
override 
public boolean frombackuptext nonnull context context nonnull string input 
return false 
