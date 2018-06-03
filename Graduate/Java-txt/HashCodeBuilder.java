licensed apache software foundation under more 
contributor license agreements notice file distributed with 
this work additional information regarding copyright ownership 
licenses this file under apache license version 
license this file except compliance with 
license obtain copy license 
http apache licenses license 
unless required applicable agreed writing software 
distributed under license distributed basis 
without warranties conditions kind either express implied 
license specific language governing permissions 
limitations under license 
package apache commons lang builder 
import java util hashset 
import java util 

assists implementing link object hashcode methods 



this class enables good code hashcode code method built class follows rules laid 
book href http java docs books effective index html effective java joshua bloch writing 
good code hashcode code method actually quite difficult this class aims simplify process 



relevant fields from object should included code hashcode code method derived fields 
excluded general field used code equals code method must used code hashcode code 
method 



this class write code follows 



public class person 
string name 

boolean smoker 

public hashcode 
pick hard coded randomly chosen zero number 
ideally different each class 
return hashcodebuilder 
append name 
append 
append smoker 
tohashcode 




required superclass code hashcode code added using link appendsuper 



alternatively there method that uses reflection determine fields test because these fields 
usually private method code reflectionhashcode code uses code accessibleobject setaccessible code 
change visibility fields this will fail under security manager unless appropriate permissions 
correctly also slower than testing explicitly 



typical invocation this method would look like 



public hashcode 
return hashcodebuilder reflectionhashcode this 

author stephen colebourne 
author gary gregory 
author pete gieser 
version hashcodebuilder java ggregory 
since 
public class hashcodebuilder 

registry objects used reflection methods detect cyclical object references avoid infinite loops 

since 
private static final threadlocal registry threadlocal 
protected synchronized object initialvalue 
hashset implementation synchronized 
which just what need here 
return hashset 

returns registry objects being traversed reflection methods current thread 

return registry objects being traversed 
since 
static getregistry 
return registry 

returns code true code registry contains given object used reflection methods avoid 
infinite loops 

param value object lookup registry 
return boolean code true code registry contains given object 
since 
static boolean isregistered object value 
return getregistry contains toidentityhashcodeinteger value 


registers given object used reflection methods avoid infinite loops 

param value object register 
static void register object value 
getregistry toidentityhashcodeinteger value 
returns integer given object default hash code 
param value object which hashcode calculated 
return default hash code 
system identityhashcode object 
private static integer toidentityhashcodeinteger object value 
return system identityhashcode value 

unregisters given object 



used reflection methods avoid infinite loops 
param value object unregister 
since 
static void unregister object value 
getregistry remove toidentityhashcodeinteger value 
constant building hashcode 
private final iconstant 
running total hashcode 
private itotal 

uses hard coded choices constants needed build code hashcode code 

public hashcodebuilder 
iconstant 
itotal 

randomly chosen zero numbers must passed ideally these should different each class 
however this vital 



prime numbers preferred especially multiplier 

param initialnonzerooddnumber zero number used initial value 
param multipliernonzerooddnumber zero number used multiplier 
throws illegalargumentexception number zero even 
public hashcodebuilder initialnonzerooddnumber multipliernonzerooddnumber 
initialnonzerooddnumber 
throw illegalargumentexception hashcodebuilder requires zero initial value 
initialnonzerooddnumber 
throw illegalargumentexception hashcodebuilder requires initial value 
multipliernonzerooddnumber 
throw illegalargumentexception hashcodebuilder requires zero multiplier 
multipliernonzerooddnumber 
throw illegalargumentexception hashcodebuilder requires multiplier 
iconstant multipliernonzerooddnumber 
itotal initialnonzerooddnumber 

append code hashcode code code boolean code 


this adds code iconstant code code hashcode code code code 
code code done java lang boolean this accordance with quote effective java quote 
design 

param value boolean code hashcode code 
return this 
public hashcodebuilder append boolean value 
itotal itotal iconstant value 
return this 

append code hashcode code code boolean code array 

param array array code hashcode code 
return this 
public hashcodebuilder append boolean array 
array null 
itotal itotal iconstant 
else 
boolean anarray array 
append anarray 
return this 


append code hashcode code code byte code 

param value byte code hashcode code 
return this 
public hashcodebuilder append byte value 
itotal itotal iconstant value 
return this 


append code hashcode code code byte code array 

param array array code hashcode code 
return this 
public hashcodebuilder append byte array 
array null 
itotal itotal iconstant 
else 
byte anarray array 
append anarray 
return this 

append code hashcode code code char code 

param value char code hashcode code 
return this 
public hashcodebuilder append char value 
itotal itotal iconstant value 
return this 

append code hashcode code code char code array 

param array array code hashcode code 
return this 
public hashcodebuilder append char array 
array null 
itotal itotal iconstant 
else 
char anarray array 
append anarray 
return this 

append code hashcode code code double code 

param value double code hashcode code 
return this 
public hashcodebuilder append double value 
return append double doubletolongbits value 

append code hashcode code code double code array 

param array array code hashcode code 
return this 
public hashcodebuilder append double array 
array null 
itotal itotal iconstant 
else 
double anarray array 
append anarray 
return this 

append code hashcode code code float code 

param value float code hashcode code 
return this 
public hashcodebuilder append float value 
itotal itotal iconstant float floattointbits value 
return this 

append code hashcode code code float code array 

param array array code hashcode code 
return this 
public hashcodebuilder append float array 
array null 
itotal itotal iconstant 
else 
float anarray array 
append anarray 
return this 

append code hashcode code code code 

param value code hashcode code 
return this 
public hashcodebuilder append value 
itotal itotal iconstant value 
return this 

append code hashcode code code code array 

param array array code hashcode code 
return this 
public hashcodebuilder append array 
array null 
itotal itotal iconstant 
else 
anarray array 
append anarray 
return this 

append code hashcode code code long code 

param value long code hashcode code 
return this 
public hashcodebuilder append long value 
itotal itotal iconstant value value 
return this 

append code hashcode code code long code array 

param array array code hashcode code 
return this 
public hashcodebuilder append long array 
array null 
itotal itotal iconstant 
else 
long anarray array 
append anarray 
return this 

append code hashcode code code object code 

param object object code hashcode code 
return this 
public hashcodebuilder append object object 
object null 
itotal itotal iconstant 
else 
object getclass isarray false 
simple case array just element 
itotal itotal iconstant object hashcode 
else 
switch type array dispatch correct handler 
this handles multi dimensional arrays 
object instanceof long 
append long object 
else object instanceof 
append object 
else object instanceof short 
append short object 
else object instanceof char 
append char object 
else object instanceof byte 
append byte object 
else object instanceof double 
append double object 
else object instanceof float 
append float object 
else object instanceof boolean 
append boolean object 
else 
array primitives 
append object object 
return this 

append code hashcode code code object code array 

param array array code hashcode code 
return this 
public hashcodebuilder append object array 
array null 
itotal itotal iconstant 
else 
object anarray array 
append anarray 
return this 

append code hashcode code code short code 

param value short code hashcode code 
return this 
public hashcodebuilder append short value 
itotal itotal iconstant value 
return this 

append code hashcode code code short code array 

param array array code hashcode code 
return this 
public hashcodebuilder append short array 
array null 
itotal itotal iconstant 
else 
short anarray array 
append anarray 
return this 

adds result super hashcode this builder 

param superhashcode result calling code super hashcode code 
return this hashcodebuilder used chain calls 
since 
public hashcodebuilder appendsuper superhashcode 
itotal itotal iconstant superhashcode 
return this 

return computed code hashcode code 

return code hashcode code based fields appended 
public tohashcode 
return itotal 
