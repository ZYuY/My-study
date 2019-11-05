import java.util.ArrayList;

public class Solution {
    //二叉树中和为某一值的路径
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    ArrayList<Integer>list=new ArrayList<>();
    ArrayList<ArrayList<Integer>>result=new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
       if(root==null)
           return result;
       list.add(root.val);
       target-=root.val;
       if(target==0&&root.left==null&&root.right==null){
           result.add(new ArrayList<Integer>(list));
       }
       FindPath(root.left,target) ;
       FindPath(root.right,target) ;
       list.remove(list.size()-1);//回溯，如果没找到路径则回溯到它的父结点继续寻找
       return result;
    }
    //复杂链表的复制
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
            return null;
        RandomListNode node=pHead;
       while(node!=null){
           RandomListNode a=new RandomListNode(node.label);
           a.random=null;
           a.next=node.next;
           node.next=a;
           node=a.next;
       }
        node=pHead;
       while(node!=null){
           RandomListNode p2=node.next;
           if(node.random!=null){
               p2.random=node.random.next;
           }
           node=p2.next;
       }
       RandomListNode p1=pHead;
       RandomListNode result=pHead.next;
       while(p1!=null){
           RandomListNode p2=p1.next;
           p1.next=p2.next;
           if(p2.next!=null){
               p2.next=p2.next.next;
           }
           p1=p1.next;
       }
       return result;
    }
    //二叉搜索树与双向链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        return null;
    }
}
