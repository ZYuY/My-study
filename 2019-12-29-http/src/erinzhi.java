import java.util.Scanner;

public class erinzhi {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String n=input.next();
        int sum=0;
        char[]arr=n.toCharArray();
        for(int i=0;i<arr.length;i++){
            sum+=(int)(arr[i]-'0')*Math.pow(2,arr.length-1-i) ;
        }
        System.out.println(sum);
    }
}
