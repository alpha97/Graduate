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

package achep base 
import android support annotation nonnull 
import android support annotation nullable 
import android support appcompatactivity 
import android widget compoundbutton 
import achep acdisplay 
import achep acdisplay dialoghelper 
import achep base interfaces icheckable 
import achep base permissions permission 
import achep base widgets switchbar 
import achep base utils viewutils 
author artem chepurnoy 
public class switchbarpermissible implements permission onpermissionstatechanged icheckable 
nonnull 
private final appcompatactivity mactivity 
nonnull 
private final switchbar mswitchbar 
nullable 
private final permission mpermissions 
nullable 
private compoundbutton oncheckedchangelistener mlistener 
public switchbarpermissible nonnull appcompatactivity activity nonnull switchbar switchbar 
nullable permission permissions 
mactivity activity 
mpermissions permissions 
mswitchbar switchbar 
mpermissions null mswitchbar seticonresource drawable ic_action_warning_amber 
mswitchbar setoncheckedchangelistener compoundbutton oncheckedchangelistener 
override 
public void oncheckedchanged compoundbutton buttonview boolean ischecked 
ischecked hasaccess 
assert mpermissions null 
buttonview setchecked false 
dialoghelper showpermissionsdialog mactivity mpermissions 
else 
mlistener null mlistener oncheckedchanged buttonview ischecked 
called activity resumed 
public void resume 
mpermissions null 
return 
boolean enabled true 
permission permission mpermissions 
permission registerlistener this 
enabled enabled permission isgranted 
viewutils setvisible mswitchbar geticonview enabled 
setchecked mswitchbar ischecked enabled 
called activity paused 
public void pause 
mpermissions null 
return 
permission permission mpermissions 
permission unregisterlistener this 
private boolean hasaccess 
mpermissions null return true 
permission permission mpermissions 
permission isgranted return false 
return true 
checkable 
inheritdoc 
override 
public void setoncheckedchangelistener 
nullable compoundbutton oncheckedchangelistener listener 
mlistener listener 
inheritdoc 
override 
public void setchecked boolean checked 
mswitchbar setchecked checked 
inheritdoc 
override 
public boolean ischecked 
return mswitchbar ischecked 
inheritdoc 
override 
public void toggle 
mswitchbar toggle 
