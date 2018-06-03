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

package achep acdisplay utils tasks 
import android annotation targetapi 
import android usage usagestats 
import android usage usagestatsmanager 
import android content context 
import android build 
import android support annotation nonnull 
import android support annotation nullable 
import android util 
import java util list 
import java util sortedmap 
import java util treemap 
author artem chepurnoy 
targetapi build version_codes lollipop 
class runningtaskslollipop extends runningtasks 
private static final string runningtaskslollipop 
private static final string usage_stats_manager usagestats 
inheritdoc 
nullable 
public string getrunningtaskstop nonnull context context 

usagestats usagestats getusagestatstop context 
return usagestats null usagestats getpackagename null 
catch securityexception 
failed usage stats permissions denied 
printstacktrace 
return null 
suppresswarnings resourcetype 
nullable 
private sortedmap long usagestats getusagestats nonnull context context 
throws securityexception 
usagestatsmanager usagestatsmanager context getsystemservice usage_stats_manager 
usage stats last seconds 
final long timeend system currenttimemillis 
final long timebegin timeend 
list usagestats statslist queryusagestats usagestatsmanager interval_daily 
timebegin 
timeend 
statslist null 
sort stats last time used 
sortedmap long usagestats statssortedmap treemap 
final usagestats usagestats statslist 
filter system decor apps 
android systemui equals usagestats getpackagename 
continue 
statssortedmap usagestats getlasttimeused usagestats 
return statssortedmap 
return null 
nullable 
private usagestats getusagestatstop nonnull context context throws securityexception 
sortedmap long usagestats statssortedmap getusagestats context 
return statssortedmap null statssortedmap isempty 
statssortedmap statssortedmap lastkey 
null 
