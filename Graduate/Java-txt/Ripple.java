package dreamers graphics 
import android animation animator 
import android animation animatorlisteneradapter 
import android animation objectanimator 
import android graphics canvas 
import android graphics paint 
import android graphics paint style 
import android graphics rect 
import android build 
import android view animation interpolator 
import android view animation linearinterpolator 
draws material ripple 
class ripple 
private static final linearinterpolator linear_interpolator linearinterpolator 
private static final loginterpolator decel_interpolator loginterpolator 
private static final float global_speed 
private static final float wave_touch_down_acceleration global_speed 
private static final float wave_touch_up_acceleration global_speed 
private static final float wave_opacity_decay_velocity global_speed 
private static final long ripple_enter_delay 
private final rippledrawable mowner 
bounds used computing radius 
private final rect mbounds 
full opacity color drawing this ripple 
private mcoloropaque 
maximum ripple radius 
private float mouterradius 
screen density used adjust pixel based velocities 
private float mdensity 
private float mstartingx 
private float mstartingy 
private float mclampedstartingx 
private float mclampedstartingy 
software animators 
private objectanimator manimradius 
private objectanimator manimopacity 
private objectanimator manimx 
private objectanimator manimy 
temporary paint used creating canvas properties 
private paint mtemppaint 
software rendering properties 
private float mopacity float 
private float mouterx 
private float moutery 
values used tween between start positions 
private float mtweenradius 
private float mtweenx 
private float mtweeny 
whether have explicit maximum radius 
private boolean mhasmaxradius 
whether were canceled externally should avoid self removal 
private boolean mcanceled 
creates ripple 
public ripple rippledrawable owner rect bounds float startingx float startingy 
mowner owner 
mbounds bounds 
mstartingx startingx 
mstartingy startingy 
public void setup maxradius color float density 
mcoloropaque color 
maxradius 
mhasmaxradius true 
mouterradius maxradius 
else 
final float halfwidth mbounds width 
final float halfheight mbounds height 
mouterradius float math sqrt halfwidth halfwidth halfheight halfheight 
mouterx 
moutery 
mdensity density 
clampstartingposition 
private void clampstartingposition 
final float mbounds exactcenterx 
final float mbounds exactcentery 
final float mstartingx 
final float mstartingy 
final float mouterradius 

point outside circle clamp circumference 
final double angle math atan 
mclampedstartingx float math angle 
mclampedstartingy float math angle 
else 
mclampedstartingx mstartingx 
mclampedstartingy mstartingy 
public void onhotspotboundschanged 
mhasmaxradius 
final float halfwidth mbounds width 
final float halfheight mbounds height 
mouterradius float math sqrt halfwidth halfwidth halfheight halfheight 
clampstartingposition 
public void setopacity float 
mopacity 
invalidateself 
public float getopacity 
return mopacity 
suppresswarnings unused 
public void setradiusgravity float 
mtweenradius 
invalidateself 
suppresswarnings unused 
public float getradiusgravity 
return mtweenradius 
suppresswarnings unused 
public void setxgravity float 
mtweenx 
invalidateself 
suppresswarnings unused 
public float getxgravity 
return mtweenx 
suppresswarnings unused 
public void setygravity float 
mtweeny 
invalidateself 
suppresswarnings unused 
public float getygravity 
return mtweeny 
draws ripple centered using specified paint 
public boolean draw canvas paint 
final boolean hascontent 
hascontent drawsoftware 
return hascontent 
private boolean drawsoftware canvas paint 
boolean hascontent false 
setcolor mcoloropaque 
final alpha mopacity 
final float radius lerp mouterradius mtweenradius 
alpha radius 
final float lerp 
mclampedstartingx mbounds exactcenterx mouterx mtweenx 
final float lerp 
mclampedstartingy mbounds exactcentery moutery mtweeny 
setalpha alpha 
setstyle style fill 
drawcircle radius 
hascontent true 
return hascontent 
public static float lerp float start float stop float amount 
return start stop start amount 
returns maximum bounds ripple relative ripple center 
public void getbounds rect bounds 
final outerx mouterx 
final outery moutery 
final mouterradius 
bounds outerx outery outerx outery 
specifies starting position relative drawable bounds 
ripple already entered 
public void move float float 
mstartingx 
mstartingy 
clampstartingposition 
starts enter animation 
public void enter 
cancel 
final radiusduration 
math sqrt mouterradius wave_touch_down_acceleration mdensity 
final objectanimator radius objectanimator offloat this radiusgravity 
build version sdk_int build version_codes jelly_bean_mr radius setautocancel true 
radius setduration radiusduration 
radius setinterpolator linear_interpolator 
radius setstartdelay ripple_enter_delay 
final objectanimator objectanimator offloat this xgravity 
build version sdk_int build version_codes jelly_bean_mr setautocancel true 
setduration radiusduration 
setinterpolator linear_interpolator 
setstartdelay ripple_enter_delay 
final objectanimator objectanimator offloat this ygravity 
build version sdk_int build version_codes jelly_bean_mr setautocancel true 
setduration radiusduration 
setinterpolator linear_interpolator 
setstartdelay ripple_enter_delay 
manimradius radius 
manimx 
manimy 
enter animations always thread since unlikely 
that anything interesting happening until user lifts their 
finger 
radius start 
start 
start 
starts exit animation 
public void exit 
cancel 
final float radius lerp mouterradius mtweenradius 
final float remaining 
manimradius null manimradius isrunning 
remaining mouterradius radius 
else 
remaining mouterradius 
final radiusduration math sqrt remaining wave_touch_up_acceleration 
wave_touch_down_acceleration mdensity 
final opacityduration mopacity wave_opacity_decay_velocity 
exitsoftware radiusduration opacityduration 
jump animations their state caller responsible 
removing ripple from list animating ripples 
public void jump 
mcanceled true 
endsoftwareanimations 
mcanceled false 
private void endsoftwareanimations 
manimradius null 
manimradius 
manimradius null 
manimopacity null 
manimopacity 
manimopacity null 
manimx null 
manimx 
manimx null 
manimy null 
manimy 
manimy null 
private paint gettemppaint 
mtemppaint null 
mtemppaint paint 
return mtemppaint 
private void exitsoftware radiusduration opacityduration 
final objectanimator radiusanim objectanimator offloat this radiusgravity 
build version sdk_int build version_codes jelly_bean_mr 
radiusanim setautocancel true 
radiusanim setduration radiusduration 
radiusanim setinterpolator decel_interpolator 
final objectanimator xanim objectanimator offloat this xgravity 
build version sdk_int build version_codes jelly_bean_mr xanim setautocancel true 
xanim setduration radiusduration 
xanim setinterpolator decel_interpolator 
final objectanimator yanim objectanimator offloat this ygravity 
build version sdk_int build version_codes jelly_bean_mr yanim setautocancel true 
yanim setduration radiusduration 
yanim setinterpolator decel_interpolator 
final objectanimator opacityanim objectanimator offloat this opacity 
build version sdk_int build version_codes jelly_bean_mr 
opacityanim setautocancel true 
opacityanim setduration opacityduration 
opacityanim setinterpolator linear_interpolator 
opacityanim addlistener manimationlistener 
manimradius radiusanim 
manimopacity opacityanim 
manimx xanim 
manimy yanim 
radiusanim start 
opacityanim start 
xanim start 
yanim start 
cancels animations caller responsible removing 
ripple from list animating ripples 
public void cancel 
mcanceled true 
cancelsoftwareanimations 
mcanceled false 
private void cancelsoftwareanimations 
manimradius null 
manimradius cancel 
manimradius null 
manimopacity null 
manimopacity cancel 
manimopacity null 
manimx null 
manimx cancel 
manimx null 
manimy null 
manimy cancel 
manimy null 
private void removeself 
owner will invalidate itself 
mcanceled 
mowner removeripple this 
private void invalidateself 
mowner invalidateself 
private final animatorlisteneradapter manimationlistener animatorlisteneradapter 
override 
public void onanimationend animator animation 
removeself 
interpolator with smooth deceleration 
private static final class loginterpolator implements interpolator 
override 
public float getinterpolation float input 
return float math input 
