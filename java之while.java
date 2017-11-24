while（判断条件）{ 
循环体 
}

public static void main(String[] args) {
    int i=1;
    while (i<=10) {
        System.out.println("你好"+i);
        i++;
    }
}

public static void main(String[] args) {
    int i=1;
    while (true) {
        System.out.println("你好"+i);
        i++;
        if(i<=10){
          break;
        }
    }
}

do{ 
循环体 
}while（判断语句）;

public static void main(String[] args) {
    int i=1;
    do {
        i++;
        System.out.println(i);
    } while (i<1);
}
结果为：2
当while条件满足时就继续执行
