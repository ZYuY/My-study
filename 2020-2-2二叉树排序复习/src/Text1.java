import sun.reflect.generics.tree.Tree;

import java.sql.Statement;
import java.util.*;

public class Text1 {
    //二叉树的层次遍历
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int lev = 0;
        while (!queue.isEmpty()) {
            result.add(new ArrayList<>());
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                result.get(lev).add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            lev++;
        }
        return result;
    }

    //二叉树非递归前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            TreeNode top = stack.pop();
            node = top.right;
        }
        return list;
    }

    //非递归中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode top = stack.pop();
            list.add(top.val);
            node = top.right;
        }
        return list;
    }

    //非递归后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        TreeNode node = root;
        TreeNode pre = null;//上次被遍历完的结点
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null || top.right == pre) {
                list.add(top.val);
                stack.pop();
                pre = top;
            } else {
                node = top.right;
            }
        }
        return list;
    }
/**
    //二叉树的分层遍历
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
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
 **/

}