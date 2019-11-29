package academic.erp.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SalaryDisbursement")
public class SalaryDisbursementVO {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sd_id;

    @Column
    private Integer salary_paid;

    @Column
    private Date date;

    @ManyToOne
    private EmployeeVO employee = new EmployeeVO();

    public EmployeeVO getEmployeeVO() {
        return employee;
    }

    public void setEmployeeVO(EmployeeVO employeeVO) {
        this.employee = employeeVO;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SalaryDisbursementVO(Integer salary_paid) {
        this.salary_paid = salary_paid;
    }

    public SalaryDisbursementVO(){}

    public Integer getSd_id() {
        return sd_id;
    }

    public void setSd_id(Integer sd_id) {
        this.sd_id = sd_id;
    }

    public Integer getSalary_paid() {
        return salary_paid;
    }

    public void setSalary_paid(Integer salary_paid) {
        this.salary_paid = salary_paid;
    }

    @Override
    public String toString() {
        return "SalaryDisbursement{" +
                "sd_id=" + sd_id +
                ", salary_paid=" + salary_paid +
                '}';
    }
}
