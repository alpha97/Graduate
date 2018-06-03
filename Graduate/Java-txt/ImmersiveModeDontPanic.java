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

package achep acdisplay plugins xposed 
import android util 
import achep base device 
import robv android xposed ixposedhookzygoteinit 
import robv android xposed xc_methodhook 
import static robv android xposed xposedhelpers findandhookmethod 
android shows help message when first start immersive mode 
when press button android sets flag remember 
this message stops showing future this 

however android resets this flag when panicking user detected 
this safeguard measure help people know what happening 
they dismissed message without reading panicking detected when 
user turns screen more than once within seconds 

this module makes method responsible this check nothing thus removing this annoyance 
public class immersivemodedontpanic implements ixposedhookzygoteinit 
private static final string xposed immersivepanic 
override 
public void initzygote startupparam startupparam throws throwable 
device haslollipopapi 
unfortunately this removes immersive panic reports 
only about acdisplay 
xc_methodhook hook xc_methodhook 
override 
protected void beforehookedmethod xc_methodhook methodhookparam param throws throwable 
param setresult null 
findandhookmethod 
android internal policy impl immersivemodeconfirmation null 
handlepanic hook 
else 
xc_methodhook hook xc_methodhook 
override 
protected void beforehookedmethod xc_methodhook methodhookparam param throws throwable 
string string param args 
null startswith achep acdisplay 
param setresult null 
unconfirmation acdisplay immersive mode passed hell 
findandhookmethod 
android internal policy impl immersivemodeconfirmation null 
unconfirmpackage string class hook 
