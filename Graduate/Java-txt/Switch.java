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

package achep acdisplay services 
import android content context 
import android support annotation nonnull 
import achep acdisplay config 
import achep base content configbase 
import achep base tests check 
provides callback when something should started stopped 
satisfy options power save reason 
author artem chepurnoy 
public abstract class switch 
private boolean mcreated 
nonnull 
private final context mcontext 
nonnull 
private final callback mcallback 
provides control callback main service 
author artem chepurnoy 
public interface callback 
asks main service start something 
this moment calling link isactive should return code true 
isactive 
requestinactive 
void requestactive 
asks main service stop something 
this moment calling link isactive should return code false 
isactive 
requestactive 
void requestinactive 
public switch nonnull context context nonnull callback callback 
mcontext context 
mcallback callback 
same calling code getcallback requestactive 
callback requestactive 
getcallback 
protected void requestactive 
getcallback requestactive 
same calling code getcallback requestinactive 
callback requestinactive 
getcallback 
protected void requestinactive 
getcallback requestinactive 
nonnull 
public callback getcallback 
return mcallback 
return link achep acdisplay services activemode activemodeservice service context 
nonnull 
public context getcontext 
return mcontext 
called link switchservice when service created 
public abstract void oncreate 
called link switchservice notify 
that this class longer used being removed 
here should clean resources holds 
threads registered receivers this point 
public abstract void ondestroy 
return code true starting something fine code false otherwise 
public abstract boolean isactive 
final void create 
mcreated true 
oncreate 
final void destroy 
ondestroy 
mcreated false 
final boolean iscreated 
return mcreated 
public abstract static class optional extends switch implements 
configbase onconfigchangedlistener 
nonnull 
private config mconfig 
private final boolean moptioninverted 
nonnull 
private final configbase option moption 
nonnull 
private final string moptionkey 
param isoptioninverted code false enabled option means actually enabled 
feature code true inversed 
public optional 
nonnull context context 
nonnull callback callback 
nonnull configbase option option boolean isoptioninverted 
super context callback 
mconfig config getinstance 
moption option 
moptionkey moption getkey mconfig 
moptioninverted isoptioninverted 
inheritdoc 
override 
public void oncreate 
mconfig registerlistener this 
inheritdoc 
override 
public void ondestroy 
mconfig unregisterlistener this 
inheritdoc 
override 
public final boolean isactive 
return isfeatureenabled isactiveinternal 
isactive 
public abstract boolean isactiveinternal 
public void requestactiveinternal 
check getinstance istrue isactive 
requestactive 
public void requestinactiveinternal 
isfeatureenabled 
check getinstance isfalse isactive 
requestinactive 
override 
public void onconfigchanged nonnull configbase configbase 
nonnull string 
nonnull object value 
equals moptionkey 
isfeatureenabled boolean value 
isactiveinternal 
requestactive 
else 
requestinactive 
else 
disabled active mode check 
amount notifications probably stop 
listening 
requestactive 
private boolean isfeatureenabled 
return isfeatureenabled boolean moption read mconfig 
private boolean isfeatureenabled boolean 
return moptioninverted 
