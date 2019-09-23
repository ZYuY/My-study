import java.util.Stack;

public class Iterationtree {
    public static Node buildTree(){
        Node n1=new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n3.left=n5;
        n3.right=n6;
        return n1;
    }
    //前序（迭代
    public static void preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }
            Node top = stack.pop();
            node = top.right;
        }
    }
    //中序
        public static void inorder(Node root) {
            Stack<Node> stack = new Stack<>();
            Node node = root;
            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                Node top = stack.pop();
                System.out.println(top.val);
                node = top.right;
            }
        }
        //后续
            public static void postorder(Node root){
                Stack<Node> stack = new Stack<>();
                Node node = root;
                Node last=null;//上次被遍历完的结点
                while(!stack.isEmpty()||node!=null){
                    while(node!=null){
                        stack.push(node);
                        node=node.left;
                    }
                    Node top=stack.peek();
                    if(top.right==null||top.right==last){
                        System.out.println(top.val);
                        stack.pop();
                        last=top;
                    }else{
                        node=top.right;
                    }
                }
            }
    public static void main(String[] args) {
        Node root = buildTree();
        preorder(root);
        System.out.println("==================");
        inorder(root);
        System.out.println("==================");
        postorder(root);
    }
}
