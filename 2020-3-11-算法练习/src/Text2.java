import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Text2 {
//    public static void main(String[] args) {
//        int i=2;
//        int b=(i++)+(i++)+(i++);
//        System.out.println(b);
//    }
    //删除字符串
public static void main(String[] args) {
    Scanner input=new Scanner(System.in);
    while(input.hasNext()){
        String arr=input.nextLine();
        Find(arr);
    }
}

    private static void Find(String arr) {
    arr+='$';
    char[]str=arr.toCharArray();
    String result="";
    int count=0;
    for(int i=0;i<str.length-1;i++){
        if(str[i]==str[i+1])
            count++;
        else{
            if(count==0)
                result+=str[i];
            else
                count=0;
        }
    }
    if(result=="")
        System.out.println("no");
    else
        System.out.println(result);
    }
}
