import java.lang.reflect.Array;

public class ArrayListDemo {
    /**
     * 顺序表
     */
    int[]arr;
    int size;

    public ArrayListDemo() {
        arr=new int[2];
        size=0;
    }
//尾插
   public void  PushBack(int telement){
        ensureCapacity();
        arr[size++]=telement;
   }
   //头插
   public void PushFront(int telement){
        ensureCapacity();
        System.arraycopy(arr,0,arr,1,size);
        arr[0]=telement;
        size++;
   }
   //中间插
   public void insert(int index,int telement){
        if(index<0||index>size) {
            System.out.println("下标错误");
            return ;
        }
        ensureCapacity();
        System.arraycopy(arr,index,arr,index+1,size-index);
        arr[index]=telement;
        size++;
   }

   public void Popback(){
        if(size<=0){
            System.out.println("顺序表为null");
            return ;
        }
        arr[--size]=0;
   }
   public void Popfront(){
       if(size<=0){
           System.out.println("顺序表为null");
           return ;
       }
       System.arraycopy(arr,1,arr,0,size-1);
       size--;

   }
   //中间删
    public  void earse(int index){
        if(index<0||index>=size){
            System.out.println("下标不存在");
            return ;
        }
        if(size<=0){
            System.out.println("顺序表为空");
            return ;
        }
        System.arraycopy(arr,index+1,arr,index,size-index-1);
        size--;
    }
    // 保证容量够用，否则进行扩容
    private void ensureCapacity() {
        if(size<arr.length){
            return ;
        }
        int[]newcopyArray=new int[arr.length*2];
        for(int i=0;i<size;i++){
            newcopyArray[i]=arr[i];
        }
        arr=newcopyArray;
    }
    public void print(){
        System.out.println("打印顺序表");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayListDemo list=new ArrayListDemo();
        list.PushBack(1);
        list.PushBack(2);
        list.PushFront(3);
        list.print();
        list.insert(1,10);
        list.print();
        list.Popback();
        list.print();
        list.Popfront();
        list.print();
        list.earse(1);
        list.print();
    }
}
