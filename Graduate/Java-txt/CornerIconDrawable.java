package achep acdisplay drawables 
import android content context 
import android graphics canvas 
import android graphics colorfilter 
import android graphics pixelformat 
import android graphics drawable drawable 
import android support annotation nonnull 
import android support annotation nullable 
import achep acdisplay config 
import achep base content configbase 
created artem chepurnoy 
public class cornericondrawable extends drawable 
private final string mkey 
private drawable mdrawable 
private mactionid 
private malpha 
config listener 
nonnull 
private final configbase onconfigchangedlistener mconfiglistener 
configbase onconfigchangedlistener 
override 
public void onconfigchanged nonnull configbase config 
nonnull string 
nonnull object value 
equals mkey update config getcontext 
public cornericondrawable nonnull string 
mkey 
public void start nonnull context context 
config getinstance registerlistener mconfiglistener 
update context 
public void stop 
config getinstance unregisterlistener mconfiglistener 
private void update nonnull context context 
config config config getinstance 
and_clear_current_drawable 
actionid config getoption mkey read config 
mactionid mactionid actionid return 
actionid config corner_unlock break and_clear_current_drawable 
final iconres cornerhelper geticonresource actionid 
drawable drawable resutils getdrawable context iconres 
drawable null 
drawable drawable mutate 
drawable setalpha malpha 
drawable setbounds 
drawable getintrinsicwidth 
drawable getintrinsicheight 
update current bounds 
setbounds drawable getbounds 
setdrawable drawable 
return 
setdrawable null 
private void setdrawable nullable drawable drawable 
mdrawable drawable 
inheritdoc 
override 
public void draw canvas canvas 
mdrawable null mdrawable draw canvas 
inheritdoc 
override 
public void setalpha alpha 
mdrawable null mdrawable setalpha alpha 
malpha alpha 
inheritdoc 
override 
public void setcolorfilter colorfilter 
throw runtimeexception 
inheritdoc 
override 
public getopacity 
return pixelformat translucent 
