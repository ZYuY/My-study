public class Join {
    /*
    private enum Week {
        MON, TUE, WED, THU, FRI, SAT, SUN
    }
    */

    private static class Printer张三 implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("张三");
                Thread.yield();
            }
        }
    }

    private static class Printer李四 implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("李四");
            }
        }
    }

    private static class MyThread extends Thread {
        /*
        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
         */
    }

    public static void main(String[] args) throws InterruptedException {
        /*
        for (Week week : Week.values()) {
            System.out.println(week);
        }
         */
        /*
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }
         */
        /*
        Thread thread = new MyThread();
        System.out.println(thread.getState());
        System.out.println("=========================");
        thread.start();
        while (thread.isAlive()) {
            System.out.println(thread.getState());
        }
        System.out.println("=========================");
        System.out.println(thread.getState());
        */
        // RUNNABLE 活着 TERMINATED

        Thread 张三 = new Thread(new Printer张三());
        Thread 李四 = new Thread(new Printer李四());
        张三.start();
        李四.start();
    }
}
