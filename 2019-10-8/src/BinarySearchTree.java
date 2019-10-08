public class BinarySearchTree {
    public static class Node{
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key=key;
        }
    }
   private  Node root=null;
    //查找key
    public Node search(int key) {
        Node cur = root;
        while (cur != null) {
            if (key == cur.key) {
                return cur;
            } else if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }
    //插入key 成功返回true
    //先查找
    public boolean insert(int key){
        Node cur = root;
        Node parent=null;//双亲
        if(root==null){
            Node node=new Node(key);
            root=node;
        }
        while (cur != null) {
            if (key == cur.key) {
                return false;
            } else if (key < cur.key) {
                parent=cur;
                cur = cur.left;
            } else {
                parent=cur;
                cur = cur.right;
            }
        }
        Node node=new Node(key);
        if(parent.key>key){
            parent.left=node;
        }else{
            parent.right=node;
        }

        return true;
    }
    //前序遍历
    public void preorder(Node root){
        if(root!=null){
            System.out.println(root.key);
            preorder(root.left);
            preorder(root.right);
        }
    }
    //中序遍历
    public void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.key);
            inorder(root.right);
        }
    }
    //删除
    public boolean remove(int key){
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(key==cur.key){
                removeNode(cur);
            }
        }
    }

    private void removeNode(Node cur) {
        Node parent=null;
        if(cur.left==null){
            if(cur==root){
                root=cur.right;
            }else if (cur==parent.left){
                parent.left=cur.right;
            }else{
                parent.right=cur.right;
            }
        }else if(cur.right==null){
            if(cur==root){
                root=cur.left;
            }else if(cur==parent.left){
                parent.left=cur.left;
            }else{
                parent.right=cur.left;
            }

        }else{

        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree=new BinarySearchTree();
        int[]array={5,3,1,2,7,6,8,10};
        tree.search(3);
        tree.insert(20);
    }
}
