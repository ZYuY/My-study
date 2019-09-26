import java.util.Random;

public class QuickSort {
    //快排（不稳定）
    // 时间复杂度O(n)*O(二叉树的高度）[n*log(n)~n^2]
    //空间 O(log(n))~O(n)
    //递归，二叉树的高度
    public static void quickSortInter(int[]array,int left,int right){
        int val=array[left];
     int q=partition1(array,left,right) ;
        quickSortInter(array,left,q-1);
        quickSortInter(array,q+1,right);
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

    private static void swap(int[] array, int i, int j) {
        int top=array[i];
        array[j]=array[i];
        array[i]=top;
    }
    
}
