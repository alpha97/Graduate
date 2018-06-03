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

package achep base fragments dialogs 
import android dialog 
import android content activitynotfoundexception 
import android content context 
import android content intent 
import android bundle 
import android support annotation layoutres 
import android support annotation nonnull 
import android util 
import android view layoutinflater 
import android view view 
import android widget adapterview 
import android widget framelayout 
import android widget imageview 
import android widget progressbar 
import achep acdisplay 
import achep base appheap 
import achep base billing bitcoin 
import achep base billing paypal 
import achep base billing skuui 
import achep base interfaces iactivitybase 
import achep base interfaces iconfiguration 
import achep base adapters betterarrayadapter 
import achep base widgets headergridview 
import achep base widgets textview 
import achep base utils coinutils 
import achep base utils rippleutils 
import achep base utils toastutils 
import achep base utils viewutils 
import afollestad materialdialogs dialogaction 
import afollestad materialdialogs materialdialog 
import solovyev android checkout activitycheckout 
import solovyev android checkout billingrequests 
import solovyev android checkout checkout 
import solovyev android checkout inventory 
import solovyev android checkout producttypes 
import solovyev android checkout purchase 
import solovyev android checkout requestlistener 
import solovyev android checkout responsecodes 
import solovyev android checkout 
import java util comparator 
import static achep base build debug 
author artem chepurnoy 
public class donatedialog extends dialogfragment 
private static final string donatefragment 
private static final screen_loading 
private static final screen_inventory 
private static final screen_empty_view 
nonnull 
private final inventoryloadedlistener minventoryloadedlistener inventoryloadedlistener 
nonnull 
private final purchaselistener mpurchaselistener purchaselistener 
private activitycheckout mcheckout 
private skusadapter madapter 
private inventory minventory 
private progressbar mprogressbar 
private textview memptyview 
override 
public void onattach context context 
super onattach context 
context instanceof iactivitybase 
iactivitybase iactivitybase context 
mcheckout getcheckout 
mcheckout null 
string message must call requestcheckout activity before 
throw runtimeexception message 
return crash 
throw runtimeexception host activity must instance iactivitybase class 
override 
public void oncreate bundle savedinstancestate 
super oncreate savedinstancestate 
minventory mcheckout loadinventory 
nonnull 
override 
public dialog oncreatedialog bundle savedinstancestate 
materialdialog initdialog 
layoutinflater inflater layoutinflater getactivity 
getsystemservice context layout_inflater_service 
framelayout framelayout framelayout getactivity 
init description message 
textview textview textview inflater inflate layout dialog_message framelayout false 
textview settext string donate_dialog_message 
textview setpadding textview getpaddingtop textview getpaddingbottom 
init view with error view progressbar 
view phview inflater inflate layout dialog_donate_placeholder framelayout false 
mprogressbar progressbar phview findviewbyid progress 
memptyview textview phview findviewbyid empty 
memptyview settext string donate_billing_not_supported 
assert getcustomview null 
headergridview headergridview getcustomview findviewbyid grid 
addheaderview textview null false 
addheaderview phview null false 
setadapter madapter skusadapter getactivity layout 
setonitemclicklistener adapterview onitemclicklistener 
override 
public void onitemclick adapterview parent view view position long 
skuui skuui skuui parent getadapter getitem position 
purchase skuui 
return 
nonnull 
private materialdialog initdialog 
materialdialog builder builder materialdialog builder getactivity 
iconres drawable ic_gift_white_ 
title string donate_dialog_title 
customview layout dialog_donate false 
neutraltext string close 
final iconfiguration configuration appheap getinstance getconfiguration 
final boolean hasapl configuration getbilling hasalternativepaymentmethods 
hasapl return builder build 
final bitcoin bitcoin 
final paypal paypal 
materialdialog singlebuttoncallback callback materialdialog singlebuttoncallback 
override 
public void onclick nonnull materialdialog materialdialog 
nonnull dialogaction dialogaction 
dialogaction dialogaction positive 
startpaymentintentwithwarningalertdialog coinutils getpaymentintent 
else dialogaction dialogaction negative 
startpaymentintentwithwarningalertdialog coinutils getpaymentintent 
else dialogaction dialogaction neutral 
dismiss 
return builder 
positivetext getnameresource 
negativetext getnameresource 
onpositive callback 
onnegative callback 
onneutral callback 
autodismiss false 
build 
override 
public void onstart 
super onstart 
mcheckout createpurchaseflow mpurchaselistener 
reloadinventory 
override 
public void onstop 
mcheckout destroypurchaseflow 
super onstop 
shows warning alert dialog note that those methods 
suck hard nobody will care about 
starts intent user agree with 
private void startpaymentintentwithwarningalertdialog final intent intent 
materialdialog builder getactivity 
content string donate_alert_no_responsibility 
negativetext android string cancel 
positivetext android string 
onpositive materialdialog singlebuttoncallback 
override 
public void onclick nonnull materialdialog materialdialog 
nonnull dialogaction dialogaction 

startactivity intent 
dismiss dismiss main fragment 
catch activitynotfoundexception hell 
build 
show 
private void refreshui visibility 
viewutils setvisible mprogressbar visibility screen_loading 
viewutils setvisible memptyview visibility screen_empty_view 
private void reloadinventory 
loading state 
refreshui screen_loading 
reload inventory 
minventory 
load 
whenloaded minventoryloadedlistener 
private void purchase nonnull final 
debug purchasing tostring 
mcheckout whenready checkout listeneradapter 
override 
public void onready nonnull billingrequests requests 
requests purchase null mcheckout getpurchaseflow 
author artem chepurnoy 
private class inventoryloadedlistener implements inventory listener 
override 
public void onloaded nonnull inventory products products 
final inventory product product products producttypes in_app 
madapter setnotifyonchange false 
madapter clear 
product supported 
product getskus 
final purchase purchase product getpurchaseinstate purchase state purchased 
final skuui skuui myskuui purchase null 
madapter skuui 
sort items prices 
madapter sort comparator skuui 
override 
public compare nonnull skuui nonnull skuui 
return detailedprice amount detailedprice amount 
show inventory 
refreshui screen_inventory 
else refreshui screen_empty_view 
madapter notifydatasetchanged 
author artem chepurnoy 
private abstract class baserequestlistener implements requestlistener 
override 
public void onerror response nonnull exception 
toastutils showshort getactivity getlocalizedmessage 
author artem chepurnoy 
private final class purchaselistener extends baserequestlistener purchase 
override 
public void onsuccess nonnull purchase purchase 
onpurchased false 
override 
public void onerror response nonnull exception 
switch response 
case responsecodes item_already_owned 
onpurchased true 
break 
default 
super onerror response 
private void onpurchased boolean alreadyowned 
toastutils showlong getactivity string donate_thanks 
alreadyowned 
nothing changed need 
reload inventory 
return 
reloadinventory 
author artem chepurnoy 
private static final class skusadapter extends betterarrayadapter skuui 
author artem chepurnoy 
private static final class viewholder extends betterarrayadapter viewholder 
nonnull 
private final android widget textview description 
nonnull 
private final android widget textview price 
nonnull 
private final android widget textview currency 
nonnull 
private final imageview done 
public viewholder nonnull view view 
super view 
description android widget textview view findviewbyid description 
view layout view findviewbyid cost 
price android widget textview layout findviewbyid price 
currency android widget textview layout findviewbyid currency 
done imageview layout findviewbyid done 
public skusadapter nonnull context context layoutres layoutres 
super context layoutres 
nonnull 
override 
public betterarrayadapter viewholder oncreateviewholder nonnull view view 
return viewholder view 
override 
public void onbindviewholder nonnull betterarrayadapter viewholder viewholder 
binditem viewholder viewholder getitem 
private static void binditem nonnull viewholder holder nonnull skuui skuui 
rippleutils makefor holder view true 
holder description settext skuui getdescription 
visibility 
skuui ispurchased 
visibility view gone 
holder done setvisibility view visible 
else 
visibility view visible 
holder price settext skuui getpriceamount 
holder currency settext skuui getpricecurrency 
holder done setvisibility view gone 
holder price setvisibility visibility 
holder currency setvisibility visibility 
author artem chepurnoy 
private static class myskuui extends skuui 
public myskuui nonnull boolean ispurchased 
super ispurchased 
nonnull 
override 
protected string oncreatedescription nonnull 
those highly specific should probably 
moved 
string prefix donation_ 
startswith prefix 
data 
string donation_ 
string donation_ 
string donation_ 
string donation_ 
string donation_ 
string donation_ 
price integer parseint substring prefix length 
data length 
price data 
context context appheap getcontext 
return context getstring data 
alien found 
return alien found 
