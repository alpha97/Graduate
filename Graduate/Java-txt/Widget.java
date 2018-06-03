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

package achep acdisplay components 
import android graphics bitmap 
import android support annotation nonnull 
import android support annotation nullable 
import android view layoutinflater 
import android view view 
import android view viewgroup 
import achep acdisplay config 
import achep acdisplay fragments acdisplayfragment 
import achep base tests check 
import apache commons lang builder equalsbuilder 
import apache commons lang builder hashcodebuilder 
base acdisplay widgets 
author artem chepurnoy 
public abstract class widget 
nonnull 
private final acdisplayfragment mfragment 
nonnull 
protected final callback mcallback 
private viewgroup mview 
private view miconview 
private boolean mattached 
private boolean mstarted 
interface definition callback host fragment 
public interface callback 
requests fragment update widget dynamic background 
getbackground 
getbackgroundmask 
void requestbackgroundupdate nonnull widget widget 
requests fragment restart timeout 
void requesttimeoutrestart nonnull widget widget 
requests fragment stick this widget turn special timeout mode 
void requestwidgetstick nonnull widget widget 
public widget nonnull callback callback nonnull acdisplayfragment fragment 
mcallback callback 
mfragment fragment 
inheritdoc 
override 
public hashcode 
return hashcodebuilder 
append mfragment 
append mview 
append miconview 
append mattached 
append mstarted 
tohashcode 
inheritdoc 
override 
public boolean equals object 
this 
return true 
instanceof widget 
return false 
widget widget widget 
return equalsbuilder 
append mattached widget mattached 
append mstarted widget mstarted 
append mfragment widget mfragment 
append mview widget mview 
append miconview widget miconview 
isequals 
return host fragment 
nonnull 
public acdisplayfragment getfragment 
return mfragment 
nonnull 
public config getconfig 
return mfragment getconfig 
home widget 
public boolean ishomewidget 
return false 
public boolean hasclock 
return false 
dismissing widget 
return code true widget dismissed code false otherwise 
ondismiss 
public boolean isdismissible 
return ishomewidget 
called when widget being dismissed example here need dismiss 
notification from system notification widget 
isdismissible 
public void ondismiss reserved children 
reading widget 
return code true widget read aloud code false otherwise 
getreadaloudtext 
public boolean isreadable 
return false 
return text read aloud 
isreadable 
nullable 
public charsequence getreadaloudtext 
return null 
dynamic background 
return bitmap used background code null background 
getbackgroundmask 
nullable 
public bitmap getbackground 
return null 
return mask widget background code show background 
depending config 
config dynamic_bg_artwork_mask 
config dynamic_bg_notification_mask 
getbackground 
public getbackgroundmask 
return 
life cycle 
public final void start 
mstarted return 
mstarted true 
onstart 
public final void stop 
mstarted return 
mstarted false 
onstop 
public final boolean isstarted 
return mstarted 
public void onstart empty 
this called when link getview view attached host fragment 
here need update view content 
onviewdetached 
isviewattached 
public void onviewattached 
check getinstance isfalse mattached 
mattached true 
this called when link getview view detached from host fragment 
onviewattached 
isviewattached 
public void onviewdetached 
check getinstance istrue mattached 
mattached false 
public boolean isviewattached 
return mattached 
public void onstop empty 
views 
return icon this widget 
oncreateiconview android view layoutinflater android view viewgroup 
public view geticonview 
return miconview 
returns view widget please note that this view reused 
other similar widgets 
return main view this widget 
onviewattached 
onviewdetached 
isviewattached 
oncreateview android view layoutinflater android view viewgroup android view viewgroup 
public viewgroup getview 
return mview 
public view createiconview layoutinflater inflater viewgroup container 
miconview oncreateiconview inflater container 
return miconview 
public viewgroup createview layoutinflater inflater viewgroup container viewgroup view 
mview oncreateview inflater container view 
return mview 
protected view oncreateiconview 
nonnull layoutinflater inflater 
nonnull viewgroup container 
return null 
protected viewgroup oncreateview 
nonnull layoutinflater inflater 
nonnull viewgroup container 
nullable viewgroup view 
return null 
