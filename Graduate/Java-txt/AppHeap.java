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
import android application 
import android content context 
import android support annotation nonnull 
import achep base billing checkoutinternal 
import achep base interfaces iconfiguration 
import achep base interfaces ionlowmemory 
import achep base permissions runtimepermissions 
import achep base tests check 
import achep base timber releasetree 
import drivemode android typeface typefacehelper 
import squareup leakcanary leakcanary 
import squareup leakcanary refwatcher 
import solovyev android checkout checkout 
import solovyev android checkout producttypes 
import solovyev android checkout products 
import java util collections 
import timber timber 
created artem chepurnoy 
public class appheap implements ionlowmemory 
private static appheap sinstance 
nonnull 
public static appheap getinstance 
sinstance null 
sinstance appheap 
return sinstance 
nonnull 
public static checkout getcheckout 
return getcheckoutinternal getcheckout 
nonnull 
public static checkoutinternal getcheckoutinternal 
check getinstance isnonnull getinstance mcheckoutinternal 
return getinstance mcheckoutinternal 
nonnull 
public static context getcontext 
check getinstance isnonnull getinstance mapplication 
return getinstance mapplication 
nonnull 
public static refwatcher getrefwatcher 
check getinstance isnonnull getinstance mapplication 
return getinstance mrefwatcher 
application wide link solovyev android checkout checkout instance 
used anywhere this instance contains available 
products 
suppresswarnings nullableproblems 
nonnull 
private checkoutinternal mcheckoutinternal 
private iconfiguration mconfiguration 
private application mapplication 
private refwatcher mrefwatcher 
must called link android application oncreate 
public void init nonnull application application nonnull iconfiguration configuration 
mrefwatcher leakcanary install application 
mcheckoutinternal checkoutinternal application products create 
producttypes in_app configuration getbilling getproducts 
producttypes subscription collections singletonlist 
mconfiguration configuration 
mapplication application 
setup 
debug 
timber plant timber debugtree 
else 
timber plant releasetree 
timber plant releasetree 
typefacehelper initialize application 
runtimepermissions getinstance load application 
nonnull 
public final iconfiguration getconfiguration 
return mconfiguration 
inheritdoc 
override 
public void onlowmemory 
