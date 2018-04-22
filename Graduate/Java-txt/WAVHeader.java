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
public class wavheader 
private byte mheader complete header 
private msamplerate sampling frequency 
private mchannels number channels 
private mnumsamples total number samples channel 
private mnumbytespersample number bytes sample channels included 
public wavheader samplerate numchannels numsamples 
msamplerate samplerate 
mchannels numchannels 
mnumsamples numsamples 
mnumbytespersample mchannels assuming bytes sample channel 
mheader null 
setheader 
public byte getwavheader 
return mheader 
public static byte getwavheader samplerate numchannels numsamples 
return wavheader samplerate numchannels numsamples mheader 
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
byte header byte 
offset 
size 
riff chunk 
system arraycopy byte header offset 
offset 
size mnumsamples mnumbytespersample 
header offset byte size 
header offset byte size 
header offset byte size 
header offset byte size 
system arraycopy byte header offset 
offset 
chunk 
system arraycopy byte header offset 
offset 
system arraycopy byte header offset chunk size 
offset 
system arraycopy byte header offset format 
offset 
header offset byte mchannels 
header offset byte mchannels 
header offset byte msamplerate 
header offset byte msamplerate 
header offset byte msamplerate 
header offset byte msamplerate 
byterate msamplerate mnumbytespersample 
header offset byte byterate 
header offset byte byterate 
header offset byte byterate 
header offset byte byterate 
header offset byte mnumbytespersample 
header offset byte mnumbytespersample 
system arraycopy byte header offset 
offset 
beginning data chunk 
system arraycopy byte header offset 
offset 
size mnumsamples mnumbytespersample 
header offset byte size 
header offset byte size 
header offset byte size 
header offset byte size 
mheader header 
