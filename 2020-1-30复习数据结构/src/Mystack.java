import java.util.LinkedList;

public class Mystack {
    //用队列实现栈
    LinkedList<Integer> link;
    public Mystack() {
        link=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        link.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for(int i=0;i<link.size()-1;i++){
            link.addLast(link.pollFirst());
        }
        return link.pollFirst();
    }

    /** Get the top element. */
    public int top() {
        for(int i=0;i<link.size()-1;i++){
            link.addLast(link.pollFirst());
        }
        int v=link.pollFirst();
        link.addLast(v);
        return v;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return link.isEmpty();
    }
}
