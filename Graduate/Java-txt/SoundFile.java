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
package ringdroid soundfile 
import java bufferedwriter 
import java file 
import java filewriter 
import java fileoutputstream 
import java ioexception 
import java printwriter 
import java stringwriter 
import java bytebuffer 
import java byteorder 
import java shortbuffer 
import java util arrays 
import android media audioformat 
import android media audiorecord 
import android media mediacodec 
import android media mediaextractor 
import android media mediaformat 
import android media mediarecorder 
import android build 
import android environment 
import android util 
public class soundfile 
private progresslistener mprogresslistener null 
private file minputfile null 
member variables representing frame data 
private string mfiletype 
private mfilesize 
private mavgbitrate average rate kbps 
private msamplerate 
private mchannels 
private mnumsamples total number samples channel audio file 
private bytebuffer mdecodedbytes audio data 
private shortbuffer mdecodedsamples shared buffer with mdecodedbytes 
mdecodedsamples following format 
sncm 
where sicj sample channel sample signed short 
number channels stereo number samples channel 
member variables hack making work with version until just uses samples 
private mnumframes 
private mframegains 
private mframelens 
private mframeoffsets 
progress listener interface 
public interface progresslistener 
will called soundfile class periodically 
with values between return true continue 
loading file recording audio false cancel stop recording 
boolean reportprogress double fractioncomplete 
custom exception invalid inputs 
public class invalidinputexception extends exception 
serial version generated eclipse 
private static final long serialversionuid 
public invalidinputexception string message 
super message 
todo nfaralli what real list supported extensions device dependent 
public static string getsupportedextensions 
return string 
public static boolean isfilenamesupported string filename 
string extensions getsupportedextensions 
extensions length 
filename endswith extensions 
return true 
return false 
create return soundfile object using file filename 
public static soundfile create string filename 
progresslistener progresslistener 
throws java filenotfoundexception 
java ioexception invalidinputexception 
first check that file exists that extension supported 
file file filename 
exists 
throw java filenotfoundexception filename 
string name getname tolowercase 
string components name split 
components length 
return null 
arrays aslist getsupportedextensions contains components components length 
return null 
soundfile soundfile soundfile 
soundfile setprogresslistener progresslistener 
soundfile readfile 
return soundfile 
create return soundfile object recording mono audio stream 
public static soundfile record progresslistener progresslistener 
progresslistener null 
must have progesslistener stop recording 
return null 
soundfile soundfile soundfile 
soundfile setprogresslistener progresslistener 
soundfile recordaudio 
return soundfile 
public string getfiletype 
return mfiletype 
public getfilesizebytes 
return mfilesize 
public getavgbitratekbps 
return mavgbitrate 
public getsamplerate 
return msamplerate 
public getchannels 
return mchannels 
public getnumsamples 
return mnumsamples number samples channel 
should removed when will directly samples instead frames 
public getnumframes 
return mnumframes 
should removed when will directly samples instead frames 
public getsamplesperframe 
return just fixed value here 
should removed when will directly samples instead frames 
public getframegains 
return mframegains 
public shortbuffer getsamples 
mdecodedsamples null 
build version sdk_int build version_codes 
build version sdk_int build version_codes n_mr 
hack nougat where asreadonlybuffer fails respect byte ordering 
https code google android issues detail 
return mdecodedsamples 
else 
return mdecodedsamples asreadonlybuffer 
else 
return null 
soundfile object should only created using static methods create record 
private soundfile 
private void setprogresslistener progresslistener progresslistener 
mprogresslistener progresslistener 
private void readfile file inputfile 
throws java filenotfoundexception 
java ioexception invalidinputexception 
mediaextractor extractor mediaextractor 
mediaformat format null 

minputfile inputfile 
string components minputfile getpath split 
mfiletype components components length 
mfilesize minputfile length 
extractor setdatasource minputfile getpath 
numtracks extractor gettrackcount 
find select first audio track present file 
numtracks 
format extractor gettrackformat 
format getstring mediaformat key_mime startswith audio 
extractor selecttrack 
break 
numtracks 
throw invalidinputexception audio track found minputfile 
mchannels format getinteger mediaformat key_channel_count 
msamplerate format getinteger mediaformat key_sample_rate 
expected total number samples channel 
expectednumsamples 
format getlong mediaformat key_duration msamplerate 
mediacodec codec mediacodec createdecoderbytype format getstring mediaformat key_mime 
codec configure format null null 
codec start 
decodedsamplessize size output buffer containing decoded samples 
byte decodedsamples null 
bytebuffer inputbuffers codec getinputbuffers 
bytebuffer outputbuffers codec getoutputbuffers 
sample_size 
mediacodec bufferinfo info mediacodec bufferinfo 
long presentation_time 
tot_size_read 
boolean done_reading false 
size decoded samples buffer stereo stream 
longer streams buffer size will increased later calculating rough 
estimate total size needed store samples order resize buffer 
only once 
mdecodedbytes bytebuffer allocate 
boolean firstsampledata true 
while true 
read data from file feed decoder input buffers 
inputbufferindex codec dequeueinputbuffer 
done_reading inputbufferindex 
sample_size extractor readsampledata inputbuffers inputbufferindex 
firstsampledata 
format getstring mediaformat key_mime equals audio latm 
sample_size 
some reasons some devices samsung should 
provide first bytes stream otherwise mediacodec will 
crash these bytes contain music data basic info 
stream channel configuration sampling frequency skipping them 
seems with other devices mediacodec already been configured 
already knows these parameters 
extractor advance 
tot_size_read sample_size 
else sample_size 
samples have been read 
codec queueinputbuffer 
inputbufferindex mediacodec buffer_flag_end_of_stream 
done_reading true 
else 
presentation_time extractor getsampletime 
codec queueinputbuffer inputbufferindex sample_size presentation_time 
extractor advance 
tot_size_read sample_size 
mprogresslistener null 
mprogresslistener reportprogress float tot_size_read mfilesize 
asked stop reading file returning immediately 
soundfile object invalid should used afterward 
extractor release 
extractor null 
codec stop 
codec release 
codec null 
return 
firstsampledata false 
decoded stream from decoder output buffers 
outputbufferindex codec dequeueoutputbuffer info 
outputbufferindex info size 
decodedsamplessize info size 
decodedsamplessize info size 
decodedsamples byte decodedsamplessize 
outputbuffers outputbufferindex decodedsamples info size 
outputbuffers outputbufferindex clear 
check buffer enough resize small 
mdecodedbytes remaining info size 
getting rough estimate total size allocate more 
make sure allocate least more than initial size 
position mdecodedbytes position 
newsize position mfilesize tot_size_read 
newsize position info size 
newsize position info size 
bytebuffer newdecodedbytes null 
allocate memory garbage collector 
retry 
while retry 

newdecodedbytes bytebuffer allocate newsize 
break 
catch outofmemoryerror oome 
setting android largeheap true application seem help 
reaching this section 
retry 
retry 
failed allocate memory stop reading more data finalize 
instance with data decoded 
break 
bytebuffer newdecodedbytes bytebuffer allocate newsize 
mdecodedbytes rewind 
newdecodedbytes mdecodedbytes 
mdecodedbytes newdecodedbytes 
mdecodedbytes position position 
mdecodedbytes decodedsamples info size 
codec releaseoutputbuffer outputbufferindex false 
else outputbufferindex mediacodec info_output_buffers_changed 
outputbuffers codec getoutputbuffers 
else outputbufferindex mediacodec info_output_format_changed 
subsequent data will conform format 
could check that codec getoutputformat which output format 
what expect 
info flags mediacodec buffer_flag_end_of_stream 
mdecodedbytes position mchannels expectednumsamples 
decoded data from decoder stop here 
theoretically dequeueoutputbuffer info should have info flags 
mediacodec buffer_flag_end_of_stream however some phones samsung 
that some files with mono files which case subsequent 
calls dequeueoutputbuffer result application crashing without 
even exception being thrown hence second check 
mono files will actually double each sample stream 
stereo resulting stream half what supposed with much 
lower pitch 
break 
mnumsamples mdecodedbytes position mchannels sample bytes 
mdecodedbytes rewind 
mdecodedbytes order byteorder little_endian 
mdecodedsamples mdecodedbytes asshortbuffer 
mavgbitrate mfilesize float msamplerate mnumsamples 
extractor release 
extractor null 
codec stop 
codec release 
codec null 
temporary hack make work with version 
mnumframes mnumsamples getsamplesperframe 
mnumsamples getsamplesperframe 
mnumframes 
mframegains mnumframes 
mframelens mnumframes 
mframeoffsets mnumframes 

gain value 
framelens mavgbitrate 
float getsamplesperframe msamplerate 
mnumframes 
gain 
getsamplesperframe 
value 
mchannels 
mdecodedsamples remaining 
value java lang math mdecodedsamples 
value mchannels 
gain value 
gain value 
mframegains math sqrt gain here gain sqrt value channel 
mframelens framelens totally accurate 
mframeoffsets mavgbitrate framelens 
float getsamplesperframe msamplerate 
mdecodedsamples rewind 
dumpsamples uncomment this line dump samples file 
private void recordaudio 
mprogresslistener null 
progress listener mandatory here will know when stop recording 
return 
minputfile null 
mfiletype 
mfilesize 
msamplerate 
mchannels record mono audio 
short buffer short buffer contains mono frame bits samples 
minbuffersize audiorecord getminbuffersize 
msamplerate audioformat channel_in_mono audioformat encoding_pcm_ 
make sure minbuffersize contain least second audio bits sample 
minbuffersize msamplerate 
minbuffersize msamplerate 
audiorecord audiorecord audiorecord 
mediarecorder audiosource default 
msamplerate 
audioformat channel_in_mono 
audioformat encoding_pcm_ 
minbuffersize 
allocate memory seconds first reallocate later more needed 
mdecodedbytes bytebuffer allocate msamplerate 
mdecodedbytes order byteorder little_endian 
mdecodedsamples mdecodedbytes asshortbuffer 
audiorecord startrecording 
while true 
check mdecodedsamples contain additional samples 
mdecodedsamples remaining 
allocate memory additional seconds 
newcapacity mdecodedbytes capacity msamplerate 
bytebuffer newdecodedbytes null 

newdecodedbytes bytebuffer allocate newcapacity 
catch outofmemoryerror oome 
break 
position mdecodedsamples position 
mdecodedbytes rewind 
newdecodedbytes mdecodedbytes 
mdecodedbytes newdecodedbytes 
mdecodedbytes order byteorder little_endian 
mdecodedbytes rewind 
mdecodedsamples mdecodedbytes asshortbuffer 
mdecodedsamples position position 
todo nfaralli maybe read method that takes direct bytebuffer argument 
audiorecord read buffer buffer length 
mdecodedsamples buffer 
progress listener know many seconds have been recorded 
returned value tells should keep recording stop 
mprogresslistener reportprogress 
float mdecodedsamples position msamplerate 
break 
audiorecord stop 
audiorecord release 
mnumsamples mdecodedsamples position 
mdecodedsamples rewind 
mdecodedbytes rewind 
mavgbitrate msamplerate 
temporary hack make work with version 
mnumframes mnumsamples getsamplesperframe 
mnumsamples getsamplesperframe 
mnumframes 
mframegains mnumframes 
mframelens null needed recorded audio 
mframeoffsets null needed recorded audio 

gain value 
mnumframes 
gain 
getsamplesperframe 
mdecodedsamples remaining 
value java lang math mdecodedsamples 
else 
value 
gain value 
gain value 
mframegains math sqrt gain here gain sqrt value channel 
mdecodedsamples rewind 
dumpsamples uncomment this line dump samples file 
should removed near future 
public void writefile file outputfile startframe numframes 
throws java ioexception 
float starttime float startframe getsamplesperframe msamplerate 
float endtime float startframe numframes getsamplesperframe msamplerate 
writefile outputfile starttime endtime 
public void writefile file outputfile float starttime float endtime 
throws java ioexception 
startoffset starttime msamplerate mchannels 
numsamples endtime starttime msamplerate 
some devices have problems reading mono files samsung making stereo 
numchannels mchannels mchannels 
string mimetype audio latm 
bitrate numchannels rule thumb good quality kbps channel 
mediacodec codec mediacodec createencoderbytype mimetype 
mediaformat format mediaformat createaudioformat mimetype msamplerate numchannels 
format setinteger mediaformat key_bit_rate bitrate 
codec configure format null null mediacodec configure_flag_encode 
codec start 
estimation encoded data based bitrate 
estimatedencodedsize endtime starttime bitrate 
bytebuffer encodedbytes bytebuffer allocate estimatedencodedsize 
bytebuffer inputbuffers codec getinputbuffers 
bytebuffer outputbuffers codec getoutputbuffers 
mediacodec bufferinfo info mediacodec bufferinfo 
boolean done_reading false 
long presentation_time 
frame_size number samples frame channel stream 
byte buffer byte frame_size numchannels sample coded with short 
mdecodedbytes position startoffset 
numsamples frame_size adding frames priming frames 
tot_num_frames numsamples frame_size first frame bytes 
numsamples frame_size 
tot_num_frames 
frame_sizes tot_num_frames 
num_out_frames 
num_frames 
num_samples_left numsamples 
encodedsamplessize size output buffer containing encoded samples 
byte encodedsamples null 
while true 
feed samples encoder 
inputbufferindex codec dequeueinputbuffer 
done_reading inputbufferindex 
num_samples_left 
samples have been read 
codec queueinputbuffer 
inputbufferindex mediacodec buffer_flag_end_of_stream 
done_reading true 
else 
inputbuffers inputbufferindex clear 
buffer length inputbuffers inputbufferindex remaining 
input buffer smaller than frame this should never happen 
continue 
buffersize hack create stereo file from mono stream 
buffersize mchannels buffer length buffer length 
mdecodedbytes remaining buffersize 
mdecodedbytes remaining buffersize 
buffer with extra make full frame 
mdecodedbytes buffer mdecodedbytes remaining 
else 
mdecodedbytes buffer buffersize 
mchannels 
buffersize 
buffer buffer 
buffer buffer 
buffer buffer 
buffer buffer 
num_samples_left frame_size 
inputbuffers inputbufferindex buffer 
presentation_time long num_frames frame_size msamplerate 
codec queueinputbuffer 
inputbufferindex buffer length presentation_time 
encoded samples from encoder 
outputbufferindex codec dequeueoutputbuffer info 
outputbufferindex info size info presentationtimeus 
num_out_frames frame_sizes length 
frame_sizes num_out_frames info size 
encodedsamplessize info size 
encodedsamplessize info size 
encodedsamples byte encodedsamplessize 
outputbuffers outputbufferindex encodedsamples info size 
outputbuffers outputbufferindex clear 
codec releaseoutputbuffer outputbufferindex false 
encodedbytes remaining info size hopefully this should happen 
estimatedencodedsize estimatedencodedsize 
bytebuffer newencodedbytes bytebuffer allocate estimatedencodedsize 
position encodedbytes position 
encodedbytes rewind 
newencodedbytes encodedbytes 
encodedbytes newencodedbytes 
encodedbytes position position 
encodedbytes encodedsamples info size 
else outputbufferindex mediacodec info_output_buffers_changed 
outputbuffers codec getoutputbuffers 
else outputbufferindex mediacodec info_output_format_changed 
subsequent data will conform format 
could check that codec getoutputformat which output format 
what expect 
info flags mediacodec buffer_flag_end_of_stream 
encoded data from encoder 
break 
encoded_size encodedbytes position 
encodedbytes rewind 
codec stop 
codec release 
codec null 
write encoded stream file time 
buffer byte 

fileoutputstream outputstream fileoutputstream outputfile 
outputstream write 
header getmp header msamplerate numchannels frame_sizes bitrate 
while encoded_size encodedbytes position buffer length 
encodedbytes buffer 
outputstream write buffer 
remaining encoded_size encodedbytes position 
remaining 
encodedbytes buffer remaining 
outputstream write buffer remaining 
outputstream close 
catch ioexception 
ringdroid failed create file 
ringdroid getstacktrace 
method used swap left right channels needed stereo files 
buffer contains data sample right sample left sample right 
size sample assumed bits single channel 
when done buffer will contain sample left sample right sample left 
private void swapleftrightchannels byte buffer 
byte left byte 
byte right byte 
buffer length channels bytes sample channel 
invalid buffer size 
return 
offset offset buffer length offset 
left buffer offset 
left buffer offset 
right buffer offset 
right buffer offset 
buffer offset right 
buffer offset right 
buffer offset left 
buffer offset left 
should removed near future 
public void writewavfile file outputfile startframe numframes 
throws java ioexception 
float starttime float startframe getsamplesperframe msamplerate 
float endtime float startframe numframes getsamplesperframe msamplerate 
writewavfile outputfile starttime endtime 
public void writewavfile file outputfile float starttime float endtime 
throws java ioexception 
startoffset starttime msamplerate mchannels 
numsamples endtime starttime msamplerate 
start writing riff header 
fileoutputstream outputstream fileoutputstream outputfile 
outputstream write wavheader getwavheader msamplerate mchannels numsamples 
write samples file time 
byte buffer byte mchannels each sample coded with short 
mdecodedbytes position startoffset 
numbytesleft numsamples mchannels 
while numbytesleft buffer length 
mdecodedbytes remaining buffer length 
this should happen 
mdecodedbytes remaining buffer length 
buffer with extra make full frame 
mdecodedbytes buffer mdecodedbytes remaining 
else 
mdecodedbytes buffer 
mchannels 
swapleftrightchannels buffer 
outputstream write buffer 
numbytesleft buffer length 
numbytesleft 
mdecodedbytes remaining numbytesleft 
this should happen 
mdecodedbytes remaining numbytesleft 
buffer with extra make full frame 
mdecodedbytes buffer mdecodedbytes remaining 
else 
mdecodedbytes buffer numbytesleft 
mchannels 
swapleftrightchannels buffer 
outputstream write buffer numbytesleft 
outputstream close 
debugging method dumping samples mdecodedsamples file 
each describes sample following format 
presentation time seconds channel channel 
file will written sdcard under media audio debug 
filename null empty then default file name samples used 
private void dumpsamples string filename 
string externalrootdir environment getexternalstoragedirectory getpath 
externalrootdir endswith 
externalrootdir 
string parentdir externalrootdir media audio debug 
create parent directory 
file parentdirfile file parentdir 
parentdirfile mkdirs 
write that special path just writing directly sdcard 
parentdirfile isdirectory 
parentdir externalrootdir 
filename null filename isempty 
filename samples 
file outfile file parentdir filename 
start dumping samples 
bufferedwriter writer null 
float presentationtime 
mdecodedsamples rewind 
string 

writer bufferedwriter filewriter outfile 
sampleindex sampleindex mnumsamples sampleindex 
presentationtime float sampleindex msamplerate 
float tostring presentationtime 
channelindex channelindex mchannels channelindex 
mdecodedsamples 

writer write 
catch ioexception 
ringdroid failed create sample file 
ringdroid getstacktrace 
done here close file rewind buffer 

writer close 
catch exception 
ringdroid failed close sample file 
ringdroid getstacktrace 
mdecodedsamples rewind 
helper method samples will dumped media audio debug samples 
private void dumpsamples 
dumpsamples null 
return stack trace given exception 
private string getstacktrace exception 
stringwriter writer stringwriter 
printstacktrace printwriter writer 
return writer tostring 
