import java.util.*;

class Node {
    public int val;
    public Node next;
    public Node random;
    public Node(){}
    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }

    public Node(int val) {

        this.val = val;
    }
}
    public class copyRandomList {
        //映射关系
        //复制复杂链表
        public Node copyrandom1(Node head) {
            if (head == null)
                return null;
            Node cur = head;
            while (cur != null) {
                Node node = new Node(cur.val);
                cur.random = null;
                node.next = cur.next;
                cur.next = node;
                cur = node.next;
            }
            cur = head;
            while (cur != null) {
                Node p2 = cur.next;
                if (cur.random != null) {
                    p2.random = cur.random.next;
                }
                cur = p2.next;
            }
            cur = head;
            Node newhead = head.next;
            while (cur != null) {
                Node p2 = cur.next;
                cur.next = p2.next;
                if (p2.next != null) {
                    p2.next = p2.next.next;
                }
                cur = cur.next;
            }
            return newhead;
        }

        private static class NodeComparator implements Comparator<Node> {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        }

        public Node copyrandom2(Node head) {
            Map<Node, Node> map = new TreeMap<>(new NodeComparator());
            Node newHead = null;
            Node newLast = null;
            Node cur = head;
            while (cur != null) {
                Node node = new Node();
                node.val = cur.val;
                if (newHead == null) {
                    newHead = node;
                } else {
                    newLast.next = node;
                }
                newLast = node;
                map.put(cur, node);
                cur = cur.next;
            }

            cur = head;
            Node node = newHead;
            while (node != null) {
                if (cur.random != null) {
                    node.random = map.get(cur.random);
                } else {
                    node.random = null;
                }

                cur = cur.next;
                node = node.next;
            }

            return newHead;
        }

        //宝石与石头
        public int numJewelsInStones(String J, String S) {
            Set<Character> set = new TreeSet<>();
            int count = 0;
            for (char i : J.toCharArray()) {
                set.add(i);
            }
            for (char i : S.toCharArray()) {
                if (set.contains(i)) {
                    count++;
                }
            }
            return count;
        }

        //坏键盘打字
        //toUpperCase
        public static void p() {
            Scanner input = new Scanner(System.in);
            String a = input.nextLine();//好的
            String b = input.nextLine();//所有的
            Set<Character> set = new TreeSet<>();
            for (char i : a.toCharArray()) {
                set.add(i);
            }
            Set<Character> newset = new TreeSet<>();
            for (char j : b.toCharArray()) {
                if (!set.contains(j)) {
                    j = Character.toUpperCase(j);
                    if (!newset.contains(j)) {//解决重复打印问题
                        System.out.println(j);
                        newset.add(j);
                    }
                }
            }
        }

        //692 前k个高频词
        public static Map<String, Integer> topK(String[] words) {
            Map<String, Integer> map = new HashMap<>();
            //统计每个单词出现的次数
            for (String i : words) {
                int r = map.getOrDefault(i, 0);
                map.put(i, r + 1);
            }
            return map;
        }

        //出现次数一样的放在一组中
        public static Map<Integer, List<String>> caleCount(Map<String, Integer> map) {
            Map<Integer, List<String>> rest = new HashMap<>();
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                String word = e.getKey();
                int count = e.getValue();
                if (!rest.containsKey(count)) {
                    rest.put(count, new ArrayList<>());

                }
                rest.get(count).add(word);
            }
            return rest;
        }

        //sort(a,比较器）可以从大往小排序
        private static class parecount implements Comparator<Integer> {

            @Override
            public int compare(Integer o1, Integer o2) {

                return o2 - o1;
            }
        }

        public static void main(String[] args) {
            int k = 1;
            String[] words = {"the", "day", "the", "is", "is", "the", "tues", "day", "the", "today"};
            Map<String, Integer> wordcount = topK(words);
            System.out.println(wordcount);
            Map<Integer, List<String>> countTowordlist = caleCount(wordcount);
            System.out.println(countTowordlist);
            Set<Integer> counts = countTowordlist.keySet();
            System.out.println(counts);
            List<Integer> countsList = new ArrayList<>(counts);
            Collections.sort(countsList, new parecount());
            System.out.println(countsList);

            List<String> result = new ArrayList<>();
            int n = 0;
            int i = 0;
            while (n < k) {
                int count = countsList.get(i);
                i++;
                List<String> ws = countTowordlist.get(count);
                Collections.sort(ws);
                if (ws.size() <= k - n) {
                    // 如果候选人数量小于需要人数，全部录取
                    result.addAll(ws);
                    n += ws.size();
                } else {
                    // 否则，只录取需要的人数
                    result.addAll(ws.subList(0, k - n));
                    n += (k - n);
                }
            }
            System.out.println(result);
        }
    }
