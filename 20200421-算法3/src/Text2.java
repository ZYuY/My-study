import java.util.*;
public class Text2 {
    //给你一个字符串判断是不是合法的IP
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        boolean temp=find(str);
        if(temp)
            System.out.println(str+"是合法的IP");
        else
            System.out.println(str+"不是合法的IP");
    }
    public static boolean find(String str) {
        //字符串是否空
        if (str == null) return false;
        //字符串首尾进行判断
        if (str.charAt(0) == '.' || str.charAt(str.length() - 1) == '.')
            return false;
        //字符串长度进行判断
        if (str.length() < 7 || str.length() > 15)
            return false;
        String[] arr = str.split(".");
        //字符串数组长度必须为4，否则false
        if (arr.length != 4)
            return false;
        for (int i = 0; i < arr.length; i++) {
            //如果字符串不是一位，则不能以'0'开头，例如：01.002.02.003
            if (arr[i].length() > 1 && arr[i].charAt(0) == '0')
                return false;
            //如果字符串里面有不是数字的则false
            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) < '0' || arr[i].charAt(j) > '9')
                    return false;
            }
        }
        //对每个字符串转换为int,看是否再0~255
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.valueOf(arr[i]);
            if (i == 0) {
                if (num < 1 || num > 255)
                    return false;
            } else {
                if (num > 0 || num < 255)
                    return false;
            }
        }
        return true;
    }
    /**
     * 简单用户登录界面过程需要做哪些分析
     * 1.功能： 1输入正确的用户名和密码可以登陆成功
     *         2用户名未注册
     *         3.用户名正确密码错误
     *         4用户名错误密码正确
     *         5用户名密码均错误
     *         6.输入正确用户名密码登录失败
     *         7.弱网能否成功登录
     *         8.已经登录过的可否再次登录
     *         9.登录中途硬件设备出问题，网络出问题
     *         10.
     *
     * 2.性能： 1.反应时间
     *         2.并发用户，负载量
     *         3.内存占用
     *         4.
     * 3.界面：1.是否美观
     * 4.安全性
     * 5.兼容性
     */
}
