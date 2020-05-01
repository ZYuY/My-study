import java.util.*;
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class Text {
     //两两交换链表中的结点
    public ListNode swapPairs(ListNode head) {
//        if(head==null||head.next==null)return head;
//        ListNode pre=new ListNode(-1);
//        pre.next=head;
//        ListNode p1=pre;
//        while(head!=null&&head.next!=null){
//            ListNode p2=head;
//            ListNode p3=head.next;
//
//            p1.next=p3;
//            p2.next=p3.next;
//            p3.next=p2;
//
//            p1=p2;
//            head=p2.next;
//        }
//        return pre.next;
        if(head==null||head.next==null)return head;
        ListNode node=new ListNode(-1);
        ListNode p1=node;
        while(head!=null&&head.next!=null){

            ListNode p2=head;
            ListNode p3=head.next;

            p1.next=p3;
            p2.next=p3.next;
            p3.next=p2;

            p1=p2;
            head=p2.next;
        }
        return node.next;
    }

//17.电话号码的字母组合(回溯法）
//    Map<String, String> digitsMap = new HashMap<String, String>() {{
//        put("2", "abc");
//        put("3", "def");
//        put("4", "ghi");
//        put("5", "jkl");
//        put("6", "mno");
//        put("7", "pqrs");
//        put("8", "tuv");
//        put("9", "wxyz");
//    }};
//    List<String> res = new ArrayList<String>();
//    StringBuilder tmp = new StringBuilder();
//    public List<String> letterCombinations(String digits) {
//        if (digits == null || digits.length() == 0) return res;
//        process(digits, 0);
//        return res;
//    }
//
//    private  void process(String digits, int index) {
//        if (index >= digits.length()) {
//            res.add(tmp.toString());
//            return;
//        }
//        String letter = digitsMap.get(digits.substring(index, index + 1));
//        for (int i = 0; i < letter.length(); i++) {
//            tmp.append(letter, i, i + 1);
//            process(digits, index + 1);
//            //去掉添加的字母，开始回溯
//            tmp.replace(tmp.length() -1, tmp.length(),"");
//        }
//    }
//

    //回溯算法，电话号码排序
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
    StringBuilder str=new StringBuilder();
    List<String>list=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0)return list;
        process(digits,0);
        return list;
    }
    public void process(String digits,int index){
        if(index>=digits.length()){
            list.add(str.toString());
            return;
        }

        String num=map.get(digits.substring(index,index+1));
        for(int i=0;i<num.length();i++){
            str.append(num.substring(i,i+1));
            process(digits,index+1);

            str.replace(str.length()-1,str.length(),"");
        }
    }


    //22括号生成
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);

        return res;
    }
    //count1统计“(”的个数，count2统计“)”的个数
    public void generate(List<String> res , String ans, int count1, int count2, int n){

        if(count1 > n || count2 > n) return;

        if(count1 == n && count2 == n)  res.add(ans);


        if(count1 >= count2){
            String ans1 = new String(ans);
            generate(res, ans+"(", count1+1, count2, n);
            generate(res, ans1+")", count1, count2+1, n);

        }
    }

List<String>lists=new ArrayList<>();
    public List<String> generateParenthesis3(int n) {
        find("",n,0,0);
        return lists;
    }
    public void find(String str,int n,int count1,int count2){
        if(str.length()==2*n){
            lists.add(str);
            return;
        }

        if(count1<n)
            find(str+"(",n,count1+1,count2);
        if(count2<count1)
            find(str+")",n,count1,count2+1);
    }
//43
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))return "0";
        int[]res=new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            int p=num1.charAt(i)-'0';
            for(int j=num2.length()-1;j>=0;j--){
                int q=num2.charAt(j)-'0';
                int sum=res[i+j+1]+p*q;
                res[i+j+1]=sum%10;
                res[i+j]+=sum/10;
            }
        }
        StringBuilder build=new StringBuilder();
        for(int i=0;i<res.length;i++){
            if(i==0&&res[i]==0)continue;
            build.append(res[i]);
        }
        return build.toString();
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int num : nums) {
            if(!list.contains(num)) {
                list.add(num);
                backtrack(res, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
    //46
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        backet(res, list, nums);
        return res;
    }
    public void backet(List<List<Integer>>re,List<Integer>lis,int[]nums){
        if(lis.size()==nums.length){
            re.add(new ArrayList(lis));
            return;
        }
        for(int num:nums){
            if(!lis.contains(num)){
                lis.add(num);
                backet(re,lis,nums);
                lis.remove(lis.size()-1);
            }
        }
    }
//47
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        Arrays.sort(nums);
        back(res,list,0,nums,new boolean[nums.length]);
        return res;
    }
    public void back(List<List<Integer>>res,List<Integer>list,int index,int[]nums,boolean []t){
        if(list.size()==nums.length){
            res.add(new ArrayList(list));
            return;
        }
        for(int num:nums){
            if(t[num])continue;
            if(num>0&&nums[num]==nums[num-1]&&t[num-1])continue;
            list.add(nums[num]);
            t[num]=true;
            back(res,list,num+1,nums,t);
            list.remove(list.size()-1);
            t[num]=false;
        }
    }

    public List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permuteUnique2(int[] nums) {
        if(nums.length == 0){
            return result;
        }
        //首先给数组排序
        Arrays.sort(nums);
        findUnique(nums,0,new boolean[nums.length],new LinkedList<Integer>());
        return result;
    }
    public void findUnique(int[] nums, int index, boolean[] visited,LinkedList<Integer> trace){
        //结束条件
        if(trace.size() == nums.length){
            result.add(new LinkedList(trace));
            return ;
        }
        //选择列表
        for(int i = 0; i<nums.length; i++){
            //其次，我们已经选择过的不需要再放进去了
            if(visited[i]) continue;
            //接下来，如果当前节点与他的前一个节点一样，并其他的前一个节点已经被遍历过了，那我们也就不需要了。
            if(i>0 && nums[i] == nums[i-1] && visited[i-1]) continue;
            //做出选择
            trace.add(nums[i]);
            visited[i] = true;
            findUnique(nums,i+1,visited,trace);
            //撤销选择
            trace.removeLast();
            visited[i] = false;
        }
    }

    //50
    public double myPow(double x, int n) {
        double result=1.0;
        for(int i=n;i!=0;i/=2){
            if(i%2!=0)
                result*=x;
            x*=x;
        }
        return n<0?1/result:result;
    }
}
