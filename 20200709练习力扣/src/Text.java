import java.util.*;
public class Text {

    public int maxArea(int[] height) {
        int i=0,j=height.length-1,res=0;
        while(i<j){
            res=height[i]<height[j]?
                    Math.max(res,(j-i)*height[i++]):
                    Math.max(res,(j-i)*height[j--]);
        }
        return res;
    }

    //三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        List< List<Integer>>list=new ArrayList<>();
        if(nums==null||nums.length<3)return list;
        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0;i<len-2;i++){
            if(i>0&&nums[i]==nums[i-1])continue;
            int j=i+1;
            int h=len-1;
            int min=nums[i]+nums[j]+nums[j+1];
            if(min>0)break;
            int max=nums[i]+nums[h]+nums[h-1];
            if(max<0)continue;
            while(j<h){
                int sum=nums[i]+nums[j]+nums[h];
                if(sum==0){
                    list.add(Arrays.asList(nums[i],nums[j],nums[h]));
                    j++;
                    h--;
                    while(j<h&&nums[j]==nums[j-1]){
                        j++;
                    }
                    while(j<h&&i<h&&nums[h]==nums[h+1]){
                        h--;
                    }
                }else if(sum>0){
                    h--;
                }else{
                    j++;
                }
            }
        }
        return list;
    }


    Map<String,String>map=new HashMap<String,String>(){
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };
    public  List<String> letterCombinations(String digits) {
        char[] nums = digits.toCharArray();
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        dfs(0, res, nums, sb);
        return res;
    }
    public  void dfs(int start , List<String> res, char[] nums, StringBuilder sb) {

        if (start == nums.length) {
            res.add(new String(sb.toString()));
        } else {
            char num = nums[start];
            String string = new String(new char[]{num});
            /// 每次递归的可选项
            char[] digits = map.get(string).toCharArray();
            for (int i = 0; i < digits.length; i++) {
                sb.append(digits[i]);
                dfs(start + 1, res, nums, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    //下一个排列
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length<=0)return ;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                int p=nums[i-1];

                for(int j=i;j<nums.length;j++){
                    if(j+1==nums.length||nums[j+1]<=p){
                        swap(nums,i-1,j);
                        break;
                    }
                }
                Arrays.sort(nums,i,nums.length);
                return;
            }
        }
        Arrays.sort(nums);

    }
    public void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    //最长括号匹配
    public int longestValidParentheses(String s) {
        Stack<Integer>stack=new Stack<>();
        stack.push(-1);
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max=Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }
    //组合总和
    List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null||candidates.length==0)return res;
        Arrays.sort(candidates);
        dfs(candidates,0,new ArrayList<>(),target);
        return res;
    }
    public void dfs(int[]arr,int index,List<Integer>cur,int target){
        if(target<0)return ;
        if(target==0){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=index;i<arr.length;i++){
            if(target<0)break;
            cur.add(arr[i]);
            dfs(arr,i,cur,target-arr[i]);
            cur.remove(cur.size()-1);
        }
    }

    //字母异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>map=new HashMap<>();
        int len=strs.length;
        if(len==0)return null;
        for(int i=0;i<len;i++){
            char[]arr=strs[i].toCharArray();
            Arrays.sort(arr);
            String str=String.valueOf(arr);
            if(!map.containsKey(str))
                map.put(str,new ArrayList<>());
            map.get(str).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    //爬楼梯
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

    //求子集
    List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        if(nums==null||nums.length==0)return res;
        dfs(nums,0,new ArrayList<>());
        return res;
    }
    public void dfs(int[]arr,int index,List<Integer>cur){
        for(int i=index;i<arr.length;i++){
            cur.add(arr[i]);
            res.add(new ArrayList<>(cur));
            dfs(arr,i+1,cur);
            cur.remove(cur.size()-1);
        }
    }
}
