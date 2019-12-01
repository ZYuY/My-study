public class Text {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode pre1=list1;
        ListNode pre2=list2;
        ListNode node=new ListNode(0);
        ListNode head=node;
        while(pre1!=null&&pre2!=null){
            if(pre1.val<pre2.val){
                node.next=pre1;
                node=node.next;
                pre1=pre1.next;
            }else{
                node.next=pre2;
                node=node.next;
                pre2=pre2.next;
            }
        }
        if(pre1!=null){
            node.next=pre1;
        }else if(pre2!=null) {
            node.next = pre2;
        }else{
            node.next=null;
        }
        return head.next;
    }
}
