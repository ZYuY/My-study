import java.util.Scanner;

public class Text4 {
    //连续最大和
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int max=Integer.MIN_VALUE,temp=0;
            for(int i=0;i<n;i++){
                temp+=sc.nextInt();
                if(temp>max)
                    max=temp;
                if(temp<=0)
                    temp=0;
            }
            System.out.println(max);
        }
    }

}
