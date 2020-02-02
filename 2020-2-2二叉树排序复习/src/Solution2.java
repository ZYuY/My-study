import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
    //二叉树遍历
    private static class Node{

        private Node left=null;
        private Node right=null;
        private char val;
        private  Node(char val){
            this.val=val;
        }
    }
    private static class A{
        private Node root;
        private int used;
        private A(Node root,int used){
            this.root=root;
            this.used=used;
        }
    }
    public static  A build(char[]nums){
        if(nums.length==0)
            return new A(null,0);
        if(nums[0]=='#')
            return new A(null,1);
        Node root=new Node(nums[0]);
        A l=build(Arrays.copyOfRange(nums,1,nums.length));
        A r=build(Arrays.copyOfRange(nums,l.used+1,nums.length));
        root.left=l.root;
        root.right=r.root;
        return new A(root,1+l.used+r.used);
    }
    public static void zhongxu(Node root){
        if(root!=null){
            zhongxu(root.left);
            System.out.print(root.val+" ");
            zhongxu(root.right);
        }
    }
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        String s=input.nextLine();
        char[]num=s.toCharArray();
        A a=build(num);
        zhongxu(a.root);
    }
}
