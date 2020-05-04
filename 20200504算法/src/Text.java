import java.util.Arrays;

public class Text {
    //买卖股票最佳时机1
    public int maxProfit(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length-1;i++){
            int k=prices[i];
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]>k){
                    max=max<prices[j]-k?prices[j]-k:max;
                }
            }
        }
        return max;
    }
    public int maxProfit2(int[] prices) {
        if(prices.length<=1)return 0;
        int min=prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>min)
                max=Math.max(prices[i]-min,max);
            else
                min=prices[i];
        }
        return max;
    }
    public int maxProfi3t(int[] prices) {
        if(prices.length<=1)return 0;
        int sum=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1])
                sum+=prices[i]-prices[i-1];

        }
        return sum;
    }

    public int climbStairs(int n) {
        if(n<=0)return 0;
        int sum=0;
        int a=1,b=2;
        if(n==1)return a;
        if(n==2)return b;
        for(int i=3;i<=n;i++){
            sum=a+b;
            a=b;
            b=sum;
        }
        return sum;
    }
    //最大子序列和
    public int maxSubArray1(int[] nums) {
        int[]dp=new int[nums.length];//以nums[i]结尾的最大数组和
        dp[0]=nums[0];
        int res=dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        int sum=0;
        int res=nums[0];
        for(int i=0;i<nums.length;i++){
            if(sum<=0){
                sum=nums[i];
            }else{
                sum+=nums[i];
            }
            res=Math.max(res,sum);
        }
        return res;
    }
    //152乘积最大子数组
    public int maxProduct(int[] nums) {
        int imax=1;
        int imin=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                int temp=imax;
                imax=imin;
                imin=temp;
            }
            imax=Math.max(nums[i]*imax,nums[i]);
            imin=Math.min(nums[i]*imin,nums[i]);
            max=Math.max(max,imax);
        }
        return max;
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3],nums[0]*nums[1]*nums[nums.length-1]);
    }
}
