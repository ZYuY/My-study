import java.io.File;

public class Solution {
    public static void main(String[] args) {
        File file = new File("C:\\\\Users\\\\whb\\\\Desktop");
        listAllFiles(file);
    }
//递归遍历file所有文件
    private static void listAllFiles(File file) {
       if(file.isDirectory()){
           File[]result=file.listFiles();
           if(result!=null){
               for(File files:result){
                   listAllFiles(files);
               }
           }
       }else{
           System.out.println( file);
       }
    }
}
