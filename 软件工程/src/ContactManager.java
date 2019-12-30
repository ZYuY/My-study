
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private List<Contact> contactList;
    private File srcFile;   //存放数据的文件
    public ContactManager(File srcFile){
        contactList = new ArrayList<Contact>();
        this.srcFile = srcFile;
//		传入文件不存在，就创建这个文件
        if (!this.srcFile.exists()) {
            try {
                this.srcFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public List<Contact> getContactList() {
        return contactList;
    }
    //	读取指定文件的方法
    public void getListFromFile(){
        try {
            FileReader fr = new FileReader(this.srcFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
//			循环读取
            while (true) {
                line = br.readLine();  //读取每一行数据存放到字符串当中
                if (line!=null) {
                    String[] split = line.split("\\|"); //分割每一行数据
//					将数据封装成对象，添加到集合中
                    Contact contact = new Contact(split[0], split[1],split[2],split[3],split[4]);
                    this.contactList.add(contact);
                }else {
                    break;
                }
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println("此文件没创建！！");
        }
    }

    //	将更新的内容写入到文件当中
    public void writeFileFromList(){
        try {
            FileWriter fw = new FileWriter(this.srcFile);
//			一个列表中，每个对象都是写入文件的一行元素
            for (Contact con : this.contactList) {
                String line = con.getName()+"|"+con.getPhone()+"|"+con.getsex()+"|"+con.getArrea()+"|"+con.getEmail()+"\n";
                fw.write(line);
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //	整体工作过程
    @SuppressWarnings("resource")
    public void work(){
//		读源文件的操作
        getListFromFile();
        System.out.println("欢迎手机管理系统，功能如下：");
        System.out.println("-------------手机通讯录管理系统-------------" +
                "\n 输入“1”，可添加联系人到通讯录(同名不可添加)" +
                "\n 输入“2”，可根据姓名删除联系人信息" +
                "\n输入”3“，可根据电话号码删除联系人信息"+
                "\n 输入“4”，可根据姓名修改联系人信息" +
                "\n 输入“5”，可根据姓名查询联系人信息" +
                "\n 输入“6”，可显示全部联系人信息" +
                "\n 输入“7”，退出当前系统" +
                "\n--------------------------------------------");
        Scanner sc = new Scanner(System.in);
        out:while (true) {
            System.out.print("请输入相关功能编号:");
            String code = sc.next();
            switch (code) {
                case "1":
                    addContactInfo(sc);
                    break;
                case "2":
                    deleteContactInfo(sc);
                    break;
                case "3":
                   deleteContactInfoPhone(sc);
                    break;
                case "4":
                    modifyContactInfo(sc);
                    break;
                case "5":
                    selectContactInfo(sc);
                    break;
                case "6":
                    printAllInfo();
                    break;
                case "7" :
                    System.out.println("感谢您的使用，退出当前系统！！");
                    writeFileFromList();
                    break out;
                default:
                    break;
            }
        }
    }
    /**
     * @des 显示全部信息
     * */
    public void printAllInfo() {
        System.out.println("-------联系人信息-------");
        //				遍历联系人信息集合
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println(contactList.get(i));
        }
    }
    /**
     * @des 查询联系人信息的方法
     * */
    public void selectContactInfo(Scanner sc) {
        System.out.print("请输入查询联系人姓名:");
        String dname = sc.next();
        boolean dflag = true;
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if (contact.getName().equals(dname)) {
//						对象存在可以打印对象信息
                System.out.println(contact);
                dflag = false;
                break;
            }
        }
        if (dflag) {
            System.out.println("此联系人不存在！");
        }
    }
    /**
     * @des 修改联系人信息
     * */
    public void modifyContactInfo(Scanner sc) {
        System.out.print("请输入修改联系人姓名:");
        String mname = sc.next();
        boolean mflag = true;
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if (contact.getName().equals(mname)) {
//						对象存在可以修改
                System.out.print("请输入修改的电话号码:");
                String mphone = sc.next();
                contact.setPhone(mphone);
                System.out.print("请输入修改的性别:");
                String msex = sc.next();
                contact.setsex(msex);
                System.out.print("请输入修改的地区:");
                String marror = sc.next();
                contact.setArrea(marror) ;
                System.out.print("请输入修改的邮箱:");
                String memail = sc.next();
                contact.setEmail(memail ) ;
                System.out.println("修改成功！");
                mflag = false;
                break;
            }
        }
        if (mflag) {
            System.out.println("修改失败！");
        }
    }
    /**
     * @des 删除联系人信息的方法
     * */
    public void deleteContactInfo(Scanner sc) {
        System.out.print("请输入删除联系人姓名:");
        String dname = sc.next();
        boolean dflag = true;
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if (contact.getName().equals(dname)) {
//						对象存在可以删除
                contactList.remove(contact);
                System.out.println("删除成功！");
                dflag = false;
                break;
            }
        }
        if (dflag) {
            System.out.println("删除失败！");
        }
    }
    /**
     * 根据电话号码删除联系人信息
     *
     */
    public void deleteContactInfoPhone(Scanner sc) {
        System.out.print("请输入要删除的电话号码:");
        String dphone = sc.next();
        boolean dflag = true;
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if (contact.getPhone().equals(dphone)) {
//						对象存在可以删除
                contactList.remove(contact);
                System.out.println("删除成功！");
                dflag = false;
                break;
            }
        }
        if (dflag) {
            System.out.println("删除失败！");
        }
    }

    /**
     * @des 添加联系人信息的方法
     * */
    public void addContactInfo(Scanner sc) {
        System.out.print("请输入联系人姓名:");
        String name = sc.next();
        boolean flag = true;
        for (int i = 0; i < contactList.size(); i++) {
            Contact ct = contactList.get(i);
            if (ct.getName().equals(name)) {
                flag = false;
                System.out.print("此联系人已经存在，请重新输入！");
                break;
            }
        }
//		判断标志位是否被改变  标志位没有被改变，说明此人不存在，可输入电话，然后添加到集合
        if (flag) {
            System.out.print("请输入电话号码:");
            String phone = sc.next();
            System.out.print("请输入性别:");
            String sex = sc.next();
            System.out.print("请输入地区:");
            String arrea = sc.next();
            System.out.print("请输入邮箱:");
            String Email = sc.next();
            Contact contact = new Contact(name, phone,sex,arrea,Email);
            contactList.add(contact);
        }
    }
}


