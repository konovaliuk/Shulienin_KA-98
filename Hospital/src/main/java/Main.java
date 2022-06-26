import connection.ConnectionPool;
import dao.DaoFactory;
import dao.interfaces.*;
import entities.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class Main {

    public static void main(String arg[]) {
        System.out.println("\n");
        testDiagnosisDao();
        System.out.println("\n");
        testDrugsDao();
        System.out.println("\n");
        testPatiensDao();
        System.out.println("\n");
        testProceduresDao();
        System.out.println("\n");
        testSurgeriesDao();
        System.out.println("\n");
        testStaffDao();
        System.out.println("\n");
        testDiagnosisInfoDao();
    }


    //------------------------------------start of DiagnosisDaoTesting---------------------------------------------------------

    private static void testDiagnosisDao() {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String dbUrl = resource.getString("dbUrl");
        String dbUser = resource.getString("dbUser");
        String dbPassword = resource.getString("dbPassword");
        System.out.println("--------------------------------------DiagnosisDao testing-----------------------------------------------------------");
        Connection conn;
        ConnectionPool pool = new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
        try {
            conn = pool.getConnection();
            IDiagnosisDao diagnosisDao = DaoFactory.createDiagnosisDao(conn);

            System.out.println("Find ALl---");
            printAll(diagnosisDao.findAll());

            System.out.println("Find by id---");
            System.out.println(diagnosisDao.findById(1).toString());

            System.out.println("save---");
            Diagnosis diagnosis = new Diagnosis("malaria1");
            diagnosisDao.save(diagnosis);


            System.out.println("update---");
            diagnosisDao.update(1, diagnosis);

            System.out.println("delete---");
            diagnosisDao.delete(2);
            printAll(diagnosisDao.findAll());

            pool.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//------------------------------------end of DiagnosisDaoTesting---------------------------------------------------------

    //------------------------------------start of DrugsDaoTesting---------------------------------------------------------

    private static void testDrugsDao() {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String dbUrl = resource.getString("dbUrl");
        String dbUser = resource.getString("dbUser");
        String dbPassword = resource.getString("dbPassword");
        System.out.println("--------------------------------------DrugsDao testing-----------------------------------------------------------");
        Connection conn;
        ConnectionPool pool = new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
        try {
            conn = pool.getConnection();
            IDrugsDao drugsDao = DaoFactory.createDrugsDao(conn);

            System.out.println("Find ALl---");
            printAll(drugsDao.findAll());

            System.out.println("Find by id---");
            System.out.println(drugsDao.findById(1).toString());

            System.out.println("save---");
            Drugs drugs = new Drugs("aspirin2");
            drugsDao.save(drugs);


            System.out.println("update---");
            drugsDao.update(1, drugs);

            System.out.println("delete---");
            drugsDao.delete(0);
            printAll(drugsDao.findAll());

            pool.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//------------------------------------end of DrugsDaoTesting---------------------------------------------------------

    //------------------------------------start of PatiensDaoTesting---------------------------------------------------------

    private static void testPatiensDao() {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String dbUrl = resource.getString("dbUrl");
        String dbUser = resource.getString("dbUser");
        String dbPassword = resource.getString("dbPassword");
        System.out.println("--------------------------------------PatiensDao testing-----------------------------------------------------------");
        Connection conn;
        ConnectionPool pool = new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
        try {
            conn = pool.getConnection();
            IPatiensDao patiensDao = DaoFactory.createPatiensDao(conn);

            System.out.println("Find ALl---");
            printAll(patiensDao.findAll());

            System.out.println("Find by id---");
            System.out.println(patiensDao.findById(1).toString());

            System.out.println("save---");
            Patiens patiens = new Patiens("John2");
            patiensDao.save(patiens);


            System.out.println("update---");
            patiensDao.update(1, patiens);

            System.out.println("delete---");
            patiensDao.delete(2);
            printAll(patiensDao.findAll());

            pool.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//------------------------------------end of PatiensDaoTesting---------------------------------------------------------

    //------------------------------------start of ProceduresDaoTesting---------------------------------------------------------

    private static void testProceduresDao() {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String dbUrl = resource.getString("dbUrl");
        String dbUser = resource.getString("dbUser");
        String dbPassword = resource.getString("dbPassword");
        System.out.println("--------------------------------------ProceduresDao testing-----------------------------------------------------------");
        Connection conn;
        ConnectionPool pool = new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
        try {
            conn = pool.getConnection();
            IProceduresDao proceduresDao = DaoFactory.createProcedursDao(conn);

            System.out.println("Find ALl---");
            printAll(proceduresDao.findAll());

            System.out.println("Find by id---");
            System.out.println(proceduresDao.findById(1).toString());

            System.out.println("save---");
            Procedures procedures = new Procedures("Appendectomy1");
            proceduresDao.save(procedures);


            System.out.println("update---");
            proceduresDao.update(1, procedures);

            System.out.println("delete---");
            proceduresDao.delete(2);
            printAll(proceduresDao.findAll());

            pool.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//------------------------------------end of ProceduresDaoTesting---------------------------------------------------------

    //------------------------------------start of SurgeriesDaoTesting---------------------------------------------------------

    private static void testSurgeriesDao() {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String dbUrl = resource.getString("dbUrl");
        String dbUser = resource.getString("dbUser");
        String dbPassword = resource.getString("dbPassword");
        System.out.println("--------------------------------------SurgeriesDao testing-----------------------------------------------------------");
        Connection conn;
        ConnectionPool pool = new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
        try {
            conn = pool.getConnection();
            ISurgeriesDao surgeriesDao = DaoFactory.createSurgeriesDao(conn);

            System.out.println("Find ALl---");
            printAll(surgeriesDao.findAll());

            System.out.println("Find by id---");
            System.out.println(surgeriesDao.findById(1).toString());

            System.out.println("save---");
            Surgeries surgeries = new Surgeries("Cholecystectomy1");
            surgeriesDao.save(surgeries);


            System.out.println("update---");
            surgeriesDao.update(1, surgeries);

            System.out.println("delete---");
            surgeriesDao.delete(2);
            printAll(surgeriesDao.findAll());

            pool.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//------------------------------------end of SurgeriesDaoTesting---------------------------------------------------------

    //------------------------------------start of StaffDaoTesting---------------------------------------------------------

    private static void testStaffDao() {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String dbUrl = resource.getString("dbUrl");
        String dbUser = resource.getString("dbUser");
        String dbPassword = resource.getString("dbPassword");
        System.out.println("--------------------------------------StaffDao testing-----------------------------------------------------------");
        Connection conn;
        ConnectionPool pool = new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
        try {
            conn = pool.getConnection();
            IStaffDao staffDao = DaoFactory.createStaffDao(conn);

            System.out.println("Find ALl---");
            printAll(staffDao.findAll());

            System.out.println("Find by id---");
            System.out.println(staffDao.findById(1).toString());

            System.out.println("save---");
            Staff staff = new Staff("Jaina1","Doctor");
            staffDao.save(staff);


            System.out.println("update---");
            staffDao.update(1, staff);

            System.out.println("delete---");
            staffDao.delete(2);
            printAll(staffDao.findAll());

            pool.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//------------------------------------end of StaffDaoTesting---------------------------------------------------------

    //------------------------------------start of DiagnosisInfoDaoTesting---------------------------------------------------------

    private static void testDiagnosisInfoDao() {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String dbUrl = resource.getString("dbUrl");
        String dbUser = resource.getString("dbUser");
        String dbPassword = resource.getString("dbPassword");
        System.out.println("--------------------------------------DiagnosisInfoDao testing-----------------------------------------------------------");
        Connection conn;
        ConnectionPool pool = new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
        try {
            conn = pool.getConnection();
            IDiagnosisInfoDao diagnosisInfoDao = DaoFactory.createDiagnosisInfoDao(conn);

            System.out.println("Find ALl---");
            printAll(diagnosisInfoDao.findAll());

            System.out.println("Find by id---");
            System.out.println(diagnosisInfoDao.findById(1).toString());

            System.out.println("save---");
            DiagnosisInfo diagnosisInfo = new DiagnosisInfo("Hard",1,1,1,1,1,1);
            diagnosisInfoDao.save(diagnosisInfo);


            System.out.println("update---");
            diagnosisInfoDao.update(1, diagnosisInfo);

            System.out.println("delete---");
            diagnosisInfoDao.delete(2);
            printAll(diagnosisInfoDao.findAll());

            pool.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//------------------------------------end of DiagnosisDaoTesting---------------------------------------------------------

    private static void printAll(List resultList) {
        resultList.forEach((result) -> {
            System.out.println(result.toString());
        });
    }
}
