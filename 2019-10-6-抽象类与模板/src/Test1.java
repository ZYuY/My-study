interface MyInterface{
    void test();
}
class Outter{
    private int age=5;
    public static void display(int num){
        //方法内部类
        class Inner{

        }
        //匿名内部类
        new MyInterface(){
            public void test(){

            }
        }.test();
    }

}
abstract class Person{
   public  abstract void test();//抽象方法
    public native void test1();//本地方法
    public Person(){
        System.out.println("1*******");
    }
}
class Student extends Person{
    public Student(){
        System.out.println("2#############");
    }
    @Override
    public void test() {
        System.out.println("子类覆写抽象方法");
    }
}
//经典笔试题
abstract class A{
    public A(){
        this.print();
    }
    public abstract void print();
}
class B extends A{
private int num=100;
    public B(int num){
        this.num=num;
    }
    public void print() {
        System.out.println(this.num);//还没有开辟空间
    }
}
public class Test1 {
    public static void main(String[] args) {
        //Person per=new Person();抽象类不能直接创建实例化对象
        //Person per=new Student();
        //per.test();
        new B(30);//0
        new B(30).print();//0   30
    }
}
