1.String
  Strig 类型定义时用了final修饰（不能被继承），其字符串数组也用了final修饰（private final char value[];），所以字符串数组不能被修改，String本质使用字符串数组实现的，所以String是不能被修改的。
  在代码中遇到字符串常量时，编译器会使用该值创建一个 String 对象。
  和其它对象一样，可以使用关键字和构造方法来创建 String 对象。
  public class StringDemo{
   public static void main(String args[]){
      char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
      String helloString = new String(helloArray);  
      System.out.println( helloString );
   }
  }
  以上实例编译运行结果如下：
  runoob
  
  public class test{
    public static void main（String[] args）{
      String s = "Google";
      System.out.println("s = " + s);

      s = "Runoob";
      System.out.println("s = " + s);
    }
  }
  输出结果为：
  Google
  Runoob
  从结果上看是改变了，但为什么门说String对象是不可变的呢？
  原因在于实例中的 s 只是一个 String 对象的引用，并不是对象本身，当执行 s = "Runoob"; 创建了一个新的对象 "Runoob"，而原来的 "Google" 还存在于内存中。
  
  length()方法，length属性和size()的方法的区别:
   1.length()方法是针对字符串来说的，要求一个字符串的长度就要用到它的length()方法；
   2.length属性是针对Java中的数组来说的，要求数组的长度可以用其length属性；
   3.java中的size()方法是针对泛型集合说的,如果想看这个泛型有多少个元素,就调用此方法来查看!
    
     
2、StringBuffer（Synchronized，即线程安全）
    StringBuffer是可变的，可以通过其方法对变量进行操作
    StringBuffer sb = "abc";  //报错，StringBuffer不存在常量池一说，必须通过构造器来创建对象
    StringBuffer sb = new StringBuffer("abc");


3、StringBuilder：字符串变量（非线程安全）。

使用策略：
  （1）基本原则：如果要操作少量的数据，用String ；单线程操作大量数据，用StringBuilder ；多线程操作大量数据，用StringBuffer。
  （2）不要使用String类的"+"来进行频繁的拼接，因为那样的性能极差的，应该使用StringBuffer或StringBuilder类，这在Java的优化上是一条比较重要的原则。例如：
    String result = "";  
    for (String s : hugeArray) {  
        result = result + s;  
    }  

    // 使用StringBuilder  
    StringBuilder sb = new StringBuilder();  
    for (String s : hugeArray) {  
        sb.append(s);  
    }  
    String result = sb.toString();  
    当出现上面的情况时，显然我们要采用第二种方法，因为第一种方法，每次循环都会创建一个String result用于保存结果，除此之外二者基本相同（对于jdk1.5及之后版本）。
    （3）为了获得更好的性能，在构造 StringBuffer 或 StringBuilder 时应尽可能指定它们的容量。当然，如果你操作的字符串长度（length）不超过 16 个      字符就不用了，当不指定容量（capacity）时默认构造一个容量为16的对象。不指定容量会显著降低性能。
    （4）StringBuilder一般使用在方法内部来完成类似"+"功能，因为是线程不安全的，所以用完以后可以丢弃。StringBuffer主要用在全局变量中。
    （5）相同情况下使用 StringBuilder 相比使用 StringBuffer 仅能获得 10%~15% 左右的性能提升，但却要冒多线程不安全的风险。而在现实的模块化编程中，负责某一模块的程序员不一定能清晰地判断该模块是否会放入多线程的环境中运行，因此：除非确定系统的瓶颈是在 StringBuffer 上，并且确定你的模块不会运行在多线程模式下，才可以采用StringBuilder；否则还是用StringBuffer。
