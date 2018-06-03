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

package achep acdisplay animations 
import android support annotation nonnull 
import android view animation animation 
import android view animation transformation 
import android widget progressbar 
defines simple from animation 
author artem chepurnoy 
public class progressbaranimation extends animation 
nonnull 
private final progressbar mprogressbar 
private from 
private 
public progressbaranimation nonnull progressbar progressbar from 
super 
mprogressbar progressbar 
this from from 
this 
override 
protected void applytransformation float interpolatedtime transformation 
super applytransformation interpolatedtime 
value from from interpolatedtime 
mprogressbar getprogress value 
mprogressbar setprogress value 
public void setrange from 
this from from 
this 
