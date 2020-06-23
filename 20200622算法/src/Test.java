import java.util.*;
public class Test {
    public double myPow(double x, int n) {
        double result=1.0;
        for(int i=n;i!=0;i/=2){
            if(i%2!=0)
                result*=x;
            x*=x;
        }
        return n>0?result:1/result;
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int sum=0,res=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k))
                res+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        //双指针  动规
        if(prices==null||prices.length<=1)return 0;
        int low=prices[0],pow=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<low)
                low=prices[i];

            pow=Math.max(pow,prices[i]-low);
        }
        return pow;
    }
    /**
     * public List<Integer> postorderTraversal(TreeNode root) {
     *         List<Integer>list=new ArrayList<>();
     *         if(root==null)return list;
     *         TreeNode node=root;
     *         TreeNode pre=null;
     *         Stack<TreeNode>stack=new Stack<>();
     *         while(node!=null||!stack.isEmpty()){
     *             while(node!=null){
     *                 stack.push(node);
     *                 node=node.left;
     *             }
     *             TreeNode top=stack.peek();
     *             if(top.right==null||top.right==pre){
     *                 list.add(top.val);
     *                 stack.pop();
     *                 pre=top;
     *             }else{
     *                 node=top.right;
     *             }
     *
     *         }
     *         return list;
     *     }
     *
     */
    public static void main(String[] args) {
        Stack<Integer>stack=new Stack<>();
        String str="abkdff";
        String p=str.substring(0,str.length()-1);
        System.out.println(p);
    }
    //用栈实现队列


    /** Initialize your data structure here. */

    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();


    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}
