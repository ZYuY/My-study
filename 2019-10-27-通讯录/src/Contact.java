import java.util.Map;
import java.util.TreeMap;

public class Contact {
    Map<String,User> map=new TreeMap<>();
    public void add(String name, String mobilephone, String officephone) throws NameExistException{
        User user=new User(name,mobilephone,officephone);
        if(map.containsKey(name) )
            throw new NameExistException();
        map.put(name,user);

    }
}
