/*class Outter{
    private String msg="outter中的msg";
    public String getMsg(){
        return msg;
    }
    public void test(){
        Inner in=new Inner(this);
        in.fun();
    }
}

class Inner{
    private Outter out;
    public Inner(Outter out){
        this.out=out;
    }
    public void fun(){
        System.out.println(out.getMsg());
    }
}*/
class Outter{
    private String msg="teat";
    class Inner{
        public void fun(){
            System.out.println(msg);
        }
    }
    public void test(){
        Inner in=new Inner();
        in.fun();
    }
}
public class Test4 {
    public static void main(String[] args) {
        Outter out=new Outter();
        out.test();
    }
}
