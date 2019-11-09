public class SynchroniedDemo {
    /**
     * 调用锁的普通方法的引用指向的对象是同一个对象，抢的就是同一把锁
     * 调用静态方法：类里面的锁叫全局锁，类里面也有自己的对象在方法区中  类.class
     */
    public synchronized void method() {
        // 具体代码
        for (int i = 0; i < 100000; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
    public synchronized void method2() {
        // 具体代码
        for (int i = 0; i < 100000; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
    public synchronized static void staticMethod() {
        // 具体代码

    }

    public void block() {
        synchronized (this) {
            // 具体代码
        }
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                object.method2();
            }
        }
        private SynchroniedDemo object;
        MyThread(SynchroniedDemo object) {
            this.object = new SynchroniedDemo();
        }
    }

    public static void main(String[] args) {
        SynchroniedDemo object = new SynchroniedDemo();
        Thread t = new MyThread(object);
        t.start();
        while (true) {
            object.method();
        }
    }
}
