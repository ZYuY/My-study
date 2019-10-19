import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution2 {
    //变态跳台阶
    public int JumpFloorII(int target) {
        if(target<=0)
            return 1;
        if(target==1)
            return 1;
        return JumpFloorII(target-1)*2;
    }
    //跳台阶
    public int JumpFloor(int target) {
        if(target<=0)
            return 1;
        if(target==1)
            return 1;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
    //链表的倒数第k个结点
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null)
            return null;
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<k;i++){
            if(fast==null)
                return null;
            fast=fast.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    //反转链表
    public ListNode ReverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode next;

        ListNode result=null;
        for(ListNode pre=head;pre!=null;pre=next){
            next=pre.next;
            pre.next=result;
            result=pre;
        }
        return result;
    }
//合并两个有序链表
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode pre1=list1;
        ListNode pre2=list2;
        ListNode result=new ListNode(0);
        ListNode cur=result;
        while(pre1!=null&&pre2!=null){
            if(pre1.val<=pre2.val){
                cur.next=pre1;
                cur=pre1;
                pre1=pre1.next;
            }else{
                cur.next=pre2;
            cur=pre2;
            pre2=pre2.next;
        }
    }
        if(pre1!=null)
            cur.next=pre1;
        else
            cur.next=pre2;
        return result.next;
}

    public void swap(int []a,int i,int j){
        int k=a[i];
        a[i]=a[j];
        a[j]=k;
    }
    public void reOrderArray(int [] array) {
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            while (i <= j && array[i] % 2 != 0) {
                i++;
            }
            while (i <= j && array[j] % 2 == 0) {
                j--;
            }
            swap(array, i, j);
        }
    }
    //调整数组顺序，使奇数位于偶数前面 前提是奇数和奇数的顺序不能变，偶数和偶数的顺序不能变
    //方法一  运用冒泡排序的思想 每次都 两两交换
    public void swwap(int []a,int i,int j){
        int k=a[i];
        a[i]=a[j];
        a[j]=k;
    }
    public void reOrderArray1(int [] array) {
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]%2==0&&array[j+1]%2!=0){
                    swwap(array,j,j+1);
                }
            }
        }
    }
    //list方法
    public void reOrderArray2(int [] array) {
        List<Integer> list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        for(int e:array){
            if(e%2!=0){
                list1.add(e);
            }else{
                list2.add(e);
            }
        }
        list1.addAll(list2);
        for(int i=0;i<array.length;i++){
            array[i]=list1.get(i);
        }
    }
}
