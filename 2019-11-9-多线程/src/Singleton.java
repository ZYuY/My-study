public class Singleton {
    /**
     * 懒汉单例  单线程正确  多线程不安全  需要保证原子性，可见性
     */
    private Singleton(){}
    private volatile static Singleton instance=null;
    public static  Singleton getinstnce(){
        if (instance == null) {
            /**
             * 为什么要二次判断？
             * 如果A,B,C刚开始都为空，A进来加锁，A创建好后，B又加锁，又创建了对象，又是C进来继续加锁创建
             * 所以必须二次判断 保证
             * 为什么要加volatile
             * 因为创建对象需要三部1.new  2.初始化  3.赋值
             * 可是创建对象会出现重排序问题  可能先是1 下来3 下来2 所以需要volatile保证可见性
             */
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /**
     * 饿汉
     * @param args
     */
//    private Singleton(){}
//    private static Singleton instance=new Singleton();
//    public static  Singleton getinstnce(){
//        return instance;
//    }

    public static void main(String[] args) {

    }
}
