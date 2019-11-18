public class ehan {
//饿汉
//    private ehan(){}
//    private static ehan e=new ehan();
//    public static ehan getInstance(){
//        return e;
//    }
    //懒汉
    private ehan(){}
    private static ehan e=null;
    public static ehan getInstance(){
        if(e==null){
            e=new ehan();
        }
        return e;
    }
}
