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

package achep base utils 
import android content intent 
import android 
import android support annotation nonnull 
import achep base interfaces icoin 
base class simple virtual coins 
author artem chepurnoy 
public class coinutils 
nonnull 
public static intent getpaymentintent nonnull icoin coin 
return getpaymentintent coin coin getpaymentamount 
nonnull 
public static intent getpaymentintent nonnull icoin coin double amount 
coin getpaymenturi amount 
return intentutils createviewintent 
