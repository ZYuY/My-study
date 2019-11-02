import java.util.Scanner;

class Febonaqithread extends Thread{
    int n;
    public Febonaqithread(int n){
        this.n=n;
    }
    @Override
    public void run() {
            long result=Febonaqithread.caln(n);
            System.out.printf("第%d项斐波那契数为：%d%n",n,result);
    }

    /**
     * 多线程的优势：
     * 1.
     * 如何创建线程：
     * Thread类-------线程的描述类
     * 如何创建Thread对象：
     * 1.继承Thread类，覆写run()
     * 2.实现一个Runnable接口的类，覆写run()
     * @param n
     * @return
     */
    private static long caln(int n) {
        if(n==0||n==1)
            return 1;
        else
        return caln(n-1)+caln(n-2);
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(true){
            System.out.println("请输入你要输求的斐波那契的第n项");
            int n=input.nextInt();
            Thread thread=new Febonaqithread(n);
            thread.start();
        }
    }
}
