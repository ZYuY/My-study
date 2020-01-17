import java.lang.reflect.Array;
import java.util.*;

public class Text {
    //58最后一个单词的长度

    /**
     * 通过空格把它分开，然后如果字符串的长度为0，说明s全是空格,直接返回0
     * @param s
     * @return
     */
    public  static int lengthOfLastWord(String s) {
        String []arr=s.split(" ");
        if(arr.length==0)
            return  0;
        return  arr[arr.length-1].length();
    }

//88 合并两个有序数组
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,nums1.length-n,n);
        Arrays.sort(nums1);
    }
    //217存在重复元素
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }

    //925长按键
    public boolean isLongPressedName(String name, String typed) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<typed.length();i++){
            int k=map.getOrDefault(typed.charAt(i),0);
            map.put(typed.charAt(i),k+1);
        }

        for(int i=0;i<name.length();i++){
            if(!map.containsKey(name.charAt(i))||map.get(name.charAt(i))<=0){
                return false;
            }else{
                map.replace(name.charAt(i),map.get(name.charAt(i))-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(lengthOfLastWord("     "));
        int []n1={1,2,3,0,0,0};
        System.out.println(n1.length);
        int[]n2={2,5,6};
        merge(n1,3,n2,3);
        System.out.println(Arrays.toString(n1));
    }
}
