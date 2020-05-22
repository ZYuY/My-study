import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Solution {
    public ArrayList<Integer> maxInWindows1(int [] num, int size)
    {
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        //双端队列，用来记录每个窗口的最大值下标
        LinkedList<Integer> qmax = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            //判断队首元素是否过期
            if (qmax.peekFirst() == i - size) {
                qmax.pollFirst();
            }
            //向result列表中加入元素
            if (i >= size - 1) {
                result.add(num[qmax.peekFirst()]);
            }
        }
        return result;
    }
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num==null||num.length<=0||size<=0||num.length<size)
            return new ArrayList<>();
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<=num.length-size;i++){
            int max=num[i];
            for(int j=i+1;j<i+size;j++){
                if(num[j]>max)max=num[j];
            }
            list.add(max);
        }
        return list;
    }

    public boolean isNumeric(char[] str) {
        try{
            double p=Double.parseDouble(new String(str));
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>>result=new ArrayList<>();
        if(pRoot==null)return result;
        Queue<TreeNode> queue=new LinkedList<>();
        int lev=0;
        queue.add(pRoot);
        while(!queue.isEmpty()){
            result.add(new ArrayList<>());
            int len=queue.size();
            for(int i=0;i<len;i++){
                TreeNode node=queue.remove();
                result.get(lev).add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            lev++;
        }
        return result;
    }


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
