copyright android open source project 
licensed under apache license version license 
this file except compliance with license 
obtain copy license 
http apache licenses license 
unless required applicable agreed writing software 
distributed under license distributed basis 
without warranties conditions kind either express implied 
license specific language governing permissions 
limitations under license 
modified artem chepurnoy 
package achep base widgets 
import android content context 
import android database datasetobservable 
import android database datasetobserver 
import android util attributeset 
import android view view 
import android view viewgroup 
import android widget adapterview 
import android widget filter 
import android widget filterable 
import android widget framelayout 
import android widget gridview 
import android widget listadapter 
import android widget wrapperlistadapter 
import java util arraylist 
link gridview that supports adding header rows 
very similar link android widget listview 
link headergridview addheaderview view object boolean 
public class headergridview extends gridview 
private static final string headergridview 
class that represents fixed view list example header 
footer bottom 
private static class fixedviewinfo 
view grid 
public view view 
public viewgroup viewcontainer 
data backing view this returned from link listadapter getitem 
public object data 
code true code fixed view should selectable grid 
public boolean isselectable 
private final arraylist fixedviewinfo mheaderviewinfos arraylist 
private void initheadergridview 
super setclipchildren false 
public headergridview context context 
super context 
initheadergridview 
public headergridview context context attributeset attrs 
super context attrs 
initheadergridview 
public headergridview context context attributeset attrs defstyle 
super context attrs defstyle 
initheadergridview 
override 
protected void onmeasure widthmeasurespec heightmeasurespec 
super onmeasure widthmeasurespec heightmeasurespec 
listadapter adapter getadapter 
adapter null adapter instanceof headerviewgridadapter 
headerviewgridadapter adapter setnumcolumns getnumcolumns 
override 
public void setclipchildren boolean clipchildren 
ignore since header rows depend being clipped 
fixed view appear grid addheaderview 
called more than once views will appear order they were 
added views added using this call take focus they want 

note call this before calling setadapter this headergridview wrap 
supplied cursor with that will also account header views 
param view 
param data data associate with this view 
param isselectable whether item selectable 
public void addheaderview view object data boolean isselectable 
listadapter adapter getadapter 
adapter null adapter instanceof headerviewgridadapter 
throw illegalstateexception 
cannot header view grid setadapter already been called 
fixedviewinfo info fixedviewinfo 
framelayout fullwidthfixedviewlayout getcontext 
addview 
info view 
info viewcontainer 
info data data 
info isselectable isselectable 
mheaderviewinfos info 
case adding header view adding later 
need notify observer 
adapter null 
headerviewgridadapter adapter notifydatasetchanged 
fixed view appear grid addheaderview 
called more than once views will appear order they were 
added views added using this call take focus they want 

note call this before calling setadapter this headergridview wrap 
supplied cursor with that will also account header views 
param view 
public void addheaderview view 
addheaderview null true 
public getheaderviewcount 
return mheaderviewinfos size 
removes previously added header view 
param view remove 
return true view removed false view header 
view 
public boolean removeheaderview view 
mheaderviewinfos size 
boolean result false 
listadapter adapter getadapter 
adapter null headerviewgridadapter adapter removeheader 
result true 
removefixedviewinfo mheaderviewinfos 
return result 
return false 
private void removefixedviewinfo view arraylist fixedviewinfo where 
where size 

fixedviewinfo info where 
info view 
where remove 
break 
override 
public void setadapter listadapter adapter 
mheaderviewinfos size 
headerviewgridadapter hadapter headerviewgridadapter mheaderviewinfos adapter 
numcolumns getnumcolumns 
numcolumns 
hadapter setnumcolumns numcolumns 
super setadapter hadapter 
else 
super setadapter adapter 
private class fullwidthfixedviewlayout extends framelayout 
public fullwidthfixedviewlayout context context 
super context 
override 
protected void onmeasure widthmeasurespec heightmeasurespec 
targetwidth headergridview this getmeasuredwidth 
headergridview this getpaddingleft 
headergridview this getpaddingright 
widthmeasurespec measurespec makemeasurespec targetwidth 
measurespec getmode widthmeasurespec 
super onmeasure widthmeasurespec heightmeasurespec 
listadapter used when headergridview header views this listadapter 
wraps another also keeps track header views their 
associated data objects 
this intended base class will probably need 
this class directly your code 
private static class headerviewgridadapter implements wrapperlistadapter filterable 
this used notify container updates relating number columns 
headers changing which changes number placeholders needed 
private final datasetobservable mdatasetobservable datasetobservable 
private final listadapter madapter 
private mnumcolumns 
this arraylist assumed null 
arraylist fixedviewinfo mheaderviewinfos 
boolean mareallfixedviewsselectable 
private final boolean misfilterable 
public headerviewgridadapter arraylist fixedviewinfo headerviewinfos listadapter adapter 
madapter adapter 
misfilterable adapter instanceof filterable 
headerviewinfos null 
throw illegalargumentexception headerviewinfos cannot null 
mheaderviewinfos headerviewinfos 
mareallfixedviewsselectable arealllistinfosselectable mheaderviewinfos 
public getheaderscount 
return mheaderviewinfos size 
override 
public boolean isempty 
return madapter null madapter isempty getheaderscount 
public void setnumcolumns numcolumns 
numcolumns 
throw illegalargumentexception number columns must more 
mnumcolumns numcolumns 
mnumcolumns numcolumns 
notifydatasetchanged 
private boolean arealllistinfosselectable arraylist fixedviewinfo infos 
infos null 
fixedviewinfo info infos 
info isselectable 
return false 
return true 
public boolean removeheader view 
mheaderviewinfos size 
fixedviewinfo info mheaderviewinfos 
info view 
mheaderviewinfos remove 
mareallfixedviewsselectable arealllistinfosselectable mheaderviewinfos 
mdatasetobservable notifychanged 
return true 
return false 
override 
public getcount 
madapter null 
return getheaderscount mnumcolumns madapter getcount 
else 
return getheaderscount mnumcolumns 
override 
public boolean areallitemsenabled 
return madapter null mareallfixedviewsselectable madapter areallitemsenabled 
override 
public boolean isenabled position 
header negative positions will throw arrayindexoutofboundsexception 
numheadersandplaceholders getheaderscount mnumcolumns 
position numheadersandplaceholders 
return position mnumcolumns 
mheaderviewinfos position mnumcolumns isselectable 
adapter 
final adjposition position numheadersandplaceholders 
adaptercount 
madapter null 
adaptercount madapter getcount 
adjposition adaptercount 
return madapter isenabled adjposition 
throw arrayindexoutofboundsexception position 
override 
public object getitem position 
header negative positions will throw arrayindexoutofboundsexception 
numheadersandplaceholders getheaderscount mnumcolumns 
position numheadersandplaceholders 
position mnumcolumns 
return mheaderviewinfos position mnumcolumns data 
return null 
adapter 
final adjposition position numheadersandplaceholders 
adaptercount 
madapter null 
adaptercount madapter getcount 
adjposition adaptercount 
return madapter getitem adjposition 
throw arrayindexoutofboundsexception position 
override 
public long getitemid position 
numheadersandplaceholders getheaderscount mnumcolumns 
madapter null position numheadersandplaceholders 
adjposition position numheadersandplaceholders 
adaptercount madapter getcount 
adjposition adaptercount 
return madapter getitemid adjposition 
return 
override 
public boolean hasstableids 
return madapter null madapter hasstableids 
override 
public view getview position view convertview viewgroup parent 
header negative positions will throw arrayindexoutofboundsexception 
numheadersandplaceholders getheaderscount mnumcolumns 
position numheadersandplaceholders 
view headerviewcontainer mheaderviewinfos 
position mnumcolumns viewcontainer 
position mnumcolumns 
return headerviewcontainer 
else 
convertview null 
convertview view parent getcontext 
need this because gridview uses height last item 
determine height entire 
convertview setvisibility view invisible 
convertview setminimumheight headerviewcontainer getheight 
return convertview 
adapter 
final adjposition position numheadersandplaceholders 
adaptercount 
madapter null 
adaptercount madapter getcount 
adjposition adaptercount 
return madapter getview adjposition convertview parent 
throw arrayindexoutofboundsexception position 
override 
public getitemviewtype position 
numheadersandplaceholders getheaderscount mnumcolumns 
position numheadersandplaceholders position mnumcolumns 
placeholders last view type number 
return madapter null madapter getviewtypecount 
madapter null position numheadersandplaceholders 
adjposition position numheadersandplaceholders 
adaptercount madapter getcount 
adjposition adaptercount 
return madapter getitemviewtype adjposition 
return adapterview item_view_type_header_or_footer 
override 
public getviewtypecount 
madapter null 
return madapter getviewtypecount 
return 
override 
public void registerdatasetobserver datasetobserver observer 
mdatasetobservable registerobserver observer 
madapter null 
madapter registerdatasetobserver observer 
override 
public void unregisterdatasetobserver datasetobserver observer 
mdatasetobservable unregisterobserver observer 
madapter null 
madapter unregisterdatasetobserver observer 
override 
public filter getfilter 
misfilterable 
return filterable madapter getfilter 
return null 
override 
public listadapter getwrappedadapter 
return madapter 
public void notifydatasetchanged 
mdatasetobservable notifychanged 
