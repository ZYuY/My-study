public class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)return 0;
        int k=0;//能够到达的最远距离
        int step=0;//步数
        int end=0;//记录上一步跳的最远距离
        for(int i=0;i<nums.length;i++){
            k=Math.max(k,i+nums[i]);

            if(k>=nums.length-1)
                return step+1;
            if(end==i){
                step++;
                end=k;
            }

        }
        return step;
    }
}
