import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Text {
//    public static void main(String[] args) {
//        List<Integer> list=new LinkedList<>();
//        list.add(200);
//        int index=list.indexOf(200);
//        list.add(index,1);
//        for(Integer e:list){
//            System.out.println(e);
//        }
  //  }

    LinkedList<Integer>list=new LinkedList<>();
    public void Insert(Integer num) {
        if(list.size()==0||num<list.getFirst()){
            list.addFirst(num);
        }else{
            boolean top=false;
            for(Integer e:list){
                if(num<e){
                    int index=list.indexOf(e);
                    list.add(index,num);
                    top=true;
                    break;
                }
            }
            if(!top){
                list.addLast(num);
            }
        }
    }

    public Double GetMedian() {
        int len=list.size();
        if(len==0)return null;
        if(len%2!=0){
            return Double.valueOf(list.get((len-1)/2));
        }
            double res=(list.get(len/2)+list.get(len/2-1))/2;
            return Double.valueOf(res);


    }

    public static void main(String[] args) {
        int[]arr=new int[]{1,2,3,4,5,6};
        boolean top=true;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int p=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=p;
                    top=false;
                }
            }
            if(top)
                break;
        }
        System.out.println(arr[0]);
    }
}
