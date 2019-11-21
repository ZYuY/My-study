public class Text1 {
    //另类加法
    /**
     * 利用位运算符，a^b表示不进位的a+b
     * a&b表示进位，所以要左移一位表示进位，然后再进行加法
     * 当不再进位时，a^b就是两个数的和
     */
    public int addAB(int A, int B) {
        // write code here
        while(B!=0){
            int p=A^B;
            int q=(A&B)<<1;
            A=p;
            B=q;
        }
        return A;
    }

}
