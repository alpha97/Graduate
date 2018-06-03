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
import android bundle 
import android support annotation nonnull 
import android support dialogfragment 
import android view view 
import android widget adapterview 
import android widget listview 
import android widget textview 
import achep acdisplay 
import achep base permissions permission 
import achep base adapters permissionadapter 
import achep base utils toastutils 
import afollestad materialdialogs materialdialog 
import java util arraylist 
import java util list 
dialog fragment that helps user give needed permissions 

author artem chepurnoy 
public class permissionsdialog extends dialogfragment 
private static final string key_permissions permissions 
private permissionadapter madapter 
private permission mpermissions 
public static permissionsdialog newinstance nonnull permission permissions 
string string permissions length 
length 
permissions getclass getsimplename 
bundle bundle bundle 
bundle putstringarray key_permissions 
permissionsdialog fragment permissionsdialog 
fragment setarguments bundle 
return fragment 
override 
public void oncreate bundle savedinstancestate 
super oncreate savedinstancestate 
permissions array 
bundle args getarguments 
assert args null 
string args getstringarray key_permissions 
mpermissions permission null length 
length 
final string name 
mpermissions permission newinstance getactivity name 
nonnull 
override 
public dialog oncreatedialog bundle savedinstancestate 
context context getactivity 
assert context null 
materialdialog materialdialog builder context 
title string permissions_dialog_title 
items charsequence 
negativetext string later 
build 
make title more 
textview title gettitleview 
title settextcolor title getcurrenttextcolor xffff 
listview listview getlistview 
assert listview null 
madapter permissionadapter context arraylist permission 
listview setadapter madapter 
listview setonitemclicklistener adapterview onitemclicklistener 
override 
public void onitemclick adapterview parent view view position long 
permissionadapter adapter permissionadapter parent getadapter 
permission item adapter getitem position 

startactivity item getintentsettings 
catch activitynotfoundexception 
item geterrorresource 
toastutils showlong getactivity 
return 
override 
public void onresume 
super onresume 
list permission data madapter getpermissionlist 
data clear 
permission item mpermissions 
item isgranted 
data item 
dismiss permission dialog there work 
data isempty 
dismiss 
madapter notifydatasetchanged 
