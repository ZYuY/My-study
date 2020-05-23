public class Lanhan {
    private Lanhan(){}
    private static volatile Lanhan test=null;
    public static Lanhan getInstance(){
        if(test==null) {//只有为空的时候才会出现互斥
            synchronized (Lanhan.class) {
                if (test == null)//因为加锁了会导致判断条件发生变化
                    test = new Lanhan();//会出现代码重排序的问题
            }
        }
                return test;
    }

    public static void main(String[] args) {
        Lanhan l=Lanhan.getInstance();
    }
}
