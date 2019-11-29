package academic.erp.utils;

import java.util.ArrayList;

public class Transaction {

    public Transaction(){};
    public ArrayList<String> getEmp_ids() {
        return emp_ids;
    }

    public void setEmp_ids(ArrayList<String> emp_ids) {
        this.emp_ids = emp_ids;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    private ArrayList<String> emp_ids;
    private String salary;

}
