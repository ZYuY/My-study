import java.io.*;

public class IO1 {
    public static void main(String[] args) throws IOException {
        File file=new File("C:\\soft\\text.txt");
        file.createNewFile();
        //字节流
        OutputStream  is=new FileOutputStream(file);
        byte[]arr="我是中国人".getBytes("UTF-8");
        is.write(arr);
        InputStream  os=new FileInputStream(file);
        InputStream ib=new ByteArrayInputStream(arr);


        //字符流
        Reader reader =new FileReader(file);
        BufferedReader reader2=new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file) ,"GB18030" )
        );
    }

}
