package academic.erp.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Employee")
public class    EmployeeVO {

    @Id
    @Column
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer e_id;

    @Column(unique = true)
    private String emp_id;

    @NotNull
    private String fname;
    private String lname;
    private String password;
    private String phoneNo;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<SalaryDisbursementVO> getSalaryDisbursementS() {
        return salaryDisbursementS;
    }

    public void setSalaryDisbursementS(List<SalaryDisbursementVO> salaryDisbursementS) {
        this.salaryDisbursementS = salaryDisbursementS;
    }

    @JsonIgnore
    @OneToMany(mappedBy= "employee",fetch = FetchType.EAGER)
    private List<SalaryDisbursementVO> salaryDisbursementS= new ArrayList<>();


    @ManyToOne
    private DepartmentVO department= new DepartmentVO();

    public DepartmentVO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentVO department) {
        this.department = department;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "employee")
    private SalaryMasterVO salaryMaster;

    public SalaryMasterVO getSalaryMaster() {
        return salaryMaster;
    }

    public void setSalaryMaster(SalaryMasterVO salaryMaster) {
        this.salaryMaster = salaryMaster;
    }

    public EmployeeVO(){}

    public EmployeeVO(String emp_id, @NotBlank String fname, String lname, String password) {
        this.emp_id = emp_id;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
    }

    public int getId() {
        return e_id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPassword() {
        return password;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "EmployeeVO{" +
                "e_id=" + e_id +
                ", emp_id='" + emp_id + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", password='" + password + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", salaryDisbursementS=" + salaryDisbursementS +
                ", department=" + department +
                ", salaryMaster=" + salaryMaster +
                '}';
    }
}