import java.util.*;

public class Text {
/**
        public static void main(String args[]){
            Scanner input=new Scanner(System.in);
            while(input.hasNext()){
                double x0=input.nextDouble();
                double y0=input.nextDouble();
                double z0=input.nextDouble();
                double x1=input.nextDouble();
                double y1=input.nextDouble();
                double z1=input.nextDouble();
                find(x0,y0,z0,x1,y1,z1);
            }
        }
        public static void find(double x0,double y0,double z0,double x1,double y1,double z1){
            double r=Math.sqrt(Math.pow((x1-x0),2)+Math.pow((y1-y0),2)+Math.pow((z1-z0),2));
            double t=(4.0/3.0)*Math.PI*Math.pow(r,3);
            System.out.printf("%.3f %.3f",r,t);
    }**/
/**
 * 键盘输入，先考虑大小写，要么全部大写比较，要么全部小写比较，转换为大写之后，先把正确输出的放入set中，
 * 因为Set有去重的功效，然后遍历需要正确输出的字符串，看Set又没有包含，如果没包含，就看list中有没有，
 * 如果没有，就放入list中，否则会出现重复的
public static void main(String[]args){
    Scanner input=new Scanner(System.in);
    String go=input.nextLine();
    String good=go.toUpperCase();
    String err=input.nextLine();
    String error=err.toUpperCase();
    Set<Character> set=new HashSet<>();
    for(int i=0;i<error.length();i++){
        set.add(error.charAt(i));
    }
    List<Character>list=new ArrayList();
    for(int j=0;j<good.length();j++){
        if(!set.contains(good.charAt(j))){
            if(!list.contains(good.charAt(j)))
                list.add(good.charAt(j));
        }
    }
   for(int i=0;i<list.size();i++){
       System.out.println(list.get(i));
   }
}**/

    public static void main(String[] args) {
    Scanner input=new Scanner(System.in);

}
//风口的猪中国牛市
public int calculateMax(int[] prices) {
       int firstBuy = Integer.MIN_VALUE, firstSell = 0;
       int secondBuy = Integer.MIN_VALUE, secondSell = 0;

       for (int curPrice : prices) {
              firstBuy = Math.max(firstBuy, -curPrice);
              firstSell = Math.max(firstSell, firstBuy + curPrice);
              secondBuy = Math.max(secondBuy,firstSell - curPrice);
              secondSell = Math.max(secondSell, secondBuy + curPrice);
       }
       return secondSell;
}

}
