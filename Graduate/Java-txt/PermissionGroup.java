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

package achep base permissions 
import android content context 
import android support annotation nonnull 
import achep base interfaces ionlowmemory 
import achep base interfaces ipermission 
import apache commons lang builder equalsbuilder 
import apache commons lang builder hashcodebuilder 
import java util arraylist 
permission that consists link permission permissions 
author artem chepurnoy 
public class permissiongroup implements ionlowmemory ipermission 
nonnull 
public final permission permissions 
public permissiongroup nonnull permission permissions 
this permissions permissions 
inheritdoc 
override 
public hashcode 
return hashcodebuilder 
append permissions 
tohashcode 
inheritdoc 
override 
public boolean equals object 
null return false 
this return true 
instanceof permissiongroup return false 
permissiongroup permissiongroup 
return equalsbuilder 
append permissions permissions 
isequals 
inheritdoc 
override 
public boolean isgranted 
ipermission permission permissions 
permission isgranted return false 
return true 
inheritdoc 
override 
public boolean exists nonnull context context 
ipermission permission permissions 
permission exists context return false 
return true 
inheritdoc 
override 
public void onlowmemory 
ipermission permission permissions 
permission onlowmemory 
author artem chepurnoy 
public static class builder 
nonnull 
private final context mcontext 
nonnull 
private final arraylist string mlist 
public builder nonnull context context 
mcontext context 
mlist arraylist 
adds permission group 
achep base permissions permission permission_accessibility 
achep base permissions permission permission_device_admin 
achep base permissions permission permission_notification_listener 
achep base permissions permission permission_usage_stats 
nonnull 
public builder nonnull string permission 
mlist permission 
return this 
nonnull 
public permissiongroup build 
final permission permission mlist size 
length 
permission newinstance mcontext mlist 
return permissiongroup 
