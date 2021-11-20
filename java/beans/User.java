package beans;

public class User {
    private int user_Id;
    private String login_Name;
    private String login_Password;
    private int user_Status;
    private String user_RealName;
    private String identity_CardType;
    private String identity_CardNumber;
    private String user_Phone;
    private String user_Sex;

    public User(int user_Id, String login_Name) {
        this.user_Id = user_Id;
        this.login_Name = login_Name;
    }

    public void setLogin_Name(String login_Name) {
        this.login_Name = login_Name;
    }

    public String getLogin_Name() {
        return login_Name;
    }

    public void setUser_RealName(String user_RealName) {
        this.user_RealName = user_RealName;
    }

    public String getUser_RealName() {
        return user_RealName;
    }

    public void setIdentity_CardType(String identity_CardType) {
        this.identity_CardType = identity_CardType;
    }

    public String getIdentity_CardType() {
        return identity_CardType;
    }

    public void setIdentity_CardNumber(String identity_CardNumber) {
        this.identity_CardNumber = identity_CardNumber;
    }

    public String getIdentity_CardNumber() {
        return identity_CardNumber;
    }

    public void setUser_Phone(String user_Phone) {
        this.user_Phone = user_Phone;
    }

    public String getUser_Phone() {
        return user_Phone;
    }

    public void setUser_Sex(String user_Sex) {
        this.user_Sex = user_Sex;
    }

    public String getUser_Sex() {
        return user_Sex;
    }

    public void setlogin_Password(String login_Password) {
        this.login_Password = login_Password;
    }

    public String getlogin_Password() {
        return login_Password;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Status(int user_Status) {
        this.user_Status = user_Status;
    }

    public int getUser_Status() {
        return user_Status;
    }

    public void update(String changeAttribute, String changeValue) {
        switch (changeAttribute) {
            case "login_Name":
                setLogin_Name(changeValue);
                break;
            case "login_Password":
                setlogin_Password(changeValue);
                break;

            case "identity_CardNumber":
                setIdentity_CardNumber(changeValue);
                break;
            case "user_Phone":
                setUser_Phone(changeValue);
                break;
            case "user_RealName":
                setUser_RealName(changeValue);
                break;
            case "user_Sex":
                setUser_Sex(changeValue);
                break;
            case "identity_CardType":
                setIdentity_CardType(changeValue);
                break;

        }

    }

    public boolean isComplete() {
        String ur = getUser_RealName();
        String ict = getIdentity_CardType();
        String icn = getIdentity_CardNumber();
        String up = getUser_Phone();
        if (ur == null || ict == null || icn == null || up == null)
            return false;
        return true;
    }
}
