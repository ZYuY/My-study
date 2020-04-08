import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class BlockArrayQuit {
    int[]arr=new int[10];
    int front=0;
    int rear=0;
    int size=0;
    void put(int val){
        if(size==arr.length){
            throw new RuntimeException("队列满了");
        }
        arr[rear]=val;
        rear=(rear+1)%arr.length;
        size++;
    }
    int take(){
        if(size==0){
            throw new RuntimeException("队列为空");
        }
        int k=arr[front];
        front=(front+1)%arr.length;
        size--;
        return k;
    }
static class myTime extends TimerTask{
    @Override
    public void run() {
        System.out.println("到第10秒了");
    }
}
    public static void main(String[] args) throws InterruptedException {
        TimerTask task=new myTime();
        Timer timer=new Timer();
        timer.schedule(task,10*1000);
        int i=0;
        while(true){
            System.out.println(i++);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
