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

package achep acdisplay widgets 
import android annotation suppresslint 
import android content context 
import android content typedarray 
import android graphics canvas 
import android support annotation nonnull 
import android support annotation nullable 
import android util attributeset 
import achep acdisplay 
import achep base device 
inheritdoc 
public class progressbar extends android widget progressbar 
private boolean mmirrored 
private onprogresschangelistener mlistener 
callback that notifies clients when progress level been changed 
public interface onprogresschangelistener 
notification that progress level changed 
param progressbar progressbar whose progress changed 
param progress current progress level this will range link progressbar getmax 
void onprogresschanged progressbar progressbar progress 
void onmaxchanged progressbar progressbar 
public progressbar context context 
this context null 
public progressbar context context attributeset attrs 
this context attrs 
public progressbar context context attributeset attrs defstyle 
super context attrs defstyle 
init context attrs defstyle 
private void init nonnull context context nullable attributeset attrs defstyle 
attrs null 
return 
typedarray context obtainstyledattributes attrs styleable progressbar defstyle 
setmirrored getboolean styleable progressbar_mirrored mmirrored 
recycle 
override 
public synchronized void setprogress progress 
super setprogress progress 
mlistener null 
mlistener onprogresschanged this progress 
override 
public synchronized void setmax 
super setmax 
mlistener null 
mlistener onmaxchanged this 
suppresslint newapi 
override 
protected synchronized void ondraw nonnull canvas canvas 
mmirrored 
canvas save 
canvas translate getwidth 
canvas scale 
super ondraw canvas 
canvas restore 
paddingend device hasjellybeanmr 
getpaddingend 
getpaddingright 
canvas save 
canvas translate getwidth paddingend 
canvas scale 
super ondraw canvas 
canvas restore 
else 
super ondraw canvas 
sets link progressbar progress should 
mirrored decreasing from both sides center 
public void setmirrored boolean mirrored 
mmirrored mirrored 
postinvalidate 
sets listener receive notifications 
changes progressbar progress level 
public void setonprogresschangelistener onprogresschangelistener listener 
mlistener listener 
