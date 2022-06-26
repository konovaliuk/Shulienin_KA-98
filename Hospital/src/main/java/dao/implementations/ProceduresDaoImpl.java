package dao.implementations;

import dao.interfaces.IProceduresDao;
import entities.Diagnosis;
import entities.Procedures;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProceduresDaoImpl implements IProceduresDao {
    private Connection connection;
    private final String COLUMN_ID = "id";
    private final String COLUMN_NAME = "name";
    private Statement statement;

    public ProceduresDaoImpl(final Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    private Procedures getProcedures(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COLUMN_ID);
        String name = resultSet.getString(COLUMN_NAME);
        return new Procedures(id, name);
    }

    @Override
    public List<Procedures> findAll() {
        String query = "SELECT * FROM procedures";
        List<Procedures> proceduresList = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Procedures procedures = getProcedures(resultSet);
                proceduresList.add(procedures);
            }

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return proceduresList;
    }

    @Override
    public Procedures findById(long id) {
        String query = "SELECT * FROM procedures WHERE procedures.id=" + id;

        Procedures procedures = new Procedures();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            procedures = getProcedures(resultSet);

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return procedures;
    }

    @Override
    public Procedures save(Procedures procedures) {
        String query = "INSERT INTO procedures(name) VALUES (";
        query +="'"+procedures.getName()+"') " ;
        try {
            statement.execute(query);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }


        return procedures;
    }

    @Override
    public Procedures update(long id, Procedures procedures) {
        String query = "UPDATE procedures SET name = '"+procedures.getName() +"' WHERE id="+id;


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
        String query = "DELETE FROM procedures WHERE id="+id;

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return;
    }

}
