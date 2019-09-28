import java.util.Arrays;

public class Merge {
    //归并排序   时间复杂度O(n*log(n))
    public static void mergeSort(int[] array) {
        mergeSortInternal(array, 0, array.length);
    }
//分治 区间（找中间位置 一分为二）[low,high)左闭右开
    private static void mergeSortInternal(int[] array, int low, int high){
        if(low>=high-1){
            return;
        }
        int mid=(low+high)/2;//找中间
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid,high);
        merge(array,low,mid,high);
    }
    //合并两个有序数组
    public static void merge(int[]a,int low,int mid,int high) {
        int[] b = new int[high - low];
        int i = low;
        int j = mid;
        int g = 0;
        while (i < mid && j < high) {
            if (a[i] >=a[j]) {
                b[g++] = a[j++];
            } else {
                b[g++] = a[i++];
            }
        }
        while (i <mid) {
            b[g++] = a[i++];
        }
        while (j < high) {
            b[g++] = a[j++];
        }
        for (int x = 0; x < high - low; x++) {
            a[low + x] = b[x];
        }
    }
//优化
    public static void mergeSort2(int[] array) {
        int []exter=new int[array.length];

        mergeSortInternal2(array, 0, array.length,exter);
    }
    private static void mergeSortInternal2(int[] array, int low, int high,int[]exter){
        if(low>=high-1){
            return;
        }
        int mid=(low+high)/2;//找中间
        mergeSortInternal2(array,low,mid,exter);
        mergeSortInternal2(array,mid,high,exter);
        merge2(array,low,mid,high,exter);
    }
    public static void merge2(int[]a,int low,int mid,int high,int[]exter) {
        int i = low;
        int j = mid;
        int g = 0;
        while (i < mid && j < high) {
            if (a[i] > a[j]) {
                exter[g++] = a[j++];
            } else {
                exter[g++] = a[i++];
            }
        }
        while (i <mid) {
            exter[g++] = a[i++];
        }
        while (j < high) {
            exter[g++] = a[j++];
        }
        for (int x = 0; x < high - low; x++) {
            a[low + x] =exter[x];
        }
    }
   //非递归
   public static void mergeSort3(int[] array){
        for(int i=1;i<array.length;i*=2){//刚开始每组数的个数
            for(int j=0;j<array.length;j+=2*i){
                int low=j;
                int mid=low+i;
                if(mid>=array.length){
                    continue;
                }
                int high=mid+i;
                if(high>array.length){
                    high=array.length;
                }
                merge(array,low,mid,high);
            }
        }
   }
    public static void main(String[] args) {
        int []a=new int[]{9,5,2,7,4,9,0};
        mergeSort3(a);
        System.out.println(Arrays.toString(a));

    }
}
