import java.util.Scanner;

public class Text1 {
    /**
     * 完美的代价
     * @param args
     */
    public static void main(String[] args) {
        boolean b = true; //是否匹配
        char x1 = 0;//x1记录字符串长度为奇数且第一次未匹配，x2记录第二次未匹配。
        int sum = 0;//交换次数
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] charArray = new char[n];
        charArray = sc.next().toCharArray();//输入的字符串转化为字符数组
//i表示从左往右未匹配字符的下标
//j表示从右往左未匹配的字符下标
        for (int i = 0; i < charArray.length / 2; i++) {
            //如果不能能匹配（字符串长度为奇数）
            //从右向左找与左边下标为i的字符相匹配的
            for (int j = i; j < charArray.length - 1 - i; j++) {
                //如果匹配
                if (charArray[i] == charArray[charArray.length - 1 - j]) {
                    b = true;
                    //如果左右不对称则交换
                    if (i != j) {
                        char a = charArray[charArray.length - 1 - j];
                        for (int k = j; k > i; k--) {
                            sum++;
                            charArray[charArray.length - 1 - k] =
                                    charArray[charArray.length - k];
                        }
                        charArray[charArray.length - 1 - i] = a;
                    }
                    break;//匹配完成就跳出j的循环
                } else {
                    b = false;
                    //若最后一次未匹配到，则保存charArray[i]
                    if (j == charArray.length - i - 2 && charArray[i] !=
                            charArray[charArray.length - 1 - j]) {
                        if (x1 == charArray[i] || x1 == 0)
                            x1 = charArray[i];
                    }
                }
            }
            if (b == false) {
                if (charArray.length % 2 == 1 && charArray[i] == x1) {
                    sum++;
                    char g = charArray[i + 1];
                    charArray[i + 1] = charArray[i];
                    charArray[i] = g;
                    b = true;
                    i--;//重新匹配charArray[i]；
                } else
                    break;
            }
        }
        if (b)
            System.out.println(sum);
        else
            System.out.println("Impossible");
    }
}
