面向对象的三大特性：
  封装、继承、多态
  
什么是封装？
  对象数据和操作该对象的指令都是对象自身的一部分，能够实现尽可能对外部隐藏数据。
  实际项目开发中，使用封装最多的就是实体类，常常和JavaBean（类必须是具体的和公共的，并且具有无参数的构造器）一起使用。
  那么，实体类有那些东西呢？
  答：私有的成员变量、无参数的构造器、有参数的构造器、setter和getters方法、重写tostring方法、重写hashCode和equals方法。
  
什么是继承？
  继承是面向对象程序设计能够提高软件开发效率的重要原因之一。
  继承是具有传递性的，就像现实中孙子不仅长得像爸爸而且还像他爷爷。
  继承来的属性和方法是隐式的，也就是在本类里面是看不见的。
  一个类只能有一个父类，也就是类只能是单继承。
  一个接口 可以有多个父类，也就是接口可以是多继承。
  
  
什么是多态？
  多态就是对象拥有多种形态：引用多态和方法多态。
  引用多态：父类的引用可以指向本类对象、父类的引用可以指向子类的对象。
  方法多态：创建本类对象时，调用的方法为本类的方法；创建子类对象时，调用的方法为子类重写的方法或者继承的方法。（即多种状态，子类都具有父类的方法，但方法             的实现的方式不同）
  存在多态的必要条件：继承、重写。
  多态的作用是消除类型之间的耦合关系。
