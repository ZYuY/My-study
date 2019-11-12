class Person{
    //饿汉
    private Person(){}
    private static Person person=new Person();
    public static Person getInstance(){
        return person;
    }
}
class Lazy{
    //懒汉
    private Lazy(){}
    private static Lazy lazy=null;
    public synchronized Lazy getInstance(){
        //有人需要时才初始化
        if(lazy==null) {
            lazy = new Lazy();
        }
        return lazy;
    }

}
class Anquan{
    //安全模式

    /**
     * 为什么要二次判断anquan==null
     * 为的什么要加volatile关键字
     * 因为new不能保证代码重排序
     */
    private Anquan(){}
    private static volatile Anquan anquan=null;
    public static Anquan getInstance(){
        if(anquan==null){
            //A B C
            synchronized (Anquan.class) {
                if(anquan==null) {
                    anquan = new Anquan();
                }
            }
        }
        return anquan;
    }
}

public class Test {

}
