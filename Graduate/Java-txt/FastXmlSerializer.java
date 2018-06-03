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
package achep base utils 
import xmlpull xmlserializer 
import java ioexception 
import java outputstream 
import java outputstreamwriter 
import java unsupportedencodingexception 
import java writer 
import java bytebuffer 
import java charbuffer 
import java charset charset 
import java charset charsetencoder 
import java charset coderresult 
import java charset illegalcharsetnameexception 
import java charset unsupportedcharsetexception 
this quick dirty implementation xmlserializer that horribly 
painfully slow like normal only does what needed 
specific files being written with 
public class fastxmlserializer implements xmlserializer 
private static final string escape_table string 
null null null null null null null null 
null null null null null null null null 
null null null null null null null null 
null null null null null null null null 
null null quot null null null null 
null null null null null null null null 
null null null null null null null null 
null null null null null null 
private static final buffer_len 
private final char mtext char buffer_len 
private mpos 
private writer mwriter 
private outputstream moutputstream 
private charsetencoder mcharset 
private final bytebuffer mbytes bytebuffer allocate buffer_len 
private boolean mindent false 
private boolean mintag 
private mnesting 
private boolean mlinestart true 
private void append char throws ioexception 
mpos 
buffer_len 
flush 
mpos 
mtext 
mpos 
private void append string final length throws ioexception 
length buffer_len 
final length 
while 
next buffer_len 
append next buffer_len 
next 
return 
mpos 
length buffer_len 
flush 
mpos 
getchars length mtext 
mpos length 
private void append char final length throws ioexception 
length buffer_len 
final length 
while 
next buffer_len 
append next buffer_len 
next 
return 
mpos 
length buffer_len 
flush 
mpos 
system arraycopy mtext length 
mpos length 
private void append string throws ioexception 
append length 
private void appendindent indent throws ioexception 
indent 
string space 
indent space length 
indent space length 
append space indent 
private void escapeandappendstring final string string throws ioexception 
final string length 
final char char escape_table length 
final string escapes escape_table 
lastpos 


char string charat 
continue 
string escape escapes 
escape null continue 
lastpos append string lastpos lastpos 
lastpos 
append escape 
lastpos append string lastpos lastpos 
private void escapeandappendstring char start throws ioexception 
final char char escape_table length 
final string escapes escape_table 
start 
lastpos start 

start 
char 
continue 
string escape escapes 
escape null continue 
lastpos append lastpos lastpos 
lastpos 
append escape 
lastpos append lastpos lastpos 
public xmlserializer attribute string namespace string name string value throws ioexception 
illegalargumentexception illegalstateexception 
append 
namespace null 
append namespace 
append 
append name 
append 
escapeandappendstring value 
append 
mlinestart false 
return this 
public void cdsect string text throws ioexception illegalargumentexception 
illegalstateexception 
throw unsupportedoperationexception 
public void comment string text throws ioexception illegalargumentexception 
illegalstateexception 
throw unsupportedoperationexception 
public void docdecl string text throws ioexception illegalargumentexception 
illegalstateexception 
throw unsupportedoperationexception 
public void enddocument throws ioexception illegalargumentexception illegalstateexception 
flush 
public xmlserializer endtag string namespace string name throws ioexception 
illegalargumentexception illegalstateexception 
mnesting 
mintag 
append 
else 
mindent mlinestart 
appendindent mnesting 
append 
namespace null 
append namespace 
append 
append name 
append 
mlinestart true 
mintag false 
return this 
public void entityref string text throws ioexception illegalargumentexception 
illegalstateexception 
throw unsupportedoperationexception 
private void flushbytes throws ioexception 
position 
position mbytes position 
mbytes flip 
moutputstream write mbytes array position 
mbytes clear 
public void flush throws ioexception 
packagemanager flush mpos mpos 
mpos 
moutputstream null 
charbuffer charbuffer charbuffer wrap mtext mpos 
coderresult result mcharset encode charbuffer mbytes true 
while true 
result iserror 
throw ioexception result tostring 
else result isoverflow 
flushbytes 
result mcharset encode charbuffer mbytes true 
continue 
break 
flushbytes 
moutputstream flush 
else 
mwriter write mtext mpos 
mwriter flush 
mpos 
public getdepth 
throw unsupportedoperationexception 
public boolean getfeature string name 
throw unsupportedoperationexception 
public string getname 
throw unsupportedoperationexception 
public string getnamespace 
throw unsupportedoperationexception 
public string getprefix string namespace boolean generateprefix 
throws illegalargumentexception 
throw unsupportedoperationexception 
public object getproperty string name 
throw unsupportedoperationexception 
public void ignorablewhitespace string text throws ioexception illegalargumentexception 
illegalstateexception 
throw unsupportedoperationexception 
public void processinginstruction string text throws ioexception illegalargumentexception 
illegalstateexception 
throw unsupportedoperationexception 
public void setfeature string name boolean state throws illegalargumentexception 
illegalstateexception 
name equals http xmlpull features html indent output 
mindent true 
return 
throw unsupportedoperationexception 
public void setoutput outputstream string encoding throws ioexception 
illegalargumentexception illegalstateexception 
null 
throw illegalargumentexception 
true 

mcharset charset forname encoding newencoder 
catch illegalcharsetnameexception unsupportedcharsetexception 
throw unsupportedencodingexception unsupportedencodingexception 
encoding initcause 
moutputstream 
else 
setoutput 
encoding null 
outputstreamwriter 
outputstreamwriter encoding 
public void setoutput writer writer throws ioexception illegalargumentexception 
illegalstateexception 
mwriter writer 
public void setprefix string prefix string namespace throws ioexception 
illegalargumentexception illegalstateexception 
throw unsupportedoperationexception 
public void setproperty string name object value throws illegalargumentexception 
illegalstateexception 
throw unsupportedoperationexception 
public void startdocument string encoding boolean standalone throws ioexception 
illegalargumentexception illegalstateexception 
append version encoding standalone 
standalone 
mlinestart true 
public xmlserializer starttag string namespace string name throws ioexception 
illegalargumentexception illegalstateexception 
mintag 
append 
mindent 
appendindent mnesting 
mnesting 
append 
namespace null 
append namespace 
append 
append name 
mintag true 
mlinestart false 
return this 
public xmlserializer text char start throws ioexception 
illegalargumentexception illegalstateexception 
mintag 
append 
mintag false 
escapeandappendstring start 
mindent 
mlinestart start 
return this 
public xmlserializer text string text throws ioexception illegalargumentexception 
illegalstateexception 
mintag 
append 
mintag false 
escapeandappendstring text 
mindent 
mlinestart text length text charat text length 
return this 
