public class MyCircularQueue {
    //622实现一个循环链表
        int size;
        int[] array;
        int left;
        int right;

    public MyCircularQueue(int k) {
        array=new int[k];
        size=0;
        left=0;
        right=0;
    }
    public boolean enQueue(int value) {
        if(size==array.length)
            return false;
        array[right]=value;
        size++;
        right++;
        return true;
    }
    public boolean deQueue() {
        if(size==0)
            return false;
        return true;
    }
    public int Front() {
        if(size==0)
            return -1;
        return array[0];
    }
    public int Rear() {
        return array[--size];
    }
    public boolean isEmpty() {
        if(size==0)
            return true;
        return false;
    }
    public boolean isFull() {
        if(right+1==left)
            return true;
        return false;
    }
}
