import java.util.ArrayList;

public class Text {
    //和为s的两个数字
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer>list=new ArrayList<>();
        if(array==null)return list;
        int i=0;
        int j=array.length-1;
        while(i<j){
            if(array[i]+array[j]==sum){
                list.add(array[i]);
                list.add(array[j]);
                break;
            }else if(i<j&&array[i]+array[j]>sum){
                j--;
            }else{
                i++;
            }
        }
        return list;
    }
}
