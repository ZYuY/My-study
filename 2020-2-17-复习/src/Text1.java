 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Text1 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null)return list2;
        if(list2==null)return list1;
        ListNode result=new ListNode(0);
        ListNode head=result;
        ListNode pre1=list1;
        ListNode pre2=list2;
        while(pre1!=null&&pre2!=null){
            if(pre1.val<pre2.val){
                head.next=pre1;
                head=pre1;
                pre1=pre1.next;
            }else{
                head.next=pre2;
                head=pre2;
                pre2=pre2.next;
            }

        }
        if(pre1!=null){
            head.next=pre1;
        }
        if(pre2!=null){
            head.next=pre2;
        }
        return result.next;
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null)return null;
        if(pHead2==null)return null;
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        int len1=getLength(pHead1);
        int len2=getLength(pHead2);
        int k=0;
        if(len1<len2){
            p1=pHead2;
            p2=pHead1;
            k=len2-len1;
        }
        k=len1-len2;
        for(int i=0;i<k;i++){
            p1=p1.next;
        }
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }
    public static int getLength(ListNode phead){
        if(phead==null)return 0;
        int count=0;
        ListNode p=phead;
        while(p!=null){
            count++;
            p=p.next;
        }
        return count;
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null)return null;
        ListNode p1=pHead;
        ListNode p2=pHead;
        do{
            p1=p1.next;
            if(p1==null)
                return null;
            else
                p1=p1.next;
            p2=p2.next;
        }while(p1!=p2);
        ListNode p3=pHead;
        while(p1!=p3){
            p1=p1.next;
            p3=p3.next;
        }
        return p3;
    }
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode head=new ListNode(0);
        head.next=pHead;
        if(pHead==null)return null;
        ListNode p1=head;
        ListNode p2=pHead;
        ListNode p3=pHead.next;
        while(p3!=null){
            if(p2.val!=p3.val){
                p1=p1.next;
                p2=p2.next;
                p3=p3.next;
            }else{
                while(p3!=null&&p2.val==p3.val){
                    p3=p3.next;
                }
                p1.next=p3;
                p2=p3;
                if(p3!=null)
                    p3=p3.next;
            }

        }
        return head.next;
    }
}
