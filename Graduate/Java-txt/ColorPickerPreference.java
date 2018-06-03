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

package achep acdisplay preferences 
import android content context 
import android graphics color 
import android support annotation nonnull 
import android util attributeset 
import android view viewgroup 
import android widget radiobutton 
import android widget radiogroup 
import achep acdisplay config 
import achep acdisplay 
import achep base content configbase 
import achep base preferences materialdialogpreference 
import achep base utils viewutils 
import afollestad materialdialogs materialdialog 
import larswerkman holocolorpicker colorpicker 
import larswerkman holocolorpicker saturationbar 
import larswerkman holocolorpicker valuebar 
preference configure size collapsed views 
author artem chepurnoy 
public class colorpickerpreference extends materialdialogpreference 
return original color link israndomenabled code false 
random otherwise 
public static getcolor color 
israndomenabled color 
math random random_colors length 
return random_colors 
return color 
return code true should generate random colors instead 
this code false otherwise 
getcolor 
public static boolean israndomenabled color 
return color alpha color random_color_alpha_mask 
constant alpha color that defines random color option 
private static final random_color_alpha_mask 
main color from material palette 
random colors list 
private static final random_colors 
xfff 
xffe pink 
purple 
deep purple 
indigo 
blue 
light blue 
cyan 
teal 
green 
light green 
xffcddc lime 
xffffeb yellow 
xffffc amber 
xffff orange 
xffff deep orange 
blue grey 
private static final string colorpickerpreference 
private final configbase option moption 
private final config mconfig 
private viewgroup mcolorpanel 
private colorpicker mcolorpicker 
private radiobutton mradiocustomcolor 
private radiobutton mradiorandomcolor 
public colorpickerpreference context context attributeset attrs 
super context attrs 
mconfig config getinstance 
moption mconfig getoption getkey 
nonnull 
override 
public materialdialog onbuilddialog nonnull materialdialog builder builder 
materialdialog builder 
customview layout dialog_preference_colorpicker true 
build 
color moption read mconfig 
boolean randomcolor color alpha color random_color_alpha_mask 
randomcolor color color argb 
radiogroup radiogroup getcustomview findviewbyid radios 
mcolorpanel viewgroup findviewbyid custom_color_panel 
mcolorpicker colorpicker mcolorpanel findviewbyid picker 
mcolorpicker addsaturationbar saturationbar mcolorpanel findviewbyid saturationbar 
mcolorpicker addvaluebar valuebar mcolorpanel findviewbyid valuebar 
mcolorpicker setcolor color 
mcolorpicker setoldcentercolor color 
setup radio things 
mradiocustomcolor radiobutton findviewbyid custom_color 
mradiorandomcolor radiobutton findviewbyid random_color 
setoncheckedchangelistener radiogroup oncheckedchangelistener 
override 
public void oncheckedchanged radiogroup group checkedid 
viewutils setvisible mcolorpanel mradiocustomcolor ischecked 
check randomcolor 
mradiorandomcolor getid 
mradiocustomcolor getid 
return 
override 
protected void ondialogclosed boolean positiveresult 
super ondialogclosed positiveresult 
positiveresult 
return 
save changes config 
boolean randomcolor mradiorandomcolor ischecked 
color mcolorpicker getcolor 
randomcolor color color argb random_color_alpha_mask 
moption write mconfig getcontext color null 
