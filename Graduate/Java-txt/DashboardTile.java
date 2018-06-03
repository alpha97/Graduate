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

package achep base dashboard 
import android content context 
import android content intent 
import android content resources 
import android content typedarray 
import android bundle 
import android parcel 
import android parcelable 
import android text textutils 
import android util attributeset 
import android util typedvalue 
import achep acdisplay 
description single dashboard tile that user select 
public class dashboardtile implements parcelable 
default value link achep base dashboard dashboardtile dashboardtile 
indicating that identifier value other values including those below 
valid 
public static final tile_id_undefined 
identifier this tile correlate with list when 
updated default value 
link tile_id_undefined meaning 
public long tile_id_undefined 
resource title tile that shown user 
public titleres 
title tile that shown user 
public charsequence title 
resource optional summary describing what this tile controls 
public summaryres 
optional summary describing what this tile controls 
public charsequence summary 
optional icon resource show this tile 
public final iconres 
full class name fragment display when this tile 
selected 
public final string fragment 
optional arguments supply fragment when 
instantiated 
public bundle fragmentarguments 
intent launch when preference selected 
public intent intent 
optional additional data subclasses activity 
public bundle extras 
public dashboardtile context context attributeset attrs 
typedarray context obtainstyledattributes attrs styleable dashboardtile 
typedvalue 
getresourceid styleable dashboardtile_dashboard_id tile_id_undefined 
iconres getresourceid styleable dashboardtile_dashboard_icon 
fragment getstring styleable dashboardtile_dashboard_fragment 
peekvalue styleable dashboardtile_dashboard_title 
null type typedvalue type_string 
resourceid 
titleres resourceid 
else 
title string 
peekvalue styleable dashboardtile_dashboard_summary 
null type typedvalue type_string 
resourceid 
summaryres resourceid 
else 
summary string 
recycle 
return currently title link titleres 
this resource loaded from returned otherwise 
link title returned 
public charsequence gettitle resources 
return titleres gettext titleres title 
return currently summary link summaryres 
this resource loaded from returned otherwise 
link summary returned 
public charsequence getsummary resources 
return summaryres gettext summaryres summary 
parcelable implementation 
public static final creator dashboardtile creator 
creator dashboardtile 
public dashboardtile createfromparcel parcel source 
return dashboardtile source 
public dashboardtile newarray size 
return dashboardtile size 
private dashboardtile parcel 
readlong 
titleres readint 
title textutils char_sequence_creator createfromparcel 
summaryres readint 
summary textutils char_sequence_creator createfromparcel 
iconres readint 
fragment readstring 
fragmentarguments readbundle 
readint 
intent intent creator createfromparcel 
extras readbundle 
inheritdoc 
override 
public describecontents 
return 
inheritdoc 
override 
public void writetoparcel parcel dest flags 
dest writelong 
dest writeint titleres 
textutils writetoparcel title dest flags 
dest writeint summaryres 
textutils writetoparcel summary dest flags 
dest writeint iconres 
dest writestring fragment 
dest writebundle fragmentarguments 
intent null 
dest writeint 
intent writetoparcel dest flags 
else 
dest writeint 
dest writebundle extras 
