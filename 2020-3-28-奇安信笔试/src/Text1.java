import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Text1 {
//    public static void main(String[] args) {
//        Scanner input=new Scanner(System.in);
//        int n=input.nextInt();
//        System.out.println(find(n));
//    }
//    public  static  int find(int n){
//        switch (n){
//            case 2: return 5;
//            case 3: return 8;
//            case 4:return 8;
//            case 5:return 11;
//            case 6: return 11;
//            case  7:return 13;
//            case 8:return 13;
//            case 9:return 13;
//            case 10:return 15;
//            case 11:return 15;
//            case 12:return 17;
//            case 13:return 17;
//            case 14:return 17;
//        }
//        return 0;
//    }
public static void main(String[] args) {
    Scanner input=new Scanner(System.in);
    int[]arr=new int[9];
    while(input.hasNext()){
        for(int i=0;i<9;i++) {
            arr[i] = input.nextInt();
        }
        if(cha(arr))
            find(arr);
        else
            System.out.println("no");
    }
}
public  static  boolean cha(int[]arr){
    List<Integer>list=new ArrayList<>();
    for(int i=0;i<9;i++){
        if(list.contains(arr[i]))
            return false;
        else
            list.add(arr[i]);
    }
    return true;
}
public  static  void  find(int[]arr){
    int sum1=0;
    int sum2=0;
    int sum3=arr[0];
    for(int i=0;i<=3;i++){
        sum1+=arr[i];
    }
    for(int j=3;j<=6;j++){
        sum2+=arr[j];
    }
    for(int k=6;k<=8;k++){
        sum3+=arr[k];
    }
    if(sum1==sum2&&sum2==sum3)
        System.out.println("yes");
    else
        System.out.println("no");
}
}
