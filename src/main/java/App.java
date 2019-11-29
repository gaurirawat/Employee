import academic.erp.DAO.EmployeeDAO;
import academic.erp.DAO.SalaryDisbursementDAO;
import academic.erp.VO.EmployeeVO;
import academic.erp.VO.SalaryDisbursementVO;
import academic.erp.utils.DBOperations;
import academic.erp.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.*;

public class App {
    public static void main(String...args){
        (new SessionUtil()).getSessionFactory();
//        DBOperations dbOperations = new DBOperations();
//        dbOperations.openCurrentSession();
//        dbOperations.closeCurrentSession();

        //        DBOperations dbo = new DBOperations();
//        Session session = dbo.openCurrentSessionWithTransaction();
//        Query query = session.createQuery("from EmployeeVO");
//        List<EmployeeVO> emps = query.list();
//        for (EmployeeVO emp:emps){
//            System.out.println("Id: "+emp.getEmp_id());
//        }

        //employee salary show logic
//        EmployeeDAO employeeDAO = new EmployeeDAO();
//        List<EmployeeVO> result = employeeDAO.findAll();
//        int tot = 0;
//        int month = 2; //0-January
//        for(EmployeeVO emp:result){
//            tot=0;
//            for(SalaryDisbursementVO sal : emp.getSalaryDisbursementS()) {
//                if(sal.getDate().getMonth() == month){
//                    tot+=sal.getSalary_paid();
//                }
//            }
//            System.out.println("Id : "+emp.getEmp_id()+" Salary : "+emp.getSalaryMaster().getSalary()+" Remaining : "+ tot);
//        }

//        int a= employeeDAO.isACDept(1, "pwd");
//        if(a==-1)
//            System.out.println("password is incorrect");
//        else if(a==0)
//            System.out.println("not from account department");
//        else
//            System.out.println("from account department");
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        (new SalaryDisbursementDAO()).makeTransaction(list, 2000);
    }
}