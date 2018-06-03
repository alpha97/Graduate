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
import android 
import android support annotation drawableres 
import android support annotation nonnull 
import android support annotation nullable 
import android support annotation stringres 
base class simple virtual coins 
author artem chepurnoy 
public interface icoin 
drawableres 
geticonresource 
return string resource name this coin string name 
simply code getresources getstring nameres 
stringres 
getnameresource 
return receiver email just string 
nonnull 
string getpaymentkey 
return default amount money 
double getpaymentamount 
param amount amount send code blank field 
return page through which sends moneys 
achep base utils coinutils getpaymentintent icoin 
achep base utils coinutils getpaymentintent icoin double 
nonnull 
getpaymenturi double amount 
return page that shows current money 
geturiwhatisit 
geturitutorial 
nullable 
geturibrowsewallet 
return page that explains coin 
geturibrowsewallet 
geturitutorial 
nonnull 
geturiwhatisit 
return page that explains that coin send receive money 
geturiwhatisit 
geturibrowsewallet 
nonnull 
geturitutorial 
