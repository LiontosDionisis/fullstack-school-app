package gr.aueb.cf.dto;

public class TeacherUpdateDTO {
    private Integer id;
    private String ssn;
    private String firstname;
    private String lastname;
    private Integer specialityId;

    public TeacherUpdateDTO() {

    }

    public TeacherUpdateDTO(Integer id, String ssn, String firstname, String lastname, Integer specialityId) {
        this.id = id;
        this.ssn = ssn;
        this.firstname = firstname;
        this.lastname = lastname;
        this.specialityId = specialityId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }
}
