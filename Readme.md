# Employee

## Configuration File
Update configurations in the following files:

* #### Database details:
```
/Employee/src/main/resources/hibernate.properties
```

## Running the Application
* Download the Tomcat Server
* Add its configuration to your project
* Add the exploded war artifact to the deployment
* Set the Application Context

## Initialising the Database
You may initialise the Domain table using the following or similar query:
```
INSERT INTO Department(capacity, name) VALUES
(10, 'Account'),
(10, 'HR');

INSERT INTO Employee(emp_id, fname, lname, password, department_d_id, phoneNo) VALUES
('AC001', 'gauri', 'rawat', 'pwd' , 1, 9999999999),
('AC002', 'vaibhav', 'dodiya', 'abc', 1, 1111111111),
('HR001', 'aishwary', 'panikar', 'cat', 2, 8888888888),
('HR002', 'smit', 'limbani', 'dog', 2, 7777777777);

INSERT INTO SalaryDisbursement(date, salary_paid, employee_e_id) VALUES
('2019-11-29 19:31:23', 1000, 1),
('2019-12-29 19:31:23', 4000, 2),
('2019-11-29 19:31:23', 7000, 3),
('2019-11-29 19:31:23', 2000, 4);

INSERT INTO SalaryMaster(salary, employee_e_id) VALUES
(50000, 1),
(80000, 2),
(20000, 4),
(40000, 3);

```

## Troubleshooting
If the changes made in your project don't reflect in your browser kindly: 
* Clear Browser Cache & Cookies
* Delete the ```/target``` directory
* Run on the IntelliJ Terminal ```$ mvn clean install```
