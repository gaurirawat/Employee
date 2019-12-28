package academic.erp.DAO;

import academic.erp.VO.SalaryMasterVO;
import academic.erp.utils.DBOperations;
import org.hibernate.query.Query;

public class SalaryMasterDAO {
    private DBOperations dbOperations = new DBOperations();

    public void UpdateSalary(Integer e_Id, int newSal){
        dbOperations.openCurrentSessionWithTransaction();
//        EmployeeVO employeeVO = (new EmployeeDAO()).find(e_Id);
        String hql = "FROM SalaryMasterVO WHERE employee_e_id= :e_Id";
        Query query= dbOperations.getCurrentSession().createQuery(hql);
        query.setParameter("e_Id", e_Id);
        SalaryMasterVO salaryMasterVO= (SalaryMasterVO)query.getSingleResult();
        salaryMasterVO.setSalary(newSal);
        dbOperations.update(salaryMasterVO);
        dbOperations.closeCurrentSessionWithTransaction();
    }
}
