import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  //从前序与中序遍历序列构造二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        int a=preorder[0];
        int b;
        for(b=0;b<inorder.length;b++){
            if(a==inorder[b])
                break;
        }
        TreeNode tree=new TreeNode(a);
        int[]left1=Arrays.copyOfRange(preorder,1,b+1);
        int[]left2=Arrays.copyOfRange(inorder,0,b);
        tree.left=buildTree(left1,left2);
        int[]right1=Arrays.copyOfRange(preorder,b+1,preorder.length);
        int[]right2=Arrays.copyOfRange(inorder,b+1,inorder.length);
        tree.right=buildTree(right1,right2);
        return tree;
    }
    //从中序和后续遍历序列构造二叉树
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if(postorder.length==0)
            return null;
        int a=postorder[postorder.length-1];
        int b;
        for(b=0;b<inorder.length;b++){
            if(a==inorder[b])
                break;
        }
        TreeNode tree=new TreeNode(a);
        int[]left1=Arrays.copyOfRange(inorder,0,b);
        int[]left2=Arrays.copyOfRange(postorder,0,b);
        tree.left=buildTree2(left1,left2);
        int[]right1=Arrays.copyOfRange(inorder,b+1,inorder.length);
        int[]right2=Arrays.copyOfRange(postorder,b,postorder.length-1);
        tree.right=buildTree2(right1,right2);
        return tree;
    }
    //二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        if(p==root||q==root)return root;
        boolean lp=baoHan(root.left,p);
        boolean lq=baoHan(root.left,q);
        if(lp&&lq){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(!lp&&!lq){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
    public boolean baoHan(TreeNode root,TreeNode t){
        if(root==null) return false;
        if(root==t)return true;
        if(baoHan(root.left,t))
            return true;
        return baoHan(root.right,t);
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)return null;
        if(p==root||q==root)
            return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null||right!=null)
            return root;
        else if(left!=null)
            return left;
        else if(right!=null)
            return right;
        return null;
    }
    //如何由前序遍历创建二叉树
    //根据二叉树创建字符串

}
