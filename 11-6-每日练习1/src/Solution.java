import java.util.*;

public class Solution {
    //回文数aba插入b构成回文数 问有集中插入的情况
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String A=input.nextLine();
        String B=input.nextLine();
        int count=0;
        for(int i=0;i<=A.length();i++){
            StringBuffer str=new StringBuffer(A);
            str.insert(i,B);
            if(huiwen(str)){
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean huiwen(StringBuffer str) {
        String arr=str.toString() ;
        char[]array=arr.toCharArray();
        int a=0,b=array.length-1;
        while(a<b){
            if(array[a]!=array[b]){
                return false;
            }
            a++;
            b--;
        }
        return true;

    }

//找出数组中倒数第k大的数
    public int findKth(int[] a, int n, int K) {
        // write code here
         Arrays.sort(a);
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(map.containsValue(a[i])){
                continue;
            }
            map.put(i,a[i]);
        }
        return map.get(map.size()-K);
    }
    //数组中只出现一次的数字
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int x=0;
        for(int e:array){
            x^=e;
        }
        int k=find(x);
        for(int i=0;i<array.length;i++){
            if(isweishu(array[i],k)){
                num1[0]^=array[i];
            }else{
                num2[0]^=array[i];
            }
        }
        System.out.println(num1+""+num2);
    }

    private boolean isweishu(int i, int k) {
        return ((i>>k)&1)==0;
    }

    private int find(int x) {
        int count=0;
        if((x&1)==0&&count<32){
            x>>=1;
            count++;
        }
        return count;
    }
    //求1+2+3+...+n
    public int Sum_Solution1(int n) {
       // return (n*(1+n))/2;
        return (int)(Math.pow(n,2)+n);
    }

    public int Sum_Solution2(int n) {
        int sum = n;
        boolean flag = (sum>0)&&((sum+=Sum_Solution2(--n))>0);
        return sum;
    }
    //把字符串转换为整数
    public int StrToInt(String str) {
        int sum=0;
        for(int i=0;i<str.length();i++){
            char a=str.charAt(i);
            if(a>=65||a>=97){
                return 0;
            }
            int b=a-'0';
            sum=sum*10+b;
        }
        return sum;
    }
}
