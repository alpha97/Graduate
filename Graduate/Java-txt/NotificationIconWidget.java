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

package achep acdisplay widgets notification 
import android content context 
import android support annotation nullable 
import android util attributeset 
import android widget framelayout 
import android widget textview 
import achep acdisplay 
import achep acdisplay interfaces inotificatiable 
import achep acdisplay notifications opennotification 
created artem 
public class notificationiconwidget extends framelayout implements inotificatiable 
nullable 
private opennotification mnotification 
views 
private notificationicon mnotificationicon 
private textview mnumbertextview 
public notificationiconwidget context context attributeset attrs 
super context attrs 
override 
protected void onfinishinflate 
super onfinishinflate 
mnotificationicon notificationicon findviewbyid icon 
mnumbertextview textview findviewbyid number 
mnotification null setnotification mnotification 
inheritdoc 
override 
public void setnotification nullable opennotification notification 
mnotificationicon null 
this means that onfinishinflate hadn happen 
lets wait notification 
mnotification notification 
return 
mnotification null 
mnotificationicon setnotification notification 
number notification null notification getnumber 
number 
mnumbertextview settext integer tostring number 
mnumbertextview setvisibility visible 
else 
mnumbertextview setvisibility gone 
inheritdoc 
nullable 
override 
public opennotification getnotification 
return mnotificationicon null 
mnotificationicon getnotification 
mnotification 
