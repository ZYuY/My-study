import java.util.List;

public class Telephone {
    class Node{
        String name;
        String phone;
        //List<String> phone;
        Node left;
        Node right;

        public Node(String name, String phone) {
            this.name=name;
            this.phone=phone;
        }
    }
   private Node root=null;
//姓名没有重复的，电话可以有重复的
    //插入
    public boolean insert(String name,String phone){
        if(root==null){
            root=new Node(name,phone);
            return true;
        }
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            int r=name.compareTo(cur.name);
            if(r==0){
                return false;
            }else if(r<0){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        int k=name.compareTo(parent.name);
        Node node=new Node(name,phone);
        if(k>0){
            parent.right=node;
        }else{
            parent.left=node;
        }
        return true;
    }
    //修改 返回原来的值
    public String update(String name,String phone){
        Node cur=root;
        while(cur!=null){
            int r=name.compareTo(cur.name);
            if(r==0){
                String oldphone=cur.phone;
                cur.phone=phone;
                return oldphone;
            }else if(r<0){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return null;
    }
    //查找
    public String search(String name){
        Node cur=root;
        while(cur!=null){
            int r=name.compareTo(cur.name);
            if(r==0){
                return cur.phone;
            }else if(r<0){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return null;
    }
}
