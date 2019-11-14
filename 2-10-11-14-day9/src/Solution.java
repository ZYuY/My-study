import java.util.LinkedList;
import java.util.Scanner;

/**
 * 沟通
 * 轻文档
 * 客户参与
 * 拥抱变化
 **/

 /**如何描述一个BUG?
 * 编号：regin_00
 * a.标题：邮箱注册提交报500错误
 * b.环境：windows10+IE11
 * c.步骤：1.进入163首页
  * 2.点击免费注册邮箱
  * 3.输入页面上的所有信息
  * 4.点击提交“已发送短信立即注册”
 * d.实际结果：出现500错误
 * e.预期结果：页面提示发送成功
 */
public class Solution {
    //删数  间隔两个数就要删除一个数，约瑟夫环问题
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()) {
            int n = input.nextInt();
            int pop = find(n);
            System.out.println(pop);
        }
    }

    private static int find(int n) {
        int[] arr = new int[n];
        int count = n;
        int pop = 0;
        while (count > 1) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    pop++;
                    if (pop == 3) {
                        arr[i] = -1;
                        count--;
                        pop = 0;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}
