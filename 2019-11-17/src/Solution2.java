import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
     long count=0;
     for(long i=1;i<=n;i++){
         if(find(i)){
             count++;
         }
     }
        System.out.println(count);
    }

    private static boolean find(long i) {
        while(i!=0){
            if(i%10==2){
                return false;
            }
            i=i/10;
        }
        return true;
    }

}

