

public class Solution {
    //二叉树平衡检查
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isBalance(TreeNode root) {
        // write code here
        if(root==null)
            return true;
        if(!isBalance(root.left)){
            return false;
        }
        if(!isBalance(root.right))
            return false;
        int len1=getlength(root.left);
        int len2=getlength(root.right);
        if(len1-len2>=-1&&len1-len2<=1)
            return true;
        return false;
    }

    private int getlength(TreeNode root) {
        if(root==null)
            return 0;
        return Math.max(getlength(root.left),getlength(root.right))+1;
    }
}
