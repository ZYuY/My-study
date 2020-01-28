import java.util.List;

class ListNode {
      int val;
      ListNode next;
 ListNode(int x) { val = x; }
 }
public class Text2 {
    //移除链表元素
    public ListNode removeElements(ListNode head, int val) {
      ListNode result=new ListNode(0);
      result.next=head;
      ListNode pre=result;
      while(pre.next!=null){
          if(pre.next.val==val){
              pre.next=pre.next.next;
          }else{
              pre=pre.next;
          }
      }
      return result.next;
    }
    //反转链表
    public ListNode reverseList(ListNode head) {
        ListNode result=null;
        ListNode pre=head;
        if(head==null)
            return null;
        while(pre!=null){
            ListNode next=pre.next;
            pre.next=result;
            result=pre;
            pre=next;
        }
        return result;
    }
    //链表的中间结点(快慢指针）
    public ListNode middleNode(ListNode head) {
        if(head==null)
            return null;
        ListNode p1=head;
        ListNode p2=head.next;
        while(p2!=null){
            p1=p1.next;
            p2=p2.next;
            if(p2!=null){
                p2=p2.next;
            }
        }
        return p1;
    }
    //链表中倒数第k个结点
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null)
            return null;
        ListNode pre2=head;
        for(int i=0;i<k;i++){
            if(pre2==null){
                return null;
            }
            pre2=pre2.next;
        }
        ListNode pre1=head;
        while(pre2!=null){
            pre1=pre1.next;
            pre2=pre2.next;
        }
        return pre1;
    }
    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode pre1=l1;
        ListNode pre2=l2;
        ListNode result=new ListNode(0);
        ListNode res=result;
        while(pre1!=null&&pre2!=null){
            if(pre1.val<=pre2.val){
                res.next=pre1;
                pre1=pre1.next;
            }else{
                res.next=pre2;
                pre2=pre2.next;
            }
            res=res.next;
        }
        if(pre1!=null){
            res.next=pre1;
        }else{
            res.next=pre2;
        }
        return result.next;
    }
    //链表分割
    public ListNode partition(ListNode pHead, int x) {
        if(pHead==null)
            return null;
        ListNode first=new ListNode(0);
        ListNode f=first;
        ListNode last=new ListNode(0);
        ListNode l=last;
        ListNode pre=pHead;
        while(pre!=null){
            ListNode next=pre.next;
            if(pre.val<x){
                f.next=pre;
                pre=next;
                f=f.next;
            }else{
                l.next=pre;
                pre=next;
                l=l.next;
            }
        }
        l.next=null;
        f.next=last.next;
        return first.next;
    }
    //删除链表的重复结点
    public ListNode deleteDuplication(ListNode pHead) {
//        if(pHead==null)
//            return null;
//        ListNode st=null;
//        ListNode pre=pHead;
//        ListNode cur=pHead.next;
//        while(cur!=null){
//            if(cur.val!=pre.val){
//                st=pre;
//                pre=cur;
//                cur=cur.next;
//            }else{
//                while(cur!=null&&pre.val==cur.val){
//                    cur=cur.next;
//                }
//                if(st==null){
//                    pHead=cur;
//                }else{
//                    st.next=cur;
//                }
//                pre=cur;
//                if(cur!=null)
//                    cur=cur.next;
//            }
//        }
//        return pHead;
        /**
         *  if(pHead==null)
         *             return null;
         *         ListNode pre=new ListNode(0);
         *         pre.next=pHead;
         *         ListNode p1=pre;
         *         ListNode p2=pHead;
         *         ListNode p3=pHead.next;
         *         while(p3!=null){
         *             if(p2.val!=p3.val){
         *                 p1=p2;
         *                 p2=p3;
         *                 p3=p3.next;
         *             }else{
         *                 while(p3!=null&&p2.val==p3.val){
         *                     p3=p3.next;
         *                 }
         *                 p1.next=p3;
         *                 p2=p3;
         *                 if(p3!=null)
         *                 p3=p3.next;
         *             }
         *         }
         *         return pre.next;
         **/

      }
}
