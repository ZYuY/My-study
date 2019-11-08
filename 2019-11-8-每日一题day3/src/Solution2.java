class A{
    private int a=10;
    public static int b=2;
    A(int i){
        System.out.println("hehe");
    }
    void method1(){

    }
}

/**
 * new一个对象时，子类默认调用父类的无参构造方法
 * 如果父类有有参构造方法没有无参构造方法，
 * 则调用子类的构造方法，子类的有参构造方法必须在第一行调用super()关键字来调用父类的有参构造方法
 * 否则会出现编译错误。
 */
public class Solution2 extends A {
    Solution2(int i){
        super(i);
        System.out.println("hahha");
    }
    static int a=20;
    int b=10;
    public void meth(){
        meth3();
        a=a+1;
    }
    public static void meth3(){
        a=a+1;
    }
    public static void main(String[] args) {

        Solution th1=new Solution();
    }

}
