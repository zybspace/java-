一、基础for循环
1.输出三角形：
public static void main(String[] args){
  for(int side=1; side<=10; side++){
    for(int column=1; column<+side; column++){
      System.out.print("*");
    }
    System.out,print();
  }
}

2.遍历数组的传统方式
/* 建立一个数组 */  
int[] integers = {1， 2， 3， 4};  
/* 开始遍历 */  
for (int j = 0; j<integers.length; j++){  
int i = integers[j];  
System.out.println(i);  
}

3.遍历Collection对象的传统方式
/* 建立一个Collection */   
String[] strings = {"A"， "B"， "C"， "D"}; 
Collection stringList = java.util.Arrays.asList(strings);  
/* 开始遍历 */  
for (Iterator itr = stringList.iterator(); itr.hasNext();) {  
Object str = itr.next();  
System.out.println(str);  
} 

二、for (循环变量类型 循环变量名称 : 要被遍历的对象) {循环体}
循环变量的类型可以和要被遍历的对象中的元素的类型相同。例如，用int型的循环变量来遍历一个int[]型的数组。用Object型的循环变量来遍历一个Collection等。
1.遍历数组的简单方式
/* 建立一个数组 */  
int[] integers = {1， 2， 3， 4};  
/* 开始遍历 */  
for (int i : integers) {  
System.out.println(i);/* 依次输出“1”、“2”、“3”、“4” */  
} 

2.遍历Collection的简单方式
/* 建立一个Collection */ 
String[] strings = {"A"， "B"， "C"， "D"}; 
Collection list = java.util.Arrays.asList(strings);  
/* 开始遍历 */  
for (Object str : list) {  
System.out.println(str);/* 依次输出“A”、“B”、“C”、“D” */  
} 


给循环取名字
public static void main(String[] args){
  Scanner scan = new Scanner(System.in);
  System.out.println("请输入要获取质数的范围上限");
  int domain = scan.nextInt();
  outer : for(int i=2; i<domain; i++){ //从2开始逐个判断
    for(int j=2; j<i; j++){
      if(i%j==0){
        continue outer;
      }
    }
    System.out.println(i);
  }
}

for循环的执行顺序
for(a; b; c){
  d;
}
a-->b-->d-->c-->b-->d-->c-->b
最后一次执行的一定是判断

break:跳出当前循环体
continue:跳出当前循环的当次循环
