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
import android animation animator 
import android animation objectanimator 
import android graphics canvas 
import android graphics color 
import android graphics colorfilter 
import android graphics paint 
import android graphics path 
import android graphics pixelformat 
import android graphics rect 
import android graphics drawable drawable 
import android support annotation nonnull 
import android support annotation nullable 
import android util property 
import achep base utils floatproperty 
class creating simple transformation buttons very simple 
perfectly fits simple material icons transformation 
author artem chepurnoy 
achep base drawables playpausedrawable 
public abstract class transformationdrawable extends drawable 
private final path mpath 
private final paint mpaint 
private final float mvertex 
private final float mvertexfrom 
private msize integer max_value 
private float mprogress 
private mtoshape 
private final animator manimator objectanimator offloat this transform 
private final static property transformationdrawable float transform 
floatproperty transformationdrawable settransformation 
override 
public void setvalue transformationdrawable object float value 
object settransformation value 
override 
public float transformationdrawable object 
return object gettransformation 
protected transformationdrawable nonnull float vertex 
mvertexfrom float vertex length 
mvertex vertex 
mprogress 
mpath path 
mpath setfilltype path filltype winding 
mpaint paint 
mpaint setantialias true 
mpaint setcolor color white 
mpaint setstyle paint style fill 
public void transformtoshape 
transformtoshape true 
public void transformtoshape boolean animate 
settargetshape animate manimator isrunning 
target shape then probably should animate 
change 
manimator start 
sets size canvas rectangle 
param size size pixels 
public void setsize size 
msize size 
public boolean settargetshape 
mtoshape return false 
updatevertexfrom 
mtoshape 
return true 
public void settransformation float progress 
mprogress progress 
rect rect getbounds 
final float size math math 
rect right rect left 
rect bottom rect msize 
final float left rect left rect right rect left size 
final float rect rect bottom rect size 
mpath reset 
mpath moveto 
left calctransformation progress size 
calctransformation progress size 
mvertex length 
mpath lineto 
left calctransformation progress size 
calctransformation progress size 
mpath close 
invalidateself 
public float gettransformation 
return mprogress 
private float calctransformation type float progress float size 
float mvertexfrom type progress 
float mvertex mtoshape type progress 
return size 
updates current init state icon while animating icon will 
from this state defined link mvertex vertexes 
private void updatevertexfrom 
length mvertexfrom length 
length 
mvertexfrom calctransformation mprogress 
mvertexfrom calctransformation mprogress 
inheritdoc 
override 
protected void onboundschange rect bounds 
super onboundschange bounds 
settransformation mprogress 
inheritdoc 
override 
public void draw canvas canvas 
canvas drawpath mpath mpaint 
inheritdoc 
override 
public void setalpha alpha 
mpaint setalpha alpha 
invalidateself 
inheritdoc 
override 
public void setcolorfilter nullable colorfilter 
mpaint setcolorfilter 
invalidateself 
specify optional color filter drawable note that color 
containing alpha well this value 
multiplied meaning that alpha value regardless 
values link color color class more details 
param color color 
setcolorfilter colorfilter 
public void setcolor color 
mpaint setcolor color 
invalidateself 
inheritdoc 
override 
public getopacity 
return pixelformat translucent 
