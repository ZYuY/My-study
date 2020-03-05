import java.util.Arrays;
import java.util.Scanner;

public class Text {

//密码验证合格程序
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            String arr=input.nextLine();
            boolean result=Find(arr);
            if(result){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }
    public static boolean Find(String arr){
        if(arr==""||arr.length()<=8){
            return false;
        }
        int[]flag=new int[4];
        char[]str=arr.toCharArray();
        for(int i=0;i<str.length;i++){
            if(str[i]>='0'&&str[i]<='9'){
                flag[0]=1;
                continue;
            }else if(str[i]>='A'&&str[i]<='Z'){
                flag[1]=1;
                continue;
            }else if(str[i]>='a'&&str[i]<='z'){
                flag[2]=1;
                continue;
            }else{
                flag[3]=1;
                continue;
            }
        }
        if( flag[0]+flag[1]+flag[2]+flag[3]<3){
            return false;
        }
        //不能有长度超2的重复子串
        for(int i=0;i<str.length-2;i++){
            String res=arr.substring(i,i+3);
            if(arr.substring(i+1).contains(res)){
                return false;
            }
        }
        return true;
    }
}
