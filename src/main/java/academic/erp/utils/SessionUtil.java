package academic.erp.utils;

import academic.erp.VO.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
    private static final SessionFactory sessionfactory = (new SessionUtil()).getSessionFactory();

    public SessionFactory getSessionFactory(){
        return new Configuration().addAnnotatedClass(UserVO.class).addAnnotatedClass(EmployeeVO.class).addAnnotatedClass(DepartmentVO.class).addAnnotatedClass(SalaryMasterVO.class).addAnnotatedClass(SalaryDisbursementVO.class).buildSessionFactory();
    }
}