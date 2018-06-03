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
import android annotation suppresslint 
import android content context 
import android graphics drawable drawable 
import android support annotation drawableres 
import android support annotation nonnull 
import android support annotation nullable 
import android support widget switchcompat 
import android util attributeset 
import android view view 
import android widget compoundbutton 
import android widget imageview 
import android widget linearlayout 
import achep acdisplay 
import achep base interfaces icheckable 
import achep base utils rippleutils 
material designed switch 
author artem chepurnoy 
public class switchbar extends linearlayout implements icheckable 
private textview mtextview 
private imageview miconview 
private switchcompat mswitch 
private compoundbutton oncheckedchangelistener mpubliclistener 
private final compoundbutton oncheckedchangelistener mlistener 
compoundbutton oncheckedchangelistener 
override 
public void oncheckedchanged compoundbutton buttonview boolean ischecked 
mswitch post runnable 
override 
public void 
updatetext mswitch ischecked 
mpubliclistener null 
mpubliclistener oncheckedchanged buttonview ischecked 
private void updatetext boolean ischecked 
mtextview settext ischecked 
string 
string 
public switchbar context context 
super context 
public switchbar context context attributeset attrs 
super context attrs 
public switchbar context context attributeset attrs defstyleattr 
super context attrs defstyleattr 
suppresslint wrongviewcast 
override 
protected void onfinishinflate 
super onfinishinflate 
isineditmode 
rippleutils makefor this false 
mtextview textview findviewbyid title 
miconview imageview findviewbyid icon 
mswitch switchcompat findviewbyid switch_ 
mswitch setoncheckedchangelistener mlistener 
updatetext mswitch ischecked 
toggle switch click panel 
setonclicklistener onclicklistener 
override 
public void onclick view 
toggle 
override 
protected void onattachedtowindow 
super onattachedtowindow 
post runnable 
override 
public void 
todo somehow update padding left with title actionbar 
public void seticonresource drawableres resource 
miconview setimageresource resource 
public void seticondrawable nullable drawable drawable 
miconview setimagedrawable drawable 
nonnull 
public imageview geticonview 
return miconview 
inheritdoc 
override 
public void setoncheckedchangelistener compoundbutton oncheckedchangelistener listener 
mpubliclistener listener 
inheritdoc 
override 
public void setchecked boolean checked 
mswitch setchecked checked 
inheritdoc 
override 
public boolean ischecked 
return mswitch ischecked 
inheritdoc 
override 
public void toggle 
mswitch toggle 
