package com.zzk.bean;

public class LinkMan {
    /**
     * 表的信息
     * 1.联系人信息
     * 2.备忘录信息
     * 3.备忘录分类信息
     * 4.联系人分类信息
     */
    private int ID = 0;
    private String name = null;
    private String sex = null;
    private String employment = null;
    private String birthday = null;
    private String principalship = null;
    private String telephone = null;
    private String address = null;
    private String postalcode = null;
    private String QQ = null;
    private String email = null;
    private String picturePath = null;
    private int SortID = 0;
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getEmployment() {
        return employment;
    }
    
    public void setEmployment(String employment) {
        this.employment = employment;
    }
    
    public String getBirthday() {
        return birthday;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    public String getPrincipalship() {
        return principalship;
    }
    
    public void setPrincipalship(String principalship) {
        this.principalship = principalship;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPostalcode() {
        return postalcode;
    }
    
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
    
    public String getQQ() {
        return QQ;
    }
    
    public void setQQ(String qQ) {
        QQ = qQ;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPicturePath() {
        return picturePath;
    }
    
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public int getSortID() {
        return SortID;
    }
    
    public void setSortID(int sortID) {
        SortID = sortID;
    }
    
}
