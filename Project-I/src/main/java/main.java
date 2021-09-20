import com.melshalati.model.Employee;
import com.melshalati.model.Reimbursement;
import com.melshalati.model.enums.EmployeeRole;
import com.melshalati.model.enums.ReimbursementStatus;
import com.melshalati.model.enums.ReimbursementType;
import com.melshalati.repository.EmployeeRepoJdbc;
import com.melshalati.repository.EmployeeRepository;
import com.melshalati.repository.ReimbursementsRepoJdbc;
import com.melshalati.service.EmployeeServiceAlpha;
import com.melshalati.service.ReimbursementServiceAlpha;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class main {
    public static void main(String[] args) {

        System.out.println("Proejct started...");
        Employee employee = new Employee();
        employee.setEmail("J@GMAIL.COM");
        employee.setEmpUsername("J");
        employee.setEmpPassword("12345");
        employee.setRole(EmployeeRole.EMPLOYEE);
        employee.setFirstName("J");
        employee.setLastname("THE EMPLOYEE");

//        Reimbursement reimbursement = new Reimbursement();
//        reimbursement.setEmployeeID(employee.getEmpID());
//        reimbursement.setEmployeeName(employee.getFirstName()+" "+ employee.getLastname());
//        reimbursement.setEmployeeID(employee.getEmpID());
//        reimbursement.setStatus(ReimbursementStatus.PENDING);
//        reimbursement.setTicketDesc("FIRST TICKET");
//        reimbursement.setType(ReimbursementType.LODGING);
//        reimbursement.setSubmitTime(new Date());

        System.out.println(employee.getRole());
//
//        Configuration cfg = new Configuration();
//
//        cfg.configure("hibernate.cfg.xml");
//
//        SessionFactory factory = cfg.buildSessionFactory();
//
//        Session session = factory.openSession();
//
//        int id;
//        ConnectionUtil connectionUtil = new ConnectionUtil();
//        Session session = connectionUtil.getSession();
//        Transaction t = session.beginTransaction();
//        session.save(employee);

//        session.save(reimbursement);

//        List<Employee> mylist= ConnectionUtil.getQuery();
//        System.out.println(mylist);

        //EmployeeRepoJdbc er = new EmployeeRepoJdbc();
//        List<Employee> list = EmployeeRepoJdbc.getInstance().selectAll();
//        System.out.println(list);
//
//        er.insert(employee);
        //ReimbursementServiceAlpha.getInstance().insert(reimbursement);
//        EmployeeServiceAlpha.getInstance().insertEmployee(employee);
//
//        List<Reimbursement> list =  ReimbursementServiceAlpha.getInstance().selectAll();
//        System.out.println(list);
//        List <Reimbursement> mylist= ReimbursementServiceAlpha.getInstance().selectAllEmpReimbursements(employee);
//        System.out.println(mylist);
//
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setTicketId(2);
        reimbursement.setEmployeeID(employee.getEmpID());
        reimbursement.setEmployeeName(employee.getFirstName()+" "+ employee.getLastname());
        reimbursement.setEmployeeID(employee.getEmpID());
        reimbursement.setStatus(ReimbursementStatus.PENDING);
        reimbursement.setTicketDesc("TRANSACTION DESC");
        reimbursement.setType(ReimbursementType.LODGING);
        reimbursement.setSubmitTime(new Date());
//        try {
//            ReimbursementsRepoJdbc.getInstance().updateJdbc(reimbursement);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        Configuration cfg = new Configuration();
//
//        cfg.configure("hibernate.cfg.xml");
//
//        SessionFactory factory = cfg.buildSessionFactory();
//
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.update(reimbursement);
//        transaction.commit();
//        session.close();

        EmployeeServiceAlpha.getInstance().insertEmployee(employee);

    }
}

