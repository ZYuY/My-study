import com.sun.deploy.util.SyncAccess;

public class Solution2 {
    private class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  //检查两棵树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    //另一棵树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null)return false;
        if(Same(s,t))
            return true;
        if(isSubtree(s.left,t))
            return true;
        return isSubtree(s.right,t);
    }
    public static boolean Same(TreeNode p,TreeNode q){
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        return p.val==q.val&&Same(p.left,q.left)&&Same(p.right,q.right);
    }
    //二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int a=maxDepth(root.left);
        int b=maxDepth(root.right);
        return Math.max(a,b)+1;
    }
    //判断一棵二叉树是否为平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        if(!isBalanced(root.left))
            return false;
        if(!isBalanced(root.right))
            return false;
        int a=getHight(root.left);
        int b=getHight(root.right);
        if((a-b)>=-1&&(a-b)<=1)
            return true;
        return false;
    }
    public static int getHight(TreeNode root){
        if(root==null)return 0;
        return Math.max(getHight(root.left),getHight(root.right))+1;
    }
    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        else
            return Sym(root.left,root.right);
    }
    public static boolean Sym(TreeNode p,TreeNode q){
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        return p.val==q.val&&Sym(p.left,q.right)&&Sym(p.right,q.left);
    }
}
