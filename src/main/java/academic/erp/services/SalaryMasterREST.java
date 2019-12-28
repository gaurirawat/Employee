package academic.erp.services;

import academic.erp.DAO.EmployeeDAO;
import academic.erp.DAO.SalaryMasterDAO;

public class SalaryMasterREST {
    private EmployeeDAO employeeDAO= new EmployeeDAO();
    private SalaryMasterDAO salaryMasterDAO= new SalaryMasterDAO();

    public void updateSalary(Integer e_id, Integer newSal){
         salaryMasterDAO.UpdateSalary(e_id, newSal);
    }

}
