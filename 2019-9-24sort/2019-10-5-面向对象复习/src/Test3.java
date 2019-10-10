final class Persons{
    //public final int a=5;//对象加载才有
    //public static final int b=10;//全局数据区，只有一个
    public String name="张三";
    public int age=0;
}

class Pers{

}
class Student extends Pers{

}
//(编译错误）public class Test3 extends Persons
public class Test3{
    byte b1=2,b2=3,b3,b6,b8;
    final byte b4=4,b5=5,b7=10;
    //byte,int,short,char都会转换成int,final修饰的域类型不会改变
    public void Test3(){
       //b3=b1+b2;//编译错误，右边是int
        b6=b4+b7;//对，
       // b4=b2+b5;//错
       // b6=b4+b1;//错
    }
    public static void main(String[] args) {
        //final int a=3;
        //static int b=2;(编译错误）
         final Persons p=new Persons();
         p.name="李四";
         p.age=10;
        System.out.println(p.name+p.age);
        //p=new Persons();(编译错误）
        Pers per=new Pers();
        System.out.println(per instanceof Pers);
        if(!(per instanceof Pers)){
            //向上转型
            per=new Student();
            System.out.println(per instanceof Student);
        }
        //向上转型
        test(new Pers());
        test(new Student());

    }
    //参数统一化
    public static void test(Pers per){

    }
}
