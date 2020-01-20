import java.util.Arrays;

public class Solution2 {
    //581最短无序连续子数组
    public static int findUnsortedSubarray(int[] nums) {
        int r=0,l=nums.length;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    r=Math.max(r,j);
                    l=Math.min(l,i);
                }
            }
        }
        return r-l+1<0?0:r-l+1;
    }

    public static void main(String[] args) {
        int[]a={1,3,2,2,2};
        System.out.println(findUnsortedSubarray(a));
    }
}
