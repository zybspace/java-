1.冒泡排序
  基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：每当两相  邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
  int[] array = {45,32,54,12,43,65,11,3,43,6,33,90,44,1,178};
  public void bubbleSort(int[] array){
    int temp;
    for(int i=0; i<array.length; i++){ //趟数
      for(int j=0; j<array.length-i-1; i++){  //比较次数
        if(array[j] > array[j+1]){
          temp = array[j];
          array[j] = array[j+1];
          array[j+1] = array[temp];
        }
      }
    }
  }
  
2.直接插入排序
  基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
  public void insertSort(int[] array){
        int temp=0;  
        for(int i=1;i<array.length;i++){  
           int j=i-1;  
           temp=array[i];  
           for(;j>=0&&temp<array[j];j--){  
               array[j+1]=array[j];                       //将大于temp的值整体后移一个单位  
           }  
           array[j+1]=temp;  
        } 
    }
    
3.快速排序
    基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
    public void qsort(int array[]){
        if(array.length>1){   //查看数组是否为空
            _qsort(array,0,array.length-1);
        }
    }
    /**
     * 一趟快速排序
     * @param array
     */
    private void _qsort(int[] array,int low,int high){
        if(low < high){
            int middle = getMiddle(array, low, high);   //将array数组进行一分为二
            _qsort(array,low,middle-1);   //对低字表进行递归排序
            _qsort(array, middle+1, high);    //对高字表进行递归排序
        }
    }
    /**
     * 得到中间值
     */
    private int getMiddle(int[] array,int low,int high){
        int tmp = array[low];   //数组的第一个作为中轴
        while(low < high){
            while(low < high && array[high] >= tmp)
            {
               high--;
            }
            array[low] = array[high];   //比中轴小的记录移到低端
            while(low<high && array[low]<=tmp)
            {
              low++;
            }
            array[high] = array[low];   //比中轴大的记录移到高端
        }
        array[low] = tmp;   //中轴记录到尾
        return low;   //返回中轴的位置
    }
    
4.选择排序
  基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
  选择排序的时间复杂度：简单选择排序的比较次数与序列的初始排序无关。 假设待排序的序列有 N 个元素，则比较次数永远都是N (N - 1) / 2。而移动次数与序列的初始排序有关。当序列正序时，移动次数最少，为 0。当序列反序时，移动次数最多，为3N (N - 1) /  2。
  所以，综上，简单排序的时间复杂度为 O(N2)。
  public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={1,3,2,45,65,33,12};
        System.out.println("交换之前：");
        for(int num:arr){
            System.out.print(num+" ");
        }        
        //选择排序的优化
        for(int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;
            for(int j = k + 1; j < arr.length; j++){// 选最小的记录
                if(arr[j] < arr[k]){ 
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }    
        }
      }
      
 5.希尔排序（最小增量排序）
  基本思想：算法先将要排序的一组数按某个增量d（n/2,n为要排序数的个数）分成若干组，每组中记录的下标相差d.对每组中全部元素进行直接插入排序，然后再用一个较小的增量（d/2）对它进行分组，在每组中再进行直接插入排序。当增量减到1时，进行直接插入排序后，排序完成。
  public  void shellSort(int[] array){  
        double d1=array.length;  
        int temp=0;  
        while(true){  
            d1= Math.ceil(d1/2);  
            int d=(int) d1;  
            for(int x=0;x<d;x++){  
                for(int i=x+d;i<array.length;i+=d){  
                    int j=i-d;  
                    temp=array[i];  
                    for(;j>=0&&temp<array[j];j-=d){  
                        array[j+d]=array[j];  
                    }  
                    array[j+d]=temp;  
                }  
            }  
            if(d==1)  
                break;  
        }  
    }  
