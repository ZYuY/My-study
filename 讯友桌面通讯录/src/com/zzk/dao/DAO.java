package com.zzk.dao;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * ������ݿ����ӵķ���
 *
 * @return Connection
 */
public class DAO {
    private static DAO dao = new DAO(); // ����DAO��ľ�̬ʵ��
    public DAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // �������ݿ�����
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "���ݿ���������ʧ�ܣ��뽫JTDS�������õ�����·���С�\n"
                    + e.getMessage());
        }
    }

    public static Connection getConn() {
        try {
            Connection conn = null; // �������ݿ�����
            String url = "jdbc:mysql://localhost:3306/db_AddressList?zeroDateTimeBehavior=convertToNull"; // ���ݿ�db_AddressList��URL
            String username = "root"; // ���ݿ���û���
            String password = "mysql"; // ���ݿ�����
            conn = DriverManager.getConnection(url, username, password); // ��������
            return conn; // ��������
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "���ݿ�����ʧ�ܡ�\n�����Ƿ�װ��SP4������\n�Լ����ݿ��û����������Ƿ���ȷ��"
                            + e.getMessage());
            return null;
        }
    }
}
