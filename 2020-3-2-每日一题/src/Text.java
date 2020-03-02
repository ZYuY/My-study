import java.util.*;

public class Text {
    /**
     * 数字之和
     */
//    public static void main(String[]args){
//        Scanner input=new Scanner(System.in);
//        while(input.hasNext()){
//            int n=input.nextInt();
//            int p=Find(n);
//            int q=Find(n*n);
//            System.out.println(p+" "+q);
//        }
//    }
//    public static int Find(int k){
//        int result=0;
//        while(k!=0){
//            result+=k%10;
//            k=k/10;
//        }
//        return result;
//    }
    /**
     * 计票统计
     */

//    public static void main(String[]args){
//        Scanner input=new Scanner(System.in);
//        while(input.hasNext()) {
//            int n = input.nextInt();
//            List<String> lists = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                String name = input.next();
//                lists.add(name);
//            }
//            int peopleName = input.nextInt();
//            int[] piaoshu = new int[n];
//            int Invalid = 0;
//            for (int i = 0; i < peopleName; i++) {
//                String name = input.next();
//                if (lists.contains(name)) {
//                    int index = lists.indexOf(name);
//                    piaoshu[index]++;
//                } else {
//                    Invalid++;
//                }
//            }
//            for (int i = 0; i < lists.size(); i++) {
//                System.out.println(lists.get(i) + ":" + piaoshu[i]);
//            }
//            System.out.println("Invalid" + ":" + Invalid);
//        }
//    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int candidateNum = sc.nextInt();
//            List<String> list = new ArrayList<>();
//            for (int i = 0; i < candidateNum; i++) {
//                String name = sc.next();
//                list.add(name);
//            }
//            int voteNum = sc.nextInt();
//            int[] arr = new int[candidateNum];
//            int invalidNum = 0;
//            for (int i = 0; i < voteNum; i++) {
//                String name = sc.next();
//                if (list.contains(name)){
//                    int index = list.indexOf(name);
//                    arr[index]++;
//                }else {
//                    invalidNum++;
//                }
//            }
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i)+" : "+arr[i]);
//            }
//            System.out.println("Invalid : "+invalidNum);
//        }
//    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            List<String>list=new ArrayList<>();
            int n=input.nextInt();
            for(int i=0;i<n;i++){
                String name=input.next();
                list.add(name);
            }
            int piao=input.nextInt();
            int[]arr=new int[n];
            int Inorder=0;
            for(int i=0;i<piao;i++){
                String name=input.next();
                if(list.contains(name)){
                    int p=list.indexOf(name);
                    arr[p]++;
                }else{
                    Inorder++;
                }
            }
            for(int i=0;i<n;i++) {
                System.out.println(list.get(i)+":"+arr[i]);
            }
            System.out.println("Inorder"+":"+Inorder);
        }
    }
}


