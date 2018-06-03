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

package achep base fragments leakcanary 
import android support fragment 
import achep base appheap 
import squareup leakcanary refwatcher 
created artem chepurnoy 
public class leakwatchfragment extends fragment 
override 
public void ondestroy 
super ondestroy 
refwatcher refwatcher appheap getrefwatcher 
refwatcher watch this 
