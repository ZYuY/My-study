public class Text1 {
    //搜索树
    public static  class Node{
        int key;
        Node left;
        Node right;
        public Node(int key){
            this.key=key;
        }
    }
    private Node root=null;

    /**
     * 在搜索树中查找key,找到返回key所在的结点，找不到返回null
     * @param key
     * @return
     */
    public Node search(int key){
       Node pre=root;
       while(pre!=null){
           if(key==pre.key){
               return pre;
           }else if(key<pre.key){
               pre=pre.left;
           }else{
               pre=pre.right;
           }
       }
       return null;
    }

    /**
     * 插入成功返回true，插入失败返回false
     *搜索树不允许key重复
     * 先找到合适的父母结点再插入
     * 根结点为null直接插入，
     */
    public boolean insert(int key){
       if(root==null){
           root=new Node(key);
           return true;
       }
       Node pre=root;
       Node parent=null;
       while(pre!=null){
           if(key==pre.key){
               return false;
           }else if(key<pre.key){
               parent=pre;
               pre=pre.left;
           }else{
               parent=pre;
               pre=pre.right;
           }
       }
       Node node=new Node(key);
       if(key<parent.key){
           parent.left=node;
       }else{
           parent.right=node;
       }
       return true;
    }
    /**
     * 删除成功返回true,失败返回false
     * 先查找，找到了再删除这个结点，
     */
    public  boolean remove(int key){
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(key==cur.key){
                removeNode(parent,cur);
                return true;
            }else if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        return false;
    }
    public void removeNode(Node parent,Node cur){
        if(cur.left==null){
            if(cur==root){
                root=cur.right;
            }else if(cur==parent.left){
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
            Node goatparent=cur;
            Node goat=cur.right;
            while(goat.left!=null){
                goatparent=goat;
                goat=goat.left;
            }
            cur.key=goat.key;
            if(goat==goatparent.left){
                goatparent.left=goat.right;
            }else{
                goatparent .right=goat.right;
            }
        }
    }
    public static void main(String[] args) {
        // 1. 创建搜索树
        // 2. 随机插入一些数据
        // 3. 打印前序 + 中序遍历
        // 4. 查找
        Text1 tree = new Text1();
        int[] keys = { 3, 9, 7, 4, 1, 6, 2, 8, 5 };
        for (int key : keys) {
            System.out.println(tree.insert(key));
        }
        System.out.println("插入重复数据");
        System.out.println(tree.insert(7));

        System.out.println("前序遍历");
        preOrder(tree.root);
        System.out.println("中序遍历");
        inOrder(tree.root);

        System.out.println(tree.search(7).key);
        System.out.println(tree.search(8).key);
        System.out.println(tree.search(5).key);
    }

    private static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    private static void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
