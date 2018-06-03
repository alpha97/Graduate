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

package achep acdisplay appwidget 
import android appwidget appwidgethostview 
import android content context 
import android support annotation nonnull 
import android view layoutinflater 
import android view motionevent 
import android view viewgroup 
import android widget remoteviews 
created artem chepurnoy 
public class myappwidgethostview extends appwidgethostview 
nonnull 
layoutinflater minflater 
private context mcontext 
private mpreviousorientation 
private boolean mtouchable 
public myappwidgethostview nonnull context context 
super context 
mcontext context 
minflater layoutinflater context getsystemservice context layout_inflater_service 
override 
public void updateappwidget remoteviews remoteviews 
store orientation which widget inflated 
mpreviousorientation mcontext getresources getconfiguration orientation 
super updateappwidget remoteviews 
whether this view pass touches link remoteviews 
public void settouchable boolean touchable 
mtouchable touchable 
public boolean isreinflaterequired 
inflate required orientation changed since last inflated 
orientation mcontext getresources getconfiguration orientation 
return mpreviousorientation orientation 
override 
public boolean onintercepttouchevent motionevent 
return mtouchable super onintercepttouchevent events 
override 
public boolean ontouchevent nonnull motionevent event 
return mtouchable super ontouchevent event 
override 
public getdescendantfocusability 
return viewgroup focus_block_descendants 
