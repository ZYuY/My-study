import java.util.Scanner;

public class Solution2 {
    //不要二
    /**
     * 思路：0+4=4 ，4+0=4，其他1+3=4,2+2=4都不能达到
     * 遍历每个格子，与格子同行同列距离不能等于2，所以将这些不满足条件的格子置为-1
     * 满足条件的就是数组默认值0
     * 只要遍历的格子为0则count++
     * @param args
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()) {
            int w = input.nextInt();//长
            int h = input.nextInt();//宽
            int[][] arr = new int[h][w];
            int count =0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 0) {
                        count++;
                        if (i + 2 < h) {
                            arr[i+2][j] = -1;
                        }
                        if (j + 2 < w) {
                            arr[i][j+2] = -1;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
