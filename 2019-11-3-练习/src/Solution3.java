class Demo extends Thread{
    /**
     * 锁
     */
    private int ticket;
    public Demo(int ticket) {
        this.ticket=ticket;
    }
    public Demo(){

    }

    @Override
    public void run() {
        //条件处只能在某一时刻只有一个线程，需要为程序段上锁
   for(int i=0;i<100;i++){
//            //需要在判断出上锁
//            synchronized (this){
//                //在任意时刻只有一个线程能进入条件判断
//            if(ticket>0) {
                try {
                    //不加锁时当ticket为1时，三个线程进来都睡眠
                    //线程1
                    //线程2
                    //线程3
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                //不加锁时1----1
//                //2----0
//                //3------  -1
//                System.out.println(Thread.currentThread().getName() +"还剩下" + ticket-- + "票");
//            }
//            }

       sell();
        }
    }
    //在任意时刻只能有一个线程进入此方法
    public synchronized void sell() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "还剩下" + ticket-- + "票");
        }
    }
}
public class Solution3 {
    public static void main(String[] args) {
        Demo a=new Demo(100);
        Thread th1=new Thread(a,"A");
        Thread th2=new Thread(a,"B");
        Thread th3=new Thread(a,"C");
        th1.start();
        th2.start();
        th3.start();
    }
}
