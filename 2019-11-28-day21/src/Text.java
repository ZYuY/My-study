import java.util.Scanner;

public class Text {
    //最难的问题
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            String arr=input.nextLine();
            String[]arr2=arr.split(" ");
            for(int i=0;i<arr2.length;i++) {
                System.out.print(find(arr2[i])+" ");
            }
            System.out.println();
        }
    }

    private static String find(String arr) {
        char[]str=arr.toCharArray();
        String result="";
        for(int i=0;i<str.length;i++){
           char a=(char)(str[i]-5);
           if(a<'A'){
               a=(char)(a+26);
           }
            result=result+a;
        }
        return result;
    }
}
