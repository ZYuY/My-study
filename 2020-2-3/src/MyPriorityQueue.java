public class MyPriorityQueue {
    private int[]array;
   private  int size;
    public MyPriorityQueue(){
        array=new int[16];
        size=0;
    }
    public void offer(int element){
        array[size++]=element;
        Text1.shiftUpSmall(array,size-1);
    }
    public int poll(){
        int element=array[0];
        array[0]=array[--size];
        Text1.shiftDownSmall(array,0,size);
        return element;
    }
    public int peek() {
        // 不做错误处理
        return array[0];
    }
}
