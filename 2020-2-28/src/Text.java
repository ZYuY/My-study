import User.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例模式
 */
// class Node{
//    private   Node(){}
//    private  static volatile Node node=null;
//    public static Node getNode(){
//        if(node==null){
//            synchronized (Node .class){
//                if(node==null){
//                    node=new Node();
//                }
//            }
//        }
//        return node;
//    }
//}
    class Base extends Exception{}
    class My extends Base{}
    class Mykey{
        private int key;
        public  Mykey(int key){
            this.key=key;
        }
    }
    class HelloA{
        public HelloA(){

            System.out.println("helloa");
        }
        {
            System.out.println("a.class");
        }
        static{
            System.out.println("sattic a");
        }
    }
    class HelloB extends HelloA {
        public HelloB (){
            System.out.println("hellob");
        }
        {
            System.out.println("b.class");
        }
        static {
            System.out.println("static b");
        }
    }
class Other{
    public  int i;
}
interface  A{
        int play=0;
        void p();
}
public class Text  implements A{
        public void set(int play){
            //this.play=play;
            /**
             * final类型无法再次赋值
             */
        }
    @Override
    public void p() {
        System.out.println("hhs");
    }
    //    public Text() {
//    }
//
//    /**
//     *
//     */
//    public static void main(String[] args) {
//        String a=new String ("acD");
//        a=a.toUpperCase() ;
//        a+="3.0";
//        System.out.println(a);
//
//    }
//
    //public static void main(String[] args) {
    //    Thread t=new Thread(){
    //        @Override
    //        public void run() {
    //            pong();
    //        }
    //    };
    //    t.run();
    //    System.out.println("ping");
    //}
    //static void pong(){
    //    System.out.println("pong");
    //}

//    public static void main(String[] args)throws  Exception {
//        try{
//            try{
//                throw new My();
//            }
//            catch (My e){
//                System.out.println("hehe");
//                Base newe=(Base)e;
//                throw newe;
//            }
//        }
//        catch (My e){
//            System.out.println("hahah");
//            return;
//        }
//        catch (Base e){
//            System.out.println("gun");
//            return;
//        }
//        finally {
//            System.out.println("fin ");
//        }
   // }
//public static void main(String[] args) {
//    Map<Mykey,Integer> map=new HashMap<>();
//    map.put(new Mykey(1),1);
//    map.put(new Mykey(2),2);
//    Integer value=map.get(new Mykey(1));
//    System.out.println(value);
//}
//public static void main(String[] args) {
//    new HelloB();
//}

//public static void main(String[] args) {
//    Other o=new Other();
//    new Text().addone(o);
//    System.out.println(o);
//}

    /**
     * final修饰基本类型参数，不能修改
     * final修饰引用类型，不能修改引用的对象
     * @param o
     */
    public void addone(final Other o){
    o.i++;
    System.out.println(o.i);
}

//    public static void main(String[] args) {
//        Text a=new Text();
//        System.out.println("hhe"+a.toString());
//    }
//    public String toString(){
//        return "hahah";
//    }
public static void main(String[] args) {
    User user1 = new User();
    User user2 = new User();
    user1.setUsername("zhangsan");
    user2=user1;
    user2.setUsername("lisi");
    System.out.println(user1.getUsername());
}
}
