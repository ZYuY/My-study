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
    Node root=null;
//姓名没有重复的，电话可以有重复的
    public boolean insert(String name,String phone){
        Node cur=root;
        Node parent=null;
        int r=name.compareTo(cur.name);
        while(cur!=null){
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
}
