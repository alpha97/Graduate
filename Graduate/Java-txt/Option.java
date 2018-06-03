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

package achep acdisplay blacklist options 
import android content context 
import android graphics drawable drawable 
import android support annotation nonnull 
import android widget compoundbutton 
import achep acdisplay blacklist appconfig 
import achep acdisplay blacklist blacklist 
import achep base utils operator 
created artem 
public abstract class option extends blacklist onblacklistchangedlistener implements 
compoundbutton oncheckedchangelistener 
private final context mcontext 
private final blacklist mblacklist 
private appconfig mappconfig 
private compoundbutton mcompoundbutton 
private boolean mbroadcasting 

public final drawable icon 
public final charsequence title 
public final charsequence summary 
public option context context compoundbutton 
blacklist blacklist string packagename 
drawable icon 
charsequence title 
charsequence summary 
this icon icon 
this title title 
this summary summary 
mcontext context 
mcompoundbutton 
mblacklist blacklist 
mappconfig mblacklist getappconfig packagename 
public abstract boolean getvalue appconfig config 
return diff mask current option 
achep acdisplay blacklist appconfig diff_hidden 
achep acdisplay blacklist appconfig diff_restricted 
achep acdisplay blacklist appconfig diff_non_clearable 
public abstract getdiffmask 
sets listeners updates current state 
make sure that call link pause later 
public void resume 
mblacklist registerlistener this 
mcompoundbutton setoncheckedchangelistener this 
setchecked getvalue mappconfig 
public void pause 
mblacklist unregisterlistener this 
mcompoundbutton setoncheckedchangelistener null 
public void setcompoundbutton compoundbutton 
mcompoundbutton 
return 
boolean checked ischecked 
mcompoundbutton setoncheckedchangelistener null 
mcompoundbutton 
mcompoundbutton setoncheckedchangelistener this 
setchecked checked 
private void setchecked boolean checked 
mbroadcasting true 
mcompoundbutton setchecked checked 
mbroadcasting false 
override 
public void oncheckedchanged compoundbutton buttonview boolean ischecked 
mbroadcasting 
return 
getvalue mappconfig ischecked 
clone current state cause changed after 
mblacklist saveappconfig mcontext mappconfig this 

blacklist core 

override 
public void onblacklistchanged 
nonnull appconfig confignew 
nonnull appconfig configold diff 
configold equals mappconfig 
mappconfig confignew 
operator bitand diff getdiffmask 
setchecked getvalue confignew 
