import java.util.Scanner;

public class Text2 {
    //FJ的字符串
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        System.out.println(find(n));
    }

    private static String find(int n) {
        if(n==1)
            return "A";
        else{
            return find(n-1)+(char)(64+n)+find(n-1);
        }
    }
}
