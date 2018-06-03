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

package achep base utils 
import android annotation suppresslint 
import android content contentresolver 
import android content context 
import android provider settings 
import android support annotation nonnull 
import achep base device 
author artem chepurnoy 
public class zenutils 
public static final zen_mode_default zenconsts zen_mode_off 
suppresslint newapi 
public static getvalue nonnull context context 
device haslollipopapi 
return zenconsts zen_mode_off 
contentresolver context getcontentresolver 
return settings global getint zenconsts zen_mode zen_mode_default 
return same name constant 
nonnull 
public static string zenmodetostring zenmode 
switch zenmode 
case zenconsts zen_mode_off 
return zen_mode_off 
case zenconsts zen_mode_important_interruptions 
return zen_mode_important_interruptions 
case zenconsts zen_mode_no_interruptions 
return zen_mode_no_interruptions 
default 
return unknown_value 
