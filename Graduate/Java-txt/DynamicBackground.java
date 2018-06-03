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

package achep acdisplay 
import android animation animator 
import android animation animatorinflater 
import android content context 
import android content resources 
import android graphics bitmap 
import android graphics drawable bitmapdrawable 
import android graphics drawable drawable 
import android graphics drawable transitiondrawable 
import android support annotation nonnull 
import android support annotation nullable 
import android view view 
import android widget imageview 
import achep acdisplay config 
import achep acdisplay 
import achep acdisplay fragments acdisplayfragment 
import achep base animations animatorlisteneradapter 
import achep base utils operator 
created artem chepurnoy 
public abstract class dynamicbackground 
protected static final string dynamicbackground 
nonnull 
public static dynamicbackground newinstance 
nonnull acdisplayfragment fragment 
nullable imageview imageview 
return dynamicbackgroundcompat fragment imageview 
protected final acdisplayfragment mfragment 
protected final imageview mimageview 
protected dynamicbackground nonnull acdisplayfragment fragment 
nullable imageview imageview 
mfragment fragment 
mimageview imageview 
mimageview null 
return 
initbackground 
protected abstract void initbackground 
protected abstract void dispatchsetbackgroundinternal nullable bitmap bitmap 
clears background 
dispatchsetbackground android graphics bitmap 
public void dispatchclearbackground 
dispatchsetbackground null 
smoothly sets background this feature known dynamic background 
param bitmap bitmap display code null hide previous background 
param mask following 
link config dynamic_bg_artwork_mask 
link config dynamic_bg_notification_mask 
code bypass mask checking 
dispatchclearbackground 
public void dispatchsetbackground nullable bitmap bitmap mask 
config config mfragment getconfig 
mask operator bitand config getdynamicbackgroundmode mask 
dispatchsetbackground bitmap 
smoothly sets background 
private void dispatchsetbackground nullable bitmap bitmap 
mimageview null return 
mfragment ispowersavemode animations background 
mimageview setimagebitmap null 
else 
dispatchsetbackgroundinternal bitmap 
inheritdoc 
private static class dynamicbackgroundcompat extends dynamicbackground 
private animator menteranimation 
private animator mexitanimation 
inheritdoc 
dynamicbackgroundcompat 
nonnull acdisplayfragment fragment 
nullable imageview imageview 
super fragment imageview 
override 
protected void initbackground 
assert mimageview null 
context context mfragment getactivity 
setup enter animation 
menteranimation animatorinflater loadanimator context animator background_enter 
menteranimation settarget mimageview 
menteranimation addlistener animatorlisteneradapter 
override 
public void onanimationstart animator animation 
mimageview setvisibility view visible 
setup exit animation 
mexitanimation animatorinflater loadanimator context animator background_exit 
mexitanimation settarget mimageview 
mexitanimation addlistener animatorlisteneradapter 
override 
public void onanimationend animator animation 
iscanceled return 
mimageview setvisibility view gone 
mimageview setimagedrawable null 
override 
protected void dispatchsetbackgroundinternal nullable bitmap bitmap 
assert mimageview null 
bitmap null clear background 
mimageview getdrawable null 
menteranimation cancel 
mexitanimation start 
else background 
bitmapdrawable drawable bitmapdrawable getresources bitmap 
drawable drawableprev mimageview getdrawable 
mexitanimation isrunning 
mexitanimation cancel 
menteranimation setupendvalues 
drawableprev null mfragment isanimatableauto 
mimageview setimagedrawable drawable 
menteranimation start 
else 
drawableprev instanceof transitiondrawable 
transitiondrawable transitiondrawable drawableprev 
drawableprev getdrawable 
resettransition 
drawable arraydrawable drawable drawableprev drawable 
transitiondrawable transitiondrawable transitiondrawable arraydrawable 
transitiondrawable setcrossfadeenabled true 
mimageview setimagedrawable transitiondrawable 
start cross fade animation 
duration getresources getinteger android integer config_shortanimtime 
transitiondrawable starttransition duration 
nonnull 
private resources getresources 
return mfragment getresources 
