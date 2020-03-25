import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Text2 {
    //求n以内的质数
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        System.out.println(find(n));
    }
    public  static List<Integer> find(int n){
        List<Integer>list=new ArrayList<>();
        for(int i=2;i<=n;i++){
            int j;
            for(j=2;j<i;j++){
                if(i%j==0){
                    break;
                }
            }
            if(j>=i)
                list.add(i);
        }
        return list;
    }
}
