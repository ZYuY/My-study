import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public void reorderList(ListNode head) {
        LinkedList<ListNode> queue=new LinkedList<>();
        if(head==null)return;
        ListNode pre=head;
        while(pre!=null){
            queue.add(pre);
            pre=pre.next;
        }
        while(!queue.isEmpty()){
            if(pre==null){
                pre= queue.pollFirst() ;
            }else{
                pre.next=queue.pollFirst();
                pre=pre.next;
            }
            pre.next=queue.pollLast();
            pre=pre.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode result=new ListNode(0);
        ListNode res=result;
        int carry=0;
        while(l1!=null||l2!=null){
            int num1=l1==null?0:l1.val;
            int num2=l2==null?0:l2.val;
            int sum=num1+num2+carry;
            carry=sum/10;
            res.next=new ListNode(sum%10);
            res=res.next;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        if(carry>0){
            res.next=new ListNode(carry);
        }
        return result.next;
    }
}
