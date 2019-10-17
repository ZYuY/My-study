public class StringDemo {
//    public static void main(String[] args) {
//        String test="你是大坏蛋";
//        char[]a=test.toCharArray() ;
//        System.out.println(a);
//        System.out.println(new String(a));
//    }
    public static void throwException(boolean isThrow){
        System.out.println("抛出异常前");
        if(isThrow){
            throw new NullPointerException();
        }
        System.out.println("抛异常之后");
    }

    public static void main(String[] args) {
        try{
            throwException(true);
        }catch(NullPointerException exe){
            System.out.println("捕获到异常");
        }finally{
            System.out.println("总的过来一趟");
        }
    }
}
