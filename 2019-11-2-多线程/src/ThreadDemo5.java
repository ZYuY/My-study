public class ThreadDemo5 {
    private static class Mythread extends Thread{
        private int n=0;
        @Override
        public void run() {
            while(n<60){
                System.out.println(n);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n++;
            }
        }
    }

    public static void main(String[] args) {
//        Thread th1=new Mythread();
//        th1.start();
//        Thread th2=new Mythread();
//        th2.start();
//        Thread th3=new Thread(new Mythread());
//        Thread th4=new Thread(new Mythread());
//        th3.start();
//        th4.start();
        Mythread a=new Mythread();
        Thread th5=new Thread(a);
        Thread th6=new Thread(a);
        th5.start();
        th6.start();
    }
}
