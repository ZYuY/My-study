/*class PerSon{
    public static int num;
    static{
        //静态代码块
        //System.out.println(num);
        System.out.println("3");
    }
    public PerSon(){
        System.out.println("1.person类的构造方法");
    }
    {
        //构造块
        System.out.println("2.person类的构造块");
    }
}*/
public class Test2 {
   /* public static void main(String[] args) {
        //int data=20;//（编译错误）
        {
            //普通代码块
            int data=10;
            System.out.println(data);
        }
        int data=20;
        System.out.println(data);

    }*/
   public Test2(){
       System.out.println("1.主类的构造方法");
   }
    {
        System.out.println("2，主类的构造块");
    }
   static{

       System.out.println("3.主类中的静态代码块");
   }
   public static void main(String[] args) {
       //new PerSon();
      // new PerSon();
       System.out.println("4，main方法开始");
       new Test2();
       new Test2();
       System.out.println("5.main结束");
  }
}
