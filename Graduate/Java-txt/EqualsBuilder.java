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
assists implementing link object equals object methods 

this class provides methods build good equals method 
class follows rules laid 
href http java docs books effective index html effective java 
joshua bloch particular rule comparing code doubles code 
code floats code arrays tricky also making sure that 
code equals code code hashcode code consistent 
difficult 

objects that compare equals must generate same hash code 
objects with same hash code have equal 

relevant fields should included calculation equals 
derived fields ignored particular field used 
generating hash code must used equals method vice 
versa 

typical code follows 

public boolean equals object 
instanceof myclass false 
return false 

this 
return true 

myclass myclass 
return equalsbuilder 
appendsuper super equals 
append field field 
append field field 
append field field 
isequals 


alternatively there method that uses reflection determine 
fields test because these fields usually private method 
code reflectionequals code uses code accessibleobject setaccessible code 
change visibility fields this will fail under security 
manager unless appropriate permissions correctly 
also slower than testing explicitly 

typical invocation this method would look like 

public boolean equals object 
return equalsbuilder reflectionequals this 

author href mailto steve downey netfolio steve downey 
author stephen colebourne 
author gary gregory 
author pete gieser 
author arun mammen thomas 
version equalsbuilder java bayard 
since 
suppresswarnings pointlessbooleanexpression 
public class equalsbuilder 
fields tested equals 
default value code true code 
private boolean isequals true 
constructor equalsbuilder 

starts assuming that equals code true code 
object equals object 
public equalsbuilder 
nothing 

adds result code super equals code this builder 
param superequals result calling code super equals code 
return equalsbuilder used chain calls 
since 
public equalsbuilder appendsuper boolean superequals 
isequals false 
return this 
isequals superequals 
return this 

test code object code equal using their 
code equals code method 
param left hand object 
param right hand object 
return equalsbuilder used chain calls 
public equalsbuilder append object object 
isequals false 
return this 

return this 
null null 
this setequals false 
return this 
class lhsclass getclass 
lhsclass isarray 
simple case array just test element 
isequals equals 
else getclass getclass 
here when compare different dimensions example boolean boolean 
this setequals false 
switch type array dispatch correct handler 
this handles multi dimensional arrays same depth 
else instanceof long 
append long long 
else instanceof 
append 
else instanceof short 
append short short 
else instanceof char 
append char char 
else instanceof byte 
append byte byte 
else instanceof double 
append double double 
else instanceof float 
append float float 
else instanceof boolean 
append boolean boolean 
else 
array primitives 
append object object 
return this 

test code long code equal 

param left hand code long code 
param right hand code long code 
return equalsbuilder used chain calls 
public equalsbuilder append long long 
isequals false 
return this 
isequals 
return this 
test code code equal 
param left hand code code 
param right hand code code 
return equalsbuilder used chain calls 
public equalsbuilder append 
isequals false 
return this 
isequals 
return this 
test code short code equal 
param left hand code short code 
param right hand code short code 
return equalsbuilder used chain calls 
public equalsbuilder append short short 
isequals false 
return this 
isequals 
return this 
test code char code equal 
param left hand code char code 
param right hand code char code 
return equalsbuilder used chain calls 
public equalsbuilder append char char 
isequals false 
return this 
isequals 
return this 
test code byte code equal 
param left hand code byte code 
param right hand code byte code 
return equalsbuilder used chain calls 
public equalsbuilder append byte byte 
isequals false 
return this 
isequals 
return this 
test code double code equal testing that 
pattern bits returned code doubletolong code equal 

this handles nans infinities code code 

compatible with hash code generated 
code hashcodebuilder code 
param left hand code double code 
param right hand code double code 
return equalsbuilder used chain calls 
public equalsbuilder append double double 
isequals false 
return this 
return append double doubletolongbits double doubletolongbits 
test code float code equal testing that 
pattern bits returned doubletolong equal 

this handles nans infinities code code 

compatible with hash code generated 
code hashcodebuilder code 
param left hand code float code 
param right hand code float code 
return equalsbuilder used chain calls 
public equalsbuilder append float float 
isequals false 
return this 
return append float floattointbits float floattointbits 
test code booleans code equal 
param left hand code boolean code 
param right hand code boolean code 
return equalsbuilder used chain calls 
public equalsbuilder append boolean boolean 
isequals false 
return this 
isequals 
return this 
performs deep comparison code object code arrays 

this also will called level 
multi dimensional ragged multi typed arrays 
param left hand code object code 
param right hand code object code 
return equalsbuilder used chain calls 
public equalsbuilder append object object 
isequals false 
return this 

return this 
null null 
this setequals false 
return this 
length length 
this setequals false 
return this 
length isequals 
append 
return this 
deep comparison array code long code length 
values compared 

method link append long long used 
param left hand code long code 
param right hand code long code 
return equalsbuilder used chain calls 
public equalsbuilder append long long 
isequals false 
return this 

return this 
null null 
this setequals false 
return this 
length length 
this setequals false 
return this 
length isequals 
append 
return this 
deep comparison array code code length 
values compared 

method link append used 
param left hand code code 
param right hand code code 
return equalsbuilder used chain calls 
public equalsbuilder append 
isequals false 
return this 

return this 
null null 
this setequals false 
return this 
length length 
this setequals false 
return this 
length isequals 
append 
return this 
deep comparison array code short code length 
values compared 

method link append short short used 
param left hand code short code 
param right hand code short code 
return equalsbuilder used chain calls 
public equalsbuilder append short short 
isequals false 
return this 

return this 
null null 
this setequals false 
return this 
length length 
this setequals false 
return this 
length isequals 
append 
return this 
deep comparison array code char code length 
values compared 

method link append char char used 
param left hand code char code 
param right hand code char code 
return equalsbuilder used chain calls 
public equalsbuilder append char char 
isequals false 
return this 

return this 
null null 
this setequals false 
return this 
length length 
this setequals false 
return this 
length isequals 
append 
return this 
deep comparison array code byte code length 
values compared 

method link append byte byte used 
param left hand code byte code 
param right hand code byte code 
return equalsbuilder used chain calls 
public equalsbuilder append byte byte 
isequals false 
return this 

return this 
null null 
this setequals false 
return this 
length length 
this setequals false 
return this 
length isequals 
append 
return this 
deep comparison array code double code length 
values compared 

method link append double double used 
param left hand code double code 
param right hand code double code 
return equalsbuilder used chain calls 
public equalsbuilder append double double 
isequals false 
return this 

return this 
null null 
this setequals false 
return this 
length length 
this setequals false 
return this 
length isequals 
append 
return this 
deep comparison array code float code length 
values compared 

method link append float float used 
param left hand code float code 
param right hand code float code 
return equalsbuilder used chain calls 
public equalsbuilder append float float 
isequals false 
return this 

return this 
null null 
this setequals false 
return this 
length length 
this setequals false 
return this 
length isequals 
append 
return this 
deep comparison array code boolean code length 
values compared 

method link append boolean boolean used 
param left hand code boolean code 
param right hand code boolean code 
return equalsbuilder used chain calls 
public equalsbuilder append boolean boolean 
isequals false 
return this 

return this 
null null 
this setequals false 
return this 
length length 
this setequals false 
return this 
length isequals 
append 
return this 
returns code true code fields that have been checked 
equal 
return boolean 
public boolean isequals 
return this isequals 
sets code isequals code value 
param isequals value 
since 
protected void setequals boolean isequals 
this isequals isequals 
