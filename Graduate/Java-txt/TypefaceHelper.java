package drivemode android typeface 
import android annotation targetapi 
import android activity 
import android application 
import android dialog 
import android content context 
import android graphics paint 
import android graphics typeface 
import android build 
import android support annotation layoutres 
import android util 
import android view layoutinflater 
import android view view 
import android view viewgroup 
import android widget textview 
import android widget toast 
helper class setting typeface text views 
author keithyokoma 
suppresswarnings unused public apis 
public final class typefacehelper 
public static final string typefacehelper class getsimplename 
private static typefacehelper shelper 
private final typefacecache mcache 
private typefacehelper application application 
mcache typefacecache getinstance application 
initialize instance 
param application application context 
public static synchronized void initialize application application 
shelper null 
already initialized 
shelper typefacehelper application 
terminate instance 
public static synchronized void destroy 
shelper null 
initialized 
return 
shelper null 
retrieve helper instance 
return helper instance 
public static synchronized typefacehelper getinstance 
shelper null 
throw illegalargumentexception instance initialized call initialize first 
return shelper 
typeface target view 
param view typeface 
param typefacename typeface name 
param text view parameter 
public extends textview void settypeface view string typefacename 
typeface typeface mcache typefacename 
typeface null 
view settypeface typeface 
typeface target view 
param view typeface 
param typefacename typeface name 
param style typeface style 
param text view parameter 
public extends textview void settypeface view string typefacename style 
typeface typeface mcache typefacename 
typeface null 
view settypeface typeface style 
typeface text views belong view group 
note that this method recursively trace child view groups typeface text views 
param viewgroup view group that contains text views 
param typefacename typeface name 
param view group parameter 
public extends viewgroup void settypeface viewgroup string typefacename 
count viewgroup getchildcount 
count 
view child viewgroup getchildat 
child instanceof viewgroup 
settypeface viewgroup child typefacename 
continue 
child instanceof textview 
continue 
settypeface textview child typefacename 
typeface text views belong view group 
note that this method recursively trace child view groups typeface text views 
param viewgroup view group that contains text views 
param typefacename typeface name 
param style typeface style 
param view group parameter 
public extends viewgroup void settypeface viewgroup string typefacename style 
count viewgroup getchildcount 
count 
view child viewgroup getchildat 
child instanceof viewgroup 
settypeface viewgroup child typefacename style 
continue 
child instanceof textview 
continue 
settypeface textview child typefacename style 
typeface target paint 
param paint typeface 
param typefacename typeface name 
public void settypeface paint paint string typefacename 
typeface typeface mcache typefacename 
typeface null 
paint settypeface typeface 
typeface text views belong view group 
param context context 
param layoutres layout resource 
param typefacename typeface name 
return view 
public view settypeface context context layoutres layoutres string typefacename 
return settypeface context layoutres null typefacename 
typeface text views belong view group 
param context context 
param layoutres layout resource 
param parent parent view group attach layout 
param typefacename typeface name 
return view 
public view settypeface context context layoutres layoutres viewgroup parent string typefacename 
viewgroup view viewgroup layoutinflater from context inflate layoutres parent 
settypeface view typefacename 
return view 
typeface text views belong view group 
param context context 
param layoutres layout resource 
param typefacename typeface name 
param style typeface style 
return view 
public view settypeface context context layoutres layoutres string typefacename style 
return settypeface context layoutres null typefacename 
typeface text views belong view group 
param context context 
param layoutres layout resource 
param parent parent view group attach layout 
param typefacename typeface name 
param style typeface style 
return view 
public view settypeface context context layoutres layoutres viewgroup parent string typefacename style 
viewgroup view viewgroup layoutinflater from context inflate layoutres parent 
settypeface view typefacename style 
return view 
typeface text views belong activity 
note that decor view activity that typeface will also applied action 
param activity activity 
param typefacename typeface name 
public void settypeface activity activity string typefacename 
settypeface activity typefacename 
typeface text views belong activity 
note that decor view activity that typeface will also applied action 
param activity activity 
param typefacename typeface name 
param style typeface style 
public void settypeface activity activity string typefacename style 
settypeface viewgroup activity getwindow getdecorview typefacename style 
typeface text views belong fragment 
make sure call this method after fragment view creation 
fragments support package 
call link drivemode android typeface typefacehelper supportsettypeface android support fragment string instead 
param fragment fragment 
param typefacename typeface name 
targetapi build version_codes honeycomb 
public extends android fragment void settypeface fragment string typefacename 
settypeface fragment typefacename 
typeface text views belong fragment 
make sure call this method after fragment view creation 
fragments support package 
call link drivemode android typeface typefacehelper supportsettypeface android support fragment string instead 
param fragment fragment 
param typefacename typeface name 
param style typeface style 
targetapi build version_codes honeycomb 
public extends android fragment void settypeface fragment string typefacename style 
view root fragment getview 
root instanceof textview 
settypeface textview root typefacename style 
else root instanceof viewgroup 
settypeface viewgroup root typefacename style 
typeface text views belong fragment 
make sure call this method after fragment view creation 
this support package fragments only 
param fragment fragment 
param typefacename typeface name 
public extends android support fragment void supportsettypeface fragment string typefacename 
supportsettypeface fragment typefacename 
typeface text views belong fragment 
make sure call this method after fragment view creation 
this support package fragments only 
param fragment fragment 
param typefacename typeface name 
param style typeface style 
public extends android support fragment void supportsettypeface fragment string typefacename style 
view root fragment getview 
root instanceof textview 
settypeface textview root typefacename style 
else root instanceof viewgroup 
settypeface viewgroup root typefacename style 
typeface dialog view 
param dialog dialog 
param typefacename typeface name 
public extends dialog void settypeface dialog string typefacename 
settypeface dialog typefacename 
typeface dialog view 
param dialog dialog 
param typefacename typeface name 
param style typeface style 
public extends dialog void settypeface dialog string typefacename style 
dialogutils settypeface this dialog typefacename style 
typeface toast view 
param toast toast 
param typefacename typeface name 
return toast that typeface injected 
public toast settypeface toast toast string typefacename 
return settypeface toast typefacename 
typeface toast view 
param toast toast 
param typefacename typeface name 
param style typeface style 
return toast that typeface injected 
public toast settypeface toast toast string typefacename style 
settypeface viewgroup toast getview typefacename style 
return toast 
