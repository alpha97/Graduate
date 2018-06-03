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

package achep acdisplay 
import android content resources 
import android build 
import android support annotation nonnull 
import android support dialogfragment 
import android support fragment 
import android support fragmentmanager 
import android support fragmenttransaction 
import android support appcompatactivity 
import android text html 
import achep acdisplay 
import achep base device 
import achep base permissions permission 
import achep base tests check 
import achep base fragments dialogs aboutdialog 
import achep base fragments dialogs donatedialog 
import achep base fragments dialogs feedbackdialog 
import achep base fragments dialogs helpdialog 
import achep base fragments dialogs permissionsdialog 
import achep base utils resutils 
import afollestad materialdialogs materialdialog 
helper class showing fragment dialogs 
public class dialoghelper 
public static final string tag_fragment_about dialog_about 
public static final string tag_fragment_permissions dialog_permissions 
public static final string tag_fragment_help dialog_help 
public static final string tag_fragment_donation dialog_donate 
public static final string tag_fragment_feedback dialog_feedback 
shows about dialog that contains some info about program 
developers used libraries tools 
public static void showaboutdialog nonnull appcompatactivity activity 
showdialog activity aboutdialog class tag_fragment_about 
shows help dialog that contains some frequently asked questions 
some answers them this dialog that nobody reads 
public static void showhelpdialog nonnull appcompatactivity activity 
showdialog activity helpdialog class tag_fragment_help 
public static void showdonatedialog nonnull appcompatactivity activity 
showdialog activity donatedialog class tag_fragment_donation 
public static void showcrydialog nonnull appcompatactivity activity 
check getinstance isinmainthread 
resources activity getresources 
charsequence message html fromhtml getstring string cry_dialog_message 
materialdialog builder activity 
iconres drawable ic_action_about_white 
title string cry_dialog_title 
content message 
negativetext string close 
build 
show 
public static void showcompatdialog nonnull appcompatactivity activity 
check getinstance isinmainthread 
pairs 
string compat_dialog_item_notification 
android build version_codes jelly_bean_mr 
string compat_dialog_item_immersive_mode 
android build version_codes kitkat 
string compat_dialog_item_music_widget 
android build version_codes kitkat 
check over pairs 
boolean empty true 
pairs length 
final pairs 
device hastargetapi 
empty false 
break 
empty return 
string formatter activity getstring string compat_dialog_item_formatter 
stringbuilder builder stringbuilder 
pairs length 
final pairs 
device hastargetapi 
string activity getstring pairs 
string format formatter 
builder append 
string message resutils getstring activity string compat_dialog_message build version release builder 
materialdialog builder activity 
iconres drawable ic_dialog_compat_white 
title string compat_dialog_title 
content message 
negativetext string close 
build 
show 
public static void showfeedbackdialog nonnull appcompatactivity activity 
showdialog activity feedbackdialog class tag_fragment_feedback 
public static void showpermissionsdialog nonnull appcompatactivity activity 
nonnull permission permissions 
showdialog activity permissionsdialog newinstance permissions tag_fragment_permissions 
internal 
private static void showdialog nonnull appcompatactivity activity 
nonnull class clazz 
nonnull string 
dialogfragment 

dialogfragment clazz newinstance 
catch exception 
throw runtimeexception 
showdialog activity 
private static void showdialog nonnull appcompatactivity activity 
nonnull dialogfragment fragment 
nonnull string 
check getinstance isinmainthread 
fragmentmanager activity getsupportfragmentmanager 
fragmenttransaction begintransaction 
fragment prev findfragmentbytag 
prev null remove prev 
addtobackstack null 
fragment show 
