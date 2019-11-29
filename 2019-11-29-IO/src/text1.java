import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class text1 {
    /**
     * 遍历一个文件目录下的所有文件
     * 虽然File提供有 listFiles() 方法，但是这个方法本身只能够列出本目录中的第一级信息。
     * 如果要求列出目录中所有级的信息，必须自己来处理。这种操作就必须通过递归的模式来完成
     * @param args
     */
    public static void main(String[] args) {
        File file=new File("C:\\soft");
        listallfiles(file);
    }

    private static <HashList> void listallfiles(File file) {
        Map<File,Long> map=new HashMap<>();
        if(file.isDirectory()){
            File[]arr=file.listFiles();
            if(arr!=null){
                for(File i:arr){
                    listallfiles(i);
                }
            }
        }else{
            System.out.println(file);
            long a=file.length();
            map.put(file,a);
        }

    }
}
