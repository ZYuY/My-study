import java.util.Comparator;
import java.util.Scanner;

interface Computer{
    void printComputer();
}
class Macbook implements Computer{

    @Override
    public void printComputer() {
        System.out.println("这是macbook");
    }
}
class Surfacebook implements Computer{

    @Override
    public void printComputer() {
        System.out.println("这是surfacebook");
    }
}
//将所有生产Computer对象实例的操作哦解耦到工厂类中
class ComputerFacetory{
    public static Computer getInstance(String str){
        Computer computer=null;
        if(str.equals("mac")){
            computer=new Macbook();
        }else if(str.equals("surface")){
            computer=new Surfacebook();
        }
        return computer;
    }
}

//抽象工厂类
interface ComputerFactory{
    Computer createComputer();
}
class msFacetory implements ComputerFactory {

    @Override
    public Computer createComputer() {
        return new Surfacebook() ;
    }
}
class Apple implements ComputerFactory {

    @Override
    public Computer createComputer() {
        return new Macbook() ;
    }
}
public class Testcomp {
    public static void main(String[] args) {
        //Computer computer=new Macbook();
        //computer.printComputer();
        Scanner input=new Scanner(System.in);
        System.out.println("请输入你要的电脑型号");
        String a=input.nextLine();
        Computer computer=ComputerFacetory.getInstance(a);//
        computer.printComputer();

        //抽象
        ComputerFactory factory=new Apple() ;
        Computer comp=factory.createComputer() ;
        comp.printComputer() ;
    }
}
