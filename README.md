## **Project name: Project I  | Reimbursement App**

### Project Description: 
  Project I is a webapp that allows employees to submit their reimburement requests which could be reviewed by the finance manager.

### Technologies used:
  * Java v1.8
  * MySQL
  * JS, HTML, CSS
  * Jackson API v2.12.3
  * Fetch API
  * Jakarta Servlet v5.0
  * Tomcat 10.0.10
 
### Features:
  * One login page for both employee and finance manager, which will take each to two different pages.
  * Finance manager will have an extra tab that contains all employees requests. However employees will not be able to access that tab.
  * Finance manager has the choice to accept or reject a req uest. Status colmn will change accordingly.
  * Responsive and super neat design. 

### To-do list:

  * Implementation of response status codes

### Getting Started
  1. Clone project.
  2. Create an MySql database. 
  3. Enter your own MySql username and password inside [hibernate.cfg.xml file](https://github.com/mohamadelshalati/Project-I/blob/main/Project-I/src/main/resources/hibernate.cfg.xml) (lines 10 and 11). Also change the name of the database in line 9 after jdbc:mysql://localhost:3306/[your mysql database name].
  4. You must add an entry to the employee table in the database in order to be able to access the app pages you can enter the following command in the command line: [INSERT INTO employee (emp_email, emp_password, emp_username, emp_firstname, emp_lastname, emp_role) VALUES ('email@email.com', 'password', 'userename', 'firstname', 'lastname', 1);] for emp_role put in value 1 for manager or 0 for employee.
  5. Deploy project and go to http://localhost:8080/ProjectI/ you will be prompted with a login page use the values you entered into the database to login.
  6. Submit an imbursement request and then you will be able to view it inside the My requests tab. When finance manager logs in they will be able to either accept or deny the reimbursement request.
### Contributors:
  * [Mohamad Elshalati](https://github.com/mohamadelshalati/)
