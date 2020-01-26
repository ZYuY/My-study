import java.util.Properties;

class Node{
    /**
     * 链表
     */
    Node next;
    int value;

    public Node(Node next) {
        this.next=next;
    }

    public Node(int value) {
        this.value = value;
    }
    public String toString(){
        return String.format("Node(%d)",value);
    }
}
public class LinkedDemo {
    /**
     * 链表
     */
    //头插
    public  static Node pushFront(Node head,int telement){
        Node node=new Node(telement);
        node.next=head;
        return node;
    }
    //尾插(如果head为null如果head不为null）
    public  static Node  pushBack(Node head,int telement){
        Node node=new  Node(telement);
        if(head==null){
            return node;
        }else{
            Node pre=head;
            while(pre.next!=null){
                pre=pre.next;
            }
            pre.next=node;
            return head;
        }
    }
    //头删
    public static Node popFront(Node head){
        if(head==null){
            System.out.println("链表为null");
            return null;
        }
       return head.next;
    }
    //尾删(要考虑链表个数为0和为1）
    public static  Node popBack(Node head){
        if(head==null){
            System.out.println("链表为null");
            return null;
        }
        if(head.next==null)
            return null;
        else{
            Node pre=head;
            while(pre.next.next!=null){
                pre=pre.next;
            }
            pre.next=null;
            return head;
        }
    }
    public static void main(String[] args) {
        Node head=null;
        head=pushBack(head,1);
        head=pushBack(head,2);
        head=pushFront(head,3);
        Print(head);
        head=popBack(head);
        head=popFront(head);
        Print(head);
    }
    public static void Print(Node head){
        System.out.println("打印链表");
        for(Node pre=head;pre!=null;pre=pre.next){
            System.out.print(pre+"--->");
        }
        System.out.println("null");
    }
}
