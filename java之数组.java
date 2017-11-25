1.什么叫数组？
  用来存储 固定大小 的同类型元素。位置有序
  
2.一维数组
  数组变量声明：
  int[] nums;
  分配空间：
  nums = new int[3];
  
  int[] nums = new int[3];//声明数组变量，数组必须定义大小，大小定义在=好右边。
  int nums[] = new int[3];//效果同int[] nums = new int[3];
  //赋值引用
  nums[0] = 1;
  nums[1] = 2;
  nums[2] = 3;
  
  int[] nums = {1,2,3};//true
  int[] nums = new int[]{1,2,3};//true
  int[] nums = new int[3]{1,2,3};//false,{}中已经将分配的空间给占用了，不允许在[]中再次分配数组空间  
  
  
  数组遍历：
  for(int i=0; i<nums.length; i++){
    System.out.println("数组中的第"+i+"个元素为："+nums[i]);
  }
  //jdk1.5  forEach   无法确定元素的位置
  for(int num : nums){
     System.out.println(num);
  }
  
2.二维数组
  //声明数组
  int[][] nums;
  //分配空间
  nums = new int[3][2];
  nums[0][0] = 1;
  nums[0][1] = 2;
  nums[1][0] = 1;
  nums[1][1] = 3;
  nums[2][0] = 2;
  nums[2][1] = 3;
  
  int[][] nums = new int[3][2];
  int[][] nums = new int[][]{{1,2},{1,3},{2,3}};
  
  数组遍历：
  for(int i=0; i<nums.length; i++){  //nums.length代表的二维数组中有几个一维数组
    for(int j=0; j<nums[i].length; j++){  //nums[i].length代表的是第i个一维数组中有几个元素
      System.out.print(nums[i][j]+"  ");
    }
    System.out.println();//用于换行
  }
  //jdk1.5 forEach
  for(int[] arr : nums){
    for(int num : arr){
      System.out.print(nums+"  ");
    }
    System.out.println();//用于换行
  }
  
3.不规则数组
    //声明数组
    int[][] nums;
    //分配空间
    nums = new nums[3][];//必须确定数组中有几个一维数组
    nums[0][0] = 1;//会报错，在分配空间时并没有对每个一维数组的大小分配空间，需要在使用时手动的生成一维数组
    nums[0] = new int[2];
    nums[1] = new int[3];
    
    
