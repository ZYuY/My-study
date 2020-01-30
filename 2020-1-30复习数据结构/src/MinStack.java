import java.util.ArrayList;

public class MinStack {
    //实现一个最小栈
    ArrayList<Integer>normal;
    ArrayList<Integer>min;
    public MinStack() {
        normal=new ArrayList<>();
        min=new ArrayList<>();
    }

    public void push(int x) {
        normal.add(x);
        if(min.isEmpty()){
        min.add(x);
        }else if(x<min.get(min.size()-1)){
            min.add(x);
        }else{
            min.add(min.get(min.size()-1));
        }
    }

    public void pop() {
        min.remove(min.size()-1);
        normal.remove(normal.size()-1);
    }

    public int top() {
        return normal.get(normal.size()-1);
    }

    public int getMin() {
        return min.get(min.size()-1);
    }
}
