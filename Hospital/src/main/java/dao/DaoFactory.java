package dao;

import dao.implementations.*;
import dao.interfaces.*;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactory {
    public static IDiagnosisDao createDiagnosisDao (Connection connection) throws SQLException {
        return new DiagnosisDaoImpl(connection);
    }
    public static IDrugsDao createDrugsDao (Connection connection) throws SQLException {
        return new DrugsDaoImpl(connection);
    }
    public static IPatiensDao createPatiensDao (Connection connection) throws SQLException {
        return new PatiensDaoImpl(connection);
    }
    public static IProceduresDao createProcedursDao (Connection connection) throws SQLException {
        return new ProceduresDaoImpl(connection);
    }
    public static ISurgeriesDao createSurgeriesDao (Connection connection) throws SQLException {
        return new SurgeriesDaoImpl(connection);
    }
    public static IStaffDao createStaffDao (Connection connection) throws SQLException {
        return new StaffDaoImpl(connection);
    }
    public static IDiagnosisInfoDao createDiagnosisInfoDao (Connection connection) throws SQLException {
        return new DiagnosisInfoDaoImpl(connection);
    }
}
