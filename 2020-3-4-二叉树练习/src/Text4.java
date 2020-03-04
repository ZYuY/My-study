import java.util.Arrays;

public class Text4 {
    public static void sort(int[]arr){
        quick(arr,0,arr.length-1);
    }

    private static void quick(int[] arr, int left, int right) {
        if(left>=right) return;
        int k=protection(arr,left,right);
        quick(arr,left,k-1);
        quick(arr,k+1,right);
    }

    public  static int protection(int[] arr, int left, int right) {
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

    public static void main(String[] args) {
        int[]arr={3,5,2,7,2,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
