import java.util.*;

class Node{
    Node left;
    Node right;
    int val;
    Node(int val){
        this.val=val;
    }
}
public class Text {
    //层序遍历
    public static List<List<Integer>> cengxu(Node root){
        List<List<Integer>>list=new ArrayList<>();
        Queue<Node>queue=new LinkedList<>();
        if(root==null)return list;
        queue.add(root);
        int lev=0;
        while(!queue.isEmpty()){
            list.add(new ArrayList<>());
            int len=queue.size();
            for(int i=0;i<len;i++){
                Node p=queue.remove();
                list.get(lev).add(p.val);
                if(p.left!=null)
                    queue.add(p.left);
                if(p.right!=null)
                    queue.add(p.right);
            }
            lev++;
        }
        return list;
    }
    //前序非递归
    public static List<Integer> pre(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) return list;
        Node node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                list.add(node.val);
                node = node.left;
            }
            Node top = stack.pop();
            node = top.right;
        }
        return list;
    }
    //非递归中序遍历
    public static List<Integer>inorder(Node root){
        List<Integer>list=new ArrayList<>();
        Stack<Node>stack=new Stack<>();
        if(root==null)return list;
        Node node=root;
        while(!stack.isEmpty()||node!=null){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            Node top=stack.pop();
            list.add(node.val);
            node=top.right;
        }
        return list;
    }
    //非递归后序遍历
    public static List<Integer>ord(Node root){
        List<Integer>list=new ArrayList<>();
        Stack<Node>stack=new Stack<>();
        if(root==null)return list;
        Node pre=root;
        Node cur=null;//上次遍历的结点
        while(!stack.isEmpty()||pre!=null){
            while(pre!=null){
                stack.push(pre);
                pre=pre.left;
            }
            Node top=stack.peek();
            if(top.right==null||top.right==cur){
                list.add(top.val);
                cur=top;
                stack.pop();
            }else{
                pre=top.right;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Node a=new Node(3);
        Node b=new Node(4);
        Node d=new Node(7);
        Node f=new Node(0);
        Node k=new Node(9);
        a.left=b;
        a.right=d;
        b.left=f;
        b.right=k;
        Node p=a;
        System.out.println(ord(p));
    }
}
