public class Text {
    //链式A+B

    /**
     * 两个链表可能不一样长
     * 就把短的为null的话置为0
     */
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode plusAB(ListNode a, ListNode b) {
   ListNode pre1=a;
   ListNode pre2=b;
   ListNode node=new ListNode(0);
   ListNode result=node;
   ListNode head=null;
   int k=0,sum=0,p=0,q=0;
   while(pre1!=null||pre2!=null||k!=0){
       p=(pre1==null?0:pre1.val);
       q=(pre2==null?0:pre2.val);
       sum=p+q+k;
       head=new ListNode(sum%10);
       k=sum/10;
       node.next=head;
       node=node.next;
       pre1=(pre1==null?null:pre1.next);
       pre2=(pre2==null?null:pre2.next);
   }
   node.next=null;
   return result.next;
    }
}
