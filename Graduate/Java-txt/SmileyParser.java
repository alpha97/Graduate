copyright artem chepurnoy 
copyright cyanogenmod project 
copyright android open source project 
licensed under apache license version license 
this file except compliance with license 
obtain copy license 
http apache licenses license 
unless required applicable agreed writing software 
distributed under license distributed basis 
without warranties conditions kind either express implied 
license specific language governing permissions 
limitations under license 
package achep base utils smiley 
import android application 
import android content context 
import android support annotation nonnull 
import android support annotation nullable 
import android text spannable 
import android text spannablestringbuilder 
import android text style imagespan 
import achep acdisplay 
import achep base tests check 
import java util hashmap 
import java util regex matcher 
import java util regex pattern 
class annotating charsequence with spans convert textual emoticons 
graphical ones 
public class smileyparser 
private static smileyparser sinstance 
nonnull 
public static smileyparser getinstance 
check getinstance isnonnull sinstance 
return sinstance 
initializes whole smileys parses thing saves into 
static reference this method should called from 
link application oncreate 
public static void init nonnull context context 
sinstance smileyparser context getapplicationcontext 
private final context mcontext 
private final string msmileytexts 
private final pattern mpattern 
private final hashmap string integer msmileytores 
private smileyparser nonnull context context 
mcontext context 
msmileytexts mcontext getresources getstringarray default_smiley_texts 
msmileytores buildsmileytores 
mpattern buildpattern 
static class smileys 
private static final siconids 
drawable emo_im_happy 
drawable emo_im_sad 
drawable emo_im_winking 
drawable emo_im_tongue_sticking_out 
drawable emo_im_surprised 
drawable emo_im_kissing 
drawable emo_im_yelling 
drawable emo_im_cool 
drawable emo_im_money_mouth 
drawable emo_im_foot_in_mouth 
drawable emo_im_embarrassed 
drawable emo_im_angel 
drawable emo_im_undecided 
drawable emo_im_crying 
drawable emo_im_lips_are_sealed 
drawable emo_im_laughing 
drawable emo_im_wtf 
drawable emo_im_heart 
drawable emo_im_mad 
drawable emo_im_smirk 
drawable emo_im_pokerface 
public static final happy 
public static final 
public static final winking 
public static final tongue_sticking_out 
public static final surprised 
public static final kissing 
public static final yelling 
public static final cool 
public static final money_mouth 
public static final foot_in_mouth 
public static final embarrassed 
public static final angel 
public static final undecided 
public static final crying 
public static final lips_are_sealed 
public static final laughing 
public static final 
public static final 
public static final heart 
public static final smirk 
public static final pokerface 
public static getsmileyresource which 
return siconids which 
note change anything about this array must make 
corresponding change string arrays default_smiley_texts 
default_smiley_names values cm_arrays 
public static final default_smiley_res_ids 
smileys getsmileyresource smileys happy 
smileys getsmileyresource smileys 
smileys getsmileyresource smileys winking 
smileys getsmileyresource smileys tongue_sticking_out 
smileys getsmileyresource smileys surprised 
smileys getsmileyresource smileys kissing 
smileys getsmileyresource smileys yelling 
smileys getsmileyresource smileys cool 
smileys getsmileyresource smileys money_mouth 
smileys getsmileyresource smileys foot_in_mouth 
smileys getsmileyresource smileys embarrassed 
smileys getsmileyresource smileys angel 
smileys getsmileyresource smileys undecided 
smileys getsmileyresource smileys crying 
smileys getsmileyresource smileys lips_are_sealed 
smileys getsmileyresource smileys laughing 
smileys getsmileyresource smileys 
smileys getsmileyresource smileys 
smileys getsmileyresource smileys heart 
smileys getsmileyresource smileys smirk 
smileys getsmileyresource smileys pokerface 
public static final default_smiley_texts array default_smiley_texts 
builds hashtable mapping string version 
smiley resource icon version 
nonnull 
private hashmap string integer buildsmileytores 
default_smiley_res_ids length msmileytexts length 
throw exception someone updated default_smiley_res_ids 
failed update arrays 
throw illegalstateexception smiley resource text mismatch 
hashmap string integer smileytores hashmap msmileytexts length 
msmileytexts length 
smileytores msmileytexts default_smiley_res_ids 
return smileytores 
builds regular expression find smileys link addsmileyspans 
nonnull 
private pattern buildpattern 
stringbuilder capacity with assumption that average 
smiley characters long 
stringbuilder patternstring stringbuilder msmileytexts length 
build regex that looks like escaping smilies 
properly they will interpreted literally regex matcher 
patternstring append 
string msmileytexts 
patternstring append pattern quote 
patternstring append 
replace extra with 
patternstring replace patternstring length patternstring length 
return pattern compile patternstring tostring 
adds imagespans charsequence that replace textual emoticons such 
with graphical version 
param text charsequence possibly containing emoticons 
return charsequence annotated with imagespans covering 
recognized emoticons 
public charsequence addsmileyspans nullable charsequence text 
text null return null 
spannablestringbuilder builder spannablestringbuilder text 
matcher matcher mpattern matcher text 
while matcher find 
resid msmileytores matcher group 
start matcher start 
matcher 
check getinstance istrue start 
builder setspan imagespan mcontext resid start 
spannable span_exclusive_exclusive 
return builder 
