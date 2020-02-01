import java.util.*;

public class TreeNums {
    /**
     * 三数之和
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>>result=new ArrayList<>();
      if(nums==null||nums.length<3) return result;
      Arrays.sort(nums);
      for(int i=0;i<nums.length;i++){
          if(nums[i]>0) break;
          if(i>0&&nums[i]==nums[i-1]) continue;
          int j=i+1;
          int k=nums.length-1;
          while(j<k){
              int sum=nums[i]+nums[j]+nums[k];
              if(sum<0) j++;
              if(sum>0) k--;
              if(sum==0){
                  List<Integer>list=new ArrayList<>();
                  list.add(nums[i]);
                  list.add(nums[j]);
                  list.add(nums[k]);
                  result.add(list);
                  while(j<k&&nums[j]==nums[j+1]) j++;
                  while(j<k&&nums[k]==nums[k-1]) k--;
                  j++;
                  k--;
              }
          }
      }
      return result;
    }

    public static void main(String[] args) {
        int[]arr={-2,-0,0,2,2};
        System.out.println(threeSum(arr));
    }
    //括号匹配
    public static boolean piPei(String str){
        Stack<Character> stack=new Stack<>();
        for(char a:str.toCharArray()){
            switch(a){
                case '(':
                case '{':
                case '[':
                    stack.push(a);
                    break;
                case ')':
                case '}':
                case ']':
                    if(stack.isEmpty())
                        return false;
                    char aa=stack.pop();
                    if(!((a=='('&&aa==')')||(a=='{'&&aa=='}')||(a=='['&&aa==']')))
                        return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
