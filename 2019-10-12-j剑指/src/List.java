class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val=val;
    }
}
public class List {
    //头插
    public Node preorder(Node head,int val){
        Node node=new Node(val);
        node.next=head;
        head=node;
        return head;
    }
    //尾插
    public Node lastinsert(Node head,int val){
        Node node=new Node(val);
        Node pre=head;
        if(head==null){
            head=node;
        }else{
            while(pre.next!=null){
                pre=pre.next;
            }
            pre.next=node;
        }
        return head;
    }

    //头删
    public Node firstdel(Node head){
        if(head==null)
            return null;
        return head.next;
    }
    //尾删
    public Node lastdel(Node head){
        if(head==null||head.next==null)
            return null;
        Node pre=head;
        while(pre.next.next!=null){
            pre=pre.next;
        }
        pre.next=null;
        return head;
    }
}
