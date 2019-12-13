import java.util.Scanner;

public class Text {
    //字符串对比
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str1=input.nextLine();
        String str2=input.nextLine();
        int len1=str1.length();
        int len2=str2.length();
       int k=find(str1,len1,str2,len2);
        System.out.println(k);
    }

    private static int find(String str1, int len1, String str2, int len2) {
        if(len1!=len2){
            return 1;
        }
        else if(str1.equals(str2)){
            return 2;
        }
        else if(str1.equalsIgnoreCase(str2)){
            return 3;
        }
        return 4;
    }
}
