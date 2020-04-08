import java.util.Scanner;
import java.util.function.ObjIntConsumer;

public class usewait {
    static Object o=new Object();
    static class user extends  Thread{
        @Override
        public void run() {
            for(int i=0;i<100;i++) {
                if (i == 30) {
                    synchronized (o) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else
                    System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        user u=new user();
        u.start();
        System.out.println("输入");
        Scanner input=new Scanner(System.in);
        input.nextLine();
        synchronized (o){
            o.notify();
        }
    }
}
