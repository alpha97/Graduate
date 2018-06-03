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

package achep base interfaces 
author artem chepurnoy 
public interface ionlowmemory 
this called when overall system running memory actively running 
processes should trim their memory usage while exact point which this 
will called defined generally will happen when background process 
have been killed that before reaching point killing processes hosting service 
foreground that would like avoid killing 
should implement this method release caches other unnecessary resources 
holding system will perform garbage collection after returning 
from this method 
void onlowmemory 
