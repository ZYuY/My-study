//import java.util.Arrays;
//
//public class Text {
//    public static void quickSort(int[] array) {
//       quickSortInternal(array, 0, array.length - 1);
//    }
//    // [left, right] 为待排序区间
//    private static void quickSortInternal(int[] array, int left, int right) {
//    if (left == right) {
// return;
//}
//if (left > right) {
//return;
//}
//// 最简单的选择基准值的方式，选择 array[left] 作为基准值
//// pivotIndex 代表基准值最终停留的下标
//int pivotIndex = partition(array, left, right);
//// [left, pivotIndex - 1] 都是小于等于基准值的
//// [pivotIndex + 1, right] 都是大于等于基准值的
//quickSortInternal(array, left, pivotIndex - 1);
//quickSortInternal(array, pivotIndex + 1, right);
//    }
//    private static int partition(int[] array, int left, int right) {
//int i = left;
//int j = right;
//int pivot = array[left];
//while (i < j) {
//while (i < j && array[j] >= pivot) {
//j--;
//}
//
//while (i < j && array[i] <= pivot) {
//i++;
//}
//swap(array, i, j);
//}
//swap(array, i, left);
//return i;
//    }
//    private static void swap(int[] arr, int p, int q) {
//        int k=arr[p];
//        arr[p]=arr[q];
//        arr[q]=k;
//    }
//    public static void main(String[] args) {
//        int[]arr={3,1,6,4,8,10,2,5};
//        quickSort(arr);
//        System.out.println(Arrays.toString(arr));
//    }
//}
