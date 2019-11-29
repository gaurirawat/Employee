package academic.erp.controller;

import academic.erp.VO.EmployeeVO;
import academic.erp.services.EmployeeREST;
import academic.erp.utils.Login;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

@Path("/employee")
public class EmployeeController {
    private EmployeeREST employeeRest= new EmployeeREST();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/check")
    public Response isAccountant(Login login) throws URISyntaxException {
        int res = employeeRest.isAccountDept(login.getEmp_id(), login.getPassword());
        if (res == 1) {
//            valid user
            return Response.ok("1").build();
        } else if (res == -1) {
//            invalid id/password
            return Response.ok("-1").build();
        }
        else{
//          user not from account
            return Response.ok("0").build();
        }
    }

    @POST
    @Path("/view")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewAll(){
        return Response.ok().entity(employeeRest.getEmployees()).build();
    }

    @GET
    @Path("/next")
    @Produces(MediaType.TEXT_PLAIN)
    public Response next() throws URISyntaxException {
        return Response.seeOther(new URI("/employee/view.html")).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findAllEmployees() {
        List<EmployeeVO> employeeVOS = employeeRest.findAll();
        return Response.ok().entity(employeeVOS).build();
    }

//    @POST
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    @Produces("text/plain")
//    @Path("/check")
//    public Response isAccountant(@FormParam("emp_id") String e_id,
//                                 @FormParam("password") String pwd) throws URISyntaxException {
//
////        String e_id = "1";
////        String pwd = "pwd";
//        int res= employeeRest.isAccountDept(e_id, pwd);
//        if(res==-1)
//            return Response.seeOther(new URI("/Employee/login.html?invalid=1")).build();
//        else if (res==0)
//            return Response.seeOther(new URI("/academicerp/studentlist.html?invalid=2")).build();
//        else
//            return Response.seeOther(new URI("/academicerp/view.html")).build();

//    }

}






































