package dao.implementations;

import dao.interfaces.IDiagnosisDao;
import entities.Diagnosis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiagnosisDaoImpl implements IDiagnosisDao {

    private Connection connection;
    private final String COLUMN_ID = "id";
    private final String COLUMN_NAME = "name";
    private Statement statement;

    public DiagnosisDaoImpl(final Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    private Diagnosis getDiagnosis(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COLUMN_ID);
        String name = resultSet.getString(COLUMN_NAME);
        return new Diagnosis(id, name);
    }

    @Override
    public List<Diagnosis> findAll() {
        String query = "SELECT * FROM diagnosis";
        List<Diagnosis> diagnosisList = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Diagnosis diagnosis = getDiagnosis(resultSet);
                diagnosisList.add(diagnosis);
            }

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return diagnosisList;
    }

    @Override
    public Diagnosis findById(long id) {
        String query = "SELECT * FROM diagnosis WHERE diagnosis.id=" + id;

        Diagnosis diagnosis = new Diagnosis();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            diagnosis = getDiagnosis(resultSet);

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return diagnosis;
    }

    @Override
    public Diagnosis save(Diagnosis diagnosis) {
        String query = "INSERT INTO diagnosis (name) VALUES (";
        query +="'"+diagnosis.getName()+"') " ;
        try {
            statement.execute(query);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }


        return diagnosis;
    }

    @Override
    public Diagnosis update(long id, Diagnosis diagnosis) {
        String query = "UPDATE diagnosis SET name = '"+diagnosis.getName() +"' WHERE id="+id;


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
        String query = "DELETE FROM diagnosis WHERE id="+id;

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return;
    }
}
