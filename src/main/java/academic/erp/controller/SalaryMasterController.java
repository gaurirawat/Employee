package academic.erp.controller;

import academic.erp.services.SalaryMasterREST;
import academic.erp.utils.Update;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/updatesalary")
public class SalaryMasterController {

    private SalaryMasterREST salaryMasterREST= new SalaryMasterREST();

    @POST
    @Produces("text/plain")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateSalary(Update update){
        salaryMasterREST.updateSalary(Integer.parseInt(update.getE_id()), Integer.parseInt(update.getSalary()));
        return "true";
    }
}
