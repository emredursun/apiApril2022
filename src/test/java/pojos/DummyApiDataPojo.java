package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyApiDataPojo {

    private String employeeName;
    private Integer employeeSalary;
    private Integer employeeAge;
    private String profileImage;

    public DummyApiDataPojo() {
    }
    public DummyApiDataPojo(String employeeName, Integer employeeSalary, Integer employeeAge, String profileImage) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeAge = employeeAge;
        this.profileImage = profileImage;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public Integer getEmployeeSalary() {
        return employeeSalary;
    }
    public void setEmployeeSalary(Integer employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
    public Integer getEmployeeAge() {
        return employeeAge;
    }
    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }
    public String getProfileImage() {
        return profileImage;
    }
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "Data{" +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeeAge=" + employeeAge +
                ", profileImage='" + profileImage + '\'' +
                '}';
    }
}
