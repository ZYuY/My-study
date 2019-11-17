import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int r=input.nextInt();
        int c=input.nextInt();
        System.out.println(find(n,m,r,c));
    }

    private static int find(int n, int m, int r, int c) {
        int[][]arr=new int[n][m];
        int left=0;
        int right=m-1;
        int top=0;
        int hight=n-1;
        int count=1;
        while(left<=right&&top<=hight){
            for(int i=left;i<=right;i++){
                arr[top][i]=count++;
            }
            if(top!=hight){
                for(int i=top+1;i<=hight;i++){
                    arr[i][right]=count++;
                }
            }
            if(top!=hight){
                for(int i=right-1;i>=left;i--){
                    arr[hight][i]=count++;
                }
            }
            if(left!=right){
                for(int i=hight-1;i>top;i--){
                    arr[i][left]=count++;
                }
            }
            left++;right--;
            top++;hight--;
        }
        return arr[r-1][c-1];
    }
}
