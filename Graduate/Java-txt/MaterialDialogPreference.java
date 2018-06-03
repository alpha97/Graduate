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

package achep base preferences 
import android annotation targetapi 
import android dialog 
import android content context 
import android content dialoginterface 
import android build 
import android bundle 
import android preference dialogpreference 
import android preference preference 
import android preference preferencemanager 
import android support annotation nonnull 
import android util attributeset 
import android view window 
import android view windowmanager 
import afollestad materialdialogs dialogaction 
import afollestad materialdialogs materialdialog 
import java lang reflect method 
base class link preference objects that 
dialog based these preferences will when clicked open dialog showing 
actual preference controls 
author artem chepurnoy 
public abstract class materialdialogpreference extends dialogpreference 
private materialdialog mdialog 
targetapi build version_codes lollipop 
public materialdialogpreference context context attributeset attrs defstyleattr defstyleres 
super context attrs defstyleattr defstyleres 
public materialdialogpreference context context attributeset attrs defstyleattr 
super context attrs defstyleattr 
public materialdialogpreference context context attributeset attrs 
super context attrs 
targetapi build version_codes lollipop 
public materialdialogpreference context context 
super context 
main 
override 
public dialog getdialog 
return mdialog 
override 
protected void showdialog bundle state 
materialdialog builder mbuilder materialdialog builder getcontext 
icon getdialogicon 
title getdialogtitle 
content getdialogmessage 
positivetext getpositivebuttontext 
negativetext getnegativebuttontext 
onpositive materialdialog singlebuttoncallback 
override 
public void onclick nonnull materialdialog materialdialog 
nonnull dialogaction dialogaction 
materialdialogpreference this onclick null dialoginterface button_positive 
onnegative materialdialog singlebuttoncallback 
override 
public void onclick nonnull materialdialog materialdialog 
nonnull dialogaction dialogaction 
materialdialogpreference this onclick null dialoginterface button_negative 
dismisslistener this 
preferencemanager getpreferencemanager 

method method getclass getdeclaredmethod 
registeronactivitydestroylistener 
preferencemanager onactivitydestroylistener class 
method setaccessible true 
method invoke this 
catch exception 
printstacktrace 
mdialog onbuilddialog mbuilder 
state null mdialog onrestoreinstancestate state 
needinputmethod requestinputmethod mdialog 
mdialog show 
nonnull 
public abstract materialdialog onbuilddialog nonnull materialdialog builder builder 
sets required flags dialog window enable input method window show 
private void requestinputmethod dialog dialog 
window window dialog getwindow 
window setsoftinputmode windowmanager layoutparams soft_input_state_always_visible 
returns whether preference needs display soft input method when dialog 
displayed default false subclasses should override this method they need 
soft input method brought automatically 
protected boolean needinputmethod 
return false 
