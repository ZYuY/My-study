import java.util.HashMap;
import java.util.Map;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class Text {
    //371两整数之和
    public int getSum(int a, int b) {
        //a^b是无进位相加 + a&b是进位，
        return b==0?a:getSum(a^b,(a&b)<<1);
    }
    //字符串加法
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        int carry=0;
        StringBuilder build=new StringBuilder();
        while(i>=0||j>=0||carry!=0){
            if(i>=0)carry+=num1.charAt(i--)-'0';
            if(j>=0)carry+=num2.charAt(j--)-'0';
            build.append(carry%10);
            carry/=10;
        }
        return build.reverse().toString();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l2==null)return l1;
        if(l1==null)return l2;
        String str1="";
        String str2="";
        ListNode p1=l1;
        ListNode p2=l2;
        while(p1!=null){
            str1+=p1.val;
            p1=p1.next;
        }
        while(p2!=null){
            str2+=p2.val;
            p2=p2.next;
        }

        int i=str1.length()-1;
        int j=str2.length()-1;
        int carry=0;
        ListNode res=null;
        while(i>=0||j>=0||carry!=0){
            if(i>=0)carry+=str1.charAt(i--)-'0';
            if(j>=0)carry+=str2.charAt(j--)-'0';
            ListNode node=new ListNode(carry%10);
            node.next=res;
            res=node;
            carry/=10;
        }
        return res;
    }

    //43合并k个排序链表（分治算法）
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        if(lists.length==1)return lists[0];
        if(lists.length==2) return mergeTwo(lists[0],lists[1]);

        int mid=lists.length/2;
        ListNode[]l1=new ListNode[mid];
        ListNode[]l2=new ListNode[lists.length-mid];
        for(int i=0;i<mid;i++){
            l1[i]=lists[i];
        }
        for(int j=0,i=mid;i<lists.length;j++,i++){
            l2[j]=lists[i];
        }
        return mergeTwo(mergeKLists(l1),mergeKLists(l2));
    }

    private ListNode mergeTwo(ListNode p, ListNode q) {
        if(p==null)return q;
        if(q==null)return p;
        ListNode result=new ListNode(-1);
        ListNode res=result;
        while(p!=null&&q!=null){
            if(p.val<q.val){
                result.next=new ListNode(p.val);
                result=result.next;
                p=p.next;
            }else{
                result.next=new ListNode(q.val);
                result=result.next;
                q=q.next;
            }
        }
        if(p!=null)result.next=p;
        if(q!=null)result.next=q;
        return res.next;
    }
    //263
    public boolean isUgly(int num) {
        if(num<1)return false;
        while(num%5==0){
            num/=5;
        }
        while(num%3==0){
            num/=3;
        }
        while(num%2==0){
            num/=2;
        }
        return num==1;
    }

    //264
    public int nthUglyNumber(int n) {
        int[]arr=new int[n];
        arr[0]=1;
        int index1=0;
        int index2=0;
        int index3=0;
        for(int i=1;i<n;i++){
            arr[i]=Math.min(Math.min(arr[index1]*2,arr[index2]*3),arr[index3]*5);
            if(arr[i]==arr[index1]*2)index1++;
            if(arr[i]==arr[index2]*3)index2++;
            if(arr[i]==arr[index3]*5)index3++;
        }
        return arr[n-1];
    }
    //13
    public int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<Character, Integer>(){
            {
                put('I',1);
                put('V',5);
                put('X',10);
                put('L',50);
                put('C',100);
                put('D',500);
                put('M',1000);
                put('P',0);
            }
        };
        s+="P";
        int sum=0;
        for(int i=0;i<s.length()-1;i++){
            if(map.get(s.charAt(i))>=map.get(s.charAt(i+1))){
                sum+=map.get(s.charAt(i));
            }else{
                sum-=map.get(s.charAt(i));
            }
        }
        return sum;
    }
    
}
