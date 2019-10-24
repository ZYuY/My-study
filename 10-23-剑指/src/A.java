public class A {
    //逆置链表
  class  Node{
        Node next;
        int val;
        Node(int val){
            this.val=val;
        }
    }
    Node root;
    public Node reverseList(Node root){
        Node node=root;
        Node result=null;
        Node next;
        while(node!=null){
            next=node.next;
            node.next=result;
            result=node;
            node=next;
        }
        return result;
    }


}
