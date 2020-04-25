import java.util.*;
public class Text {
//    public static void main(String[]args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        while (scanner.hasNext()) {
//            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                int a=scanner.nextInt();
//                if (list.contains(a))
//                    list.remove(list.indexOf(a));
//                else
//                    list.add(a);
//            }
//            int min = list.get(0) < list.get(1) ? list.get(0) : list.get(1);
//            int max = list.get(0) > list.get(1) ? list.get(0) : list.get(1);
//            System.out.print(min + " " + max);
//        }
//    }


    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=input.nextInt();
        }
        int[][]result=new int[n][2];
        for(int i=0;i<n;i++){
            result[i][0]=find1(arr,i);
            result[i][1]=find2(arr,i);
        }
        for(int i=0;i<n;i++){
            System.out.println(result[i][0]+" "+result[i][1]);
        }
    }
    public static int find1(int[]arr,int k){
        for(int i=k-1;i>=0;i--){
            if(arr[i]<arr[k])
                return i;
        }
        return -1;
    }
    public static int find2(int[]arr,int k){
        for(int i=k+1;i<arr.length;i++){
            if(arr[i]<arr[k])
                return i;
        }
        return -1;
    }
}
