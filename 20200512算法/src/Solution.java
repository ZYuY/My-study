import java.util.Arrays;

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length<=0)return 0;
        int m=grid.length;
        int n=grid[0].length;
        int[][]dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        for(int j=1;j<n;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }

        }
        return dp[m-1][n-1];

    }
//25k个一组反转链表
   public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode node=new ListNode(0),prev=node,next,curry=head;
            int length=0;
            while(curry!=null){
                length++;
                curry=curry.next;
            }
            curry=head;
            node.next=head;
            for(int i=0;i<length/k;i++){
                for(int j=0;j<k-1;j++){
                    next=curry.next;
                    curry.next=next.next;
                    next.next=prev.next;
                    prev.next=next;
                }
                prev=curry;
                curry=curry.next;
            }
            return node.next;
        }

        //31
        public void nextPermutation(int[] nums) {
            if(nums==null||nums.length<=0)return ;
            for(int i=nums.length-1;i>0;i--){
                if(nums[i]>nums[i-1]){
                    int p=nums[i-1];

                    for(int j=i;j<nums.length;j++){
                        if(j+1==nums.length||nums[j+1]<=p){
                            swap(nums,i-1,j);
                            break;
                        }
                    }
                    Arrays.sort(nums,i,nums.length);
                    return;
                }
            }
            Arrays.sort(nums);

        }
    public void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
