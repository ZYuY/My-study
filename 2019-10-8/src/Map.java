import java.util.HashSet;
import java.util.Set;

public class Map {
    class Node{
        int key;
        int val;
        Node left;
        Node right;

        public Node(int key, int val) {
            this.key=key;
            this.val=val;
        }
        public int getKey(){
            return key;
        }
        public int getValue(){
            return val;
        }
    }
    private Node root=null;
    //get
    public int get(int key){
        Node cur=root;
        while(cur!=null){
            if(cur.key==key){
                return cur.val;
            }else if(key>cur.key){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }
        return -1;
    }
    //getOrDefault
    public int getOrDefaultdemo(int k,int v){
        Node cur=root;
        while(cur!=null){
            if(cur.key==k){
                return cur.val;
            }else if(cur.key>k){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return v;
    }
    //set
    public int set(int k,int v){
        if(root==null){
            root=new Node(k,v);
            return -1;
        }
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(cur.key==k){
                int oldval=cur.val;
                cur.val=v;
                return oldval;
            }else if(cur.key>k){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        Node node=new Node(k,v);
        if(k<parent.key){
            parent.left=node;
        }else{
            parent.right=node;
        }
        return -1;
    }
    //keySet
    public Set<Integer> keySet(){
        return inorder(root);
    }
    private Set<Integer>inorder(Node root){
        Set<Integer>set=new HashSet<>();
        if(root!=null){
            Set<Integer>left=inorder(root.left);
            Set<Integer>right=inorder(root.right);
            set.addAll(left);
            set.add(root.key);
            set.addAll(right);
        }
        return set;
    }
    public boolean containsKey(int key) {

        return get(key) != -1;
    }

    //remove
    public boolean removedemo(int k,int v){
        Node cur=root;
        Node parent=null;
        Node node=new Node(k,v);
        while(cur!=null){
            if(cur.val==v&&cur.key==k){
                removeNode(node,parent);
                return true;
            }else if(cur.key>k){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }
        return false;
   }

    private void removeNode(Node node, Node parent) {
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
}
