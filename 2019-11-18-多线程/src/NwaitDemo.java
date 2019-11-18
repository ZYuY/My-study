public class NwaitDemo {
    private static Object object = new Object();
    private static int n = 0;
    private static class A extends Thread{
        A(){
            super("n--");
        }
        @Override
        public void run() {
            while(true){
                synchronized (object){
                    if(n==0){
                        synchronized (object){
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    n--;
                    System.out.println(getName()+":"+n);
                    object.notify();
                }
            }
        }
    }
    private static class B extends Thread{
        B(){
            super("n++");
        }
        @Override
        public void run() {
            while(true){
                synchronized (object){

                    if(n==10){
                        synchronized (object){
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    //因为锁还没释放，所以放上面也是可以的
                    // object.notify();
                    n++;
                    System.out.println(getName()+":"+n);
                    object.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread a=new A();
        Thread b=new B();
        a.start();
        b.start();
    }
}
