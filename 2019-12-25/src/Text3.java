public class Text3 {
    /**
     * 数组中重复的数字
     * //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int[]arr=new int[length];
        for(int i=0;i<length;i++){
            arr[numbers[i]]+=1;
        }
        for(int i=0;i<length;i++){
            if(arr[i]>1){
                duplication[0]=i;
                    return true;
            }
        }
        return false;
    }
}
