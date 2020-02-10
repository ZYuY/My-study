import java.io.File;

public class Text {
    public static void main(String[] args) {
//        File file=new File("C://user/ideas");
//        if(file.exists()&&file.isDirectory()){
//            File []files=file.listFiles();
//            for(File e:files){
//                System.out.println(e);
//            }
//        }
        File file=new File("C://user/ideas");
        listAllFile(file);
    }

    private static void listAllFile(File file) {
        if(file.isDirectory()){
            File[]files=file.listFiles();
            if(files!=null){
                for(File e:files){
                    listAllFile(e);
                }
            }
        }else{
            System.out.println("文件"+file);
        }
    }
}
