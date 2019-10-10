import java.util.Arrays;

class ListNode {
   int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

public class Solution {
    //oj 2 两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode result=new ListNode(0);
        ListNode cur=result;
        int t=0;
        while(p1!=null||p2!=null){
            int x=(p1!=null)?p1.val:0;
            int y=(p2!=null)?p2.val:0;
            int sum=t+x+y;
            t=sum/10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            if(p1!=null)
                p1=p1.next;
            if(p2!=null)
                p2=p2.next;
        }
        if(t>0){
            cur.next=new ListNode(t);
        }
        return result.next;
    }

    //oj 16 最接近的三数之和
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int nbs=nums[0]+nums[1]+nums[2];//初始值
        for(int i=0;i<nums.length;i++){
            int begin=i+1;
            int end=nums.length-1;
            while(begin<end){
                int sum=nums[i]+nums[begin]+nums[end];
                //每次比较，nbs越来越接近目标值
                if(Math.abs(target-sum)<Math.abs(target-nbs)){//绝对值
                    nbs=sum;
                }
                if(sum<target)
                    begin++;
                else if(sum>target)
                    end--;
                else
                    return nbs;
            }
        }
        return nbs;
    }
}
