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

package achep base interfaces 
import android content context 
import android support annotation nonnull 
import java util list 
import java util 
author artem chepurnoy 
public interface iconfiguration 
nonnull 
ibilling getbilling 
author artem chepurnoy 
interface ibilling 
nonnull 
list string getproducts 
return code true show alternative google play 
billing services such bitcoin paypal code false otherwise 
boolean hasalternativepaymentmethods 
nonnull 
ihelp gethelp 
author artem chepurnoy 
interface ihelp 
return help text displayed 
link achep base fragments dialogs helpdialog 
nonnull 
charsequence gettext nonnull context context 
called when user finished probably finished reading 
help text 
void onuserreadhelp 
nonnull 
ipermissions getpermissions 
author artem chepurnoy 
interface ipermissions 
void onbuildpermissions nonnull string list 
