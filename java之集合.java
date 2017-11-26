数组的缺陷：
  大小固定；类型相同；无方法。
Arrays可变长数组

Collection与Collections的区别？
    Collection是集合的上级接口，继承与它的类主要有set和List;
    Collections是集合类的帮助类，它提供一些静态方法实现对各种集合的搜索、排序、线程安全化等操作。

Queue:extends Collection,队列，先进先出
List：extends Collection
Set：extends Collection
Vector: implements List,向量按照各元素序号存储，数组大小可以动态增长，对于大容量数据存储效率较高。
Stack:extends Vector,堆栈，先进后出的数组。

ArrayList：底层是可变数组结构，有自己的位置下标。
    ArrayList在查找时更方便
LinkedList:是以链表模式进行存储，每个元素不知道自己的位置，而只是记录记录相邻的两个元素分别是什么。
    LinkedList在插入和删除时性能更高
    
    
1)列表  list接口（继承Collection接口）及其实现类
List的是容量可变的列表，可按索引访问集合中的元素。
特点：集合中的元素是有序、可重复的。
列表在数据结构中分别表现为：数组和向量、链表、堆栈、队列。
实现类：
ArrayList实现一个数组，它的规模可变并且能像链表一样被访问。他提供的功能类似vector类但不同步，他用array方式实现list，允许快速随机存取。
Linkedlist实现一个链表，提供最佳顺序存取，适合插入和移除元素。可以像栈或队列一样被使用。

2)集 set接口（继承collection接口）及其实现类
特点：
集合中的元素不按特定方式排序，只是简单的把对象加入集合中。
对set中成员的访问和操作是通过set中对象的应用进行的，所以集合中不能有重复对象。
Set也有多种变体，可以实现排序功能，如TreeSet，它把对象添加到集中的操作将变为按照某种比较规则将其插入到有序的对象序列中。    它实现的是SortedSet接口，也就是加入了对象比较的方法。通过对集中的对象迭代，我们可以得到一个升序的对象集合。
实现类：
HashSet能够快速的定位一个元素，要注意的是：存入hashset中的对象必须实现
hashcode（）的方法；
TreeSet将放入其中的元素按序存放。

3)映射  map接口及其实现类
Map是一个单独的接口，不继承collection。Map是吧键对象和值对象进行关联的容器。
特点：key不允许重复
实现类：
HashMap实现一个键到值映射的哈希表，通过键取得值对象，没有顺序，通过get（key）取得value，允许存放对象，而且允许键是空（由于键是唯一的，所以只能有一个为空）。
HashTable 实现一个映象，所有的键必须非空。为了能高效的工作，定义键的类必须实现hashcode()方法和equal()方法。这个类是前面java实现的一个继承，并且通常能在实现映象的其他类中更好的使用。
当元素的顺序很重要时选用TreeMap，当元素不必以特定的顺序进行存储时，使用HashMap。Hashtable的使用不被推荐，因为HashMap提供了所有类似的功能，并且速度更快。当你需要在多线程环境下使用时，HashMap也可以转换为同步的。
Properties 一般是把属性文件读入流中后，以键-值对的形式进行保存，以方便读取其中的数据。

HashMap存数据的过程是：
  HashMap内部维护了一个存储数据的Entry数组，HashMap采用链表解决冲突，每一个Entry本质上是一个单向链表。

HashTable和HashMap区别？
    Hashtable 中的方法是Synchronize的，是线程安全的
    HashMap是非线程安全的，只是用于单线程环境下，多线程环境下可以采用concurrent并发包下的concurrentHashMap。


list的遍历：
    List<String> list = new ArrayList<String>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    方法一：
    超级for循环遍历
    for(String attribute : list) {
      System.out.println(attribute);
    }
    方法二：
    对于ArrayList来说速度比较快, 用for循环, 以size为条件遍历:
    for(int i = 0 ; i < list.size() ; i++) {
      system.out.println(list.get(i));
    }
    方法三：
    集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代
    Iterator it = list.iterator();
    while(it.hasNext()) {
      System.ou.println(it.next);
    }

map的遍历：
    方式一 这是最常见的并且在大多数情况下也是最可取的遍历方式。在键值都需要时使用。
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { 
          System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
        }

    方法二 在for-each循环中遍历keys或values。
        如果只需要map中的键或者值，你可以通过keySet或values来实现遍历，而不是用entrySet。
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        //遍历map中的键 
        for (Integer key : map.keySet()) { 
          System.out.println("Key = " + key); 
        } 
        //遍历map中的值 
        for (Integer value : map.values()) { 
          System.out.println("Value = " + value); 
        }
        该方法比entrySet遍历在性能上稍好（快了10%），而且代码更加干净。
        
     方法三使用Iterator遍历
        使用泛型：
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator(); 
        while (entries.hasNext()) { 
          Map.Entry<Integer, Integer> entry = entries.next(); 
          System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
        }
        不使用泛型：
        Map map = new HashMap(); 
        Iterator entries = map.entrySet().iterator(); 
        while (entries.hasNext()) { 
          Map.Entry entry = (Map.Entry) entries.next(); 
          Integer key = (Integer)entry.getKey(); 
          Integer value = (Integer)entry.getValue(); 
          System.out.println("Key = " + key + ", Value = " + value); 
        }
        你也可以在keySet和values上应用同样的方法。
        该种方式看起来冗余却有其优点所在。首先，在老版本java中这是惟一遍历map的方式。另一个好处是，你可以在遍历时调用iterator.remove()来删除entries，另两个方法则不能。根据javadoc的说明，如果在for-each遍历中尝试使用此方法，结果是不可预测的。
        从性能方面看，该方法类同于for-each遍历（即方法二）的性能。
        
     方法四、通过键找值遍历（效率低）
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (Integer key : map.keySet()) { 
          Integer value = map.get(key); 
          System.out.println("Key = " + key + ", Value = " + value);
          
总结:
如果仅需要键(keys)或值(values)使用方法二。如果你使用的语言版本低于java 5，或是打算在遍历时删除entries，必须使用方法三。否则使用方法一(键值都要)。
