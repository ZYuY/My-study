class A{
    public static void a(int c){
        System.out.println("hehe");
    }
}
//class B extends A{
//    public  static  void a(int c){}
//}
public class Text2 extends A{
    public  static void  a(int c){
        System.out.println("haha");
    }
//静态方法可以被继承不能被重写
    public static void main(String[] args) {
        Text2 p=new Text2();
        p.a(1);
        A q=new Text2();
        q.a(2);
    }
//    static class A{
//        public  static  void e(int a){
//
//        }
//    }
//    static class B extends A{
//        public static void e(int a){
//
//        }
//    }
//
//    public static void main(String[] args) {
//        A a=new A();
//
//    }
//    public void p(){
//        A a=new A();
//        B b=new B();
//    }
//    public static void e(int a){
//
//    }
}
