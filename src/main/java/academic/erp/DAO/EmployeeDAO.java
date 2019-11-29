package academic.erp.DAO;

import academic.erp.VO.EmployeeVO;
import academic.erp.utils.DBOperations;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class EmployeeDAO {
    private final DBOperations dbOperations = new DBOperations();

    public List<EmployeeVO> findAll(){
        dbOperations.openCurrentSessionWithTransaction();
        List<EmployeeVO> employeeVOS = dbOperations.getList(EmployeeVO.class,"from EmployeeVO");
        dbOperations.closeCurrentSessionWithTransaction();
        return employeeVOS;
    }

    public List<Object> getEmployeesWithSalary(){
        dbOperations.openCurrentSessionWithTransaction();
        Query<Object> query = dbOperations.getCurrentSession().createSQLQuery("select emp.e_id,CONCAT(emp.fname,' ',emp.lname) as name ,sm.salary,SUM(sd.salary_paid) as salary_paid,sm.salary-SUM(sd.salary_paid) as remaining from Employee as emp,SalaryMaster as sm, SalaryDisbursement as sd where sd.employee_e_id = emp.e_id and sm.employee_e_id = emp.e_id group by emp.e_id,sm.salary");
        List<Object> resultSet = query.getResultList();
        dbOperations.closeCurrentSessionWithTransaction();
        return resultSet;
    }

    public int isACDept(String empId, String password){
        dbOperations.openCurrentSessionWithTransaction();
        String hql = "FROM EmployeeVO WHERE emp_id = :empId";
        Query query= dbOperations.getCurrentSession().createQuery(hql);
        query.setParameter("empId", empId);
        //EmployeeVO employee= (EmployeeVO) query.getResultList().get(0);
        int returnValue;
        EmployeeVO employee = null;

        try{
            employee = (EmployeeVO) query.getSingleResult();
        }
        catch (NoResultException nre){
            dbOperations.closeCurrentSessionWithTransaction();
            return -1;
        }

        if(password.equals(employee.getPassword())==false) {
            returnValue= -1;
        }
        else if("Account".equals(employee.getDepartment().getName())) {
            returnValue= 1;
        }
        else
            returnValue =0;
        dbOperations.closeCurrentSessionWithTransaction();
        return returnValue;
    }

    public EmployeeVO find(Integer id) {
        dbOperations.openCurrentSessionWithTransaction();
        EmployeeVO employee= dbOperations.getCurrentSession().get(EmployeeVO.class, id);
        dbOperations.closeCurrentSessionWithTransaction();
        return employee;
    }

}
