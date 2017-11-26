多线程：指的是这个程序（一个进程）运行时产生不只一个线程。
并发与并行：
    并行：多个CPU或多台计算机同事执行一段处理逻辑，是真正的同时。
    并发：通过CPU调度运算，让用户看上去同时执行，实际上从cpu操作层面不是真正的同时。并发往往在场景中有公用的资源，那么针对这个公用的资源往往产生瓶颈，我们会用TPS或者QPS来反应这个系统的处理能力。
    线程安全：经常用来描绘一段代码。指在并发的情况之下，该代码经过多线程使用，线程的调度顺序不影响任何结果。这个时候使用多线程，我们只需要关注系统的内存，cpu是不是够用即可。反过来，线程不安全就意味着线程的调度顺序会影响最终结果。
    同步：Java中的同步指的是通过人为的控制和调度，保证共享资源的多线程访问成为线程安全，来保证结果的准确。如上面的代码简单加入@synchronized关键字。在保证结果准确的同时，提高性能，才是优秀的程序。线程安全的优先级高于性能。


进程：每个进程都有独立的代码和数据空间（进程上下文），进程间的切换会有较大的开销，一个进程包含1--n个线程。（进程是资源分配的最小单位）
线程：同一类线程共享代码和数据空间，每个线程有独立的运行栈和程序计数器(PC)，线程切换开销小。（线程是cpu调度的最小单位）

线程和进程一样分为五个阶段：创建、就绪、运行、阻塞、终止。
1、新建状态（New）：新创建了一个线程对象。
2、就绪状态（Runnable）：线程对象创建后，其他线程调用了该对象的start()方法。该状态的线程位于可运行线程池中，变得可运行，等待获取CPU的使用权。
3、运行状态（Running）：就绪状态的线程获取了CPU，执行程序代码。
4、阻塞状态（Blocked）：阻塞状态是线程因为某种原因放弃CPU使用权，暂时停止运行。直到线程进入就绪状态，才有机会转到运行状态。阻塞的情况分三种：
（一）、等待阻塞：运行的线程执行wait()方法，JVM会把该线程放入等待池中。(wait会释放持有的锁)
（二）、同步阻塞：运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池中。
（三）、其他阻塞：运行的线程执行sleep()或join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。（注意,sleep是不会释放持有的锁）
5、死亡状态（Dead）：线程执行完了或者因异常退出了run()方法，该线程结束生命周期。


在java中要想实现多线程，有两种手段，一种是继续Thread类，另外一种是实现Runable接口.(其实准确来讲，应该有三种，还有一种是实现Callable接口，并与Future、线程池结合使用），实现run（）方法，启动start()方法。

start()方法的调用后并不是立即执行多线程代码，而是使得该线程变为可运行态（Runnable），什么时候运行是由操作系统决定的。
Thread.sleep()方法调用目的是不让当前线程独自霸占该进程所获取的CPU资源，以留出一定时间给其他线程执行的机会。

推荐使用Runable
如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享。

实现Runnable接口比继承Thread类所具有的优势：
1）：适合多个相同的程序代码的线程去处理同一个资源
2）：可以避免java中的单继承的限制
3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
4）：线程池只能放入实现Runable或callable类线程，不能直接放入继承Thread的类

扩展java.lang.Thread类
class Thread1 extends Thread{  
    private String name;  
    public Thread1(String name) {  
       this.name=name;  
    }  
    public void run() {  
        for (int i = 0; i < 5; i++) {  
            System.out.println(name + "运行  :  " + i);  
            try {  
                sleep((int) Math.random() * 10);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
         
    }  
}  
public class Main {  
  
    public static void main(String[] args) {  
        Thread1 mTh1=new Thread1("A");  
        Thread1 mTh2=new Thread1("B");  
        mTh1.start();  
        mTh2.start();  
  
    }  
}  
                                                   
实现java.lang.Runnable接口
class Thread2 implements Runnable{  
    private String name;  
  
    public Thread2(String name) {  
        this.name=name;  
    }  
  
    @Override  
    public void run() {  
      for (int i = 0; i < 5; i++) {  
          System.out.println(name + "运行  :  " + i);  
          try {  
              Thread.sleep((int) Math.random() * 10);  
          } catch (InterruptedException e) {  
              e.printStackTrace();  
          }  
       }  
    }  
}  
public class Main {  
    public static void main(String[] args) {  
        new Thread(new Thread2("C")).start();  
        new Thread(new Thread2("D")).start();  
    }  
}  
                                                   
                                                   
wait():释放锁对象，自身进入等待状态，等待notify
notity():唤醒一个线程，随机的
notityAll():唤醒所有在等待Resource.lock这把锁的线程
sleep()是不会释放持有的锁
线程加入：join()方法，等待其他线程终止。在当前线程中调用另一个线程的join()方法，则当前线程转入阻塞状态，直到另一个进程运行结束，当前线程再由阻塞转为就绪状态。


死锁
    产生死锁的四个必要条件：
    （1） 互斥条件：一个资源每次只能被一个进程使用。
    （2） 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
    （3） 不剥夺条件:进程已获得的资源，在末使用完之前，不能强行剥夺。
    （4） 循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。
    这四个条件是死锁的必要条件，只要系统发生死锁，这些条件必然成立，而只要上述条件之
    一不满足，就不会发生死锁。
    死锁的解除与预防：
    理解了死锁的原因，尤其是产生死锁的四个必要条件，就可以最大可能地避免、预防和
    解除死锁。所以，在系统设计、进程调度等方面注意如何不让这四个必要条件成立，如何确
    定资源的合理分配算法，避免进程永久占据系统资源。此外，也要防止进程在处于等待状态
    的情况下占用资源。因此，对资源的分配要给予合理的规划。
