import java.util.Scanner;

public class Text3 {
    /**
     * 分解质因数
     * @param args
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        for(int i=a;i<=b;i++){
            if(isPrime(i)){
                System.out.println(i+"="+i);
            }else{
                System.out.print(i+"=");
                primeFactor(i);
            }
        }
    }

    private static void primeFactor(int k) {
        if(isPrime(k)){
            System.out.println(k);
        }
        for(int i=2;i<k;i++){
            if(k%i==0){
                System.out.print(i+"*");
                primeFactor(k/i);
                break;
            }
        }
    }

    private static boolean isPrime(int a) {
        for(int i=2;i<a;i++){
            if(a%i==0)
                return false;
        }
        return true;
    }
}
