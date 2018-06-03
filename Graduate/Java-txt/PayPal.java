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
import android support annotation nullable 
import android support annotation stringres 
import achep acdisplay 
import achep base interfaces icoin 
paypal very basics 

paypal american international digital wallet based commerce 
business allowing payments money transfers made through internet 
online money transfers serve electronic alternatives paying with 
traditional paper methods such checks money orders 
paypal world largest internet payment companies 
company operates acquirer performing payment processing 
online vendors auction sites other commercial users which charges 
author artem chepurnoy 
public class paypal implements icoin 
private static final string donations achep gmail 
private static final double amount user choose amount 
inheritdoc 
drawableres 
override 
public geticonresource 
return 
inheritdoc 
stringres 
override 
public getnameresource 
return string paypal 
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
stringbuilder builder stringbuilder 
builder append https paypal webscr _donations 
builder append item_name artem chepurnoy 
builder append business append getpaymentkey 
amount builder append amount append amount 
return parse builder tostring 
inheritdoc 
nullable 
override 
public geturibrowsewallet 
return null 
inheritdoc 
nonnull 
override 
public geturiwhatisit 
return parse https youtube watch oozndt 
inheritdoc 
nonnull 
override 
public geturitutorial 
return parse http wikihow paypal 
