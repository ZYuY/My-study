import java.util.Scanner;

public class Text3 {
    //句子逆序
    public static void main(String []args){
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        System.out.println(find(str).trim());
    }
    public static String find(String str){
        if(str==null||str.length()==0)return null;
        String[]arr=str.split(" ");
        StringBuilder res=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            res.append(arr[i]).append(" ");
        }
        return res.toString();
    }
}
