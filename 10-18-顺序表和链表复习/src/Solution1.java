class Node {
    int val;
    Node next = null;

    public Node(int val) {
        this.val = val;
    }
}
public class Solution1 {
    //复制复杂链表
    CNode copy(CNode head) {
        if (head == null) {
            return null;
        }

        CNode p1 = head;
        while (p1 != null) {
            CNode p2 = new CNode(p1.val);

            p2.next = p1.next;
            p1.next = p2;

            p1 = p2.next;
        }

        p1 = head;
        while (p1 != null) {
            CNode p2 = p1.next;
            if (p1.random != null) {
                p2.random = p1.random.next;
            }

            p1 = p2.next;
        }

        p1 = head;
        CNode newHead = head.next;
        while (p1 != null) {
            CNode p2 = p1.next;
            p1.next = p2.next;
            if (p2.next != null) {
                p2.next = p2.next.next;
            }

            p1 = p1.next;
        }

        return newHead;
    }
    //删除链表的指定结点
    Node removeAll(Node head, int val) {
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            if (cur.val == val) {
                if (cur == head) {
                    head = cur.next;
                } else {
                    prev.next = cur.next;
                }
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
//合并两个有序链表
    Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node result = null;
        Node last = null;

        Node cur1 = head1;
        Node cur2 = head2;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                if (result == null) {
                    result = cur1;
                } else {
                    last.next = cur1;
                }
                last = cur1;
                cur1 = cur1.next;
            } else {
                if (result == null) {
                    result = cur2;
                } else {
                    last.next = cur2;
                }
                last = cur2;
                cur2 = cur2.next;
            }
        }

        if (cur1 != null) {
            last.next = cur1;
        } else {
            last.next = cur2;
        }

        return result;
    }
    //删除链表的重复结点
    public Node deleteDuplicated(Node head) {
        if (head == null) {
            return head;
        }

        Node prev = null;
        Node p1 = head;
        Node p2 = head.next;

        while (p2 != null) {
            if (p1.val != p2.val) {
                prev = p1; p1 = p2; p2 = p2.next;
            } else {
                while (p2 != null && p2.val == p1.val) {
                    p2 = p2.next;
                }

                if (prev == null) {
                    head = p2;
                } else {
                    prev.next = p2;
                }

                p1 = p2;
                if (p2 != null) {
                    p2 = p2.next;
                }
            }
        }

        return head;
    }
    //
    public Node separateX(Node head, int x) {
        /*
        遍历整个链表，把小于 x 的尾插到一个小链表
                      把大于等于 x 的尾插到一个大链表中
        理想情况下，把大链表接到小链表后边
        1) 如果没有小链表，直接返回大链表(大链表可能为空）

        保证，返回链表的最后一个结点.next == null
        lessLast / greatLast
         */
        /* 尾插
        1. 先情况讨论：
            1）如果当前链表为空，要插入的结点就是链表的第一个结点
            2) 如果链表不为空，
                1. 先找到当前的最后一个结点
                2. 让当前的最后一个结点的 next = 要插入的结点
                3. 如果每次的最后一个结点都是我们插入的
                    可以记录上次插入的最后一个结点
                4. 不要忘记更新最后一个结点
         */

        Node less = null;   // 指向小链表的第一个结点
        Node lessLast = null;   // 记录小链表的最后一个结点
        Node great = null;
        Node greatLast = null;

        Node cur = head;
        while (cur != null) {
            if (cur.val < x) {
                /* 尾插到小的链表中 */
                if (less == null) {
                    less = cur;
                } else {
                    lessLast.next = cur;
                }
                lessLast = cur;
            } else {
                /* 尾插到大的链表中 */
                // 同理
                if (great == null) {
                    great = cur;
                } else {
                    greatLast.next = cur;
                }
                greatLast = cur;
            }
            cur = cur.next;
        }

        if (less == null) {
            return great;
        } else {
            lessLast.next = great;
            if (greatLast != null) {
                greatLast.next = null;
            }
            return less;
        }
    }
}
