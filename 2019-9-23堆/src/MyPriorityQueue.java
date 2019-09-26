import java.util.PriorityQueue;

public class MyPriorityQueue {
    //使用堆来构建队列的优先级
    int[]array;
    int size;
    MyPriorityQueue(){
        array=new int[16];
        size=0;
    }
    //入队列(队尾）
    public void offer(int element){
        array[size++]=element;
        Heap.shiftUpSmall(array,size-1);
    }
    //出队列（把队首元素和最后一个元素交换，小堆）
    public int poll(){
        int element=array[0];
        array[0]=array[--size];
        Heap.shiftDownSmall(array,0,size);
        return element;
    }
    public int peek(){
        return array[0];
    }
    public static void main(String[] args) {
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        q.offer(7);
//        q.offer(9);
//        q.offer(5);
//        System.out.println(q.poll());
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.offer(7);
        queue.offer(9);
        queue.offer(5);
        System.out.println(queue.poll());   // 5
        queue.offer(3);
        System.out.println(queue.poll());   // 3
        queue.offer(10);
        queue.offer(8);
        System.out.println(queue.poll());   // 7
        System.out.println(queue.poll());   // 8
        System.out.println(queue.poll());   // 9
        System.out.println(queue.poll());   // 10
    }
}
