import java.util.*;

class ListNode{
    int val;
   ListNode next;
    ListNode(int val){this.val=val;}
}
public class Text {
    //顺序表，链表
    //删除链表的指定节点
    public static void remove(ListNode node){
        node.val=node.next.val;
        node.next=node.next.next;
    }
//逆置链表
public ListNode reverseList(ListNode head) {
    if(head==null)return null;
    ListNode result=null;
    ListNode pre=head;
    while(pre!=null){
        ListNode next=pre.next;
        pre.next=result;
        result=pre;
        pre=next;
    }
    return result;
}
//链表的中间结点
public ListNode middleNode(ListNode head) {
    if(head==null)return null;
    ListNode p1=head;
    ListNode p2=head.next;
    while(p2!=null){
        p1=p1.next;
        p2=p2.next;
        if(p2!=null)
            p2=p2.next;
    }
    return p1;
}
//返回链表的倒数第k个结点
public ListNode FindKthToTail(ListNode head,int k) {
    if(head==null)return null;
    ListNode a=head;
    ListNode b=head;
    for(int i=0;i<k;i++){
        if(a!=null)
            a=a.next;
        else
            return null;
    }
    while(a!=null){
        b=b.next;
        a=a.next;
    }
    return b;
}
//合并两个有序链表
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1==null)return l2;
    if(l2==null)return l1;
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
    if(pre1!=null)
        res.next=pre1;
    if(pre2!=null)
        res.next=pre2;
    return result.next;
}
//分割链表(记住最后结点的next=null)
public ListNode partition(ListNode pHead, int x) {
    // write code here
    if(pHead==null||pHead.next==null)
        return pHead;
    ListNode small=new ListNode(0);
    ListNode sm=small;
    ListNode big=new ListNode(0);
    ListNode bi=big;
    ListNode node=pHead;
    while(node!=null){
        if(node.val<x){
            sm.next=node;
            sm=sm.next;
        }else{
            bi.next=node;
            bi=bi.next;
        }
        node=node.next;
    }
    bi.next=null;
    sm.next=big.next;
    return small.next;
}
//删除链表的重复节点
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
//判断回文链表
public boolean chkPalindrome(ListNode A) {
    // write code here
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
//相交链表的结点
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA==null||headB==null)return null;
    ListNode A=headA;
    ListNode B=headB;
    while(A!=B){
        A=A==null?headB:A.next;
        B=B==null?headA:B.next;
    }
    return A;
}
//返回链表的第一个入环结点
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
//判断链表是否有环
public boolean hasCycle(ListNode head) {
    if(head==null||head.next==null)
        return false;
    ListNode p1=head;
    ListNode p2=head;
    do{
        if(p2==null)
            return false;
        p2=p2.next;
        if(p2==null)
            return false;
        p2=p2.next;
        p1=p1.next;
    }while(p1!=p2);
    return true;
}

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.remove(1);
//        // list.remove(2);
//        for (int i = 0; i < list.size(); i++)
//            System.out.println(list.get(i));
        int[]arr={1,4,2,5,7,2};
        insert(arr);
        System.out.println(Arrays.toString(arr));
    }
        //插入排序
        public static void insert(int[]arr){
        for(int i=1;i<arr.length;i++){
            int k=arr[i];
            int j;
            for(j=i-1;j>=0&&k<arr[j];j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=k;
        }
        }

        //选择排序

        //快排

        //冒泡

        //堆排序

        //希尔排序

        //归并排序


}
