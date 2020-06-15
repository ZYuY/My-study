import java.util.*;

public class Solution {
    //回文数
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x == 0)
            return true;
        int k = 0, y = x;
        while (x != 0) {
            k *= 10;
            k += x % 10;

            x /= 10;
        }
        if (k == y)
            return true;
        else
            return false;
    }

    //整数反转
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return (int) result == result ? (int) result : 0;
    }

    //罗马数字转整数
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
                put('P', 0);
            }
        };
        s += "P";
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                sum += map.get(s.charAt(i));
            } else {
                sum -= map.get(s.charAt(i));
            }
        }
        return sum;
    }

    //最长共工前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String str = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(str) != 0) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    //x的平方根
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x / 2;
        while (left < right) {
            // 取中位数的上界，否则会死循环
            int mid = left + (right - left + 1) / 2;
            if (mid <= x / mid) left = mid;
            else right = mid - 1;
        }
        return left;
    }

    //最后一个单词的长度
    public int lengthOfLastWord(String s) {

        String[] arr = s.split(" ");
        if (arr.length == 0)
            return 0;
        return arr[arr.length - 1].length();

    }

    //反转字符串
    public void reverseString(char[] s) {
        if (s == null || s.length == 1) return;
        int i = 0, j = s.length - 1;
        while (i < j) {
            char top = s[i];
            s[i] = s[j];
            s[j] = top;
            i++;
            j--;
        }
    }

    //替换空格
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                builder.append("%20");
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    //字符串转换整数
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        int n = str.length();
        int i = 0;
        int res = 0;
        boolean is_negative = false;
        //第一步，跳过前面若干个空格
        while (i < n && str.charAt(i) == ' ') {
            ++i;
        }
        //如果字符串全是空格直接返回
        if (i == n) {
            return 0;
        }
        //第二步，判断正负号
        if (str.charAt(i) == '-') {
            is_negative = true;
        }
        //如果是正负号，还需要将指针i，跳过一位
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            ++i;
        }
        //第三步，循环判断字符是否在 0~9之间
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            //'0'的ASCII码是48，'1'的是49，这么一减就从就可以得到真正的整数值
            int tmp = str.charAt(i) - 48;
            //判断是否大于 最大32位整数
            if (!is_negative && (res > 214748364 || (res == 214748364 && tmp >= 7))) {
                return 2147483647;
            }
            //判断是否小于 最小32位整数
            if (is_negative && (-res < -214748364 || (-res == -214748364 && tmp >= 8))) {
                return -2147483648;
            }
            res = res * 10 + tmp;
            ++i;
        }
        //如果有负号标记则返回负数
        if (is_negative) {
            return -res;
        }
        return res;
    }


    public int myAtoi2(String str) {
        int len = str.length();
        int i = 0;
        boolean top = false;
        while (i < len) {
            if (str.charAt(i) == ' ')
                i++;
            else
                break;
        }
        if (i < len && str.charAt(i) == '-') {
            top = true;
            i++;
        } else if (i < len && str.charAt(i) == '+') {
            i++;
        }
        int num = 0;
        while (i < len && Character.isDigit(str.charAt(i))) {
            int pos = str.charAt(i) - '0';
            if (num > (Integer.MAX_VALUE - pos) / 10) {
                return top ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + pos;
            i++;
        }
        return top ? -num : num;
    }

    //用rand7()实现rand10()
    int  rand7(){return 0;}
    public int rand10() {
        while(true){
            int num=(rand7()-1)*7+rand7()-1;
            if(num<40)return num%10+1;
        }
    }
    //删除排序数组中的重复项
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==1)
            return nums.length;
        int i=0,j=1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else{
                i++;
                nums[i]=nums[j];
                j++;
            }
        }
        return i+1;
    }

    //2
    public int removeDuplicates2(int[] nums) {
        int i=0;
        for(int n:nums){
            if(i<2||n>nums[i-2])
                nums[i++]=n;
        }
        return i;
    }

    //数组中重复的数字
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int result=nums[0];
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])){
                result=nums[i];
                break;
            }
        }
        return result;
    }
    //搜索插入位置
    public int searchInsert(int[] nums, int target) {
        for(int i=0; i<nums.length;i++){
            if(nums[i]==target)
                return i;
            if(nums[i]>target){
                return i;
            }
        }
        return nums.length;
    }
    //加一
    public static  int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]!=9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[]arr=new int[digits.length+1];
        arr[0]=1;
        return arr;
    }

    public static void main(String[] args) {
        int[]arr={9,9,9};
       int[]p= plusOne(arr);
        System.out.println(Arrays.toString(p));
    }
    //合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,k=0;
        int[]num=new int[m+n];
        while(i<m&&j<n){
            if(nums1[i]<nums2[j]){
                num[k++]=nums1[i];
                i++;
            }else{
                num[k++]=nums2[j];
                j++;
            }
        }
        while(i<m){
            num[k++]=nums1[i++];
        }
        while(j<n){
            num[k++]=nums2[j++];
        }
        System.arraycopy(num,0,nums1,0,m+n);
    }
    //扑克牌中的顺子
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);//1.先排序
        int zeroCnt=0,diff=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                zeroCnt++;//2.计算0的个数
            }else{
                if(nums[i]==nums[i+1]) return false;
                if(nums[i]+1!=nums[i+1]){
                    diff+=nums[i+1]-nums[i]-1;//3.计算要填补的个数
                }
            }
        }
        return zeroCnt>=diff;

    }
    //方法二
    public boolean isStraight2(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int max=0;
        int min=14;
        for(int num:nums){
            if(num==0)continue;
            if(!set.add(num))return false;
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        return max-min<5;
    }
    //买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)return 0;
        int low=prices[0],pow=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<low)
                low=prices[i];
            pow=Math.max(pow,prices[i]-low);
        }
        return pow;
    }
    //时机2
    public int maxProfit2(int[] prices) {
        if(prices.length<=1)return 0;
        int pow=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                pow+=prices[i]-prices[i-1];
            }
        }
        return pow;
    }
    //二叉树的层平均值

}
