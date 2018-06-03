copyright android open source project 
licensed under apache license version license 
this file except compliance with license 
obtain copy license 
http apache licenses license 
unless required applicable agreed writing software 
distributed under license distributed basis 
without warranties conditions kind either express implied 
license specific language governing permissions 
limitations under license 
modified achep artemchep gmail 
package achep acdisplay widgets status 
import android content broadcastreceiver 
import android content context 
import android content intent 
import android content intentfilter 
import android content resources 
import android content typedarray 
import android graphics canvas 
import android graphics paint 
import android graphics path 
import android graphics porterduff 
import android graphics porterduffxfermode 
import android graphics rectf 
import android graphics typeface 
import android batterymanager 
import android support annotation nonnull 
import android util attributeset 
import android view view 
import android widget textview 
import achep acdisplay 
import achep base utils resutils 
todo bring support 
public class batterymeterview extends textview 
public static final string batterymeterview class getsimplename 
public static final event_level 
public static final event_charging 
public enum batterymetermode 
battery_meter_icon_portrait 
protected class batterytracker extends broadcastreceiver 
public static final unknown_level 
current battery status 
boolean present true 
boolean plugged 
plugtype 
status 
level unknown_level 
override 
public void onreceive context context intent intent 
switch intent getaction 
case intent action_battery_changed 
final boolean chargingold indicatecharging 
final levelold level 
battery level 
level 
intent getintextra batterymanager extra_level 
intent getintextra batterymanager extra_scale 
present intent getbooleanextra batterymanager extra_present true 
plugtype intent getintextra batterymanager extra_plugged 
plugged plugtype 
status intent getintextra batterymanager extra_status 
batterymanager battery_status_unknown 
update view 
settext string format mbatteryformat this level 
setcontentdescription resutils getstring context string accessibility_battery_level level 
notify listener 
monbatterychangedlistener null 
event 
event chargingold indicatecharging event_charging 
event levelold level event_level 
event 
monbatterychangedlistener onbatterychanged batterymeterview this event 
break 
return code true device charging code false otherwise 
protected boolean indicatecharging 
return status batterymanager battery_status_charging 
status batterymanager battery_status_full plugged 
interface definition callback invoked 
when battery status level other changed 
setonbatterychangedlistener onbatterychangedlistener 
public interface onbatterychangedlistener 
invoked when battery status level other changed 
param event events link event_level link event_charging other 
void onbatterychanged batterymeterview view event 
protected batterymetermode mbatterymetermode 
final mcolors 
private string mbatteryformat 
private string mwarningstring 
private final mchargecolor 
private final mbatteryheight 
private final mbatterywidth 
private final mbatterypadding 
private onbatterychangedlistener monbatterychangedlistener 
private boolean mattached 
private context mcontext 
protected batterytracker mtracker batterytracker 
private batterymeterdrawable mbatterydrawable 
private final object mlock object 
private mpaddingleft 
override 
public void onattachedtowindow 
super onattachedtowindow 
mattached true 
intentfilter filter intentfilter intent action_battery_changed 
intent sticky getcontext registerreceiver mtracker filter 
load battery level 
sticky null 
mtracker onreceive getcontext sticky 
override 
public void ondetachedfromwindow 
super ondetachedfromwindow 
mattached false 
getcontext unregisterreceiver mtracker 
public batterymeterview context context 
this context null 
public batterymeterview context context attributeset attrs 
this context attrs 
public batterymeterview context context attributeset attrs defstyle 
super context attrs defstyle 
mcontext context 
typedarray context obtainstyledattributes attrs styleable batterymeterview defstyle 
mbatteryheight getdimensionpixelsize styleable batterymeterview_battery_height 
mbatterywidth getdimensionpixelsize styleable batterymeterview_battery_width 
mbatterypadding getdimensionpixelsize styleable batterymeterview_battery_padding 
setpadding getpaddingleft getpaddingtop getpaddingright getpaddingbottom 
recycle 
final resources context getresources 
isineditmode 
typedarray levels obtaintypedarray array batterymeter_color_levels 
typedarray colors obtaintypedarray array batterymeter_color_values 
final levels length 
mcolors 

mcolors levels getint 
mcolors colors getcolor 
levels recycle 
colors recycle 
else 
mcolors 
getcolor color batterymeter_critical 
getcolor color batterymeter_low 
getcolor color batterymeter_full 
mchargecolor getresources getcolor color batterymeter_charge_color 
mbatteryformat getresources getstring string batterymeter_precise 
mwarningstring context getstring string batterymeter_very_low_overlay_symbol 
setmode batterymetermode battery_meter_icon_portrait 
mbatterydrawable onsizechanged mbatterywidth mbatteryheight 
setlayertype view layer_type_software null 
override 
public void setpadding left right bottom 
apply additional padding leave free space 
battery meter drawing 
final leftextended left mbatterypadding mpaddingleft mbatterywidth mbatterypadding 
super setpadding leftextended right bottom 
mpaddingleft left 
override 
public getpaddingleft 
return mpaddingleft 
private batterymeterdrawable createbatterymeterdrawable batterymetermode mode 
resources mcontext getresources 
return normalbatterymeterdrawable 
override 
protected void onmeasure widthmeasurespec heightmeasurespec 
super onmeasure widthmeasurespec heightmeasurespec 
heightmin mbatteryheight gettotalpaddingtop gettotalpaddingbottom 
height math getmeasuredheight heightmin 
setmeasureddimension getmeasuredwidth height 
public void setonbatterychangedlistener onbatterychangedlistener listener 
monbatterychangedlistener listener 
return battery charge level from code 
public getbatterylevel 
return mtracker level 
return code true charging code false otherwise 
public boolean getbatterycharging 
return mtracker indicatecharging 
public getcolorforlevel percent 
thresh color 
mcolors length 
thresh mcolors 
color mcolors 
percent thresh 
return color 
throw runtimeexception broken color levels 
public void setmode batterymetermode mode 
synchronized mlock 
mbatterymetermode mode 
return 
mbatterymetermode mode 
mbatterydrawable null 
mbatterydrawable ondispose 
mbatterydrawable createbatterymeterdrawable mode 
mbatterymetermode batterymetermode battery_meter_icon_portrait 
normalbatterymeterdrawable drawable normalbatterymeterdrawable mbatterydrawable 
drawable loadboltpoints mcontext getresources 
mattached 
postinvalidate 
override 
public void ondraw nonnull canvas 
super ondraw 
synchronized mlock 
mbatterydrawable null 
mbatterydrawable ondraw mtracker 
protected interface batterymeterdrawable 
void ondraw canvas batterytracker tracker 
void onsizechanged oldw oldh 
void ondispose 
protected class normalbatterymeterdrawable implements batterymeterdrawable 
public static final full 
public static final empty 
public static final float subpixel inset rects softer edges 
private boolean mdisposed 
private paint mframepaint mbatterypaint mwarningtextpaint mboltpaint 
private mbuttonheight 
private float mwarningtextheight 
private final float mboltpoints 
private final path mboltpath path 
private final rectf mframe rectf 
private final rectf mbuttonframe rectf 
private final rectf mclipframe rectf 
private final rectf mboltframe rectf 
public normalbatterymeterdrawable resources 
super 
mdisposed false 
mframepaint paint paint anti_alias_flag 
mframepaint setcolor getcolor color batterymeter_frame_color 
mframepaint setdither true 
mframepaint setstrokewidth 
mframepaint setstyle paint style fill_and_stroke 
mframepaint setxfermode porterduffxfermode porterduff mode dst_atop 
mbatterypaint paint paint anti_alias_flag 
mbatterypaint setdither true 
mbatterypaint setstrokewidth 
mbatterypaint setstyle paint style fill_and_stroke 
mwarningtextpaint paint paint anti_alias_flag 
mwarningtextpaint setcolor mcolors 
typeface font typeface create sans serif typeface bold 
mwarningtextpaint settypeface font 
mwarningtextpaint settextalign paint align center 
mboltpaint paint 
mboltpaint setantialias true 
mboltpaint setcolor getcolor color batterymeter_bolt_color 
mboltpoints loadboltpoints 
override 
public void ondraw canvas batterytracker tracker 
mdisposed return 
final level tracker level 
level batterytracker unknown_level return 
float drawfrac float level 
final gettotalpaddingtop getheight gettotalpaddingtop gettotalpaddingbottom mbatteryheight 
final getpaddingleft 
height mbatteryheight 
width mbatterywidth 
mbuttonheight height 
mframe width height 
mframe offset 
mbuttonframe 
mframe left width 
mframe 
mframe right width 
mframe mbuttonheight cover frame border intersecting area 
mbuttonframe subpixel 
mbuttonframe left subpixel 
mbuttonframe right subpixel 
mframe mbuttonheight 
mframe left subpixel 
mframe subpixel 
mframe right subpixel 
mframe bottom subpixel 
first draw battery shape 
drawrect mframe mframepaint 
fill 
final color tracker plugged mchargecolor getcolorforlevel level 
mbatterypaint setcolor color 
level full 
drawfrac 
else level empty 
drawfrac 
drawrect mbuttonframe drawfrac mbatterypaint mframepaint 
mclipframe mframe 
mclipframe mframe height drawfrac 
save canvas clip_save_flag 
cliprect mclipframe 
drawrect mframe mbatterypaint 
restore 
tracker indicatecharging 
draw bolt 
final float mframe left mframe width 
final float mframe mframe height 
final float mframe right mframe width 
final float mframe bottom mframe height 
mboltframe left mboltframe 
mboltframe right mboltframe bottom 
mboltframe 
mboltpath reset 
mboltpath moveto 
mboltframe left mboltpoints mboltframe width 
mboltframe mboltpoints mboltframe height 
mboltpoints length 
mboltpath lineto 
mboltframe left mboltpoints mboltframe width 
mboltframe mboltpoints mboltframe height 
mboltpath lineto 
mboltframe left mboltpoints mboltframe width 
mboltframe mboltpoints mboltframe height 
drawpath mboltpath mboltpaint 
else level empty 
final float mbatterywidth 
final float mbatteryheight mwarningtextheight 
drawtext mwarningstring mwarningtextpaint 
override 
public void ondispose 
mdisposed true 
override 
public void onsizechanged oldw oldh 
mwarningtextpaint settextsize 
mwarningtextheight mwarningtextpaint getfontmetrics ascent 
private float loadboltpoints resources 
isineditmode 
final getintarray getboltpointsarrayresource 
maxx maxy 
length 
maxx math maxx 
maxy math maxy 
final float ptsf float length 
length 
ptsf float maxx 
ptsf float maxy 
return ptsf 
else 
return float 
protected getboltpointsarrayresource 
return array batterymeter_bolt_points 
