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
import android support annotation nonnull 
import achep acdisplay atomic 
author artem chepurnoy 
public abstract class switchservice extends bathservice childservice implements 
atomic callback 
switch callback 
protected atomic mlisteningatom 
protected switch mswitches 
nonnull 
public abstract switch onbuildswitches 
inheritdoc 
override 
public void oncreate 
mlisteningatom atomic this 
mswitches onbuildswitches 
switch switch_ mswitches 
switch_ create 
requestactive 
inheritdoc 
override 
public void ondestroy 
switch switch_ mswitches 
switch_ destroy 
stop 
mlisteningatom null 
mswitches null 
inheritdoc 
override 
public void requestactive 
mlisteningatom isrunning 
return already listening need check handlers 
check through available handlers 
switch switch_ mswitches 
switch_ iscreated switch_ isactive 
return 
start 
inheritdoc 
override 
public void requestinactive 
stop 
protected void stop 
mlisteningatom stop 
protected void start 
mlisteningatom start 
