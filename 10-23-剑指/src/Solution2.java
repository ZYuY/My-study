public class Solution2 {
    //不用加减乘除做加法
    public int Add(int num1,int num2) {
        do{
            int a=num1^num2;
            int b=(num1&num2)<<1;//进位
            num1=a;
            num2=b;
        }while(num2!=0);
        return num1;
    }
    //交换两个整数
    public void swap(int a,int b){
        a=a^b;
        b=a^b;
        a=a^b;
    }

}
