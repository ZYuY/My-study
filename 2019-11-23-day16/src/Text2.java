import java.util.Scanner;
public class Text2 {
    //统计同成绩学生人数
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int n=input.nextInt();
            if(n==0){
                return;
            }
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=input.nextInt();
            }
            int grade=input.nextInt();
            int count=0;
            for(int i=0;i<n;i++){
                if(arr[i]==grade){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
