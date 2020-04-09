import java.io.File;

public class file {
    File file=new File("");
    public static void find(File node){
        if(node.isDirectory()){
            File[] files=node.listFiles();
            if(files!=null){
                for(File file:files){
                    find(file);
                }
            }
        }
        System.out.println("这是一个文件");
    }
}
