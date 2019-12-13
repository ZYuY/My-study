import java.util.Scanner;

public class Text2 {
    /**
     * sin之舞
     * @param args
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        S(n);
    }
    public static StringBuffer S(int n){
        String str="";
        for(int i=1;i<n;i++)
            str+="(";
        for(int i=1,j=n;i<=n;i++,j--){
            str=str+A(i)+"+"+j+")";
        }
        StringBuffer str2=new StringBuffer(str);
        str2.deleteCharAt(str2.length()-1);
        return str2;
    }
    public static StringBuffer A(int i){
        String str="";
        for(int t=1;t<=i;t++){
            if(t%2!=0)
                str=str+"+"+"sin("+t;
            else
                str=str+"-"+"sin("+t;
        }
        for(int t=1;t<=i;t++){
            str=str+")";
        }
        StringBuffer str2=new StringBuffer(str);
        str2.deleteCharAt(0);
        return str2;
    }
}
