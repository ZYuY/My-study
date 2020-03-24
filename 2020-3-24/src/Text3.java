import java.util.Scanner;

public class Text3 {
    //骆驼命名法
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            String str=input.nextLine();
            System.out.println(find(str));
        }
    }
    public static String find(String str){
        String newstr="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='_'){
                newstr+=" ";
                newstr+=(char)(str.charAt(i+1)-32);
                i++;
            }else{
                newstr+=str.charAt(i);
            }
        }
        String[]arr=newstr.split(" ");
        String res="";
        for(int i=0;i<arr.length;i++){
            res+=arr[i];
        }
        return res;
    }
}
