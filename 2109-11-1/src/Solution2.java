import java.util.ArrayList;
import java.util.Stack;

public class Solution2 {
    //包含min函数的栈
    /**
     * 用两个栈，一个用来完成栈操作，一个用来存放小的数，每次push
     * 如果比当前栈的元素小，就入栈，否则继续push当前栈顶元素
     * 删除的时候   要考虑如果要删的元素在最小栈出现了多次怎么办。
     * 如果删除的元素和最小栈栈顶元素相同，就得把最小栈里面的前面的相同元素删除
     * 比如：push 2,3   pop (3) 再pop(2)时 最小栈里面有两个2
     */
    Stack  <Integer>stack1=new Stack<>();
    Stack <Integer>stack2=new Stack<>();
    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()){
            stack2.push(node);
        }else{
            if(node<stack2.peek()){
                stack2.push(node);
            }else{
                stack2.push(stack1.peek());
            }
        }
    }
//切记  删干净最小栈里面的要删除的元素
    public void pop() {
        while(stack1.peek()==stack2.peek())
        stack2.pop();
       stack1.pop();
    }

    public int top() {//获得栈顶元素
        stack2.pop();
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args) {

    }
}
