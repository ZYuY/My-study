import java.lang.Thread ;
import java.util.concurrent.Callable;

//继承Thread类
//class MyThread extends Thread{
//    int title=20;
//    String a;
//    public MyThread(String a) {
//        this.a=a;
//    }
//    //每个线程都需要执行的任务
//    public void run(){
//        while(title>0){
//            System.out.println("当前进程"+a+"还剩下"+title--+"票");
//        }
//    }
//}
//实现Runnable接口
class My implements Runnable {
    int title = 20;
        String a;
//    public My(String a) {
//        this.a=a;
//    }
    //每个线程都需要执行的任务
    public void run(){
        while(title>0){
            System.out.println("当前进程"+Thread.currentThread().getName() +"还剩下"+title--+"票");
        }
    }
}
class mythread implements Callable <String>{

    @Override
    public String  call() throws Exception {
        return null;
    }
}
public class Text1 {
    public static void main(String[] args) {
//        MyThread mt1=new MyThread("A");
//        MyThread mt2=new MyThread("B");
//        mt1.start();
//        mt2.start();
//
        My a1=new My();
        //My a2=new My("B");
        Thread aa1=new Thread(a1);
        Thread aa2=new Thread(a1);
        //Thread aa2=new Thread(a2);
        aa1.start();
        aa2.start();

    }
}
