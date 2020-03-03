import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.sort;

public class Text2 {
    /**
     * 折纸问题

   static  StringBuffer p=new StringBuffer();
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int n=input.nextInt();
            Find(1,n,true);
            System.out.println(p.toString());
        }
    }

    private static void Find(int i,int n,boolean down) {
        if(i>n)return ;
        Find(i+1,n,true);
        p.append(down?"down":"up").append("\n");
        Find(i+1,n,false);
    }*/

//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        StringBuilder sb = new StringBuilder();
//        printAllFolds(1, x, true, sb);
//        System.out.print(sb.toString());
//    }
//    public static void printAllFolds(int i, int x, boolean down, StringBuilder sb){
//        if(i>x){return;}
//        printAllFolds(i+1, x, true, sb);
//        sb.append(down?"down":"up").append("\n");
//        printAllFolds(i+1, x, false, sb);
//    }
    /**
     * 排序
     */
    public static void insert(int[]arr){
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            for(;j>=0&&key<arr[j];j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=key;
        }
    }

    public static void select(int[]arr){
        for(int i=0;i<arr.length-1;i++){
            int maxindex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[maxindex])
                    maxindex=j;
            }
            int k=arr[maxindex];
            arr[maxindex]=arr[i];
            arr[i]=k;
        }
    }

    //快速排序
    public static void fastSort(int[]arr){
        Sort(arr,0,arr.length-1);
    }

    private static void Sort(int[] arr, int left, int right) {
        if(left>=right)return;
        int index=partition(arr,left,right);
        Sort(arr,left,index-1);
        Sort(arr,index+1,right);
    }

    private static int partition(int[] arr, int left, int right) {
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

    private static void swap(int i, int k) {
        int p=i;
        i=k;
        k=p;
    }

    public static void main(String[] args) {
        int arr[]={1,5,3,7,9,2,3};
        fastSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
