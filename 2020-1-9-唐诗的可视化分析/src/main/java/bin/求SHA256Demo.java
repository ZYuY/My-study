package bin;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class 求SHA256Demo {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messagedigest=MessageDigest.getInstance("SHA-256");
        String s="你好世界";
        byte[]bytes=s.getBytes("UTF-8");
        messagedigest.update(bytes);
        byte[]result=messagedigest.digest();
        System.out.println(result.length);
        for(byte b:result){
            System.out.printf("%02x",b);
        }
        System.out.println();
    }
}
