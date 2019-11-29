package academic.erp.services;

import academic.erp.DAO.SalaryDisbursementDAO;
import academic.erp.VO.SalaryDisbursementVO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

// The Java class will be hosted at the URI path "/helloworld"
@Path("/salarysdisbursementrest")
public class SalaryDisbursementREST {

    private SalaryDisbursementDAO salaryDisbursementDAO = new SalaryDisbursementDAO();

    public void makeTransaction(ArrayList<Integer> employeeList, int salary){
        salaryDisbursementDAO.makeTransaction(employeeList, salary);
    }

    public List<SalaryDisbursementVO> findall(){
        return salaryDisbursementDAO.findAll();
    }

}
