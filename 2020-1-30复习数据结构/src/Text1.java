import java.util.Stack;

public class Text1 {
    //有效的括号
    public boolean isValid(String s) {
//        Stack<Character>stack=new Stack<>();
//        for(char a:s.toCharArray()){
//            switch(a){
//                case '(':
//                case '{':
//                case '[':
//                    stack.push(a);
//                break;
//                case ')':
//                case '}':
//                case ']':
//                if(stack.isEmpty())
//                    return false;
//                char aaa=stack.pop();
//                if(!((aaa=='('&&a==')')||(aaa=='{'&&a=='}')||(aaa=='['&&a==']'))){
//                    return false;
//                }
//            }
//        }
//        if(!stack.isEmpty())
//            return false;
//        return true;
        Stack<Character>stack=new Stack<>();
        for(char a:s.toCharArray()){
            switch(a){
                case '(':
                case '{':
                case '[':
                    stack.push(a);
                    break;
                case ')':
                case '}':
                case ']':
                    if(stack.isEmpty())
                        return false;
                    char aaa=stack.pop();
                    if(!((aaa=='('&&a==')')||(aaa=='{'&&a=='}')||(aaa=='['&&a==']'))){
                        return false;
                    }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
    //用队列实现栈


}
