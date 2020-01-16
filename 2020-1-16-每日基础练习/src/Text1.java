import java.util.*;

public class Text1 {

//    public void rotate(int[] nums, int k) {
//        k=k%nums.length;
//        int[]a= Arrays.copyOfRange(nums,nums.length-k,nums.length);
//        System.arraycopy(nums,0,nums,k,nums.length-k);
//        System.arraycopy(a,0,nums,0,a.length);
//
//    }

    public int removeElement(int[] nums, int val) {
        int k=0;
    for(int i=0;i<nums.length;i++){
        if(nums[i]!=val){
            nums[k++]=nums[i];
        }
    }
    return k;
    }
//搜索插入位置
    public  static int searchInsert(int[] nums, int target) {
//        int p=0,q=nums.length-1;
//        while(p<=q){
//            int k=(q-p)/2;
//            if(target>nums[k]){
//                p=k+1;
//            }else if(target<nums[k]){
//                q=k-1;
//            }else{
//                return k;
//            }
//        }
//        if(k)

        for(int i=0; i<nums.length;i++){
            if(nums[i]==target)
                return i;
            if(nums[i]>target){
                    return i;
            }
        }
            return nums.length;
    }

    //赎金信
    public  static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            int k=map.getOrDefault(magazine.charAt(i),0);
            System.out.println(k);
            map.put(magazine.charAt(i),k+1) ;
        }
        for(int i=0;i<ransomNote.length();i++){
            if((!map.containsKey(ransomNote.charAt(i))||map.get(ransomNote.charAt(i))<=0)){
                return false;
            }else{
//                int len=map.get(ransomNote.charAt(i));
//                map.remove(ransomNote.charAt(i));
//                map.put(ransomNote.charAt(i),len-1);
                map.replace(ransomNote.charAt(i),map.get(ransomNote.charAt(i))-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[]arr={1,3,5,6};
//        int val=2;
//        System.out.println(searchInsert(arr,val));
        System.out.println(canConstruct("fffbfg","fffbfgeffjfggbffjdgbjjhhdegh"));
    }
    //判断回文数
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
}
