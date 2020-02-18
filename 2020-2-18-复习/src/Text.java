import java.util.Arrays;

public class Text {
    /**
     *
     *
     *
     */
    //插入排序
    public static void insertSort(int[]arr){
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            for(;j>=0&&key<arr[i];j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=key;
        }
    }

    //选择排序
    public static void selectSort(int[]arr){
        for(int i=0;i<arr.length-1;i++){
            int maxindex=i;
            int j=i+1;
            for(;j<arr.length;j++){
                if(arr[j]>arr[maxindex])
                    maxindex=j;
            }
            swap(arr,i,maxindex);
        }
    }

    private static void swap(int[] arr, int i, int maxindex) {
        int k=arr[i];
        arr[i]=arr[maxindex];
        arr[maxindex]=k;
    }

    public static void main(String[] args) {
        int[]a={2,5,1,7,5,3,8};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }

    //快速排序

}
