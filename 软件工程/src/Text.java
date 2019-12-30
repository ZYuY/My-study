

import java.io.File;
import java.util.List;
public class Text {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager(new File("contact.txt"));
//		测试案例使用
//		List<Contact1> list = manager.getContactList();
//		list.add(new Contact1("Rose", "14532289011"));
//		list.add(new Contact1("Jack", "18511289011"));
//		list.add(new Contact1("Jerry", "17634511021"));
//		list.add(new Contact1("小明", "14510989925"));
        manager.work();
    }
}

