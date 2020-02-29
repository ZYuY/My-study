import java.util.*;
class a{
    protected int b=10;

}
class Node{
    Node left=null;
    Node right=null;
    int val;
    Node(int val){
        this.val=val;
    }
}
public class Text {

    /**
     * 层序遍历
     */
    public  static List<List<Integer>> bianli(Node head){
        List<List<Integer>>lists=new ArrayList<>();
        if(head==null)return lists;
        Queue<Node>queue=new LinkedList<>();
        queue.add(head);
        int lev=0;
        while(!queue.isEmpty()){
            lists.add(new ArrayList<>());
            int len=queue.size();
            for(int i=0;i<len;i++){
                Node pre=queue.remove();
                lists.get(lev).add(pre.val);
                if(pre.left!=null)
                    queue.add(pre.left);
                if(pre.right!=null)
                    queue.add(pre.right);
            }
            lev++;
        }
        return lists;
    }
    /**
     * 非递归前序遍历
     */
    public static List<Integer> pre(Node root){
        List<Integer>lists=new ArrayList<>();
        if(root==null)return lists;
        Stack<Node>stack=new Stack<>();
        Node pre=root;
      while(!stack.isEmpty()||pre!=null){
          while(pre!=null){
              lists.add(pre.val);
              stack.push(pre);
              pre=pre.left;
          }
          Node top=stack.pop();
          pre=top.right;
      }
      return lists;
    }
    /**
     * 非递归中序遍历
     */
    public static List<Integer>inorder(Node root){
        List<Integer>lists=new ArrayList<>();
        if(root==null)return lists;
        Stack<Node>stack=new Stack<>();
        Node pre=root;
        while(!stack.isEmpty()||pre!=null){
            while(pre!=null){
                stack.push(pre);
                pre=pre.left;
            }
            Node top=stack.pop();
            lists.add(top.val);
            pre=top.right;
        }
        return lists;
    }
    /**
     * 非递归后续遍历
     */
    public static List<Integer>post(Node root){
        List<Integer>lists=new ArrayList<>();
        if(root==null)return lists;
        Stack<Node>stack=new Stack<>();
        Node pre=root;
        Node key=null;
        while(!stack.isEmpty()||pre!=null) {
            while (pre != null) {
                stack.push(pre);
                pre = pre.left;
            }
            Node top = stack.peek();
            if (top.right == null || top.right == key) {
                lists.add(top.val);
                stack.pop();
                key = top;
            } else {
                pre = top.right;
            }
        }
        return lists;
    }
    /**
     * 插入排序
     */
    /**
     * 选择排序
     */
    /**
     * 堆排序
     */
    /**
     * 快速排序
     */
    /**
     * 归并排序
     */
    private static int g=20;
    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE; System.out.println(maxValue+1);
        int minValue = Integer.MIN_VALUE; System.out.println(minValue-1);
double a=1;
Node node=new Node(1);
int k=g;
Text text=new Text();
int y=text.g;
    }

    private class c{
        private int d=10;
    }
}
