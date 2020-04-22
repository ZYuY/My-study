public class Text {
    public int reverse(int x) {
        long result=0;
        while(x!=0){
            result=result*10+x%10;
            x=x/10;
        }
        return (int)result==result?(int)result:0;
    }

    public static void main(String[] args) {
//        String a="-123";
//        System.out.println(Integer.valueOf(a));
        int a=-2;
        a=-a;
        System.out.println(a);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
    public int myAtoi(String str) {
        str=str.trim();
        if(str==null) return 0;
        if(str.charAt(0)!='-'||str.charAt(0)<'0'&&str.charAt(0)>'9'){
            return 0;
        }
        long result=str.charAt(0)-'0';
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                result=result*10+str.charAt(i)-'0';
            }else{
                break;
            }
        }
        if(result>Integer.MAX_VALUE )
            return Integer.MAX_VALUE;
        if(result<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)result;
    }
    //26删除排序数组重复项
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
    //27.移除元素
    public int removeElement(int[] nums, int val) {
        if(nums==null)return 0;
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k++]=nums[i];
            }
        }
        return k;
    }
    //28
    public int strStr(String haystack, String needle) {
        //    if(needle==null||needle.length()==0)return 0;
        //     if(haystack==null||haystack.length()==0)return -1;

        //     char[]arr1=haystack.toCharArray();
        //     char[]arr2=needle.toCharArray();
        //    to: for(int i=0;i<arr1.length-arr2.length+1;i++){
        //         for(int j=0;j<arr2.length;j++){
        //             if(arr1[i+j]!=arr2[j])continue to;
        //         }
        //         return i;
        //     }
        //     return -1;
        return haystack.indexOf(needle);
    }
    //29
    public int divide2(int dividend, int divisor) {
        int q=Math.abs(divisor);
        long count=0;
        while(dividend>=divisor){
            dividend-=q;
            count++;
        }
        if(dividend>0&&divisor<0||dividend<0&&divisor>0)
            count=-count;
        return (int)count==count?(int)count:Integer.MAX_VALUE ;
    }
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        negative = (dividend ^ divisor) <0;//用异或来计算是否符号相异
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
        int result = 0;
        for (int i=31; i>=0;i--) {
            if ((t>>i)>=d) {//找出足够大的数2^n*divisor
                result+=1<<i;//将结果加上2^n
                t-=d<<i;//将被除数减去2^n*divisor
            }
        }
        return negative ? -result : result;//符号相异取反
    }
}
