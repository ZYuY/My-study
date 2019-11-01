import java.util.Arrays;

public class Solution {
    //重建二叉树
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int a){
            val=a;
        }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
       if(pre.length==0)
           return null;
       int a=pre[0];
       int i=0;
       for( ;i<in.length;i++){
           if(a==in[i])
               break;
       }
        TreeNode result=new TreeNode(a);
       int[]left1= Arrays.copyOfRange(pre,1,i+1);
       int[]left2=Arrays.copyOfRange(in,0,i) ;
       result.left=reConstructBinaryTree(left1,left2);
       int[]right1=Arrays.copyOfRange(pre,i+1,pre.length) ;
       int[]right2=Arrays.copyOfRange(in,i+1,in.length) ;
       result.right=reConstructBinaryTree(right1,right2);
       return result;
    }
    //替换空格
    public String replaceSpace(StringBuffer str){
        StringBuffer result=new StringBuffer();
        for(int i=0;i<str.length();i++){
            char a=str.charAt(i);
            if(a==' '){
                result.append("%20");
            }else
                result.append(a);
        }
        return result.toString();
    }
//树的子结构
    /**
     * 这个题和查看是否是另一棵树的子树很相似
     * 首先应该以根节点作为起点，看是否包含root2，
     * 如果不包含，就把左子树当作新的根节点的起点
     * 如果不包含，就看右子树
     **/

public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null||root1==null)
            return false;
        if(Same(root1,root2)){
            return true;
        }
         if(HasSubtree(root1.left,root2)){
            return true;
        }
            return HasSubtree(root1.right,root2);
}
//以p1为根节点看是否包含p2
public boolean Same(TreeNode p1,TreeNode p2){
      if(p2==null)
          return true;
      if(p1==null&&p2!=null)
          return false;
      return (p1.val==p2.val)&&Same(p1.left,p2.left)&&Same(p1.right,p2.right);
}
//二叉树的镜像

    /**
     * 如果树为null
     * 如果树只有一个结点
     * @param root
     */
    public void Mirror(TreeNode root) {
    if(root==null)
        return;
    if(root.left==null&&root.right==null)
        return;
    TreeNode k=root.left;
    root.left=root.right;
    root.right=k;
    if(root.left!=null)
        Mirror(root.left);
    if(root.right!=null)
        Mirror(root.right);
}
    public static void main(String[] args) {

    }
}
