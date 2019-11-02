public class Threaddemo1 {
  private static  class Mythread extends Thread{
        public void run(){
            while(true){
                System.out.println("执行method2方法");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    public static void method2(){
        Thread a=new Mythread();
        a.start();
    }
    public static void method1() throws InterruptedException {
        while(true){
            System.out.println("执行method1方法");
            Thread.sleep(1000);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        method2();
        while(true){
            System.out.println("执行method1方法");
            Thread.sleep(1000);
        }
    }
}
