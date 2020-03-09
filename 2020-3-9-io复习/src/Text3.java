import java.util.*;

class Node{
    Node left;
    Node right;
    int val;
        }
public class Text3 {
    //二叉树层序遍历
    public static List<List<Integer>> tree(Node head){
        List<List<Integer>>lists=new ArrayList<>();
        if(head==null)return lists;
        Queue<Node> queue=new LinkedList<>();
        queue.add(head);
        Node pre=head;
        int lev=0;
        while(!queue.isEmpty()){
            lists.add(new ArrayList<>());
            int len=queue.size();
            for(int i=0;i<len;i++){
                Node node=queue.remove();
                lists.get(lev).add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            lev++;
        }
        return lists;
    }
    //二叉树非递归前序遍历
    public static List<Integer> inorder(Node head){
        List<Integer>list=new ArrayList<>();
        if(head==null)return null;
        Stack<Node> stack=new Stack<>();
        Node node=head;
        while(!stack.isEmpty()||node!=null){
            while(node!=null){
                stack.push(node);
                list.add(node.val);
                node=node.left;
            }
            Node top=stack.pop();
            node=top.right;
        }
        return list;
    }
    //二叉树非递归中序遍历
    public static List<Integer>order(Node head){
        List<Integer>list=new ArrayList<>();
        if(head==null)return list;
        Node node=head;
        Stack<Node>stack=new Stack<>();
        while(!stack.isEmpty()||node!=null){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            Node top=stack.pop();
            list.add(top.val);
            node=top.right;
        }
        return list;
    }
    //二叉树非递归后序遍历
    public static List<Integer>forder(Node head){
        List<Integer>list=new ArrayList<>();
        if(head==null)return list;
        Node node=head;
        Stack<Node>stack=new Stack<>();
        Node pre=null;
        while(!stack.isEmpty()||node!=null){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            Node top=stack.peek();
            if(top.right==null||top.right==pre){
                list.add(top.val);
                stack.pop();
            }else{
                node=top.right;
            }
        }
        return list;
    }
}
