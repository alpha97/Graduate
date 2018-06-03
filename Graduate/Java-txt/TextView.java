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

package achep base widgets 
import android content context 
import android content typedarray 
import android build 
import android support widget appcompattextview 
import android util attributeset 
import achep acdisplay config 
import achep acdisplay 
import achep base device 
import drivemode android typeface typefacehelper 
created artem 
public class textview extends appcompattextview 
private static final string textview 
public textview context context 
this context null 
public textview context context attributeset attrs 
this context attrs 
public textview context context attributeset attrs defstyle 
super context attrs 
isineditmode return 
typedarray context obtainstyledattributes attrs styleable textview 
config getinstance isoverridingfontsenabled 
string fontname getstring styleable textview_font 
fontname null 
maximumsdkversion getint 
styleable textview_font_beforeapi 
build version_codes lollipop 
device hastargetapi maximumsdkversion 
fontname indexof fontname 
typefacehelper getinstance settypeface this fonts fontname 
recycle 
