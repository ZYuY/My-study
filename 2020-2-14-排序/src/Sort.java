import java.util.Arrays;

public class Sort {
    //插入排序
    public  static  void insertSort(int arr[]){
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
    public  static  void xierSort(int[]arr){
        int gay=arr.length;
       while(gay>1){
           insertgay(arr,gay);
           gay=gay/2;
       }
       insertgay(arr,1);
    }

    private static void insertgay(int[] arr, int gay) {
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j;
            for(j=i-gay;j>=0&&key<arr[j];j-=gay){
                arr[j+gay]=arr[j];
            }
            arr[j+gay]=key;
        }
    }
//选择排序
    public  static  void selectSort(int[]arr){
        for(int i=0;i<arr.length-1;i++){
            int maxIndex=i;
            int j=i+1;
            for(;j<arr.length;j++){
                if(arr[j]>arr[maxIndex]){
                    maxIndex=j;
                }
            }
            swap(arr,i,maxIndex);
        }
    }
    public  static  void  selectSort1(int[]arr){
        int begin=0;
        int end=arr.length-1;
        while(begin<end){
            int minIndex=begin;
            int maxIndex=end;
            for(int i=begin+1;i<=end;i++){
                if(arr[i]>arr[maxIndex])
                    maxIndex=i;
                if(arr[i]<arr[minIndex])
                    minIndex=i;
            }
            swap(arr,minIndex,begin);
            if(maxIndex==begin)
                maxIndex=minIndex;
            swap(arr,maxIndex,end);
            begin++;
            end--;
        }
    }
//堆排序
    public  static  void  heapSort(int []arr){
        creatHeapBig(arr);
        for(int i=0;i<arr.length-1;i++){
            swap(arr,0,arr.length-1-i);
            shiftDown(arr,0,arr.length-1-i);
        }
    }

    private static void creatHeapBig(int[] arr) {
        for(int i=(arr.length-2)/2;i>=0;i--){
            shiftDown(arr,i,arr.length);
        }
    }

    private static void shiftDown(int[] arr, int index, int size) {
        int left=2*index+1;
        while(left<size){
            int right=left+1;
            int max=left;
            if(right<size){
                if(arr[max]<arr[right]){
                    max=right;
                }
            }
            if(arr[index]<arr[max]){
                swap(arr,index,max);
            }
            index=max;
            left=2*index+1;
        }
    }

    private static void swap(int[] arr, int p, int q) {
        int k=arr[p];
        arr[p]=arr[q];
        arr[q]=k;
    }
//冒泡排序
    public  static  void  bubbleSort(int []arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    //快排
   public  static  void quickSort(int[]arr){
        quick(arr,0,arr.length-1);
   }

    private static void quick(int[] arr, int left, int right) {
        if(left>=right)return;
        int partitionId=partition1(arr,left,right);
        quick(arr,left,partitionId-1);
        quick(arr,partitionId+1,right);
    }

    private static int partition1(int[] arr, int left, int right) {
        int i=left;
        int j=right;
        int k=arr[left];
        while(i<j){
            while(i<j&&arr[j]>=k)
                j--;
            while(i<j&&arr[i]<=k)
                i++;
            swap(arr,i,j);
        }
        swap(arr,i,left);
        return i;
    }
    //挖坑法
    public  static  int partition2(int arr[],int left,int right){
        int i=left;
        int j=right;
        int k=arr[left];
        while(i<j){
            while(i<j&&arr[j]>=k)
                j--;
            arr[i]=arr[j];
            while(i<j&&arr[i]<=k)
                i++;
            arr[j]=arr[i];
        }
        arr[i]=k;
        return i;
    }
//归并排序
public   static  void mergeSort(int[]arr){
        mergeSortIntenel(arr,0,arr.length);
}

    private static void mergeSortIntenel(int[] arr, int index, int high) {
        if(index>=high-1)return;
        int mid=(index+high)/2;
        mergeSortIntenel(arr,index,mid);
        mergeSortIntenel(arr,mid,high) ;
        merge(arr,index,mid,high);
    }

    private static void merge(int[] arr, int index, int mid, int high) {
        int i = index;
        int j = mid;
        int length = high - index;
        int[] ext = new int[length];
        int k = 0;
// 选择小的放入 extra
        while (i < mid && j < high) {
            // 加入等于，保证稳定性
            if (arr[i] <= arr[j]) {
                ext[k++] = arr[i++];
            } else {
                ext[k++] = arr[j++];
            }
        }
        // 将属于元素放入 extra
        while (i < mid) {
            ext[k++] = arr[i++];
        }
        while (j < high) {
            ext[k++] = arr[j++];

// 从 extra 搬移回 array
            for (int t = 0; t < length; t++) {
// 需要搬移回原位置，从 low 开始
                arr[index + t] = ext[t];
            }
        }
    }
    public static void main(String[] args) {
        int[]arr={3,1,6,4,8,10,2,5};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
