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

package achep base widgets 
import android annotation suppresslint 
import android content context 
import android content resources 
import android util attributeset 
import android view view 
import android view viewgroup 
import achep acdisplay 
import achep base device 
public class dashboardlayout extends viewgroup 
private final float mcellgapx 
private final float mcellgapy 
private mnumrows 
private final mnumcolumns 
public dashboardlayout context context attributeset attrs 
super context attrs 
final resources context getresources 
mcellgapx getdimension dimen dashboard_cell_gap_x 
mcellgapy getdimension dimen dashboard_cell_gap_y 
mnumcolumns getinteger integer dashboard_num_columns 
override 
protected void onmeasure widthmeasurespec heightmeasurespec 
final childcount getchildcount 
final width measurespec getsize widthmeasurespec 
final availablewidth width getpaddingleft getpaddingright 
mnumcolumns mcellgapx 
float cellwidth float math ceil float availablewidth mnumcolumns 
cellheight 
cursor 
childcount 
dashboardtileview dashboardtileview getchildat 
getvisibility view gone continue 
layoutparams getlayoutparams 
colspan getcolumnspan 
width colspan cellwidth colspan mcellgapx 
measure child 
newwidthspec getchildmeasurespec widthmeasurespec width 
newheightspec getchildmeasurespec heightmeasurespec height 
measure newwidthspec newheightspec 
save cell height 
cellheight 
cellheight getmeasuredheight 
height cellheight 
cursor colspan 
mnumrows math ceil float cursor mnumcolumns 
final newheight mnumrows cellheight mnumrows mcellgapy 
getpaddingtop getpaddingbottom 
setmeasureddimension width newheight 
override 
protected void onlayout boolean changed 
final childcount getchildcount 
final boolean islayoutrtl islayoutrtl 
final width getwidth 
getpaddingstartleft 
getpaddingtop 
cursor 
childcount 
final dashboardtileview dashboardtileview getchildat 
final layoutparams getlayoutparams 
getvisibility gone continue 
final cursor mnumcolumns 
final colspan getcolumnspan 
final childwidth width 
final childheight height 
cursor mnumcolumns 
setdividervisibility mnumrows 
push item next this 
colspan mnumcolumns 
getpaddingstartleft 
childheight mcellgapy 

final childleft islayoutrtl width childwidth 
final childright childleft childwidth 
final childtop 
final childbottom childtop childheight 
layout container 
layout childleft childtop childright childbottom 
offset position cell reset position cursor when 
reach 
cursor getcolumnspan 
cursor mnumcolumns 
childwidth mcellgapx 
else 
getpaddingstartleft 
childheight mcellgapy 
return code true this layout right left otherwise 
this device android version doesn support 
returns code false 
suppresslint newapi 
private boolean islayoutrtl 
return device hasjellybeanmr getlayoutdirection layout_direction_rtl 
suppresslint newapi 
private getpaddingstartleft 
return device hasjellybeanmr 
getpaddingstart 
getpaddingleft 
