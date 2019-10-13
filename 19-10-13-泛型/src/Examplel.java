public class Examplel {
    private static class Person<T>{
        T name;
        //static修饰的属性 方法 类不能使用
    }

    public static void main(String[] args) {
        Person<String>p=new Person<>();
        Person<Integer>q=new Person<>();
    }
}
