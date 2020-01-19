import java.util.TreeSet;

public class Solution {
    //66加一
    public int[] plusOne(int[] digits) {
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

    //414第三大的数
    public int thirdMax(int[] nums) {
        /**
         * 维护一个只有3个元素的TreeSet，如果大于三个元素就就把Set中的最小最小值remove掉。
         * 最后如果Set中元素小于3就返回Set最大值，否则返回最小值。
         */
        if(nums==null||nums.length==0)throw new RuntimeException("error");
        TreeSet<Integer>set=new TreeSet<>();
        for(int i:nums){
            set.add(i);
            if(set.size()>3)
                set.remove(set.first());
        }
        return set.size()<3?set.last():set.first();

//        if (nums == null || nums.length == 0) throw new RuntimeException("error");
//           TreeSet<Integer> set = new TreeSet<>();
//           for (Integer elem : nums) {
//               set.add(elem);
//               if (set.size() > 3) set.remove(set.first());
//           }
//           return set.size() < 3 ? set.last() : set.first();   // set.last() 里面最大的元素
//        int a = Integer.MIN_VALUE;
//        int b = a,c=a;
//        boolean bg = false;
//        for (int i:nums){
//            if(i>a){
//                if(b > Integer.MIN_VALUE){
//                    bg = true;
//                }
//                c = b;
//                b = a;
//                a = i;
//            }else if(i > b){
//                if(i == a){
//                    continue;
//                }
//                if(b > Integer.MIN_VALUE){
//                    bg = true;
//                }
//                c = b;
//                b = i;
//            }else if(i >= c){
//                if(i == b && i > Integer.MIN_VALUE){
//                    continue;
//                }
//                c = i;
//                bg = true;
//            }
//        }
//        if(b == Integer.MIN_VALUE || !bg){
//            return a;
//        }
//        return c;
    }
    //1两数之和
    public int[] twoSum(int[] nums, int target) {
        int []arr=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    arr[0]=i;
                    arr[1]=j;
                }
            }
        }
        return arr;
    }

    //67二进制求和
    public String addBinary(String a, String b) {
        StringBuilder str=new StringBuilder();
        int ca=0;
        for(int i=a.length()-1,j=b.length()-1;i>=0||j>=0;i--,j--){
            int sum=ca;
            sum+=i>=0?a.charAt(i)-'0':0;
            sum+=j>=0?b.charAt(j)-'0':0;
            str.append(sum%2);
            ca=sum/2;
        }
        str.append(ca==1?ca:"");
                return str.reverse().toString();
    }
}
