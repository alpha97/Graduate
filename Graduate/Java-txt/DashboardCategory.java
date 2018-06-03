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
import android content resources 
import android content typedarray 
import android parcel 
import android parcelable 
import android support annotation nonnull 
import android text textutils 
import android util attributeset 
import android util typedvalue 
import achep acdisplay 
import apache commons lang builder equalsbuilder 
import apache commons lang builder hashcodebuilder 
import java util arraylist 
import java util collection 
import java util iterator 
import java util list 
import java util listiterator 
public class dashboardcategory implements parcelable list dashboardtile 
default value link achep base dashboard dashboardcategory dashboardcategory 
indicating that identifier value other values including those below 
valid 
public static final cat_id_undefined 
identifier this tile correlate with list when 
updated default value 
link achep base dashboard dashboardtile tile_id_undefined meaning 
public long cat_id_undefined 
resource title category that shown user 
public titleres 
title category that shown user 
public charsequence title 
list category children 
public final list dashboardtile tiles arraylist 
public dashboardcategory context context attributeset attrs 
typedarray context obtainstyledattributes attrs styleable dashboardtile 
getresourceid styleable dashboardtile_dashboard_id cat_id_undefined 
typedvalue peekvalue styleable dashboardtile_dashboard_title 
null type typedvalue type_string 
resourceid 
titleres resourceid 
else 
title string 
recycle 
return currently title link titleres 
this resource loaded from stored link title 
public charsequence gettitle resources 
titleres 
title gettext titleres 
titleres 
return title 
inheritdoc 
override 
public boolean equals object 
this 
return true 
instanceof dashboardcategory 
return false 
dashboardcategory dashboardcategory 
return equalsbuilder 
append 
append titleres titleres 
append title title 
append tiles tiles 
isequals 
inheritdoc 
override 
public hashcode 
return hashcodebuilder 
append 
append titleres 
append title 
append tiles 
tohashcode 
parcelable implementation 
public static final creator dashboardcategory creator 
creator dashboardcategory 
public dashboardcategory createfromparcel parcel source 
return dashboardcategory source 
public dashboardcategory newarray size 
return dashboardcategory size 
private dashboardcategory parcel 
titleres readint 
title textutils char_sequence_creator createfromparcel 
final count readint 
count 
dashboardtile tile dashboardtile creator createfromparcel 
tiles tile 
inheritdoc 
override 
public describecontents 
return 
inheritdoc 
override 
public void writetoparcel parcel dest flags 
dest writeint titleres 
textutils writetoparcel title dest flags 
final count tiles size 
dest writeint count 
count 
dashboardtile tile tiles 
tile writetoparcel dest flags 
list implementation 
inheritdoc 
override 
public void location dashboardtile object 
tiles location object 
inheritdoc 
override 
public boolean dashboardtile object 
return tiles object 
inheritdoc 
override 
public boolean addall location nonnull collection extends dashboardtile collection 
return tiles addall location collection 
inheritdoc 
override 
public boolean addall nonnull collection extends dashboardtile collection 
return tiles addall collection 
inheritdoc 
override 
public void clear 
tiles clear 
inheritdoc 
override 
public boolean contains object object 
return tiles contains object 
inheritdoc 
override 
public boolean containsall nonnull collection collection 
return tiles containsall collection 
inheritdoc 
override 
public dashboardtile location 
return tiles location 
inheritdoc 
override 
public indexof object object 
return tiles indexof object 
inheritdoc 
override 
public boolean isempty 
return tiles isempty 
inheritdoc 
nonnull 
override 
public iterator dashboardtile iterator 
return tiles iterator 
inheritdoc 
override 
public lastindexof object object 
return tiles lastindexof object 
inheritdoc 
nonnull 
override 
public listiterator dashboardtile listiterator 
return tiles listiterator 
inheritdoc 
nonnull 
override 
public listiterator dashboardtile listiterator location 
return tiles listiterator location 
inheritdoc 
override 
public dashboardtile remove location 
return tiles remove location 
inheritdoc 
override 
public boolean remove object object 
return tiles remove object 
inheritdoc 
override 
public boolean removeall nonnull collection collection 
return tiles removeall collection 
inheritdoc 
override 
public boolean retainall nonnull collection collection 
return tiles retainall collection 
inheritdoc 
override 
public dashboardtile location dashboardtile object 
return tiles location object 
inheritdoc 
override 
public size 
return tiles size 
inheritdoc 
nonnull 
override 
public list dashboardtile sublist start 
return tiles sublist start 
inheritdoc 
nonnull 
override 
public object toarray 
return tiles toarray 
inheritdoc 
suppresswarnings suspicioustoarraycall 
nonnull 
override 
public toarray nonnull array 
return tiles toarray array 
