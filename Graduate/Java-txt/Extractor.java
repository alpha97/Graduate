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
import android annotation suppresslint 
import android notification 
import android content context 
import android bundle 
import android support annotation nonnull 
import android support annotation nullable 
import android text spannable 
import android text spannablestringbuilder 
import android text spanned 
import android text textutils 
import android text style backgroundcolorspan 
import android text style characterstyle 
import android text style foregroundcolorspan 
import android text style textappearancespan 
import android util 
import android view layoutinflater 
import android view view 
import android view viewgroup 
import android widget remoteviews 
import android widget textview 
import achep acdisplay 
import achep base device 
import java lang reflect field 
import java util arraylist 
created artem 
final class extractor 
private static final string extractor 
removes kinds multiple spaces from given string 
nullable 
private static string removespaces nullable charsequence 
null return null 
string string instanceof string 
string tostring 
return string 
replaceall 
replaceall 
removes both link foregroundcolorspan link backgroundcolorspan from given string 
nullable 
private static charsequence removecolorspans nullable charsequence 
null return null 
instanceof spanned 
spannablestringbuilder 
instanceof spannable 
characterstyle styles 
spannable spanned spannable 
styles spanned getspans spanned length textappearancespan class 
characterstyle style styles spanned removespan style 
styles spanned getspans spanned length foregroundcolorspan class 
characterstyle style styles spanned removespan style 
styles spanned getspans spanned length backgroundcolorspan class 
characterstyle style styles spanned removespan style 
return 
suppresslint inlinedapi 
public void loadtexts nonnull context context nonnull opennotification 
final notification notification getnotification 
final bundle extras getextras notification 
extras null loadfromextras extras 
textutils isempty titletext 
textutils isempty titlebigtext 
textutils isempty messagetext 
messagetextlines null 
loadfromview context 
gets bundle with additional data from notification 
nullable 
suppresslint newapi 
private bundle getextras nonnull notification notification 
device haskitkatapi 
return notification extras 
access extras using reflections 

field field notification getclass getdeclaredfield extras 
field setaccessible true 
return bundle field notification 
catch exception 
failed access extras jelly bean 
return null 
nullable 
private charsequence doit nullable charsequence lines 
lines null 
filter empty lines 
arraylist charsequence list arraylist 
charsequence lines 
removespaces 
textutils isempty 
list removecolorspans 
create array 
list size 
return list toarray charsequence list size 
return null 
loading from extras 
loads possible texts from given link notification extras extras 
param extras extras load from 
suppresslint inlinedapi 
private void loadfromextras nonnull opennotification nonnull bundle extras 
titlebigtext extras getcharsequence notification extra_title_big 
titletext extras getcharsequence notification extra_title 
infotext extras getcharsequence notification extra_info_text 
subtext extras getcharsequence notification extra_sub_text 
summarytext extras getcharsequence notification extra_summary_text 
messagebigtext removecolorspans extras getcharsequence notification extra_big_text 
messagetext removecolorspans extras getcharsequence notification extra_text 
charsequence lines extras getcharsequencearray notification extra_text_lines 
messagetextlines doit lines 
loading from views 
private void loadfromview nonnull context context nonnull opennotification 
viewgroup view 
final context contextnotify notificationutils createcontext context 
contextnotify null return 
final notification notification getnotification 
final remoteviews notification bigcontentview null 
notification contentview 
notification bigcontentview 
load view from remote views 
layoutinflater inflater layoutinflater contextnotify getsystemservice context layout_inflater_service 

view viewgroup inflater inflate getlayoutid null 
reapply contextnotify view 
catch exception 
return 
arraylist textview textviews recursivefinder textview class expand view 
removeclickableviews textviews 
removesubtextviews context textviews 
removeactionviews getactions textviews 
views 
textviews size 
return 
textview title findtitletextview textviews 
textviews remove title need title view anymore 
titletext title gettext 
views 
textviews size 
return 
pull other texts merge them 
length textviews size 
charsequence messages charsequence length 
length messages textviews gettext 
messagetextlines doit messages 
private void removeactionviews nullable action actions 
nonnull arraylist textview textviews 
actions null 
return 
action action actions 
textviews size 
charsequence text textviews gettext 
text null text equals action title 
textviews remove 
break 
private void removeclickableviews nonnull arraylist textview textviews 
textviews size 
textview child textviews 
child isclickable child getvisibility view visible 
textviews remove 
break 
private void removesubtextviews nonnull context context 
nonnull arraylist textview textviews 
float subtextsize context getresources getdimension dimen notification_subtext_size 
textviews size 
final textview child textviews 
final string text child gettext tostring 
child gettextsize subtextsize 
empty textviews 
text matches 
clock textviews 
text matches 
textviews remove 
nonnull 
private textview findtitletextview nonnull arraylist textview textviews 
idea that title text 
largest 
textview largest null 
textview textview textviews 
largest null textview gettextsize largest gettextsize 
largest textview 
assert largest null cause count views always 
return largest 
private static class recursivefinder extends view 
private final arraylist list 
private final class clazz 
public recursivefinder nonnull class clazz 
this list arraylist 
this clazz clazz 
public arraylist expand nonnull viewgroup viewgroup 
offset 
childcount viewgroup getchildcount 
childcount 
view child viewgroup getchildat offset 
child null 
continue 
clazz isassignablefrom child getclass 
noinspection unchecked 
list child 
else child instanceof viewgroup 
expand viewgroup child 
return list 
