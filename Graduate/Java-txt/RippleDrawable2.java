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
import android annotation targetapi 
import android content colorstatelist 
import android graphics colorfilter 
import android graphics paint 
import android graphics porterduff 
import android graphics porterduffcolorfilter 
import android graphics drawable drawable 
import android graphics drawable rippledrawable 
import android build 
import android support annotation nonnull 
import java lang reflect invocationtargetexception 
import java lang reflect method 
created artem chepurnoy 
author artem chepurnoy 
targetapi build version_codes lollipop 
public class rippledrawable extends rippledrawable 
creates ripple drawable with specified ripple color 
optional content mask drawables 
param color ripple color 
param content content drawable code null 
param mask mask drawable code null 
public rippledrawable colorstatelist color drawable content drawable mask 
super color content mask 
inheritdoc 
override 
public void setcolorfilter color nonnull porterduff mode mode 
setcolorfilter porterduffcolorfilter color mode 
inheritdoc 
override 
public void setcolorfilter colorfilter colorfilter 
super setcolorfilter colorfilter 
getripplepaint setcolorfilter colorfilter 
fixme ripple backfires with original color 
private paint getripplepaint 

method method rippledrawable class getdeclaredmethod getripplepaint 
method setaccessible true 
return paint method invoke this 
catch nosuchmethodexception 
invocationtargetexception 
illegalaccessexception ignored 
normally should never happen 
return paint 
