import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Text {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int k = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return k;
    }

    public int JumpFloorII(int target) {
        if (target <= 1) return 1;
        return 2 * JumpFloorII(target - 1);
    }

    public int RectCover(int target) {
        if (target <= 0) return 0;
        if (target == 1 || target == 2) return target;
        return RectCover(target - 1) + RectCover(target - 2);
    }

    public void reOrderArray(int[] array) {
        if (array.length == 0) return;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                list1.add(array[i]);
            } else {
                list2.add(array[i]);
            }
        }
        list1.addAll(list2);
        for (int i = 0; i < array.length; i++) {
            array[i] = list1.get(i);
        }

    }

    public int minNumberInRotateArray(int [] array) {
        if(array.length==0||array==null)return 0;
        int i=0,j=array.length-1;
        while(i<j){
            int mid=(i+j)/2;
            if(array[mid]>array[j]){
                i=mid+1;
            }else if(array[mid]==array[j]){
                j=j-1;
            }else{
                j=mid;
            }
        }
        return array[i];
    }
}
