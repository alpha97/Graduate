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
import java shortbuffer 
import android media audioformat 
import android media audiomanager 
import android media audiotrack 
import ringdroid soundfile soundfile 
class sampleplayer 
public interface oncompletionlistener 
public void oncompletion 
private shortbuffer msamples 
private msamplerate 
private mchannels 
private mnumsamples number samples channel 
private audiotrack maudiotrack 
private short mbuffer 
private mplaybackstart start offset samples 
private thread mplaythread 
private boolean mkeepplaying 
private oncompletionlistener mlistener 
public sampleplayer shortbuffer samples samplerate channels numsamples 
msamples samples 
msamplerate samplerate 
mchannels channels 
mnumsamples numsamples 
mplaybackstart 
buffersize audiotrack getminbuffersize 
msamplerate 
mchannels audioformat channel_out_mono audioformat channel_out_stereo 
audioformat encoding_pcm_ 
make sure minbuffersize contain least second audio bits sample 
buffersize mchannels msamplerate 
buffersize mchannels msamplerate 
mbuffer short buffersize buffersize bytes 
maudiotrack audiotrack 
audiomanager stream_music 
msamplerate 
mchannels audioformat channel_out_mono audioformat channel_out_stereo 
audioformat encoding_pcm_ 
mbuffer length 
audiotrack mode_stream 
check when player played given data notify user mlistener 
maudiotrack setnotificationmarkerposition mnumsamples marker 
maudiotrack setplaybackpositionupdatelistener 
audiotrack onplaybackpositionupdatelistener 
override 
public void onperiodicnotification audiotrack track 
override 
public void onmarkerreached audiotrack track 
stop 
mlistener null 
mlistener oncompletion 
mplaythread null 
mkeepplaying true 
mlistener null 
public sampleplayer soundfile 
this getsamples getsamplerate getchannels getnumsamples 
public void setoncompletionlistener oncompletionlistener listener 
mlistener listener 
public boolean isplaying 
return maudiotrack getplaystate audiotrack playstate_playing 
public boolean ispaused 
return maudiotrack getplaystate audiotrack playstate_paused 
public void start 
isplaying 
return 
mkeepplaying true 
maudiotrack flush 
maudiotrack play 
setting thread feeding audio samples audio hardware 
assumes mchannels 
mplaythread thread 
public void 
position mplaybackstart mchannels 
msamples position position 
limit mnumsamples mchannels 
while msamples position limit mkeepplaying 
numsamplesleft limit msamples position 
numsamplesleft mbuffer length 
msamples mbuffer 
else 
numsamplesleft mbuffer length 
mbuffer 
msamples mbuffer numsamplesleft 
todo nfaralli write method that takes bytebuffer argument 
maudiotrack write mbuffer mbuffer length 
mplaythread start 
public void pause 
isplaying 
maudiotrack pause 
maudiotrack write should block cannot write 
public void stop 
isplaying ispaused 
mkeepplaying false 
maudiotrack pause pause stops playback immediately 
maudiotrack stop unblock maudiotrack write avoid deadlocks 
mplaythread null 

mplaythread join 
catch interruptedexception 
mplaythread null 
maudiotrack flush just case 
public void release 
stop 
maudiotrack release 
public void seekto msec 
boolean wasplaying isplaying 
stop 
mplaybackstart msec msamplerate 
mplaybackstart mnumsamples 
mplaybackstart mnumsamples nothing play 
maudiotrack setnotificationmarkerposition mnumsamples mplaybackstart 
wasplaying 
start 
public getcurrentposition 
return mplaybackstart maudiotrack getplaybackheadposition 
msamplerate 
