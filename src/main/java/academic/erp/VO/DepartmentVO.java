package academic.erp.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Department")
public class DepartmentVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer d_id;

    @Column
    private Integer capacity;

    @Column
    private String name;

    public List<EmployeeVO> getEmployeeVOS() {
        return employeeVOS;
    }

    public void setEmployeeVOS(List<EmployeeVO> employeeVOS) {
        this.employeeVOS = employeeVOS;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<EmployeeVO> employeeVOS = new ArrayList<>();

    public DepartmentVO(Integer capacity, String name) {
        this.capacity = capacity;
        this.name = name;
    }
    public DepartmentVO(){}

    public Integer getId() {
        return d_id;
    }


    public Integer getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.d_id = id;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

}
