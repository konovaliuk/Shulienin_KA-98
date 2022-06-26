package dao.implementations;

import dao.interfaces.IPatiensDao;
import entities.Diagnosis;
import entities.Patiens;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatiensDaoImpl implements IPatiensDao {
    private Connection connection;
    private final String COLUMN_ID = "id";
    private final String COLUMN_NAME = "name";
    private Statement statement;

    public PatiensDaoImpl(final Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    private Patiens getPatiens(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COLUMN_ID);
        String name = resultSet.getString(COLUMN_NAME);
        return new Patiens(id, name);
    }

    @Override
    public List<Patiens> findAll() {
        String query = "SELECT * FROM patiens";
        List<Patiens> patiensList = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Patiens patiens = getPatiens(resultSet);
                patiensList.add(patiens);
            }

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return patiensList;
    }

    @Override
    public Patiens findById(long id) {
        String query = "SELECT * FROM patiens WHERE patiens.id=" + id;

        Patiens patiens = new Patiens();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            patiens = getPatiens(resultSet);

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return patiens;
    }

    @Override
    public Patiens save(Patiens patiens) {
        String query = "INSERT INTO patiens (name) VALUES (";
        query +="'"+patiens.getName()+"') " ;
        try {
            statement.execute(query);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }


        return patiens;
    }

    @Override
    public Patiens update(long id, Patiens patiens) {
        String query = "UPDATE patiens SET name = '"+patiens.getName() +"' WHERE id="+id;


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
        String query = "DELETE FROM patiens WHERE id="+id;

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return;
    }
}
