public class Solution {
    //链式A+B
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode plusAB(ListNode a, ListNode b) {
        if(a==null||b==null)
            return null;
        ListNode result=new ListNode(0);
        ListNode r=result;
        ListNode l1=a;
        ListNode l2=b;
        result.next.val=(l1.val+l2.val)%10;
        result=result.next;
        l1=l1.next;
        l2=l2.next;
        int k=(l1.val+l2.val)/10;
        while(l1!=null&&l2!=null){
            result.val=(l1.val+l2.val+k)%10;
            k=(l1.val+l2.val)/10;
            l1=l1.next;
            l2=l2.next;
            result=result.next;
        }
        if(k==0) {
            if (l1 != null)
                result.next = l1;
            if (l2 != null)
                result.next = l2;
        }else{
            while(l1!=null){
                result.val=k+l1.val;
                k=(k+l1.val)/10;
                result=result.next;
                l1=l1.next;
            }
            while(l2!=null){
                result.val=k+l2.val;
                k=(k+l2.val)/10;
                result=result.next;
                l2=l2.next;
            }
        }
        return reserve(r.next);
    }

    private ListNode reserve(ListNode b) {
        if(b==null)
            return null;
        ListNode pre=b;
        ListNode node=null;
        ListNode next;
        while(pre!=null){
            next=pre.next;
            pre.next=node;
            node=pre;
            pre=next;
        }
        return node;
    }
}
