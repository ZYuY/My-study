class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Text4 {
    /**
     * 链表中环的入口结点
     * 先找到相遇节点，利用快慢指针，一个走一步，一个走两步
     * 下来一个指针从头节点开始，一个指针从相遇节点开始，每个指针只走一步
     * 相遇的结点就是它的环的入口结点。
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode p1=pHead;
        ListNode p2=pHead;
        do{
            if(p1==null)
                return null;
            p1=p1.next;
            if(p1==null)
                return null;
            p1=p1.next;
            p2=p2.next;
        }while(p1!=p2);
        ListNode p3=pHead;
        while(p1!=p3){
            p1=p1.next;
            p3=p3.next;
        }
        return p1;
    }
}
