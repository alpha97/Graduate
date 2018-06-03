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
import android content context 
import android graphics bitmap 
import android view keyevent 
this needed avoid exceptions 
kitkat platforms 
public class remotecontroller 
public static final position_synchronization_check 
public remotecontroller context context onclientupdatelistener 
throw runtimeexception shit happened 
public boolean setartworkconfiguration width height 
return false 
public boolean sendmediakeyevent keyevent keyevent 
return true 
public boolean setsynchronizationmode mode 
return true 
public boolean seekto long 
return true 
public long getestimatedmediaposition 
return 
public class metadataeditor 
public synchronized string getstring string defaultvalue 
return null 
public synchronized long getlong long defaultvalue 
return 
public synchronized bitmap getbitmap bitmap defaultvalue 
return null 
public interface onclientupdatelistener 
void onclientchange boolean clearing 
void onclientmetadataupdate remotecontroller metadataeditor metadataeditor 
void onclientplaybackstateupdate state long statechangetimems long currentposms float speed 
void onclientplaybackstateupdate state 
void onclienttransportcontrolupdate transportcontrolflags 
