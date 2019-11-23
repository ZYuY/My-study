class X{
    Y y=new Y();
    public X(){
        System.out.println("X");
    }
}
class Y{
    public Y(){
        System.out.println("Y");
    }
}
public class Test4  extends X{
    Y y=new Y();
    public Test4(){
        System.out.println("Z");
    }

    public static void main(String[] args) {
        new Test4();
    }
}
