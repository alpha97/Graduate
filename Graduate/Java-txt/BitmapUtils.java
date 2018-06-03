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

package achep acdisplay utils 
import android graphics bitmap 
import android graphics color 
import android support annotation nonnull 
created artem 
public class bitmaputils 
public static getaveragecolor nonnull bitmap bitmap 
bitmap onepixelbitmap bitmap createscaledbitmap bitmap true 
color onepixelbitmap getpixel 
onepixelbitmap recycle 
return color 
public static boolean hastransparentcorners nonnull bitmap bitmap 
right bitmap getwidth 
bottom bitmap getheight 
return bitmap getpixel color transparent 
bitmap getpixel right color transparent 
bitmap getpixel bottom color transparent 
bitmap getpixel right bottom color transparent 
