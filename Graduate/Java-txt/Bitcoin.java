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

package achep base billing 
import android 
import android support annotation drawableres 
import android support annotation nonnull 
import android support annotation stringres 
import achep acdisplay 
import achep base interfaces icoin 
bitcoin very basics 

bitcoin peer peer payment system introduced open source 
software developer satoshi nakamoto digital currency 
created used system also called bitcoin 
alternatively referred virtual currency electronic money 
cryptocurrency bitcoin system controlled single entity 
like central bank which treasury call bitcoin 
decentralized currency 
author artem chepurnoy 
public class bitcoin implements icoin 
private static final string znmbykj bsmz 
private static final double amount 
inheritdoc 
drawableres 
override 
public geticonresource 
return 
inheritdoc 
stringres 
override 
public getnameresource 
return string bitcoin 
inheritdoc 
nonnull 
override 
public string getpaymentkey 
return 
inheritdoc 
override 
public double getpaymentamount 
return amount 
inheritdoc 
nonnull 
override 
public getpaymenturi double amount 
return parse bitcoin getpaymentkey amount double tostring amount 
inheritdoc 
nonnull 
override 
public geturibrowsewallet 
return parse https biteasy blockchain addresses getpaymentkey 
inheritdoc 
nonnull 
override 
public geturiwhatisit 
return parse http youtube watch nhxa 
inheritdoc 
nonnull 
override 
public geturitutorial 
return parse https trybtc 
