import java.util.ArrayList;
import java.util.List;
class ListNode {
    int val;
   ListNode next;
   ListNode(int x) { val = x; }
  }
public class Text {
    //旋转矩阵
    public void rotate(int[][] matrix) {
        //先按对角线翻转再每一行逆置
        int len=matrix.length;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                int a=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=a;
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len/2;j++){
                int b=matrix[i][j];
                matrix[i][j]=matrix[i][len-j-1];
                matrix[i][len-j-1]=b;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        List<List<Integer>>list=new ArrayList<>();
        int f=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    List<Integer>li=new ArrayList();
                    li.add(i);
                    li.add(j);
                    list.add(li);
                }
            }
        }
        for(int i=0;i<list.size();i++){
            find(matrix,list.get(i).get(0),list.get(i).get(1));
        }
    }
    public void find(int[][]matrix,int p,int q){
        for(int i=0;i<matrix.length;i++){
            matrix[i][q]=0;
        }
        for(int i=0;i<matrix[0].length;i++){
            matrix[p][i]=0;
        }
    }

    public boolean isFlipedString(String s1, String s2) {
        if(s1.length()!=s2.length())return false;
        String ss=s2+s2;
        return ss.contains(s1);
    }
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head==null)return null;
        List<Integer>list=new ArrayList<>();
        ListNode p=head;
        while(p!=null){
            if(!list.contains(p.val)){
                list.add(p.val);
            }
            p=p.next;
        }
        ListNode result=new ListNode(0);
        ListNode pre=result;
        for(int i=0;i<list.size();i++){
            ListNode node=new ListNode(list.get(i));
            pre.next=node;
            pre=node;
        }
        return result.next;
    }
    public ListNode removeDuplicateNodes2(ListNode head) {
        if(head==null)return null;
        List<Integer>list=new ArrayList<>();
        ListNode p=head;
        ListNode q=head;
        while(p!=null){
            if(!list.contains(p.val)){
                list.add(p.val);
                q=p;
            }
            else{
                q.next=p.next;
            }
            p=p.next;
        }
        return head;
    }
    public int kthToLast(ListNode head, int k) {
        ListNode pre=head;
        for(int i=0;i<k;i++){
            if(pre!=null)
                pre=pre.next;
        }
        ListNode q=head;
        while(pre!=null){
            pre=pre.next;
            q=q.next;
        }
        return q.val;
    }
    public ListNode partition(ListNode head, int x) {
        if(head==null)return null;
        ListNode small=new ListNode(0);
        ListNode s=small;
        ListNode big=new ListNode(0);
        ListNode b=big;
        ListNode pre=head;
        while(pre!=null){
            if(pre.val<x){
                s.next=pre;
                s=pre;
            }else{
                b.next=pre;
                b=pre;
            }
            pre=pre.next;
        }
        b.next=null;
        s.next=big.next;
        return small.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode(0);
        ListNode p=pre;
        int carry=0;
        while(l1!=null||l2!=null){
            int num1=l1==null?0:l1.val;
            int num2=l2==null?0:l2.val;
            int sum=num1+num2+carry;
            carry=sum/10;
            p.next=new ListNode(sum%10);
            p=p.next;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        if(carry>0)
            p.next=new ListNode(carry);
        return pre.next;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1=headA;
        ListNode p2=headB;
        while(p1!=p2){
            p1=p1==null?headB:p1.next;
            p2=p2==null?headA:p2.next;
        }
        return p1;
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null)return null;
        ListNode p1=head;
        ListNode p2=head;
        do{
            if(p1==null)
                return null;
            p1=p1.next;
            if(p1==null)
                return null;
            p1=p1.next;
            p2=p2.next;
        }while(p1!=p2);
        ListNode p=head;
        while(p!=p1){
            p=p.next;
            p1=p1.next;
        }
        return p;
    }
}
