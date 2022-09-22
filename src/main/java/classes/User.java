package classes;

public class User {
    private int id;
    private String userName;
    private Integer nationalCode;
    private String birthDay;
    private String passWord;

    private String password;
    private String username;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    public Integer getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(Integer nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
