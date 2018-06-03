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

package achep base drawables 
import android graphics canvas 
import android graphics colorfilter 
import android graphics paint 
import android graphics pixelformat 
import android graphics rect 
import android graphics drawable drawable 
created artem chepurnoy 
public class circledrawable extends drawable 
private final paint mpaint 
public circledrawable 
mpaint paint 
mpaint setantialias true 
mpaint setstyle paint style fill 
public void setcolor color 
mpaint setcolor color ignore alpha bits 
invalidateself 
inheritdoc 
override 
public void draw canvas canvas 
final rect rect getbounds 
canvas drawcircle 
rect exactcenterx 
rect exactcentery 
math rect height rect width mpaint 
inheritdoc 
override 
public void setalpha alpha 
mpaint setalpha alpha 
invalidateself 
inheritdoc 
override 
public void setcolorfilter colorfilter 
mpaint setcolorfilter 
invalidateself 
inheritdoc 
override 
public getopacity 
return pixelformat translucent 
