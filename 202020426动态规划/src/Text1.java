import java.util.ArrayList;
import java.util.Set;

public class Text1 {
    //表态青蛙跳台阶
    public int JumpFloorII(int target) {
        if(target<=0)return 0;
        if(target==1)return 1;
        return JumpFloorII(target-1)*2;
    }
    //矩形覆盖
    public int RectCover(int target) {
        if(target<=0)
            return 0;
        if(target==1)
            return 1;
        if(target==2)
            return 2;

        return RectCover(target-1)+RectCover(target-2);
    }
    //word-break
    public boolean wordBreak(String s, Set<String> dict) {
        int len=s.length();
        boolean[]arr=new boolean[len+1];
        arr[0]=true;
        for(int i=1;i<=len;i++){
            for(int j=0;j<i;j++){
                if(arr[j]&&dict.contains(s.substring(j,i))){
                    arr[i]=true;
                    break;
                }
            }
        }
        return arr[len];
    }
    //triangle(三角矩阵的最小路径)

    /**
     * 自底向上 f[i,j]=min(f[i+1,j],f[i+1,j+1])+f[i,j];
     * 直到第一行【0，0】就是最小和
     * @param triangle
     * @return
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle.isEmpty())return 0;
        ArrayList<ArrayList<Integer>>list=new ArrayList<>(triangle);
        int len=triangle.size();
        //从倒数第二行开始
        for(int i=len-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int sum=Math.min(list.get(i+1).get(j),list.get(i+1).get(j+1))+list.get(i).get(j);
                list.get(i).set(j,sum);
            }
        }
        return list.get(0).get(0);
    }
    //unique-paths(路径和）
    public int uniquePaths(int m, int n) {
//        if(m==0||n==0)return 1;
//        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
        if(m==0||n==0)return 1;
        int[][]arr=new int[m][n];
        for(int i=0;i<m;i++){
            arr[i][0]=1;
        }
        for(int i=0;i<n;i++){
            arr[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                arr[i][j]=arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
    //unique-paths-ii(有阻碍的上道题)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][]arr=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++){
            if(obstacleGrid[i][0]==1)break;
            arr[i][0]=1;
        }
        for(int j=0;j<obstacleGrid[0].length;j++){
            if(obstacleGrid[0][j]==1)break;
            arr[0][j]=1;
        }
        for(int i=1;i<obstacleGrid.length;i++){
            for(int j=1;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j]==1)arr[i][j]=0;
                else
                    arr[i][j]=arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    //minimum-path-sum（最小路径和）
    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int high=grid[0].length;
        for(int i=1;i<row;i++){
            grid[i][0]+=grid[i-1][0];
        }
        for(int i=1;i<high;i++){
            grid[0][i]+=grid[0][i-1];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<high;j++){
                grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[row-1][high-1];
    }

}
