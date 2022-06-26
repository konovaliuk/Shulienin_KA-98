package dao.implementations;

import dao.interfaces.IDiagnosisInfoDao;
import entities.DiagnosisInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiagnosisInfoDaoImpl implements IDiagnosisInfoDao {
    private Connection connection;
    private final String COLUMN_ID = "id";
    private final String COLUMN_TYPE = "type";
    private final String COLUMN_PATIENT_ID = "patient_id";
    private final String COLUMN_STAFF_ID = "staff_id";
    private final String COLUMN_DIAGNOSIS_ID = "diagnosis_id";
    private final String COLUMN_DRUGS_ID = "drugs_id";
    private final String COLUMN_PROCEDURES_ID = "procedures_id";
    private final String COLUMN_SURGERIES_ID = "surgeries_id";
    private Statement statement;

    public DiagnosisInfoDaoImpl(final Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    private DiagnosisInfo getDiagnosisInfo(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COLUMN_ID);
        String type = resultSet.getString(COLUMN_TYPE);
        int patient_id = resultSet.getInt(COLUMN_PATIENT_ID);
        int staff_id = resultSet.getInt(COLUMN_STAFF_ID);
        int diagnosis_id = resultSet.getInt(COLUMN_DIAGNOSIS_ID);
        int drugs_id = resultSet.getInt(COLUMN_DRUGS_ID);
        int procedures_id = resultSet.getInt(COLUMN_PROCEDURES_ID);
        int surgeries_id = resultSet.getInt(COLUMN_SURGERIES_ID);
        return new DiagnosisInfo(id, type, patient_id, staff_id, diagnosis_id, drugs_id, procedures_id, surgeries_id);
    }

    @Override
    public List<DiagnosisInfo> findAll() {
        String query = "SELECT * FROM diagnosis_info";
        List<DiagnosisInfo> diagnosisInfoList = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                DiagnosisInfo diagnosisInfo = getDiagnosisInfo(resultSet);
                diagnosisInfoList.add(diagnosisInfo);
            }

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return diagnosisInfoList;
    }

    @Override
    public DiagnosisInfo findById(long id) {
        String query = "SELECT * FROM diagnosis_info WHERE diagnosis_info.id=" + id;

        DiagnosisInfo diagnosisInfo = new DiagnosisInfo();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            diagnosisInfo = getDiagnosisInfo(resultSet);

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return diagnosisInfo;
    }

    @Override
    public DiagnosisInfo save(DiagnosisInfo diagnosisInfo) {
        String query = "INSERT INTO diagnosis_info (type, patient_id, staff_id, diagnosis_id, drugs_id, procedures_id, surgeries_id) VALUES (";
        query +="'"+diagnosisInfo.getType()+"','"+diagnosisInfo.getPatientId()+"','"+diagnosisInfo.getStaffId()+"','"+diagnosisInfo.getDiagnosisId()+"','"+diagnosisInfo.getDrugsId()+"','"+diagnosisInfo.getProceduresId()+"','"+diagnosisInfo.getSurgeriesId()+"') ";
        try {
            statement.execute(query);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }


        return diagnosisInfo;
    }

    @Override
    public DiagnosisInfo update(long id, DiagnosisInfo diagnosisInfo) {
        String query = "UPDATE diagnosis_info SET type = '"+diagnosisInfo.getType()+"',patient_id = '"+diagnosisInfo.getPatientId()+"',staff_id = '"+diagnosisInfo.getStaffId()+"', diagnosis_id = '"+diagnosisInfo.getDiagnosisId()+"', drugs_id = '"+diagnosisInfo.getDrugsId()+"', procedures_id = '"+diagnosisInfo.getProceduresId()+"',surgeries_id = '"+diagnosisInfo.getSurgeriesId()+"' WHERE id="+id;


        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(long id) {
        String query = "DELETE FROM diagnosis_info WHERE id="+id;

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return;
    }

}
