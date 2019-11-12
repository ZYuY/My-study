import java.util.Scanner;

public class WaitDemo {
    public static Object object=new Object();
    private static class A extends Thread{
        public void  run(){
            for(int i=0;i<10;i++){
                System.out.println(i);
            }
            synchronized (object) {
                try {
                    object.wait();
                    /**
                     * 1.释放object中的锁
                     * 2. 把线程放到object对象的等待集中
                     * 3.把线程状态变为WAiTING
                     */
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 100; i < 110; i++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Thread a = new A();
        a.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("我不输入，A 线程就绝对不会动");
        scanner.nextLine();
        synchronized (object) {
            object.notify();
            /**
             * 1.把线程从等待集中取出
             * 2.把线程的状态变为RUNNABLE
             * 3.尝试重新抢object的锁
             */
        }
    }
}
