import java.util.Random;

public class QuickSort {
    //快排（不稳定）
    // 时间复杂度O(n)*O(二叉树的高度）[n*log(n)~n^2]
    //空间 O(log(n))~O(n)
    //递归，二叉树的高度
    public static void quickSort(int[] array) {
        quickSortInter(array, 0, array.length - 1);
    }


    // [left, right]
    private static void quickSortInter2(int[] a, int left, int right) {
        if (left >= right) {
            // 直到 长度 <= 1
            return;
        }
        // 1. 选择基准值 array[left]
        if (right - left + 1 >= 3) {
            int mid = (left + right) / 2;
            if (a[left] > a[mid]) {
                if (a[left] > a[right]) {
                    if (a[mid] > a[right]) {
                        swap(a, left, mid);
                    } else {
                        swap(a, left, right);
                    }
                } else {
                }
            } else {
                if (a[mid] > a[right]) {
                    if (a[left] > a[right]) {
                    } else {
                        swap(a, left, right);
                    }
                } else {
                    swap(a, left, mid);
                }
            }
        }
        // 2. 做 partition
        //int pivotIndex = partition3(a, left, right);
        int[] pivotIndices = partition4(a, left, right);
        // 左边小区间 [left, pivotIndex - 1]
        // 右边小区间 [pivotIndex + 1, right]
        // 3. 分别对左右小区间按同样方式处理
        quickSortInter(a, left, pivotIndices[0]);
        //quickSortInter(a, left, pivotIndex - 1);
        quickSortInter(a, pivotIndices[1], right);
        //quickSortInter(a, pivotIndex + 1, right);
    }

    private static int[] partition4(int[] a, int left, int right) {
        int pivot = a[left];
        int less = left;
        int great = right;
        int i = left;
        while (i <= great) {
            if (a[i] == pivot) {
                i++;
            } else if (a[i] < pivot) {
                swap(a, i, less);
                less++;
                i++;
            } else {
                swap(a, i, great);
                great--;
            }
        }

        return new int[] { less - 1, great + 1 };
    }


    public static void quickSortInter(int[]array,int left,int right) {
        if(left>=right)
            return;
        int val = array[left];
        if (left < right) {
            int q = partition1(array, left, right);
            quickSortInter(array, left,q-1);
            quickSortInter(array,q+1, right);
        }
    }
    //o(n)
    public static int partition1(int[]array,int left,int right){
        int i=left;
        int j=right;
        int val=array[left];
        while(i<j){
            while(array[j]>=val&&i<j){
                j--;
            }
            while(array[i]<=val&&i<j){
                i++;
            }
            swap(array,i,j);
        }
        swap(array,left,i);
        return i;
    }
//挖坑partition(par在左 先从右边排）
    public static int partition2(int[]array,int left,int right){
        int i=left;
        int j=right;
        int par=array[left];
        while(i<j){
            while(array[j]>=par&&i<j){
                j--;
            }
            array[i]=array[j];
            while(array[i]<=par&&i<j){
                i++;
            }
            array[j]=array[i];
        }
        array[i]=par;
        return i;
    }
    //前后下标（i遇到比它小的就与d交换，i++,d++）
    public static int partition3(int []array,int left,int right){
        int pre=array[left];
        int d=left+1;
        for(int i=left+1;i<=right;i++){
            if(array[i]<pre){
                swap(array,i,d);
                d++;
            }
        }
        swap(array,left,d-1);
        return d-1;
    }
    //基准值选三个数的中间值
    private static void swap(int[] array, int i, int j) {
        int top=array[i];
        array[j]=array[i];
        array[i]=top;
    }

    
}
