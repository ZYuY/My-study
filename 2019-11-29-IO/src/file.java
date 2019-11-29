import java.io.File;
import java.io.IOException;

public class file {
    public static void main(String[] args) throws IOException {

        File file=new File("C:\\soft");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.canRead() );
        System.out.println(file.canWrite() );
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getUsableSpace());
        System.out.println("是否是隐藏文件"+file.isHidden());
        System.out.println("当前文件的大小"+file.length());
        System.out.println(file.getParent());

        file.createNewFile();
        file.delete();
        file.deleteOnExit();//jvm退出删除
        file.mkdir();//创建文件夹
        file.mkdirs();//创建中间路径中当前不存在的文件夹
       File[]arr= file.listFiles();//当前文件夹有多少文件
        for(File i:arr){
            System.out.println(i);
        }
        /**
         * 相对路径：相对运行时期的路径--程序启动时期的路径
         * .当前路径
         * ..回到上一级路径
         *
         */
    }
}
