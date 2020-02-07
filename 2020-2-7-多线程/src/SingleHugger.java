public class SingleHugger {
   /** //饿汉模式
    private SingleHugger(){
    }
    private static SingleHugger insert=new SingleHugger();
    public static SingleHugger getInstance(){
        return insert;
    }**/
   /**懒汉模式1
    private SingleHugger(){}
    private static SingleHugger insert=null;
    public static SingleHugger getInsert(){
        if(insert==null){
            insert=new SingleHugger();
        }
        return insert;
    }**/
   /**懒汉模式2
   private SingleHugger(){}
    private static SingleHugger insert=null;
    public synchronized static SingleHugger getInsert(){
        if(insert==null){
            insert=new SingleHugger();
        }
        return insert;
    }**/
    //懒汉模式3
    private SingleHugger(){}
    private static SingleHugger insert=null;
    public static SingleHugger getInsert(){
        if(insert==null){
            synchronized (SingleHugger.class) {
                if(insert==null){
                    insert=new SingleHugger();
                }
            }
        }
        return insert;
    }
}
