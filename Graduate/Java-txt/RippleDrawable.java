package dreamers graphics 
import android content colorstatelist 
import android graphics canvas 
import android graphics color 
import android graphics colorfilter 
import android graphics paint 
import android graphics pixelformat 
import android graphics porterduff 
import android graphics porterduffxfermode 
import android graphics rect 
import android graphics drawable drawable 
import android build 
import android util displaymetrics 
import android view view 
import java util arrays 
public class rippledrawable extends drawable 
private static final porterduffxfermode dst_in porterduffxfermode porterduff mode dst_in 
private static final porterduffxfermode src_atop porterduffxfermode porterduff mode src_atop 
private static final porterduffxfermode src_over porterduffxfermode porterduff mode src_over 
constant automatically determining maximum ripple radius 
hide 
setmaxradius 
public static final radius_auto 
maximum number ripples supported 
private static final max_ripples 
current ripple effect bounds used constrain ripple effects 
private final rect mhotspotbounds rect 
colorstatelist mcolor colorstatelist valueof color magenta 
mmaxradius radius_auto 
private drawable mcontent 
masking layer layer with mask 
private drawable mmask 
current background actively animating pending entry 
private ripplebackground mbackground 
whether expect draw background when visible 
private boolean mbackgroundactive 
current ripple actively animating pending entry 
private ripple mripple 
whether expect draw ripple when visible 
private boolean mrippleactive 
hotspot coordinates that awaiting activation 
private float mpendingx 
private float mpendingy 
private boolean mhaspending 
lazily created array actively animating ripples inactive ripples 
pruned during draw locations these will change 
private ripple mexitingripples 
private mexitingripplescount 
paint used control appearance ripples 
private paint mripplepaint 
paint used control reveal layer masking 
private paint mmaskingpaint 
target density display into which ripples drawn 
private float mdensity 
whether bounds being overridden 
private boolean moverridebounds 
whether next draw must draw something canvas used work around 
hardware invalidation following render thread accelerated 
animation 
private boolean mneedsdraw 
creates ripple drawable with specified ripple color 
optional content mask drawables 
param color ripple color 
public rippledrawable colorstatelist color 
setcolor color 
public rippledrawable colorstatelist color drawable content 
this color 
mcontent content 
override 
public void jumptocurrentstate 
build version sdk_int 
super jumptocurrentstate 
boolean needsdraw 
mripple null 
mripple jump 
mbackground null 
mbackground jump 
needsdraw cancelexitingripples 
mneedsdraw needsdraw 
invalidateself 
private boolean cancelexitingripples 
final count mexitingripplescount 
final ripple ripples mexitingripples 
count 
ripples cancel 
ripples null 
arrays fill ripples count null 
mexitingripplescount 
return false 
override 
public void setalpha alpha 
mcolor withalpha alpha 
override 
public getalpha 
return color alpha mcolor getdefaultcolor 
override 
public void setcolorfilter colorfilter 
todo implement 
override 
public getopacity 
worst case scenario 
return pixelformat translucent 
override 
protected boolean onstatechange stateset 
final boolean changed super onstatechange stateset 
boolean enabled false 
boolean pressed false 
boolean focused false 
state stateset 
state android attr state_enabled 
enabled true 
state android attr state_focused 
focused true 
state android attr state_pressed 
pressed true 
setrippleactive enabled pressed 
setbackgroundactive focused enabled pressed 
return changed 
private void setrippleactive boolean active 
mrippleactive active 
mrippleactive active 
active 
tryrippleenter 
else 
tryrippleexit 
private void setbackgroundactive boolean active 
mbackgroundactive active 
mbackgroundactive active 
active 
trybackgroundenter 
else 
trybackgroundexit 
override 
protected void onboundschange rect bounds 
super onboundschange bounds 
moverridebounds 
mhotspotbounds bounds 
onhotspotboundschanged 
invalidateself 
override 
public boolean setvisible boolean visible boolean restart 
final boolean changed super setvisible visible restart 
visible 
clearhotspots 
else changed 
just became visible ensure background ripple 
visibilities consistent with their internal states 
mrippleactive 
tryrippleenter 
mbackgroundactive 
trybackgroundenter 
return changed 
public void sethotspot float float 
mripple null mbackground null 
mpendingx 
mpendingy 
mhaspending true 
mripple null 
mripple move 
attempts start enter animation active hotspot fails 
there many animating ripples 
private void tryrippleenter 
mexitingripplescount max_ripples 
this should never happen unless user tapping like maniac 
there that preventing ripples from being removed 
return 
mripple null 
final float 
final float 
mhaspending 
mhaspending false 
mpendingx 
mpendingy 
else 
mhotspotbounds exactcenterx 
mhotspotbounds exactcentery 
mripple ripple this mhotspotbounds 
final color mcolor getcolorforstate getstate color transparent 
mripple setup mmaxradius color mdensity 
mripple enter 
attempts start exit animation active hotspot fails 
there active hotspot 
private void tryrippleexit 
mripple null 
mexitingripples null 
mexitingripples ripple max_ripples 
mexitingripples mexitingripplescount mripple 
mripple exit 
mripple null 
cancels removes active ripple exiting ripples 
background nothing will drawn after this method called 
private void clearhotspots 
boolean needsdraw false 
mripple null 
needsdraw false 
mripple cancel 
mripple null 
mbackground null 
needsdraw mbackground ishardwareanimating 
mbackground cancel 
mbackground null 
needsdraw cancelexitingripples 
mneedsdraw needsdraw 
invalidateself 
public void sethotspotbounds left right bottom 
moverridebounds true 
mhotspotbounds left right bottom 
onhotspotboundschanged 
hide 
public void gethotspotbounds rect outrect 
outrect mhotspotbounds 
notifies animating ripples that hotspot bounds have changed 
private void onhotspotboundschanged 
final count mexitingripplescount 
final ripple ripples mexitingripples 
count 
ripples onhotspotboundschanged 
mripple null 
mripple onhotspotboundschanged 
mbackground null 
mbackground onhotspotboundschanged 
creates active hotspot specified location 
private void trybackgroundenter 
mbackground null 
mbackground ripplebackground this mhotspotbounds 
final color mcolor getcolorforstate getstate color transparent 
mbackground setup mmaxradius color mdensity 
mbackground enter 
private void trybackgroundexit 
mbackground null 
null background need draw 
mbackground exit 
override 
public void draw canvas canvas 
final boolean hasmask mmask null 
final boolean drawnonmaskcontent mcontent null todo contentdrawable null 
final boolean drawmask hasmask mmask getopacity pixelformat opaque 
final rect bounds getdirtybounds 
final savecount canvas save canvas clip_save_flag 
canvas cliprect bounds 
have content draw into layer first 
drawnonmaskcontent 
drawcontentlayer canvas bounds src_over 
next draw ripples into layer necessary need 
mask against underlying content xfermode src_atop 
final porterduffxfermode xfermode hasmask drawnonmaskcontent src_over src_atop 
have background opaque mask draw masking layer 
final backgroundlayer drawbackgroundlayer canvas bounds xfermode drawmask 
backgroundlayer 
drawmask 
drawmaskinglayer canvas bounds dst_in 
canvas restoretocount backgroundlayer 
have ripples opaque mask draw masking layer 
final ripplelayer drawripplelayer canvas bounds xfermode 
ripplelayer 
drawmask 
drawmaskinglayer canvas bounds dst_in 
canvas restoretocount ripplelayer 
failed draw anything just canceled animations 
least draw color that hardware invalidation works correctly 
mneedsdraw 
canvas drawcolor color transparent 
request another draw avoid adding transparent layer 
during next display list refresh 
invalidateself 
mneedsdraw false 
canvas restoretocount savecount 
removes ripple from exiting ripple list 
param ripple ripple remove 
void removeripple ripple ripple 
ripple ripple ripple ripple ripple ripple 
final ripple ripples mexitingripples 
final count mexitingripplescount 
final index getrippleindex ripple 
index 
system arraycopy ripples index ripples index count index 
ripples count null 
mexitingripplescount 
invalidateself 
private getrippleindex ripple ripple 
final ripple ripples mexitingripples 
final count mexitingripplescount 
count 
ripples ripple 
return 
return 
private drawcontentlayer canvas canvas rect bounds porterduffxfermode mode 
mcontent setbounds bounds 
mcontent draw canvas 
return 
private drawbackgroundlayer 
canvas canvas rect bounds porterduffxfermode mode boolean drawmask 
savecount 
mbackground null mbackground shoulddraw 
todo avoid savelayer here push xfermode into 
background render thread animator exit time 
drawmask mode src_over 
savecount canvas savelayer bounds left bounds bounds right 
bounds bottom getmaskingpaint mode 
final float mhotspotbounds exactcenterx 
final float mhotspotbounds exactcentery 
canvas translate 
mbackground draw canvas getripplepaint 
canvas translate 
return savecount 
private drawripplelayer canvas canvas rect bounds porterduffxfermode mode 
boolean drewripples false 
restoretocount 
restoretranslate 
draw ripples update animating ripples array 
final count mexitingripplescount 
final ripple ripples mexitingripples 
count 
final ripple ripple 
count 
ripple ripples 
else mripple null 
ripple mripple 
else 
continue 
masking ripple layer make sure have layer 
first this will merge src_over directly onto canvas 
restoretocount 
final paint maskingpaint getmaskingpaint mode 
final color mcolor getcolorforstate getstate color transparent 
final alpha color alpha color 
maskingpaint setalpha alpha 
translate canvas current hotspot bounds 
restoretranslate canvas save 
canvas translate mhotspotbounds exactcenterx mhotspotbounds exactcentery 
drewripples ripple draw canvas getripplepaint 
always restore translation 
restoretranslate 
canvas restoretocount restoretranslate 
created layer with content merge immediately 
restoretocount drewripples 
canvas restoretocount restoretocount 
restoretocount 
return restoretocount 
private drawmaskinglayer canvas canvas rect bounds porterduffxfermode mode 
ensure that dst_in blends using entire layer 
canvas drawcolor color transparent 
mmask draw canvas 
return 
private paint getripplepaint 
mripplepaint null 
mripplepaint paint 
mripplepaint setantialias true 
return mripplepaint 
private paint getmaskingpaint porterduffxfermode xfermode 
mmaskingpaint null 
mmaskingpaint paint 
mmaskingpaint setxfermode xfermode 
mmaskingpaint setalpha 
return mmaskingpaint 
density which this drawable will rendered 
param metrics display metrics this drawable 
private void settargetdensity displaymetrics metrics 
mdensity metrics density 
mdensity metrics density 
invalidateself 
override 
public boolean isstateful 
return true 
public void setcolor colorstatelist color 
mcolor color 
invalidateself 
override 
public rect getdirtybounds 
return getbounds 
sets maximum ripple radius pixels default value 
link radius_auto defines radius distance from center 
drawable bounds hotspot bounds specified corner 
param maxradius maximum ripple radius pixels 
link radius_auto automatically determine maximum 
radius based bounds 
hide 
getmaxradius 
sethotspotbounds 
public void setmaxradius maxradius 
maxradius radius_auto maxradius 
throw illegalargumentexception maxradius must radius_auto 
mmaxradius maxradius 
return maximum ripple radius pixels link radius_auto 
radius determined automatically 
hide 
setmaxradius 
public getmaxradius 
return mmaxradius 
deprecated 
public static rippledrawable createripple view target color 
return target color 
public static rippledrawable view target color 
return makefor target colorstatelist valueof color 
public static rippledrawable makefor view target colorstatelist colors 
return makefor target colors false 
public static rippledrawable makefor view target colorstatelist colors boolean parentisscrollcontainer 
rippledrawable drawable rippledrawable colors target getbackground 
touchtracker tracker touchtracker drawable 
tracker setinsidescrollcontainer parentisscrollcontainer 
setbackground target drawable 
target setontouchlistener tracker 
return drawable 
suppresswarnings deprecation 
private static void setbackground view target drawable drawable 
build version sdk_int 
target setbackground drawable 
else 
target setbackgrounddrawable drawable 
