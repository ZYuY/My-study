import java.util.Scanner;

public class Text4 {
    //双行道
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        String[]arr=new String[2];
        for(int i=0;i<2;i++){
            arr[i]=input.next();
        }
        char[][]p=new char[2][n];
        p[0]=arr[0].toCharArray();
        p[1]=arr[1].toCharArray();
        int res=Find(p);
    }

    private static int Find(char[][]arr) {
        int count=0;
    for(int i=1;i<=arr.length;i++){
        for(int j=1;j<=arr[1].length;j++){
            if(arr[i][j+1]=='X'&&arr[i+1][j+1]=='X'&&arr[i-1][j+1]=='X'){
                return -1;
            }else{
                count++;
            }
        }
    }
    return count;
    }
}
