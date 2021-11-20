package beans;

import java.sql.Date;

public class Comment {
    private int comment_Id;
    private String login_Name;
    private String content;
    private Date audit_Time;

    public Comment(int comment_Id) {
        this.comment_Id = comment_Id;
    }

    public int getComment_ID() {
        return comment_Id;
    }

    public void setLogin_Name(String login_Name) {
        this.login_Name = login_Name;
    }

    public String getLogin_Name() {
        return login_Name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setAudit_Time(Date audit_Time) {
        this.audit_Time = audit_Time;
    }

    public Date getAudit_Time() {
        return audit_Time;
    }

}
