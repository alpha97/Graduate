stackblur android 
author enrique eenriquelopez gmail 
http lopez manas 

author original algorithm mario klingemann mario quasimondo 

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
copyright enrique 
license apache license 
package enrique stackblur 
import android content context 
import android graphics bitmap 
import java fileoutputstream 
import java util concurrent executorservice 
import java util concurrent executors 
public class stackblurmanager 
static final executor_threads runtime getruntime availableprocessors 
static final executorservice executor executors newfixedthreadpool executor_threads 
original image 
private final bitmap _image 
most recent result blurring 
private bitmap _result 
method blurring 
private final blurprocess _blurprocess 
constructor method basic initialization construction pixel array 
param image image that will analyed 
public stackblurmanager bitmap image 
_image image 
_blurprocess javablurprocess 
process image given radius radius must least 
param radius 
public bitmap process radius 
_result _blurprocess blur _image radius 
return _result 
returns blurred image bitmap 
return blurred image 
public bitmap returnblurredimage 
return _result 
save image into file system 
param path path where save image 
public void saveintofile string path 

fileoutputstream fileoutputstream path 
_result compress bitmap compressformat 
catch exception 
printstacktrace 
returns original image bitmap 
return original bitmap image 
public bitmap getimage 
return this _image 
process image using native library 
public bitmap processnatively radius 
throw unsupportedoperationexception 
process image using renderscript possible 
fall back native renderscript available 
param context renderscript requires android context 
param radius 
public bitmap processrenderscript context context float radius 
throw unsupportedoperationexception 
