import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class A extends Thread{
    @Override
    public void run() {
        System.out.println("nihao1");
    }
}
class B implements Runnable{
    @Override
    public void run() {
        System.out.println("你好2");
    }
}
class C implements Callable<Object>{
    @Override
    public Object call() {
        System.out.println("你好3");
        return null;
    }
}
public class Text2 {
    public static void main(String[] args) {
        Thread t1=new A();
        t1.start();
        Thread t2=new Thread(new B());
        t2.start();

        Callable<Object> c=new C();
        FutureTask<Object>f=new FutureTask<>(c);
        Thread d=new Thread(f);
        d.start();
    }
}
