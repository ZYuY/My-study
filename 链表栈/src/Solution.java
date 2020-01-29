 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    //链表的回文结构
    public boolean chkPalindrome(ListNode A){
        ListNode mid=Findmid(A);
        ListNode rev=reverse(mid);
        ListNode p1=A;
        ListNode p2=rev;
        while(p1!=null&&p2!=null){
            if(p1.val!=p2.val)
                return false;
            p1=p1.next;
            p2=p2.next;
        }
        return true;
   }
   public ListNode Findmid(ListNode head){
       ListNode l1=head;
       ListNode l2=head.next;
       while(l2!=null){
           l1=l1.next;
           l2=l2.next;
           if(l2!=null)
               l2=l2.next;
       }
       return l1;
   }
   public ListNode reverse(ListNode head){
        ListNode result=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=result;
            result=cur;
            cur=next;
        }
        return result;
   }
   /**
   //相交链表
    方法一：计算两个链表的长度，长的链表先走长度查，然后长短链表依次往后走知道相遇
    方法二：长短链表都从头开始，短的走到null就转到长链表的开头，长的走到null
    会转回到短的开头，知道相遇
    **/
   public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lenA=Length(headA);
        int lenB=Length(headB);
        int sub=lenA-lenB;
        ListNode p1=headA;
        ListNode p2=headB;
        if(lenB>lenA){
            p1=headB;
            p2=headA;
            sub=lenB-lenA;
        }
        for(int i=0;i<sub;i++){
            p1=p1.next;
        }
        while(p1!=null&&p2!=null&&p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
   }
   public static int Length(ListNode head){
        ListNode pre=head;
        int count=0;
        while(pre!=null){
            count++;
            pre=pre.next;
        }
        return count;
   }
   //方法二
   public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
       if(headA==null||headB==null)
           return null;
       ListNode pA=headA;
       ListNode pB=headB;
       while(pA!=pB){
           pA=pA==null?headB:pA.next;
           pB=pB==null?headA:pB.next;
       }
       return pA;
   }
   //环形链表(快慢指针）
   public boolean hasCycle(ListNode head) {
      if(head==null||head.next==null)
          return false;
      ListNode p1=head;
      ListNode p2=head.next;
      while(p2!=null){
          if(p1!=p2){
              p1=p1.next;
              p2=p2.next;
              if(p2!=null)
                  p2=p2.next;
          }else{
              return true;
          }
      }
      return false;
   }
   //查找入环的第一个结点
   public ListNode detectCycle(ListNode head) {
      ListNode p1=head;
      ListNode p2=head;
      do{
          if(p2==null)
              return null;
          p2=p2.next;
          if(p2==null)
              return null;
          p2=p2.next;
          p1=p1.next;
      }while(p1!=p2);
      ListNode pre1=head;
      ListNode pre2=p1;
      while(pre1!=pre2){
          pre1=pre1.next;
          pre2=pre2.next;
      }
      return pre1;
   }
}
