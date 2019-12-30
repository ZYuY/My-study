package tongxunlu;

import java.sql.Connection;
import java.util.Scanner;

public class Contactmanage {
    public static void access() {
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
//            switch (code) {
//                case "1":
//                    addContactInfo(sc);
//                    break;
//                case "2":
//                    deleteContactInfo(sc);
//                    break;
//                case "3":
//                    deleteContactInfoPhone(sc);
//                    break;
//                case "4":
//                    modifyContactInfo(sc);
//                    break;
//                case "5":
//                    selectContactInfo(sc);
//                    break;
//                case "6":
//                    printAllInfo();
//                    break;
//                case "7" :
//                    System.out.println("感谢您的使用，退出当前系统！！");
//                    writeFileFromList();
//                    break out;
//                default:
//                    break;
//            }
//        }
    }
    }
}
