import java.util.*;

public class Text {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int []arr=new int[n];
        int j=1;
        for(int i=0;i<n;i++){
            arr[i]=j++;
        }
        if(n>2)
            find(arr,n);
        System.out.println(Arrays.toString(arr));
    }
    public static void find(int[]arr,int n){
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for( int k=j+1;k<n;k++){
                    if(arr[i]+arr[k]==2*arr[j]){
                        int p=arr[j];
                        arr[j]=arr[k];
                        arr[k]=p;
                    }
                }
            }
        }
    }
}
