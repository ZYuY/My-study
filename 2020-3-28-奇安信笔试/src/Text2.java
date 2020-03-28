import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Text2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()) {
            String str = input.nextLine();
            String[] arr = str.split(",");
            if (cha(arr))
                find(arr);
            else
                System.out.println("no");
        }
    }
    public  static  boolean cha(String[]arr){
        List<String> list=new ArrayList<>();
        for(int i=0;i<9;i++){
            if(list.contains(arr[i]))
                return false;
            else
                list.add(arr[i]);
        }
        return true;
    }
    public  static  void  find(String[]arr){
        int sum1=0;
        int sum2=0;
        int sum3=Integer.valueOf(arr[0]);
        for(int i=0;i<=3;i++){
            sum1+=Integer.valueOf(arr[i]);
        }
        for(int j=3;j<=6;j++){
            sum2+=Integer.valueOf(arr[j]);
        }
        for(int k=6;k<=8;k++){
            sum3+=Integer.valueOf(arr[k]);
        }
        if(sum1==sum2&&sum2==sum3)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
