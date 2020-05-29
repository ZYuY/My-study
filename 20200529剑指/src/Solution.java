import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int left=1,right=2;
        ArrayList<ArrayList<Integer>>result=new ArrayList<>();
        int lev=0;
        while(left<right){
            int count=(left+right)*(right-left+1)/2;
            if(count==sum){
                result.add(new ArrayList<>());
                for(int i=left;i<=right;i++){
                    result.get(lev).add(i);
                }
                lev++;
                left++;
            }else if(count<sum){
                right++;
            }else{
                left++;
            }
        }
        return result;
    }

    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1) return -1;
        int[] array = new int[n];
        int i = -1,step = 0, count = n;
        while(count>0){   //跳出循环时将最后一个元素也设置为了-1
            i++;          //指向上一个被删除对象的下一个元素。
            if(i>=n) i=0;  //模拟环。
            if(array[i] == -1) continue; //跳过被删除的对象。
            step++;                     //记录已走过的。
            if(step==m) {               //找到待删除的对象。
                array[i]=-1;
                step = 0;
                count--;
            }
        }
        return i;//返回跳出循环时的i,即最后一个被设置为-1的元素
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.get(0));
    }

    String Serialize(TreeNode root) {
        StringBuilder builder=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null)
            queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            if(node!=null){
                queue.add(node.left);
                queue.add(node.right);
                builder.append(node.val+",");
            }else{
                builder.append("#"+",");
            }
        }
        if(builder.length()!=0)
            builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }
    TreeNode Deserialize(String str) {
        TreeNode head=null;
        if(str==null||str.length()==0)return head;
        String[]arr=str.split(",");
        TreeNode[]tree=new TreeNode[arr.length];
        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals("#")){
                tree[i]=new TreeNode(Integer.valueOf(arr[i]));
            }
        }

        for(int i=0,j=1;i<tree.length;i++){
            if(tree[i]!=null){
                tree[i].left=tree[j++];
                tree[i].right=tree[j++];
            }
        }
        return tree[0];
    }
}
