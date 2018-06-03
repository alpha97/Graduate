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

package achep acdisplay appwidget 
import android appwidget appwidgethost 
import android appwidget appwidgethostview 
import android appwidget appwidgetproviderinfo 
import android content context 
import android transactiontoolargeexception 
import android support annotation nonnull 
import android support annotation nullable 
import achep base device 
specific link appwidgethost that creates link myappwidgethostview 
which eats touch events this ensures that users 
bypass keyguard 
author artem chepurnoy 
public class myappwidgethost extends appwidgethost 
nullable 
private appwidgethostview mtempview 
public myappwidgethost nonnull context context hostid 
super device haslollipopmr 
android widget host that 
holds context reference 
https github android platform_frameworks_base commit fadec 
context 
context getapplicationcontext hostid 
create appwidgethostview given widget 
appwidgethost retains pointer newly created view 
nonnull 
public final appwidgethostview updateview nonnull context context appwidgetid 
nonnull appwidgetproviderinfo appwidget 
nullable appwidgethostview view 
mtempview view 
view createview context appwidgetid appwidget 
mtempview null 
return view 
nonnull 
override 
protected appwidgethostview oncreateview nonnull context context appwidgetid 
nonnull appwidgetproviderinfo appwidget 
return mtempview null mtempview myappwidgethostview context 
override 
public void startlistening 

super startlistening 
catch exception 
noinspection statementwithemptybody 
getcause instanceof transactiontoolargeexception 
willing this slide exception being caused list 
remoteviews which being passed back startlistening relationship will 
have been established this point will populating 
widgets upon bind anyway issue more context 
else 
throw runtimeexception 
override 
public void stoplistening 
super stoplistening 
clearviews 
