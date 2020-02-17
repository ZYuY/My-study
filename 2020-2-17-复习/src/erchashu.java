
import java.util.*;

class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
  }
public class erchashu {
    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        if(root==null)return list;
        List<Integer>left=preorderTraversal(root.left);
        List<Integer>right=preorderTraversal(root.right);
        list.add(root.val);
        list.addAll(left);
        list.addAll(right);
        return list;
    }
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        TreeNode node=root;
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                list.add(node.val);
                stack.push(node);
                node=node.left;
            }
            TreeNode top=stack.pop();
            node=top.right;
        }
        return list;
    }
    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        if(root==null)return list;
        List<Integer>left=inorderTraversal(root.left);
        List<Integer>right=inorderTraversal (root.right);
        list.addAll(left);
        list.add(root.val);
        list.addAll(right);
        return list;
    }
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        if(root==null)return list;
        Stack<TreeNode>stack=new Stack<>();
        TreeNode node=root;
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            TreeNode top=stack.pop();
            list.add(top.val);
            node=top.right;
        }
        return list;
    }
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        if(root==null)return list;
        TreeNode node=root;
        TreeNode pre=null;//上次被遍历完的结点
        Stack<TreeNode>stack=new Stack<>();
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            TreeNode top=stack.peek();
            if(top.right==null||top.right==pre){
                list.add(top.val);
                stack.pop();
                pre=top;
            }else{
                node=top.right;
            }

        }
        return list;
    }
    //层次遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>>list=new ArrayList<>();
       if(root==null)return list;
       Queue<TreeNode>queue=new LinkedList<>();
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
}
