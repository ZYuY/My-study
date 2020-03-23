class A extends Thread{
    @Override
    public void run() {
        System.out.println("我是A线程");
    }
}
class B extends Thread{
    @Override
    public void run() {
        System.out.println("我是B线程");
    }
}
class C implements Runnable{
    @Override
    public void run() {
        System.out.println("我是c线程");
    }
}
public class Text1 {
    public static void main(String[] args) {
        A a=new A();
        B b=new B();
        a.start();
        b.start();
        Thread c=new A();
        c.start();
        Thread d=new Thread(new C());
        d.start();
        Runnable e=new C();
        Runnable w=new A();
        Thread r=new A();

        Thread f=new Thread(e);
        f.start();
        System.out.println("我是main线程");
    }
}
