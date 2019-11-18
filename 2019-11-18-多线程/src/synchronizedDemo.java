public class synchronizedDemo {
    /**
     * 静态方法加锁  加的是类的锁 同一个对象抢的是同一把锁
     * 抢锁必然先抢cpu
     * volatile没有原子性问题
     */
    public synchronized void method(){
        for(int i=0;i<100000;i++){
            System.out.println(Thread.currentThread().getName()+" :"+i);
        }
    }
    public synchronized void method2() {
        for (long i = 0; i < 100000; i++) {
            System.out.println("Method2:" + Thread.currentThread().getName() + ": " + i);
        }
    }
    private static class Mythread extends Thread{
        private synchronizedDemo object;
        Mythread(synchronizedDemo object){

            this.object=new synchronizedDemo();
        }
        @Override
        public void run() {
            while(true){
                object.method();
            }
        }
    }

    public static void main(String[] args) {
        synchronizedDemo object = new synchronizedDemo();
        Thread t = new Mythread(object);
        t.start();
        while (true) {
            object.method2();
        }
    }
}
