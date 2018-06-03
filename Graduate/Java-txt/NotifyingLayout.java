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

package achep acdisplay view 
import android content context 
import android util attributeset 
import android widget framelayout 
created achep acdisplay 
author artem chepurnoy 
public class notifyinglayout extends framelayout 
private onpressstatechangedlistener monpressstatechangedlistener 
public interface onpressstatechangedlistener 
void onpressstatechanged notifyinglayout view boolean pressed 
public notifyinglayout context context 
super context 
public notifyinglayout context context attributeset attrs 
super context attrs 
public notifyinglayout context context attributeset attrs defstyleattr 
super context attrs defstyleattr 
public void setonpressstatechangedlistener onpressstatechangedlistener listener 
monpressstatechangedlistener listener 
inheritdoc 
override 
public void setpressed boolean pressed 
boolean notify pressed ispressed 
super setpressed pressed 
monpressstatechangedlistener null notify 
monpressstatechangedlistener onpressstatechanged this pressed 
