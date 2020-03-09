import java.io.*;
public class Text {
    public static void main(String[] args) throws IOException {
//        File file=new File("c://index/");
//        Find(file);
        FileInputStream fin=new FileInputStream("E:\\bit\\bit.jpg");
        FileOutputStream fout=new FileOutputStream("E:\\bit\\bit\\BitCopy.jpg");
        int len=0;
        byte[]buffer=new byte[1024];
        while((len=fin.read(buffer))!=-1){
            fout.write(buffer,0,len);
        }
        fin.close();
        fout.close();
        //创建输入流对象
        FileReader fr = new FileReader("E:\\bit\\bitSrc.java");
//创建输出流对象
        FileWriter fw = new FileWriter("E:\\bit\\bitCopy.java");
        int text;
        while((text=fr.read())!=-1){
            fw.write(text);
        }
        fr.close();
        fw.close();
    }

    private static void Find(File file) {
        if(file.isDirectory()){
            File[]files=file.listFiles();
            if(files!=null){
                for(File f:files){
                    Find(f);
                }
            }
        }else{
            System.out.println(file);
        }
    }
}
