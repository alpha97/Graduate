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

package achep acdisplay notifications 
import android annotation targetapi 
import android notification 
import android pendingintent 
import android build 
import android support annotation drawableres 
import android support annotation nonnull 
import android support annotation nullable 
import android support remoteinput 
import android util 
import achep base device 
import java lang softreference 
import java lang reflect field 
structure encapsulate named action that shown part this notification 
must include icon label link pendingintent fired when action 
selected user 

this actually wrapper around link android notification action class that supports both 
jelly bean reflections kitkat android versions 
author artem chepurnoy 
public class action 
private static final string action 
nonnull 
private static softreference factory sfactoryref softreference null 
nonnull 
targetapi build version_codes jelly_bean 
private static factory getfactory 
factory factory sfactoryref 
factory null 
device haskitkatwatchapi 
factory factorykitkatwatch 
else 
factory device haskitkatapi 
factorykitkat 
factoryjellybean 
sfactoryref softreference factory 
return factory 
return factory 
creates list actions based given link android notification notification 
instance 
param notification notification create from 
return array link achep acdisplay notifications action actions code null 
nullable 
static action makefor nonnull notification notification 
return getfactory makefor notification 
small icon representing action 
drawableres 
public final icon 
title action 
nonnull 
public final charsequence title 
intent send when user invokes this action null which case action 
rendered disabled presentation system 
nullable 
public final pendingintent intent 
list inputs collected from user when this action sent 
null remote inputs were added 
nullable 
public final remoteinput remoteinputs 
private action drawableres icon nonnull charsequence title 
nullable pendingintent intent nullable remoteinput remoteinputs 
this icon icon 
this title title 
this intent intent 
this remoteinputs remoteinputs 
base definition link achep acdisplay notifications action creator 
author artem chepurnoy 
public static abstract class factory 
creates list actions based given link android notification notification 
instance 
param notification notification create from 
return array link achep acdisplay notifications action actions code null 
nullable 
public abstract action makefor nonnull notification notification 
targetapi build version_codes kitkat_watch 
private static class factorykitkatwatch extends factorykitkat 
inheritdoc 
nullable 
public remoteinput getremoteinputs nonnull notification action action 
return remoteinpututils tocompat action getremoteinputs 
targetapi build version_codes kitkat 
private static class factorykitkat extends factory 
inheritdoc 
nullable 
override 
public action makefor nonnull notification notification 
notification action notification actions 
null 
return null 
final length length 
final action action length 
length 
remoteinput remoteinputs getremoteinputs 
action icon title actionintent remoteinputs 
return 
list inputs collected from user when this action sent 
return null remote inputs were added 
nullable 
public remoteinput getremoteinputs nonnull notification action action 
return null 
targetapi build version_codes jelly_bean 
private static class factoryjellybean extends factory 
inheritdoc 
nullable 
override 
public action makefor nonnull notification notification 
getting actions from stupid jelly bean 
object 

field field notification class getdeclaredfield actions 
field setaccessible true 
object field notification 
catch exception 
failed access actions field 
return null 
null 
return null 
final length length 
final action action length 
length 
object object 

field field object getclass getdeclaredfield icon 
field setaccessible true 
final icon field object 
field object getclass getdeclaredfield title 
field setaccessible true 
final charsequence title charsequence field object 
field object getclass getdeclaredfield actionintent 
field setaccessible true 
final pendingintent intent pendingintent field object 
action icon title intent null 
catch exception 
failed access fields action 
return null 
return 
