import java.util.Arrays;

public class Text1 {
    //反转链表
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //第k个结点
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null)
            return null;
        ListNode a=head;
        ListNode b=head;
        for(int i=0;i<k;i++){
            if(a!=null){
                a=a.next;
            }else{
                return null;
            }
        }
        while(a!=null){
            b=b.next;
            a=a.next;
        }
        return b;
    }
    public class Solution {
        public ListNode ReverseList(ListNode head) {
            ListNode pre=head;
            ListNode result=null;
            while(pre!=null){
                ListNode next=pre.next;
                pre.next=result;
                result=pre;
                pre=next;
            }
            return result;
        }
    }
    public static void main(String[] args) {
        char[]a=new  char[]{'a','b'};
        String arr=new String(a);
        System.out.println(arr);
    }
}
