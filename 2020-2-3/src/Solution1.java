import java.util.Arrays;

public class Solution1 {
    //堆排序
    public static void HeapSort(int array[]){
        creatDownSmall(array,array.length);
        for(int i=0;i<array.length-1;i++){
            swap(array,0,array.length-i-1);
            shiftDownSmall(array,0,array.length-i-1);
        }
    }

    private static void shiftDownSmall(int[] array, int index, int size) {
        int left=2*index+1;
        while(left<size){
            int right=left+1;
            int min=left;
            if(right<size){
                if(array[right]<array[left])
                    min=right;
            }
            if(array[index]>array[min]){
                swap(array,index,min);
                        index=min;
                left=2*index+1;
            }else{
                break;
            }
        }
    }

    private static void swap(int[] array, int i, int i1) {
        int k=array[i];
        array[i]=array[i1];
        array[i1]=k;
    }

    private static void creatDownSmall(int[] array, int size) {
        for(int i=(size-2)/2;i>=0;i--){
            shiftDownSmall(array,i,size);
        }
    }

    public static void main(String[] args) {
        int[] a = { 9,5,2,7,3,4,5,2,6,8 };
        HeapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
