import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Text2 {
    /**
   //电话号码
    public static void main(String[] args){
        String symbol="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number="222333444555666777788899991234567890";
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            ArrayList<String> arrayList=new ArrayList<String>();
            for(int i=0;i<n;i++){
                String str=scanner.next();
                str=str.replace("-","");
                String result="";
                for(int j=0;j<7;j++){
                    result+=number.charAt(symbol.indexOf(str.charAt(j)+""));
                }
                result=result.substring(0,3)+"-"+result.substring(3,7);
                if(!arrayList.contains(result))
                    arrayList.add(result);
            }
            Collections.sort(arrayList);
            for(int j=0;j<arrayList.size();j++){
                System.out.println(arrayList.get(j));
            }
            System.out.println();
        }
    }**/
    //电话号码
    public static void main(String[] args) {
        String symbol="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number="222333444555666777788899991234567890";
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int n=input.nextInt();
            List<String> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                String str=input.next();
                str=str.replace("-","");
                String res="";
                for(int j=0;j<7;j++){
                    res+=number.charAt(symbol.indexOf(str.charAt(j)+""));
                }
                res=res.substring(0,3)+"-"+res.substring(3,7);
                if(!list.contains(res))
                    list.add(res);
            }
            Collections.sort(list);
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
            System.out.println();
        }
    }
    /**
    //单词倒排
        public static void main(String[]args){
            Scanner input=new Scanner(System.in);
            String str=input.nextLine();
            System.out.println(find(str).trim());
        }
        public static String find(String str){
            String res="";
            if(str==null||str.length()==0)return res;
            String[]arr=str.split("[^a-zA-Z]");
            for(int i=arr.length-1;i>=0;i--){
                res+=arr[i];
                res+=" ";
            }
            return res;
        }
    **/


}
