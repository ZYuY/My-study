class Node{
    Node next;
    int val;

    public Node(Node next) {
        this.next = next;
    }
    public Node(int val){
        this.val=val;
    }
}
public class MyArrayList {
    //逆置链表
    public static Node reverse(Node head){
     Node result=null;
     Node cur=head;
     while(cur!=null){
         Node pre=cur.next;
         cur.next=result;
         result=cur;
         cur=pre;
     }
     return result;
    }
}
