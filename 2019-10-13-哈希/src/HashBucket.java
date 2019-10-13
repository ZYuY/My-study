//哈希表key-value模型
public class HashBucket {
    private static class Node{
        private int key;
        private int val;
        Node next;
        public Node(int ket,int val){
            this.key=key;
            this.val=val;
        }
    }
    private Node[]array;
    private int size;
    private static final double LOAD_FACTOR=0.75;

    public  HashBucket() {
        array=new Node[8];
        size=0;
    }

    //get
    public int get(int key){
        int index=key%array.length;
        for(Node cur=array[index];cur!=null;cur=cur.next){
            if(key==cur.key)
                return cur.val;
        }
        return -1;
    }
    //put
    public int put(int key,int val){
        // key => int
        // int 合法的下标
        int index=key%array.length;
        // 2. 在链表中查找 key 所在的结点
        //      如果找到了，更新
        //      所有结点都不是 key，插入一个新的结点
        for(Node cur=array[index];cur!=null;cur=cur.next){
            if(key==cur.key){
                int oldval=cur.val;
                cur.val=val;
                return oldval;
            }
        }
        //没找到就作头插
        Node node=new Node(key,val);
        node.next=array[index];
        array[index]=node;
        size++;
        if(loadfactor()>LOAD_FACTOR){
            resize();
        }
        return -1;
    }
/*扩容 需要考虑到 重新哈希  因为数组长度已经发生改变
两层循环  外层遍历数组  内层遍历链表
    */
    private void resize() {
      Node []newarray=new Node[array.length*2];
      for(int i=0;i<array.length;i++){
          Node next;
          for(Node cur=array[i];cur!=null;cur=next){
              next=cur.next;
              int index=cur.key%newarray.length;
              cur.next=newarray[index];
              newarray[index]=cur;
          }
      }
      array=newarray;
    }
    //负载因子
    private double loadfactor(){
        return size*1.0/array.length;
    }

    public static void main(String[] args) {
        
    }
}
