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

package achep base animations 
import android animation animator 
this adapter class provides empty implementations methods from 
link android animation animator animatorlistener 
custom listener that cares only about subset methods this listener 
simply subclass this adapter class instead implementing interface directly 

addition provides link iscanceled method 
author artem chepurnoy 
public class animatorlisteneradapter extends android animation animatorlisteneradapter 
private boolean mcanceled 
override 
public void onanimationstart animator animation 
mcanceled false 
super onanimationstart animation 
override 
public void onanimationcancel animator animation 
mcanceled true 
super onanimationcancel animation 
return code true animation canceled code false otherwise 
public boolean iscanceled 
return mcanceled 
