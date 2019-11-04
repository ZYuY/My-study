import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //层序遍历二叉树
    class Node{
        Node left;
        Node right;
        int val;
        public Node(int val){
            this.val=val;
        }
    }
    public ArrayList<Integer> preorder(Node root){
        ArrayList<Integer>list=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        if(root==null)
            return list;
        queue.add(root);
    while(!queue.isEmpty()){
        Node pre=queue.remove();
        list.add(pre.val);
        if(pre.left!=null)
            queue.add(pre.left);
        if(pre.right!=null)
            queue.add(pre.right);
    }
    return list;
    }
    //二叉树由前序和中序构建二叉树
    public Node reConstructBinaryTree(int [] pre,int [] in){
        if(pre==null||pre.length==0)
            return null;
        int a=pre[0];
        int i=0;
        for(;i<in.length;i++){
            if(a==in[i]){
                break;
            }
        }
        Node result=new Node(a);
        int[] len1= Arrays.copyOfRange(pre,1,i+1);
        int[]len2=Arrays.copyOfRange(in,0,i);
        result.left=reConstructBinaryTree(len1,len2);
        int[]right1=Arrays.copyOfRange(pre,i+1,pre.length) ;
        int[]right2=Arrays.copyOfRange(in,i+1,in.length) ;
        result.right=reConstructBinaryTree(right1,right2);
        return result;
    }
}
