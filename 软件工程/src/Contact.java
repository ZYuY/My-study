public class Contact {
    /**
     * 姓名      same
     * 手机号    phone
     * 性别      sex
     * 地区      arrea
     * 邮件      Email
     *
     */
    private String name;
    private String phone;
    private String sex;
    private String arrea;
    private String Email;
    public Contact(String name, String phone,String sex,String arrea,String Email) {
        this.name = name;
        this.phone = phone;
        this.sex=sex;
        this.arrea=arrea;
        this.Email=Email;
    }
    public Contact() {super();}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public String getsex() {return sex;}
    public void setsex(String sex) {this.sex = sex;}
    public String getArrea() {return    arrea;}
    public void setArrea(String arrea) {this.arrea = arrea;}
    public String getEmail() {return Email;}
    public void setEmail(String Email) {this.Email = Email;}
    @Override
    public String toString(){return "姓名:"+name+"\t电话号码:"+phone+"\n性别"+sex+"\t地区"+arrea+"\t邮件"+Email;}
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contact other = (Contact) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (phone == null) {
            if (other.phone != null)
                return false;
        } else if (!phone.equals(other.phone))
            return false;
        if (sex== null) {
            if (other.sex != null)
                return false;
        } else if (!sex.equals(other.sex))
            return false;
        if (arrea == null) {
            if (other.arrea!= null)
                return false;
        } else if (!arrea.equals(other.arrea))
            return false;
        if (Email == null) {
            if (other.Email != null)
                return false;
        } else if (!Email.equals(other.Email))
            return false;
        return true;
    }

}
