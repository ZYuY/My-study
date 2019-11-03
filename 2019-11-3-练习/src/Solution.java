class ThreadDemo extends Thread {
    private boolean flag = true;

    public void setflag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {

            System.out.println("当前线程的状态" + Thread.currentThread().isInterrupted());
            System.out.println(Thread.interrupted());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            //System.out.println("当前线程的状态" + Thread.currentThread().isInterrupted());
        }

    }
}


public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread th1=new ThreadDemo();
        th1.start();
        Thread.sleep(1000);
        //((ThreadDemo) th1).setflag(false) ;
        //th1.stop();
        th1.interrupt();
    }
}
