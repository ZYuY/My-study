class A{
    static int q=2;
    static int method(){
       return 0;
    }
}
public class Test2 {
    public static void main(String[] args) {
        A a=new A();
        A b=null;
        System.out.println(a.q);
        System.out.println(b.method());
    }
}
