public class StaticMethod {
    private static int n=0;
    private static class MyThread extends Thread{
        @Override
        public void run() {
            for(int i=0;i<100000;i++){
                synchronized (StaticMethod.class){
                    n++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t=new MyThread();
        t.start();
        for (int i = 0; i < 100000; i++) {
            synchronized (StaticMethod.class) {
                n--;
            }
        }
        t.join();
        System.out.println(n);
    }
}
