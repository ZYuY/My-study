import java.util.Arrays;

public class Heap {
    //小堆（自上而下）
    public static void shiftDownSmall(int[] array, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            int right = left + 1;
            int min = left;
            if (right < size) {
                if (array[right] < array[left]) {
                    min = right;
                }
            }
            if (array[index] > array[min]) {
                swap(array, index, min);
                index = min;
                left = 2 * index + 1;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int t=array[i];
        array[i]=array[j];
        array[j]=t;

    }

    public static void shiftDownBig(int[] array, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            int right = left + 1;
            int max = left;
            if (right < size) {
                if (array[right] > array[left]) {
                    max = right;
                }
            }
            if (array[index] < array[max]) {
                swap(array, index, max);
                index = max;
                left = 2 * index + 1;
            } else {
                break;
            }
        }
    }
    //建大堆（从最后一个叶子结点的双亲开始）
    public static void createHeapBig(int[] array, int size){
        for(int i=(size-2)/2;i>=0;i--){
            shiftDownBig(array,i,size);
        }
    }
    //建小堆
    public static void createHeapSmall(int[] a, int s) {
        for (int i = (s - 2) / 2; i >= 0; i--) {
            shiftDownSmall(a, i, s);
        }
    }
//    public static void main(String[] args) {
//        int[] small = {39, 15, 3, 18, 40, 5, 6, 51, 52, 70};
//        shiftDownSmall(small, 0, small.length);
//        System.out.println(Arrays.toString(small));
//
//        int[] big = {100, 50, 30, 25, 40, 80, 70, 10, 5, 20, 30, 60, 70, 60, 70, 5};
//        shiftDownBig(big, 2, big.length);
//        System.out.println(Arrays.toString(big));
//    }
    //自下向上建小堆
      public static void shiftUpSmall(int[] array, int i){
          // 直到 i == 0 之前，一直
          // 先找到 i 的双亲的下标
          // 比较 array[parent] 和 array[i]
          // 如果满足条件，调整结束
          // 否则，交换，然后 让 i = parent 继续
        while(i!=0){
            int p=(i-1)/2;
            if(array[p]<=array[i]){
                break;
            }
            swap(array,p,i);
            i=p;
        }
}
//用堆排序（建大堆，找到最大的先和最后一个交换，第二次和倒数第二个交换，以此类推）
    //利用找第k方法
    public static void heapSort(int[] array){
        createHeapBig(array,array.length);
        for(int i=0;i<array.length-1;i++){
            // 无序 [0, array.length - i)
            // 有序 [array.length - i, array.length)
            swap(array,0,array.length-1-i);
            // 无序 [0, array.length - i - 1)
            // 长度 array.length - i - 1
            shiftDownBig(array,0,array.length-i-1);
        }
    }
    public static void main(String[] args) {
        int[] a = { 9, 4, 1, 3, 7, 1, 2, 2, 9, 8 };
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
