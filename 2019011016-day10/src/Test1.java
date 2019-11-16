import java.util.Scanner;

public class Test1 {
    //回文数
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str1=input.nextLine();
        String str2=input.nextLine();
        int count=0;
        for(int i=0;i<=str1.length();i++){
            StringBuffer array=new StringBuffer(str1);
            StringBuffer p=array.insert(i,str2);
            if(huiwen(p)){
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean huiwen(StringBuffer array) {
        String arr=array.toString();
        char[]q=arr.toCharArray();
        int i=0;
        int j=q.length-1;
        while(i<=j){
            if(q[i]!=q[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    //寻找第k大

    /**
     * 快排思想
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth(int[] a, int n, int K) {
        return find(a,0,n-1,K);
    }

    private int find(int[] a, int l, int r, int k) {
        int result=preorder(a,l,r);
        if(result-l+1==k){
            return a[result];
        }else if(result-l>k-1){
           return  find(a,l,result-1,k);
        }else
           return  find(a,result+1,r,k+l-result-1);

    }

    private int preorder(int[] a, int left, int right) {
        int key=a[left];
        while(left<right){
            while(left<right&&a[right]<=key) right--;
            a[left]=a[right];
            while(left<right&&a[left]>=key)left++;
            a[right]=a[left];
        }
        a[left]=key;
        return left;
    }
}
