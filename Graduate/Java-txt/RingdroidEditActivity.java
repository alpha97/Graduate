copyright google 
licensed under apache license version license 
this file except compliance with license 
obtain copy license 
http apache licenses license 
unless required applicable agreed writing software 
distributed under license distributed basis 
without warranties conditions kind either express implied 
license specific language governing permissions 
limitations under license 
package ringdroid 
import android activity 
import android alertdialog 
import android progressdialog 
import android content contentvalues 
import android content dialoginterface 
import android content intent 
import android content packagemanager 
import android content configuration 
import android media ringtonemanager 
import android 
import android bundle 
import android environment 
import android handler 
import android message 
import android provider mediastore 
import android text editable 
import android text textwatcher 
import android util displaymetrics 
import android util 
import android view keyevent 
import android view menu 
import android view menuinflater 
import android view menuitem 
import android view view 
import android view view onclicklistener 
import android widget imagebutton 
import android widget relativelayout 
import android widget textview 
import android widget toast 
import ringdroid soundfile soundfile 
import java file 
import java stringwriter 
import java printwriter 
import java randomaccessfile 
activity ringdroid main editor window keeps track 
waveform display current horizontal offset marker handles 
start text boxes handles buttons controls 
public class ringdroideditactivity extends activity 
implements markerview markerlistener 
waveformview waveformlistener 
private long mloadinglastupdatetime 
private boolean mloadingkeepgoing 
private long mrecordinglastupdatetime 
private boolean mrecordingkeepgoing 
private double mrecordingtime 
private boolean mfinishactivity 
private textview mtimertextview 
private alertdialog malertdialog 
private progressdialog mprogressdialog 
private soundfile msoundfile 
private file mfile 
private string mfilename 
private string martist 
private string mtitle 
private mnewfilekind 
private boolean mwasgetcontentintent 
private waveformview mwaveformview 
private markerview mstartmarker 
private markerview mendmarker 
private textview mstarttext 
private textview mendtext 
private textview minfo 
private string minfocontent 
private imagebutton mplaybutton 
private imagebutton mrewindbutton 
private imagebutton mffwdbutton 
private boolean mkeydown 
private string mcaption 
private mwidth 
private mmaxpos 
private mstartpos 
private mendpos 
private boolean mstartvisible 
private boolean mendvisible 
private mlastdisplayedstartpos 
private mlastdisplayedendpos 
private moffset 
private moffsetgoal 
private mflingvelocity 
private mplaystartmsec 
private mplayendmsec 
private handler mhandler 
private boolean misplaying 
private sampleplayer mplayer 
private boolean mtouchdragging 
private float mtouchstart 
private mtouchinitialoffset 
private mtouchinitialstartpos 
private mtouchinitialendpos 
private long mwaveformtouchstartmsec 
private float mdensity 
private mmarkerleftinset 
private mmarkerrightinset 
private mmarkertopoffset 
private mmarkerbottomoffset 
private thread mloadsoundfilethread 
private thread mrecordaudiothread 
private thread msavesoundfilethread 
result codes 
private static final request_code_choose_contact 
this special intent action that means edit sound file 
public static final string edit ringdroid action edit 
public methods protected overrides 
called when activity first created 
override 
public void oncreate bundle icicle 
ringdroid editactivity oncreate 
super oncreate icicle 
mplayer null 
misplaying false 
malertdialog null 
mprogressdialog null 
mloadsoundfilethread null 
mrecordaudiothread null 
msavesoundfilethread null 
intent intent getintent 
ringdroid media select activity launched 
get_content intent then shouldn display saved 
message when user saves should just return whatever 
they create 
mwasgetcontentintent intent getbooleanextra was_get_content_intent false 
mfilename intent getdata tostring replacefirst file replaceall 
msoundfile null 
mkeydown false 
mhandler handler 
loadgui 
mhandler postdelayed mtimerrunnable 
mfilename equals record 
loadfromfile 
else 
recordaudio 
private void closethread thread thread 
thread null thread isalive 

thread join 
catch interruptedexception 
called when activity finally destroyed 
override 
protected void ondestroy 
ringdroid editactivity ondestroy 
mloadingkeepgoing false 
mrecordingkeepgoing false 
closethread mloadsoundfilethread 
closethread mrecordaudiothread 
closethread msavesoundfilethread 
mloadsoundfilethread null 
mrecordaudiothread null 
msavesoundfilethread null 
mprogressdialog null 
mprogressdialog dismiss 
mprogressdialog null 
malertdialog null 
malertdialog dismiss 
malertdialog null 
mplayer null 
mplayer isplaying mplayer ispaused 
mplayer stop 
mplayer release 
mplayer null 
super ondestroy 
called with activity started with intent returns 
override 
protected void onactivityresult requestcode 
resultcode 
intent dataintent 
ringdroid editactivity onactivityresult 
requestcode request_code_choose_contact 
user finished saving their ringtone they 
just applying contact when they return here 
they done 
finish 
return 
called when orientation changes keyboard shown 
hidden need recreate whole activity this 
case need redo layout somewhat 
override 
public void onconfigurationchanged configuration newconfig 
ringdroid editactivity onconfigurationchanged 
final savezoomlevel mwaveformview getzoomlevel 
super onconfigurationchanged newconfig 
loadgui 
mhandler postdelayed runnable 
public void 
mstartmarker requestfocus 
markerfocus mstartmarker 
mwaveformview setzoomlevel savezoomlevel 
mwaveformview recomputeheights mdensity 
updatedisplay 

override 
public boolean oncreateoptionsmenu menu menu 
menuinflater inflater getmenuinflater 
inflater inflate menu edit_options menu 
return true 
override 
public boolean onprepareoptionsmenu menu menu 
super onprepareoptionsmenu menu 
menu finditem action_save setvisible true 
menu finditem action_reset setvisible true 
menu finditem action_about setvisible true 
return true 
override 
public boolean onoptionsitemselected menuitem item 
switch item getitemid 
case action_save 
onsave 
return true 
case action_reset 
resetpositions 
moffsetgoal 
updatedisplay 
return true 
case action_about 
onabout this 
return true 
default 
return false 
override 
public boolean onkeydown keycode keyevent event 
keycode keyevent keycode_space 
onplay mstartpos 
return true 
return super onkeydown keycode event 
waveformlistener 
every time message that waveform drew need 
animate trigger another redraw 
public void waveformdraw 
mwidth mwaveformview getmeasuredwidth 
moffsetgoal moffset mkeydown 
updatedisplay 
else misplaying 
updatedisplay 
else mflingvelocity 
updatedisplay 
public void waveformtouchstart float 
mtouchdragging true 
mtouchstart 
mtouchinitialoffset moffset 
mflingvelocity 
mwaveformtouchstartmsec getcurrenttime 
public void waveformtouchmove float 
moffset trap mtouchinitialoffset mtouchstart 
updatedisplay 
public void waveformtouchend 
mtouchdragging false 
moffsetgoal moffset 
long elapsedmsec getcurrenttime mwaveformtouchstartmsec 
elapsedmsec 
misplaying 
seekmsec mwaveformview pixelstomillisecs 
mtouchstart moffset 
seekmsec mplaystartmsec 
seekmsec mplayendmsec 
mplayer seekto seekmsec 
else 
handlepause 
else 
onplay mtouchstart moffset 
public void waveformfling float 
mtouchdragging false 
moffsetgoal moffset 
mflingvelocity 
updatedisplay 
public void waveformzoomin 
mwaveformview zoomin 
mstartpos mwaveformview getstart 
mendpos mwaveformview getend 
mmaxpos mwaveformview maxpos 
moffset mwaveformview getoffset 
moffsetgoal moffset 
updatedisplay 
public void waveformzoomout 
mwaveformview zoomout 
mstartpos mwaveformview getstart 
mendpos mwaveformview getend 
mmaxpos mwaveformview maxpos 
moffset mwaveformview getoffset 
moffsetgoal moffset 
updatedisplay 
markerlistener 
public void markerdraw 
public void markertouchstart markerview marker float 
mtouchdragging true 
mtouchstart 
mtouchinitialstartpos mstartpos 
mtouchinitialendpos mendpos 
public void markertouchmove markerview marker float 
float delta mtouchstart 
marker mstartmarker 
mstartpos trap mtouchinitialstartpos delta 
mendpos trap mtouchinitialendpos delta 
else 
mendpos trap mtouchinitialendpos delta 
mendpos mstartpos 
mendpos mstartpos 
updatedisplay 
public void markertouchend markerview marker 
mtouchdragging false 
marker mstartmarker 
setoffsetgoalstart 
else 
setoffsetgoalend 
public void markerleft markerview marker velocity 
mkeydown true 
marker mstartmarker 
savestart mstartpos 
mstartpos trap mstartpos velocity 
mendpos trap mendpos savestart mstartpos 
setoffsetgoalstart 
marker mendmarker 
mendpos mstartpos 
mstartpos trap mstartpos velocity 
mendpos mstartpos 
else 
mendpos trap mendpos velocity 
setoffsetgoalend 
updatedisplay 
public void markerright markerview marker velocity 
mkeydown true 
marker mstartmarker 
savestart mstartpos 
mstartpos velocity 
mstartpos mmaxpos 
mstartpos mmaxpos 
mendpos mstartpos savestart 
mendpos mmaxpos 
mendpos mmaxpos 
setoffsetgoalstart 
marker mendmarker 
mendpos velocity 
mendpos mmaxpos 
mendpos mmaxpos 
setoffsetgoalend 
updatedisplay 
public void markerenter markerview marker 
public void markerkeyup 
mkeydown false 
updatedisplay 
public void markerfocus markerview marker 
mkeydown false 
marker mstartmarker 
setoffsetgoalstartnoupdate 
else 
setoffsetgoalendnoupdate 
delay updaing display because this focus 
response touch event want receive touch 
event before updating display 
mhandler postdelayed runnable 
public void 
updatedisplay 

static about dialog method also called from ringdroidselectactivity 
public static void onabout final activity activity 
string versionname 

packagemanager packagemanager activity getpackagemanager 
string packagename activity getpackagename 
versionname packagemanager getpackageinfo packagename versionname 
catch packagemanager namenotfoundexception 
versionname unknown 
alertdialog builder activity 
settitle string about_title 
setmessage activity getstring string about_text versionname 
setpositivebutton string alert_ok_button null 
setcancelable false 
show 
internal methods 
called from both oncreate onconfigurationchanged 
user switched layouts 
private void loadgui 
inflate from layout description 
setcontentview layout editor 
displaymetrics metrics displaymetrics 
getwindowmanager getdefaultdisplay getmetrics metrics 
mdensity metrics density 
mmarkerleftinset mdensity 
mmarkerrightinset mdensity 
mmarkertopoffset mdensity 
mmarkerbottomoffset mdensity 
mstarttext textview findviewbyid starttext 
mstarttext addtextchangedlistener mtextwatcher 
mendtext textview findviewbyid endtext 
mendtext addtextchangedlistener mtextwatcher 
mplaybutton imagebutton findviewbyid play 
mplaybutton setonclicklistener mplaylistener 
mrewindbutton imagebutton findviewbyid 
mrewindbutton setonclicklistener mrewindlistener 
mffwdbutton imagebutton findviewbyid ffwd 
mffwdbutton setonclicklistener mffwdlistener 
textview markstartbutton textview findviewbyid mark_start 
markstartbutton setonclicklistener mmarkstartlistener 
textview markendbutton textview findviewbyid mark_end 
markendbutton setonclicklistener mmarkendlistener 
enabledisablebuttons 
mwaveformview waveformview findviewbyid waveform 
mwaveformview setlistener this 
minfo textview findviewbyid info 
minfo settext mcaption 
mmaxpos 
mlastdisplayedstartpos 
mlastdisplayedendpos 
msoundfile null mwaveformview hassoundfile 
mwaveformview setsoundfile msoundfile 
mwaveformview recomputeheights mdensity 
mmaxpos mwaveformview maxpos 
mstartmarker markerview findviewbyid startmarker 
mstartmarker setlistener this 
mstartmarker setalpha 
mstartmarker setfocusable true 
mstartmarker setfocusableintouchmode true 
mstartvisible true 
mendmarker markerview findviewbyid endmarker 
mendmarker setlistener this 
mendmarker setalpha 
mendmarker setfocusable true 
mendmarker setfocusableintouchmode true 
mendvisible true 
updatedisplay 
private void loadfromfile 
mfile file mfilename 
songmetadatareader metadatareader songmetadatareader 
this mfilename 
mtitle metadatareader mtitle 
martist metadatareader martist 
string titlelabel mtitle 
martist null martist length 
titlelabel martist 
settitle titlelabel 
mloadinglastupdatetime getcurrenttime 
mloadingkeepgoing true 
mfinishactivity false 
mprogressdialog progressdialog ringdroideditactivity this 
mprogressdialog setprogressstyle progressdialog style_horizontal 
mprogressdialog settitle string progress_dialog_loading 
mprogressdialog setcancelable true 
mprogressdialog setoncancellistener 
dialoginterface oncancellistener 
public void oncancel dialoginterface dialog 
mloadingkeepgoing false 
mfinishactivity true 
mprogressdialog show 
final soundfile progresslistener listener 
soundfile progresslistener 
public boolean reportprogress double fractioncomplete 
long getcurrenttime 
mloadinglastupdatetime 
mprogressdialog setprogress 
mprogressdialog getmax fractioncomplete 
mloadinglastupdatetime 
return mloadingkeepgoing 
load sound file background thread 
mloadsoundfilethread thread 
public void 

msoundfile soundfile create mfile getabsolutepath listener 
msoundfile null 
mprogressdialog dismiss 
string name mfile getname tolowercase 
string components name split 
string 
components length 
getresources getstring 
string no_extension_error 
else 
getresources getstring 
string bad_extension_error 
components components length 
final string finalerr 
runnable runnable runnable 
public void 
showfinalalert exception finalerr 
mhandler post runnable 
return 
mplayer sampleplayer msoundfile 
catch final exception 
mprogressdialog dismiss 
printstacktrace 
minfocontent tostring 
runonuithread runnable 
public void 
minfo settext minfocontent 
runnable runnable runnable 
public void 
showfinalalert getresources gettext string read_error 
mhandler post runnable 
return 
mprogressdialog dismiss 
mloadingkeepgoing 
runnable runnable runnable 
public void 
finishopeningsoundfile 
mhandler post runnable 
else mfinishactivity 
ringdroideditactivity this finish 
mloadsoundfilethread start 
private void recordaudio 
mfile null 
mtitle null 
martist null 
mrecordinglastupdatetime getcurrenttime 
mrecordingkeepgoing true 
mfinishactivity false 
alertdialog builder adbuilder alertdialog builder ringdroideditactivity this 
adbuilder settitle getresources gettext string progress_dialog_recording 
adbuilder setcancelable true 
adbuilder setnegativebutton 
getresources gettext string progress_dialog_cancel 
dialoginterface onclicklistener 
public void onclick dialoginterface dialog 
mrecordingkeepgoing false 
mfinishactivity true 
adbuilder setpositivebutton 
getresources gettext string progress_dialog_stop 
dialoginterface onclicklistener 
public void onclick dialoginterface dialog 
mrecordingkeepgoing false 
todo nfaralli framelayout pass following inflate call 
using null android layout_width work hence text view 
other hand text enough this good enough 
adbuilder setview getlayoutinflater inflate layout record_audio null 
malertdialog adbuilder show 
mtimertextview textview malertdialog findviewbyid record_audio_timer 
final soundfile progresslistener listener 
soundfile progresslistener 
public boolean reportprogress double elapsedtime 
long getcurrenttime 
mrecordinglastupdatetime 
mrecordingtime elapsedtime 
only thread update views such textviews 
runonuithread runnable 
public void 
mrecordingtime 
float float mrecordingtime 
mtimertextview settext string format 
mrecordinglastupdatetime 
return mrecordingkeepgoing 
record audio stream background thread 
mrecordaudiothread thread 
public void 

msoundfile soundfile record listener 
msoundfile null 
malertdialog dismiss 
runnable runnable runnable 
public void 
showfinalalert 
exception 
getresources gettext string record_error 
mhandler post runnable 
return 
mplayer sampleplayer msoundfile 
catch final exception 
malertdialog dismiss 
printstacktrace 
minfocontent tostring 
runonuithread runnable 
public void 
minfo settext minfocontent 
runnable runnable runnable 
public void 
showfinalalert getresources gettext string record_error 
mhandler post runnable 
return 
malertdialog dismiss 
mfinishactivity 
ringdroideditactivity this finish 
else 
runnable runnable runnable 
public void 
finishopeningsoundfile 
mhandler post runnable 
mrecordaudiothread start 
private void finishopeningsoundfile 
mwaveformview setsoundfile msoundfile 
mwaveformview recomputeheights mdensity 
mmaxpos mwaveformview maxpos 
mlastdisplayedstartpos 
mlastdisplayedendpos 
mtouchdragging false 
moffset 
moffsetgoal 
mflingvelocity 
resetpositions 
mendpos mmaxpos 
mendpos mmaxpos 
mcaption 
msoundfile getfiletype 
msoundfile getsamplerate 
msoundfile getavgbitratekbps kbps 
formattime mmaxpos 
getresources getstring string time_seconds 
minfo settext mcaption 
updatedisplay 
private synchronized void updatedisplay 
misplaying 
mplayer getcurrentposition 
frames mwaveformview millisecstopixels 
mwaveformview setplayback frames 
setoffsetgoalnoupdate frames mwidth 
mplayendmsec 
handlepause 
mtouchdragging 
offsetdelta 
mflingvelocity 
offsetdelta mflingvelocity 
mflingvelocity 
mflingvelocity 
else mflingvelocity 
mflingvelocity 
else 
mflingvelocity 
moffset offsetdelta 
moffset mwidth mmaxpos 
moffset mmaxpos mwidth 
mflingvelocity 
moffset 
moffset 
mflingvelocity 
moffsetgoal moffset 
else 
offsetdelta moffsetgoal moffset 
offsetdelta 
offsetdelta offsetdelta 
else offsetdelta 
offsetdelta 
else offsetdelta 
offsetdelta offsetdelta 
else offsetdelta 
offsetdelta 
offsetdelta 
moffset offsetdelta 
mwaveformview setparameters mstartpos mendpos moffset 
mwaveformview invalidate 
mstartmarker setcontentdescription 
getresources gettext string start_marker 
formattime mstartpos 
mendmarker setcontentdescription 
getresources gettext string end_marker 
formattime mendpos 
startx mstartpos moffset mmarkerleftinset 
startx mstartmarker getwidth 
mstartvisible 
delay this avoid flicker 
mhandler postdelayed runnable 
public void 
mstartvisible true 
mstartmarker setalpha 

else 
mstartvisible 
mstartmarker setalpha 
mstartvisible false 
startx 
endx mendpos moffset mendmarker getwidth mmarkerrightinset 
endx mendmarker getwidth 
mendvisible 
delay this avoid flicker 
mhandler postdelayed runnable 
public void 
mendvisible true 
mendmarker setalpha 

else 
mendvisible 
mendmarker setalpha 
mendvisible false 
endx 
relativelayout layoutparams params relativelayout layoutparams 
relativelayout layoutparams wrap_content 
relativelayout layoutparams wrap_content 
params setmargins 
startx 
mmarkertopoffset 
mstartmarker getwidth 
mstartmarker getheight 
mstartmarker setlayoutparams params 
params relativelayout layoutparams 
relativelayout layoutparams wrap_content 
relativelayout layoutparams wrap_content 
params setmargins 
endx 
mwaveformview getmeasuredheight mendmarker getheight mmarkerbottomoffset 
mstartmarker getwidth 
mstartmarker getheight 
mendmarker setlayoutparams params 
private runnable mtimerrunnable runnable 
public void 
updating edittext slow android make sure 
only update text actually changed 
mstartpos mlastdisplayedstartpos 
mstarttext hasfocus 
mstarttext settext formattime mstartpos 
mlastdisplayedstartpos mstartpos 
mendpos mlastdisplayedendpos 
mendtext hasfocus 
mendtext settext formattime mendpos 
mlastdisplayedendpos mendpos 
mhandler postdelayed mtimerrunnable 
private void enabledisablebuttons 
misplaying 
mplaybutton setimageresource android drawable ic_media_pause 
mplaybutton setcontentdescription getresources gettext string stop 
else 
mplaybutton setimageresource android drawable ic_media_play 
mplaybutton setcontentdescription getresources gettext string play 
private void resetpositions 
mstartpos mwaveformview secondstopixels 
mendpos mwaveformview secondstopixels 
private trap 

return 
mmaxpos 
return mmaxpos 
return 
private void setoffsetgoalstart 
setoffsetgoal mstartpos mwidth 
private void setoffsetgoalstartnoupdate 
setoffsetgoalnoupdate mstartpos mwidth 
private void setoffsetgoalend 
setoffsetgoal mendpos mwidth 
private void setoffsetgoalendnoupdate 
setoffsetgoalnoupdate mendpos mwidth 
private void setoffsetgoal offset 
setoffsetgoalnoupdate offset 
updatedisplay 
private void setoffsetgoalnoupdate offset 
mtouchdragging 
return 
moffsetgoal offset 
moffsetgoal mwidth mmaxpos 
moffsetgoal mmaxpos mwidth 
moffsetgoal 
moffsetgoal 
private string formattime pixels 
mwaveformview null mwaveformview isinitialized 
return formatdecimal mwaveformview pixelstoseconds pixels 
else 
return 
private string formatdecimal double 
xwhole 
xfrac xwhole 
xfrac 
xwhole round 
xfrac need remainder after round 
xfrac 
xfrac need fraction that digits long 
xfrac 
return xwhole xfrac 
return xwhole xfrac 
private synchronized void handlepause 
mplayer null mplayer isplaying 
mplayer pause 
mwaveformview setplayback 
misplaying false 
enabledisablebuttons 
private synchronized void onplay startposition 
misplaying 
handlepause 
return 
mplayer null 
initialized 
return 

mplaystartmsec mwaveformview pixelstomillisecs startposition 
startposition mstartpos 
mplayendmsec mwaveformview pixelstomillisecs mstartpos 
else startposition mendpos 
mplayendmsec mwaveformview pixelstomillisecs mmaxpos 
else 
mplayendmsec mwaveformview pixelstomillisecs mendpos 
mplayer setoncompletionlistener sampleplayer oncompletionlistener 
override 
public void oncompletion 
handlepause 
misplaying true 
mplayer seekto mplaystartmsec 
mplayer start 
updatedisplay 
enabledisablebuttons 
catch exception 
showfinalalert string play_error 
return 
show final alert dialog that will exit activity 
after user clicks button exception 
passed assumed error condition 
dialog presented error stack trace 
logged there exception success message 
private void showfinalalert exception charsequence message 
charsequence title 
null 
ringdroid error message 
ringdroid getstacktrace 
title getresources gettext string alert_title_failure 
setresult result_canceled intent 
else 
ringdroid success message 
title getresources gettext string alert_title_success 
alertdialog builder ringdroideditactivity this 
settitle title 
setmessage message 
setpositivebutton 
string alert_ok_button 
dialoginterface onclicklistener 
public void onclick dialoginterface dialog 
whichbutton 
finish 
setcancelable false 
show 
private void showfinalalert exception messageresourceid 
showfinalalert getresources gettext messageresourceid 
private string makeringtonefilename charsequence title string extension 
string subdir 
string externalrootdir environment getexternalstoragedirectory getpath 
externalrootdir endswith 
externalrootdir 
switch mnewfilekind 
default 
case filesavedialog file_kind_music 
todo nfaralli directly environment getexternalstoragepublicdirectory 
environment directory_music getpath instead 
subdir media audio music 
break 
case filesavedialog file_kind_alarm 
subdir media audio alarms 
break 
case filesavedialog file_kind_notification 
subdir media audio notifications 
break 
case filesavedialog file_kind_ringtone 
subdir media audio ringtones 
break 
string parentdir externalrootdir subdir 
create parent directory 
file parentdirfile file parentdir 
parentdirfile mkdirs 
write that special path just writing 
directly sdcard 
parentdirfile isdirectory 
parentdir externalrootdir 
turn title into filename 
string filename 
title length 
character isletterordigit title charat 
filename title charat 
make filename unique 
string path null 

string testpath 

testpath parentdir filename extension 
testpath parentdir filename extension 

randomaccessfile randomaccessfile file testpath 
close 
catch exception 
good file didn exist 
path testpath 
break 
return path 
private void saveringtone final charsequence title 
double starttime mwaveformview pixelstoseconds mstartpos 
double endtime mwaveformview pixelstoseconds mendpos 
final startframe mwaveformview secondstoframes starttime 
final endframe mwaveformview secondstoframes endtime 
final duration endtime starttime 
create indeterminate progress dialog 
mprogressdialog progressdialog this 
mprogressdialog setprogressstyle progressdialog style_spinner 
mprogressdialog settitle string progress_dialog_saving 
mprogressdialog setindeterminate true 
mprogressdialog setcancelable false 
mprogressdialog show 
save sound file background thread 
msavesoundfilethread thread 
public void 
first 
string outpath makeringtonefilename title 
outpath null 
runnable runnable runnable 
public void 
showfinalalert exception string no_unique_filename 
mhandler post runnable 
return 
file outfile file outpath 
boolean fallbacktowav false 

write file 
msoundfile writefile outfile startframe endframe startframe 
catch exception 
error create file instead 
outfile exists 
outfile delete 
stringwriter writer stringwriter 
printstacktrace printwriter writer 
ringdroid error failed create outpath 
ringdroid writer tostring 
fallbacktowav true 
create file creating file failed 
fallbacktowav 
outpath makeringtonefilename title 
outpath null 
runnable runnable runnable 
public void 
showfinalalert exception string no_unique_filename 
mhandler post runnable 
return 
outfile file outpath 

create file 
msoundfile writewavfile outfile startframe endframe startframe 
catch exception 
creating file also failed stop progress dialog show 
error message exit 
mprogressdialog dismiss 
outfile exists 
outfile delete 
minfocontent tostring 
runonuithread runnable 
public void 
minfo settext minfocontent 
charsequence errormessage 
getmessage null 
getmessage equals space left device 
errormessage getresources gettext string no_space_error 
null 
else 
errormessage getresources gettext string write_error 
final charsequence finalerrormessage errormessage 
final exception finalexception 
runnable runnable runnable 
public void 
showfinalalert finalexception finalerrormessage 
mhandler post runnable 
return 
load file make sure worked 

final soundfile progresslistener listener 
soundfile progresslistener 
public boolean reportprogress double frac 
nothing going 
estimate when reloading saved sound 
since usually fast hard 
estimate anyway 
return true keep going 
soundfile create outpath listener 
catch final exception 
mprogressdialog dismiss 
printstacktrace 
minfocontent tostring 
runonuithread runnable 
public void 
minfo settext minfocontent 
runnable runnable runnable 
public void 
showfinalalert getresources gettext string write_error 
mhandler post runnable 
return 
mprogressdialog dismiss 
final string finaloutpath outpath 
runnable runnable runnable 
public void 
aftersavingringtone title 
finaloutpath 
duration 
mhandler post runnable 
msavesoundfilethread start 
private void aftersavingringtone charsequence title 
string outpath 
duration 
file outfile file outpath 
long filesize outfile length 
filesize 
outfile delete 
alertdialog builder this 
settitle string alert_title_failure 
setmessage string too_small_error 
setpositivebutton string alert_ok_button null 
setcancelable false 
show 
return 
create database record pointing existing file path 
string mimetype 
outpath endswith 
mimetype audio latm 
else outpath endswith 
mimetype audio 
else 
this should never happen 
mimetype audio mpeg 
string artist getresources gettext string artist_name 
contentvalues values contentvalues 
values mediastore mediacolumns data outpath 
values mediastore mediacolumns title title tostring 
values mediastore mediacolumns size filesize 
values mediastore mediacolumns mime_type mimetype 
values mediastore audio media artist artist 
values mediastore audio media duration duration 
values mediastore audio media is_ringtone 
mnewfilekind filesavedialog file_kind_ringtone 
values mediastore audio media is_notification 
mnewfilekind filesavedialog file_kind_notification 
values mediastore audio media is_alarm 
mnewfilekind filesavedialog file_kind_alarm 
values mediastore audio media is_music 
mnewfilekind filesavedialog file_kind_music 
insert into database 
mediastore audio media getcontenturiforpath outpath 
final newuri getcontentresolver insert values 
setresult result_ok intent setdata newuri 
ringdroid launched content just return 
mwasgetcontentintent 
finish 
return 
there nothing more with music alarm show 
success message then quit 
mnewfilekind filesavedialog file_kind_music 
mnewfilekind filesavedialog file_kind_alarm 
toast maketext this 
string save_success_message 
toast length_short 
show 
finish 
return 
notification give user option making 
this their default notification they finished 
mnewfilekind filesavedialog file_kind_notification 
alertdialog builder ringdroideditactivity this 
settitle string alert_title_success 
setmessage string set_default_notification 
setpositivebutton string alert_yes_button 
dialoginterface onclicklistener 
public void onclick dialoginterface dialog 
whichbutton 
ringtonemanager setactualdefaultringtoneuri 
ringdroideditactivity this 
ringtonemanager type_notification 
newuri 
finish 
setnegativebutton 
string alert_no_button 
dialoginterface onclicklistener 
public void onclick dialoginterface dialog whichbutton 
finish 
setcancelable false 
show 
return 
here that means type ringtone there 
three choices make this your default ringtone assign 
contact nothing 
final handler handler handler 
public void handlemessage message response 
actionid response 
switch actionid 
case button_make_default 
ringtonemanager setactualdefaultringtoneuri 
ringdroideditactivity this 
ringtonemanager type_ringtone 
newuri 
toast maketext 
ringdroideditactivity this 
string default_ringtone_success_message 
toast length_short 
show 
finish 
break 
case button_choose_contact 
choosecontactforringtone newuri 
break 
default 
case button_do_nothing 
finish 
break 
message message message obtain handler 
aftersaveactiondialog dlog aftersaveactiondialog 
this message 
dlog show 
private void choosecontactforringtone 

intent intent intent intent action_edit 
intent setclassname 
ringdroid 
ringdroid choosecontactactivity 
startactivityforresult intent request_code_choose_contact 
catch exception 
ringdroid couldn open choose contact window 
private void onsave 
misplaying 
handlepause 
final handler handler handler 
public void handlemessage message response 
charsequence newtitle charsequence response 
mnewfilekind response 
saveringtone newtitle 
message message message obtain handler 
filesavedialog dlog filesavedialog 
this getresources mtitle message 
dlog show 
private onclicklistener mplaylistener onclicklistener 
public void onclick view sender 
onplay mstartpos 
private onclicklistener mrewindlistener onclicklistener 
public void onclick view sender 
misplaying 
newpos mplayer getcurrentposition 
newpos mplaystartmsec 
newpos mplaystartmsec 
mplayer seekto newpos 
else 
mstartmarker requestfocus 
markerfocus mstartmarker 
private onclicklistener mffwdlistener onclicklistener 
public void onclick view sender 
misplaying 
newpos mplayer getcurrentposition 
newpos mplayendmsec 
newpos mplayendmsec 
mplayer seekto newpos 
else 
mendmarker requestfocus 
markerfocus mendmarker 
private onclicklistener mmarkstartlistener onclicklistener 
public void onclick view sender 
misplaying 
mstartpos mwaveformview millisecstopixels 
mplayer getcurrentposition 
updatedisplay 
private onclicklistener mmarkendlistener onclicklistener 
public void onclick view sender 
misplaying 
mendpos mwaveformview millisecstopixels 
mplayer getcurrentposition 
updatedisplay 
handlepause 
private textwatcher mtextwatcher textwatcher 
public void beforetextchanged charsequence start 
count after 
public void ontextchanged charsequence 
start before count 
public void aftertextchanged editable 
mstarttext hasfocus 

mstartpos mwaveformview secondstopixels 
double parsedouble 
mstarttext gettext tostring 
updatedisplay 
catch numberformatexception 
mendtext hasfocus 

mendpos mwaveformview secondstopixels 
double parsedouble 
mendtext gettext tostring 
updatedisplay 
catch numberformatexception 
private long getcurrenttime 
return system nanotime 
private string getstacktrace exception 
stringwriter writer stringwriter 
printstacktrace printwriter writer 
return writer tostring 
