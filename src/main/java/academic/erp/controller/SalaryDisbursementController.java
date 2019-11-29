package academic.erp.controller;

import academic.erp.services.SalaryDisbursementREST;
import academic.erp.utils.Transaction;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/salarydisbursement")
public class SalaryDisbursementController {
    private SalaryDisbursementREST salaryDisbursementREST = new SalaryDisbursementREST();

    @POST
    @Produces("text/plain")
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/maketransaction")
    public String makeTransaction(Transaction transaction){
        ArrayList<Integer> emp_ids = getIntegerArray(transaction.getEmp_ids());
        salaryDisbursementREST.makeTransaction(emp_ids,Integer.parseInt(transaction.getSalary()));
        return "true";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok().entity(salaryDisbursementREST.findall()).build();
    }

    private ArrayList<Integer> getIntegerArray(ArrayList<String> stringArray) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(String stringValue : stringArray) {
            result.add(Integer.parseInt(stringValue));
        }
        return result;
    }
}