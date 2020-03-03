import java.util.*;

class Node{
    Node left;
    Node right;
    int val;
    Node(int val){
        this.val=val;
    }
}
public class Text3 {
    //层序遍历
    public static List<List<Integer>> bianli(Node node){
        List<List<Integer>>result=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        if(node==null)return result;
        queue.add(node);
        int lev=0;
        while(!queue.isEmpty()){
            result.add(new ArrayList<>());
            int len=queue.size();
            for(int i=0;i<len;i++){
                Node p=queue.remove();
                result.get(lev).add(p.val);
                if(p.left!=null)
                    queue.add(p.left);
                if(p.right!=null)
                    queue.add(p.right);

            }
            lev++;
        }
        return result;
    }
//非递归前序遍历
    public static List<Integer> pre(Node node){
        List<Integer>list=new ArrayList<>();
        Stack<Node>stack=new Stack<>();
        if(node==null)return list;
        Node pre=node;
        while(!stack.isEmpty()||pre!=null){
            while(pre!=null) {
                list.add(pre.val);
                stack.push(pre);
                pre = pre.left;
            }
            Node cur=stack.pop();
            pre=cur.right;
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
        System.out.println(bianli(p));
    }
}
