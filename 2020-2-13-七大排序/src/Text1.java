import java.util.Arrays;

public class Text1 {
    //插入排序

    /**
     *
     * @param arr
     */
    public static  void  insertSort(int []arr){
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j;
            for(j=i-1;j>=0&&key<arr[j];j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=key;
        }
    }
    //希尔排序
    public static void shellSort(int arr[]){
        int gap=arr.length;
        while(gap>1){
            gap=gap/2;
            insertgap(arr,gap);
        }
        insertgap(arr,1);
    }

    private static void insertgap(int[] arr, int gap) {
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-gap;
            for(;j>=0&&key<arr[j];j-=gap){
                arr[j+gap]=arr[j];
            }
            arr[j+gap]=key;
        }
    }
//选择排序
    public static void selectSort(int[]arr){
        for(int i=0;i<arr.length-1;i++){
            int minindex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minindex]>arr[j]){
                    minindex=j;
                }
            }
            int k=arr[minindex];
            arr[minindex]=arr[i];
            arr[i]=k;
        }
    }
    public static void selectSort2(int[]arr){
        int begin=0;
        int end=arr.length-1;
        while(begin<end){
            int min=begin;
            int max=end;
            for(int j=begin+1;j<=end;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
                if(arr[j]>arr[max]){
                    max=j;
                }
            }
            swap(arr,min,begin);
            if(max==begin){
                max=min;
            }
            swap(arr,max,end);
            begin++;end--;
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int k=arr[a];
        arr[a]=arr[b];
        arr[b]=k;
    }
    //堆排序
    public static void heapSort(int []arr){
        creatHeapBig(arr);
        for(int i=0;i<arr.length-1;i++){
            swap(arr,0,arr.length-i-1);
            shiftDownBig(arr,0,arr.length-i-1);
        }
    }

    private static void creatHeapBig(int[] arr) {
        for(int i=(arr.length-2)/2;i>=0;i--){
            shiftDownBig(arr,i,arr.length);
        }
    }

    private static void shiftDownBig(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        while (left < size) {
            int right = left + 1;
            int max = left;
            if (right < size) {
                if (arr[max] < arr[right]) {
                    max = right;
                }
            }
            if (arr[i] < arr[max]) {
                swap(arr, max, i);
                i = max;
                left = 2 * i + 1;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[]arr={3,1,6,9,2,5,7,4};
        //insertSort(arr);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
