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
import android content context 
import android content applicationinfo 
import android content packagemanager 
import android graphics bitmap 
import android graphics canvas 
import android graphics typeface 
import android graphics drawable drawable 
import android support annotation nonnull 
import android support annotation nullable 
import android text spannablestring 
import android text spanned 
import android text textutils 
import android text format dateutils 
import android text style stylespan 
import achep acdisplay config 
import achep acdisplay 
import achep acdisplay interfaces inotificatiable 
import achep base tests check 
import achep base utils csutils 
import achep base utils nullutils 
import achep base utils operator 
import achep base utils refcachebase 
import java lang reference 
import java lang softreference 
import java lang weakreference 
import java util arrays 
created artem chepurnoy 
public class notificationuihelper implements inotificatiable 
callback events 
public static final event_title_changed 
public static final event_message_changed 
public static final event_timestamp_changed 
public static final event_subtitle_changed 
public static final event_actions_changed 
public static final event_small_icon_changed 
public static final event_large_icon_changed 
pending updates 
private static final pending_update_title 
private static final pending_update_subtitle 
private static final pending_update_timestamp 
private static final pending_update_message 
private static final pending_update_actions 
private static final pending_update_icons 
private static softreference charsequence ssecurecontentlabelref 
static refcachebase bitmap sappiconcache refcachebase bitmap 
nonnull 
override 
protected reference bitmap oncreatereference nonnull bitmap bitmap 
return weakreference bitmap 
private opennotification mnotification 
private charsequence mmessages 
private charsequence mtitle 
private charsequence mtimestamp 
private charsequence msubtitle 
private action mactions 
private bitmap msmallicon 
private bitmap mlargeicon 
private boolean mbig 
private final context mcontext 
private final onnotificationcontentchanged mlistener 
private final opennotification onnotificationdatachangedlistener 
opennotification onnotificationdatachangedlistener 
override 
public void onnotificationdatachanged 
nonnull opennotification notification 
event 
check getinstance isinmainthread 
switch event 
case opennotification event_icon 
updateicons 
break 
private mpendingupdates 
private boolean mresumed 
public interface onnotificationcontentchanged 
param 
param event 
void onnotificationcontentchanged 
nonnull notificationuihelper helper 
final event 
public notificationuihelper 
nonnull context context 
nonnull onnotificationcontentchanged listener 
mcontext context 
mlistener listener 
public void resume 
check getinstance isinmainthread 
mresumed true 
synchronized notificationpresenter getinstance monitor 
operator bitand mpendingupdates pending_update_title updatetitle 
operator bitand mpendingupdates pending_update_subtitle updatesubtitle 
operator bitand mpendingupdates pending_update_timestamp updatetimestamp 
operator bitand mpendingupdates pending_update_message updatemessage 
operator bitand mpendingupdates pending_update_actions updateactions 
operator bitand mpendingupdates pending_update_icons updateicons 
mpendingupdates 
registernotificationlistener 
public void pause 
check getinstance isinmainthread 
unregisternotificationlistener 
mresumed false 
param 
public void setnotification nullable opennotification 
check getinstance isinmainthread 
unregisternotificationlistener 
mnotification 
registernotificationlistener 
synchronized notificationpresenter getinstance monitor 
update everything 
updatetitle 
updatetimestamp 
updatesubtitle 
updatemessage 
updateactions 
updateicons 
inheritdoc 
nullable 
override 
public opennotification getnotification 
return mnotification 
controls small types notification 
view 
public void setbig boolean isbig 
mbig isbig 
private void registernotificationlistener 
mnotification null mnotification registerlistener 
private void unregisternotificationlistener 
mnotification null mnotification unregisterlistener 
private boolean issecret minvisibility privacymask 
return notificationutils issecret mcontext mnotification minvisibility privacymask 
param mask following 
link pending_update_title link pending_update_subtitle 
link pending_update_message link pending_update_actions 
link pending_update_timestamp link pending_update_icons 
return code true update should canceled code false otherwise 
private boolean ispendingupdate mask 
mresumed 
mpendingupdates mask 
return true 
return false 
icons 
private void updateicons 
ispendingupdate pending_update_icons return 
mnotification null 
setlargeicon null 
setsmallicon null 
return 
final boolean secret islargeiconsecret 
bitmap bitmap 
secret 
load application icon large icon 
store bitmaps soft reference cache 
reduce memory usage improve performance 
string packagename mnotification getpackagename 
bitmap sappiconcache packagename null 
drawable drawable getappicon mnotification getpackagename 
drawable null 
bitmap bitmap createbitmap 
drawable getintrinsicwidth 
drawable getintrinsicheight 
bitmap config argb_ 
drawable setbounds bitmap getwidth bitmap getheight 
drawable draw canvas bitmap 
sappiconcache packagename bitmap 
else 
bitmap null 
sappiconcache remove packagename 
else 
bitmap mnotification getnotification largeicon 
bitmap null 
setlargeicon mnotification geticon 
setsmallicon null 
else 
setlargeicon bitmap 
setsmallicon mnotification geticon 
return code true large icon secret should visible 
user code false otherwise 
protected final boolean islargeiconsecret 
return issecret 
opennotification visibility_secret 
config privacy_hide_content_mask 
nullable 
private drawable getappicon nonnull string packagename 
packagemanager mcontext getpackagemanager 

applicationinfo appinfo getapplicationinfo packagename 
return getapplicationicon appinfo 
catch packagemanager namenotfoundexception 
return null 
private void setsmallicon nullable bitmap bitmap 
sameas msmallicon bitmap 
need notify listeners about this 
change 
return 
msmallicon bitmap 
mlistener onnotificationcontentchanged this event_small_icon_changed 
return notification small icon displayed 
getlargeicon 
nullable 
public bitmap getsmallicon 
return msmallicon 
private void setlargeicon nullable bitmap bitmap 
sameas mlargeicon bitmap 
need notify listeners about this 
change 
return 
mlargeicon bitmap 
mlistener onnotificationcontentchanged this event_large_icon_changed 
return notification large icon displayed 
getsmallicon 
nullable 
public bitmap getlargeicon 
return mlargeicon 
return code true both link bitmap bitmaps code null 
link bitmap bitmaps equal according 
link android graphics bitmap sameas android graphics bitmap code false otherwise 
private boolean sameas nullable bitmap bitmap nullable bitmap bitmap 
return bitmap bitmap bitmap null bitmap null bitmap sameas bitmap 
title 
private void updatetitle 
ispendingupdate pending_update_title return 
mnotification null 
settitle null 
return 
final boolean secret istitlesecret 
charsequence title 
secret 
charsequence applabel getapplabel mnotification getpackagename 
title applabel null applabel hidden 
else mbig 
title nullutils whilenotnull 
mnotification titlebigtext 
mnotification titletext 
else 
title mnotification titletext 
settitle title 
return code true title secret should visible 
user code false otherwise 
protected final boolean istitlesecret 
return issecret 
opennotification visibility_secret 
config privacy_hide_content_mask 
nullable 
private charsequence getapplabel nonnull string packagename 
packagemanager mcontext getpackagemanager 

applicationinfo appinfo getapplicationinfo packagename 
return getapplicationlabel appinfo 
catch packagemanager namenotfoundexception 
return null 
private void settitle nullable charsequence title 
textutils equals mtitle title 
need notify listeners about this 
change 
return 
mtitle title 
mlistener onnotificationcontentchanged this event_title_changed 
return notification title displayed 
getmessages 
opennotification getvisibility 
nullable 
public charsequence gettitle 
return mtitle 
timestamp 
private void updatetimestamp 
ispendingupdate pending_update_timestamp return 
mnotification null 
settimestamp null 
return 
final long when mnotification getnotification when 
settimestamp dateutils formatdatetime mcontext when dateutils format_show_time 
private void settimestamp nullable charsequence timestamp 
textutils equals mtimestamp timestamp 
need notify listeners about this 
change 
return 
mtimestamp timestamp 
mlistener onnotificationcontentchanged this event_timestamp_changed 
return notification timestamp displayed 
android notification when 
nullable 
public charsequence gettimestamp 
return mtimestamp 
subtitle 
protected void updatesubtitle 
ispendingupdate pending_update_subtitle return 
mnotification null 
setsubtitle null 
return 
setsubtitle csutils join mnotification subtext mnotification infotext 
private void setsubtitle nullable charsequence subtitle 
textutils equals msubtitle subtitle 
need notify listeners about this 
change 
return 
msubtitle subtitle 
mlistener onnotificationcontentchanged this event_subtitle_changed 
return notification subtitle displayed 
nullable 
public charsequence getsubtitle 
return msubtitle 
message 
updates message from current link mnotification notificiation 
setmessages charsequence 
ismessagesecret 
private void updatemessage 
ispendingupdate pending_update_message return 
mnotification null 
setmessages null 
return 
final boolean secret ismessagesecret 
message text 
secret 
charsequence messages 
ssecurecontentlabelref null messages ssecurecontentlabelref null 
final charsequence mcontext getstring string privacy_mode_hidden_content 
final spannablestring spannablestring 
check getinstance istrue length 
setspan stylespan typeface italic 
start length 
spanned span_exclusive_exclusive 
messages charsequence 
ssecurecontentlabelref softreference messages 
setmessages messages 
else 
charsequence message 
mbig 
mnotification messagetextlines null 
setmessages mnotification messagetextlines 
return 
message nullutils whilenotnull 
mnotification messagebigtext 
mnotification messagetext 
else 
message mnotification messagetext 
setmessages textutils isempty message null charsequence message 
return code true message secret should visible 
user code false otherwise 
protected final boolean ismessagesecret 
return mnotification iscontentsecret mcontext 
private void setmessages nullable charsequence messages 
arrays equals mmessages messages 
need notify listeners about this 
change 
return 
mmessages messages 
mlistener onnotificationcontentchanged this event_message_changed 
return notification messages displayed 
gettitle 
opennotification getvisibility 
nullable 
public charsequence getmessages 
return mmessages 
actions 
private void updateactions 
ispendingupdate pending_update_actions return 
mnotification null 
setactions null 
return 
final boolean secret isactionssecret 
setactions secret mbig null mnotification getactions 
return code true actions secret should visible 
user code false otherwise 
protected final boolean isactionssecret 
return issecret 
opennotification visibility_private 
config privacy_hide_actions_mask 
private void setactions nullable action actions 
arrays equals mactions actions 
need notify listeners about this 
change 
return 
mactions actions 
mlistener onnotificationcontentchanged this event_actions_changed 
return notification actions displayed 
opennotification getvisibility 
nullable 
public action getactions 
return mactions 
