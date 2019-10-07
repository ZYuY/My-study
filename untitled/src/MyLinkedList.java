
class Node {
    int val;
    Node next;
    Node(int val){
        this.val=val;
        this.next=null;
    }
    public String toString() {
        return String.format("Node(%d)", val);
    }
}public class MyLinkedList {
    public static void main(String[] args) {
        Node head = null;
        head = pushFront(head, 0);
        head = pushFront(head, 1);
        head = pushFront(head, 2);
        print(head);    // 2 1 0

        // 尾插
        head = popFront(head);
        print(head);    // 1 0

        head = pushBack(head, 10);
        head = pushBack(head, 20);
        head = pushBack(head, 30);
        print(head);    // 1 0 10 20 30
        head = popBack(head);
        head = popBack(head);
        head = popBack(head);
        head = popBack(head);
        head = popBack(head);
        print(head);        // 空

        head = pushBack(head, 100);
        print(head);
    }
    // 打印
    private static void print(Node head) {
        System.out.println("打印链表：");
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur + " --> ");
        }
        System.out.println("null");
    }

    // 头插
    // head: 原来的第一个结点
    // val：要插入的值
    // 返回：新的第一个结点
    private static Node pushFront(Node head, int val) {
        // 1. 结点
        Node node = new Node(val);
        // 2. 让原来的 head 成为 node 的下一个结点
        node.next = head;
        // 3. 更新第一个结点的引用
        return node;
    }

    private static Node pushBack(Node head, int val) {
        Node node = new Node(val);
        if (head == null) {
            return node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;

            return head;
        }
    }
//头删
    private static Node popFront(Node head) {
        if (head == null) {
            System.err.println("空链表无法删除");
            return null;
        }

        // 原来第一个结点，会因为没有引用指向而被回收
        return head.next;
    }
//尾删
    private static Node popBack(Node head) {
        if (head == null) {
            System.err.println("空链表无法删除");
            return null;
        }

        if (head.next == null) {
            return null;
        } else {
            Node lastSecond = head;
            while (lastSecond.next.next != null) {
                lastSecond = lastSecond.next;
            }

            lastSecond.next = null;
            return head;
        }
    }
}


