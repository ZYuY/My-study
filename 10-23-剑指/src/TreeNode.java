import java.util.Stack;
//二叉树非递归后序遍历
public class TreeNode {
    class Treenode{
        int val;
        Treenode left;
        Treenode right;
    }
    public void postOrderTreversal(Treenode root) {
      Treenode node=root;
      Stack<Treenode>stack=new Stack<>();
      Treenode last=null;
      while(node!=null||!stack.isEmpty()){
          while(node!=null){
              stack.push(node);
              node=node.left;
          }
          Treenode top=stack.peek();
          if(top==null||top.right==last){
              System.out.println(top.val);
              stack.pop();
              last=top;
          }else{
              node=top.right;
          }
      }

    }
    //堆向下调整
    public void adjustdown(int[]array,int index,int size){
        while(2*index+1<size){
            int max=2*index+1;
            if(2*index+2<size&&array[2*index+2]>array[2*index+1]){
                    max=2*index+2;
            }
            if(array[index]>=array[max])
                return;
            swap(array,index,max);
            index=max;
        }
    }

    private void swap(int[] array, int index, int max) {
        int t=array[index];
        array[index]=array[max];
        array[max]=t;
    }
}
