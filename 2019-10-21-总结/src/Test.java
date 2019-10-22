import javax.swing.tree.TreeNode;

public class Test {
    //查找二叉树的最近公共祖先
    public class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean chazhao(TreeNode m,TreeNode n){
        if(m==null)
            return false;
        if(m==n)
            return true;
        if(chazhao(m.left,n))
            return true;
        return chazhao(m.right,n);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {if(root==null)
        return null;
        if(p==root||q==root)
            return root;
        boolean left1=chazhao(root.left,p);
        boolean left2=chazhao(root.left,q);
        if(left1&&left2)
            return lowestCommonAncestor(root.left,p,q);
        if(!left1&&!left2)
            return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}
