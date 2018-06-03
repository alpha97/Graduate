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

package achep base fragments dialogs 
import android dialog 
import android bundle 
import android handler 
import android support annotation nonnull 
import android support dialogfragment 
import achep acdisplay 
import achep base appheap 
import achep base interfaces iconfiguration 
import afollestad materialdialogs materialdialog 
dialog fragment that shows 
author artem chepurnoy 
public class helpdialog extends dialogfragment 
nonnull 
private final handler mhandler handler 
nonnull 
private final runnable mreadrunnable runnable 
override 
public void 
appheap getinstance getconfiguration gethelp onuserreadhelp 
nonnull 
override 
public dialog oncreatedialog bundle savedinstancestate 
final iconfiguration configuration appheap getinstance getconfiguration 
return materialdialog builder getactivity 
iconres drawable ic_help_circle_white_ 
title string help_dialog_title 
content configuration gethelp gettext getactivity 
negativetext string close 
build 
override 
public void onresume 
super onresume 
final duration getresources getinteger integer config_maxhelpuserreadfuckyou 
mhandler postdelayed mreadrunnable duration 
override 
public void onpause 
mhandler removecallbacks mreadrunnable 
super onpause 
