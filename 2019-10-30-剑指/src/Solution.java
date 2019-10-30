import java.util.*;

import static java.lang.Long.sum;

public class Solution {
    //判断是不是平衡二叉树
//    class TreeNode{
//        TreeNode left;
//        TreeNode right;
//    }
//    public boolean IsBalanced_Solution(TreeNode root) {
//        if(root==null)
//            return true;
//        if(!IsBalanced_Solution(root.left))
//            return false;
//        if(!IsBalanced_Solution(root.right))
//            return false;
//        int lenl=githight(root.left);
//        int lenr=githight(root.right);
//        if(lenl-lenr>1||lenl-lenr<-1)
//            return false;
//        return true;
//    }
//
//    private int githight(TreeNode node) {
//        if(node==null)
//            return 0;
//        return Math.max(githight(node.left),githight(node.right))+1;
//    }
    //找出重复的数字
//    public static  void main(String[] args) {
//        Set<String>set=new HashSet<>();
//        Scanner input=new Scanner(System.in);
//        String str=input.nextLine();
//        String[]arr=str.split(" ");
//        for(String e:arr){
//            if(set.contains(e)){
//                System.out.println(e);
//                break;
//            }
//            set.add(e);
//        }
//    }
    //数列计算
    //其实就是把k转为二进制形式
//    public static void main(String[] args) {
//        Scanner input=new Scanner(System.in);
//        int n=input.nextInt();
//        int k=input.nextInt();
//        String str="";
//        while(k!=0){
//            str=k%2+str;
//            k=k/2;
//        }
//        char[]array=str.toCharArray();
//        int sum=0;
//        int count=array.length-1;
//        for(int i=0;i<array.length;i++){
//            sum+=(array[i]-'0')*(int)Math.pow(n,count--);//谨记 pow是double型，每次运算放到后面
//        }
//        System.out.println(sum);
//    }
    //剪绳子
    public static int Cheng(int n,int k){
        int[]array=new int[k];
        for(int i=0;i<k-n%k;i++){
            array[i]=n/k;
        }
        for(int i=k-n%k;i<k;i++){
            array[i]=(n/k)+1;
        }
        int sum=1;
        for(int a:array){
            sum*=a;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        for(int count=2;count<n;count++) {
            if(Cheng(n,count)>Cheng(n,count+1)){
                System.out.println(Cheng(n,count));
                break;
            }
        }

    }
}
