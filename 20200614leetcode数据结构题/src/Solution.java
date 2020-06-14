import java.util.HashMap;
import java.util.Map;

public class Solution {
    //回文数
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        if(x==0)
            return true;
        int k=0,y=x;
        while(x!=0){
            k*=10;
            k+=x%10;

            x/=10;
        }
        if(k==y)
            return true;
        else
            return false;
    }
    //整数反转
    public int reverse(int x) {
        long result=0;
        while(x!=0){
            result=result*10+x%10;
            x=x/10;
        }
        return (int)result==result?(int)result:0;
    }

    //罗马数字转整数
    public int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<Character, Integer>(){
            {
                put('I',1);
                put('V',5);
                put('X',10);
                put('L',50);
                put('C',100);
                put('D',500);
                put('M',1000);
                put('P',0);
            }
        };
        s+="P";
        int sum=0;
        for(int i=0;i<s.length()-1;i++){
            if(map.get(s.charAt(i))>=map.get(s.charAt(i+1))){
                sum+=map.get(s.charAt(i));
            }else{
                sum-=map.get(s.charAt(i));
            }
        }
        return sum;
    }

    //最长共工前缀
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        String str=strs[0];
        for(int i=0;i<strs.length;i++){
            while(strs[i].indexOf(str)!=0){
                str=str.substring(0,str.length()-1);
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

        String []arr=s.split(" ");
        if(arr.length==0)
            return  0;
        return  arr[arr.length-1].length();

    }
    //反转字符串
    public void reverseString(char[] s) {
        if(s==null||s.length==1)return ;
        int i=0,j=s.length-1;
        while(i<j){
            char top=s[i];
            s[i]=s[j];
            s[j]=top;
            i++;
            j--;
        }
    }
    //替换空格
    public String replaceSpace(String s) {
        if(s==null||s.length()==0)return "";
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                builder.append("%20");
            }else{
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
    //字符串转换整数
    public int myAtoi(String str) {
        if(str==null) {
            return 0;
        }
        int n = str.length();
        int i = 0;
        int res = 0;
        boolean is_negative = false;
        //第一步，跳过前面若干个空格
        while(i<n && str.charAt(i)==' ') {
            ++i;
        }
        //如果字符串全是空格直接返回
        if(i==n) {
            return 0;
        }
        //第二步，判断正负号
        if(str.charAt(i)=='-') {
            is_negative = true;
        }
        //如果是正负号，还需要将指针i，跳过一位
        if(str.charAt(i)=='-' || str.charAt(i)=='+') {
            ++i;
        }
        //第三步，循环判断字符是否在 0~9之间
        while(i<n && str.charAt(i)>='0' && str.charAt(i)<='9') {
            //'0'的ASCII码是48，'1'的是49，这么一减就从就可以得到真正的整数值
            int tmp = str.charAt(i)-48;
            //判断是否大于 最大32位整数
            if(!is_negative &&(res>214748364 ||(res==214748364 && tmp>=7))) {
                return 2147483647;
            }
            //判断是否小于 最小32位整数
            if(is_negative &&(-res<-214748364 || (-res==-214748364 && tmp>=8))) {
                return -2147483648;
            }
            res = res*10 + tmp;
            ++i;
        }
        //如果有负号标记则返回负数
        if(is_negative) {
            return -res;
        }
        return res;
    }
}
