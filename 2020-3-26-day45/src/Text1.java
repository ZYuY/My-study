import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Text1 {
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            String str1=input.nextLine();
            String str2=input.nextLine();
            find(str1,str2);
        }
    }
    public static void find(String str1,String str2){
        if(str1==null||str2==null)
            System.out.println("No");
        StringBuilder build=new StringBuilder(str1);
        build.replace(0,1," ");
        System.out.println(build.toString());
    }
}
