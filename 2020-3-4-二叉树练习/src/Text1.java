import java.util.Scanner;

public class Text1 {
    /**
    public static void main(String[] args) {
        StringBuilder a=new StringBuilder();
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=input.nextInt();
        }
        int x=input.nextInt();
        for(int i=0;i<n;i++){
            if(x==arr[i]){
                System.out.println(i);
                return;
            }
        }
        System.out.println("-1");
    }
     **/
    //整数与ip地址之间的转换
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            // 判断输入是IP地址还是十进制数
            if (str.contains(".")) {
                String[] arr = str.split("\\.");
                long[] ip = new long[arr.length];
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arr.length; i++) {
                    ip[i] = Long.parseLong(arr[i]);
                    String a = Long.toBinaryString(ip[i]);
                    //转成8位二进制 利用String.format()控制格式
                    String temp = String.format("%08d", Long.parseLong(a));
                    sb.append(temp);
                }
                long output = Long.parseLong(sb.toString(), 2);
                System.out.println(output);
            } else {
                String binaryChuan = Long.toBinaryString(Long.parseLong(str));
                int len = binaryChuan.length();
                StringBuilder sb = new StringBuilder(binaryChuan);
                // 不足32位的前面补0
                for (int i = 0; i < 32 - len; i++) {
                    sb.insert(0, "0");
                }
                String fin = sb.toString();
                long a = Long.valueOf(fin.substring(0, 8), 2);
                long b = Long.valueOf(fin.substring(8, 16), 2);
                long c = Long.valueOf(fin.substring(16, 24), 2);
                long d = Long.valueOf(fin.substring(24, 32), 2);
                System.out.println(a + "." + b + "." + c + "." + d);
            }
        }
    }
}
