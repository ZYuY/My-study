import java.util.Arrays;

public class Solution2 {
    //8.字符串转换为整数
    public int myAtoi(String str) {
return 0;
    }
    //34在排序数组中查找元素第一个和最后一个的位置
    public static   int[] searchRange(int[] nums, int target) {
//        if(nums==null||nums.length==0)
//            return new int[]{-1, -1};
        int[]result=new int[]{-1,-1};
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target) {
                result [0]=i;
                break;
            }
        }
        for(int j=nums.length-1;j>=result[0]&&j>=0;j--){
            if(nums[j]==target){
                result[1]=j;
                break;
            }
        }
        return result;
    }

    //125验证回文串
    public  static boolean isPalindrome(String s) {
       if(s==null||s.length()==0)
           return true;
       String s1=s.replaceAll("[^0-9A-Za-z]","").toLowerCase();
        //System.out.println(s1);
       int i=0,j=s1.length()-1;
       while(i<=j){
           if(s1.charAt(i)==s1.charAt(j)){
               i++;
               j--;
           }else{
               return false;
           }
       }
       return true;
    }
    public static void main(String[] args) {
//        int[]arr={1};
//        int b=1;
//        System.out.println(Arrays.toString(searchRange(arr, b)));
        System.out.println(isPalindrome("Damosel, a poem? A carol? Or a cameo pale? (So mad!)"));
    }
}
