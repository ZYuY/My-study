import java.io.*;

public class copy {
    public static void main(String[] args) throws IOException {
//        File file=new File("C:\\soft\\text.txt");
//        file.createNewFile();
//        //字节流
//        OutputStream is=new FileOutputStream(file);
//        byte[]arr="我是中国人".getBytes("UTF-8");
//        is.write(arr);

        String a1="C:\\soft\\text.txt";
        String a2="C:\\soft\\tex.txt";
        InputStream a=new FileInputStream(a1);
        OutputStream b=new FileOutputStream(a2);
        int c;
        while((c=a.read())!=-1){
            b.write(c);
        }
    }
}
