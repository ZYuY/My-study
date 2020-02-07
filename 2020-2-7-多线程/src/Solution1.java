import java.util.concurrent.SynchronousQueue;

public class Solution1 {
    public static void main(String[] args)throws  InterruptedException {
        Object o=new Object();
        synchronized(o){
            System.out.println("等待中");
            o.wait();
            System.out.println("等待已过");
        }
        o.notify();
        System.out.println("main方法结束");
    }
}
