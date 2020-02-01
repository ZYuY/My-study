import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BinaryTree {
    private static  class Node{
        private  char val;
        private  Node left=null;
        private  Node right=null;
        private Node(char val){this.val=val;}
        public String toString(){
            return String.format("{%c}",val);
        }
    }
    public static Node buildTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        e.right = h;

        return a;
    }
    //前序遍历
    public static void preOrderTraversal(Node root){
        if(root==null)
            return;
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //中序遍历
    public static void inOrderTraversal(Node root) {
        if(root==null)
            return;
        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }
    //后序遍历
    public static void postOrderTraversal(Node root){
        if(root==null)
            return ;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val);
    }
    //结点个数
   public static int count=0;
    public static void getSize(Node root){
        if(root==null)
            return;
        count++;
        getSize(root.left);
        getSize(root.right);
    }
    public static int getSize2(Node root){
        if(root==null)
            return 0;
        int a=getSize2(root.left);
        int b=getSize2(root.right);
        return a+b+1;
    }
    private static List<Character>list=new ArrayList<>();
    private static void inorderReturnList(Node root) {
        if(root!=null){
            inorderReturnList(root.left);
            list.add(root.val);
            inorderReturnList(root.right);
        }
    }

    private static List<Character> inorderReturnList2(Node root){
        List<Character>list=new ArrayList<>();
        if(root==null)
            return list;
        list.addAll(inorderReturnList2(root.left));
        list.add(root.val);
        list.addAll(inorderReturnList2(root.right));
        return list;
    }
    //叶子结点个数
    private static int leftsize=0;
    private static void getLeafSize(Node root) {
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
            leftsize++;
        getLeafSize(root.left);
        getLeafSize(root.right);
    }
    private static int getLeafSize2(Node root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 1;
        int a=getLeafSize2(root.left);
        int b=getLeafSize2(root.right);
        return a+b;
    }

    //树的高度
    public static int getHeight(Node root) {
        if(root==null)
            return 0;
        int a=getHeight(root.left);
        int b=getHeight(root.right);
        return Math.max(a,b)+1;
    }
    //求第k层结点个数
    public static int getKLevel(Node root, int k){
        if(root==null)
            return 0;
        if(k==1)
            return 1;
        return getKLevel(root.left,k-1)+getKLevel(root.right,k-1);
    }
    //查找val所在的结点
    public static Node find(Node root, int val) {
        if(root==null)
            return null;
        if(root.val==val)
            return root;
        Node n=find(root.left,val);
        if(n!=null){
            return n;
        }
        return find(root.right,val);
    }
    public static boolean find2(Node root, int val){
        if(root==null) return false;
        if(root.val==val) return true;
        if(find2(root.left,val))
            return true;
        return find2(root.right,val);
    }
    public static boolean find3(Node root, int val) {
        return root != null
                && (
                root.val == val
                        || find3(root.left, val)
                        || find3(root.right, val)
        );
    }
    public static void main(String[] args) {
        Node root = buildTree();
        System.out.println("Success");
        preOrderTraversal(root);
        System.out.println("====================");
        inOrderTraversal(root);
        System.out.println("====================");
        postOrderTraversal(root);
        System.out.println("====================");
        count = 0;
        getSize(root);
        System.out.println("结点个数: " + count);
        System.out.println("结点个数: " + getSize2(root));
        System.out.println(find2(root,'H'));

        System.out.println("====================");
        list.clear();
        inorderReturnList(root);
        System.out.println(list);
        System.out.println(inorderReturnList2(root));
        System.out.println("====================");
        leftsize = 0;
        getLeafSize(root);
        System.out.println("叶子结点个数： " + leftsize);
        System.out.println(getLeafSize2(root));
        System.out.println("====================");
        System.out.println(getHeight(root));
        System.out.println("====================");
        System.out.println(getKLevel(root, 1)); // 1
        System.out.println(getKLevel(root, 2)); // 2
        System.out.println(getKLevel(root, 3)); // 4
        System.out.println(getKLevel(root, 4)); // 1
        System.out.println(getKLevel(root, 5)); // 0
        Random random = new Random(20190917);
        for (int i = 0; i < 70; i++) {
            System.out.println(random.nextInt(70));
        }
    }
}
