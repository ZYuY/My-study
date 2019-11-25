import java.io.File;

public class Text2 {
    public static void main(String[] args) {
        show1();//路径
        show2();//名称
        show3();//
    }

    /**
     * public long length  返回由此File表示的文件长度
     * 获取的是构造方法指定的文件的大小，以字节为单位
     * 注意：1.文件夹没有大小的概念，不能获取文件夹的大小
     * 2.如果构造方法中给定的路径不存在，则length()返回0
     * public String getName
     */
    private static void show3() {

    }

    private static void show2() {
        File f1=new File("C:\\HG");
        File f2=new File("txt");
        //获取路径的结尾部分
        System.out.println(f1.getName());


    }

    private static void show1() {
        //返回的都是绝对路径
        File f1=new File("C:\\HG");
        System.out.println(f1.getAbsolutePath());
        File f2=new File("txt");
        System.out.println(f2.getAbsolutePath());
        //绝对的返回绝对路径  相对的返回相对路径
        System.out.println(f1.getPath());
        System.out.println(f2.getPath());
        //toString方法调用的就是getPath()
        System.out.println(f1);
        System.out.println(f1.toString());

    }

}
