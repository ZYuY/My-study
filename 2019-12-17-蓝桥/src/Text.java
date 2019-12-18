import java.util.Scanner;

public class Text {
    /**
     * 时间转换
     * @param args
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int t=input.nextInt();
        if(t/3600<=0)
            System.out.print("0"+":");
        else{
            System.out.print(t/3600+":");
        }
        if((t%3600)/60<=0){
            System.out.print("0"+":");
        }else{
            System.out.print((t%3600)/60+":");
        }
        System.out.print((t%3600)%60);
    }
}
