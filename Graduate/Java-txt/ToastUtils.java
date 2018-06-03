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

package achep base utils 
import android content context 
import android support annotation nonnull 
import android support annotation stringres 
import android widget toast 
helper class with utils related toasts without bacon 
author artem chepurnoy 
public class toastutils 
shows toast message with given message shortly 
param text message show 
showlong android content context charsequence 
nonnull 
public static toast showshort nonnull context context nonnull charsequence text 
return show context text toast length_short 
nonnull 
public static toast showshort nonnull context context stringres stringres 
return showshort context context getstring stringres 
shows toast message with given message long time 
param text message show 
showshort android content context charsequence 
nonnull 
public static toast showlong nonnull context context nonnull charsequence text 
return show context text toast length_long 
nonnull 
public static toast showlong nonnull context context stringres stringres 
return showlong context context getstring stringres 
nonnull 
private static toast show nonnull context context charsequence text duration 
toast toast toast maketext context text duration 
toast show 
return toast 
class showing sequence toasts 
author artem chepurnoy 
public static class singletoast 
private final context mcontext 
private toast mtoast 
public singletoast nonnull context context 
mcontext context 
public void show charsequence text duration 
mtoast null 
mtoast cancel 
mtoast toastutils show mcontext text duration 
