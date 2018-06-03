package enrique stackblur 
import android graphics bitmap 
import java util arraylist 
import java util concurrent callable 
blur using java code 

this compromise between gaussian blur blur 
creates much better looking blurs than blur 
faster than gaussian blur implementation 

called stack blur because this describes best this 
filter works internally creates kind moving stack 
colors whilst scanning through image thereby 
just block color right side 
stack remove leftmost color remaining 
colors topmost layer stack either added 
reduced depending they right 
left side stack 
author enrique eenriquelopez gmail 
http tech 

author original algorithm mario klingemann mario quasimondo 

based heavily http vitiy info code stackblur 
http vitiy info stackblur algorithm multi threaded blur 
copyright enrique 
license apache license 
class javablurprocess implements blurprocess 
private static final short stackblur_mul 
















private static final byte stackblur_shr 
















override 
public bitmap blur bitmap original float radius 
original getwidth 
original getheight 
currentpixels 
original getpixels currentpixels 
cores stackblurmanager executor_threads 
arraylist blurtask horizontal arraylist blurtask cores 
arraylist blurtask vertical arraylist blurtask cores 
cores 
horizontal blurtask currentpixels radius cores 
vertical blurtask currentpixels radius cores 

stackblurmanager executor invokeall horizontal 
catch interruptedexception 
return null 

stackblurmanager executor invokeall vertical 
catch interruptedexception 
return null 
return bitmap createbitmap currentpixels bitmap config argb_ 
private static void bluriteration radius cores core step 


stack_start 
stack_i 
src_i 
dst_i 
long sum_r sum_g sum_b 
sum_in_r sum_in_g sum_in_b 
sum_out_r sum_out_g sum_out_b 


radius 
mul_sum stackblur_mul radius 
byte shr_sum stackblur_shr radius 
stack 
step 
miny core cores 
maxy core cores 
miny maxy 
sum_r sum_g sum_b 
sum_in_r sum_in_g sum_in_b 
sum_out_r sum_out_g sum_out_b 
src_i start line 
radius 
stack_i 
stack stack_i src_i 
sum_r src_i 
sum_g src_i 
sum_b src_i 
sum_out_r src_i 
sum_out_g src_i 
sum_out_b src_i 
radius 
src_i 
stack_i radius 
stack stack_i src_i 
sum_r src_i radius 
sum_g src_i radius 
sum_b src_i radius 
sum_in_r src_i 
sum_in_g src_i 
sum_in_b src_i 
radius 
radius 

src_i pix_ptr 
dst_i pix_ptr 

dst_i 
dst_i 
sum_r mul_sum shr_sum 
sum_g mul_sum shr_sum 
sum_b mul_sum shr_sum 
dst_i 
sum_r sum_out_r 
sum_g sum_out_g 
sum_b sum_out_b 
stack_start radius 
stack_start stack_start 
stack_i stack_start 
sum_out_r stack stack_i 
sum_out_g stack stack_i 
sum_out_b stack stack_i 

src_i 

stack stack_i src_i 
sum_in_r src_i 
sum_in_g src_i 
sum_in_b src_i 
sum_r sum_in_r 
sum_g sum_in_g 
sum_b sum_in_b 


stack_i 
sum_out_r stack stack_i 
sum_out_g stack stack_i 
sum_out_b stack stack_i 
sum_in_r stack stack_i 
sum_in_g stack stack_i 
sum_in_b stack stack_i 
step 
else step 
minx core cores 
maxx core cores 
minx maxx 
sum_r sum_g sum_b 
sum_in_r sum_in_g sum_in_b 
sum_out_r sum_out_g sum_out_b 
src_i 
radius 
stack_i 
stack stack_i src_i 
sum_r src_i 
sum_g src_i 
sum_b src_i 
sum_out_r src_i 
sum_out_g src_i 
sum_out_b src_i 
radius 
src_i stride 
stack_i radius 
stack stack_i src_i 
sum_r src_i radius 
sum_g src_i radius 
sum_b src_i radius 
sum_in_r src_i 
sum_in_g src_i 
sum_in_b src_i 
radius 
radius 

src_i pix_ptr 
dst_i pix_ptr 

dst_i 
dst_i 
sum_r mul_sum shr_sum 
sum_g mul_sum shr_sum 
sum_b mul_sum shr_sum 
dst_i 
sum_r sum_out_r 
sum_g sum_out_g 
sum_b sum_out_b 
stack_start radius 
stack_start stack_start 
stack_i stack_start 
sum_out_r stack stack_i 
sum_out_g stack stack_i 
sum_out_b stack stack_i 

src_i stride 

stack stack_i src_i 
sum_in_r src_i 
sum_in_g src_i 
sum_in_b src_i 
sum_r sum_in_r 
sum_g sum_in_g 
sum_b sum_in_b 


stack_i 
sum_out_r stack stack_i 
sum_out_g stack stack_i 
sum_out_b stack stack_i 
sum_in_r stack stack_i 
sum_in_g stack stack_i 
sum_in_b stack stack_i 
private static class blurtask implements callable void 
private final _src 
private final 
private final 
private final _radius 
private final _totalcores 
private final _coreindex 
private final _round 
public blurtask radius totalcores coreindex round 
_src 


_radius radius 
_totalcores totalcores 
_coreindex coreindex 
_round round 
override 
public void call throws exception 
bluriteration _src _radius _totalcores _coreindex _round 
return null 
