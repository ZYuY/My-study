public class MyQueue {
    private int[]arr=new int[10];
    //private int size=0;
    private volatile int size=0;
    private int front=0;
    private int rear=0;
    private Object empty=new Object();
    private Object full=new Object();
    public synchronized void put(int message) throws InterruptedException {
        while(size == arr.length) {
            wait();
        }
        arr[rear] = message;
        rear = (rear + 1) % arr.length;
        size++;
        notifyAll();
    }
    public synchronized int take() throws InterruptedException {
        while(size == 0) {
            wait();
        }
        int message = arr[front];
        front = (front + 1) % arr.length;
        size--;
        // 消费者必须唤醒一个生产者，但如果只是调用 notify
        // 不保证唤醒的是生产者
        notifyAll();
        return message;
    }
    public  synchronized void put2(int message) throws InterruptedException {
        while(size == arr.length) {
            synchronized (full){
                full.wait();
            }
        }
        synchronized (this) {
            arr[rear] = message;
            rear = (rear + 1) % arr.length;
            size++;
        }
        synchronized (empty){
            empty.notify();
        }
    }
    public synchronized int take2() throws InterruptedException {
        while(size == 0) {
            synchronized (empty){
                empty.wait();
            }
        }
        int message;
        synchronized (this) {
             message = arr[front];
            front = (front + 1) % arr.length;
            size--;
        }
        // 消费者必须唤醒一个生产者，但如果只是调用 notify
        // 不保证唤醒的是生产者
        synchronized (full){
            full.notify();
        }
        return message;
    }
    private static MyQueue queue = new MyQueue();
    private static class Producer extends Thread {
        @Override
        public void run() {
            synchronized (this) {
            }
            for (int i = 0; i < 100; i++) {
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Customer extends Thread {
        @Override
        public void run() {
            while (true) {
                int message = 0;
                try {
                    message = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(message);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Producer();
        Thread t2 = new Producer();
        Thread t3 = new Customer();
        t1.start();
        t2.start();
        t3.start();
    }
}
