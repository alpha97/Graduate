copyright google 
licensed under apache license version license 
this file except compliance with license 
obtain copy license 
http apache licenses license 
unless required applicable agreed writing software 
distributed under license distributed basis 
without warranties conditions kind either express implied 
license specific language governing permissions 
limitations under license 
package ringdroid gift
import android content context 
import android content resources 
import android graphics canvas 
import android graphics dashpatheffect 
import android graphics paint 
import android util attributeset 
import android util 
import android view gesturedetector 
import android view motionevent 
import android view scalegesturedetector 
import android view view 
import ringdroid soundfile soundfile 
waveformview android view that displays visual representation 
audio waveform retrieves frame gains from cheapsoundfile 
object recomputes shape contour several zoom levels 
this class doesn handle selection touch interactions 
directly exposes listener interface class that embeds 
this view should itself listener make view scroll 
respond other events appropriately 
waveformview doesn actually handle selection will just display 
selected part waveform different color 
public class waveformview extends view 
public interface waveformlistener 
public void waveformtouchstart float 
public void waveformtouchmove float 
public void waveformtouchend 
public void waveformfling float 
public void waveformdraw 
public void waveformzoomin 
public void waveformzoomout 
colors 
private paint mgridpaint 
private paint mselectedlinepaint 
private paint munselectedlinepaint 
private paint munselectedbkgndlinepaint 
private paint mborderlinepaint 
private paint mplaybacklinepaint 
private paint mtimecodepaint 
private soundfile msoundfile 
private mlenbyzoomlevel 
private double mvaluesbyzoomlevel 
private double mzoomfactorbyzoomlevel 
private mheightsatthiszoomlevel 
private mzoomlevel 
private mnumzoomlevels 
private msamplerate 
private msamplesperframe 
private moffset 
private mselectionstart 
private mselectionend 
private mplaybackpos 
private float mdensity 
private float minitialscalespan 
private waveformlistener mlistener 
private gesturedetector mgesturedetector 
private scalegesturedetector mscalegesturedetector 
private boolean minitialized 
public waveformview context context attributeset attrs 
super context attrs 
want keys markers these 
setfocusable false 
resources getresources 
mgridpaint paint 
mgridpaint setantialias false 
mgridpaint setcolor getcolor color grid_line 
mselectedlinepaint paint 
mselectedlinepaint setantialias false 
mselectedlinepaint setcolor getcolor color waveform_selected 
munselectedlinepaint paint 
munselectedlinepaint setantialias false 
munselectedlinepaint setcolor getcolor color waveform_unselected 
munselectedbkgndlinepaint paint 
munselectedbkgndlinepaint setantialias false 
munselectedbkgndlinepaint setcolor getcolor color waveform_unselected_bkgnd_overlay 
mborderlinepaint paint 
mborderlinepaint setantialias true 
mborderlinepaint setstrokewidth 
mborderlinepaint setpatheffect dashpatheffect float 
mborderlinepaint setcolor getcolor color selection_border 
mplaybacklinepaint paint 
mplaybacklinepaint setantialias false 
mplaybacklinepaint setcolor getcolor color playback_indicator 
mtimecodepaint paint 
mtimecodepaint settextsize 
mtimecodepaint setantialias true 
mtimecodepaint setcolor getcolor color timecode 
mtimecodepaint setshadowlayer getcolor color timecode_shadow 
mgesturedetector gesturedetector 
context 
gesturedetector simpleongesturelistener 
public boolean onfling motionevent motionevent float float 
mlistener waveformfling 
return true 
mscalegesturedetector scalegesturedetector 
context 
scalegesturedetector simpleonscalegesturelistener 
public boolean onscalebegin scalegesturedetector 
ringdroid scalebegin getcurrentspanx 
minitialscalespan math getcurrentspanx 
return true 
public boolean onscale scalegesturedetector 
float scale math getcurrentspanx 
ringdroid scale scale minitialscalespan 
scale minitialscalespan 
mlistener waveformzoomin 
minitialscalespan scale 
scale minitialscalespan 
mlistener waveformzoomout 
minitialscalespan scale 
return true 
public void onscaleend scalegesturedetector 
ringdroid scaleend getcurrentspanx 
msoundfile null 
mlenbyzoomlevel null 
mvaluesbyzoomlevel null 
mheightsatthiszoomlevel null 
moffset 
mplaybackpos 
mselectionstart 
mselectionend 
mdensity 
minitialized false 
override 
public boolean ontouchevent motionevent event 
mscalegesturedetector ontouchevent event 
mgesturedetector ontouchevent event 
return true 
switch event getaction 
case motionevent action_down 
mlistener waveformtouchstart event getx 
break 
case motionevent action_move 
mlistener waveformtouchmove event getx 
break 
case motionevent action_up 
mlistener waveformtouchend 
break 
return true 
public boolean hassoundfile 
return msoundfile null 
public void setsoundfile soundfile soundfile 
msoundfile soundfile 
msamplerate msoundfile getsamplerate 
msamplesperframe msoundfile getsamplesperframe 
computedoublesforallzoomlevels 
mheightsatthiszoomlevel null 
public boolean isinitialized 
return minitialized 
public getzoomlevel 
return mzoomlevel 
public void setzoomlevel zoomlevel 
while mzoomlevel zoomlevel 
zoomin 
while mzoomlevel zoomlevel 
zoomout 
public boolean canzoomin 
return mzoomlevel 
public void zoomin 
canzoomin 
mzoomlevel 
mselectionstart 
mselectionend 
mheightsatthiszoomlevel null 
offsetcenter moffset getmeasuredwidth 
offsetcenter 
moffset offsetcenter getmeasuredwidth 
moffset 
moffset 
invalidate 
public boolean canzoomout 
return mzoomlevel mnumzoomlevels 
public void zoomout 
canzoomout 
mzoomlevel 
mselectionstart 
mselectionend 
offsetcenter moffset getmeasuredwidth 
offsetcenter 
moffset offsetcenter getmeasuredwidth 
moffset 
moffset 
mheightsatthiszoomlevel null 
invalidate 
public maxpos 
return mlenbyzoomlevel mzoomlevel 
public secondstoframes double seconds 
return seconds msamplerate msamplesperframe 
public secondstopixels double seconds 
double mzoomfactorbyzoomlevel mzoomlevel 
return seconds msamplerate msamplesperframe 
public double pixelstoseconds pixels 
double mzoomfactorbyzoomlevel mzoomlevel 
return pixels double msamplesperframe msamplerate 
public millisecstopixels msecs 
double mzoomfactorbyzoomlevel mzoomlevel 
return msecs msamplerate 
msamplesperframe 
public pixelstomillisecs pixels 
double mzoomfactorbyzoomlevel mzoomlevel 
return pixels msamplesperframe 
msamplerate 
public void setparameters start offset 
mselectionstart start 
mselectionend 
moffset offset 
public getstart 
return mselectionstart 
public getend 
return mselectionend 
public getoffset 
return moffset 
public void setplayback 
mplaybackpos 
public void setlistener waveformlistener listener 
mlistener listener 
public void recomputeheights float density 
mheightsatthiszoomlevel null 
mdensity density 
mtimecodepaint settextsize density 
invalidate 
protected void drawwaveformline canvas canvas 

paint paint 
canvas drawline paint 
override 
protected void ondraw canvas canvas 
super ondraw canvas 
msoundfile null 
return 
mheightsatthiszoomlevel null 
computeintsforthiszoomlevel 
draw waveform 
measuredwidth getmeasuredwidth 
measuredheight getmeasuredheight 
start moffset 
width mheightsatthiszoomlevel length start 
measuredheight 
width measuredwidth 
width measuredwidth 
draw grid 
double onepixelinsecs pixelstoseconds 
boolean onlyeveryfivesecs onepixelinsecs 
double fractionalsecs moffset onepixelinsecs 
integersecs fractionalsecs 

while width 
fractionalsecs onepixelinsecs 
integersecsnew fractionalsecs 
integersecsnew integersecs 
integersecs integersecsnew 
onlyeveryfivesecs integersecs 
canvas drawline measuredheight mgridpaint 
draw waveform 
width 
paint paint 
start mselectionstart 
start mselectionend 
paint mselectedlinepaint 
else 
drawwaveformline canvas measuredheight 
munselectedbkgndlinepaint 
paint munselectedlinepaint 
drawwaveformline 
canvas 
mheightsatthiszoomlevel start 
mheightsatthiszoomlevel start 
paint 
start mplaybackpos 
canvas drawline measuredheight mplaybacklinepaint 
right edge waveform draw 
waveform area right unselected 
width measuredwidth 
drawwaveformline canvas measuredheight 
munselectedbkgndlinepaint 
draw borders 
canvas drawline 
mselectionstart moffset 
mselectionstart moffset measuredheight 
mborderlinepaint 
canvas drawline 
mselectionend moffset 
mselectionend moffset measuredheight 
mborderlinepaint 
draw timecode 
double timecodeintervalsecs 
timecodeintervalsecs onepixelinsecs 
timecodeintervalsecs 
timecodeintervalsecs onepixelinsecs 
timecodeintervalsecs 
draw grid 
fractionalsecs moffset onepixelinsecs 
integertimecode fractionalsecs timecodeintervalsecs 

while width 
fractionalsecs onepixelinsecs 
integersecs fractionalsecs 
integertimecodenew fractionalsecs 
timecodeintervalsecs 
integertimecodenew integertimecode 
integertimecode integertimecodenew 
turn seconds into 
string timecodeminutes integersecs 
string timecodeseconds integersecs 
integersecs 
timecodeseconds timecodeseconds 
string timecodestr timecodeminutes timecodeseconds 
float offset float 
mtimecodepaint measuretext timecodestr 
canvas drawtext timecodestr 
offset 
mdensity 
mtimecodepaint 
mlistener null 
mlistener waveformdraw 
called once when sound file added 
private void computedoublesforallzoomlevels 
numframes msoundfile getnumframes 
framegains msoundfile getframegains 
double smoothedgains double numframes 
numframes 
smoothedgains framegains 
else numframes 
smoothedgains framegains 
smoothedgains framegains 
else numframes 
smoothedgains double 
framegains 
framegains 
numframes 
smoothedgains double 
framegains 
framegains 
framegains 
smoothedgains numframes double 
framegains numframes 
framegains numframes 
make sure range more than 
double maxgain 
numframes 
smoothedgains maxgain 
maxgain smoothedgains 
double scalefactor 
maxgain 
scalefactor maxgain 
build histogram bins figure scaled 
maxgain 
gainhist 
numframes 
smoothedgain smoothedgains scalefactor 
smoothedgain 
smoothedgain 
smoothedgain 
smoothedgain 
smoothedgain maxgain 
maxgain smoothedgain 
gainhist smoothedgain 
calibrate 
double mingain 

while mingain numframes 
gainhist mingain 
mingain 
calibrate 

while maxgain numframes 
gainhist maxgain 
maxgain 
compute heights 
double heights double numframes 
double range maxgain mingain 
numframes 
double value smoothedgains scalefactor mingain range 
value 
value 
value 
value 
heights value value 
mnumzoomlevels 
mlenbyzoomlevel 
mzoomfactorbyzoomlevel double 
mvaluesbyzoomlevel double 
level doubled with interpolated values 
mlenbyzoomlevel numframes 
mzoomfactorbyzoomlevel 
mvaluesbyzoomlevel double mlenbyzoomlevel 
numframes 
mvaluesbyzoomlevel heights 
mvaluesbyzoomlevel heights 
numframes 
mvaluesbyzoomlevel heights heights 
mvaluesbyzoomlevel heights 
level normal 
mlenbyzoomlevel numframes 
mvaluesbyzoomlevel double mlenbyzoomlevel 
mzoomfactorbyzoomlevel 
mlenbyzoomlevel 
mvaluesbyzoomlevel heights 
more levels each halved 

mlenbyzoomlevel mlenbyzoomlevel 
mvaluesbyzoomlevel double mlenbyzoomlevel 
mzoomfactorbyzoomlevel mzoomfactorbyzoomlevel 
mlenbyzoomlevel 
mvaluesbyzoomlevel 
mvaluesbyzoomlevel 
mvaluesbyzoomlevel 
numframes 
mzoomlevel 
else numframes 
mzoomlevel 
else numframes 
mzoomlevel 
else 
mzoomlevel 
minitialized true 
called first time need draw when zoom level changed 
screen resized 
private void computeintsforthiszoomlevel 
halfheight getmeasuredheight 
mheightsatthiszoomlevel mlenbyzoomlevel mzoomlevel 
mlenbyzoomlevel mzoomlevel 
mheightsatthiszoomlevel 
mvaluesbyzoomlevel mzoomlevel halfheight 
