import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Guangduyouxian {
    //oj 111二叉树的最小深度
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null)
            return minDepth(root.right)+1;
        if(root.right==null)
            return minDepth(root.left)+1;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
//oj 103二叉树的锯齿形遍历
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>>list=new ArrayList<>();
    if(root==null)
        return list;
    Queue<TreeNode> queue=new LinkedList<>();
    queue.offer(root);
    int lve=0;
    while(!queue.isEmpty()){
        list.add(new ArrayList<>());
        int len=queue.size();
        for(int i=0;i<len;i++){
            TreeNode node=queue.remove();
            if(lve%2==0)
                list.get(lve).add(node.val);
            if(lve%2==1)
                list.get(lve).add(0,node.val);
            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
        }
        lve++;
    }
    return list;
}
//oj 102二叉树的层次遍历
public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>>list=new ArrayList<List<Integer>>();
    if(root==null)
        return list;
    Queue<TreeNode>queue=new LinkedList<>();
    queue.add(root);
    int lev=0;
    while(!queue.isEmpty()){
        list.add(new ArrayList<>());
        int len=queue.size();
        for(int i=0;i<len;i++){
            TreeNode node=queue.remove();
            list.get(lev).add(node.val);
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);

        }
        lev++;
    }
    return list;

}
//oj 107 二叉树的层次遍历
public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>>list=new LinkedList<>();
    if(root==null)
        return list;
    Queue<TreeNode>queue=new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        List<Integer>result=new ArrayList<>();
        int len=queue.size();
        for(int i=0;i<len;i++){
            TreeNode node=queue.poll();
            result.add(node.val);
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }
        list.add(0,result);
    }
    return list;
}
}
