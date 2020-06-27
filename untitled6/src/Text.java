public class Text {
    public static void main(String[] args) {
        int[]arr={1,5,3,7,9,20,38,7,6};
        //insertSort(arr);
        //shellSort(arr);
        //selectSort(arr);
        //maoSort(arr);
        quickSort(arr);
        for(int a:arr){
            System.out.print(a+" ");
        }
    }
    //插入排序
    public static void insertSort(int[]arr){
        for(int i=1;i<arr.length;i++){
            int top=arr[i];
            int j=i-1;
            for(;j>=0&&arr[j]>top;j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=top;
        }
    }

    //希尔排序
    public static void shellSort(int[]arr){
       int grop=arr.length;
       while(grop>1){
           gropSort(arr,grop);
           grop=grop/3+1;
       }
       gropSort(arr,1);
    }
    public static void gropSort(int[]arr,int grop){
        for(int i=1;i<arr.length;i++){
            int top=arr[i];
            int j=i-grop;
            for(;j>=0&&arr[j]>top;j-=grop){
                arr[j+grop]=arr[j];
            }
            arr[j+grop]=top;
        }
    }
    //直接选择排序
    public static void selectSort(int[]arr){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min])
                    min=j;
            }
            int k=arr[min];
            arr[min]=arr[i];
            arr[i]=k;
        }
    }
    //冒泡排序
    public  static void maoSort(int[]arr){
       for(int i=0;i<arr.length-1;i++){
           boolean top=true;
           for(int j=0;j<arr.length-i-1;j++){
               if(arr[j]>arr[j+1]){
                   top=false;
                   int k=arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=k;
               }
           }
           if(top){
               break;
           }
       }
    }
    //快速排序
//    public static void quickSort(int[]arr){
//         quick(arr,0,arr.length-1);
//    }
//    public  static  void quick(int[]arr,int left,int right){
//        if(left>=right)return ;
//        int index=priorter(arr,left,right);
//        quick(arr,left,index-1);
//        quick(arr,index+1,right);
//    }
//    public static int priorter(int[]arr,int left,int right){
//        int i=left,j=right;
//        int top=arr[left];
//        while(i<j){
//            while(i<j&&arr[j]>=top)
//                j--;
//            arr[i]=arr[j];
//            while(i<j&&arr[i]<=top)
//                i++;
//            arr[j]=arr[i];
//        }
//        arr[i]=top;
//        return i;
//    }

    public static void quickSort(int[]arr){
        quick(arr,0,arr.length-1);
    }
    public static void quick(int[]arr,int left,int right){
        if(left>=right)return ;
        int index=priorter(arr,left,right);
        quick(arr,left,index-1);
        quick(arr,index+1,right);
    }
    private  static int priorter(int[]arr,int left,int right){
        int i=left;
        int j=right;
        int k=arr[left];
        while(i<j){
            while(i<j&&arr[j]>=k)
                j--;
            arr[i]=arr[j];
            while(i<j&&arr[i]<=k)
                i++;
            arr[j]=arr[i];
        }
        arr[i]=k;
        return i;
    }

    //堆排序

    //归并排序

}
