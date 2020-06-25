import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Text {
    //最长不含重复字符的子字符串
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for(int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while(set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    //礼物的最大值
    public int maxValue(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[]dp=new int[n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[j]=Math.max(dp[j-1],dp[j])+grid[i-1][j-1];
            }
        }
        return dp[n];
    }

    //数字翻转为字符串
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = s.length() - 2; i > -1; i--) {
            String tmp = s.substring(i, i + 2);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;

    }
    //连续子数组的最大和
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            switch(c){
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if(stack.isEmpty())return false;
                    char cc=stack.pop();
                    if(!((cc=='('&&c==')')||(cc=='['&&c==']')||(cc=='{'&&c=='}'))) return false;
            }

        }
        if(stack.isEmpty())return true;
        return false;
    }
}
