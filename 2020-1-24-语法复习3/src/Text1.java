class Person{
    public String name;
    public int age;
    public String sex;
}
public class Text1 {
    public static void main(String[] args) {
        Person person =new Person();
        System.out.println(person.name.length());
    }
    /**
     * 普通属性和普通方法都绑定着一个隐含的对象
     *键盘 标准输入
     * 屏幕 标注输出
     * this：1.命名重复的时候   2.代表当前对象的引用   3.在构造方法中调用其他构造方法，必须出现在第一行
     * static： 1.修饰属性，类名.属性名  2.修饰方法，静态方法可以访问静态数据成员，静态方法不能访问普通属性
     * this和super不能在静态上下文使用
     *
     * 静态代码块 实例代码块  构造方法
     * 二分查找 时间复杂度：O（log n)
     *
     */
}
