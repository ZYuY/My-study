public class OneTwoThree {
    private static class Foo {
        private int n=0;
        public void one() throws InterruptedException {
//            synchronized (this) {
//                if (n != 0)
//                    return;
//                n = 1;
//                System.out.println("one");
//            }
            if(n!=0){
                synchronized (this){
                    wait();
                }
                return;
            }
            System.out.println("one");
            n=1;
            synchronized (this){
                notifyAll();
            }
        }

        public void two() throws InterruptedException {
//            synchronized (this) {
//                if (n != 1)
//                    return;
//                n = 2;
//                System.out.println("two");
//            }
            if(n!=1){
                synchronized (this){
                    wait();
                }
                return;
            }
            System.out.println("two");
            n=2;
            synchronized (this){
                notifyAll();
            }
        }

        public void three()
        {
            synchronized (this) {
                if (n != 2)
                    return;
                n = 0;
                System.out.println("three");
            }
        }
    }

    private static Foo foo = new Foo();

    private static class OneThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    foo.one();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class TwoThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    foo.two();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ThreeThread extends Thread {
        @Override
        public void run() {
            while (true) {
                foo.three();
            }
        }
    }

    public static void main(String[] args) {
        Thread one = new OneThread();
        Thread two = new TwoThread();
        Thread three = new ThreeThread();
        one.start();
        two.start();
        three.start();
    }
}
