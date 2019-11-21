import java.util.Scanner;

public class Text2 {
    //尼科彻斯定理
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()) {
            int m = input.nextInt();
            System.out.println(get(m));
        }
    }

    private static String get(int m) {
        int[]arr=new int[m];
        arr[0]=m*(m-1)+1;
        for(int i=1;i<arr.length;i++){
            arr[i]=arr[i-1]+2;
        }
        String str="";
        str=str+arr[0];
        for(int i=1;i<arr.length;i++){
            str+="+"+arr[i];
        }
        return str;
    }
}
