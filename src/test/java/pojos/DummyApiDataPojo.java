package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyApiDataPojo {

    private String employee_name;
    private Integer employee_salary;
    private Integer employee_age;
    private String profile_image;

    public DummyApiDataPojo() {
    }
    public DummyApiDataPojo(String employeeName, Integer employeeSalary, Integer employeeAge, String profileImage) {
        this.employee_name = employeeName;
        this.employee_salary = employeeSalary;
        this.employee_age = employeeAge;
        this.profile_image = profileImage;
    }

    public String getEmployee_name() {
        return employee_name;
    }
    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }
    public Integer getEmployee_salary() {
        return employee_salary;
    }
    public void setEmployee_salary(Integer employee_salary) {
        this.employee_salary = employee_salary;
    }
    public Integer getEmployee_age() {
        return employee_age;
    }
    public void setEmployee_age(Integer employee_age) {
        this.employee_age = employee_age;
    }
    public String getProfile_image() {
        return profile_image;
    }
    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    @Override
    public String toString() {
        return "Data{" +
                ", employeeName='" + employee_name + '\'' +
                ", employeeSalary=" + employee_salary +
                ", employeeAge=" + employee_age +
                ", profileImage='" + profile_image + '\'' +
                '}';
    }
}
