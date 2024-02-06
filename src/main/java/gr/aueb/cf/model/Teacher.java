package gr.aueb.cf.model;

public class Teacher {
    private int id;
    private String ssn;
    private String firstname;
    private String lastname;
    private int specialityId;
    private int userId;

    public Teacher() {

    }

    public Teacher(int id, String ssn, String firstname, String lastname, int specialityId, int userId) {
        this.id = id;
        this.ssn = ssn;
        this.firstname = firstname;
        this.lastname = lastname;
        this.specialityId = specialityId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
