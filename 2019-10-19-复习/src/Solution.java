import java.util.ArrayList;
import java.util.List;

//二叉树
public class Solution {
    class Node{
        Node left;
        Node right;
        int val;
        public Node(int val) {
            this.val=val;
        }
    }
    Node root=null;
    public List<Integer> preorder(Node root){
        if(root==null)
            return new ArrayList<>();
        List<Integer>left=preorder(root.left);
        List<Integer>right=preorder(root.right);
        List<Integer>list=new ArrayList<>();
        list.add(root.val);
        list.addAll(left);
        list.addAll(right);
        return list;
    }
    //求结点个数
    public int getsize(Node root){
        if(root==null)
            return 0;
        int left=getsize(root.left);
        int right=getsize(root.right);
        return left+right+1;
    }
    //求叶子结点个数
    public int getleftsize(Node root){
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        int left=getleftsize(root.left);
        int right=getleftsize(root.right);
        return left+right;
    }
    //求树的高度
    public int gethight(Node root){
        if(root==null)
            return 0;
        int left=gethight(root.left);
        int right=gethight(root.right);
        return Math.max(left,right)+1;
    }
    //求二叉树第k层的结点个数
    public int getklevel(Node root,int k){
        if(root==null)
            return 0;
        if(k==1)
            return 1;
        return getklevel(root.left,k-1)+getklevel(root.right,k-1);
    }
    //查找val所在的结点
    public Node find1(Node root,int val){
        if(root==null)
            return null;
        if(root.val==val)
            return root;
        Node n=find1(root.left,val);
        if(n!=null)
            return n;
        return find1(root.right,val);
    }
    public boolean find(Node root,int val){
        if(root==null)
            return false;
        if(root.val==val)
            return true;
        if(find(root.left,val)){
            return true;
        }
        return find(root.right,val);
    }
    //判断两颗二叉树是否是相同的二叉树
    public boolean isSametree(Node p1,Node p2){
        if(p1==null&&p2==null)
            return true;
        if(p1==null||p2==null)
            return false;
        return p1.val==p2.val&&isSametree(p1.left,p2.left)&&isSametree(p1.right,p2.right);
    }
    //判断两棵树是否互为镜像
    public boolean isSame(Node p1,Node p2){
        if(p1==null&&p2==null)
            return true;
        if(p1==null||p2==null)
            return false;
        return p1.val==p2.val&&isSame(p1.left,p2.right)&&isSame(p1.right,p2.left);
    }
    //判断一棵树中是否含有另一棵树
    public boolean search(Node tree,Node p){
        if(tree==null)
            return false;
        if(isSametree(tree,p)){
            return true;
        }
        if(search(tree.left,p)){
            return true;
        }
        return search(tree.right,p);
    }

    //判断一棵树是否是平衡二叉树
    public boolean isbalance(Node tree){
        if(tree==null)
            return false;
        if(!isbalance(tree.left)){
            return false;
        }
        if(!isbalance(tree.right)){
            return false;
        }
        int len1=gethight(tree.left);
        int len2=gethight(tree.right);
        if(len1-len2>=-1&&len1-len2<=1){
            return true;
        }
        return false;
    }

}
