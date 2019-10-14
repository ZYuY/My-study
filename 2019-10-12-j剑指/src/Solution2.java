import java.util.ArrayList;
import java.util.Stack;

public class Solution2 {

    //从尾到头打印链表
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //运用链表每次做头插 再装入到ArrayList中
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if(listNode==null)
            return new ArrayList<>();
        ListNode node=listNode;
        ArrayList<Integer> list=new ArrayList<>();
        ListNode pre=null;
        ListNode next;
        for(node=listNode;node!=null;node=next){
            next=node.next;
            node.next=pre;
            pre=node;
        }
        /*
        *必须装入到ArrayList中，看返回值操作
         */
        while(pre!=null){
            list.add(pre.val);
            pre=pre.next;
        }
        return list;
    }
    //运用栈  先进后出的思想
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
        Stack<Integer>stack=new Stack<>();
        ArrayList<Integer>list=new ArrayList<>();
        ListNode pre=listNode;
        while(pre!=null){
            stack.push(pre.val);
            pre=pre.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
    //
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ListNode pre=listNode;
        ArrayList<Integer>list=new ArrayList<>();
        while(pre!=null){
            list.add(0,pre.val);
            pre=pre.next;
        }
        return list;
    }
    public static void main(String[] args) {

    }
}
