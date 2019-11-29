package academic.erp.services;

import academic.erp.DAO.EmployeeDAO;
import academic.erp.VO.EmployeeVO;
//import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

// The Java class will be hosted at the URI path "/helloworld"
//@Path("/Employee")
public class EmployeeREST {
//    private final Gson gson = new Gson();
    private EmployeeDAO employeeDAO = new EmployeeDAO();

//    @GET
//    @Path("/getemployees")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getEmployees(){
//        return Response.ok().entity(employeeDAO.getEmployeesWithSalary()).build();
////        return Response.ok().entity(employeeDAO.findAll()).build();
////        return Response.ok(gson.toJson(employeeDAO.findAll()),MediaType.APPLICATION_JSON).build();
////        return Response.ok(gson.toJson(courseDAO.getCourseVO(Integer.parseInt(id))),MediaType.APPLICATION_JSON).build();
//    }

    public List<Object> getEmployees(){
        return employeeDAO.getEmployeesWithSalary();
    }

    public List<EmployeeVO> findAll(){
        return employeeDAO.findAll();
    }

    public int isAccountDept(String emp_id, String password){
        return employeeDAO.isACDept(emp_id, password);
    }
}
