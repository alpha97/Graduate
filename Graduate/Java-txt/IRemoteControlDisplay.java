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

package android media 
import android pendingintent 
import android graphics bitmap 
import android bundle 
import android remoteexception 
this needed able those 
damn internal apis 
public interface iremotecontroldisplay 
abstract class stub implements iremotecontroldisplay 
public abstract void setallmetadata generationid bundle metadata bitmap bitmap 
public abstract void setartwork generationid bitmap bitmap 
public abstract void setcurrentclientid clientgeneration pendingintent mediaintent 
boolean clearing throws remoteexception 
public abstract void setmetadata generationid bundle metadata 
public abstract void setplaybackstate generationid state long statechangetimems 
public abstract void settransportcontrolflags generationid flags 
