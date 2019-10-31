import java.util.ArrayList;

public class Solution {
    class ListNode{
        ListNode next;
    }
    //数值的整数次方  要考虑base等于0 指数要大于0 等于0 小于0的情况
    public static double pow(double base,int n){
        if(n==0)
            return 1;
        return base*pow(base,n-1);
    }
    public static double Power(double base, int exponent) {
       if(base==0)
           return 0;
       double result=0;
       if(exponent>=0){
           result=pow(base,exponent);
       }else{
           result=1/pow(base,-exponent);
       }
       return result;
    }
    //顺时针打印矩阵
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
    //两个链表的第一个公共结点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null)
            return null;
        int len1=Length(pHead1);
        int len2=Length(pHead2);
        int hight=len1-len2;
        ListNode fast=pHead1;
        ListNode slow=pHead2;
        if(len1<len2){
            hight=len2-len1;
            fast=pHead2;
            slow=pHead1;
        }
        for(int i=0;i<hight;i++){
            if(fast==null)
                return null;
            fast=fast.next;
        }
        while(fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }

    private int Length(ListNode head) {
        int count=0;
        ListNode pre=head;
        while(pre!=null){
            count++;
            pre=pre.next;
        }
        return count;
    }
   //数字在排序数组中出现的次数
    //二分查找
   public int GetNumberOfK(int [] array , int k) {
        if(array==null||array.length==0)
            return 0;
        int left=0;
        int right=array.length-1;
        int count=0;
        int index=0;
        while(left<=right){
             index=(left+right)/2;
            if(k>array[index]){
                left=index+1;
            }else if(k<array.length){
                right=index-1;
            }else{
                break;
            }
        }
        for(int i=index;i>=0;i--){
            if(array[i]==k)
                count++;
            else
                break;
        }
        for(int i=index+1;i<array.length;i++){
            if(array[i]==k)
                count++;
            else
                break;
        }

        return count;
   }
    public static void main(String[] args) {
        System.out.println(Power(2.3,3));
    }
}
