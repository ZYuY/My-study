import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int[]zhuozi=new int[n];
        for(int i=0;i<n;i++){
            zhuozi[i]=input.nextInt();
        }
        int[][]people=new int[m][2];
        for(int i=0;i<m;i++){
            people[i][0]=input.nextInt();
            people[i][1]=input.nextInt();
        }
        Arrays.sort(zhuozi);
        //对people按照消费金额进行升序
        for(int i=0;i<people.length-1;i++){
            for(int j=0;j<people.length-i-1;j++){
                if(people[j][1]<people[j+1][1]){
                    int k=people[j][1];
                    people[j][1]=people[j+1][1];
                    people[j+1][1]=k;

                    int p=people[j][0];
                    people[j][0]=people[j+1][0];
                    people[j+1][0]=p;
                }
            }
        }
        int sum=0;
        for(int i=0;i<zhuozi.length;i++){
            for(int j=0;j<people.length;j++){
                if(people[j][0]<=zhuozi[i]&&people[j][0]!=0){
                    sum+=people[j][1];
                    people[j][0]=0;
                    break;
                }
            }
            continue;
        }
        System.out.println(sum);
    }
}
