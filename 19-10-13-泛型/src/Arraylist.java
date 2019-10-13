public class Arraylist<E> {
    //泛型顺序表
//        E[]array;
//        int size;
//        public Arraylist(){
//            array=(E[])new Object[16];
//            size=0;
//        }
//        public void adde(E e){
//            array[size++]=e;
//        }
//        public E remove(){
//            E element=array[size-1];
//            array[size-1]=null;
//            size--;
//            return element;
//        }


    //泛型链表
    public static class Node<E>{
            private E value;
            private Node<E> next;
            private Node(E e){
                value=e;
                next=null;
            }
    }
    private Node<E>head;
       private int size;
        public Arraylist(){
            head=null;
            size=0;
        }
        //头插
    public void pushfront(E e){
            Node <E>node=new Node<>(e);
            node.next=head;
            head=node;
            size++;
    }
    //尾插
    public void puahback(E e){
            Node<E>node=new Node<>(e);
            if(size==0){
                pushfront(e);
                return;
            }
            Node<E>cur=head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
            size++;
    }
}
