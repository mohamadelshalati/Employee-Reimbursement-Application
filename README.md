## **Project name: Reimbursement App**
### UPDATED VERSION OF THIS PROJECT: https://github.com/mohamadelshalati/springboot-reimbursement-webapp
### Project Description: 
 This web appication allows employees to submit their reimburement requests which could be reviewed, approved, or denied by the finance manager.

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
  * Finance manager has the choice to accept or reject a request. Status column will change accordingly.
  * Responsive and super neat design. 
  * Manager can sort reimbursement requests by status (pending, approved, denied).


### Getting Started
  1. Clone project.
  2. Create MySql database. 
  3. Enter your own MySql username and password inside [hibernate.cfg.xml file](https://github.com/mohamadelshalati/Project-I/blob/main/Project-I/src/main/resources/hibernate.cfg.xml) (lines 10 and 11). Also change the name of the database in line 9 after jdbc:mysql://localhost:3306/[your mysql database name].
  4. You must add an entry to the employee table in the database in order to be able to access the app pages you can enter the following command in the command line: [INSERT INTO employee (emp_email, emp_password, emp_username, emp_firstname, emp_lastname, emp_role) VALUES ('email@email.com', 'password', 'userename', 'firstname', 'lastname', 1);] for emp_role put in value 1 for manager or 0 for employee.
  5. Deploy project and go to http://localhost:8080/ProjectI/ you will be prompted with a login page use the values you entered into the database to login.
  6. Submit an imbursement request and then you will be able to view it inside the My requests tab. When finance manager logs in they will be able to either accept or deny the reimbursement request.
### Contributors:
  * [Mohamad Elshalati](https://github.com/mohamadelshalati/)
  
 # Images
 ![Login_page.png](./App%20Images/Login_page.png)
 ![Form.png](./App%20Images/Form.png)
 ![Reimbursement table.png](./App%20Images/ReimbursementTable.png)
 ![Filtered teble 1.png](./App%20Images/Filtered%20table.png)
 ![Filtered table 2.png](./App%20Images/Filtered%20teble%202.png)


