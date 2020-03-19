import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Text2 {
    //删除公共字符串
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        String str1=input.nextLine();
        String str2=input.nextLine();
        System.out.println(find(str1,str2));
    }
    public static String find(String str1,String str2){
        if(str2==null)return str1;
        List<Character> list=new ArrayList<>();
        for(int i=0;i<str2.length();i++){
            list.add(str2.charAt(i));
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<str1.length();i++){
            if(!list.contains(str1.charAt(i))){
                res.append(str1.charAt(i));
            }
        }
        return res.toString();
    }
}
