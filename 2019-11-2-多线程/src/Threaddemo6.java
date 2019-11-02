public class Threaddemo6 {
    private static class Sum1 extends Thread{
        int n=1;
        long sum=0;
        @Override
        public void run() {
            while(n<=1000000){
                sum+=n;
                n++;
            }
            System.out.println(sum);
        }
    }
    private static class Sumjishu extends Thread{
        int n=1;
        long sum=0;
        @Override
        public void run() {
            while(n<=1000001){
                sum+=n;
                n+=2;
            }
            System.out.println(sum);
        }
    }
    private static class Sumoushu extends Thread{
        int n=1;
        long sum=0;
        @Override
        public void run() {
            while(n<=1000000){
                sum+=n*n;
                n+=2;
            }
            System.out.println(sum);
        }
    }
    public static void Sumjishu2(){
        int n=1;
        int sum=0;
        while(n<=1000000){
            sum+=n;
            n+=2;
        }
        System.out.println(sum);
    }
    public static void sum(){
        int n=1;
        int sum=0;
        while(n<=1000000){
            sum+=n;
            n++;
        }
        System.out.println(sum);

    }
    public static void main(String[] args) throws InterruptedException {
        long begin=System.currentTimeMillis() ;
        Thread th1=new Sum1();
        Thread th2=new Sumjishu();
        Thread th3=new Sumoushu();
        th1.start();
        th2.start();
        th3.start();
        th1.join();
        long end=System.currentTimeMillis() ;
    }
}
