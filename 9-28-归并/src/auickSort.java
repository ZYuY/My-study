public class auickSort {
    public static void quickSortInter(int[]array,int left,int right){
       int p=array[left];
       int k=partition1(array,left,right);
        quickSortInter(array,left,k-1);
        quickSortInter(array,k+1,right);

    }
    public static int partition1(int[]array,int left,int right){
        int k=array[left];
        int i=left;
        int j=right;
        while(i<j){
            while(array[j]>=k&&i<j)
                j--;
            array[i]=array[j];
            while(array[i]<=k&&i<j)
                i++;
            array[j]=array[i];
        }
        array[i]=k;
        return i;
    }
}
