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

package achep acdisplay services media 
import android graphics bitmap 
import android support annotation nullable 
import android text textutils 
import apache commons lang builder equalsbuilder 
import apache commons lang builder hashcodebuilder 
created achep 
public class metadata 
nullable 
public charsequence title 
nullable 
public charsequence artist 
nullable 
public charsequence album 
nullable 
public charsequence subtitle 
nullable 
public bitmap bitmap 
nullable 
public string 
public long duration 
isempty 
public void clear 
title null 
artist null 
subtitle null 
bitmap null 
null 
duration 
void generatesubtitle 
general subtitle format 
artist album 
stringbuilder stringbuilder 
textutils isempty artist 
append artist 
textutils isempty album 
append 
append album 
else textutils isempty album 
append album 
else 
null 
subtitle 
override 
public string tostring 
return metadata title title 
artist artist 
subtitle subtitle 
duration duration 

bitmap bitmap 
override 
public hashcode 
return hashcodebuilder 
append title 
append artist 
append subtitle 
append duration 
append 
append bitmap 
tohashcode 
override 
public boolean equals object 
this 
return true 
instanceof metadata 
return false 
metadata metadata metadata 
return equalsbuilder 
append duration metadata duration 
append metadata 
append title metadata title 
append artist metadata artist 
append subtitle metadata subtitle 
append bitmap metadata bitmap 
isequals 
return code true metadata empty 
clear 
public boolean isempty 
return title null 
artist null 
subtitle null 
bitmap null 
null 
duration 
