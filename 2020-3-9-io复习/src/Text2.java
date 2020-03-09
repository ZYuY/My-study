import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Text2 {
    public static void main(String[] args) {
        Map<Integer,Integer>map=new HashMap<>();
        map.put(1,11);
        for(Map.Entry<Integer,Integer>e:map.entrySet()){

        }
        System.out.println( map.keySet());
        String str="hehe";
        char[]p=str.toCharArray();
        char a=str.charAt(0);
        char[]arr={'a','b'};
        String res=new String(arr);
        System.out.println(res);
        //heapSort(arr);
        //System.out.println(Arrays.toString(arr));
    }
    //插入排序
    public static void insert(int[]arr){
        for(int i=1;i<arr.length;i++){
            int k=arr[i];
            int j;
            for(j=i-1;j>=0&&k<arr[j];j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=k;
        }
    }
    //选择排序
    public static void select(int[]arr){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int p=arr[min];
            arr[min]=arr[i];
            arr[i]=p;
        }
    }
    //快速排序 时间复杂度O(n*logn)最坏O(n^2)空间复杂度O(logn)
    public static void quickSort(int[]arr){
        quick(arr,0,arr.length-1);
    }

    private static void quick(int[] arr, int left, int right) {
        if(left>=right)return;
        int index=protection(arr,left,right);
        quick(arr,left,index-1);
        quick(arr,index+1,right);
    }

    private static int protection(int[] arr, int left, int right) {
        int i=left;
        int j=right;
        int k=arr[left];
        while(i<j){
            while(i<j&&arr[j]>=k){
                j--;
            }
            arr[i]=arr[j];
            while(i<j&&arr[i]<=k)
                i++;
            arr[j]=arr[i];
        }
        arr[i]=k;
        return i;
    }

    //冒泡排序
    public static void pao(int[]arr){
        boolean isSort=true;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    isSort=false;
                    int p=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=p;
                }
            }
            if(isSort)
                break;
        }
    }

    //堆排序
    public static void heapSort(int[]arr){
        createBig(arr);
        for(int i=0;i<arr.length-1;i++){
            swap(arr,0,arr.length-i-1);
            shiftDownBig(arr,0,arr.length-i-1);
        }
    }

    private static void shiftDownBig(int[] arr, int index, int size) {
        int left=index*2+1;
        while(left<size){
            int right=left+1;
            int max=left;
            if(right<size){
                if(arr[right]>arr[max]){
                    max=right;
                }
            }
            if(arr[index]<arr[max]) {
                swap(arr, index, max);
                index=max;
                left=2*index+1;
            }else{
                break;
            }
        }
    }

    private static void swap(int[] arr, int p, int q) {
        int k=arr[p];
        arr[p]=arr[q];
        arr[q]=k;
    }


    private static void createBig(int[] arr) {
        for(int i=(arr.length-2)/2;i>=0;i--){
            shiftDownBig(arr,i,arr.length);
        }
    }
    //归并排序

    //希尔排序
}
