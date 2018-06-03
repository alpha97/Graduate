package drivemode android typeface 
import android application 
import android content context 
import android graphics typeface 
import java util hashtable 
this typeface instance cache 
cache avoid memory leak problem when typeface loaded 
link more details about memory leak issue 
https code google android issues detail 
author hnakagawa 
package final class typefacecache 
private static typefacecache sinstance 
private final hashtable string typeface mcache hashtable 
private final application mapplication 
private typefacecache application application 
mapplication application 
cache instance typeface name this will return instance immediately 
otherwise this method will create typeface instance into cache return instance 
param name typeface name 
return link android graphics typeface instance 
public synchronized typeface string name 
typeface typeface mcache name 
typeface null 

typeface typeface createfromasset mapplication getassets name 
catch exception 
return null 
mcache name typeface 
return typeface 
retrieve this cache 
param context context 
return cache instance 
public static synchronized typefacecache getinstance context context 
sinstance null 
sinstance typefacecache application context getapplicationcontext 
return sinstance 
