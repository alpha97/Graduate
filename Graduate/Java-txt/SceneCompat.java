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

package achep acdisplay compat 
import android transition scene 
import android util 
import android view viewgroup 
import android view viewparent 
import achep base device 
import static achep base build debug 
this restricted link android transition scene compatibility 
class supporting android below 
author artem chepurnoy 
public class scenecompat 
private static final string scenecompat 
private final viewgroup mview 
private final viewgroup mparent 
private scene mscene 
public scenecompat viewgroup parent viewgroup view 
device haskitkatapi 
mscene scene parent view 
mparent parent 
mview view 
public scene getscene 
return mscene 
public viewgroup getview 
return mview 
public void enter 
device haskitkatapi 
fixme this workaround that more research 
viewparent mview getparent 
null 
debug removing view mview from 
viewgroup removeview mview 
mscene enter 
else 
mparent removeallviews 
mparent addview mview 
