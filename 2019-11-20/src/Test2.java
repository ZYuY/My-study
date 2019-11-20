import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Test2 {
    //超长正整数相加
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String add=input.next();
        String aug=input.next();
        System.out.print(Add(add,aug));
    }

    private static String Add(String add, String aug) {
        int lenA = add.length();
        int lenB = aug.length();
        int lenS = Math.max(lenA, lenB);

        // arrS保存最终生成的结果
        int[] arrA = new int[lenS];
        int[] arrB = new int[lenS];
        int[] arrS = new int[lenS + 1];

        for (int i = 0; i < lenA; i++) {
            arrA[i] = add.charAt(lenA - 1 - i) - '0';
        }

        for (int i = 0; i < lenB; i++) {
            arrB[i] = aug.charAt(lenB - 1 - i) - '0';
        }

        for (int i = 0; i < lenS; i++) {
            int sum = arrS[i] + arrA[i] + arrB[i];
            int flag = sum / 10;
            arrS[i] = sum % 10;
            arrS[i + 1] += flag;
        }
        int index = arrS.length-1;
        while (arrS[index] != 0) {
            index--;
        }
        int[] result = Arrays.copyOfRange(arrS, 0, index);
        String str="";
        for (int i = result.length - 1; i >= 0; i--) {
            str+=result[i];
        }
        return str;

    }
}
