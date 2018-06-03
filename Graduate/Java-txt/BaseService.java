package achep base services 
import android service 
import android content intent 
import achep base interfaces ipowersave 
import achep base utils power powersavedetector 
author artem chepurnoy 
since 
public abstract class baseservice extends service implements ipowersave 
private powersavedetector mpsd 
inheritdoc 
override 
public void oncreate 
super oncreate 
mpsd powersavedetector newinstance this 
mpsd start 
inheritdoc 
override 
public void ondestroy 
mpsd stop 
super ondestroy 
inheritdoc 
override 
public void ontaskremoved intent rootintent 
mpsd stop 
super ontaskremoved rootintent 
inheritdoc 
override 
public boolean ispowersavemode 
return mpsd ispowersavemode 
inheritdoc 
override 
public boolean isnotpowersavemode 
return mpsd isnotpowersavemode 
