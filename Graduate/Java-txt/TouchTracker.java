package dreamers graphics 
import android view motionevent 
import android view view 
import android view viewconfiguration 
import java lang weakreference 
public class touchtracker implements view ontouchlistener 
rippledrawable mhotspotdrawable 
performclick mperformclick 
checkfortap mpendingcheckfortap 
checkforlongpress mpendingcheckforlongpress 
unsetpressedstate munsetpressedstate 
boolean mhasperformedlongpress 
mtouchslop 
boolean mprepressed 
boolean minsidescrollcontainer 
public touchtracker rippledrawable hotspot 
mhotspotdrawable hotspot 
mtouchslop 
public void setinsidescrollcontainer boolean inside 
minsidescrollcontainer inside 
override 
public boolean ontouch view motionevent event 
final float event getx 
final float event gety 
isclickable islongclickable 
switch event getaction 
case motionevent action_up 
mprepressed pointinview mtouchslop ispressed 
take focus have already should 
touch mode 
boolean focustaken false 
isfocusable isfocusableintouchmode isfocused 
focustaken requestfocus 
mprepressed 
button being released before actually 
showed pressed make show pressed 
state before scheduling click ensure 
user sees 
setpressed true 
mhasperformedlongpress 
this remove longpress check 
removelongpresscallback 
only perform take click actions were pressed state 
focustaken 
runnable post this rather than calling 
performclick directly this lets other visual state 
view update before click actions start 
mperformclick null 
mperformclick performclick 
post mperformclick 
performclick 
munsetpressedstate null 
munsetpressedstate unsetpressedstate 
mprepressed 
postdelayed munsetpressedstate 
viewconfiguration getpressedstateduration 
else post munsetpressedstate 
post failed unpress right 
munsetpressedstate 
removetapcallback 
break 
case motionevent action_down 
mhasperformedlongpress false 
minsidescrollcontainer 
mprepressed true 
mpendingcheckfortap null 
mpendingcheckfortap checkfortap 
mpendingcheckfortap event getx 
mpendingcheckfortap event gety 
postdelayed mpendingcheckfortap viewconfiguration gettaptimeout 
else 
setpressed true 
checkforlongclick 
break 
case motionevent action_move 
mhotspotdrawable sethotspot 
mtouchslop 
mtouchslop viewconfiguration getcontext getscaledtouchslop 
lenient about moving outside buttons 
pointinview mtouchslop 
outside button 
removetapcallback 
ispressed 
remove future long press checks 
removelongpresscallback 
setpressed false 
break 
case motionevent action_cancel 
setpressed false 
removetapcallback 
removelongpresscallback 
break 
return true 
return false 
private void checkforlongclick view target delayoffset 
target islongclickable 
mhasperformedlongpress false 
mpendingcheckforlongpress null 
mpendingcheckforlongpress checkforlongpress target 
target postdelayed mpendingcheckforlongpress 
viewconfiguration getlongpresstimeout delayoffset 
void setpressed view target boolean pressed float float 
target setpressed pressed 
mhotspotdrawable sethotspot 
utility method determine whether given point local coordinates 
inside view where area view expanded slop factor 
this method called while processing touch move events determine event 
still within view 
hide 
public boolean pointinview view target float localx float localy float slop 
return localx slop localy slop localx target getright target getleft slop 
localy target getbottom target gettop slop 
void removetapcallback view target 
mpendingcheckfortap null 
target removecallbacks mpendingcheckfortap 
void removelongpresscallback view target 
mpendingcheckforlongpress null 
target removecallbacks mpendingcheckforlongpress 
private final static class performclick implements runnable 
weakreference view target 
private performclick view target 
this target weakreference target 
override 
public void 
target null 
target performclick 
final class checkfortap implements runnable 
view target 
float 
checkfortap view target 
this target target 
override 
public void 
mprepressed true 
setpressed target true 
checkforlongclick target viewconfiguration gettaptimeout 
private final class checkforlongpress implements runnable 
view target 
private checkforlongpress view target 
this target target 
override 
public void 
target ispressed target getparent null 
target performlongclick 
mhasperformedlongpress true 
mprepressed false 
private static final class unsetpressedstate implements runnable 
view target 
private unsetpressedstate view target 
this target target 
override 
public void 
target setpressed false 
