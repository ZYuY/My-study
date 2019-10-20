import javax.swing.tree.TreeNode;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class So {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    //一个数最少需要几步变成斐波那契额数列的数
    public  static int p(int i){
       if(i<=0)
           return 0;
       if(i==1)
           return 1;
        return p(i-1)+p(i-2);
    }
    public static void m(String[] args) {
      Scanner input=new Scanner(System.in);
      int n=input.nextInt();
      int k=0;
      while(n>=p(k)){
          k++;
      }
      int count=n-p(k)<n-p(k-1)?n-p(k):n-p(k-1);
        System.out.println(count);
    }
//下厨房
    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (input.hasNext()) {
            String str = input.nextLine();
            String[] arr = str.split(" ");
            for (String e : arr) {
                set.add(e);
            }
        }
        System.out.println(set.size());
    }
//矩形覆盖
    public int RectCover(int target) {
        if(target<=0)
            return 0;
        if(target==1)
            return 1;
        if(target==2)
            return 2;

        return RectCover(target-1)+RectCover(target-2);
    }
//对称二叉树
boolean so(TreeNode p1, TreeNode p2){
    if(p1==null&&p2==null)
        return true;
    if(p1==null||p2==null)
        return false;
    return (p1.val==p2.val)&&(so(p1.left,p2.right))&&(so(p1.right,p2.left));
}
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null)
            return true;
        return so(pRoot.left,pRoot.right);
    }
}
