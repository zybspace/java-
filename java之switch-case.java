1.语法格式
switch (表达式) {
case 条件1:
    语句1;
    break;
case 条件2:
    语句2;
    break;
...
default:
    语句;
}

2.使用示例
int类型switch示例（byte,short,char同理）：
int i = 3;
switch (i) {
case 1:
    System.out.println(1);
    break;
case 2:
    System.out.println(2);
    break;
case 3:
    System.out.println(3);
    break;
default:
    System.out.println(0);
}

枚举(Enum)类型switch示例
public class TestSwitch {
 
    static enum E {
        A, B, C, D
    }
 
    public static void main(String args[]) {
        E e = E.B;
        switch (e) {
        case A:
            System.out.println("A");
            break;
        case B:
            System.out.println("B");
            break;
        case C:
            System.out.println("C");
            break;
        case D:
            System.out.println("D");
            break;
        default:
            System.out.println(0);
        }
    }
}

String类型switch示例（JDK1.7 后补充进来的）：
String str = "C";
switch (str) {
case "A":
    System.out.println("A");
    break;
case "B":
    System.out.println("B");
    break;
case "C":
    System.out.println("C");
    break;
default:
    System.out.println(0);
}

3.break
break在switch中用于结束当前流程。
一旦case匹配，就会顺序执行后面的程序代码，而不管后面的case是否匹配，直到遇见break。
int i = 2;
switch (i) {
case 1:
    System.out.println(1);
case 2:
    System.out.println(2);
case 3:
    System.out.println(3);
default:
    System.out.println(0);
}
输出结果：
2
3
0

巧用break：
int year = 2015;
int month = 8;
int day = 0;
switch (month) {
case 1:
case 3:
case 5:
case 7:
case 8:
case 10:
case 12:
    day = 31;
    break;
case 2:
    day = 28;
    break;
case 4:
case 6:
case 9:
case 11:
    day = 30;
    break;
}

4.default
default在当前switch找不到匹配的case时执行。default并不是必须的。
