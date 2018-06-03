package drivemode android typeface 
import android alertdialog 
import android dialog 
import android progressdialog 
import android content dialoginterface 
import android widget button 
import android widget textview 
author keishinyokomaku 
final class dialogutils 
public static extends dialog void settypeface typefacehelper helper dialog string typefacename style 
dialog instanceof progressdialog 
settypeface helper progressdialog dialog typefacename style 
else dialog instanceof alertdialog 
settypeface helper alertdialog dialog typefacename style 
private static void settypeface typefacehelper helper alertdialog alertdialog string typefacename style 
button positive alertdialog getbutton dialoginterface button_positive 
button negative alertdialog getbutton dialoginterface button_negative 
button neutral alertdialog getbutton dialoginterface button_neutral 
textview message textview alertdialog findviewbyid android message 
positive null 
helper settypeface positive typefacename style 
negative null 
helper settypeface negative typefacename style 
neutral null 
helper settypeface neutral typefacename style 
message null 
helper settypeface message typefacename style 
private static void settypeface typefacehelper helper progressdialog progressdialog string typefacename style 
textview message textview progressdialog findviewbyid android message 
message null 
helper settypeface message typefacename style 
