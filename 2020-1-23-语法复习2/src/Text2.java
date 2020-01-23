import java.util.Arrays;

public class Text2 {
    //冒泡排序
    public static void main(String[] args) {
        int []arr={4,6,2,7};
        find(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void find(int[]arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int k=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=k;
                }
            }
        }
    }
}
