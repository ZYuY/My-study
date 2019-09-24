import java.util.Random;

public class Sort {
    //插入排序（拿后面的数与前面的比较，小的就插入适当的位置）2000
    //稳定   时间 o(n^2)   空间o(1)
    public static void insertSort(int[]nums) {
        for(int i=1;i<=nums.length;i++){
            //有序[0,i)
            //无序[i,nums.length)
            int key=nums[i];
            int j;
            for(j=i-1;j>=0&&nums[j]>key;j--){
                nums[j+1]=nums[j];
            }
            nums[j+1]=key;
        }
    }
    //希尔排序(不稳定）28
    public static void shellSort(int[]array){
        int gap=array.length;
        while(true){
            gap=gap/3+1;
            //gap=gap/2;
            insertSortGap(array,gap);
            if(gap==1)//已经有序
                break;
        }
    }
    public static void  insertSortGap(int[]array,int gap){
        for(int i=gap;i<array.length;i++){
            int key=array[i];
            int j;
            for(j=i-gap;j>=0&&array[j]>key;j-=gap){
                array[j+gap]=array[j];
            }
            array[j+gap]=key;
        }
    }
    //直接选择排序（不稳定）
    public static void selectSort(int[]array){
        for(int i=0;i<array.length-1;i++){
            int maxindex=0;
            for(int j=1;j<array.length-i;j++){
                if(array[j]>array[maxindex]){
                    maxindex=j;
                }
            }
            swap(array,maxindex,array.length-i-1);
        }
    }
    public static void swap(int[]nums,int a,int b){
        int top=nums[a];
        nums[a]=nums[b];
        nums[b]=top;
    }
    public static void selectSort2(int[]array){

    }
    //堆排序(不稳定）
    public static void createHeapBig(int[]array){
        int size=array.length;
        for(int i=(size-2)/2;i>=0;i--){
            shiftDown(array,0,size-i);
        }
    }
    public static void shiftDown(int[]array,int index,int size){
        int left=2*index+1;
        while(left<size){
            int right=left+1;
            int max=left;
            if(right<size){
                if(array[right]>array[left])
                    max=right;
            }
            if(array[index]<array[max]){
                swap(array,index,max);
                index=max;
                left=2*index+1;
            }else{
                break;
            }
        }
    }
    public static void sort(int[]array){
        createHeapBig(array);
        for(int i=0;i<array.length-1;i++){
            swap(array,0,array.length-i-1);
            shiftDown(array,0,array.length-i-1);
        }
    }
    //冒泡排序（稳定）
    public static void sort2(int[]nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j+1,j);
                }
            }
        }
    }
    public static void main(String[] args) {
        Random random=new Random(20190924);
        int[]a=new int[10*10000];
    for(int i=0;i<10*10000;i++){
        a[i]=random.nextInt(10*10000);
    }
       long begin=System.nanoTime() ;
    sort2(a);
    long end=System.nanoTime();
    double ms=(end-begin)*1.0/1000/1000;
        System.out.printf("共耗时：%.5f 毫秒%n",ms);
    }
}
