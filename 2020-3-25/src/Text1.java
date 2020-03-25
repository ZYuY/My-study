import java.util.Scanner;

public class Text1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            String str=input.nextLine();
            System.out.println(find(str));
            System.out.println("ff"+null);
        }
        System.out.println("ff"+null);
    }

    private static String  find(String str) {
        if(str==null||str.length()==0)
            return null;
        StringBuilder build=new StringBuilder();
        int count=0;
        str+=4;
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                count++;
            }else{
                build.append(str.charAt(i)).append(count+1);
                count=0;
            }
        }
        return build.toString();
    }
}
