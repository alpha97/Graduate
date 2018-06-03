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

package achep base preferences 
import android content context 
import android support annotation nonnull 
import android widget compoundbutton 
import achep base content configbase 
import achep base interfaces icheckable 
author artem chepurnoy 
public class enabler 
private final string mkey 
private final context mcontext 
private final configbase mconfig 
private final configbase option moption 
private final configbase onconfigchangedlistener mconfiglistener 
configbase onconfigchangedlistener 
override 
public void onconfigchanged nonnull configbase config 
nonnull string 
nonnull object value 
mkey equals updatecheckablestate 
private final compoundbutton oncheckedchangelistener mcheckablelistener 
compoundbutton oncheckedchangelistener 
override 
public void oncheckedchanged compoundbutton buttonview boolean ischecked 
mbroadcasting 
return 
moption write mconfig mcontext ischecked mconfiglistener 
private icheckable mcheckable 
private boolean mbroadcasting 
public enabler nonnull context context 
nonnull configbase config 
nonnull string 
nonnull icheckable checkable 
mkey 
mconfig config 
mcontext context 
mcheckable checkable 
moption mconfig getoption mkey 
starts listening config changes updates corresponding 
link achep base interfaces icheckable compound button 
must call link stop stop method later 
public void start 
mconfig registerlistener mconfiglistener 
mcheckable setoncheckedchangelistener mcheckablelistener 
updatecheckablestate 
stops listening config changes 
public void stop 
mconfig unregisterlistener mconfiglistener 
mcheckable setoncheckedchangelistener null 
public void setcheckable nonnull icheckable checkable 
mcheckable checkable 
return 
mcheckable setoncheckedchangelistener null 
mcheckable checkable 
mcheckable setoncheckedchangelistener mcheckablelistener 
updatecheckablestate 
private void updatecheckablestate 
mbroadcasting true 
mcheckable setchecked boolean moption read mconfig 
mbroadcasting false 
