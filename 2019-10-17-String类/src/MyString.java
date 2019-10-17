import java.util.Arrays;

public class MyString {
    private final char[]value;
    public MyString(char[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }
    public MyString(char[]value,int index,int count){
        this.value=Arrays.copyOfRange(value,index,index+count);
    }
    public char charAt(int index){
        return value[index];
    }
    public char[] toCharArray(){
        return Arrays.copyOf(value,value.length);
    }
//    public int hashcode(){
//        return Arrays.hashcode(val);
//    }
    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(!(obj instanceof MyString))
            return false;
        MyString mystring=(MyString)obj;
        return Arrays.equals(value,mystring.value);
    }
    public boolean equalsIgnore(MyString o){
return true;
    }
    public MyString concat(MyString o){
return o;
    }

}
