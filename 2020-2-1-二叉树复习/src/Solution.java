import java.util.ArrayList;
import java.util.List;

public class Solution {
    //杨辉三角
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<numRows;i++){
            for(int j=0;j<=i;j++){
                list.get(i).add(1);
            }
        }
        for(int i=2;i<numRows;i++){
            for(int j=1;j<i;j++){
                int a=list.get(i-1).get(j);
                int b=list.get(i-1).get(j-1);
                list.get(i).set(j,a+b);
            }
        }
        return list;
    }
}
