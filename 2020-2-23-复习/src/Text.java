  class A{
    private abstract class B{
       abstract void x();
       abstract void a();
    }
    protected abstract class c extends B{
        void x(){
        }
    }
    final class W{
        int a=10;
        String as="122";
        String as2=new String("87");
        void A(){
            as="45";
        };
    }
}
public class Text {
    static class a{
        void s(){};

    }
    public static void main(String[] args) {
        final String a = "hello";
        String b = "hello";
        final String c = "world";
        String d = "hello" + "world";
        String e = a + c;
        String f = b + c;
        String g = "helloworld";
        System.out.println(g == d);//true
        System.out.println(g == e);//true
        System.out.println(g == f);//false
        System.out.println(f);
    }
}
