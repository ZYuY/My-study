class T{
     String a="hehe";
    T(){
        name();
    }
    public  void name(){
        System.out.println(a);
    }
}
public class Text2 extends T{
    String a="haha";
    public  void name(){
        System.out.println(a);
    }
//    public static void main(String[] args) {
//        StringBuffer a=new StringBuffer("A");
//        StringBuffer b=new StringBuffer("B");
//        paw(a,b);
//        System.out.println(a+"."+b);
//    }
//
//    private static void paw(StringBuffer a, StringBuffer b) {
//        a.append(b);
//        b=a;
//    }
//    public static void hello(){
//        System.out.println("hello");
//    }
//      public static void main(String[] args) {
//    Text2 text=null;
//    text.hello();
//    }
      public static void main(String[] args) {
        Text2 t=new Text2();

      }
}
