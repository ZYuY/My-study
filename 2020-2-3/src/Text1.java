public class Text1 {

//建堆
    public static void createHeapSmall(int[] a, int s) {
        for(int i=(s-2)/2;i>=0;i--){
            shiftDownSmall(a,i,s);
        }
    }
//向下调整小堆
    public static void shiftDownSmall(int[]array, int index, int size) {
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

    private static void swap(int[] array, int index, int min) {
        int k=array[index];
        array[index]=array[min];
        array[min]=k;
    }
    public static void createHeapBig(int[] a, int s) {
        for(int i=(s-2)/2;i>=0;i--){
            shiftDownBig(a, i, s);
        }
    }

    public static void shiftDownBig(int[] array, int index, int size) {
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
//入队列
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
    //堆排序(升序用大堆，降序用小堆）
    public static void heapSort(int[] array){
        createHeapBig(array,array.length);
        for(int i=0;i<array.length-1;i++){
            // 无序 [0, array.length - i)
            // 有序 [array.length - i, array.length)
            swap(array, 0, array.length - i - 1);
            // 无序 [0, array.length - i - 1)
            // 长度 array.length - i - 1
            shiftDownBig(array,0,array.length-i-1);
        }
    }
}
