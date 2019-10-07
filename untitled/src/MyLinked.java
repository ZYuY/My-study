class Node{
    int val;
    Node next=null;
    public Node(int val){
        this.val=val;
    }
    public String toString(){
        return String.format("Node(%d)",val);
    }
}
public class MyLinked {
    public static  void main(String []args){
        Node head=null;

    }
    private static Node pushFront(Node head,int val){
        Node node=new Node(val);
        node.next=head;
        return node;
    }
    private static Node pushBack(Node head,int val){
        Node node=new Node(val);
        if(head==null){
            return node;
        }else{
            Node cur=head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
            return head;
        }
    }

    private static Node popFront(Node head){
        if(head==null){
            System.err.println("链表为空");
            return null;
        }
        return head.next;
    }
    private static Node popBack(Node head){
        if(head==null){
            System.err.println("链表为空");
            return null;
        }
        else if(head.next==null)
            return null;
        else{
            Node last=head;
            while(last.next.next!=null){
                last=last.next;
            }
            last.next=null;
            return head;
        }
    }
}

Node removeAll(Node head,int val){
    if(head==null)
        return null;
    Node pre=head;
    Node cur=head.next;
    while(cur!=null){
        Node next=cur.next;
        if(cur.val!=val){
            pre=cur;
        }else{
            pre.next=cur.next;
        }
        cur=next;
    }
    if(head.val==val)
        head=head.next;
    return head;
}
Node merge(Node head1,Node head2){
    if(head1==null)
        return head2;
    if(head2==null)
        return head1;
    Node cur1=head1;
    Node cur2=head2;
    Node result=null;
    Node last=null;
    while(cur1!=null&&cur2!=null){
        if(cur1.val<=cur2.val){
            Node next=cur1.next;
            if(result==null)
                result=cur1;
            else{
                last.next=cur1;
            }
            last=cur1;
            cur1=next;
        }
        else{
            Node next=cur2.next;
            if(result==null)
                result=cur2;
            else{
                last.next=cur2;
            }
            last=cur2;
            cur2=next;
        }
    }
    if(cur1!=null)
        last.next=cur1;
    else
        last.next=cur2;
    return result;
}
public Node partition(Node head,int x){
    Node min=null;
    Node max=null;
    Node cur=head;
    Node last1=null;
    Node last2=null;
    if(head==null)
        return null;
    while(cur!=null){
        if(cur.val<x){
            Node next=cur.next;
            cur.next=null;
            if(min==null)
            min=cur;
            else{
                last1.next=cur;
            }
            last1=cur;
            cur=next;
        }else{
            Node next=cur.next;
            cur.next=null;
            if(max==null) {
                max = cur;
            }
            else{
                last2.next=cur;
            }
            last2=cur;
            cur=next;
        }
    }

    if(last1==null)
        return max;
     else {
        last1.next = max;
        if(last2!=null){
            last2.next=null;
        }
        return min;
    }
}
public ListNode Find(ListNode head,int k){
    int length=0;
    ListNode cur=head;
    for(cur=head;cur!=null;cur=cur.next){
        length++;
    }
    ListNode st=head;
    int count=0;
    while(st!=null){
        st=st.next;
        count++;
        if(count==length-k+1)
            return st;
    }
    return null;
}
Node separateX(Node head,int x){
    Node cur=head;
    Node min=null;
    Node max=null;
    Node last1=null;
    Node last2=null;
    while(cur!=null){
        if(cur.val<x){
            if(min==null)
                min=cur;
            else{
                last1.next=cur;
            }
            last1=cur;
            cur=cur.next;
        }else{
            if(max==null)
                max=cur;
            else{
                last2.next=cur;
            }
            last2=cur;
            cur=cur.next;
        }
    }
    if(min==null)
        return max;
    else{
        last1.next=max;
        if(max!=null)
            last2.next=null;
        return min;
    }
}
Node deleteDuplicated(Node head){
    if(head==null)
        return null;
    Node cur=head.next;
    Node pre=head;
    while(cur!=null){
        if(cur.val!=pre.val){
            pre=pre.next;
            cur=cur.next;
        }
        else{
            if(cur.val!=pre.val){
                pre=cur;
            }
            else
                cur=cur.next;
        }

    }
}
Node copy(Node head){
    Node result=null;
    Node cur=head;
    Node last=null;

    while(cur!=null){
        Node node=new Node();
        node.val=cur.val;
        if(result==null)
            result=cur;
        else{
            last.next=cur;
        }
        last=cur;
        cur=cur.next;
    }
    return head;
}
CNode copy(CNode head){
    if(head==null)
        return null;
    CNode p1=head;
    while(p1!=null){
        CNode p2=new cNode();
        p2.val=p1.val;
        p2.random==null;
        p2.next=p1.next;
        p1.next=p2;
        p1=p2.next;
    }
     p1=head;
    while(p1!=null){
        CNode p2=p1.next;
        if(p2.random!=null){
            p2.random=p1.random.next;
        }
        p1=p2.next;
    }
    p1=head;
    while(p1!=null){


    }
}
public void popFront(){
    if(size<=0){
        System.out.println("cuowu");
        return ;
    }
    head= head.next;
    if(head!=null) {

        head.prev = null;
    }else
        last=null;
    size--;

}
void pushBack(int val){
    Node node=new Node(val);
    if(head!=null){
        last.next=node;
        node.prev=last;
        last=node;

    }
    else{
        head=node;
        last=node;
    }
    size++;
}
void popBack(){
    if(size<=0){
        System.out.println("cuowu");
        return ;
    }
    if(head.next
            !=null){
        last=last.prev;
        last.next=null;
    }else{
        head=last=null;
    }
    size--;
}
public void pop(int val) {


//    Node cur = head;
//    wile(cur!=null){
//        cur=cur.next;
//        if(cur=)
//    }
    Node node=new Node(val);
    for(int i=0;i<index;i++){
        cur=cur.next;
    }
    cur.prev.next=cur.next;
    cur.next.prev=cur.prev;

    
    size--;



}