import java.util.ArrayList;
import java.util.List;

public class Text {
    //不同路径
    public int uniquePaths(int m, int n) {
        int[][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0)
                    dp[i][j]=1;
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    //不同路径2
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        if(obstacleGrid==null||obstacleGrid.length<=0)return 0;
        int[][]dp=new int[row][col];
        for(int i=0;i<row;i++){
            if(obstacleGrid[i][0]==1){
                dp[i][0]=0;
                break;
            }else
                dp[i][0]=1;
        }

        for(int j=0;j<col;j++){
            if(obstacleGrid[0][j]==1){
                dp[0][j]=0;
                break;
            }
            else
                dp[0][j]=1;
        }

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(obstacleGrid[i][j]==1)dp[i][j]=0;
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[row-1][col-1];
    }

    //最小路径
    public int minPathSum(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        if(grid==null||grid.length<=0)return 0;
        int[][]dp=new int[rows][cols];
        dp[0][0]=grid[0][0];
        for(int i=1;i<rows;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int j=1;j<cols;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }

        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }


    //77组合
    List<List<Integer>>result;
    List<Integer>tmp;
    public List<List<Integer>> combine(int n, int k) {
        result=new ArrayList<List<Integer>>();
        tmp=new ArrayList<Integer>();
        backTrace(k,0,n);
        return result;
    }
    public void backTrace(int remain, int last, int n) {
        if(remain == 0) {
            result.add(new ArrayList(tmp));
            return;
        }
// n-remain+1这里是剪枝的关键，25ms   到 1ms
        for(int i=last+1; i<=n-remain+1; i++) {
            tmp.add(i);
            backTrace(remain-1, i, n);
            tmp.remove(tmp.size()-1);
        }
    }
}
