package gr.aueb.cf.dto;

public class TeacherInsertDTO {
    private String ssn;
    private String firstname;
    private String lastname;
    private Integer specialityId;

    public TeacherInsertDTO() {}

    public TeacherInsertDTO(String ssn, String firstname, String lastname, Integer specialityId) {
        this.ssn = ssn;
        this.firstname = firstname;
        this.lastname = lastname;
        this.specialityId = specialityId;
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

    public Integer getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }
}
