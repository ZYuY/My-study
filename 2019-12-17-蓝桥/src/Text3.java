import java.util.Scanner;

public class Text3 {
    static int n,tot; //n表示棋盘的长度，tot表示放置成功的次数（即要输出的结果）
    static int[] C; //一维数组C表示皇后在每行放置的位置
    static int[][] board;//表示棋盘

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        tot = 0;
        n = sc.nextInt();//录入棋盘数据
        C = new int[n];
        board = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
            }
        }
        search(0);
        System.out.println(tot);

    }
    static void search(int row){//放置黑皇后
        if(row==n) { //递归边界，如果row等于n，那么所有皇后必然不会冲突

            int[][] board1 = new int[n][n]; //生成新棋盘
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    board1[i][j] = board[i][j];
            }
            for(int i=0;i<n;i++){//将黑皇后所在位置更新为“0”
                board1[i][C[i]]=0;
            }

            int[] C1 = new int[n];
            search1(0,board1,C1);//放置白皇后

        }
        else{
            for(int i=0;i<n;i++){
                if(board[row][i] == 0) continue;//如果此位置为“0”，则跳过此次循环
                boolean ok = true;
                C[row] = i;//将第row行的皇后放在第i列
                for(int j=0;j<row;j++){
                    if(C[row] == C[j] || row-C[row] == j-C[j] || row+C[row]==j+C[j]){//判断皇后是否冲突
                        ok = false;break;//冲突则结束此次循环
                    }

                }
                if(ok) search(row+1);//不冲突，则继续进行递归
            }
        }
    }

    static void search1(int row,int[][] board1,int[] C1){//放置白皇后
        if(row==n) tot++;//黑皇后和白皇后都放置成功，tot+1
        else{
            for(int i=0;i<n;i++){
                if(board1[row][i] == 0) continue;
                boolean ok = true;
                C1[row] = i;
                for(int j=0;j<row;j++){
                    if(C1[row] == C1[j] || row-C1[row] == j-C1[j] || row+C1[row]==j+C1[j]){
                        ok = false;break;
                    }

                }
                if(ok) search1(row+1,board1,C1);
            }
        }
    }


}
