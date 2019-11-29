package academic.erp.DAO;

import academic.erp.VO.EmployeeVO;
import academic.erp.VO.SalaryDisbursementVO;
import academic.erp.utils.DBOperations;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDisbursementDAO {

    private static DBOperations dbOperations = new DBOperations();

    public void makeTransaction(ArrayList<Integer> employeeList, int salary) {
        dbOperations.openCurrentSessionWithTransaction();
        for (Integer x : employeeList) {
            SalaryDisbursementVO salaryDisbursementVO = new SalaryDisbursementVO(salary);
            salaryDisbursementVO.setDate(new Date());
            salaryDisbursementVO.setEmployeeVO(new EmployeeDAO().find(x));
            (new SalaryDisbursementDAO()).save(salaryDisbursementVO);
        }
        dbOperations.closeCurrentSessionWithTransaction();
    }

    public void save(SalaryDisbursementVO salaryDisbursementVO) {
        dbOperations.openCurrentSessionWithTransaction();
        dbOperations.getCurrentSession().save(salaryDisbursementVO);
        dbOperations.closeCurrentSessionWithTransaction();
    }

    public List<SalaryDisbursementVO> findAll(){
        dbOperations.openCurrentSessionWithTransaction();
        List<SalaryDisbursementVO> salaryDisbursementVOS = dbOperations.getList(SalaryDisbursementVO.class,"from SalaryDisbursementVO");
        dbOperations.closeCurrentSessionWithTransaction();
        return salaryDisbursementVOS;
    }
}
