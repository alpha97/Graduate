package dreamers graphics 
import android animation animator 
import android animation animatorlisteneradapter 
import android animation objectanimator 
import android graphics canvas 
import android graphics color 
import android graphics paint 
import android graphics paint style 
import android graphics rect 
import android build 
import android view animation interpolator 
import android view animation linearinterpolator 
draws material ripple 
class ripplebackground 
private static final interpolator linear_interpolator linearinterpolator 
private static final float global_speed 
private static final float wave_opacity_decay_velocity global_speed 
private static final float wave_outer_opacity_exit_velocity_max global_speed 
private static final float wave_outer_opacity_exit_velocity_min global_speed 
private static final float wave_outer_opacity_enter_velocity global_speed 
private static final float wave_outer_size_influence_max 
private static final float wave_outer_size_influence_min 
private final rippledrawable mowner 
bounds used computing radius 
private final rect mbounds 
full opacity color drawing this ripple 
private mcoloropaque 
maximum alpha value drawing this ripple 
private mcoloralpha 
maximum ripple radius 
private float mouterradius 
screen density used adjust pixel based velocities 
private float mdensity 
software animators 
private objectanimator manimouteropacity 
temporary paint used creating canvas properties 
private paint mtemppaint 
software rendering properties 
private float mouteropacity 
private float mouterx 
private float moutery 
whether should drawing hardware animations 
private boolean mhardwareanimating 
whether hardware acceleration exit animation 
private boolean mcanusehardware 
whether have explicit maximum radius 
private boolean mhasmaxradius 
creates ripple 
public ripplebackground rippledrawable owner rect bounds 
mowner owner 
mbounds bounds 
public void setup maxradius color float density 
mcoloropaque color 
mcoloralpha color alpha color 
maxradius rippledrawable radius_auto 
mhasmaxradius true 
mouterradius maxradius 
else 
final float halfwidth mbounds width 
final float halfheight mbounds height 
mouterradius float math sqrt halfwidth halfwidth halfheight halfheight 
mouterx 
moutery 
mdensity density 
public boolean ishardwareanimating 
return mhardwareanimating 
public void onhotspotboundschanged 
mhasmaxradius 
final float halfwidth mbounds width 
final float halfheight mbounds height 
mouterradius float math sqrt halfwidth halfwidth halfheight halfheight 
suppresswarnings unused 
public void setouteropacity float 
mouteropacity 
invalidateself 
suppresswarnings unused 
public float getouteropacity 
return mouteropacity 
draws ripple centered using specified paint 
public boolean draw canvas paint 
return drawsoftware 
public boolean shoulddraw 
final outeralpha mcoloralpha mouteropacity 
return mcanusehardware mhardwareanimating outeralpha mouterradius 
private boolean drawsoftware canvas paint 
boolean hascontent false 
setcolor mcoloropaque 
final outeralpha mcoloralpha mouteropacity 
outeralpha mouterradius 
setalpha outeralpha 
setstyle style fill 
drawcircle mouterx moutery mouterradius 
hascontent true 
return hascontent 
returns maximum bounds ripple relative ripple center 
public void getbounds rect bounds 
final outerx mouterx 
final outery moutery 
final mouterradius 
bounds outerx outery outerx outery 
starts enter animation 
public void enter 
cancel 
final outerduration wave_outer_opacity_enter_velocity 
final objectanimator outer objectanimator offloat this outeropacity 
build version sdk_int build version_codes jelly_bean_mr outer setautocancel true 
outer setduration outerduration 
outer setinterpolator linear_interpolator 
manimouteropacity outer 
enter animations always thread since unlikely 
that anything interesting happening until user lifts their 
finger 
outer start 
starts exit animation 
public void exit 
cancel 
scale outer opacity opacity velocity based 
size outer radius 
final opacityduration wave_opacity_decay_velocity 
final float outersizeinfluence constrain 
mouterradius wave_outer_size_influence_min mdensity 
wave_outer_size_influence_max mdensity 
final float outeropacityvelocity ripple lerp wave_outer_opacity_exit_velocity_min 
wave_outer_opacity_exit_velocity_max outersizeinfluence 
determine what time inner outer opacity intersect 
inner mopacity wave_opacity_decay_velocity 
outer mouteropacity wave_outer_opacity_velocity 
final inflectionduration math mouteropacity 
wave_opacity_decay_velocity outeropacityvelocity 
final inflectionopacity mcoloralpha mouteropacity 
inflectionduration outeropacityvelocity outersizeinfluence 
exitsoftware opacityduration inflectionduration inflectionopacity 
public static float constrain float amount float float high 
return amount amount high high amount 
jump animations their state caller responsible 
removing ripple from list animating ripples 
public void jump 
endsoftwareanimations 
private void endsoftwareanimations 
manimouteropacity null 
manimouteropacity 
manimouteropacity null 
private paint gettemppaint 
mtemppaint null 
mtemppaint paint 
return mtemppaint 
private void exitsoftware opacityduration inflectionduration inflectionopacity 
final objectanimator outeropacityanim 
inflectionduration 
outer opacity continues increase 
outeropacityanim objectanimator offloat this 
outeropacity inflectionopacity 
build version sdk_int build version_codes jelly_bean_mr 
outeropacityanim setautocancel true 
outeropacityanim setduration inflectionduration 
outeropacityanim setinterpolator linear_interpolator 
chain outer opacity exit animation 
final outerduration opacityduration inflectionduration 
outerduration 
outeropacityanim addlistener animatorlisteneradapter 
override 
public void onanimationend animator animation 
final objectanimator outerfadeoutanim objectanimator offloat 
ripplebackground this outeropacity 
build version sdk_int build version_codes jelly_bean_mr 
outerfadeoutanim setautocancel true 
outerfadeoutanim setduration outerduration 
outerfadeoutanim setinterpolator linear_interpolator 
outerfadeoutanim addlistener manimationlistener 
manimouteropacity outerfadeoutanim 
outerfadeoutanim start 
override 
public void onanimationcancel animator animation 
animation removelistener this 
else 
outeropacityanim addlistener manimationlistener 
else 
outeropacityanim objectanimator offloat this outeropacity 
build version sdk_int build version_codes jelly_bean_mr 
outeropacityanim setautocancel true 
outeropacityanim setduration opacityduration 
outeropacityanim addlistener manimationlistener 
manimouteropacity outeropacityanim 
outeropacityanim start 
cancel animations caller responsible removing 
ripple from list animating ripples 
public void cancel 
cancelsoftwareanimations 
private void cancelsoftwareanimations 
manimouteropacity null 
manimouteropacity cancel 
manimouteropacity null 
private void invalidateself 
mowner invalidateself 
private final animatorlisteneradapter manimationlistener animatorlisteneradapter 
override 
public void onanimationend animator animation 
mhardwareanimating false 
