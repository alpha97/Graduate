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

package achep base adapters 
import android content context 
import android support annotation layoutres 
import android support annotation nonnull 
import android view layoutinflater 
import android view view 
import android view viewgroup 
import android widget arrayadapter 
created artem chepurnoy 
public abstract class betterarrayadapter extends arrayadapter 
nonnull 
protected final layoutinflater minflater 
nonnull 
protected final context mcontext 
layoutres 
private final mresource 
public abstract static class viewholder 
nonnull 
public final view view 
public viewholder nonnull view view 
this view view 
protected betterarrayadapter nonnull context context layoutres resource 
super context 
minflater layoutinflater from context 
mcontext context 
mresource resource 
override 
public view getview position view convertview viewgroup parent 
final view view 
final viewholder 
convertview null 
view minflater inflate mresource parent false 
oncreateviewholder view 
view settag 
else 
view convertview 
viewholder view gettag 
onbindviewholder position 
return view 
nonnull 
protected abstract viewholder oncreateviewholder nonnull view view 
protected abstract void onbindviewholder nonnull viewholder viewholder 
