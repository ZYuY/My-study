 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution2 {
    //链表分割

    /**
     * 注意big.next一定要置空
     * @param pHead
     * @param x
     * @return
     */
    public ListNode partition(ListNode pHead, int x) {
        if(pHead==null||pHead.next==null)
            return pHead;
        ListNode small=new ListNode(0);
        ListNode s=small;
        ListNode big=new ListNode(0);
        ListNode b=big;
        ListNode pre=pHead;
        while(pre!=null){
            if(pre.val<x){
                small.next=pre;
                small=small.next;
            }else{
                big.next=pre;
                big=big.next;
            }
            pre=pre.next;
        }
        big.next=null;
        small.next=b.next;
        return s.next;
    }
}
