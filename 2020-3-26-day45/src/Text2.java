import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Node{
    int id;
    String name;
    int parentId;
}
public class Text2 {
//    public static List<List<List<String>>> find(List<Node>){
//        List<List<List<String>>>list=new ArrayList<>();
//        for(int i=0;i<list.size();i++){
//            list.add(new ArrayList<>());
//
//        }
//    }
    public static void quickSort(int []arr){
        quick(arr,0,arr.length-1);
    }

    private static void quick(int[] arr, int left, int right) {
        if(left>=right)return;
        int index=protection(arr,left,right);
        quick(arr,0,index-1);
        quick(arr,index+1,right);
    }

    private static int protection(int[] arr, int left, int right) {
        int i=left;
        int j=right;
        int key=arr[left];
        while(i<j){
            while(i<j&&arr[j]>=key)
                j--;
            arr[i]=arr[j];
            while(i<j&&arr[i]<=key)
                i++;
            arr[j]=arr[i];
        }
        arr[i]=key;
        return i;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=input.nextInt();
        }
        quickSort(arr) ;
        System.out.println(Arrays.toString(arr));
    }
    public static void res(String name,String id ,int money){
        //id studentid name course fenshu
        //select studentid,id from (select studentid,id from student group by studentid) group by course having fenshu>80;
    }
    //yum show tomcat
}
