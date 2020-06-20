import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Text {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer>result=new ArrayList<>();
        if(matrix==null)
            return null;
        int left=0;
        int right=matrix[0].length-1;
        int top=0;
        int hight=matrix.length-1;
        while(left<=right&&top<=hight){
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            if(top!=hight){
                for(int i=top+1;i<=hight;i++){
                    result.add(matrix[i][right]);
                }
            }
            if(top!=hight){
                for(int i=right-1;i>=left;i--){
                    result.add(matrix[hight][i]);
                }
            }
            if(left!=right){
                for(int i=hight-1;i>top;i--){
                    result.add(matrix[i][left]);
                }
            }
            left++;right--;
            top++;hight--;
        }
        return result;
    }
    //二叉搜索树的后序遍历序列
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0||sequence==null)
            return false;
        return find(sequence,0,sequence.length-1);
    }

    private boolean find(int[] sequence, int i, int len) {
        if(i>=len)
            return true;
        int j=0;
        for(;j<len;j++){
            if(sequence[j]>sequence[len]){
                break;
            }
        }
        for(int k=j;k<len;k++){
            if(sequence[k]<sequence[len]){
                return false;
            }
        }
        boolean left=find(sequence,0,j-1);
        boolean right=find(sequence,j,len-1);
        return left&&right;
    }
    //复杂链表的复制
    /**
     *  public RandomListNode Clone(RandomListNode pHead)
     *     {
     *         if(pHead==null)return null;
     *         RandomListNode node=pHead;
     *         while(node!=null){
     *             RandomListNode a=new RandomListNode(node.label);
     *             a.random=null;
     *             a.next=node.next;
     *             node.next=a;
     *             node=a.next;
     *         }
     *         RandomListNode pre1=pHead;
     *         while(pre1!=null){
     *             RandomListNode pre2=pre1.next;
     *             if(pre1.random!=null){
     *                 pre2.random=pre1.random.next;
     *             }
     *             pre1=pre2.next;
     *         }
     *         pre1=pHead;
     *         RandomListNode result=pHead.next;
     *         while(pre1!=null){
     *             RandomListNode p=pre1.next;
     *             pre1.next=p.next;
     *             if(p.next!=null){
     *                 p.next=p.next.next;
     *             }
     *             pre1=pre1.next;
     *         }
     *         return result;
     *     }
     */

    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map=new HashMap<>();
        if(array==null)return 0;
        for(int i=0;i<array.length;i++){
            int k=map.getOrDefault(array[i],0);
            map.put(array[i],k+1);
        }

        for(Map.Entry<Integer,Integer>e:map.entrySet()){
            if(e.getValue()>array.length/2)
                return e.getKey();
        }
        return 0;
    }
}
