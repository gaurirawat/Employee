package academic.erp.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "SalaryMaster")
public class SalaryMasterVO {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer s_id;

    @Column
    private Integer salary;

    @OneToOne
    private EmployeeVO employee;

    public EmployeeVO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeVO employee) {
        this.employee = employee;
    }

    public SalaryMasterVO(Integer salary) {
        this.salary = salary;
    }

    public SalaryMasterVO(){}

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "SalaryMasterVO{" +
                "s_id=" + s_id +
                ", salary=" + salary +
                '}';
    }
}