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
import android support annotation nonnull 
import android util base 
author artem chepurnoy 
public class encryptionutils 
method deciphers previously ciphered message 
param message ciphered message 
param salt salt which used ciphering 
return deciphered message 
nonnull 
public static string fromx nonnull string message nonnull string salt 
throws illegalargumentexception 
return string base decode message base url_safe salt 
symmetric algorithm used ciphering deciphering 
param message message 
param salt salt 
return ciphered deciphered message 
nonnull 
public static string nonnull string message nonnull string salt 
final char message tochararray 
final char salt tochararray 
final length 
final length 
final char result char 

result char 
return string result 
