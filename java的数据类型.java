Java 的两大数据类型:1.内置数据类型     2.引用数据类型

一、基本数据类型（内置数据类型）：
整数：byte shor int long
小数：float double
字符：char
布尔类型：boolean

byte：一个字节，8位，有符号，最小值是 -128（-2^7），最大值是 127（2^7-1），默认值是 0。
包装类：java.lang.Byte
例子：byte a = 100，byte b = -50。

short：两个字节，16位，有符号，最小值是 -32768（-2^15），最大值是 32767（2^15 - 1），默认值是 0。
包装类：java.lang.Short
例子：short s = 1000，short r = -20000。

int：四个字节，32位，有符号，最小值是 -2,147,483,648（-2^31），最大值是 2,147,483,647（2^31 - 1），默认值是 0 。
包装类：java.lang.Integer
例子：int a = 100000, int b = -200000。

long：八个字节，64 位，有符号，最小值是 -9,223,372,036,854,775,808（-2^63），最大值是 9,223,372,036,854,775,807（2^63 -1），默认值是 0L。
包装类：java.lang.Long
例子： long a = 100000L，Long b = -200000L。

float：四个字节，单精度浮点型、32位，默认值是 0.0f，浮点数不能用来表示精确的值，精确到小数点后6-7位。
包装类：java.lang.Float
例子：float f1 = 234.5f。

double：八个字节，双精度浮点型、64 位，默认值是 0.0d，不能表示精确的值，精确到小数点后15-16位
包装类：java.lang.Double
例子：double d1 = 123.4。

boolean：只有两个取值：true 和 false；默认值是 false。

char：16 位 Unicode 字符，最小值是 \u0000（即为0），最大值是 \uffff（即为65,535），char 数据类型可以储存任何字符。
包装类：java.lang.Character
例子：char letter = 'A';
char类型存储的是字符在Unicode表中的值，不允许位null

注：long,float赋值时，后面要加上L，f。
例：long a = 100000L；   float f1 = 234.5f；

自动类型转换：从小到大（byte、short、char）<int<long<float<double
byte、short、char之间不会进行自动转换，要手动转换成int，再进行转换
short s=1;
s = s+1;//会报错，1默认为int类型
s = (short)s+1;//true
System.out.println((double)10/3);//true
System.out.println(10d/3);//true

char c1 = 97;//true
System.out.println(c1);//结果为a
char c2 = 'b';
System.out.println(c1+c2);//结果为195，char运算会自动转换成int类型



二、引用数据类型
String str = "张三";
