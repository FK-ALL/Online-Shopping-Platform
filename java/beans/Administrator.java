package beans;

public class Administrator {
    private int administrator_id;
    private String administrator_RealName;
    private String administrator_Password;
    private String administrator_IDCode;
    private int identity_CardType;
    private String identity_CardNumber;
    private int administrator_Phone;

    public Administrator() {
    };

    public void setAdministrator_Id(int administrator_id) {
        this.administrator_id = administrator_id;
    }

    public void setAdministrator_RealName(String administrator_RealName) {
        this.administrator_RealName = administrator_RealName;
    }

    public void setAdministrator_Password(String administrator_Password) {
        this.administrator_Password = administrator_Password;
    }

    public void setAdministrator_IDCode(String administrator_IDCode) {
        this.administrator_IDCode = administrator_IDCode;
    }

    public void setIdentity_CardType(int identity_CardType) {
        this.identity_CardType = identity_CardType;
    }

    public void setIdentity_CardNumber(String identity_CardNumber) {
        this.identity_CardNumber = identity_CardNumber;
    }

    public void setAdministrator_Phone(int administrator_Phone) {
        this.administrator_Phone = administrator_Phone;
    }

    public int getAdministrator_id() {
        return administrator_id;
    }

    public String getAdministrator_RealName() {
        return administrator_RealName;
    }

    public String getAdministrator_Password() {
        return administrator_Password;
    }

    public String getAdministrator_IDCode() {
        return administrator_IDCode;
    }

    public int getIdentity_CardType() {
        return identity_CardType;
    }

    public String getIdentity_CardNumber() {
        return identity_CardNumber;
    }

    public int getAdministrator_Phone() {
        return administrator_Phone;
    }

    /*
     * public void update(String changeAttribute, String changeValue) { switch
     * (changeAttribute) { case "login_Name": setLogin_Name(changeValue); break;
     * case "login_Password": setlogin_Password(changeValue); break;
     * 
     * case "identity_CardNumber": setIdentity_CardNumber(changeValue); break; case
     * "user_Phone": setUser_Phone(changeValue); break; case "user_RealName":
     * setUser_RealName(changeValue); break; case "user_Sex":
     * setUser_Sex(changeValue); break; case "identity_CardType":
     * setIdentity_CardType(changeValue); break;
     * 
     * }
     * 
     * }
     */

    /*
     * public boolean isComplete() { if (user_RealName == null || identity_CardType
     * == null || identity_CardNumber == null || user_Phone == null) return false;
     * return true; }
     */
}
