import java.util.concurrent.Callable;

public class Card {
    public  int value;
    public  String color;
    public Card(int value, String color) {
        this.value = value;
        this.color = color;
    }
    public String toString(){
        String v;
        if(value==1){
            v="A";
        }else{
            v=String.valueOf(value);
        }
        return String.format("[%s,%s]",color,v);
    }
    public boolean equals(Object obj) {
    if(obj==null)
        return false;
    if(!(obj instanceof  Card))
        return false;
    if(obj==this)
        return true;
       Card a=(Card)obj;
       return value==a.value&&color.equals(a.color);
    }
}
