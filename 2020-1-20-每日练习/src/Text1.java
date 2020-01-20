import java.io.InputStream;
import java.util.Stack;

public class Text1 {
    //150逆波兰表达式求值
    public  static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (tokens[i].equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (tokens[i].equals("/")) {
                int k = stack.pop();
                stack.push(stack.pop() / k);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();


    }

    public static void main(String[] args) {
        String[]a={"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(a));
    }
}
