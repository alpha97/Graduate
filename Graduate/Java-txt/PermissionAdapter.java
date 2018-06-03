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

package achep base adapters 
import android content context 
import android support annotation nonnull 
import android view view 
import android widget imageview 
import android widget textview 
import achep acdisplay 
import achep base permissions permission 
import java util list 
author artem chepurnoy 
public class permissionadapter extends betterarrayadapter permission 
private final list permission mpermissions 
private static class viewholder extends betterarrayadapter viewholder 
final imageview icon 
final textview title 
final textview summary 
public viewholder nonnull view view 
super view 
this icon imageview view findviewbyid icon 
this title textview view findviewbyid title 
this summary textview view findviewbyid summary 
public permissionadapter context context list permission items 
super context layout item_blah 
mpermissions items 
nonnull 
override 
protected betterarrayadapter viewholder oncreateviewholder nonnull view view 
padding mcontext getresources getdimensionpixelsize dimen activity_horizontal_margin 
view setpadding padding view getpaddingtop padding view getpaddingbottom 
return viewholder view 
override 
protected void onbindviewholder nonnull betterarrayadapter viewholder viewholder 
final permission item getitem 
final viewholder holder viewholder viewholder 
holder title settext item gettitleresource 
holder summary settext item getsummaryresource 
holder icon setimageresource item geticonresource 
override 
public getcount 
return mpermissions size 
override 
public permission getitem position 
return mpermissions position 
nonnull 
public list permission getpermissionlist 
return mpermissions 
