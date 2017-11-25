1.构造器
  调用构造器是编译器的责任，所以必须让编译器知道调用的是哪一个方法。所以Java采取了与类同名的方法命名构造器。
  没有返回值类型。也不需要void
  构造器可以有任何访问的修饰： public, protected, private或者没有修饰（通常被package 和 friendly调用）. 不同于方法的是，构造器不能有以下非访问性质的修饰： abstract, final, native, static, 或者 synchronized。
  
  作用：
      产生当前类的对象；
      将属性进行复制（即初始化操作）。
      
  构造方法：只有在对象创建的时候才会去调用，而且只会调用一次。
  
  构造器调用其他构造器，写法为this()  //（）中些参数
  
  public class Person {
      public String name;
      public int age;
  
      // 这是系统自动提供的构造器public Person(){}
      // 自定义构造器
      public Person(String name）{
          this.name = name;
      }
      public Person(String name, int age) {
          this（name）;   //调用本类其他构造器
          this.age = age;
     }
 
     public static void main(String[] args) {
          //Person p = new Person();会报错，默认构造方法被覆盖。必须通过构造函数创建对象
         // 使用自定义的构造器创建对象（构造器是创建对象的重要途径）
         Person p = new Person("小明", 12);
         System.out.println(p.age);
         System.out.println(p.name);
     }
 }
 
2.继承
  当子类继承父类时，之类构造器必须先构造完父类的构造对象。
  java默认调用的是无参的构造器，没有无参构造器是必须手动构造
  
  
3.通用构造块
  //通用构造块  每次在执行构造方法前都会执行
  public class SuperClass(){
    {
      System.out.println("父类  的通用构造块");   //多用于写构造器共有的部分
    }
    //静态代码块  在第一次执行构造方法前执行；且最先执行，在构造块之前
    static {
      System.out.println("父类  的静态代码块");
    }
    public SuperClass（）{
      System.out.println("superClass()");
    }
    public SuperClass（String name）{
      this.name = name;
      System.out.println("superClass()");
    }
  }
  
  public class SubClass extends SuperClass(){
    {
      System.out.println("子类  的通用构造块");   //多用于写构造器共有的部分
    }
    //静态代码块  在第一次执行构造方法前执行；且最先执行，在构造块之前
    static {
      System.out.println("子类  的静态代码块");
    }
    public SubClass(){
      super("张三");
      System.out.println("subClass（）");
    }
  }
  
  public class Test(){
    public static void main(String[] args){
      SubClass subClass = new SubClass();
    }
  }
  
  输出结果为：
    父类  的静态代码块
    子类  的静态代码块
    父类  的通用构造块
    superClass()
    子类  的通用构造块
    subClass（）
    
    总结：先静后非静，先父后子，先通后专
    
