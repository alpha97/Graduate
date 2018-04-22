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
class atom note latest versions spec simply call instead atom 
private msize includes atom header bytes 
private mtype 
private byte mdata atom either contain data children both 
private atom mchildren 
private byte mversion negative then atom does contain version flags data 
private mflags 
create empty atom given type 
public atom string type 
msize 
mtype gettypeint type 
mdata null 
mchildren null 
mversion 
mflags 
create empty atom type type with given version flags 
public atom string type byte version flags 
msize 
mtype gettypeint type 
mdata null 
mchildren null 
mversion version 
mflags flags 
size field atom based content 
private void setsize 
size type size 
mversion 
size version flags 
mdata null 
size mdata length 
else mchildren null 
atom child mchildren 
size child getsize 
msize size 
size this atom 
public getsize 
return msize 
private gettypeint string type_str 
type 
type byte type_str charat 
type byte type_str charat 
type byte type_str charat 
type byte type_str charat 
return type 
public gettypeint 
return mtype 
public string gettypestr 
string type 
type char byte mtype 
type char byte mtype 
type char byte mtype 
type char byte mtype 
return type 
public boolean setdata byte data 
mchildren null data null 
todo nfaralli something here 
return false 
mdata data 
setsize 
return true 
public byte getdata 
return mdata 
public boolean addchild atom child 
mdata null child null 
todo nfaralli something here 
return false 
numchildren 
mchildren null 
numchildren mchildren length 
atom children atom numchildren 
mchildren null 
system arraycopy mchildren children mchildren length 
children numchildren child 
mchildren children 
setsize 
return true 
return child atom corresponding type 
type contain grand children type trak mdia minf 
return null atom does contain such child 
public atom getchild string type 
mchildren null 
return null 
string types type split 
atom child mchildren 
child gettypestr equals types 
types length 
return child 
else 
return child getchild types 
return null 
return byte array containing full content atom including header 
public byte getbytes 
byte atom_bytes byte msize 
offset 
atom_bytes offset byte msize 
atom_bytes offset byte msize 
atom_bytes offset byte msize 
atom_bytes offset byte msize 
atom_bytes offset byte mtype 
atom_bytes offset byte mtype 
atom_bytes offset byte mtype 
atom_bytes offset byte mtype 
mversion 
atom_bytes offset mversion 
atom_bytes offset byte mflags 
atom_bytes offset byte mflags 
atom_bytes offset byte mflags 
mdata null 
system arraycopy mdata atom_bytes offset mdata length 
else mchildren null 
byte child_bytes 
atom child mchildren 
child_bytes child getbytes 
system arraycopy child_bytes atom_bytes offset child_bytes length 
offset child_bytes length 
return atom_bytes 
used debugging purpose only 
public string tostring 
string 
byte atom_bytes getbytes 
atom_bytes length 


string format atom_bytes 
atom_bytes length 




return 
public class header 
private mframesize size each frames bytes first should 
private mmaxframesize size biggest frame 
private mtotsize size stream 
private mbitrate bitrate used encode stream 
private byte mtime time used creation time modification time fields 
private byte mdurationms duration stream milliseconds 
private byte mnumsamples number samples stream 
private byte mheader complete header 
private msamplerate sampling frequency 
private mchannels number channels 
creates header object that should used generate file header 
public header samplerate numchannels frame_size bitrate 
frame_size null frame_size length frame_size 
todo nfaralli something here 
return 
msamplerate samplerate 
mchannels numchannels 
mframesize frame_size 
mbitrate bitrate 
mmaxframesize mframesize 
mtotsize mframesize 
mframesize length 
mmaxframesize mframesize 
mmaxframesize mframesize 
mtotsize mframesize 
long time system currenttimemillis 
time number seconds between 
mtime byte 
mtime byte time 
mtime byte time 
mtime byte time 
mtime byte time 
numsamples frame_size length frame does contain samples 
durationms numsamples msamplerate 
numsamples msamplerate round duration 
durationms 
mnumsamples byte 
byte numsamples 
byte numsamples 
byte numsamples 
byte numsamples 
mdurationms byte 
byte durationms 
byte durationms 
byte durationms 
byte durationms 
setheader 
public byte getmp header 
return mheader 
public static byte getmp header 
samplerate numchannels frame_size bitrate 
return header samplerate numchannels frame_size bitrate mheader 
public string tostring 
string 
mheader null 
return 
num_ bits_per_lines 
count 
byte mheader 
boolean break_line count count num_ bits_per_lines 
boolean insert_space count count break_line 
break_line 

insert_space 

string format 
count 
return 
private void setheader 
create atoms needed build header 
atom a_ftyp getftypatom 
atom a_moov getmoovatom 
atom a_mdat atom mdat create empty atom stream data should follow 
immediately after correct size will later 
correct chunk offset stco atom 
atom a_stco a_moov getchild trak mdia minf stbl stco 
a_stco null 
mheader null 
return 
byte data a_stco getdata 
chunk_offset a_ftyp getsize a_moov getsize a_mdat getsize 
offset data length here stco should contain only chunk offset 
data offset byte chunk_offset 
data offset byte chunk_offset 
data offset byte chunk_offset 
data offset byte chunk_offset 
create header byte array based previous atoms 
byte header byte chunk_offset here chunk_offset also size header 
offset 
atom atom atom a_ftyp a_moov a_mdat 
byte atom_bytes atom getbytes 
system arraycopy atom_bytes header offset atom_bytes length 
offset atom_bytes length 
correct size mdat atom 
size mtotsize 
offset 
header offset byte size 
header offset byte size 
header offset byte size 
header offset byte size 
mheader header 
private atom getftypatom 
atom atom atom ftyp 
atom setdata byte 
major brand 
minor version 
compatible brands 


return atom 
private atom getmoovatom 
atom atom atom moov 
atom addchild getmvhdatom 
atom addchild gettrakatom 
return atom 
private atom getmvhdatom 
atom atom atom mvhd byte 
atom setdata byte 
mtime mtime mtime mtime creation time 
mtime mtime mtime mtime modification time 
byte timescale duration expressed 
mdurationms mdurationms mdurationms mdurationms duration 
rate 
volume 
reserved 
reserved 
reserved 
unity matrix 


defined 
defined 
defined 
defined 
defined 
defined 
next track 
return atom 
private atom gettrakatom 
atom atom atom trak 
atom addchild gettkhdatom 
atom addchild getmdiaatom 
return atom 
private atom gettkhdatom 
atom atom atom tkhd byte track enabled movie preview 
atom setdata byte 
mtime mtime mtime mtime creation time 
mtime mtime mtime mtime modification time 
track 
reserved 
mdurationms mdurationms mdurationms mdurationms duration 
reserved 
reserved 
layer 
alternate group 
volume 
reserved 
unity matrix 


width 
height 
return atom 
private atom getmdiaatom 
atom atom atom mdia 
atom addchild getmdhdatom 
atom addchild gethdlratom 
atom addchild getminfatom 
return atom 
private atom getmdhdatom 
atom atom atom mdhd byte 
atom setdata byte 
mtime mtime mtime mtime creation time 
mtime mtime mtime mtime modification time 
byte msamplerate byte msamplerate timescale 
byte msamplerate byte msamplerate duration expressed samples 
mnumsamples mnumsamples mnumsamples mnumsamples duration 
languages 
defined 
return atom 
private atom gethdlratom 
atom atom atom hdlr byte 
atom setdata byte 
defined 
handler type 
reserved 
reserved 
reserved 
name used only debugging inspection purposes 


return atom 
private atom getminfatom 
atom atom atom minf 
atom addchild getsmhdatom 
atom addchild getdinfatom 
atom addchild getstblatom 
return atom 
private atom getsmhdatom 
atom atom atom smhd byte 
atom setdata byte 
balance center 
reserved 
return atom 
private atom getdinfatom 
atom atom atom dinf 
atom addchild getdrefatom 
return atom 
private atom getdrefatom 
atom atom atom dref byte 
byte geturlatom getbytes 
byte data byte length 
data entry count 
system arraycopy data length 
atom setdata data 
return atom 
private atom geturlatom 
atom atom atom byte flags data self contained 
return atom 
private atom getstblatom 
atom atom atom stbl 
atom addchild getstsdatom 
atom addchild getsttsatom 
atom addchild getstscatom 
atom addchild getstszatom 
atom addchild getstcoatom 
return atom 
private atom getstsdatom 
atom atom atom stsd byte 
byte getmp aatom getbytes 
byte data byte length 
data entry count 
system arraycopy data length 
atom setdata data 
return atom 
also part section this atom 
private atom getmp aatom 
atom atom atom 
byte byte audio sample entry data 
reserved 
data reference index 
reserved 
reserved 
byte mchannels byte mchannels channel count 
sample size 
defined 
reserved 
byte msamplerate byte msamplerate sample rate 
byte esds getesdsatom getbytes 
byte data byte length esds length 
system arraycopy data length 
system arraycopy esds data length esds length 
atom setdata data 
return atom 
private atom getesdsatom 
atom atom atom esds byte 
atom setdata getesdescriptor 
return atom 
returns descriptor audio stream channels 
samples frame channel decoder buffer size that contain 
least frames section more details 
private byte getesdescriptor 
samplingfrequencies 

first bytes descriptor 
byte esdescriptor_top byte 
first bytes decoder configuration descriptor audio audiostream 
byte decconfigdescr_top byte 
audio specific configuration samples frame channel 
sampling frequency channels configuration 
byte audiospecificconfig byte 
byte slconfigdescr byte specific file 
offset 
buffersize 
while buffersize mmaxframesize 
todo nfaralli what should minimum size decoder buffer 
should multiple 
buffersize 
create decoder configuration descriptor 
byte decconfigdescr byte decconfigdescr_top 
system arraycopy decconfigdescr_top decconfigdescr decconfigdescr_top length 
offset decconfigdescr_top length 
decconfigdescr offset byte buffersize 
decconfigdescr offset byte buffersize 
decconfigdescr offset byte buffersize 
decconfigdescr offset byte mbitrate 
decconfigdescr offset byte mbitrate 
decconfigdescr offset byte mbitrate 
decconfigdescr offset byte mbitrate 
decconfigdescr offset byte mbitrate 
decconfigdescr offset byte mbitrate 
decconfigdescr offset byte mbitrate 
decconfigdescr offset byte mbitrate 
index 
index index samplingfrequencies length index 
samplingfrequencies index msamplerate 
break 
index samplingfrequencies length 
todo nfaralli something here 
invalid sampling frequency default 
index 
audiospecificconfig byte index 
audiospecificconfig byte index mchannels 
system arraycopy 
audiospecificconfig decconfigdescr offset audiospecificconfig length 
create descriptor 
byte esdescriptor byte esdescriptor_top 
system arraycopy esdescriptor_top esdescriptor esdescriptor_top length 
offset esdescriptor_top length 
system arraycopy decconfigdescr esdescriptor offset decconfigdescr length 
offset decconfigdescr length 
system arraycopy slconfigdescr esdescriptor offset slconfigdescr length 
return esdescriptor 
private atom getsttsatom 
atom atom atom stts byte 
numaudioframes mframesize length 
atom setdata byte 
entry count 
first frame contains audio 

byte numaudioframes byte numaudioframes 
byte numaudioframes byte numaudioframes 
delay between frames samples timescale 
return atom 
private atom getstscatom 
atom atom atom stsc byte 
numframes mframesize length 
atom setdata byte 
entry count 
first chunk 
byte numframes byte numframes samples 
byte numframes byte numframes chunk 
sample description index 
return atom 
private atom getstszatom 
atom atom atom stsz byte 
numframes mframesize length 
byte data byte numframes 
offset 
data offset sample size each frame have different size 
data offset 
data offset 
data offset 
data offset byte numframes sample count 
data offset byte numframes 
data offset byte numframes 
data offset byte numframes 
size mframesize 
data offset byte size 
data offset byte size 
data offset byte size 
data offset byte size 
atom setdata data 
return atom 
private atom getstcoatom 
atom atom atom stco byte 
atom setdata byte 
entry count 
chunk offset here must later here should 
size complete header stream will follow 
immediately 
return atom 
