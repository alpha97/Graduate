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

package achep acdisplay blacklist 
import android content context 
import android support annotation nonnull 
import android support annotation nullable 
import android util 
import achep base content sharedlist 
blacklist also known features 
author artem chepurnoy 
saveappconfig android content context appconfig sharedlist onsharedlistchangedlistener 
getappconfig string 
public final class blacklist extends sharedlist appconfig appconfig saver 
private static final string blacklist 
public static final string pref_name blacklist 
private static blacklist sblacklist 
interface definition callback invoked 
when blacklist changed 
author artem chepurnoy 
public static abstract class onblacklistchangedlistener 
implements onsharedlistchangedlistener appconfig 
called blacklist changed 
param confignew instance config 
param configold instance previous config null 
param diff difference between configs 
public abstract void onblacklistchanged 
nonnull appconfig confignew 
nonnull appconfig configold diff 
inheritdoc 
override 
public final void onput nonnull appconfig objectnew appconfig objectold diff 
onblacklistchanged objectnew objectold diff 
should never called 
onblacklistchanged appconfig appconfig 
override 
public final void onremoved nonnull appconfig objectremoved 
notified about removing item from blacklist 
public static synchronized blacklist getinstance 
sblacklist null 
sblacklist blacklist 
return sblacklist 
private blacklist 
super 
this called link achep acdisplay oncreate create 
achep base content sharedlist init android content context 
override 
public void init nonnull context context 
super init context 
inheritdoc 
nonnull 
override 
protected string getpreferencesfilename 
return pref_name 
inheritdoc 
nonnull 
override 
protected appconfig saver oncreatesaver 
return appconfig saver 
inheritdoc 
override 
protected comparator oncreatecomparator 
return appconfig comparator 
inheritdoc 
override 
protected boolean isoverwriteallowed nonnull appconfig object 
return true 
managing config 
public void saveappconfig context context appconfig config 
onsharedlistchangedlistener listener 
config equalstodefault 
need remove defaults save blacklist size 
super remove context config listener 
return 
appconfig clone appconfig config packagename 
appconfig copy config clone 
super context clone listener overwriting enabled 
creates instance link achep acdisplay blacklist appconfig 
fills with present data 
param packagename package name need application 
return instance config filled with present data 
fill appconfig 
nonnull 
public appconfig getappconfig nonnull string packagename 
return fill appconfig packagename 
nonnull 
public appconfig fill nonnull appconfig config 
appconfig values 
equals config 
appconfig copy config 
return config 
appconfig reset config 
return config 
bull shit protection 
this will throw exception please 
link saveappconfig context appconfig sharedlist onsharedlistchangedlistener instead 
nullable 
override 
public appconfig nonnull context context nonnull appconfig object 
nullable onsharedlistchangedlistener 
throw runtimeexception 
this will throw exception please 
link saveappconfig context appconfig sharedlist onsharedlistchangedlistener instead 
override 
public void remove nonnull context context nonnull appconfig object 
nullable onsharedlistchangedlistener 
throw runtimeexception 
dismissing widget 
inheritdoc 
override 
protected final void notifyonremoved nonnull appconfig object onsharedlistchangedlistener 
change remove event event about putting 
empty config list 
notifyonput appconfig object packagename object 
inheritdoc 
override 
protected final void notifyonput appconfig object appconfig onsharedlistchangedlistener 
null 
allow nulls 
appconfig object packagename 
notify listeners 
super notifyonput object 
