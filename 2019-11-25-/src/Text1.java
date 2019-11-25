import java.io.File;

public class Text1 {
    /**
     * java.io.File;
     * 文件和目录路径名的抽象表现形式
     * file:文件
     * directory:文件夹/目录
     * path:路径
     */
    public static void main(String[] args) {
        System.out.println(File.pathSeparator);//路径分隔符
        //windows ; Linux :
        System.out.println(File.separator);//文件名称分隔符
        //windows \  Linus   /
        /**
         * 绝对路径：完整的路径  以盘符开始的
         * 相对路径：简化的路径  指的是相对于当前项目的根目录  可以省略项目的根目录
         * 注意：路径不区分大小写
         * 路径中的文件名称分隔符windows使用\\
         */
        meth1();
        meth2("c:\\",".txt");
        meth3();
    }

    private static void meth3() {
        File parent=new File("c:\\");
        File c=new File(parent,"hello.java");
        System.out.println(c);
    }

    private static void meth2(String s, String s1) {
        File b=new File(s,s1);
        System.out.println(b);
    }

    private static void meth1() {
        File a=new File("C:\\a");
        System.out.println(a);//覆写了toString方法

    }
    /**
     * File类的构造方法
     * [1]  File(String pathname)
     * 路径可以以文件结尾，也可以以文件夹结尾
     * 路径可以是绝对路经，也可以是相对路径
     * 路径可以是存在，也可以是不存在
     * 创建File对象，只是把字符串路径封装为File对象，不考虑路径的真假情况
     * [2]  File(String parent ,String child)父路径和子路径可以单独书写，都可以变化
     *[3]File(File parent ,String child)父类型可以使用File的方法对路径进行一系列操作，再使用路径创建对象
     *
     */
}
