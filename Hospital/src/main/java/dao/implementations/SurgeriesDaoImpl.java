package dao.implementations;

import dao.interfaces.ISurgeriesDao;
import entities.Diagnosis;
import entities.Surgeries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SurgeriesDaoImpl implements ISurgeriesDao {
    private Connection connection;
    private final String COLUMN_ID = "id";
    private final String COLUMN_NAME = "name";
    private Statement statement;

    public SurgeriesDaoImpl(final Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    private Surgeries getSurgeries(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COLUMN_ID);
        String name = resultSet.getString(COLUMN_NAME);
        return new Surgeries(id, name);
    }

    @Override
    public List<Surgeries> findAll() {
        String query = "SELECT * FROM surgeries";
        List<Surgeries> surgeriesList = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Surgeries surgeries = getSurgeries(resultSet);
                surgeriesList.add(surgeries);
            }

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return surgeriesList;
    }

    @Override
    public Surgeries findById(long id) {
        String query = "SELECT * FROM surgeries WHERE surgeries.id=" + id;

        Surgeries surgeries = new Surgeries();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            surgeries = getSurgeries(resultSet);

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return surgeries;
    }

    @Override
    public Surgeries save(Surgeries surgeries) {
        String query = "INSERT INTO surgeries (name) VALUES (";
        query +="'"+surgeries.getName()+"') " ;
        try {
            statement.execute(query);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }


        return surgeries;
    }

    @Override
    public Surgeries update(long id, Surgeries surgeries) {
        String query = "UPDATE surgeries SET name = '"+surgeries.getName() +"' WHERE id="+id;


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
        String query = "DELETE FROM surgeries WHERE id="+id;

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return;
    }

}
