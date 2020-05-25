import java.util.Stack;

public class Solution {
    Stack<Integer> stack1=new Stack<>();
    Stack <Integer>stack2=new Stack<>();
    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()){
            stack2.push(node);
        }else{
            if(node<=stack2.peek()){
                stack2.push(node);
            }else{
                stack2.push(stack2.peek());
            }
        }
    }

    public void pop() {
        while(stack1.peek()==stack2.peek())
            stack2.pop();
        stack1.pop();
    }

    public int top() {
        stack2.pop();
        return stack1.pop();
    }

    public int min() {
        return stack2.peek();
    }
}
