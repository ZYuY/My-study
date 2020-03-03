public class Text {
    /**
     * 无序数组找出第二大的数
     */
    public static void main(String[] args) {
        int[]arr={1,5,2,7,3,10,20,10,8};
        int p=arr[0];
        int q=arr[1];
        for(int i=2;i<arr.length;i++){
            if(q>p){
                int k=p;
                p=q;
                q=k;
            }
            if(arr[i]>p){
                q=p;
                p=arr[i];
            }
        }
        System.out.println(q);
    }
}
