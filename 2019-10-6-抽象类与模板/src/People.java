import java.util.Scanner;

abstract class CaffeineBeverage{
    //核心冲泡法
    //封装算法
    final void perpareRecipe(){
        boilweat();
        brew();
        pourInCup();
        if(customadd()){
            addCondiments();
        }
    }

    abstract void addCondiments();
    abstract void brew();
    final void boilweat() {
        System.out.println("将水烧开");
    }
    final void pourInCup(){
        System.out.println("将饮料倒入杯中");
    }
    boolean customadd(){
        return true;
    }
}
class Coffee extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("冲咖啡");
    }
    @Override
    void addCondiments() {
        System.out.println("加糖和牛奶");
    }
}
class Tea extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("浸泡茶叶");
    }
    @Override
    void addCondiments() {
        System.out.println("加柠檬");
    }
    //询问用户是否加调料
    boolean customadd(){
        String result=getUserInfo() ;

        if(result.equals("y")){
            return true;
        }
        return false;
    }
    private String getUserInfo(){
        System.out.println("请问需要加柠檬吗 ：  y/n");
        String str=null;
        Scanner input=new Scanner(System.in);
        str=input.nextLine();
        return str;
    }
}
public class People {
    public static void main(String[] args) {
        CaffeineBeverage coffee=new Coffee();
        coffee.perpareRecipe();
        CaffeineBeverage tea=new Tea();
        tea.perpareRecipe();
    }
}
