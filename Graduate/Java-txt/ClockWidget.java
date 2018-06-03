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

package achep acdisplay components 
import android graphics bitmap 
import android support annotation nonnull 
import android support annotation nullable 
import android view layoutinflater 
import android view viewgroup 
import achep acdisplay 
import achep acdisplay fragments acdisplayfragment 
very simple clock widget link achep acdisplay fragments acdisplayfragment 
author artem chepurnoy 
public class clockwidget extends widget 
private static final string clockwidget 
public clockwidget nonnull callback callback nonnull acdisplayfragment fragment 
super callback fragment 
inheritdoc 
override 
public boolean ishomewidget 
return true 
inheritdoc 
override 
public boolean hasclock 
return true 
override 
protected viewgroup oncreateview 
nonnull layoutinflater inflater 
nonnull viewgroup container 
nullable viewgroup sceneview 
boolean initialize sceneview null 
initialize 
sceneview viewgroup inflater inflate layout acdisplay_scene_clock container false 
assert sceneview null 
initialize 
return sceneview 
return sceneview 
nullable 
override 
public bitmap getbackground 
return null 
override 
public getbackgroundmask 
return 
