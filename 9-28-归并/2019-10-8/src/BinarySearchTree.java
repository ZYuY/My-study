public class BinarySearchTree {
    //搜索树
   public static class Node{
       int key;
       Node left;
       Node right;

        public Node(int key) {
            this.key=key;
        }
    }
   private Node root=null;
    /**
     * 在搜索树中查找 key，如果找到，返回 key 所在的结点，否则返回 null
     * @param key
     * @return
     */
    public Node search(int key) {
        Node node=root;
        while(node!=null){
            if(node.key==key)
                return node;
            else if(node.key>key){
                node=node.left;
            }else{
                node=node.right;
            }
        }
        return null;
    }
    //插入key 成功返回true
    //先查找
    /**
     * 插入
     * @param key
     * @return true 表示插入成功, false 表示插入失败
     */
    public boolean insert(int key){
        if(root==null){//必须判断根是否为空的情况
            root=new Node(key);
            return true;
        }
        Node node=root;
        Node result=new Node(key);
        Node parent=null;
        while(node!=null){
            if(key==node.key){
                return false;
            }else if(key<node.key){
                parent=node;
                node=node.left;
            }else{
                parent=node;
                node=node.right;
            }
        }
        if(parent.key>key){
            parent.left=result;
        }else{
            parent.right=result;
        }
        return true;
    }
    //前序遍历
    public static void preorder(Node root){
        if(root!=null){
            System.out.println(root.key);
            preorder(root.left);
            preorder(root.right);
        }
    }
    //中序遍历
    public static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.key);
            inorder(root.right);
        }
    }
    //删除
    /**
     * 删除   先查找 成功返回 true，失败返回 false
     * @param key
     * @return
     */
    public boolean remove(int key){
       Node node=root;
       Node parent=null;
       while(node!=null){
           if(key==node.key){
               removeNode(node,parent);
               return true;
           }else if(key<node.key){
               parent=node;
               node=node.left;
           }else{
               parent=node;
               node=node.right;
           }
       }
       return false;
    }
    private void removeNode(Node node,Node parent) {
       if(node.left==null){
           if(node==root){
               root=node.right;
           }else if(node==parent.left){
               parent.left=node.right;
           }else{
               parent.right=node.right;
           }
       }else if(node.right==null){
           if(node==root){
               root=node.left;
           }else if(node==parent.left){
               parent.left=node.left;
           }else{
               parent.right=node.left;
           }
       }else{
           //替换法  左边找最大的用来替换根，或者右边找最小的来替换
           Node goad=node.right;
           Node goadparent=node;
           while(goad.left!=null){
               goadparent=goad;
               goad=goad.left;
           }
           node.key=goad.key;
           if(goadparent.left==goad){
               goadparent.left=goad.right;
           }else{
               goadparent.right=goad.right;
           }
       }
    }

    public static void main(String[] args) {
        BinarySearchTree tree=new BinarySearchTree();
        int[]keys={3,9,7,4,1,6,2,8,5};
        for(int key:keys){
            System.out.println(tree.insert(key));
        }
        System.out.println("插入重复数据");
        System.out.println(tree.insert(7));
        System.out.println("前序遍历");
        preorder(tree.root);
        System.out.println("中序遍历");
        inorder(tree.root);
        System.out.println(tree.search(7).key);
        System.out.println(tree.search(8).key);

    }
}
