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
import android util property 
implementation link android util property used specifically with fields type 
code float code this type specific subclass enables performance benefit allowing 
calls link object float function that takes primitive 
code float code type avoids autoboxing other overhead associated with 
code float code class 
param class which property declared 
public abstract class floatproperty extends property float 
public floatproperty string name 
super float class name 
type specific override link object float that faster when dealing 
with fields type code float code 
public abstract void setvalue object float value 
override 
final public void object float value 
setvalue object value 
