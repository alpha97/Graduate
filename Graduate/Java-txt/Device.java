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

package achep base 
import android build 
contains params current device this nice because override 
some here test compatibility with 
author artem chepurnoy 
public class device 
user visible version framework 
possible values defined build version_codes 
public static final api_version build version sdk_int 
name android version represented three 
letters example kitkat kitkat watches 
public static final string api_version_name_short 
static 
switch api_version 
case build version_codes jelly_bean 
api_version_name_short 
break 
case build version_codes jelly_bean_mr 
api_version_name_short 
break 
case build version_codes jelly_bean_mr 
api_version_name_short 
break 
case build version_codes kitkat 
api_version_name_short 
break 
case build version_codes kitkat_watch 
api_version_name_short 
break 
case build version_codes lollipop 
api_version_name_short 
break 
case build version_codes lollipop_mr 
api_version_name_short 
break 
case build version_codes 
api_version_name_short 
break 
default 
api_version_name_short hasmarshmallowapi 
return code true device device supports given version 
code false otherwise 
public static boolean hastargetapi 
return api_version 
return code true device running 
link build version_codes marshmallow higher code false otherwise 
public static boolean hasmarshmallowapi 
return hastargetapi build version_codes 
return code true device running 
link build version_codes lollipop_mr lollipop higher code false otherwise 
public static boolean haslollipopmr 
return hastargetapi build version_codes lollipop_mr 
return code true device running 
link build version_codes lollipop lollipop higher code false otherwise 
public static boolean haslollipopapi 
return hastargetapi build version_codes lollipop 
return code true device running 
link build version_codes kitkat_watch kitkat watch higher code false otherwise 
public static boolean haskitkatwatchapi 
return hastargetapi build version_codes kitkat_watch 
return code true device running 
link build version_codes kitkat kitkat higher code false otherwise 
public static boolean haskitkatapi 
return hastargetapi build version_codes kitkat 
return code true device running 
link build version_codes jelly_bean_mr jelly bean higher code false otherwise 
public static boolean hasjellybeanmr 
return hastargetapi build version_codes jelly_bean_mr 
return code true device running 
link build version_codes jelly_bean_mr jelly bean higher code false otherwise 
public static boolean hasjellybeanmr 
return hastargetapi build version_codes jelly_bean_mr 
return code true device produced probably 
buggy software 
public static boolean islge 
return build brand equalsignorecase 
